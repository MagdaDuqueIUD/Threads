package threads;

import models.Producto;

public class MainRunnable implements Runnable{
	
	private Cliente cliente;
	private Cajera cajera;
	private long initialTime;
	
	public MainRunnable (Cliente cliente, Cajera cajera, long initialTime){
		this.cajera = cajera;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	public static void main(String[] args) {
		
                Producto item1 = new Producto("Jamón",10000,2);
                Producto item2 = new Producto("Leche",3000,6);
                Producto item3 = new Producto("Queso",9000,1);                
                Producto[] compra1 = new Producto[] {item1,item2,item3};                
                Cliente cliente1 = new Cliente("Cristian Cliente 1", compra1 );
                
                Producto item4 = new Producto("Galletas",1000,7);
                Producto item5 = new Producto("Cocoa",3000,1);
                Producto item6 = new Producto("Leche",3000,6);                
                Producto[] compra2 = new Producto[] {item4,item5,item6};                
                Cliente cliente2 = new Cliente("Indira Cliente 2", compra2 );
		
		Cajera cajera1 = new Cajera("Elizabeth Caja 1");
		Cajera cajera2 = new Cajera("Magdalena Caja 2");
		
		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		
		Runnable proceso1 = new MainRunnable(cliente1, cajera1, initialTime);
		Runnable proceso2 = new MainRunnable(cliente2, cajera2, initialTime);
		
		new Thread(proceso1).start();
		new Thread(proceso2).start();

	}

	@Override
	public void run() {
		this.cajera.procesarCompra(this.cliente, this.initialTime);
	}

}
