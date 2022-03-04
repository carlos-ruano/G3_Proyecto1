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
	public void filtrarByPlatform(String platform) {
		try {
			for(Juego j : coleccionJuegos.listado)
			{
				if(j.getPlatform().name() == platform)
				{
					System.out.println("Juego: "+j.getName()+", Genero: "+j.getGenre().name()
									+", año de publicación: "+j.getYear()+", editor: "+j.getPublisher()
									+", su ranking es: "+j.getRank());
				}
			}
		} catch (ColeccionJuegosException e) {
			
		}
		
		
	}
	
	@Override
	public void filtrarByPlatform(String genre) {
		for(Juego j : coleccionJuegos.listado)
		{
			if(j.getPlatform().name() == platform)
			{
				System.out.println("Juego: "+j.getName()+", Genero: "+j.getGenre().name()
								+", año de publicación: "+j.getYear()+", editor: "+j.getPublisher());
			}
		}
		
	}

	@Override
	public boolean addJuego() throws ColeccionJuegosException {
		return false;
	}

	@Override
	public boolean addJuego(Juego J) throws ColeccionJuegosException {
		return false;
	}

}
