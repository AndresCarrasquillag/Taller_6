package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Combo;
import modelo.ProductoMenu;

class ComboTest {

	@Test
	void test() {
		ProductoMenu producto1 = new ProductoMenu("prod1", 1200);
		ProductoMenu producto2 = new ProductoMenu("prod2", 1300);
		ProductoMenu producto3 = new ProductoMenu("prod3", 1400);
		Combo combo = new Combo("combo", 0.1, producto1, producto2, producto3);
		assertEquals("combo", combo.getNombre());
		assertEquals((0.9*1200)+(0.9*1300)+(0.9*1400), combo.getPrecio());
		
	}

}
