package g327.lucasteam.servicios;

import java.lang.annotation.Retention;

/**
 * Mediante esta clase se conseguirÃ¡ leer los '<b>.CSV</b>' del proyecto y
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

/**
 * Mediante esta clase se administra lo pedido por control, se lo envia a datos
 * o lo hace service.
 * 
 * @see <a href="https://github.com/carlos-ruano/G3_Proyecto1"> GitHub
 *      G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */
@Log4j2
public class LucasteamServiceImpl implements LucasteamService {

	private ColeccionJuegos coleccionJuegos = new ColeccionJuegosImpl();
	private EnumGenre genre;

	/**
	 * Mediante esta funcion añaden los datos recogidos en operarCSV y se añaden a
	 * la . coleccion de juegos
	 */
	@Override
	public void importarListado() {
		// Hacemos casting porque el metodo no esta en la interface de datos.
		String nombreArchivo = "vgsales.csv";
		((ColeccionJuegosImpl) coleccionJuegos).importarListado(nombreArchivo);
	}

	/**
	 * Mediante esta funcion se imprime por consola la coleccion de juegos
	 */
	@Override
	public void mostrarListado() {
		coleccionJuegos.mostrarListado();
	}

	/**
	 * Mediante esta funcion se imprime por consola la coleccion de juegos donde
	 * contengan el enumerado de Genero Plataform
	 */
	@Override
	public void filtrarByGenrePlatform() {
		coleccionJuegos.filtrarByGenre("Platform");
	}

	/**
	 * Mediante esta funcion se imprime por consola los enumerados de Genero y se
	 * recoge para luego imprimir la coleccion de juegos que solo contengan ese
	 * enumerado
	 * 
	 * @exception Recoge los errores de impresion
	 */
	@Override
	public void filtrarByGenre() {
		System.out.println("Seleccione el numero de genero a buscar:");
		EnumGenre.Informe2();
		try {
			this.genre = EnumGenre.dimeCategoria(Datos.recogeInt());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		coleccionJuegos.filtrarByGenre(genre.name());
	}

	/**
	 * Mediante esta funcion se sobreescribe el metodo addJuego para crear el objeto
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
	 * Mediante esta funcion se sobreescribe el metodo addJuego para añadirlo a la
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
	@Override
	public void buscarJuegoByName() {
		try {
			String name = Datos.recogeString("¿Cual es el nombre del juego que desea buscar?");
			if(name=="" || name==null) {
				throw new ColeccionJuegosException("Error en el nombre entrado!");
			}else {
				coleccionJuegos.buscarJuegoByName(name);
			}
		} catch (ColeccionJuegosException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean deleteJuego() {
		boolean estado = false;
		try {
			int rank = Datos.recogeInt("¿Cual es el numero de rank del juego que desea borrar?");
			if(rank<0 || rank>16598)
				throw new ColeccionJuegosException("El numero de rank que ústed ha elegido no existe");
			else {
				estado = coleccionJuegos.deleteJuego(rank);
			}
		} catch (ColeccionJuegosException e) {
			log.warn(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
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
