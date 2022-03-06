package G3_Proyecto1.datos;

import java.util.HashSet;
import java.util.Set;

import G3_Proyecto1.excepciones.ColeccionJuegosException;
import G3_Proyecto1.modelos.Juego;
import G3_Proyecto1.utilidades.OperarCSV;


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
