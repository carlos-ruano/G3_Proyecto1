package G3_Proyecto1.utilidades;

import G3_Proyecto1.modelos.EnumGenre;
import G3_Proyecto1.modelos.EnumPlatform;
import G3_Proyecto1.modelos.Juego;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class OperarCSV {

	private static final String SEPARADOR = "[,]";

	public static Set<Juego> readCSV(String nombreFichero) {

		Set<Juego> listado = new HashSet<Juego>();

		try {
			// Abrir el .csv en un buffer de lectura
			BufferedReader bufferLectura = new BufferedReader(new FileReader(nombreFichero));

			// Leer una linea del archivo
			String linea = bufferLectura.readLine();

			while (linea != null || linea == "") {
				// Separar la linea leida con el separador definido previamente
				String[] campos = linea.split(SEPARADOR, 0);
				// Buscamos el enumerado correspondiente en cada linea del .CSV
				// Separamos los dos unicos casos conflictivos del enumerado
				if (campos[2].equalsIgnoreCase("3DO")) {
					@SuppressWarnings("unused")
					EnumPlatform platform = EnumPlatform.valueOf("_3DO");
				} else if (campos[2].equalsIgnoreCase("3DS")) {
					@SuppressWarnings("unused")
					EnumPlatform platform = EnumPlatform.valueOf("_3DS");
				}

				EnumPlatform platform = EnumPlatform.valueOf(campos[2].toUpperCase());
				EnumGenre genre = EnumGenre.valueOf(campos[4].toUpperCase());

				Juego juego = new Juego(Integer.parseInt(campos[0]), campos[1], platform, Integer.parseInt(campos[3]),
						genre, campos[5]);
				listado.add(juego);

				// Volver a leer otra linea del fichero
				linea = bufferLectura.readLine();
			}
			bufferLectura.close(); // Cerramos el buffer

		} catch (IOException | IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		return listado;
	}

	public static void writeCSV(Set<Juego> listado) {
		// Falta desarrollar cuerpo
	}

}
