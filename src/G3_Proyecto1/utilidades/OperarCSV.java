package G3_Proyecto1.utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; // Import the IOException class to handle errors
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OperarCSV {
	
	private static final String SEPARADOR = "[,]";
	
	public static Set<Juego> LeerCSV(String nombreFichero) {

		Set<Juego> listado = new HashSet<Juego>();

		try {
			// Abrir el .csv en buffer de lectura
			BufferedReader bufferLectura = new BufferedReader(new FileReader(nombreFichero));

			// Leer una linea del archivo
			String linea = bufferLectura.readLine();

			while (linea != null || linea == "") {
				// Sepapar la linea leída con el separador definido previamente

				String[] campos = linea.split(SEPARADOR, 0);

				Juego juego = new Juego(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5]);
				listado.add(juego);
			}

			// Volver a leer otra línea del fichero
			linea = bufferLectura.readLine();
			bufferLectura.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listado;
	}

}
