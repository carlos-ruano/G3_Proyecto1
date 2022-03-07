package g327.lucasteam.excepciones;

/**
 * Mediante esta clase recogeremos los exception que puedan ocurrir.
 * 
 * @see <a href="https://github.com/carlos-ruano/G3_Proyecto1"> GitHub
 *      G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */
public class ColeccionJuegosException extends Exception {

	private static final long serialVersionUID = 1L;

	// private Level level;

	public ColeccionJuegosException() {
	}

	/**
	 * Mediante esta funci�n construye la excepci�n con el mensaje de detalle
	 * especificado
	 * 
	 * @param message Se pasa el mensaje del exception.
	 */
	public ColeccionJuegosException(String message) {
		super(message);
	}

	/**
	 * Mediante esta funci�n recogemos la causa del error
	 * 
	 * @param cause Se pasa la causa del Throw.
	 */
	public ColeccionJuegosException(Throwable cause) {
		super(cause);
	}

	/**
	 * Mediante esta funci�n construye la excepci�n con el mensaje de detalle
	 * especificado y su causa
	 * 
	 * @param cause   Se pasa la causa del Throw.
	 * @param messege Se pasa el mensaje del excepttion
	 */
	public ColeccionJuegosException(String message, Throwable cause) {
		super(message, cause);
	}

  /*
	// 1: ERROR
	// 2: WARNING
	// 3: INFO
	public ColeccionJuegosException(String message, int tipo) {
		super(message);
		setLevel(tipo);
	}

	 * Mediante esta funci�n cambiamos el nivel de gravedad del error
	 * 
	 * @param tipo Se pasa el nivel de error
	public void setLevel(int tipo) {

		switch (tipo) {
		case 1:
			level = Level.SEVERE;
			break;
		case 2:
			level = Level.WARNING;
			break;
		case 3:
			level = Level.INFO;
			break;
		default:
			level = Level.INFO;
			break;
		}
	}
	*/

	@Override
	public String toString() {
		// Logger.getLogger(ColeccionJuegosException.class.getName()).log(level, null,
		// super.getMessage());
		return super.getMessage();
	}

}
