package G3_Proyecto1.servicios;

import G3_Proyecto1.excepciones.ColeccionJuegosException;
import G3_Proyecto1.modelos.Juego;

public interface LucasteamService {
	
	public void setListado();
	public void listarJuegos();
	public void filtrarByGenrePlatform();
	public boolean addJuego() throws ColeccionJuegosException;
	public boolean addJuego(Juego J) throws ColeccionJuegosException;
}
