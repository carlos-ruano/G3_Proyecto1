package g327.lucasteam.gui;

/**
 * Mediante esta clase creamos el menu que se mostrara por consola
 * 
 * @see <a href="https://github.com/carlos-ruano/G3_Proyecto1"> GitHub
 *      G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */
public class Menu {

	public static void mostrarMenu() {
		System.out.println(" ");
		System.out.println(" LUCASTEAM");
		System.out.println(" ");
		System.out.println("************************************************");
		System.out.println("*  Por favor, escoge una opcion: ");
		System.out.println("*    1.-Importar el listado de juegos");
		System.out.println("*    2.-Listar todos los juegos");
		System.out.println("*    3.-Filtrar por genero plataforma");
		System.out.println("*    4.-Filtrar por genero");
		System.out.println("*    5.-Dar de alta un juego");
		System.out.println("*    6.-Dar de baja un juego");
		System.out.println("*    7.-Modificar un juego");
		System.out.println("*    8.-Filtrar por editor nintendo");
		System.out.println("*    9.-Listado de editores");
		System.out.println("*    10.-Filtrar por juegos del siglo XX");
		System.out.println("*    11.-Filtrar por juegos de año par");
		System.out.println("*    12.-Exportar listado actual");
		System.out.println("*    0.-Terminar sesion");
		System.out.println("************************************************");
		System.out.println(" ");
		System.out.print(">> ");

	}
	
	public static void mostrarMenuEdit() {
		System.out.println(" ");
		System.out.println(" LUCASTEAM");
		System.out.println(" ");
		System.out.println("************************************************");
		System.out.println("*  Por favor, escoge una opcion: ");
		System.out.println("*    1.-Cambiar el Rank");
		System.out.println("*    2.-Cambiar el Nombre");
		System.out.println("*    3.-Cambiar la Plataforma");
		System.out.println("*    4.-Cambiar el Año");
		System.out.println("*    5.-Cambiar el Genero");
		System.out.println("*    6.-Cambiar la Editora");
		System.out.println("*    0.-Terminar editar Juego");
		System.out.println("************************************************");
		System.out.println(" ");
		System.out.print(">> ");
	}
}
