import model.ArcadeMachine;
import model.ArcadeRoom;
import model.Player;
import utils.Utils;
import utils.View;

public class Main {
    public static void main(String[] args) {

        //TAMAÑOS MÁXIMOS DE CARÁCTERES POR VERIFICACIÓN DE INTRODUCCIÓN DEL USUARIO.
        final int MAXCHARACTERSID = 9;
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

        final int MAXSCORE = 9999;

        //RELLENADO INICIAL DE DATOS ARRAY. Ya que no tenemos una forma actualmente de preservar la información con el
        //cierre y la apertura del programa.

        Player player1 = new Player("María Luisa", "32027371A", 100, 10);
        Player player2 = new Player("Antonio", "77777777A", 20, 0);
        Player player3 = new Player("John Kirby", "44444444A", 80, 5);
        Player player4 = new Player("Phoenix Wright", "33333333A", 0, 40);
        Player player5 = new Player("Dolores", "55555555A", 50, 99);

        ArcadeMachine arcadeMachine1 = new ArcadeMachine("Space Invaders", "Shoot' em Up", PRICEOLDMACHINES, 1978, "Taito");
        ArcadeMachine arcadeMachine2 = new ArcadeMachine("Street Fighter II", "Lucha", VERSUSORCOOPPRICE, 1991, "Capcom");
        ArcadeMachine arcadeMachine3 = new ArcadeMachine("Metal Slug", "Run and gun", VERSUSORCOOPPRICE, 1996, "Nazca Corporation");
        ArcadeMachine arcadeMachine4 = new ArcadeMachine("Pac-Man", "Laberinto", DELUXEPRICE, 1980, "Namco");
        ArcadeMachine arcadeMachine5 = new ArcadeMachine("Parodius", "Shoot' em Up", STANDARDPRICE, 1990,"Konami");
        ArcadeMachine arcadeMachine6 = new ArcadeMachine("Donkey Kong", "Plataformas", DELUXEPRICE, 1981,"Nintendo R&D1");
        ArcadeMachine arcadeMachine7 = new ArcadeMachine("Breakout", "Acción", LOWPRICE, 1976, "Atari");

        //INICIALIZACIÓN DE ARRAY DE JUGADORES Y MÁQUINAS ARCADE.
        Player[] players = {player1, player2, player3, player4, null, null, null, null, null, null};

        ArcadeMachine[] arcadeMachinesInRoom = {arcadeMachine1, arcadeMachine2, arcadeMachine3, arcadeMachine4, arcadeMachine5, arcadeMachine6, null, null, null, null};

        ArcadeRoom arcadeRoom1 = new ArcadeRoom(players, arcadeMachinesInRoom);

        int option = 0, subOption = 0;
        do {
            System.out.println("--- MENÚ RECREATIVAS ARCADIA ---\n\t0. SALIR.\n\t1. JUGAR UNA PARTIDA.\n\t2. ADMINISTRAR JUGADOR/ES.\n\t3. ADMINISTRAR MÁQUINA/S.\n\t4. ESTADÍSTICAS Y LISTADO.");
            option = Utils.readIntInRange(0, 4, "Introduzca opción a elegir: ", "Debe introducir un número entre 0 y 4.");
            switch (option) {
                case 0:
                    System.out.println("Ha seleccionado salir del programa, gracias por su tiempo.");
                    break;

                case 1:
                    System.out.println("¡Ha seleccionado jugar una partida!");
                    try {
                        arcadeRoom1.playMachine("Escriba el ID del jugador que va a jugar (números y letra): ", "Escriba el nombre de la máquina que va a usarse: ", MAXSCORE, MAXCHARACTERSID, MAXCHARACTERSARCADEMACHINE);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Ha seleccionado Administrar jugador/es, por favor seleccione opción a elegir:");
                    View.subMenuPlayer(arcadeRoom1, MAXCHARACTERSPLAYER, MAXCHARACTERSID);
                    break;

                case 3:
                    System.out.println("Ha seleccionado Administrar máquina/s, por favor seleccione opción a elegir:");
                    System.out.println("\t0. Salir\n\t1. Dar de alta Máquina Arcade.\n\t2. Dar baja Máquina Arcade.\n\t3. Editar Máquina Arcade.");
                    subOption = Utils.readIntInRange(0, 3, "Introduzca opción a elegir: ", "Debe introducir un número entre 0 y 3.");
                    switch (subOption){
                        case 0:
                            System.out.println("Ha seleccionado salir de la administración de máquinas, volviendo al programa inicial.");
                            break;

                        case 1:
                            System.out.println("Seleccione máquina a dar de alta: ");
                            try {
                                //Sería necesario un sistema para elegir una máquina a añadir, por ejemplo una array de máquinas no asignadas.
                                arcadeRoom1.registerNewMachine(arcadeMachine7);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 2:
                            System.out.println("Seleccione máquina a dar de baja: ");
                            try{
                                arcadeRoom1.removeMachine("Seleccione nombre de máquina a eliminar: ", MAXCHARACTERSARCADEMACHINE);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 3:
                            System.out.println("Seleccione máquina a editar: ");
                            try{
                                arcadeRoom1.editMachine("Introduzca nombre de la máquina a buscar: ", "Introduzca nombre modificado de la máquina", "Introduzca nombre del género a correjir: ", MAXCHARACTERSARCADEMACHINE);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        default:
                            System.out.println("Error, ha seleccionado una opción incorrecta, inténtelo de nuevo.");
                    }
                    break;
                default:
                    System.out.println("Error, ha seleccionado una opción incorrecta, inténtelo de nuevo.");
            }
        } while (option != 0);
    }
}