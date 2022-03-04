package G3_Proyecto1.servicios;

import G3_Proyecto1.datos.ColeccionJuegos;
import G3_Proyecto1.datos.ColeccionJuegosImpl;
import G3_Proyecto1.excepciones.ColeccionJuegosException;
import G3_Proyecto1.modelos.Juego;

public class LucasteamServiceImpl implements LucasteamService {
	
	private ColeccionJuegos coleccionJuegos = new ColeccionJuegosImpl();

	@Override
	public void setListado() {
		coleccionJuegos.setListado("vgsales.csv");
	}

	@Override
	public void listarJuegos() {
		coleccionJuegos.listarJuegos();
	}

	@Override
	public void filtrarByGenrePlatform() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addJuego() throws ColeccionJuegosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addJuego(Juego J) throws ColeccionJuegosException {
		// TODO Auto-generated method stub
		return false;
	}

}
