import model.ArcadeMachine;
import model.Player;
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

        Player antonio = new Player("Antonio", "1", 100);

        int[] score = {1000, 600, 500};
        arcadeMachine1.setRankingScore(score);
        arcadeMachine1.storeScore(antonio, 700);

        System.out.println(arcadeMachine1);
    }
}
