package g327.lucasteam.datos.tests;

import g327.lucasteam.datos.ColeccionJuegosImpl;
import g327.lucasteam.modelos.EnumGenre;
import g327.lucasteam.modelos.EnumPlatform;
import g327.lucasteam.modelos.Juego;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestColeccionJuegosImpl {

	private ColeccionJuegosImpl CJ;
	
	@BeforeEach
	void setUp() throws Exception {
		
		CJ = new ColeccionJuegosImpl();
		
	}
	
	@Test
	void testColeccionJuegosImpl() {
		fail("Not yet implemented");
	}

	@Test
	void testColeccionJuegosImplSetOfJuego() {
		fail("Not yet implemented");
	}

	@Test
	void testGetListado() {
		fail("Not yet implemented");
	}

	@Test
	void testSetListado() {
		fail("Not yet implemented");
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
		
		// Comprobar si todos los juegos están importados.
		
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
		
		// Comprobar que se filtra correctamente dado un género en concreto. En este caso, el género 'PLATFORM'.
		
		//Given:
		CJ.importarListado("vgsales.csv");
		//When:
		CJ.filtrarByGenre("platform");
		//Then:			
		assertThat(CJ.getListado().iterator().next().getGenre().name()).isEqualTo("PLATFORM");
			
		

	}

	@Test
	void testAddJuego() {
		
		// Comprobar que el juego añadido no es nulo y que se añade correctamente.
		
		//Given:
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1989",EnumGenre.PUZZLE,"Nintendo");
		//When:
		CJ.addJuego(j);
		//Then:
		assertThat(j).isNotNull();
		assertThat(CJ.addJuego(j)).isNotEqualTo(false);

	}
	
	@Test
	void testAddJuego2() {
		
		// Asegurar que una lista vacía funciona.
		
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
		
		// Comprobar que no se añade un juego posterior al año 1958.
		
		//Given:
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1957",EnumGenre.PUZZLE,"Nintendo");
		//When:
		if (Integer.parseInt(j.getYear()) < 1958) {
			
			System.out.println("El primer juego salió en 1958, y por tanto el año es inválido.");
			fail("Not yet implemented");
			
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
			
			System.out.println("El género o la platafarma no existen.");
			fail("Not yet implemented");
			
		} else {
			
		//Then:
			
			assertThat(CJ.addJuego(j)).isEqualTo(true);
			System.out.println("Juego añadido correctamente.");

			
		}


	}
	

	@Test
	void testToString() {
		
		// Verifica que el objeto que va a llamar a toString(), no es nulo.
		
		assertThat(this).isNotNull();
		
	}

}
