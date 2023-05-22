package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.ProductoMenu;

class ProductoMenuTest {

	@Test
	void testProductoMenu() {
		
		ProductoMenu producto = new ProductoMenu("producto", 12000);
		
		assertEquals("producto", producto.getNombre());
		assertEquals(12000, producto.getPrecio());
		
	}

}
