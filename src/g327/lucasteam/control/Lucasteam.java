package g327.lucasteam.control;

import g327.lucasteam.excepciones.ColeccionJuegosException;
import g327.lucasteam.gui.Menu;
import g327.lucasteam.servicios.LucasteamService;
import g327.lucasteam.servicios.LucasteamServiceImpl;
import g327.lucasteam.utilidades.Datos;
import lombok.extern.log4j.Log4j2;

/**
 * Mediante esta clase se abre el menu, se llama a servicios y utilidades para.
 * para hacer funcionar la aplicacion.
 * 
 * @see <a href="https://github.com/carlos-ruano/G3_Proyecto1"> GitHub
 *      G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */
@Log4j2
public class Lucasteam {

	private LucasteamService services = new LucasteamServiceImpl();

	/**
	 * Mediante esta funcion abrimos la aplicacion Lucasteam y mostramos un menu, mientras la variable.
	 * seguir sea verdadera se seguira mostrando por consola el menu.
	 * 
	 * @param seguir sea verdadero, iteramos la clase menu, volviendo a dar una seleccion de opciones.
	 * @return Devuelve Menu.
	 */
	public void abrirLucasteam() {
		log.info("[Inicio de la sesion]"); // Hacemos loggin .info al iniciar sesion
		boolean seguir = true;
		do {
			Menu.mostrarMenu();
			seguir = this.seleccionOpciones();
		} while (seguir);
		log.info("[Fin de la sesion]"); // Hacemos loggin .info al terminar la sesion
	}
  /**
	 * Mediante esta funcion recogemos por consola lo elegido por el cliente me diante la clase
	 * Datos y el numero del caso en el switch, llamando a los metodos del paquete service.
	 * 
	 * @return True para seguir mandando el menu por consola.
	 */
	public boolean seleccionOpciones() {

		boolean continuar = true;

		try {
			switch (Datos.recogeInt()) {
			case 1:
				// IMPORTAR LISTADO DE JUEGOS
				services.importarListado();
				break;

			case 2:
				// LISTAR TODOS LOS JUEGOS
				services.mostrarListado();
				break;

			case 3:
				// FILTRAR POR GENERO PLATAFORMA (servicio ya te lo da)
				services.filtrarByGenrePlatform();
				break;

			case 4:
				// FILTRAR POR GENERO (servicio va a pedir el genero)
				services.filtrarByGenre();
				break;

			case 5:
				// DAR DE ALTA UN JUEGO
				services.addJuego();
				break;
				
			case 6:
				// DAR DE BAJA UN JUEGO
				services.deleteJuego();
				break;

			case 7:
				// MODIFICAR UN JUEGO
				services.updateJuego();
				break;

			case 8:
				// FILTRAR POR EDITOR NINTENDO
				//services.filtrarByPublisherNintendo();
				break;

			case 9:
				// LISTADO DE EDITORES
				//services.getListaPublisher();
				break;

			case 10:
				// FILTRAR POR JUEGOS DEL SIGLO XX
				services.filtrarBySigloXX();
				break;
				
			case 11:
				// FILTRAR POR ANO PAR
				services.filtrarByAnoPar();
				break;
				
			case 12:
				// EXPORTAR LISTADO ACTUAL
				services.exportarListado();
				break;

			case 0:
				continuar = salir();
				break;

			default:
				throw new ColeccionJuegosException("Seleccion erronea, introduzca una opcion existente");
			}
		} catch (Exception e) {
			log.error(e.toString());
		}
		return continuar;
	}

	/**
	 * Esta funcion cierra el bucle del menu en el caso que se marque con una s.
	 * 
	 * @return el dato introducido por consola si es diferente a '<b>S<b>'
	 * @throws Exception
	 */
	private boolean salir() throws Exception {
		String sino = Datos.recogeString("---¿Esta seguro?(S/N)---");
		return (sino.toUpperCase().charAt(0) != 'S');
	}

}
