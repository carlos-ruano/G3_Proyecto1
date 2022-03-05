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
	
	public void setListado(String nombreFichero) {
		// Llamamos a util.OperarCSV y nos devuelve el listado completo del CSV
		this.listado = OperarCSV.readCSV(nombreFichero);
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
			
			System.out.println("Este juego no existe o la lista esta vac�a."); 
			
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
	
	public void filtrarByPlatform(String platform) {
		if(!listado.isEmpty()) {
			for(Juego j : listado)
			{
				if(j.getPlatform().name() == platform)
				{
					System.out.println("Juego: "+j.getName()+", Genero: "+j.getGenre().name()
									+", a�o de publicaci�n: "+j.getYear()+", editor: "+j.getPublisher()
									+", su ranking es: "+j.getRank());
				}
			}
		}
	}
	
	public void filtrarByGenre(String genre) {
		if(!listado.isEmpty()) {
			for(Juego j : listado)
			{
				if(j.getGenre().name() == genre)
				{
					System.out.println("Juego: "+j.getName()+", Genero: "+j.getGenre().name()
									+", a�o de publicaci�n: "+j.getYear()+", editor: "+j.getPublisher()
									+", su ranking es: "+j.getRank());
				}
			}
		}
	}
		
		
	
	
	

}
