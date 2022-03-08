package g327.lucasteam.datos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import g327.lucasteam.excepciones.ColeccionJuegosException;
import g327.lucasteam.gui.Menu;
import g327.lucasteam.modelos.EnumGenre;
import g327.lucasteam.modelos.EnumPlatform;
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
	 * @param nombreFichero Se pasa el nombre del fichero deseado por parÃ¡metro..
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
				log.info("El archivo ha sido mostrado importado correctamente");
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
				log.info("Se ha filtrado por genero "+genre+".");
			} else {
				throw new ColeccionJuegosException("Listado vacio, no se ha podido importar ningun juego");
			}
		} catch (ColeccionJuegosException e) {
			log.warn(e.getMessage()); // Si el Set esta vacio
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

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Metodo para listar todos los editores sin duplicidad
	 * 
	 * @return Un HashSet de tipo 'String' de todos los editores que existen
	 */
	@Override
	public Set<String> getListaPublisher() {

		Set<String> listaSet = new HashSet<String>();

		try {
			if (!listado.isEmpty()) {
				for (Juego j : listado) {
					listaSet.add(j.getPublisher());
				}
				log.info("Se ha obtenido la lista de editoras");
			} else {
				throw new ColeccionJuegosException("Listado vacio, no se ha podido obtener el Publisher pedido");
			}
		} catch (ColeccionJuegosException e) {
			log.warn(e.getMessage()); // Si el Set esta vacio
		}
		return listaSet;
	}

	/**
	 * Mediante este metodo iteramos la coleccion listado para sacar por consola los
	 * objetos. juegos con el editor dado
	 * 
	 * @param publisher Se pasa el nombre del editor deseado por parametro.
	 */
	@Override
	public void filtrarByPublisher(String publisher) {
		try {
			if (!listado.isEmpty()) {
				for (Juego j : listado) {
					if (j.getPublisher().compareToIgnoreCase(publisher) == 0) {
						testListado.add(j);
						System.out.println(j.imprimir());
					}
				}
				log.info("Se ha filtrado por editora "+publisher+".");
			} else {
				throw new ColeccionJuegosException("Listado vacio, no se ha podido importar ningun juego");
			}
		} catch (ColeccionJuegosException e) {

			log.warn(e.getMessage());

		}
	}

	/**
	 * Metodo para editar el juego que quieras.
	 * 
	 * @param rank Se el id del juego que esta en la coleccion Juegos.
	 * @throws Exception
	 * @return Devolvemos listado con el juego actualizado.
	 */
	
	public boolean updateJuego(int rank) {
		boolean estado = false;
		try {
			if (!listado.isEmpty()) {
				for (Juego j : listado) {
					if (j.getRank() == rank) {
						boolean seguir = true;
						do {
							Menu.mostrarMenuEdit();
							String z = Datos.recogeString();
							if (isNumeric(z)) {
								rank = Integer.parseInt(z);
								switch (rank) {
								case 1: {
									j.setRank(Datos.recogeInt(
											j.getRank() + " Este es el rank actual,¿a cual quieres cambiar?"));
									break;
								}
								case 2: {
									j.setName(Datos.recogeString(
											j.getName() + " Este es el nombre actual,¿a cual quieres cambiar?"));
									break;
								}
								case 3: {
									EnumPlatform.Informe2();
									j.setPlatform(EnumPlatform.dimeCategoria(Datos.recogeInt(j.getPlatform()
											+ " Esta es la Plataforma actual,¿a cual quieres cambiar?")));
									break;
								}
								case 4: {
									j.setYear(String.valueOf(Datos.recogeInt(
											j.getYear() + " Este es el Año actual,¿a cual quieres cambiar?")));
									break;
								}
								case 5: {
									EnumGenre.Informe2();
									j.setGenre(EnumGenre.dimeCategoria(Datos.recogeInt(
											j.getGenre() + " Este es el Genero actual,¿a cual quieres cambiar?")));
									break;
								}
								case 6: {
									j.setPublisher(Datos.recogeString(
											j.getPublisher() + " Esta es la Editora,¿a cual quieres cambiar?"));
									break;
								}
								case 0: {
									seguir = false;
									break;
								}
								default:
									throw new ColeccionJuegosException(
											"Seleccion erronea, introduzca una opcion existente");
								}
							} else {
								throw new ColeccionJuegosException("¡Tienes que introducir un numero!");
							}
						} while (seguir);
						log.info("Se ha modificado el juego:");
						log.info("j.imprimir");
					} else {
						throw new ColeccionJuegosException("No existe un Juego para ese rank, introduzca uno valido");
					}
				}
			} else {
				throw new ColeccionJuegosException("Listado vacio, no se ha podido importar ningun juego");
			}

		} catch (Exception e) {
			log.error(e.toString());
		}
		*/
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
	public boolean buscarJuegoByName(String name) {
		boolean estado = false;
		try {
			if (listado.isEmpty())
				throw new ColeccionJuegosException("Listado vacio, no se ha podido importar ningun juego");
			else {
				for (Juego j : listado) {
					if (j.getName().toLowerCase().contains(name.toLowerCase())) {
						System.out.println(j);
					}
				}
				log.info("Se ha filtrado por nombre "+name+".");
			}
		} catch (ColeccionJuegosException e) {
			log.warn(e.getMessage());
		}
		return estado;
	}

	@Override
	public boolean deleteJuego(int rank) {
		boolean estado = false;
		try {
			Juego j1 = null;
			System.out.println(listado.size());
			for (Juego j : listado) {
				if (j.getRank() == rank)
					j1 = j;
			}
			estado = listado.remove(j1);
			if (estado == false)
				throw new ColeccionJuegosException("El numero de rank que ústed ha elegido no existe");
			log.info("Se ha borrado el juego con rango "+rank+".");
		} catch (Exception e) {
			log.warn(e.getMessage());
		}
		return estado;
	}

	@Override
	public void filtrarByAnoPar(boolean par) {
		ArrayList<Integer> years = new ArrayList<Integer>();
		int i = 0;
		if (par == true)
			i = 1958;
		else
			i = 1959;
		for (int y = i; y <= 2000; y = y + 2) {
			years.add(y);
		}
		for (Juego j : listado) {
			try {
				if (j.getYear().compareToIgnoreCase("N/A") != 0) {
					int year = Integer.parseInt(j.getYear());
					if (years.contains(year)) {
						System.out.println(j);
					}
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				e.getMessage();
			}

		}

	}

	/**
	 * Mediante este metodo estatico se devuelve un <i>System.out.println</i> con la
	 * los juegos del siglo XX y los mete en un nuevo array listado
	 * 
	 * @param anoMax numero de año que se quiere buscar de máximo
	 * @param anoMin numero de año que se quiere buscar de minimo
	 */
	@Override
	public void filtrarByAno(int anoMax, int anoMin) {
		try {
			if (!listado.isEmpty()) {
				if (!testListado.isEmpty()) {
					testListado.clear();
				}
				int year = 0;
				for (Juego j : listado) {
					if (j.getYear().compareToIgnoreCase("N/A") != 0) {
						year = Integer.parseInt(j.getYear());
						if (year >= anoMin && year <= anoMax) {
							testListado.add(j);
							System.out.println(j.imprimir());
						}
					}
				}
				log.info("Se ha filtrado por año entre "+anoMax+" y "+ anoMin+".");
			} else {
				throw new ColeccionJuegosException("Listado vacio, no se ha podido importar ningun juego");
			}
		} catch (ColeccionJuegosException e) {
			log.warn(e.getMessage());
		}

	}
	
	/**
	 * Metodo para recoger los datos del HashSet y usando un nombre de fichero pedido <br>por el usuario, se guarda un .csv
	 * 
	 * @param nombreFichero Se le pasa un nombre para el .CSV
	 * @param listado Se recoge el listado importado por el usuario o los juegos ya añadidos...
	 */
	@Override
	public void exportarListado(String nombreFichero) {
		OperarCSV.writeCSV(nombreFichero, listado);
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
	 * +", aÃ±o de publicaciÃ³n: "+j.getYear()+", editor: "+j.getPublisher()
	 * +", su ranking es: "+j.getRank()); } } } }
	 * 
	 */

}
