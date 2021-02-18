
public class TennisGame1 implements ITennisGame {

    private int mscore1 = 0;
    private int mscore2 = 0;
    private String player1Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;

    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            mscore1 += 1;
        else
            mscore2 += 1;
    }

    public String pointDeuce(Integer mscore1) {
        String score;
        switch (mscore1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    public String scoreGame(Integer tempScore) {
        String score = "";
        switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
            default:
                score +="";
        }
        return score;
    }

    public String score() {
        String score = "";
        int tempScore=0;
        if (mscore1 == mscore2)
        {
            score=pointDeuce(mscore1);
        }
        else if (mscore1 >=4 || mscore2 >=4)
        {
            int minusResult = mscore1 - mscore2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = mscore1;
                else { score+="-"; tempScore = mscore2;}
                 score+= scoreGame(tempScore);
            }
        }
        return score;
    }
}
