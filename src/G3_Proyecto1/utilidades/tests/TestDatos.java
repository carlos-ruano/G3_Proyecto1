package G3_Proyecto1.utilidades.tests;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import G3_Proyecto1.utilidades.Datos;

class TestDatos {

	@Test
	void testDeberiaRecogerStringDelUsuario() throws Exception {
			String input = "hola";
		    InputStream in = new ByteArrayInputStream(input.getBytes());
		    System.setIn(in);
		    //assertEquals("hola", Datos.recogeString());
		    assertThat(Datos.recogeString()).isEqualTo("hola");
	    
	}
	@Test
	void testDeberiaRecogerIntDelUsuario() throws Exception {
			String input = "2";
		    InputStream in = new ByteArrayInputStream(input.getBytes());
		    System.setIn(in);
		    //assertEquals("hola", Datos.recogeString());
		    assertThat(Datos.recogeInt()).isEqualTo(2);
	    
	}
	
	@Test
	void testDeberiaRecogerDoubleDelUsuario() throws Exception {
			String input = "1";
		    InputStream in = new ByteArrayInputStream(input.getBytes());
		    System.setIn(in);
		    //assertEquals("hola", Datos.recogeString());
		    assertThat(Datos.recogeDouble()).isEqualTo(1);
	    
	}
/*
	@Test
	void testRecogeStringString() {
		fail("Not yet implemented");
	}

	@Test
	void testRecogeInt() {
		fail("Not yet implemented");
	}

	@Test
	void testRecogeIntString() {
		fail("Not yet implemented");
	}

	@Test
	void testRecogeDouble() {
		fail("Not yet implemented");
	}

	@Test
	void testRecogeDoubleString() {
		fail("Not yet implemented");
	}
*/
}
