package g327.lucasteam.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import g327.lucasteam.datos.ColeccionJuegosImpl;
import g327.lucasteam.utilidades.OperarCSV;

class TestOperarCSV {
	
	@SuppressWarnings("unused")
	private ColeccionJuegosImpl CJ;
	@SuppressWarnings("unused")
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() throws Exception {
		CJ = new ColeccionJuegosImpl();
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	void DebeCrearArchivo() {
		
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		input = ""; // Importa "vgsales.csv" por defecto
		InputStream in2 = new ByteArrayInputStream(input.getBytes());
		System.setIn(in2);
		
		input = "12"; // Selecciona "Importar"
		InputStream in3 = new ByteArrayInputStream(input.getBytes());
		System.setIn(in3);
		
		input = "prueba01"; // Se crea el archivo .CSV
		InputStream in4 = new ByteArrayInputStream(input.getBytes());
		System.setIn(in4);
		
		// assertEquals("hola", Datos.recogeString());
		assertThat(OperarCSV.readCSV("prueba01.csv")).isNotEmpty();

	}

}
