package g327.lucasteam.tests;

import g327.lucasteam.datos.ColeccionJuegosImpl;
import g327.lucasteam.modelos.EnumGenre;
import g327.lucasteam.modelos.EnumPlatform;
import g327.lucasteam.modelos.Juego;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestColeccionJuegosImpl {

	private ColeccionJuegosImpl CJ;
	
	@BeforeEach
	void setUp() throws Exception {
		
		CJ = new ColeccionJuegosImpl();
		
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
		
		// Comprobar si todos los juegos est�n importados.
		
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
		
		// Comprobar que se filtra correctamente dado un g�nero en concreto. En este caso, el g�nero 'PLATFORM'.
		
		//Given:
		CJ.importarListado("vgsales.csv");
		//When:
		CJ.filtrarByGenre("platform");
		//Then:			
		assertThat(CJ.getTestListado().get(0).getGenre().name()).isEqualTo("PLATFORM");
			
		

	}

	@Test
	void testAddJuego() {
		
		// Comprobar que el juego a�adido no es nulo y que se a�ade correctamente.
		
		//Given:
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1989",EnumGenre.PUZZLE,"Nintendo");
		//When:
		//Then:
		assertThat(j).isNotNull();
		assertThat(CJ.addJuego(j)).isNotEqualTo(false);

	}
	
	@Test
	void testAddJuego2() {
		
		// Asegurar que una lista vac�a funciona.
		
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
		
		// Comprobar que no se añade un juego posterior al a�o 1958.
		
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
			System.out.println("Juego a�adido correctamente.");

			
		}


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


}
