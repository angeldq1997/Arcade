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
        final int MAXYEAR = 2025;
        final int MINCREDITS = 1;
        final int MAXCREDITS = 1000;

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

        //Creación de sala recreativa con los arrays anteriores:
        ArcadeRoom arcadeRoom1 = new ArcadeRoom(players, arcadeMachinesInRoom);

        //Vista del menú principal en clase View.
        View.principalMenu(arcadeRoom1, arcadeMachinesInRoom, players,MAXCHARACTERSPLAYER, MAXCHARACTERSID, MAXCHARACTERSARCADEMACHINE, MAXYEAR, MAXSCORE, MINCREDITS, MAXCREDITS);
    }
}