package G3_Proyecto1.servicios;

import G3_Proyecto1.excepciones.ColeccionJuegosException;
import G3_Proyecto1.modelos.Juego;

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
