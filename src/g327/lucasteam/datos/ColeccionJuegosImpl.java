package g327.lucasteam.datos;

import java.util.HashSet;
import java.util.Set;

import g327.lucasteam.excepciones.ColeccionJuegosException;
import g327.lucasteam.modelos.Juego;
import g327.lucasteam.utilidades.OperarCSV;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ColeccionJuegosImpl implements ColeccionJuegos {

	private Set<Juego> listado = new HashSet<Juego>();

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
		try {
			if (!listado.isEmpty()) {
				for (Juego j : listado) {
					System.out.println(j);
				}
			} else {
				throw new ColeccionJuegosException("Listado vacío, no se ha podido mostrar ningún juego", 2);
			}
		} catch (ColeccionJuegosException e) {
			log.warn(e.toString());
		}
	}

	@Override
	public void filtrarByGenre(String genre) {
		try {
			if (!listado.isEmpty()) {
				for (Juego j : listado) {
					if (j.getGenre().name().compareToIgnoreCase(genre) == 0) {
						System.out.println(j.imprimir());
					}
				}
			} else {
				throw new ColeccionJuegosException("Listado vacío, no se ha podido importar ningún juego", 2);
			}
		} catch (ColeccionJuegosException e) {
			log.warn(e.getMessage()); // Si el Set está vacío
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
	 * @Override public void deleteJuego(Juego juego) {
	 * 
	 * // Mejorable con un try catch.
	 * 
	 * if (!listado.isEmpty()) {
	 * 
	 * listado.remove(juego);
	 * 
	 * } else {
	 * 
	 * System.out.println("Este juego no existe o la lista esta vacía.");
	 * 
	 * } }
	 * 
	 * 
	 * 
	 * @Override public Juego getByRank(int rank) { if(!listado.isEmpty()) {
	 * for(Juego j : listado) { if(j.getRank()==rank) return j; } } return null; }
	 * 
	 * @Override public void filtrarByPlatform(String platform) {
	 * if(!listado.isEmpty()) { for(Juego j : listado) {
	 * if(j.getPlatform().name().compareToIgnoreCase(platform)==0) {
	 * System.out.println("Juego: "+j.getName()+", Genero: "+j.getGenre().name()
	 * +", año de publicación: "+j.getYear()+", editor: "+j.getPublisher()
	 * +", su ranking es: "+j.getRank()); } } } }
	 * 
	 */

}
