package g327.lucasteam.servicios;

import g327.lucasteam.excepciones.ColeccionJuegosException;
import g327.lucasteam.modelos.Juego;

public interface LucasteamService {
	
	public void importarListado();
	public void mostrarListado();
	public void filtrarByGenrePlatform();
	public void filtrarByGenre();
	public boolean addJuego() throws ColeccionJuegosException;
	public boolean addJuego(Juego J) throws ColeccionJuegosException;
	//public void filtrarByPlatform();
	//public Juego getByRank(int rank);
}
