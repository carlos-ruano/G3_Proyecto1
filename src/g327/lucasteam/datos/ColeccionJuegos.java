package g327.lucasteam.datos;

/**
 * Interface de la capa Datos.
 * @see  <a href="https://github.com/carlos-ruano/G3_Proyecto1">
 *      GitHub G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */

import g327.lucasteam.modelos.Juego;

public interface ColeccionJuegos {

	public void importarListado(String fichero);

	public void mostrarListado();

	public void filtrarByGenre(String genre);
	
	public boolean addJuego(Juego juego);
  
	public boolean updateJuego(int rank);
  
	public boolean buscarJuegoByName(String name);
  
	public boolean deleteJuego(int rank);
	// public void deleteJuego(Juego juego);
	// public Juego getByRank(int rank);
	// public void filtrarByPlatform(String platform) ;

}
