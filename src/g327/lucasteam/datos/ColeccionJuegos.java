package g327.lucasteam.datos;

import g327.lucasteam.modelos.Juego;

public interface ColeccionJuegos {

	public void importarListado(String fichero);

	public void mostrarListado();

	public void filtrarByGenre(String genre);

	public boolean addJuego(Juego juego);
	// public void deleteJuego(Juego juego);
	// public Juego getByRank(int rank);
	// public void filtrarByPlatform(String platform) ;

}
