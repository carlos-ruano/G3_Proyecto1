package G3_Proyecto1.modelos;


import G3_Proyecto1.utilidades.Datos;

public class Juego {

	private int rank;
	private String name;
	private EnumPlatform platform;
	private String year;
	private EnumGenre genre; //Cambiar en UML tiene puesto que es clase String
	private String publisher;
	public Juego() {
		super();
	}
	public Juego(int rank, String name, EnumPlatform platform, String year, EnumGenre genre, String publisher) {
		super();
		this.rank = rank;
		this.name = name;
		this.platform = platform;
		this.year = year;
		this.genre = genre;
		this.publisher = publisher;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EnumPlatform getPlatform() {
		return platform;
	}
	public void setPlatform(EnumPlatform platform) {
		this.platform = platform;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public EnumGenre getGenre() {
		return genre;
	}
	public void setGenre(EnumGenre genre) {
		this.genre = genre;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Juego [rank=" + rank + ", name=" + name + ", platform=" + platform + ", year=" + year + ", genre="
				+ genre + ", publisher=" + publisher + "]";
	}
	
	public String imprimir() {
		return this.getRank()+": "+this.getName()+", Platform: "
				+this.getPlatform().name()+", Año: "
				+this.getYear()+", Género: "+this.getGenre().name()
				+", Editor: "+this.getPublisher();
	}
	
	
	public void createJuego() {
		try {
			//metemos el ranking para hacer pruebas, pero lo que habria que hacer es no pedirselo al usuario,
			//sino detectar el ultimo numero de ranking en el array y sumarle 1 o algo asi
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
	
	
	

