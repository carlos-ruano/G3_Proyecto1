package g327.lucasteam.utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import g327.lucasteam.modelos.EnumGenre;
import g327.lucasteam.modelos.EnumPlatform;
import g327.lucasteam.modelos.Juego;

/**
 * Mediante esta clase se conseguirá leer los '<b>.CSV</b>' del proyecto y sobreescribir cualquier otro '<b>.CSV</b>'.
 * @see  <a href="https://github.com/carlos-ruano/G3_Proyecto1">
 *      GitHub G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */

public class OperarCSV {

	private static final String SEPARADOR = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)"; // Ignora los juegos con entrecomillados conflictivos

	/**
	 * Mediante esta función se consigue leer un archivo '<b>.CSV</b>' mediante la adición de los parámetros a los atributos de los objetos
	 * "Juego" instanciados hasta terminar todas las líneas e introduciéndolos en un listado de tipo '<b>Set</b>'.
	 * @param nombreFichero
	 *			Se pasa el nombre del fichero deseado por parámetro.
	 * @return Una colección de juegos de tipo '<b>Set</b>'.
	 */
	public static Set<Juego> readCSV(String nombreFichero) {

		Set<Juego> listado = new HashSet<Juego>();

		try {
			// Abrir el .csv en un buffer de lectura
			File f = new File(nombreFichero);
			if (f.exists()){
			BufferedReader bufferLectura = new BufferedReader(new FileReader(nombreFichero));
			bufferLectura.readLine();
			// Leer una linea del archivo
			String linea = bufferLectura.readLine();

			while (linea != null || linea == "") {
				// Separar la linea leida con el separador definido previamente
				String[] campos = linea.split(SEPARADOR, 0);
				// Buscamos el enumerado correspondiente en cada linea del .CSV
				// Separamos los dos unicos casos conflictivos del enumerado
				
				EnumPlatform platform = null;
				if (campos[2].equalsIgnoreCase("3DO")) {
					EnumPlatform platform1 = EnumPlatform.valueOf("_3DO");
					platform=platform1;
				} else if (campos[2].equalsIgnoreCase("3DS")) {
					EnumPlatform platform1 = EnumPlatform.valueOf("_3DS");
					platform=platform1;
				} else if (campos[2].equalsIgnoreCase("2600")) {
					EnumPlatform platform1 = EnumPlatform.valueOf("_2600");
					platform=platform1;
				}else {
					platform  = EnumPlatform.valueOf(campos[2].toUpperCase());
				}
				
				
				EnumGenre genre = null;
				if (campos[4].equalsIgnoreCase("Role-Playing")) {
					EnumGenre genre1= EnumGenre.valueOf("ROLEPLAYING");
					genre = genre1;
				}else {
					genre = EnumGenre.valueOf(campos[4].toUpperCase());
				}
				
				Juego juego = new Juego(Integer.parseInt(campos[0]), campos[1], platform, campos[3],
						genre, campos[5]);
				listado.add(juego);

				// Volver a leer otra linea del fichero
				linea = bufferLectura.readLine();
			}
			bufferLectura.close(); // Cerramos el buffer
			}
		} catch (IOException | IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		return listado;
	}

	/**
	 * Tras proceder a introducir un juego nuevo en la lista, modificar alguno existente y/o precargar el archivo .CSV, se
	 * finaliza con una sobrescritura del archivo .csv deseado.
	 * @param listado
	 * 			Se pasa por parámetro la lista cargada/editada.
	 * @param nombreFichero
	 * 			Se le pasa el nombre deaseado para crear el nuevo '<b>.CSV</b>'.
	 * @throws IOException Si se produce una excepción de Entrada/Salida.
	 */
	public static void writeCSV(Set<Juego> listado) {
		// Falta desarrollar cuerpo
	}

}
