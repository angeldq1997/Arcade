package utils;

import model.ArcadeMachine;
import model.ArcadeRoom;
import model.Player;

public class View {
    /**
     * Menú principal con opciones que llevan a otros submenús.
     * @param arcadeRoom1 Sala recreativa principal que contiene jugadores y máquinas recreativas.
     * @param MAXCHARACTERSPLAYER Número de carácteres máximo del nombre del jugador.
     * @param MAXCHARACTERSID Número de carácteres máximo de la ID del jugador.
     * @param MAXCHARACTERSARCADEMACHINE Número de carácteres máximo de la máquina arcade.
     * @param MAXYEAR Año máximo permitido cuando se creó la máquina recreativa concreta.
     * @param MAXSCORE Puntuación máxima que puede conseguir un jugador.
     * @param MAXCREDITS Créditos máximos que puede ingresar un jugador.
     * @param MINCREDITS Créditos mínimos que debe ingresar el jugador.
     */
    public static void principalMenu(ArcadeRoom arcadeRoom1, int MAXCHARACTERSPLAYER, int MAXCHARACTERSID, int MAXCHARACTERSARCADEMACHINE, int MAXYEAR, int MAXSCORE, int MAXCREDITS, int MINCREDITS, int MINPRICE, int MAXPRICE) {
        int option = 0;
        do {
            System.out.println("\n--- MENÚ RECREATIVAS ARCADIA ---\n\t0. SALIR.\n\t1. JUGAR UNA PARTIDA.\n\t2. ADMINISTRAR JUGADOR/ES.\n\t3. ADMINISTRAR MÁQUINA/S.\n\t4. ESTADÍSTICAS Y LISTADO.");
            option = Utils.readIntInRange(0, 4, "Introduzca opción a elegir: ", "Debe introducir un número entre 0 y 4.");
            switch (option) {
                case 0:
                    System.out.println("Ha seleccionado salir del programa, gracias por su tiempo.");
                    break;

                case 1:
                    System.out.println("¡Ha seleccionado jugar una partida!");
                    try {
                        System.out.println("Ha conseguido una puntuación de: " + arcadeRoom1.playMachine("Escriba el ID del jugador que va a jugar (números y letra): ", "Escriba el nombre de la máquina que va a usarse: ", MAXSCORE, MAXCHARACTERSID, MAXCHARACTERSARCADEMACHINE));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    subMenuPlayer(arcadeRoom1, MAXCHARACTERSPLAYER, MAXCHARACTERSID, MINCREDITS, MAXCREDITS);
                    break;

                case 3:
                    subMenuMachine(arcadeRoom1, MAXCHARACTERSARCADEMACHINE, MAXYEAR, MINPRICE, MAXPRICE);
                    break;

                case 4:
                    subMenuStatistics(arcadeRoom1, MAXCHARACTERSARCADEMACHINE);
                    break;
                default:
                    System.out.println("Error, ha seleccionado una opción incorrecta, inténtelo de nuevo.");
            }
        } while (option != 0);
    }

    /**
     * Submenú de Jugadores con las opciones que les concierne, como dar de alta, baja, editar jugadores y cargar créditos de estos.
     * @param arcadeRoom1 Sala recreativa principal que contiene jugadores y máquinas recreativas.
     * @param MAXCHARACTERSPLAYER Número de carácteres máximo del nombre del jugador.
     * @param MAXCHARACTERSID Número de carácteres máximo de la ID del jugador.
     * @param maxCredits Créditos máximos que puede ingresar un jugador.
     * @param minCredits Créditos mínimos que debe ingresar el jugador.
     */
    private static void subMenuPlayer(ArcadeRoom arcadeRoom1, int MAXCHARACTERSPLAYER, int MAXCHARACTERSID, int minCredits, int maxCredits) {
        int subOption = 0;
        do {
            System.out.println("Ha seleccionado Administrar jugador/es, por favor seleccione opción a elegir:");
            System.out.println("\t0. Salir de administración de jugadores.\n\t1. Dar de alta Jugador.\n\t2. Dar baja jugador.\n\t3. Editar jugador.\n\t4. Cargar créditos jugador.");
            subOption = Utils.readIntInRange(0, 4, "Introduzca opción a elegir: ", "Debe introducir un número entre 0 y 4.");
            switch (subOption) {
                case 0:
                    System.out.println("Ha seleccionado salir de la administración de jugadores, volviendo al programa inicial.");
                    break;

                case 1:
                    try {
                        Player definedPlayer = Utils.definePlayer("Introduzca nombre del nuevo jugador: ", "Introduzca ID del nuevo jugador:", MAXCHARACTERSPLAYER, MAXCHARACTERSID);
                        arcadeRoom1.registerNewPlayer(definedPlayer);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Jugador registrado correctamente, esperamos que disfrute su tiempo aquí.");
                    break;

                case 2:
                    try {
                        arcadeRoom1.removePlayer("Escriba ID del jugador a eliminar: ", MAXCHARACTERSPLAYER);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Se ha borrado correctamente el jugador.");
                    break;

                case 3:
                    try {
                        arcadeRoom1.editPlayer("Introduzca nombre del ID del jugador a editar: ", "Introduzca nuevo nombre del jugador: ", "Introduzca nuevo ID del jugador: ", MAXCHARACTERSPLAYER, MAXCHARACTERSID);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Se ha editado correctamente el jugador seleccionado.");
                    break;

                case 4:
                    try {
                        String idPlayerToFind = Utils.verifyString("Introduzca ID del jugador para cargar créditos: ", MAXCHARACTERSID);
                        arcadeRoom1.getPlayers()[arcadeRoom1.findPlayerByID(idPlayerToFind)].rechargeCredits(Utils.readIntInRange(minCredits, maxCredits, "Introduzca créditos a recargar: ", "Ha introducido un número de créditos inválido, inténtelo de nuevo."));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Créditos cargados correctamente. Disfrute las partidas. :)");
                    break;

                default:
                    System.out.println("Error, ha seleccionado una opción incorrecta, inténtelo de nuevo.");
            }
        } while (subOption != 0);
    }

    /**
     *
     * @param arcadeRoom1 Sala recreativa principal que contiene jugadores y máquinas recreativas.
     * @param MAXCHARACTERSARCADEMACHINE Número máximo de carácteres de la máquina arcade.
     * @param maxYear Número máximo del año en el que se creó la máquina.
     */
    private static void subMenuMachine(ArcadeRoom arcadeRoom1, int MAXCHARACTERSARCADEMACHINE, int maxYear, int minPrice, int maxPrice) {
        int subOption = 0;
        do {
            System.out.println("Ha seleccionado Administrar máquina/s, por favor seleccione opción a elegir:");
            System.out.println("\t0. Salir de administración de máquinas.\n\t1. Dar de alta Máquina Arcade.\n\t2. Dar baja Máquina Arcade.\n\t3. Editar Máquina Arcade.\n\t4. Realizar mantenimiento a una máquina.");
            subOption = Utils.readIntInRange(0, 4, "Introduzca opción a elegir: ", "Debe introducir un número entre 0 y 4.");
            switch (subOption) {
                case 0:
                    System.out.println("Ha seleccionado salir de la administración de máquinas, volviendo al programa inicial.");
                    break;

                case 1:
                    try {
                        ArcadeMachine definedArcadeMachine = Utils.defineMachine(MAXCHARACTERSARCADEMACHINE, maxYear, minPrice, maxPrice);
                        arcadeRoom1.registerNewMachine(definedArcadeMachine);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        arcadeRoom1.removeMachine("Seleccione nombre de máquina a dar de baja: ", MAXCHARACTERSARCADEMACHINE);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Se ha borrado satisfactoriamente la máquina seleccionada.");
                    break;

                case 3:
                    try {
                        ArcadeMachine editedMachine = Utils.defineMachine(MAXCHARACTERSARCADEMACHINE, maxYear, minPrice, maxPrice);
                        arcadeRoom1.editMachine(editedMachine, "Introduzca nombre de la máquina a buscar", MAXCHARACTERSARCADEMACHINE);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        String nameMachineMaintenance = Utils.verifyString("Introduzca nombre de la máquina para realizar su mantenimiento:", MAXCHARACTERSARCADEMACHINE);
                        arcadeRoom1.getArcadeMachines()[arcadeRoom1.findMachineByName(nameMachineMaintenance)].modifyActivationMachine(true);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                default:
                    System.out.println("Error, ha seleccionado una opción incorrecta, inténtelo de nuevo.");
            }
        } while (subOption != 0);
    }

    /**
     * Menú para mostrar estadísticas a los usuarios.
     * @param arcadeRoom1 Sala recreativa principal a medir.
     * @param MAXCHARACTERSARCADEMACHINE Número máximo de carácteres del nombre de una máquina arcade.
     */
    private static void subMenuStatistics(ArcadeRoom arcadeRoom1, int MAXCHARACTERSARCADEMACHINE) {
        int subOption = 0;
        do {
            System.out.println("Ha seleccionado Estadísticas y Listados, por favor seleccione opción a elegir:");
            System.out.println("\t0. Salir de estadísticas y listados.\n\t1. Listado de jugadores.\n\t2. Listado máquinas.\n\t3. Listado máquinas ACTIVAS." +
                    "\n\t4. Ver jugador más activo.\n\t5. Ver máquina más jugada.\n\t6. Ver ranking de una máquina a seleccionar.");
            subOption = Utils.readIntInRange(0, 6, "Introduzca opción a elegir: ", "Debe introducir un número entre 0 y 6.");
            switch (subOption) {
                case 0:
                    System.out.println("Ha seleccionado salir de Estadísticas y Listados, volviendo al programa inicial.");
                    break;

                case 1:
                    System.out.println("LISTADO DE JUGADORES:\n" + arcadeRoom1.listPlayers());
                    break;

                case 2:
                    System.out.println("LISTADO DE MÁQUINAS:\n" + arcadeRoom1.listMachines());
                    break;

                case 3:
                    System.out.println("LISTADO DE MÁQUINAS ACTIVAS:\n" + arcadeRoom1.listActiveMachines());
                    break;

                case 4:
                    System.out.println("JUGADOR MÁS ACTIVO:\n" + arcadeRoom1.mostActivePlayer());
                    break;

                case 5:
                    System.out.println("MÁQUINA MÁS ACTIVA:\n" + arcadeRoom1.mostActiveMachine());
                    break;

                case 6:
                    try {
                        String nameMachineRanking = Utils.verifyString("Introduzca nombre máquina para ver el ranking: ", MAXCHARACTERSARCADEMACHINE);
                        System.out.println(arcadeRoom1.getArcadeMachines()[arcadeRoom1.findMachineByName(nameMachineRanking)].getRankingScore());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Error, ha seleccionado una opción incorrecta, inténtelo de nuevo.");
            }
        } while (subOption != 0);
    }
}