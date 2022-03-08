package g327.lucasteam.tests;

import g327.lucasteam.datos.ColeccionJuegosImpl;
import g327.lucasteam.modelos.EnumGenre;
import g327.lucasteam.modelos.EnumPlatform;
import g327.lucasteam.modelos.Juego;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
	void testAddJuegoOK() {
		// Comprobar que no se añade un juego posterior al año 1958.
  //Given:
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1958",EnumGenre.PUZZLE,"Nintendo");
		//When:
  
		//Then:	
			assertThat(CJ.addJuego(j)).isEqualTo(true);
}
	
	@Test
	void testAddJuegoKO() {
		// Comprobar que no se añade un juego posterior al año 1958.
		//Given:
		Juego j = new Juego(6,"Tetris",EnumPlatform.GB,"1957",EnumGenre.PUZZLE,"Nintendo");
		//When:
		//Then:
			assertThat(CJ.addJuego(j)).isEqualTo(false);
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
  
	@Test
	void testDeberiaBorrarJuegoOK() {
		//:Given
		CJ.importarListado("vgsales.csv");
		//When:
		int size = CJ.getListado().size();
		//Then:
		assertThat(CJ.deleteJuego(1)).isEqualTo(true);
		assertThat(CJ.getListado()).hasSize(size-1);
	}
	@Test
	void testDeberiaBorrarJuegoKO() {
		//:Given
		CJ.importarListado("vgsales.csv");
		//When:
		int size = CJ.getListado().size();
		//Then:
		assertThat(CJ.deleteJuego(-1)).isEqualTo(true);
		assertThat(CJ.getListado()).hasSize(size-1);
	}
	
	@Test
	void testDeberiaImprimirListaParesOK() {
		//:Given
		CJ.importarListado("vgsales.csv");
		CJ.filtrarByAnoPar(true);
		//When:
		assertThat(outputStreamCaptor.toString().trim()).contains("year=2000");
	}
	
	@Test
	void testDeberiaImprimirListaParesKO() {
		//:Given
		CJ.importarListado("vgsales.csv");
		CJ.filtrarByAnoPar(true);
		//When:
		assertThat(outputStreamCaptor.toString().trim()).contains("year=1999");
	}
	
	@Test
	void testDeberiaImprimirListaImparesOK() {
		//:Given
		CJ.importarListado("vgsales.csv");
		CJ.filtrarByAnoPar(false);
		//When:
		assertThat(outputStreamCaptor.toString().trim()).contains("year=1999");
	}
	@Test
	void testDeberiaImprimirListaImparesKO() {
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
	
	@Test 
	void testDevuelveAniosExactoOK(){
		CJ.importarListado("vgsales.csv");
		//When:
		CJ.filtrarByAno(1990,1990);
		//Then:		
		assertThat(CJ.getTestListado().get(0).getYear().contains("1990")).isTrue();
	}
	@Test 
	void testDevuelveAniosExactoKO(){
		CJ.importarListado("vgsales.csv");
		//When:
		CJ.filtrarByAno(1990,1990);
		//Then:		
		assertThat(CJ.getTestListado().get(0).getYear().contains("1991")).isTrue();
	}
	
	@Test 
	void testDevuelveAniosEnUnRangoOK(){
		CJ.importarListado("vgsales.csv");
		//When:
		CJ.filtrarByAno(1992,1990);
		//Then:		
		assertThat(CJ.getTestListado().get(0).getYear().contains("1991")).isTrue();
	}
	
	@Test 
	void testDevuelveAniosEnUnRangoKO(){
		CJ.importarListado("vgsales.csv");
		//When:
		CJ.filtrarByAno(1992,1990);
		//Then:		
		assertThat(CJ.getTestListado().get(0).getYear().contains("1993")).isTrue();
	}
	
}
