package exceptiones;

public class ProductoRepetidoException extends HamburguesaException {
	
	public static void cargarMenuEx (Exception e) {
		
		System.err.println(e.getMessage());
}
}
