package g327.lucasteam.servicios;

import java.lang.annotation.Retention;

/**
 * Mediante esta clase se conseguirá leer los '<b>.CSV</b>' del proyecto y
 * sobreescribir cualquier otro '<b>.CSV</b>'.
 * 
 * @see <a href="https://github.com/carlos-ruano/G3_Proyecto1"> GitHub
 *      G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */
import g327.lucasteam.datos.ColeccionJuegos;
import g327.lucasteam.datos.ColeccionJuegosImpl;
import g327.lucasteam.excepciones.ColeccionJuegosException;
import g327.lucasteam.modelos.EnumGenre;
import g327.lucasteam.modelos.Juego;
import g327.lucasteam.utilidades.Datos;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LucasteamServiceImpl implements LucasteamService {

	private ColeccionJuegos coleccionJuegos = new ColeccionJuegosImpl();
	private EnumGenre genre;

	/**
	 * Mediante esta función añaden los datos recogidos en operarCSV y se añaden a
	 * la . coleccion de juegos
	 */
	@Override
	public void importarListado() {
		// Hacemos casting porque el metodo no esta en la interface de datos.
		String nombreArchivo = "vgsales.csv";
		((ColeccionJuegosImpl) coleccionJuegos).importarListado(nombreArchivo);
	}

	/**
	 * Mediante esta función se imprime por consola la coleccion de juegos
	 */
	@Override
	public void mostrarListado() {
		coleccionJuegos.mostrarListado();
	}

	/**
	 * Mediante esta función se imprime por consola la coleccion de juegos donde
	 * contengan el enumerado de Genero Plataform
	 */
	@Override
	public void filtrarByGenrePlatform() {
		coleccionJuegos.filtrarByGenre("Platform");
	}

	/**
	 * Mediante esta función se imprime por consola los enumerados de Genero y se
	 * recoge para luego imprimir la coleccion de juegos que solo contengan ese
	 * enumerado
	 * 
	 * @exception Recoge los errores de impresion
	 */
	@Override
	public void filtrarByGenre() {
		System.out.println("Seleccione el número de género a buscar:");
		EnumGenre.Informe2();
		try {
			this.genre = EnumGenre.dimeCategoria(Datos.recogeInt());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		coleccionJuegos.filtrarByGenre(genre.name());
	}

	/**
	 * Mediante esta función se sobreescribe el metodo addJuego para crear el objeto
	 * juego
	 * 
	 * @throws Exception
	 * @return addJuego(juego) El juego que pasaron por teclado para añadirlo a la
	 *         coleccion
	 */
	@Override
	public boolean addJuego() throws ColeccionJuegosException {

		Juego juego = new Juego();
		juego.createJuego();
		return this.addJuego(juego);
	}

	/**
	 * Mediante esta función se sobreescribe el metodo addJuego para añadirlo a la
	 * coleccion juego
	 * 
	 * @param juego Se pasa el valor de juego a añadir a la coleccion
	 * @throws Exception
	 * @return addJuego(juego) El juego que pasaron por teclado para añadirlo a la
	 *         coleccion
	 */
	@Override
	public boolean addJuego(Juego juego) throws ColeccionJuegosException {
		// return coleccionJuegos.addJuego(juego,(int)coleccionJuegos.getLastRank());
		return coleccionJuegos.addJuego(juego);
	}
	/*
	 * @Override public Juego getByRank(int rank) { return
	 * coleccionJuegos.getByRank(rank);
	 * 
	 * }
	 * 
	 * @Override public void filtrarByPlatform(String platform) {
	 * coleccionJuegos.filtrarByPlatform(platform); }
	 */
}
