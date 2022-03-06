package G3_Proyecto1.modelos.tests;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import G3_Proyecto1.modelos.EnumGenre;
import G3_Proyecto1.modelos.EnumPlatform;
import G3_Proyecto1.modelos.Juego;

class TestJuego {
	
	private EnumPlatform platform;
	private EnumGenre genre; 
	private Juego juego;

	@BeforeEach
	void setUp() throws Exception {
		this.platform = EnumPlatform.valueOf("WII");
		this.genre = EnumGenre.valueOf("PLATFORM");
		juego = new Juego(0, "1",platform, "1990", genre, "nintendo");
	}

	@Test
	void testSiCreoUnJuegoElContructorFuncionaOK() {
		
		assertThat(juego.getRank()).isEqualTo(0);
		assertThat(juego.getName()).isEqualTo("1");
		assertThat(juego.getPlatform()).isEqualTo(platform);
		assertThat(juego.getYear()).isEqualTo("1990");
		assertThat(juego.getGenre()).isEqualTo(genre);
		assertThat(juego.getPublisher()).isEqualTo("nintendo");
	}
	
	@Test
	void testToStringOK() {
		assertThat(juego.toString()).isEqualTo("Juego [rank=0, name=1, platform=WII, year=1990, genre=PLATFORM, publisher=nintendo]");
	}
	
	@Test
	void testImprimirOK() {
		assertThat(juego.imprimir()).isEqualTo("0: 1, Platform: WII, Año: 1990, Género: PLATFORM, Editor: nintendo");
		
	}
/*
	@Test
	void testCreateJuego() {
		fail("Not yet implemented");
	}
	*/
}
