package G3_Proyecto1.control;

import G3_Proyecto1.servicios.LucasteamService;
import G3_Proyecto1.servicios.LucasteamServiceImpl;
import G3_Proyecto1.utilidades.Datos;
import G3_Proyecto1.gui.Menu;
public class Lucasteam {
	
	private LucasteamService services = new LucasteamServiceImpl();

    public void abrirLucasteam() {
        boolean seguir = true;
        do {
            Menu.mostrarMenu();
            seguir = this.seleccionOpciones();
        } while (seguir);
        System.out.println("   --- Fin de la sesion ---");
    }

    public boolean seleccionOpciones() {

        boolean continuar = true;

        try {
            switch (Datos.recogeInt()) {
                case 1:
                    //IMPORTAR LISTADO DE JUEGOS
                    //services.setListado();
                    break;

                case 2:
                    //LISTAR TODOS LOS JUEGOS
                    //services.listarJuegos();
                    break;

                case 3:
                    //FILTRAR POR GENERO PLATAFORMA
                    //services.filtrarByGenrePlatform();
                    break;

                case 4:
                    //DAR DE ALTA UN JUEGO
                    //services.addJuego();
                    break;

                case 0:
                    continuar = salir();
                    break;
            }
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        }
        return continuar;
    }

    private boolean salir() throws Exception {
        String sino = Datos.recogeString("   ¿Está seguro?(S/N)");
        return (sino.toUpperCase().charAt(0) != 'S');
    }


}
