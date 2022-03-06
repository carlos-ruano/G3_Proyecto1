package g327.lucasteam.modelos;

import g327.lucasteam.utilidades.Datos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor @AllArgsConstructor class Juego {

	private int rank;
	private String name;
	private EnumPlatform platform;
	private String year;
	private EnumGenre genre; // Cambiar en UML tiene puesto que es clase String
	private String publisher;

	@Override
	public String toString() {
		return "Juego [rank=" + rank + ", name=" + name + ", platform=" + platform + ", year=" + year + ", genre="
				+ genre + ", publisher=" + publisher + "]";
	}

	public String imprimir() {
		return this.getRank() + ": " + this.getName() + ", Platform: " + this.getPlatform().name() + ", Año: "
				+ this.getYear() + ", Género: " + this.getGenre().name() + ", Editor: " + this.getPublisher();
	}

	public void createJuego() {
		try {
			// metemos el ranking para hacer pruebas, pero lo que habria que hacer es no
			// pedirselo al usuario,
			// sino detectar el ultimo numero de ranking en el array y sumarle 1 o algo asi
			this.rank = Datos.recogeInt("Introduce el numero de ranking");
			this.name = Datos.recogeString("Introduce el nombre del juego");
			EnumPlatform.Informe2();
			this.platform = EnumPlatform.dimeCategoria(Datos.recogeInt());
			this.year = String.valueOf(Datos.recogeInt("Introduce el año"));
			EnumGenre.Informe2();
			this.genre = EnumGenre.dimeCategoria(Datos.recogeInt());
			this.publisher = Datos.recogeString("Introduce el nombre del editor");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
