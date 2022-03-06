package g327.lucasteam.excepciones;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ColeccionJuegosException extends Exception {

	private static final long serialVersionUID = 1L;

	private Level level;

	public ColeccionJuegosException() {
	}

	public ColeccionJuegosException(String message) {
		super(message);
	}

	public ColeccionJuegosException(Throwable cause) {
		super(cause);
	}

	public ColeccionJuegosException(String message, Throwable cause) {
		super(message, cause);
	}
	
	// 1: ERROR
	// 2: WARNING
	// 3: INFO
	public ColeccionJuegosException(String message, int tipo) {
		super(message);
		setLevel(tipo);
	}	

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

	@Override
	public String toString() {
		Logger.getLogger(ColeccionJuegosException.class.getName()).log(level, null, super.getMessage());
		return super.getMessage();
	}

}
