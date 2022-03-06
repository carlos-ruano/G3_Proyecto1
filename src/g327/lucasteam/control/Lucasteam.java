package g327.lucasteam.control;

import g327.lucasteam.gui.Menu;
import g327.lucasteam.servicios.LucasteamService;
import g327.lucasteam.servicios.LucasteamServiceImpl;
import g327.lucasteam.utilidades.Datos;

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

public class Lucasteam {

	private LucasteamService services = new LucasteamServiceImpl();

	/**
	 * Mediante esta función abrimos la aplicacion Lucasteam y mostramos un menu, mientras la variable.
	 * seguir sea verdadera se seguira mostrando por consola el menu.
	 * 
	 * @param seguir sea verdadero, iteramos la clase menu, volviendo a dar una seleccion de opciones.
	 * @return Devuelve Menu.
	 */
	public void abrirLucasteam() {
		boolean seguir = true;
		do {
			Menu.mostrarMenu();
			seguir = this.seleccionOpciones();
		} while (seguir);
		System.out.println("   --- Fin de la sesion ---");
	}

	/**
	 * Mediante esta funciónrecogemos por consola lo elegido por el cliente me diante la clase
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

			case 0:
				continuar = salir();
				break;
			}
		} catch (Exception e) {
			System.out.println("error: " + e.toString());
		}
		return continuar;
	}

	/**
	 * Mediante esta función se consigue leer un archivo '<b>.CSV</b>' mediante la
	 * adición de los parámetros a los atributos de los objetos "Juego" instanciados
	 * hasta terminar todas las líneas e introduciéndolos en un listado de tipo
	 * '<b>Set</b>'.
	 * 
	 * @return el dato introducido por consola si es diferente a '<b>S<b>'
	 * @throws Exception
	 */
	private boolean salir() throws Exception {
		String sino = Datos.recogeString("   ¿Está seguro?(S/N)");
		return (sino.toUpperCase().charAt(0) != 'S');
	}

}
