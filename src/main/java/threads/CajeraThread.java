package threads;

public class CajeraThread extends Thread {

	private String nombre;

	private Cliente cliente;

	private long initialTime;


	public CajeraThread() {
	}

	public CajeraThread(String nombre, Cliente cliente, long initialTime) {
		this.nombre = nombre;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public void run() {

		System.out.println("La cajera: " + this.nombre + " EMPIEZA A REGISTRAR LA COMPRA PARA EL CLIENTE: " 
					+ this.cliente.getNombre() + " EN TIEMPO: " 
					+ (System.currentTimeMillis() - this.initialTime) / 1000 
					+ " segundos");

		for (int i = 0; i < this.cliente.getProducto().length; i++) {
			// Se procesa el pedido en X segundos
			this.esperarXsegundos(cliente.getProducto()[i].getCantidad());
			System.out.println("Registrado el producto: "+ cliente.getProducto()[i].getNombre() + "  "  + (i + 1) 
						+ " del cliente: " + this.cliente.getNombre() + "->Tiempo: " 
						+ (System.currentTimeMillis() - this.initialTime) / 1000 
						+ " segundos");
		}

		System.out.println("La cajera: " + this.nombre + " TERMINÓ DE REGISTRAR LOS PRODUCTOS DEL CLIENTE: " 
						+ this.cliente.getNombre() + " EN UN TIEMPO DE: " 
						+ (System.currentTimeMillis() - this.initialTime) / 1000 
						+ " segundos");
	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}