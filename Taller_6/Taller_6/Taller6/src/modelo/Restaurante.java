package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exceptiones.IngredienteRepetidoException;
import exceptiones.ProductoRepetidoException;
import storage.Storage;

public class Restaurante {
	public Restaurante() throws Exception {
		
		String archivoIngredientes ="data/ingredientes.txt";
		String archivoCombos ="data/combos.txt";
		String archivoMenu ="data/menu.txt";
		cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
	}
	
	public static void iniciarPedido(String nombre, String direccionCliente) {
		Pedido.updateId();
		Pedido.updateNumeroPedidos();
		List<Producto> produs = new ArrayList<>();
		Pedido nuevoPedido = new Pedido(nombre, direccionCliente, produs);
	}
	
	public void cerrarYGuardarPedido() {
	}
	
	
	public List<Ingrediente> getIngredientes(){
		List<Ingrediente> ingredientes = Storage.getIngredientes();
		return ingredientes;
	}
	public void cargarInformacionRestaurante(String archivoIngredientes, String archivoMenu, String archivoCombos) throws Exception {
		Storage informacion = new Storage();
		List<Producto> pedido = new ArrayList<>();
		Storage.setPedido(pedido);
		List<Producto> prods = new ArrayList<>();
		Storage.setProductos(prods);
		List<Ingrediente> ingre = cargarIngredientes(archivoIngredientes);
		Storage.setIngredientes(ingre);
		List<ProductoMenu> prodMenu = cargarMenu(archivoMenu);
		Storage.setProductosMenu(prodMenu);
		List<Combo> combos = cargarCombos(archivoCombos);
		Storage.setCombos(combos);
	}
	private List<Ingrediente> cargarIngredientes(String archivoIngredientes) throws Exception {
		List<Ingrediente> ingredientes= new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String linea = br.readLine();
		while (linea!=null) {
			String[] partes = linea.split(";");
			String nombreIng = partes[0];
			int precio = Integer.parseInt(partes[1]);
			Ingrediente elIngrediente= new Ingrediente(nombreIng, precio);
			linea=br.readLine();
			ingredientes.add(elIngrediente);
		}
		br.close();
		try {
            for (int i = 0; i < ingredientes.size(); i++) {
                for (int j = i+1; j < ingredientes.size(); j++) {
                    if (ingredientes.get(i).getNombre().equals(ingredientes.get(j).getNombre())) {
                        throw new Exception ("Se encontraron dos ingredientes iguales en las líneas " + (i+1) + " y " + (j+1));
                    }
                }
            }
        } catch (Exception e) {
        	IngredienteRepetidoException.cargarIngredientesEx(e);
        }
		return ingredientes;
		
	}
	
	private List<ProductoMenu> cargarMenu(String archivoMenu) throws IOException {
		List<ProductoMenu> prodMenu= new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		String linea = br.readLine();
		while (linea!=null) {
			String[] partes = linea.split(";");
			String nombreProd = partes[0];
			int precio = Integer.parseInt(partes[1]);
			ProductoMenu elProducto= new ProductoMenu(nombreProd, precio);
			linea=br.readLine();
			prodMenu.add(elProducto);
			Storage.productos.add(elProducto);
		}
		br.close();
		try {
            for (int i = 0; i < prodMenu.size(); i++) {
                for (int j = i+1; j < prodMenu.size(); j++) {
                    if (prodMenu.get(i).getNombre().equals(prodMenu.get(j).getNombre())) {
                        throw new Exception ("Se encontraron dos productos iguales en las líneas " + (i+1) + " y " + (j+1));
                    }
                }
            }
        } catch (Exception e) {
        	ProductoRepetidoException.cargarMenuEx(e);
        }
		return prodMenu;
		
	}
	private List<Combo> cargarCombos(String archivoCombos) throws IOException {
		List<Combo> combos= new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
		String linea = br.readLine();
		ProductoMenu item1=null;
		ProductoMenu item2=null;
		ProductoMenu item3=null;
		while (linea!=null) {
			String[] partes = linea.split(";");
			String nombreCombo = partes[0];
			double descuento = Double.parseDouble(partes[1].replace("%",""));
			descuento = descuento/100;
			List<ProductoMenu> produs = Storage.getProductosMenu();
			for (ProductoMenu prod:produs) {
				String nombre = prod.getNombre();
				if (nombre.equals(partes[2]))
					item1=prod;
				else if (nombre.equals(partes[3])) 
				{
					item2=prod;
				}
				else if (nombre.equals(partes[4])) 
				{
					item3=prod;
				}
			}
			Combo elCombo= new Combo(nombreCombo, descuento, item1, item2, item3);
			linea=br.readLine();
			combos.add(elCombo);
			Storage.productos.add(elCombo);
		}
		br.close();
		return combos;
		
	}
	
}
