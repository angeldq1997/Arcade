package utils;

import model.ArcadeRoom;

public class View {
    public static int subMenuPlayer(ArcadeRoom arcadeRoom1, int MAXCHARACTERSPLAYER, int MAXCHARACTERSID){
        int subOption = 0;
        System.out.println("\t0. Salir\n\t1. Dar de alta Jugador.\n\t2. Dar baja jugador.\n\t3. Editar jugador.");
        subOption = Utils.readIntInRange(0, 3, "Introduzca opción a elegir: ", "Debe introducir un número entre 0 y 3.");
        switch (subOption) {
            case 0:
                System.out.println("Ha seleccionado salir de la administración de jugadores, volviendo al programa inicial.");
                break;

            case 1:
                System.out.println("Seleccione jugador a dar de alta: ");
                try {
                    arcadeRoom1.registerNewPlayer("Introduzca nombre del nuevo jugador: ", "Introduzca ID del nuevo jugador:", MAXCHARACTERSPLAYER, MAXCHARACTERSID);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("Seleccione jugador a dar de baja: ");
                try {
                    arcadeRoom1.removePlayer("Escriba nombre del jugador a eliminar: ", MAXCHARACTERSPLAYER);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                System.out.println("Seleccione jugador a editar: ");
                try {
                    arcadeRoom1.editPlayer("Introduzca nombre del ID del jugador a editar: ", "Introduzca nuevo nombre del jugador: ", "Introduzca nuevo ID del jugador: ", MAXCHARACTERSPLAYER, MAXCHARACTERSID);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("Error, ha seleccionado una opción incorrecta, inténtelo de nuevo.");
        }
    }
}
