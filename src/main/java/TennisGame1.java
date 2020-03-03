import java.util.HashMap;
import java.util.Map;

//Ignore message package.
public class TennisGame1 implements TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    //private String player1Name;
    //private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        //this.player1Name = player1Name;
        //this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if ( playerName.equalsIgnoreCase("player1")){
            scorePlayer1 += 1;
        } else {
            scorePlayer2 += 1;
        }
    }

    public String getScore() {
        String score = "";

        if (isDraw()){
            score = definirScoreDeEmpate();
        }else if (isAdvantage()){
            score = getAdvantage();
        }else{
            score = validarScore(score);
        }
        return score;
    }

    private boolean isDraw() {
        return scorePlayer1 == scorePlayer2;
    }

    private String definirScoreDeEmpate() {
        String[] drawScores = {"Love-All", "Fifteen-All", "Thirty-All"};
        return scoreInGame()<3 ? drawScores[scoreInGame()]: "Deuce";
    }

    private int scoreInGame() {
        return scorePlayer1;
    }

    private boolean isAdvantage() {
        return scorePlayer1 >=4 || scorePlayer2 >=4;
    }

    private String getAdvantage() {
        int minusResult = scorePlayer1 - scorePlayer2;
        Map<Integer, String> mapOfState = new HashMap<Integer, String>();
        mapOfState.put(1,"Advantage player1");
        mapOfState.put(-1,"Advantage player2");
        mapOfState.put(2,"Win for player1");
        mapOfState.put(3,"Win for player1");
        mapOfState.put(4,"Win for player1");
        return mapOfState.getOrDefault(minusResult, "Win for player2");
    }

    private String validarScore(String score) {
        /*int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1){
                tempScore = scorePlayer1;
            }
            else {
                score+="-";
                tempScore = scorePlayer2;
            }
            switch(tempScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }*/
        String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
        score += scores[scorePlayer1] + "-" + scores[scorePlayer2];
        return score;
    }

}
