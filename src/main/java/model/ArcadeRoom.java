package model;

import utils.Utils;

public class ArcadeRoom {
    Player[] players;
    ArcadeMachine[] arcadeMachines;

    /**
     * Constructor de sala recreativa. Requiere array de jugadores y de máquinas arcade.
     *
     * @param players        Array de jugadores de la sala recreativa.
     * @param arcadeMachines Array de máquinas arcade de la sala recreativa.
     */
    public ArcadeRoom(Player[] players, ArcadeMachine[] arcadeMachines) {
        this.players = players;
        this.arcadeMachines = arcadeMachines;
    }

    /**
     * Función para encontrar un jugador concreto en el array de jugadores
     *
     * @param playerToFind Jugador a buscar.
     * @return La posición del jugador a buscar en el array de jugadores.
     */
    private int findPlayerPosition (Player playerToFind) throws Exception {
        int playerPosition = -1;
        if(playerToFind != null) {
            boolean foundPlayer = false;
            for (int i = 0; i < this.players.length && !foundPlayer; i++) {
                if (this.players[i].equals(playerToFind)) {
                    foundPlayer = true;
                    playerPosition = i;
                }
            }
        }else{
            throw new Exception("Error, ha seleccionado un jugador nulo, debe seleccionar un jugador existente.");
        }
        return playerPosition;
    }


    private int findMachinePosition (ArcadeMachine machineToFind) throws Exception {
        int machinePosition = -1;
        if (machineToFind !=null) {
            boolean isMachineFound = false;
            for (int i = 0; i < this.arcadeMachines.length && !isMachineFound; i++) {
                if (this.arcadeMachines[i].equals(machineToFind)) {
                    isMachineFound = true;
                    machinePosition = i;
                }
            }
        }else{
            throw new Exception("Error, ha seleecionado una máquina nula, debe seleccionar una máquina existente.");
        }
        return machinePosition;
    }

    public int findMachineByName (String machineName) {
        boolean isMachineFound = false;
        int machinePosition = 0;
        for (int i = 0; i < this.arcadeMachines.length && !isMachineFound; i++) {
            if (this.arcadeMachines[i].getName().equals(machineName)) {
                isMachineFound = true;
                machinePosition = i;
            }
        }
        return machinePosition;
    }

    public int findPlayerByID (String idToFind) {
        boolean isPlayerFound = false;
        int playerPosition = -1;
        for (int i = 0; i < this.players.length && !isPlayerFound; i++) {
            if (this.players[i].getId().equals(idToFind)) {
                isPlayerFound = true;
                playerPosition = i;
            }
        }
        return playerPosition;
    }

    //TODO: Renovar codigo remove igual que jugador CREAR EDITAR Máquina.
    public void removeMachine (ArcadeMachine machineToRemove) throws Exception {
        int position = findMachinePosition(machineToRemove);
        this.arcadeMachines[position] = null;
    }

    public boolean removePlayer (int MAXCHARACTERSPLAYER) throws Exception {
        boolean removeSuccessful = false;
        int playerPosition = -1;
        String playerSelected = Utils.verifyString(MAXCHARACTERSPLAYER);
        playerPosition = this.findPlayerByID(playerSelected);
        if (playerPosition !=-1){
            this.arcadeMachines[playerPosition] = null;
            removeSuccessful = true;
        }
        return removeSuccessful;
    }

    public boolean registerNewPlayer (Player newPlayerToRegister) throws Exception {
        boolean registerSuccessful = false;
        if (newPlayerToRegister != null) {
            for (int i = 0; i < this.players.length; i++) {
                if (players[i].getId() == "NONE" || players[i] == null) {
                    players[i] = newPlayerToRegister;
                    registerSuccessful = true;
                }
            }
        } else {
            throw new Exception("No se puede registrar un jugador sin datos.");
        }
        return registerSuccessful;
    }

    public boolean registerNewMachine (ArcadeMachine newMachineToRegister) throws Exception {
        boolean registerSuccessful = false;
        if (newMachineToRegister != null) {
            for (int i = 0; i < this.arcadeMachines.length; i++) {
                if (arcadeMachines[i].getName() == "Máquina desconocida" || arcadeMachines[i] == null) {
                    arcadeMachines[i] = newMachineToRegister;
                    registerSuccessful = true;
                }
            }
        } else {
            throw new Exception("Error, no se puede registrar una máquina vacía.");
        }
        return registerSuccessful;
    }

    public boolean editPlayer (int MAXCHARACTERSPLAYER, int MAXCHARACTERSID) throws Exception {
        int playerPosition = -1;
        boolean editedPlayer = false;
        String playerSelected = Utils.verifyString(MAXCHARACTERSPLAYER);
        playerPosition = this.findPlayerByID(playerSelected);
        if (playerPosition !=-1){
            this.players[playerPosition].setName(Utils.verifyString(MAXCHARACTERSPLAYER));
            this.players[playerPosition].setId(Utils.verifyString(MAXCHARACTERSID));
            editedPlayer =true;
        }
        return editedPlayer;
    }

    public String listPlayers () {
        String playerList = null;
        for (int i = 0; i < this.players.length; i++) {
            playerList += (this.players[i].getName() + " ");
        }
        return playerList;
    }

    public String listMachines () {
        String machineList = null;
        for (int i = 0; i < this.arcadeMachines.length; i++) {
            machineList += (this.arcadeMachines[i].getName() + " ");
        }
        return machineList;
    }

    public String listActiveMachines () {
        String activeMachineList = null;
        for (int i = 0; i < this.arcadeMachines.length; i++) {
            if (this.arcadeMachines[i].isActivated()) {
                activeMachineList += (this.arcadeMachines[i].getName() + " ");
            }
        }
        return activeMachineList;
    }

    public Player mostActivePlayer () {
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

    public ArcadeMachine mostActiveMachine () {
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
}
