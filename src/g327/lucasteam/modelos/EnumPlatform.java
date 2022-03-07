package g327.lucasteam.modelos;

/**
 * Creamos los enumerados de Plataforma
 * 
 * @see <a href="https://github.com/carlos-ruano/G3_Proyecto1"> GitHub
 *      G3_Proyecto1</a>
 * @author Equipo 3
 * @version 0.1
 *
 */
public enum EnumPlatform {

	// Mirar el 3DO y 3DS, no me deja y pongo TRES_DO y TRES_DS
	ATARI2600(1), _3DO(2), _3DS(3), DC(4), DS(5), GB(6), GBA(7), GC(8), GEN(9), GG(10), N64(11), NES(12), NG(13),
	PC(14), PCFX(15), PS(16), PS2(17), PS3(18), PS4(19), PSP(20), PSV(21), SAT(22), SCD(23), SNES(24), TG16(25),
	WII(26), WIIU(27), WS(28), X360(29), XB(30), XONE(31), _2600(32);

	private final int codigo;
	private static final int size = EnumPlatform.values().length;

	/**
	 * Mediante esta función le damos un valor al enumerado
	 */
	EnumPlatform(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Mediante esta función se consigue el codigo de los enumerados
	 * 
	 * @return codigo Devuelve el valor del enumerado
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Mediante esta función conseguimos el tamaño de Enumerados
	 * 
	 * @return size Devuelve el tamaño de Enumerados.
	 */
	public static int getSize() {
		return size;
	}

	private static EnumPlatform[] values = null;

	/**
	 * Mediante esta función recogemos el enumerado que nos dan por consola
	 * 
	 * @param val Recoge el valor del enumerado que quiere
	 * @return values[val-1] Devuelve el enumerado
	 */
	public static EnumPlatform dimeCategoria(int val) {
		if (EnumPlatform.values == null) {
			EnumPlatform.values = EnumPlatform.values();
		}
		// System.out.println("--> " + Categorias.values[val]);
		return EnumPlatform.values[val - 1];
	}

	/**
	 * Mediante esta función se imprimen los Enumerados
	 */
	public static void Informe1() {
		StringBuilder sb;
		for (EnumPlatform cat : EnumPlatform.values()) {
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
		for (EnumPlatform cat : EnumPlatform.values()) {
			sb = new StringBuilder();
			sb.append("(").append(cat.codigo).append(")").append(cat).append("|");
			System.out.println(sb);
		}
	}
}
