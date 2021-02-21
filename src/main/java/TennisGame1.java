import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class TennisGame1 implements TennisGame {

    private int mscore1 = 0;
    private int mscore2 = 0;
    private final String player1Name;
    private final String player2Name;

    private static final HashMap<Integer,String> scores= new HashMap<Integer, String>();
    private static final HashMap<Integer,String> advantageWin= new HashMap<Integer, String>();


    static {
        scores.put(0, "Love");
        scores.put(1, "Fifteen");
        scores.put(2, "Thirty");
        scores.put(3, "Forty");
    }


    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name=player2Name;

    }

    public void wonPoint(String playerName) {
        if (this.player1Name.equals(playerName))
            mscore1 += 1;
        else
            mscore2 += 1;
    }


    private String draw(Integer mscore1) {
        return mscore1 < 3 ? scoreGame(mscore1) + "-All" : "Deuce";
    }

    public String deuceWorks(Integer minusResult) {
        String score;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }


    private String scoreGame(Integer tempScore) {
        return scores.get(tempScore);
    }

    private boolean isAdvantageOrWin(){
        return mscore1>=4 || mscore2 >= 4 ? Boolean.TRUE: Boolean.FALSE;
    }


    public String getScore() {
        if (mscore1 == mscore2) {
            return draw(mscore1);
        } else if (isAdvantageOrWin()) {
            int minusResult = mscore1 - mscore2;
            return deuceWorks(minusResult);
        }
        return scoreGame(mscore1) + "-" + scoreGame(mscore2);
    }
}
