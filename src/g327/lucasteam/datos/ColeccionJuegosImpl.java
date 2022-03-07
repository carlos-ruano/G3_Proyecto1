		package g327.lucasteam.datos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import g327.lucasteam.excepciones.ColeccionJuegosException;
import g327.lucasteam.modelos.Juego;
import g327.lucasteam.utilidades.OperarCSV;
import lombok.extern.log4j.Log4j2;

/**
 * Mediante esta clase manejaremos y almacenaremos los datos que nos llegan por consola o el csv.
 * @see  <a href="https://github.com/carlos-ruano/G3_Proyecto1">
 *      GitHub G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */
@Log4j2
public class ColeccionJuegosImpl implements ColeccionJuegos {
	
	
	private Set <Juego> listado = new HashSet <Juego> ();
	private ArrayList<Juego> testListado = new ArrayList<Juego>();

	public ColeccionJuegosImpl() {
		super();
	}

	/**
	 * Mediante este método generamos una coleccion de los datos recogidos en listado.
	 * 
	 * @param listado Se pasa por parametro la lista
	 */
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
  
  public ArrayList<Juego> getTestListado() {
		return testListado;
	}

	public void setTestListado(ArrayList<Juego> testListado) {
		this.testListado = testListado;
	}

	/**
	 * Mediante esta función se consigue leer un archivo '<b>.CSV</b>' mediante la
	 * adición de los parámetros a los atributos de los objetos "Juego" instanciados
	 * hasta terminar todas las líneas e introduciéndolos en un listado de tipo
	 * '<b>Set</b>'.
	 * 
	 * @param nombreFichero Se pasa el nombre del fichero deseado por parámetro..
	 */
	@Override
	public void importarListado(String nombreFichero) {
		// Llamamos a util.OperarCSV y nos devuelve el listado completo del CSV
		this.listado = OperarCSV.readCSV(nombreFichero);
	}

	/**
	 * Mediante este método iteramos la coleccion listado para sacar por consola los
	 * objetos. juegos
	 * 
	 */
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
  /**
	 * Mediante este método iteramos la coleccion listado para sacar por consola los
	 * objetos. juegos con el genre dado
	 * 
	 * @param genre Se pasa el nombre del genero deseado por parámetro.
	 */
	@Override
	public void filtrarByGenre(String genre) {

		try {
			if (!listado.isEmpty()) {
				for (Juego j : listado) {
					if (j.getGenre().name().compareToIgnoreCase(genre) == 0) {
            testListado.add(j);
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

	/**
	 * Metodo para introducir un objeto Juego en el HashSet.
	 * 
	 * @param juegos Se pasa el juego que introduciremos en la coleccion del
	 *               HashSet.
	 * @return Devolvemos listado con
	 */
	@Override
	public boolean addJuego(Juego juego) {
		return listado.add(juego);
	}

	/**
	 * Mediante este método estático se devuelve un <i>System.out.println</i> con la
	 * cadena de texto deseada.
	 * 
	 * @param msg Se le introduce un mensaje personalizado para pedir la entrada del
	 *            teclado.
	 * @return Una colección de juegos de tipo '<b>Set</b>'
	 */
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
