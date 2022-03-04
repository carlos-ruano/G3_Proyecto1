package G3_Proyecto1.datos;

import G3_Proyecto1.modelos.Juego;

public interface ColeccionJuegos {
	
	public void addJuego(Juego juego);
	
	public void deleteJuego(Juego juego);
	
	public Juego getByRank(int rank);
	
}
