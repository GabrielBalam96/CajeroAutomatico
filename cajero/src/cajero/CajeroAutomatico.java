package cajero;
import java.util.Scanner;

import javax.swing.JOptionPane;

public abstract class CajeroAutomatico  {
	
	//atributos 
	
	protected int transacciones, retiro, deposito; 
	private static int saldo; 

	
	
	Scanner entrada = new Scanner(System.in);
	
	
	// metodo de operaciones del cajero
	
	public void Operaciones() {
		
		int i = 0;
		int opciones = 0;
		
	
		
			do {
				do { 
					opciones = Integer.parseInt(JOptionPane.showInputDialog("Por favor seleccione una opci�n: \n"
					+" 1.Consultar Saldo \n"
					+" 2.Retirar Fondos \n"
					+" 3.Depositar En Efectivo \n"
					+" 4.Salir \n" ));
					
					
				/*	System.out.println("Por favor seleccione una opci�n: ");
					System.out.println(" 1.Consultar Saldo");
					System.out.println(" 2.Retirar Fondos ");
					System.out.println(" 3.Depositar En Efectivo");
					System.out.println(" 4.Validacion De Targeta");
					System.out.println(" 5.Salir");
					
					opciones = entrada.nextInt(); 
					*/
					
					if (opciones >=1 && opciones <=4) {
						
						i=1;
					}else {
						JOptionPane.showMessageDialog(null, "La opci�n que eligio "+opciones+" no existe, por favor vuelva intentarlo de nuevo");
						
						/*System.out.println("---------------------------------------------------------------------------------");
						System.out.println("La opci�n que eligio "+opciones+" no existe, por favor vuelva intentarlo de nuevo");
						System.out.println("---------------------------------------------------------------------------------");
						*/
					}
					
					
				}while(i == 0);
				
				if(opciones == 1) { //consultar saldo
					
					CajeroAutomatico cajero = new Consulta();
					cajero.Transacciones();
					
				}else if(opciones == 2) { //retiro
					
					CajeroAutomatico cajero = new Retiro(); 
					cajero.Transacciones();
					
				}else if(opciones == 3) {//depositar
					
					CajeroAutomatico cajero = new Deposito();
					cajero.Transacciones();
					
				}else if(opciones == 4) {
					
					/*System.out.println("------------------------------");
					System.out.println("�Gracias!, vuelva muy pronto. ");
					System.out.println("------------------------------");
					*/
					
					JOptionPane.showMessageDialog(null, "�Gracias!, vuelva muy pronto. ");
					
					i = 2; // termina el proceso
				}
			}while(i != 2); 
		
	}
	
	
	//metodo para retirar dinero
	
	public void Retiro() {
		
		retiro = entrada.nextInt();
	}
	
	//metodo para solicitar deposito
	
	public void Deposito() {
		
		deposito = entrada.nextInt();
		
	}
	
	//metodo abstracto transacciones
	
	public abstract void Transacciones();
	
	//metodos setter and getter
	
	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	

}
