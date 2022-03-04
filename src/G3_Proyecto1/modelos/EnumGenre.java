package G3_Proyecto1.modelos;

public enum EnumGenre {

	ACTION(1), 
	ADVENTURE(2), 
	FIGHTING(3), 
	MISC(4), 
	PLATFORM(5), 
	PUZZLE(6), 
	RACING(7), 
	ROLEPLAYING(8), 
	SHOOTER(9),
	SIMULATION(10), 
	SPORTS(11), 
	STRATEGY(12);

	private final int codigo;
    private static final int size = EnumPlatform.values().length;

    EnumGenre(int codigo) {
		this.codigo=codigo;
	}
	public int getCodigo() {
        return codigo;
    }

    public static int getSize() {
        return size;
    }
    
    private static EnumGenre[] values = null;

    public static EnumGenre dimeCategoria(int val) {
        if (EnumGenre.values == null) {
        	EnumGenre.values = EnumGenre.values();
        }
        //System.out.println("--> " + Categorias.values[val]);
        return EnumGenre.values[val];
    }
    
    public static void Informe1() {
        StringBuilder sb;
        for (EnumGenre cat : EnumGenre.values()) {
            sb = new StringBuilder();
            sb.append("Codigo 0").
                    append(cat.codigo).
                    append(": ").
                    append(cat);
            System.out.println(sb);
        }
    }

    public static void Informe2() {
        StringBuilder sb;
        for (EnumGenre cat : EnumGenre.values()) {
            sb = new StringBuilder();
            sb.append("(").
                    append(cat.codigo).
                    append(")").
                    append(cat).
                    append("|");
            System.out.println(sb);
        }
    }
} 


