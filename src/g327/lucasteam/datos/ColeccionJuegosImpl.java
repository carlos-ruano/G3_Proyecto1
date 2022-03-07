package g327.lucasteam.datos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import g327.lucasteam.excepciones.ColeccionJuegosException;
import g327.lucasteam.modelos.Juego;
import g327.lucasteam.utilidades.Datos;
import g327.lucasteam.utilidades.OperarCSV;
import lombok.extern.log4j.Log4j2;

/**
 * Mediante esta clase manejaremos y almacenaremos los datos que nos llegan por
 * consola o el csv.
 * 
 * @see <a href="https://github.com/carlos-ruano/G3_Proyecto1"> GitHub
 *      G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */
@Log4j2
public class ColeccionJuegosImpl implements ColeccionJuegos {

	private Set<Juego> listado = new HashSet<Juego>();
	private ArrayList<Juego> testListado = new ArrayList<Juego>();

	public ColeccionJuegosImpl() {
		super();
	}

	/**
	 * Mediante este metodo generamos una coleccion de los datos recogidos en
	 * listado.
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
	 * Mediante esta funcion se consigue leer un archivo '<b>.CSV</b>' mediante la
	 * adicion de los parametros a los atributos de los objetos "Juego" instanciados
	 * hasta terminar todas las lineas e introduciendolos en un listado de tipo
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
	 * Mediante este metodo iteramos la coleccion listado para sacar por consola los
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
				throw new ColeccionJuegosException("Listado vacio, no se ha podido mostrar ningun juego");
			}
		} catch (ColeccionJuegosException e) {
			log.warn(e.toString());
		}
	}

	/**
	 * Mediante este metodo iteramos la coleccion listado para sacar por consola los
	 * objetos. juegos con el genre dado
	 * 
	 * @param genre Se pasa el nombre del genero deseado por parametro.
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
				throw new ColeccionJuegosException("Listado vacio, no se ha podido importar ningun juego");
			}
		} catch (ColeccionJuegosException e) {
			log.warn(e.getMessage()); // Si el Set esta� vacio
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
	 * Metodo para editar el juego que quieras.
	 * 
	 * @param rank   Se el id del juego que esta en la coleccion Juegos.
	 * @param nombre Se pasa el nombre del juego a buscar
	 * @return Devolvemos listado con el juego actualizado.
	 */
	public boolean updateJuego(int rank) {
		boolean estado = false;
		
		try {
			switch (Datos.recogeInt()) {
			case 1: {

				yield type;
			}
			case 2: {

				yield type;
			}
			case 3: {

				yield type;
			}
			case 4: {

				yield type;
			}
			case 5: {

				yield type;
			}
			case 6: {

				yield type;
			}
			default:
				throw new ColeccionJuegosException("Seleccion erronea, introduzca una opcion existente");
			}
		} catch (Exception e) {
			log.error(e.toString());
		}

		return estado;
	}

	/**
	 * Mediante este metodo estatico se devuelve un <i>System.out.println</i> con la
	 * cadena de texto deseada.
	 * 
	 * @param msg Se le introduce un mensaje personalizado para pedir la entrada del
	 *            teclado.
	 * @return Una coleccion de juegos de tipo '<b>Set</b>'
	 */
	@Override
	public String toString() {
		return "ColeccionJuegosImpl [listado=" + listado + "]";
	}
	@Override
	public void buscarJuegoByName(String name) {
		try {
			if(listado.isEmpty())
				throw new ColeccionJuegosException("Listado vacio, no se ha podido importar ningun juego");
			else {
				for(Juego j : listado) {
					if(j.getName().contains(name)) {
						System.out.println(j);
					}
				}
			}
		} catch (ColeccionJuegosException e) {
			log.warn(e.getMessage());
		}
		
	}
	@Override
	public boolean deleteJuego(int rank) {
		boolean estado = false;
		try {
			for(Juego j : listado) {
				if(j.getRank()==rank)
					estado= listado.remove(j);
				else {
					throw new ColeccionJuegosException("La lista no contiene ningun juego con este numero de rank");
				}
			}
		} catch (ColeccionJuegosException e) {
			log.warn(e.getMessage());
		}
		return estado;
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
	 * System.out.println("Este juego no existe o la lista esta vacia.");
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
