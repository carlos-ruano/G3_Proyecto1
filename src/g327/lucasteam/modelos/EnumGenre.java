package g327.lucasteam.modelos;
/**
 * Creamos los enumerados de Genero
 * 
 * @see <a href="https://github.com/carlos-ruano/G3_Proyecto1"> GitHub
 *      G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */
public enum EnumGenre {

	ACTION(1), ADVENTURE(2), FIGHTING(3), MISC(4), PLATFORM(5), PUZZLE(6), RACING(7), ROLEPLAYING(8), SHOOTER(9),
	SIMULATION(10), SPORTS(11), STRATEGY(12);

	private final int codigo;
	private static final int size = EnumPlatform.values().length;
	/**
	 * Mediante esta función le damos un valor al enumerado
	 */
	EnumGenre(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * Mediante esta función se consigue el codigo de los enumerados
	 * @return codigo Devuelve el valor del enumerado
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * Mediante esta función conseguimos el tamaño de Enumerados
	 * @return size Devuelve el tamaño de Enumerados.
	 */
	public static int getSize() {
		return size;
	}

	private static EnumGenre[] values = null;
	/**
	 * Mediante esta función recogemos el enumerado que nos dan por consola
	 * 
	 * @param val Recoge el valor del enumerado que quiere
	 * @return values[val-1] Devuelve el enumerado
	 */
	public static EnumGenre dimeCategoria(int val) {
		if (EnumGenre.values == null) {
			EnumGenre.values = EnumGenre.values();
		}
		// System.out.println("--> " + Categorias.values[val]);
		return EnumGenre.values[val - 1];
	}
	/**
	 * Mediante esta función se imprimen los Enumerados
	 */
	public static void Informe1() {
		StringBuilder sb;
		for (EnumGenre cat : EnumGenre.values()) {
			sb = new StringBuilder();
			sb.append("Codigo 0").append(cat.codigo).append(": ").append(cat);
			System.out.println(sb);
		}
	}
	/**
	 * Mediante esta función se imprimen los Enumerados
	 */
	public static void Informe2() {
		StringBuilder sb;
		for (EnumGenre cat : EnumGenre.values()) {
			sb = new StringBuilder();
			sb.append("(").append(cat.codigo).append(")").append(cat).append("|");
			System.out.println(sb);
		}
	}
}
