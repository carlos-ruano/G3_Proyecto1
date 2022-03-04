package G3_Proyecto1.modelos;

public class Juego {

	private int rank;
	private String name;
	private EnumPlatform platform;
	private int year;
	private EnumGenre genre; //Cambiar en UML tiene puesto que es clase String
	private String publisher;
	public Juego() {
		super();
	}
	public Juego(int rank, String name, EnumPlatform platform, int year, EnumGenre genre, String publisher) {
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
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
	
	
	
}
