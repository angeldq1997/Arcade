package model;

import utils.Utils;

public class ArcadeRoom {
    Player[] players;
    ArcadeMachine[] arcadeMachines;

    /**
     * Constructor de sala recreativa. Requiere array de jugadores y de máquinas arcade.
     * @param players        Array de jugadores de la sala recreativa.
     * @param arcadeMachines Array de máquinas arcade de la sala recreativa.
     */
    public ArcadeRoom(Player[] players, ArcadeMachine[] arcadeMachines) {
        this.players = players;
        this.arcadeMachines = arcadeMachines;
    }

    public ArcadeRoom() {
        this.players = null;
        this.arcadeMachines = null;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public ArcadeMachine[] getArcadeMachines() {
        return this.arcadeMachines;
    }

    /**
     * Función para buscar una máquina por nombre.
     * @param machineName Nombre de la máquina a buscar.
     * @return Devuelve la posición de la máquina en el array de máquinas de la sala recreativa concreta.
     */
    public int findMachineByName(String machineName) {
        boolean isMachineFound = false;
        int machinePosition = 0;
        for (int i = 0; i < this.arcadeMachines.length && !isMachineFound; i++) {
            if (this.arcadeMachines[i] !=null && this.arcadeMachines[i].getName().equalsIgnoreCase(machineName)) {
                isMachineFound = true;
                machinePosition = i;
            }
        }
        return machinePosition;
    }

    /**
     * Función para encontrar a un jugador a partir de su ID.
     * @param idToFind id a buscar del jugador en el array.
     * @return La posición del jugador en el array.
     * @throws Exception Lanza excepción si no se encuentra al jugador con la id que se ha introducido.
     */
    public int findPlayerByID(String idToFind) throws Exception {
        boolean isPlayerFound = false;
        int playerPosition = -1;
        for (int i = 0; i < this.players.length && !isPlayerFound; i++) {
            if (this.players[i] !=null && this.players[i].getId().equalsIgnoreCase(idToFind)) {
                isPlayerFound = true;
                playerPosition = i;
            }
        }
        if (playerPosition==-1){
            throw new Exception("No se ha encontrado al jugador con la ID introducida.");
        }
        return playerPosition;
    }

    /**
     * Elimina una máquina arcade poniéndola a null, para ello la busca mediante su nombre escrito por el usuario.
     * @param message Mensaje a introducir antes de pedir el nombre de la máquina arcade.
     * @param MAXCHARACTERSMACHINE Número máximo de caracteres que tiene una máquina.
     * @return True si se ha podido eliminar y false, si no se ha podido.
     * @throws Exception Lanza una excepción si se introduce un nombre no válido a buscar u otra diferente si no existe dicha máquina en el sistema.
     */
    public boolean removeMachine(String message, int MAXCHARACTERSMACHINE) throws Exception {
        boolean removeSuccessful = false;
        int machinePosition = -1;
        String machineSelected = Utils.verifyString(message, MAXCHARACTERSMACHINE);
        machinePosition = this.findMachineByName(machineSelected);
        if (machinePosition != -1) {
            this.arcadeMachines[machinePosition] = null;
            removeSuccessful = true;
        } else{
            throw new Exception("Error, ha introducido una máquina que no existe en el sistema.");
        }
        return removeSuccessful;
    }

    /**
     * Función que elimina un jugador concreto cambiando su valor a null, lo busca mediante su ID.
     * @param message Mensaje a introducir antes de pedir el ID del jugador.
     * @param MAXCHARACTERSPLAYER Número máximo de carácteres del jugador.
     * @return True si se ha podido eliminar y false si no ha podido.
     * @throws Exception Si se introduce un ID no válida o si no existe el jugador en el sistema.
     */
    public boolean removePlayer(String message, int MAXCHARACTERSPLAYER) throws Exception {
        boolean removeSuccessful = false;
        int playerPosition = -1;
        String playerSelected = Utils.verifyString(message, MAXCHARACTERSPLAYER);
        playerPosition = this.findPlayerByID(playerSelected);
        if (playerPosition != -1) {
            this.arcadeMachines[playerPosition] = null;
            removeSuccessful = true;
        }else{
            throw new Exception("Error, ha introducido un ID que no existe en el sistema.");
        }
        return removeSuccessful;
    }

    /**
     * Función que permite ingresar un nuevo jugador al array.
     * @param definedPlayer Jugador definido en otra función que se inserta en el array.
     * @return True si se ha podido registrar y false si no ha podido completarse.
     * @throws Exception Lanza excepción si no se ha podido registrar al jugador.
     */
    public boolean registerNewPlayer(Player definedPlayer) throws Exception {
        boolean registerSuccessful = false;
        if(Utils.isANullInArray(this.players)){
            for (int i = 0; i < this.players.length && !registerSuccessful; i++) {
                if (players[i].getId() == "NONE" || players[i] == null) {
                    players[i] = definedPlayer;
                    registerSuccessful = true;
                }
            }
        }else{
            throw new Exception("Error, no se puede registrar a un jugador ya que el registro está completo.");
        }
        return registerSuccessful;
    }

    /**
     * Función que registra una máquina nueva, pidiendo al usuario su nombre, género, entre otros datos.
     * @param definedArcadeMachine Máquina arcade definida por otra función que se insertará en el array.
     * @return True si ha registrado la máquina correctamente y false si no ha podido.
     * @throws Exception Lanza excepción cuando está el array de máquinas completo.
     */
    public boolean registerNewMachine(ArcadeMachine definedArcadeMachine) throws Exception {
        boolean registerSuccessful = false;
        if(Utils.isANullInArray(this.arcadeMachines)){
            for (int i = 0; i < this.arcadeMachines.length; i++) {
                if (arcadeMachines[i].getName() == "Máquina desconocida" || arcadeMachines[i] == null) {
                    arcadeMachines[i] = definedArcadeMachine;
                    registerSuccessful = true;
                }
            }
        }else{
            throw new Exception("Error, no se puede registrar ninguna máquina, el registro está completo.");
        }
        return registerSuccessful;
    }

    /**
     * Función para editar un jugador de la sala recreativa.
     * @param messageSearchIdPlayer Mensaje a mostrar antes de buscar un ID de jugador concreto.
     * @param messageName Mensaje a mostrar al pedir el nombre nuevo a asignar.
     * @param messageId Mensaje a mostrar al pedir el ID nuevo a asignar.
     * @param MAXCHARACTERSNAME Máximo número de caracteres del jugador editado.
     * @param MAXCHARACTERSID Máximo número de caracteres del ID editado.
     * @return True si ha podido editarse y false si no ha sido posible.
     * @throws Exception Lanza excepción si hay un fallo al modificar el jugador.
     */
    public boolean editPlayer(String messageSearchIdPlayer, String messageName, String messageId, int MAXCHARACTERSNAME, int MAXCHARACTERSID) throws Exception {
        int playerPosition = -1;
        boolean editedPlayer = false;
        String idPlayerToSearch = Utils.verifyString(messageSearchIdPlayer, MAXCHARACTERSNAME);
        playerPosition = this.findPlayerByID(idPlayerToSearch);
        if (playerPosition != -1) {
            Utils.modifyPlayer(this.players[playerPosition], messageId, messageName, MAXCHARACTERSID, MAXCHARACTERSNAME);
            editedPlayer = true;
        }
        return editedPlayer;
    }

    /**
     * Función que edita una máquina existente modificando sus datos.
     * @param machineToEdit Máquina a editar.
     * @param messageSearchMachine Mensaje para pedir nombre de la máquina a buscar.
     * @param MAXCHARACTERSMACHINE Máximo número de caracteres que puede tener una máquina.
     * @return Devuelve la máquina arcade ya modificada.
     * @throws Exception Lanza excepción si no se introduce correctamente un nombre de la máquina a buscar.
     */
    public ArcadeMachine editMachine(ArcadeMachine machineToEdit, String messageSearchMachine, int MAXCHARACTERSMACHINE) throws Exception {
        int machinePosition = -1;
        ArcadeMachine editedMachine = new ArcadeMachine();
        String nameMachineToSearch = Utils.verifyString(messageSearchMachine, MAXCHARACTERSMACHINE);
        machinePosition = this.findMachineByName(nameMachineToSearch);
        if (machinePosition != -1) {
           editedMachine = machineToEdit;
        }
        return editedMachine;
    }

    /**
     * Función que muestra los jugadores de una arcade.
     * @return Devuelve una cadena con todos los jugadores de una arcade.
     */
    public String listPlayers() {
        String playerList = null;
        for (int i = 0; i < this.players.length; i++) {
            if(this.players[i] !=null) {
                playerList += (this.players[i].getName() + " ");
            }
        }
        return playerList;
    }

    /**
     * Función que muestra una lista de máquinas activas o no.
     * @return Devuelve una cadena con todas las máquinas de una sala recreativa.
     */
    public String listMachines() {
        String machineList = null;
        for (int i = 0; i < this.arcadeMachines.length; i++) {
            if(this.arcadeMachines[i] !=null) {
                machineList += (this.arcadeMachines[i].getName() + " ");
            }
        }
        return machineList;
    }

    /**
     * Función que muestra una lista de máquinas incluyendo solo las activas.
     * @return Devuelve una cadena con las máquinas activas.
     */
    public String listActiveMachines() {
        String activeMachineList = null;
        for (int i = 0; i < this.arcadeMachines.length; i++) {
            if (this.arcadeMachines[i].isActivated()) {
                activeMachineList += (this.arcadeMachines[i].getName() + " ");
            }
        }
        return activeMachineList;
    }

    /**
     * Función que muestra el jugador más activo de la sala recreativa.
     * @return Devuelve el objeto jugador que más veces ha usado una recreativa.
     */
    public Player mostActivePlayer() {
        Player mostActivePlayer = null;
        int arcadesPlayed = 0;
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i].getGamesPlayed() > arcadesPlayed) {
                arcadesPlayed = this.players[i].getGamesPlayed();
                mostActivePlayer = this.players[i];
            }
        }
        return mostActivePlayer;
    }

    /**
     * Función para mostrar la máquina más usada
     * @return El objeto máquina arcade que más han jugado.
     */
    public ArcadeMachine mostActiveMachine() {
        ArcadeMachine mostActiveMachine = null;
        int arcadePlayedRuns = 0;
        for (int i = 0; i < this.arcadeMachines.length; i++) {
            if (this.arcadeMachines[i].getTimesPlayed() > arcadePlayedRuns) {
                arcadePlayedRuns = this.arcadeMachines[i].getTimesPlayed();
                mostActiveMachine = this.arcadeMachines[i];
            }
        }
        return mostActiveMachine;
    }

    //NO LO HE USADO
    private boolean existPlayer(Player player) {
        boolean exist = false;
        for (int i = 0; i < this.players.length && !exist; i++) {
            if (this.players[i] != null && this.players[i].equals(player)) {
                exist = true;
            }
        }
        return exist;
    }

    //NO LO HE USADO
    private boolean existMachine(ArcadeMachine arcadeMachine) {
        boolean exist = false;
        for (int i = 0; i < this.arcadeMachines.length && !exist; i++) {
            if (this.arcadeMachines[i] != null && this.arcadeMachines[i].equals(arcadeMachine)) {
                exist = true;
            }
        }
        return exist;
    }

    /**
     * Función para jugar con un jugador a una máquina concreta.
     * @param messagePlayerId Mensaje para pedir ID del jugador que jugará.
     * @param messageMachine Mensaje para pedir el nombre de la máquina a usar.
     * @param MAXSCORE Puntuación máxima que puede obtener el jugador.
     * @param MAXCHARACTERSID Máximo número de caracteres que puede tener el ID del jugador.
     * @param MAXCHARACTERSMACHINENAME Máximo número de caracteres que puede tener la máquina.
     * @return La puntuación obtenida.
     * @throws Exception Lanza excepción si la máquina está desactivada.
     */
    public int playMachine(String messagePlayerId, String messageMachine, int MAXSCORE, int MAXCHARACTERSID, int MAXCHARACTERSMACHINENAME) throws Exception {
        int score = Utils.genRandomNumber(MAXSCORE);
        String playerSelected = Utils.verifyString(messagePlayerId, MAXCHARACTERSID);
        Player activePlayer = this.players[this.findPlayerByID(playerSelected)];

        String machineSelected = Utils.verifyString(messageMachine, MAXCHARACTERSMACHINENAME);
        ArcadeMachine arcadeMachineToPlay = this.arcadeMachines[this.findMachineByName(machineSelected)];

        if (arcadeMachineToPlay.isActivated()) {
            arcadeMachineToPlay.addPlayTimeToMachine();
            activePlayer.spendCredits(arcadeMachineToPlay.getPricePerPlay());
            activePlayer.incrementTimesArcadePlayed();
            arcadeMachineToPlay.storeScore(activePlayer, score);
        } else {
            throw new Exception("Error, no se puede jugar la máquina está desactivada, por favor actívela antes de iniciar partida.");
        }
        return score;
    }
}
