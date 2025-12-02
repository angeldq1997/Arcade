import model.ArcadeMachine;
import utils.Utils;

public class Main{
    public static void main(String[] args) {

        ArcadeMachine arcadeMachine1 = new ArcadeMachine("Space Invaders", "Shoot' em Up", 10);
        arcadeMachine1.setTimesPlayed(70);
        System.out.println(arcadeMachine1.IsActivated());

        try {
            arcadeMachine1.addPlay();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(arcadeMachine1.IsActivated());
    }
}
