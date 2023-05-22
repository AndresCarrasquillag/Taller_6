package exceptiones;

public class IngredienteRepetidoException extends HamburguesaException {

	
	public static void cargarIngredientesEx (Exception e) {
		
			System.err.println(e.getMessage());
	}
}
