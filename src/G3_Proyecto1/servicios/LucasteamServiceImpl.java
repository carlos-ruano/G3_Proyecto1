package G3_Proyecto1.servicios;

import G3_Proyecto1.datos.ColeccionJuegos;
import G3_Proyecto1.datos.ColeccionJuegosImpl;
import G3_Proyecto1.excepciones.ColeccionJuegosException;
import G3_Proyecto1.modelos.EnumGenre;
import G3_Proyecto1.modelos.Juego;
import G3_Proyecto1.utilidades.Datos;

public class LucasteamServiceImpl implements LucasteamService {
	
	private ColeccionJuegos coleccionJuegos = new ColeccionJuegosImpl();
	private EnumGenre genre; 
	
	@Override
	public void importarListado() {
		// Hacemos casting porque el metodo no esta en la interface de datos.
		((ColeccionJuegosImpl) coleccionJuegos).importarListado("vgsales.csv");
	}

	@Override
	public void mostrarListado() {
		coleccionJuegos.mostrarListado();
	}
	
	
	@Override 
	public void filtrarByGenrePlatform() {
		coleccionJuegos.filtrarByGenre("Platform");
	}
	
	@Override 
	public void filtrarByGenre() {
		EnumGenre.Informe2();
        try {
			this.genre = EnumGenre.dimeCategoria(Datos.recogeInt());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		coleccionJuegos.filtrarByGenre(genre.name());
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
	/*
	@Override
	public Juego getByRank(int rank) {
		return coleccionJuegos.getByRank(rank);
		
	}
	@Override
	public void filtrarByPlatform(String platform) {
		coleccionJuegos.filtrarByPlatform(platform);
	}
	*/
}
