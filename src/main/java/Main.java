import model.ArcadeMachine;
import model.ArcadeRoom;
import model.Player;
import utils.Utils;

public class Main {
    public static void main(String[] args) {

        //TAMAÑOS MÁXIMOS DE CARÁCTERES POR VERIFICACIÓN DE INTRODUCCIÓN DEL USUARIO.
        final int MAXCHARACTERSID = 3;
        final int MAXCHARACTERSPLAYER = 20;
        final int MAXCHARACTERSARCADEMACHINE = 30;

        //TAMAÑOS DE ARRAY DE JUGADORES Y MÁQUINAS ARCADE.
        final int SIZEARRAYPLAYERS = 10;
        final int SIZEARRAYARCADEMACHINES = 10;

        //PRECIO CRÉDITOS MÁQUINAS ARCADE.
        final int LOWPRICE = 5;
        final int PRICEOLDMACHINES = 8;
        final int STANDARDPRICE = 10;
        final int VERSUSORCOOPPRICE = 20;
        final int DELUXEPRICE = 30;

        //INICIALIZACIÓN DE ARRAY DE JUGADORES Y MÁQUINAS ARCADE.
        Player[] players = new Player[SIZEARRAYPLAYERS];
        ArcadeMachine[] arcadeMachines = new ArcadeMachine[SIZEARRAYARCADEMACHINES];

        //RELLENADO INICIAL DE DATOS ARRAY. Ya que no tenemos una forma actualmente de preservar la información con el
        //cierre y la apertura del programa.

        Player player1 = new Player("María Luisa", "1A", 100, 10);
        Player player2 = new Player("Antonio", "2A", 20, 0);
        Player player3 = new Player("John Kirby", "3A", 80, 5);
        Player player4 = new Player("Phoenix Wright", "4A", 0, 40);
        Player player5 = new Player("Dolores", "5A", 50, 99);

        ArcadeMachine arcadeMachine1 = new ArcadeMachine("Space Invaders", "Shoot' em Up", PRICEOLDMACHINES);
        ArcadeMachine arcadeMachine2 = new ArcadeMachine("Street Fighter II", "Lucha", VERSUSORCOOPPRICE);
        ArcadeMachine arcadeMachine3 = new ArcadeMachine("Metal Slug", "Acción/Plataformas", VERSUSORCOOPPRICE);
        ArcadeMachine arcadeMachine4 = new ArcadeMachine("Pac-Man", "Laberinto", DELUXEPRICE);
        ArcadeMachine arcadeMachine5 = new ArcadeMachine("Parodius", "Shoot' em Up", STANDARDPRICE);
        ArcadeMachine arcadeMachine6 = new ArcadeMachine("Donkey Kong", "Plataformas", DELUXEPRICE);
        ArcadeMachine arcadeMachine7 = new ArcadeMachine("Breakout", "Acción", LOWPRICE);

        ArcadeRoom arcadeRoom = new ArcadeRoom(players, arcadeMachines);

        int option = 0;
        do {
            System.out.println("--- MENÚ RECREATIVAS ARCADIA ---\n\t0. SALIR\n\t1. JUGAR UNA PARTIDA.\n\t2. ADMINISTRAR JUGADOR/ES\n\t3. ADMINISTRAR MÁQUINA/S\n\t4. ESTADÍSTICAS Y LISTADO");
            option = Utils.readIntInRange(0, 4, "Introduzca opción a elegir: ", "Debe introducir un número entre 0 y 4.");
            switch (option) {
                case 0:
                    System.out.println("Ha seleccionado salir del programa, gracias por su tiempo.");
                    break;
                case 1:
                    System.out.println("Escriba el nombre de la máquina a jugar: ");
                    try {
                        String machineSelected = Utils.verifyString(MAXCHARACTERSARCADEMACHINE);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    // TODO: ArcadeMachine arcadeMachine
                    break;
                default:
                    System.out.println("Error, ha introducido un carácter no válido, inténtelo de nuevo.");
            }
        } while (option != 0);
    }
}