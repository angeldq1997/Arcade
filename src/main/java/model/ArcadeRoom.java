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

    public Player[] getPlayers() {
        return this.players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public ArcadeMachine[] getArcadeMachines() {
        return this.arcadeMachines;
    }

    public void setArcadeMachines(ArcadeMachine[] arcadeMachines) {
        this.arcadeMachines = arcadeMachines;
    }

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
     * @param idToFind ID a buscar del jugador en el array.
     * @return La posición del jugador en el array.
     * @throws Exception Lanza excepción si no se encuentra al jugador con la ID introducida.
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
     * Elimina una máquina arcade poniendola a null, para ello la busca mediante su nombre escrito por el usuario.
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
     * @param messageName
     * @param messageId
     * @param maxCharacterName
     * @param maxCharacterId
     * @return
     * @throws Exception
     */
    public boolean registerNewPlayer(String messageName, String messageId, int maxCharacterName, int maxCharacterId) throws Exception {
        boolean registerSuccessful = false;
        for (int i = 0; i < this.players.length && !registerSuccessful; i++) {
            if (players[i].getId() == "NONE" || players[i] == null) {
                players[i].setName(Utils.verifyString(messageName, maxCharacterName));
                players[i].setId(Utils.verifyString(messageId, maxCharacterId));
                registerSuccessful = true;
            }
        }
        return registerSuccessful;
    }

    public boolean registerNewMachine(String messageName, String messageGenre,int MAXCHARACTERNAMEMACHINE) throws Exception {
        boolean registerSuccessful = false;
        for (int i = 0; i < this.arcadeMachines.length; i++) {
            if (arcadeMachines[i].getName() == "Máquina desconocida" || arcadeMachines[i] == null) {
                arcadeMachines[i].setName(Utils.verifyString(messageName, MAXCHARACTERNAMEMACHINE));
                arcadeMachines[i].setGenre(Utils.verifyString(messageGenre, MAXCHARACTERNAMEMACHINE));
                arcadeMachines[i].setGenre(Utils.verifyString(messageGenre, MAXCHARACTERNAMEMACHINE));
                registerSuccessful = true;
            }
        }
        return registerSuccessful;
    }

    public boolean editPlayer(String messageSearchIdPlayer, String messageName, String messageId, int MAXCHARACTERSNAME, int MAXCHARACTERSID) throws Exception {
        int playerPosition = -1;
        boolean editedPlayer = false;
        String idPlayerToSearch = Utils.verifyString(messageSearchIdPlayer, MAXCHARACTERSNAME);
        playerPosition = this.findPlayerByID(idPlayerToSearch);
        if (playerPosition != -1) {
            this.players[playerPosition].setName(Utils.verifyString(messageName, MAXCHARACTERSNAME));
            this.players[playerPosition].setId(Utils.verifyString(messageId, MAXCHARACTERSID));
            editedPlayer = true;
        }
        return editedPlayer;
    }

    public boolean editMachine(String messageSearchMachine, String messageName, String messageGenre, int maxYear,String messageReleaseYear, int MAXCHARACTERSMACHINE, int minPrice, int maxPrice, String messagePrice, String messageError) throws Exception {
        int machinePosition = -1;
        boolean editedMachine = false;
        String nameMachineToSearch = Utils.verifyString(messageSearchMachine, MAXCHARACTERSMACHINE);
        machinePosition = this.findMachineByName(nameMachineToSearch);
        if (machinePosition != -1) {
            this.arcadeMachines[machinePosition].setName(Utils.verifyString(messageName, MAXCHARACTERSMACHINE));
            this.arcadeMachines[machinePosition].setGenre(Utils.verifyString(messageGenre, MAXCHARACTERSMACHINE));
            this.arcadeMachines[machinePosition].setReleasedYear(Utils.readIntInRange(1950, maxYear, messageReleaseYear, messageError));
            this.arcadeMachines[machinePosition].setPricePerPlay(Utils.readIntInRange(minPrice, maxPrice, messagePrice, messageError));
            editedMachine = true;
        }
        return editedMachine;
    }

    public String listPlayers() {
        String playerList = null;
        for (int i = 0; i < this.players.length; i++) {
            if(this.players[i] !=null) {
                playerList += (this.players[i].getName() + " ");
            }
        }
        return playerList;
    }

    public String listMachines() {
        String machineList = null;
        for (int i = 0; i < this.arcadeMachines.length; i++) {
            if(this.arcadeMachines[i] !=null) {
                machineList += (this.arcadeMachines[i].getName() + " ");
            }
        }
        return machineList;
    }

    public String listActiveMachines() {
        String activeMachineList = null;
        for (int i = 0; i < this.arcadeMachines.length; i++) {
            if (this.arcadeMachines[i].isActivated()) {
                activeMachineList += (this.arcadeMachines[i].getName() + " ");
            }
        }
        return activeMachineList;
    }

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

    private boolean existPlayer(Player player) {
        boolean exist = false;
        for (int i = 0; i < this.players.length && !exist; i++) {
            if (this.players[i] != null && this.players[i].equals(player)) {
                exist = true;
            }
        }
        return exist;
    }

    private boolean existMachine(ArcadeMachine arcadeMachine) {
        boolean exist = false;
        for (int i = 0; i < this.arcadeMachines.length && !exist; i++) {
            if (this.arcadeMachines[i] != null && this.arcadeMachines[i].equals(arcadeMachine)) {
                exist = true;
            }
        }
        return exist;
    }

    public int playMachine(String messagePlayer, String messageMachine, int MAXSCORE, int MAXCHARACTERSID, int MAXCHARACTERSMACHINENAME) throws Exception {
        int score = Utils.genRandomNumber(MAXSCORE);
        String playerSelected = Utils.verifyString(messagePlayer, MAXCHARACTERSID);
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
