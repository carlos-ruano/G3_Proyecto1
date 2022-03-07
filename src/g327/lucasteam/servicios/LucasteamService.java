package g327.lucasteam.servicios;

/**
 * Interface de Service.
 * 
 * @see <a href="https://github.com/carlos-ruano/G3_Proyecto1"> GitHub
 *      G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */
import g327.lucasteam.excepciones.ColeccionJuegosException;
import g327.lucasteam.modelos.Juego;

public interface LucasteamService {

	public void importarListado();

	public void mostrarListado();

	public void filtrarByGenrePlatform();

	public void filtrarByGenre();

	public boolean addJuego() throws ColeccionJuegosException;

	public boolean addJuego(Juego J) throws ColeccionJuegosException;
	
	public void filtrarByPublisher();
	
	public void filtrarByPublisherNintendo();

}
