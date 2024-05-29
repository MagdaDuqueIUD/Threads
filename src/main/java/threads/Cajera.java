package threads;

public class Cajera {

	private String nombre;

	public Cajera() {
	}

	public Cajera(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void procesarCompra(Cliente cliente, long timeStamp) {

		System.out.println("La cajera: " + this.nombre + 
				" EMPIEZA A REGISTRAR LA COMPRA PARA EL CLIENTE: " + cliente.getNombre() + 
				" EN TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000	+
				" segundos");

                
                for (int i = 0; i < cliente.getProducto().length; i++) {
                        this.esperarXsegundos(cliente.getProducto()[i].getCantidad());
			System.out.println("Registrado el producto: " + cliente.getProducto()[i].getNombre() + "  " +(i + 1) + 
					" ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + 
					" segundos");
		}

		System.out.println("La cajera: " + this.nombre + " TERMINÓ DE REGISTRAR LOS PRODUCTOS DEL CLIENTE: " + 
							cliente.getNombre() + " EN UN TIEMPO DE: " + 
							(System.currentTimeMillis() - timeStamp) / 1000 + " segundos");

	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}