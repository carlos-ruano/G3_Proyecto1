package g327.lucasteam.control;

import g327.lucasteam.excepciones.ColeccionJuegosException;
import g327.lucasteam.gui.Menu;
import g327.lucasteam.servicios.LucasteamService;
import g327.lucasteam.servicios.LucasteamServiceImpl;
import g327.lucasteam.utilidades.Datos;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Lucasteam {

	private LucasteamService services = new LucasteamServiceImpl();

	public void abrirLucasteam() {
		log.info("[Inicio de la sesión]"); // Hacemos loggin .info al iniciar sesión
		boolean seguir = true;
		do {
			Menu.mostrarMenu();
			seguir = this.seleccionOpciones();
		} while (seguir);
		log.info("[Fin de la sesion]"); // Hacemos loggin .info al terminar la sesión
	}

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

			default:
				throw new ColeccionJuegosException("Selección errónea, introduzca una opción existente", 2);
			}
		} catch (Exception e) {
			log.error(e.toString());
		}
		return continuar;
	}

	private boolean salir() throws Exception {
		String sino = Datos.recogeString("   ¿Está seguro?(S/N)");
		return (sino.toUpperCase().charAt(0) != 'S');
	}

}
