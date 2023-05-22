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
		assertEquals("producto con ingrediente", productoAjustado.getNombre());
		assertEquals(24000, productoAjustado.getPrecio());
		
	}

}
