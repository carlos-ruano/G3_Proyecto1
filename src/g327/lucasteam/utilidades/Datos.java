package g327.lucasteam.utilidades;

/**
 *
 * @author Antonio Santos
 */
import java.util.Scanner;

public class Datos {

	public Datos() {
	}

	@SuppressWarnings("resource")
	public static String recogeString() throws Exception {
		String dato = new Scanner(System.in).nextLine();
		return dato;
	}

	public static String recogeString(String msg) throws Exception {
		System.out.println(msg);
		return recogeString();
	}

	@SuppressWarnings("resource")
	public static int recogeInt() throws Exception {
		int dato = new Scanner(System.in).nextInt();
		return dato;
	}

	public static int recogeInt(String msg) throws Exception {
		System.out.println(msg);
		return recogeInt();
	}

	@SuppressWarnings("resource")
	public static double recogeDouble() throws Exception {
		double dato = new Scanner(System.in).nextDouble();
		return dato;
	}

	public static double recogeDouble(String msg) throws Exception {
		System.out.println(msg);
		return recogeDouble();
	}
}
