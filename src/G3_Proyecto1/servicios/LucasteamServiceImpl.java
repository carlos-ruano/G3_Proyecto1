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
	public Juego getByRank(int rank) {
		return coleccionJuegos.getByRank(rank);
		
	}

	@Override
	public void filtrarByPlatform(String platform) {
		coleccionJuegos.filtrarByPlatform(platform);
	}
	
	@Override 
	public void filtrarByGenre(String genre) {
		coleccionJuegos.filtrarByGenre(genre);
	}

	@Override
	public boolean addJuego() throws ColeccionJuegosException {

		Juego juego = new Juego();
		juego.createJuego();
		return this.addJuego(juego);
	}

	@Override
	public boolean addJuego(Juego juego) throws ColeccionJuegosException {
		//return coleccionJuegos.addJuego(juego,(int)coleccionJuegos.getLastRank());
		return coleccionJuegos.addJuego(juego);
	}

}
