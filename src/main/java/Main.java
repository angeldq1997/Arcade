import model.ArcadeMachine;
import model.Player;

public class Main {
    public static void main(String[] args) {

        ArcadeMachine arcadeMachine1 = new ArcadeMachine("Space Invaders", "Shoot' em Up", 10);
        arcadeMachine1.setTimesPlayed(70);
        System.out.println(arcadeMachine1.isActivated());

        try {
            arcadeMachine1.addPlayTimeToMachine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(arcadeMachine1.isActivated());

        Player player1 = new Player("Antonio", "1", 20, 0);
        arcadeMachine1.storeScore(player1, 700);
    }
}
