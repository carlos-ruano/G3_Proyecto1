package G3_Proyecto1.datos;

import java.util.HashSet;
import java.util.Set;

import G3_Proyecto1.modelos.Juego;


public class ColeccionJuegosImpl implements ColeccionJuegos {
	
	private Set <Juego> listado = new HashSet <Juego> ();
	
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
	public String toString() {
		return "ColeccionJuegosImpl [listado=" + listado + "]";
	}
	

	@Override
	public void addJuego(Juego juego) {
		
		listado.add(juego);
		
	}


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
		
		return null;
	} 
	
	

}
