
public class TennisGame2 implements TennisGame {
    public int player1Points = 0;
    public int player2Points = 0;
    public String player1Score = "";
    public String player2Score = "";
    //se comentan nombres ya que nunca son usados
    /*private String player1Name;
    private String player2Name;*/

    public TennisGame2(String player1Name, String player2Name) {
        /*this.player1Name = player1Name;
        this.player2Name = player2Name;*/
    }

    public int getPlayer1Points() {
        return player1Points;
    }

    public void setPlayer1Points(int player1Points) {
        this.player1Points = player1Points;
    }

    public int getPlayer2Points() {
        return player2Points;
    }

    public void setPlayer2Points(int player2Points) {
        this.player2Points = player2Points;
    }

    public String getScore() {
        String score = "";
        if (drawOrDeuce()) {
            score = drawScoreToShow();
        }
        if (player2Humilliated()) {
            obtainScore(player1Score, player1Points);
            player2Score = "Love";
            score = player1Score + "-" + player2Score;

        }
        if (player2Points > 0 && player1Points == 0) {
            if (player2Points == 1)
                player2Score = "Fifteen";
            if (player2Points == 2)
                player2Score = "Thirty";
            if (player2Points == 3)
                player2Score = "Forty";

            player1Score = "Love";
            score = player1Score + "-" + player2Score;
        }

        if (player1Points > player2Points && player1Points < 4) {
            if (player1Points == 2)
                player1Score = "Thirty";
            if (player1Points == 3)
                player1Score = "Forty";
            if (player2Points == 1)
                player2Score = "Fifteen";
            if (player2Points == 2)
                player2Score = "Thirty";
            score = player1Score + "-" + player2Score;
        }
        if (player2Points > player1Points && player2Points < 4) {
            if (player2Points == 2)
                player2Score = "Thirty";
            if (player2Points == 3)
                player2Score = "Forty";
            if (player1Points == 1)
                player1Score = "Fifteen";
            if (player1Points == 2)
                player1Score = "Thirty";
            score = player1Score + "-" + player2Score;
        }

        if (player1Points > player2Points && player2Points >= 3) {
            score = "Advantage player1";
        }

        if (player2Points > player1Points && player1Points >= 3) {
            score = "Advantage player2";
        }

        if (player1Points >= 4 && player2Points >= 0 && (player1Points - player2Points) >= 2) {
            score = "Win for player1";
        }
        if (player2Points >= 4 && player1Points >= 0 && (player2Points - player1Points) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private void obtainScore(String playerScore, int playerPoints) {
        String[] scores = {"Fifteen", "Thirty", "Forty"};
        if (playerPoints == 1) {
            playerScore = "Fifteen";
        }
        if (playerPoints == 2){
            playerScore = "Thirty";
        }
        if (playerPoints == 3) {
            playerScore = "Forty";
        }

    }

    private boolean player2Humilliated() {
        return player1Points > 0 && player2Points == 0;
    }

    private String drawScoreToShow() {
        String[] scores = {"Love-All", "Fifteen-All", "Thirty-All"};
        return (scoreBothPlayers() < 3 ) ? scores[scoreBothPlayers()] : "Deuce";
    }

    private int scoreBothPlayers() {
        return this.getPlayer1Points();
    }

    private boolean drawOrDeuce() {
        return (player1Points == player2Points);//se cambia player1Points < 3, ya que en < 4 ya que si empatan en 3 es deuce y ya existe un condicional para eso
    }
    /*Estos metodos nunca son usados. los metodos privados que implementan son llamados desde wonPoint()*/
    /*public void SetP1Score(int number){

        for (int i = 0; i < number; i++)
        {
            p1Score();
        }

    }

    public void SetP2Score(int number){

        for (int i = 0; i < number; i++)
        {
            p2Score();
        }

    }*/

    /*se cambia modificador de acceso a privado ya que son metodos llamados desde otro metodo*/
    private void increaseP1Score() {
        //se cambia para implementar setters y getters
        this.setPlayer1Points(this.getPlayer1Points() + 1);
    }

    /*se cambia modificador de acceso a privado ya que son metodos llamados desde otro metodo*/
    private void increaseP2Score() {
        //se cambia para implementar setters y getters
        this.setPlayer2Points(this.getPlayer2Points() + 1);
    }

    public void wonPoint(String player) {
        if (player.equalsIgnoreCase("player1")) {
            //se renombra metodo para que sea mas diciente
            increaseP1Score();
        } else {
            //se renombra metodo para que sea mas diciente
            increaseP2Score();
        }
    }
}