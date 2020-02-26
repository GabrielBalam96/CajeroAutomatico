package cajero;



public class Administracion {

	public static void main(String[] args) {
		
		
		
		CajeroAutomatico cajero = new Consulta();
		
		cajero.setSaldo(500);
		cajero.Operaciones();

		
		
		Registro r = new Registro();
		Persona p = new Persona();
		
	    p.setId(3);
		p.setNombre("jose");
		p.setApellidoP("chuc");
		p.setApellidoM("balam");
		p.setEdad(23);
	
		
		r.insertarRegistro(p);
		System.out.println(p);
		
		int id = 0;
		String nom = "";
		String apeP = " ";
		String apeM = " ";
		int edad = 0;
		
		r.actualizarRegistro(id, nom, apeP, apeM, edad);
		
		p.setId(3);
		p = r.seleccionarPersona(p);
		System.out.println(p);

		
		
		
		
	}

}
