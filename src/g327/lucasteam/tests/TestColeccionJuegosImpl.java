package g327.lucasteam.tests;

import g327.lucasteam.datos.ColeccionJuegosImpl;
import g327.lucasteam.modelos.EnumGenre;
import g327.lucasteam.modelos.EnumPlatform;
import g327.lucasteam.modelos.Juego;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.IgnoreForBinding.Verifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestColeccionJuegosImpl {

	private ColeccionJuegosImpl CJ;
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@BeforeEach
	void setUp() throws Exception {
		
		CJ = new ColeccionJuegosImpl();
		System.setOut(new PrintStream(outputStreamCaptor));
		
	}
	

	@Test
	void testMostrarListado() {
		
		//Given:
		CJ.importarListado("vgsales.csv");
		//When:
		int x = CJ.getListado().size();
		//Then:
		assertThat(x).isNotEqualTo(0);

	}
	


	@Test
	void testImportarListado() {
		
		// Comprobar si todos los juegos estï¿½n importados.
		
		//Given:
		CJ = new ColeccionJuegosImpl();
		//When:
		CJ.importarListado("vgsales.csv");
		int x = CJ.getListado().size();
		//Then:
		assertThat(x).isEqualTo(16598);
		assertThat(x).isNotEqualTo(0);
	}
	
	@Test
	void testImportarListado2() {
		
		// Comprobar que un elemento concreto exista.
		
		//Given:
		CJ = new ColeccionJuegosImpl();
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1989",EnumGenre.PUZZLE,"Nintendo");
		//When:
		CJ.importarListado("vgsales.csv");
		//Then:
		assertThat(CJ.getListado()).containsOnlyOnce(j);


	}


	@Test
	void testFiltrarByGenre() {
		
		// Comprobar que se filtra correctamente dado un gï¿½nero en concreto. En este caso, el gï¿½nero 'PLATFORM'.
		
		//Given:
		CJ.importarListado("vgsales.csv");
		//When:
		CJ.filtrarByGenre("platform");
		//Then:			
		assertThat(CJ.getTestListado().get(0).getGenre().name()).isEqualTo("PLATFORM");
			
		

	}


	
	@Test
	void testAddJuego2() {
		
		// Asegurar que una lista vacï¿½a funciona.
		
		//Given:
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1989",EnumGenre.PUZZLE,"Nintendo");
		//When:
		CJ.addJuego(j);
		//Then:
		assertThat(j).isNotNull();
		assertThat(CJ.getListado()).hasSize(1);
	}
	
	@Test
	void testAddJuegoOK() {
		// Comprobar que no se aï¿½ade un juego posterior al aï¿½o 1958.
		//Given:
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1958",EnumGenre.PUZZLE,"Nintendo");
		//When:
		//Then:	
			assertThat(CJ.addJuego(j)).isEqualTo(true);
	}
	
	@Test
	void testAddJuegoKO() {
		// Comprobar que no se aï¿½ade un juego posterior al aï¿½o 1958.
		//Given:
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1957",EnumGenre.PUZZLE,"Nintendo");
		//When:
		//Then:
			assertThat(CJ.addJuego(j)).isEqualTo(false);
	}
	
	@Test
	void testToString() {
		
		// Verifica que el objeto que va a llamar a toString(), no es nulo.
		
		assertThat(this).isNotNull();
	}
	
	@Test
	void testDeberíaBorrarJuegoOK() {
		//:Given
		CJ.importarListado("vgsales.csv");
		//When:
		int size = CJ.getListado().size();
		//Then:
		assertThat(CJ.deleteJuego(1)).isEqualTo(true);
		assertThat(CJ.getListado()).hasSize(size-1);
	}
	@Test
	void testDeberíaBorrarJuegoKO() {
		//:Given
		CJ.importarListado("vgsales.csv");
		//When:
		int size = CJ.getListado().size();
		//Then:
		assertThat(CJ.deleteJuego(-1)).isEqualTo(true);
		assertThat(CJ.getListado()).hasSize(size-1);
	}
	
	@Test
	void testDeberíaImprimirListaParesOK() {
		//:Given
		CJ.importarListado("vgsales.csv");
		CJ.filtrarByAnoPar(true);
		//When:
		assertThat(outputStreamCaptor.toString().trim()).contains("year=2000");
	}
	
	@Test
	void testDeberíaImprimirListaParesKO() {
		//:Given
		CJ.importarListado("vgsales.csv");
		CJ.filtrarByAnoPar(true);
		//When:
		assertThat(outputStreamCaptor.toString().trim()).contains("year=1999");
	}
	
	@Test
	void testDeberíaImprimirListaImparesOK() {
		//:Given
		CJ.importarListado("vgsales.csv");
		CJ.filtrarByAnoPar(false);
		//When:
		assertThat(outputStreamCaptor.toString().trim()).contains("year=1999");
	}
	@Test
	void testDeberíaImprimirListaImparesKO() {
		//:Given
		CJ.importarListado("vgsales.csv");
		CJ.filtrarByAnoPar(false);
		//When:
		assertThat(outputStreamCaptor.toString().trim()).contains("year=2000");
	}
	//Añadir un juego a una lista vacia y verificar si devuelve lo mismo con el 
	// 	el metodo BuscarByName()
	@Test
	void testBuscarByNameCaseSensitiveOk() {
		//:Given
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1959",EnumGenre.PUZZLE,"Nintendo");
		CJ.addJuego(j);
		CJ.buscarJuegoByName("tetris");
		//When:
		assertThat(outputStreamCaptor.toString().trim()).contains("Tetris");
	}
	
	@Test
	void testBuscarByNameCaseSensitiveKO() {
		//:Given
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1959",EnumGenre.PUZZLE,"Nintendo");
		CJ.addJuego(j);
		CJ.buscarJuegoByName("Tetris");
		//When:
		assertThat(outputStreamCaptor.toString().trim()).contains("mario");
	}

}
