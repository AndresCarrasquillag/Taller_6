package exceptiones;

import modelo.Pedido;
import modelo.Producto;

public class agregarProductoException extends HamburguesaException{
	
public static void agregarProductoEx (Producto e) {
		
		try {
			Pedido.agregarProducto(e);
			System.out.println("Producto agregado correctamente");
		} catch(Exception e1) {
			System.err.println("No se puede agregar el producto. El pedido no puede exceder 150000");
		}
}
}
