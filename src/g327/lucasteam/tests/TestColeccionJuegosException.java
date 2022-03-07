package g327.lucasteam.tests;



import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import g327.lucasteam.excepciones.ColeccionJuegosException;

class TestColeccionJuegosException {

	@Test
	void testDeberiaDevolverMensajeOK() {
		ColeccionJuegosException exc = new ColeccionJuegosException("hola");
		assertThat(exc.getMessage()).isEqualTo("hola");

	}
	
	@Test
	void testDeberiaDevolverMensajeKO() {
		ColeccionJuegosException exc = new ColeccionJuegosException("Hola");
		assertThat(exc.getMessage()).isNotEqualTo("hola");

	}
	
	@Test
	void testDeberiaDevolverMensajeToStringOK() {
		ColeccionJuegosException exc = new ColeccionJuegosException("hola");
		assertThat(exc.toString()).isEqualTo("hola");

	}
	
	@Test
	void testDeberiaDevolverMensajeToStringKO() {
		ColeccionJuegosException exc = new ColeccionJuegosException("adios");
		assertThat(exc.toString()).isNotEqualTo("hola");

	}
	
}
