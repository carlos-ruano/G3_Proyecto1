package g327.lucasteam.utilidades;

/**
 * Mediante esta clase se conseguirá leer los datos introducidos por teclado con un mensaje personalizado.
 * @see  <a href="https://github.com/carlos-ruano/G3_Proyecto1">
 *      GitHub G3_Proyecto1</a>
 * @author Antonio Santos
 * @version 0.1
 *
 */

import java.util.Scanner;

public class Datos {

    public Datos() {
    }

    /**
     * Se instancia el objeto 'dato' de la clase Scanner para recoger los inputs por teclados de tipo '<b>String</b>'.
     * <br>También se suprime el aviso tipo <i>Warning</i> por no cerrar el objeto Scanner.
     * @return La cadena de texto introducida por teclado.
     * @throws Exception
     */
    @SuppressWarnings("resource")
	public static String recogeString() throws Exception {
		String dato = new Scanner(System.in).nextLine();
        return dato;
    }
    
    /**
     * Mediante este método estático  se devuelve un <i>System.out.println</i> con la cadena de texto deseada.
     * @param msg
     * 			Se le introduce un mensaje personalizado para pedir la entrada del teclado.
     * @return La función <i>recogeString()</i> con sobrecarga para crear el objeto scanner.
     * @throws Exception
     */
    public static String recogeString(String msg) throws Exception {
        System.out.println(msg);
        return recogeString();
    }
    
    /**
     * Se instancia el objeto 'dato' de la clase Scanner para recoger los inputs por teclados de tipo '<b>entero</b>'.
     * <br>También se suprime el aviso tipo <i>Warning</i> por no cerrar el objeto Scanner.
     * @return El entero introducido por teclado.
     * @throws Exception
     */
    @SuppressWarnings("resource")
    public static int recogeInt() throws Exception {
        int dato = new Scanner(System.in).nextInt();
        return dato;
    }
    
    /**
     * Mediante este método estático  se devuelve un <i>System.out.println</i> con la cadena de texto deseada.
     * @param msg
     * 			Se le introduce un mensaje personalizado para pedir la entrada del teclado.
     * @return La función <i>recogeInt()</i> con sobrecarga para crear el objeto scanner.
     * @throws Exception
     */
    public static int recogeInt(String msg) throws Exception {
        System.out.println(msg);
        return recogeInt();
    }
    
    /**
     * Se instancia el objeto 'dato' de la clase Scanner para recoger los inputs por teclados de tipo '<b>double</b>'.
     * <br>También se suprime el aviso tipo <i>Warning</i> por no cerrar el objeto Scanner.
     * @return El double introducido por teclado.
     * @throws Exception
     */
    @SuppressWarnings("resource")
    public static double recogeDouble() throws Exception {
        double dato = new Scanner(System.in).nextDouble();
        return dato;
    }
    
    /**
     * Mediante este método estático  se devuelve un <i>System.out.println</i> con la cadena de texto deseada.
     * @param msg
     * 			Se le introduce un mensaje personalizado para pedir la entrada del teclado.
     * @return La función <i>recogeDouble()</i> con sobrecarga para crear el objeto scanner.
     * @throws Exception
     */
    public static double recogeDouble(String msg) throws Exception {
        System.out.println(msg);
        return recogeDouble();
    }
}
