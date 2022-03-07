		package g327.lucasteam.datos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import g327.lucasteam.excepciones.ColeccionJuegosException;
import g327.lucasteam.modelos.Juego;
import g327.lucasteam.utilidades.OperarCSV;


public class ColeccionJuegosImpl implements ColeccionJuegos {
	
	
	private Set <Juego> listado = new HashSet <Juego> ();
	private ArrayList<Juego> testListado = new ArrayList<Juego>();
	
	public ArrayList<Juego> getTestListado() {
		return testListado;
	}

	public void setTestListado(ArrayList<Juego> testListado) {
		this.testListado = testListado;
	}

	public ColeccionJuegosImpl() {
		super();
	}

	public ColeccionJuegosImpl(Set<Juego> listado) {
		super();
		this.listado = listado;
	}

	public Set<Juego> getListado() {
		return listado;
	}
	public void setListado(Set<Juego> listado) {
		this.listado = listado;
	}
	
	@Override
	public void importarListado(String nombreFichero) {
		// Llamamos a util.OperarCSV y nos devuelve el listado completo del CSV
		this.listado = OperarCSV.readCSV(nombreFichero);
	}
	
	@Override
	public void mostrarListado() {
		if(!listado.isEmpty()) {
			for(Juego j : listado){
					System.out.println(j);
			}
		}
		
	}
	
	@Override
	public void filtrarByGenre(String genre) {
		if(!listado.isEmpty()) 
		{
			for(Juego j : listado)
			{
				if(j.getGenre().name().compareToIgnoreCase(genre)==0){
					testListado.add(j);
					System.out.println(j.imprimir());
				}
			}
		}
	}
	
	@Override
	public boolean addJuego(Juego juego) {
		return listado.add(juego);
	}
	
	@Override
	public String toString() {
		return "ColeccionJuegosImpl [listado=" + listado + "]";
	}

	/*
	@Override
	public void deleteJuego(Juego juego) {
		
		// Mejorable con un try catch.
		
		if (!listado.isEmpty()) {
			
			listado.remove(juego);
			
		} else {
			
			System.out.println("Este juego no existe o la lista esta vacía."); 
			
		}	
	}
	
	

	@Override
	public Juego getByRank(int rank) {
		if(!listado.isEmpty()) {
			for(Juego j : listado) {
				if(j.getRank()==rank) return j;
			}
		}
		return null;
	} 
	@Override
	public void filtrarByPlatform(String platform) {
		if(!listado.isEmpty()) {
			for(Juego j : listado)
			{
				if(j.getPlatform().name().compareToIgnoreCase(platform)==0)
				{
					System.out.println("Juego: "+j.getName()+", Genero: "+j.getGenre().name()
									+", año de publicación: "+j.getYear()+", editor: "+j.getPublisher()
									+", su ranking es: "+j.getRank());
				}
			}
		}
	}
	
	*/
	

	
		
	
	
	

}
