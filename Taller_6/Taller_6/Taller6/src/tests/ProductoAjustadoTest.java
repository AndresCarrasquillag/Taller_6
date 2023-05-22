package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Ingrediente;
import modelo.ProductoAjustado;
import modelo.ProductoMenu;

class ProductoAjustadoTest {

	@Test
	void testProductoAjustado() {
		
		ProductoMenu producto = new ProductoMenu("producto", 12000);
		Ingrediente ing = new Ingrediente("ingrediente", 12000);
		
		ProductoAjustado productoAjustado = new ProductoAjustado(producto, ing, "con");
		ProductoAjustado productoAjustado2 = new ProductoAjustado(producto, ing, "sin");
		assertEquals("producto con ingrediente", productoAjustado.getNombre());
		assertEquals(24000, productoAjustado.getPrecio());
		assertEquals("producto sin ingrediente", productoAjustado2.getNombre());
		assertEquals(12000, productoAjustado2.getPrecio());
		
	}

}
