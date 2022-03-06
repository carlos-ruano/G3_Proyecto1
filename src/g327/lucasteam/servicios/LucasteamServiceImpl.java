package g327.lucasteam.servicios;

import g327.lucasteam.datos.ColeccionJuegos;
import g327.lucasteam.datos.ColeccionJuegosImpl;
import g327.lucasteam.excepciones.ColeccionJuegosException;
import g327.lucasteam.modelos.EnumGenre;
import g327.lucasteam.modelos.Juego;
import g327.lucasteam.utilidades.Datos;
import lombok.extern.java.Log;

@Log // Invocamos al logger de log4j2
public class LucasteamServiceImpl implements LucasteamService {
	
	private ColeccionJuegos coleccionJuegos = new ColeccionJuegosImpl();
	private EnumGenre genre; 
	
	@Override
	public void importarListado() {
		// Hacemos casting porque el metodo no esta en la interface de datos.
		String nombreArchivo = "vgsales.csv";
		((ColeccionJuegosImpl) coleccionJuegos).importarListado(nombreArchivo);
		log.info("Listado importado del archivo "+nombreArchivo); // Hacemos loggin .info al importar listado,
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
		System.out.println("Seleccione el número de género a buscar:");
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
