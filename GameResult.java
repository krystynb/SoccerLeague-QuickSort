import java.util.Map;


//creates an object that holds the information for games so that the points can be allocated to the proper teams 
public class GameResult {

    private int team1, team2, score1, score2;
    public GameResult(int t1, int t2, int s1, int s2)
    {
        team1 = t1;
        team2 = t2;
        score1 = s1;
        score2 = s2;
    }
    
    //default constructor 
    public GameResult()
    {
    team1 = 0;
    team2 = 0;
    score1 = 0;
    score2 = 0;
    }

    //calculates which team gets how many points
    public void calcResultPoints(Map<Integer, TeamInfo> m)
    {
        if (score1 > score2)
            team1Win(m);

        else if (score1 < score2)
            team2Win(m);
            
        else
            tie(m);
    }
        
    //assigns points in the case of a tie
    public void tie(Map<Integer, TeamInfo> t){
        
        TeamInfo t1 = t.get(team1);
        TeamInfo t2 = t.get(team2);

        t1.newPoints(score1, score1, 1);
        t2.newPoints(score1,score1,1);

    }

    //assigns points in case of team 1 winning
    public void team1Win(Map<Integer, TeamInfo> t){
        TeamInfo t1 = t.get(team1);
        TeamInfo t2 = t.get(team2);

        t1.newPoints(score1, score2, 3);
        t2.newPoints(score2,score1,0);

    }
        
    //assigns points in the case of team 2 winning
    public void team2Win(Map<Integer, TeamInfo> t){
        TeamInfo t1 = t.get(team1);
        TeamInfo t2 = t.get(team2);

        t1.newPoints(score1, score2, 0);
        t2.newPoints(score2,score1,3);
    }

    // getters and setters 
    public int getTeam1()
    {
        return team1;
    }

    public int getTeam2()
    {
        return team2;
    }

    public int getScore1(){
        return score1;
    }

    public int getScore2(){
        return score2;
    }

    public void setTeam1(int team1) {
        this.team1 = team1;
    }

    public void setTeam2(int team2) {
        this.team2 = team2;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }
}
