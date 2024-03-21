//stores all the information for a given team into an object and contains an override for compareTo
public class TeamInfo implements Comparable<TeamInfo> 
{

    private int scoredPoints, allowedPoints, leaguePoints, tEntered;
    private String teamName;


    public TeamInfo(int x, String n)
    {
        tEntered = x;
        teamName = n;
        scoredPoints = 0;
        allowedPoints = 0;
        leaguePoints = 0;
    }
        
    //default constructor
    public TeamInfo()
    {
        tEntered = -1;
        teamName = null;
        scoredPoints = 0;
        allowedPoints = 0;
        leaguePoints = 0;
    }

    //assigns points to a team 
    public void newPoints(int s, int a, int l)
    {
        scoredPoints += s;
        allowedPoints += a;
        leaguePoints += l;
    }

    //compareTo method for TeamInfo, compares based on points and order entered into the league 
    @Override
    public int compareTo(TeamInfo t)
    {
        if (leaguePoints == t.leaguePoints)
        {
            if (scoredPoints == t.scoredPoints)
            {
                if (allowedPoints == t.allowedPoints)
                    return((Integer.compare(tEntered, t.tEntered))*-1);

                else
                    return ((Integer.compare(allowedPoints, t.allowedPoints))*-1);
            }

            else 
                return Integer.compare(scoredPoints, t.scoredPoints);
        }
        return Integer.compare(leaguePoints, t.leaguePoints);
    }

    //toString for team info, prints name, league points, scored points, and points allowed 
    public String toString() {
        //return teamName + " " + leaguePoints + " " + scoredPoints + " " + allowedPoints + " (" + tEntered + ")\n";
        return String.format("%-20s %3d %3d %3d", teamName, leaguePoints, scoredPoints, allowedPoints);
    }

    //getters and setters 
    public int getScoredPoints() {
        return scoredPoints;
    }

    public int getAllowedPoints() {
        return allowedPoints;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setScoredPoints(int scoredPoints) {
        this.scoredPoints = scoredPoints;
    }

    public void setAllowedPoints(int allowedPoints) {
        this.allowedPoints = allowedPoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public int getTEntered() {
        return tEntered;
    }

    public void setTEntered(int tEntered) {
        this.tEntered = tEntered;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    
}