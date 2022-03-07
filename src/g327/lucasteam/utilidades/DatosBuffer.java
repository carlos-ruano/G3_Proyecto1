package g327.lucasteam.utilidades;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Mediante esta clase se conseguira recogemos los datos que se pasan por consola.
 * 
 * @see <a href="https://github.com/carlos-ruano/G3_Proyecto1"> GitHub
 *      G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */
public class DatosBuffer {

	BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public String recogeString() throws Exception {
		String dato = teclado.readLine();
		return dato;
	}

	public int recogeInt() throws Exception {
		int dato = Integer.parseInt(teclado.readLine());
		return dato;
	}

	public double recogeDouble() throws Exception {
		double dato = Double.parseDouble(teclado.readLine());
		return dato;
	}
}
