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
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestColeccionJuegosImpl {

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
	void testAddJuego() {
		
		// Comprobar que el juego aï¿½adido no es nulo y que se aï¿½ade correctamente.
		
		//Given:
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1989",EnumGenre.PUZZLE,"Nintendo");
		//When:
		//Then:
		assertThat(j).isNotNull();
		assertThat(CJ.addJuego(j)).isNotEqualTo(false);

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
	void testAddJuego3() {
		// Comprobar que no se aï¿½ade un juego posterior al ano 1958.
		//Given:
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1957",EnumGenre.PUZZLE,"Nintendo");
		//When:
		if (Integer.parseInt(j.getYear()) < 1958) {
			System.out.println("El primer juego salido en 1958, y por tanto el año es inválido.");
		} else {
			
		//Then:
			
			assertThat(CJ.addJuego(j)).isEqualTo(true);
			System.out.println("Juego añadido correctamente.");
		}
	}
		

	@Test
	void testAddJuego4() {
		// Comprobar que un juego se añade con una plataforma que no existe.
		//Given:
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1957",EnumGenre.PUZZLE,"Nintendo");
		//When:
		
		EnumPlatform[] platform = EnumPlatform.class.getEnumConstants();
		EnumGenre[] genre = EnumGenre.class.getEnumConstants();
		ArrayList<String> LP = new ArrayList<String>();
		ArrayList<String> LG = new ArrayList<String>();
		
		for(EnumPlatform p : platform)LP.add(p.name());
		for(EnumGenre g : genre)LG.add(g.name());
					
		if (!LG.contains(j.getGenre().name()) || !LP.contains(j.getPlatform().name())) {
			System.out.println("El género o la plataforma no existen.");
			fail("Not yet implemented");
			
		} else {
			
		//Then:
			
			assertThat(CJ.addJuego(j)).isEqualTo(true);
			System.out.println("Juego aï¿½adido correctamente.");

			
		}


	}
	
	@Test
	void testFiltrarByPublisherNintendoOK() {
		
		// Comprobar que se filtran correctamente solamente los juegos de la editora Nintendo.
		
		//Given:
		CJ.importarListado("vgsales.csv");
		//When:
		CJ.filtrarByPublisher("Nintendo");
		//Then:		
		assertThat(CJ.getTestListado().get(0).getPublisher().contains("Nintendo")).isTrue();
		
	}
	
	@Test
	void testFiltrarByPublisherNintendoKO() {
		
		//Given:
		CJ.importarListado("vgsales.csv");
		//When:
		CJ.filtrarByPublisher("Nintendo");
		//Then:		
		assertThat(CJ.getTestListado().get(0).getPublisher().contains("Ubisoft")).isTrue();
	
	}
	
	@Test
	void testFiltrarByPublisherNintendoNotNullOK() {
		
		// Comprobar que se filtran correctamente solamente los juegos de la editora Nintendo porque no es nulo.
		
		//Given:
		CJ.importarListado("vgsales.csv");
		//When:
		CJ.filtrarByPublisher("Nintendo");
		//Then:		
		assertThat(CJ.getTestListado().get(0).getPublisher().contains("Nintendo")).isNotNull();
		
	}
	


	@Test
	void testToString() {
		
		// Verifica que el objeto que va a llamar a toString(), no es nulo.
		
		assertThat(this).isNotNull();
		
	}
	
	@Test
	void getListaPublisherNotVoid() {
		
		// Comprobar que se filtra correctamente dado un g�nero en concreto. En este caso, el g�nero 'PLATFORM'.
		
		//Given:
		CJ.importarListado("vgsales.csv");
		//When:
		Set <String> ListaPrueba = CJ.getListaPublisher();
		//Then:			
		assertThat(ListaPrueba.isEmpty()).isFalse();

	}
	
	@Test
	void getListaPublisherNotRepeatedOK() {
		
		// Comprobar que tras añadir un juego con un editor ya existente, las
		//lista de editores sigue inmutable
		
		//Given:
		CJ.importarListado("vgsales.csv");
		System.out.println("(getListaPublisherNotRepeatedOK) importado");
		Set<String> lista1 = CJ.getListaPublisher();
		
		Juego j1 = new Juego(999999,"Un juego",EnumPlatform.GB,"1980",EnumGenre.PUZZLE,"Nintendo"); // Ya existe Nintendo
		Juego j2 = new Juego(99999,"Dark Souls",EnumPlatform.PC,"1980",EnumGenre.PUZZLE,"From Software"); // Ya existe Nintendo
		//When:
		CJ.addJuego(j1);
		CJ.addJuego(j2);
		Set<String> lista2 = CJ.getListaPublisher();
		
		//Then:			
		assertThat(lista1.size()).isEqualTo(lista2.size());

	}
	
	@Test
	void getListaPublisherNotRepeatedKO() {
		
		// Comprobar que tras añadir un juego con un editor ya existente, las
		//lista de editores sigue inmutable
		
		//Given:
		CJ.importarListado("vgsales.csv");
		System.out.println("(getListaPublisherNotRepeatedKO) importado");
		Set<String> lista1 = CJ.getListaPublisher();
		
		Juego j1 = new Juego(999999,"Un juego",EnumPlatform.GB,"1980",EnumGenre.PUZZLE,"Nintendo"); // Ya existe Nintendo
		Juego j2 = new Juego(99999,"Dark Souls",EnumPlatform.PC,"1980",EnumGenre.PUZZLE,"Un editor inventado"); // No existe el publisher
		//When:
		CJ.addJuego(j1);
		CJ.addJuego(j2);
		Set<String> lista2 = CJ.getListaPublisher();
		
		//Then:			
		assertThat(lista1.size()).isNotEqualTo(lista2.size()); // Para que de error hay que cambiarlo a "isEqualTo"

	}

	void testUpdateJuego() {
		
	}
  
	@Test
	void testDeleteJuegoOK() {
		//:Given
		CJ.importarListado("vgsales.csv");
		//When:
		int size = CJ.getListado().size();
		//Then:
		assertThat(CJ.deleteJuego(1)).isEqualTo(true);
		assertThat(CJ.getListado()).hasSize(size-1);
	}
	@Test
	void testDeleteJuegoKO() {
		//:Given
		CJ.importarListado("vgsales.csv");
		//When:
		int size = CJ.getListado().size();
		//Then:
		assertThat(CJ.deleteJuego(-1)).isEqualTo(true);
		assertThat(CJ.getListado()).hasSize(size-1);
	}
	
	@Test
	void testFiltrarByAñoOK() {
		//:Given
		CJ.importarListado("vgsales.csv");
		CJ.filtrarByAnoPar(true);
		//When:
		assertThat(outputStreamCaptor.toString().trim()).contains("Juego");
	}
	
	@Test
	void testFiltrarByAñoKO() {
		//:Given
		CJ.importarListado("vgsales.csv");
		CJ.filtrarByAnoPar(true);
		//When:
		assertThat(outputStreamCaptor.toString().trim()).contains("null");
	}

}
