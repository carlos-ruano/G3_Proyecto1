package g327.lucasteam.servicios;

import java.util.ArrayList;

import org.assertj.core.internal.bytebuddy.asm.Advice.This;

import g327.lucasteam.datos.ColeccionJuegos;
import g327.lucasteam.datos.ColeccionJuegosImpl;
import g327.lucasteam.excepciones.ColeccionJuegosException;
import g327.lucasteam.modelos.EnumGenre;
import g327.lucasteam.modelos.EnumPlatform;
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
	private String publisher;

	/**
	 * Mediante esta funcion añaden los datos recogidos en operarCSV y se añaden a
	 * la  coleccion de juegos
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
		boolean estado = false;
		Juego juego = new Juego();
		juego.createJuego();
		
		//verificamos si los enumerados existen y si el a�o de publicacion es valido
		try {
				int year = Integer.parseInt(juego.getYear());
				if(year < 1958) 
				{
					throw new ColeccionJuegosException("Error en el a�o de publicaci�n del juego");
				}
				else {
					estado = this.addJuego(juego);
				}
			}
			catch (ColeccionJuegosException e) 
			{
				log.warn(e.getMessage());
			}
		return estado;
	}
		
		
	

	/**
	 * Mediante el uso de esta función se llama a a la capa datos para
	 * que genere la lista de editores si repetir por medio de un Set y
	 * se devuelve para imprimirlas por pantalla, contabilizando el total
	 * de editores únicos en el archivo .CSV
	 * 
	 * @throws Exception
	 */
	public void getListaPublisher() {
		int i = 0;
		
		try {
			for (String publisher : coleccionJuegos.getListaPublisher()) {
					System.out.println(publisher);
					i++;
			}
			log.info("Hay un total de "+i+" editores listados");
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
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

	/**
	 * Mediante esta funcion se recoge el String introducido por el usuario, para luego
	 * imprimir la coleccion de juegos que solo contengan ese publisher.
	 * 
	 * @exception Recoge los errores de impresion.
	 */

	@Override
	public void filtrarByPublisher() {

		System.out.println("Introduce el nombre del editor:");
				
		try {
			this.publisher = Datos.recogeString();
		} catch (Exception e) {

			log.error(e.getMessage());

		}

		coleccionJuegos.filtrarByPublisher(publisher);

	}

	/**
	 * Mediante esta funcion se imprime por consola la coleccion de juegos donde
	 * contengan el publisher Nintendo.
	 */

	@Override
	public void filtrarByPublisherNintendo() {

		coleccionJuegos.filtrarByPublisher("Nintendo");

	}

	@Override
	public boolean updateJuego(int rank) {
		return coleccionJuegos.updateJuego(rank);
  }
	
	/**
	 * Mediante este metodo se sobreescribe el metodo buscarJuegoByName de la capa Datos
	 * para buscar un juego, con su nombre, en la lista de juegos y imprimirlo 
	 */
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
	/**
	 * Mediante este metodo se sobreescribe el metodo deleteJuego de la capa Datos
	 * para borrar un juego de la lista
	 */
	@Override
	public boolean deleteJuego() {
		boolean estado = false;
		try {
			
			String name=Datos.recogeString("Que Juego quiere buscar para borrar?");
			coleccionJuegos.buscarJuegoByName(name);
			
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
	
	/**
	 * Mediante este metodo se sobreescribe el metodo filtrarByA�oPar de la capa Datos
	 * para filtrar los juegos publicados en los a�os pares o impares y imprimirlos
	 * desde la lista  
	 */
	@Override
	public void filtrarByAnoPar() {
		String mensaje="Si quiere filtrar por a�os pares entre 1\n"
					+"Si quiere filtrar por a�os impares entre 2\n";
		try {
			int num = Datos.recogeInt(mensaje);
			if(num == 1 ) coleccionJuegos.filtrarByAnoPar(true);
			else if(num == 2) coleccionJuegos.filtrarByAnoPar(false);
			else if (num != 1 && num!=2){
				throw new ColeccionJuegosException("Error en el numero elegido ");
			}
		} catch (ColeccionJuegosException e) {
			log.warn(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
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
