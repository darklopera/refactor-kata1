import java.util.HashMap;


public class TennisGame1 implements TennisGame {

    private int mscore1 = 0;
    private int mscore2 = 0;
    private final String player1Name;
    private final String player2Name;

    private static final HashMap<Integer,String> scores= new HashMap<Integer, String>();



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

    private String scoreGame(Integer tempScore) {
        return scores.get(tempScore);
    }

    private String winOrAdvantage(Integer minusResult) {
        return Math.abs(minusResult)==1 ? advantage(minusResult): win(minusResult);
    }

    private String advantage(Integer minusResult){
        return minusResult==1 ? "Advantage " + player1Name : "Advantage " + player2Name;
    }

    private String win(Integer minusResult){
        return minusResult>=2 ? "Win for " + player1Name : "Win for " + player2Name;
    }


    private boolean isAdvantageOrWin(){
        return mscore1>=4 || mscore2 >= 4 ? Boolean.TRUE: Boolean.FALSE;
    }


    public String getScore() {
        if (mscore1 == mscore2) {
            return draw(mscore1);
        }
        if (isAdvantageOrWin()) {
            int minusResult = mscore1 - mscore2;
            return winOrAdvantage(minusResult);
        }
        return scoreGame(mscore1) + "-" + scoreGame(mscore2);
    }
}
