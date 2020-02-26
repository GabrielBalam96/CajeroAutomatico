package cajero;


import java.util.List;
import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Registro{
	
	private ObjectContainer db = null;
	
	
	private void abrirRegistro() {
		db = Db4oEmbedded.openFile("registroPersona");
	}
	
	private void cerrarRegistro() {
		db.close();
	}
	
	void insertarRegistro(Persona p) {
		abrirRegistro();
		db.store(p);
		cerrarRegistro();
	}
	
	public List<Persona> seleccionarPersona(){
		abrirRegistro();
		ObjectSet<Object> listaPersonas = db.queryByExample(Persona.class);
		List<Persona> lp = new ArrayList<>();
		
		for (Object listaPersonas1 : listaPersonas) {
			lp.add((Persona) listaPersonas1);
		}
		cerrarRegistro();
		return lp;
	}
	
	public Persona seleccionarPersona(Persona p) {
		abrirRegistro();
		ObjectSet<Object> resultado = db.queryByExample(p);
		Persona persona = (Persona) resultado.next();
		cerrarRegistro();
			
			return persona;
	}
	
	
	public void actualizarRegistro(int id,String nom,String apeP,String apeM, int edad) {
		abrirRegistro();
		Persona p = new Persona();
		p.setId(id);
		ObjectSet resultado = db.queryByExample(p);
		Persona preResultado = (Persona) resultado.next();
		preResultado.setNombre(nom);
		preResultado.setApellidoP(apeP);
		preResultado.setApellidoM(apeM);
		preResultado.setEdad(edad);
		db.store(preResultado);
		cerrarRegistro();
		
	}
	public void eliminarRegistro(int id) {
		abrirRegistro();
		Persona p = new Persona();
		p.setId(id);
		ObjectSet resultado = db.queryByExample(p);
		Persona preResultado = (Persona) resultado.next();
		db.delete(preResultado);
		cerrarRegistro();
			
			
	}
}