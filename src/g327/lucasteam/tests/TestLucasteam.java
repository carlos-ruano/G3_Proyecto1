package g327.lucasteam.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import g327.lucasteam.control.Lucasteam;
import g327.lucasteam.datos.ColeccionJuegosImpl;
import g327.lucasteam.excepciones.ColeccionJuegosException;


class TestLucasteam {
	
	private Lucasteam control;

	@BeforeEach
	void setUp() throws Exception {
		
		control = new Lucasteam();
		
	}

	/*
	@Test
	void testDeberiaDevolverExcepcionConOpcionErronea() {

		//Given:
		control = new Lucasteam();

		//When:
		String input = "-1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		
		
		Throwable thrown = catchThrowable(() -> {
			control.seleccionOpciones();
		});
		
		//Then:
		// Comprobamos que devuelve una excepci�n por no exisitir tal opci�n:
		assertThatExceptionOfType(ColeccionJuegosException.class)
		.isThrownBy(() -> control.seleccionOpciones());
		
	}
	*/
	
	@Test
	void testDeberiaCerrarLoopDelMenu() {

		//Given:
		control = new Lucasteam();

		//When:
		// Seleccionamos salir de Lucasteam
		String input = "0";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// Confirmamos salida del menu
		input = "s";
		InputStream in2 = new ByteArrayInputStream(input.getBytes());
		System.setIn(in2);
		
		//Then:
		assertThat(control.seleccionOpciones()).isFalse();
		
	}
	
	@Test
	void testDeberiaMantenerLoopDelMenu() {

		//Given:
		control = new Lucasteam();

		//When:
		// Seleccionamos salir de Lucasteam
		String input = "0";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// Confirmamos salida del menu
		input = "n";
		InputStream in2 = new ByteArrayInputStream(input.getBytes());
		System.setIn(in2);
		
		//Then:
		assertThat(control.seleccionOpciones()).isTrue();
		
	}

}
