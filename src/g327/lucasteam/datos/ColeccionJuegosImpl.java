package g327.lucasteam.datos;

/**
 * Mediante esta clase manejaremos y almacenaremos los datos que nos llegan por consola o el csv.
 * @see  <a href="https://github.com/carlos-ruano/G3_Proyecto1">
 *      GitHub G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */

import java.util.HashSet;
import java.util.Set;

import g327.lucasteam.excepciones.ColeccionJuegosException;
import g327.lucasteam.modelos.Juego;
import g327.lucasteam.utilidades.OperarCSV;

public class ColeccionJuegosImpl implements ColeccionJuegos {

	private Set<Juego> listado = new HashSet<Juego>();

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

	/**
	 * Mediante este método recogemos toda la informacion de la colecion de juegos
	 * en listado
	 * 
	 * @return La coleccion de juegos tipo '<b>Set<b>'
	 */
	public Set<Juego> getListado() {
		return listado;
	}

	/**
	 * Mediante este método modificamos la lista del juegos de la coleccion de
	 * juegos
	 * 
	 * @param listado Se pasa por parámetro la lista cargada para modificarla
	 */
	public void setListado(Set<Juego> listado) {
		this.listado = listado;
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
		if (!listado.isEmpty()) {
			for (Juego j : listado) {
				System.out.println(j);
			}
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
		if (!listado.isEmpty()) {
			for (Juego j : listado) {
				if (j.getGenre().name().compareToIgnoreCase(genre) == 0) {
					System.out.println(j.imprimir());
				}
			}
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
