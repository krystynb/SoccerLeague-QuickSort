import java.util.*;
import java.io.*;

//stores the current information for a specific league object, including all points recorded
public class LeagueInfo 
{

    private Map<Integer, TeamInfo> teamList;
    private int numPromoted; 
    private ArrayList<Integer> sortedTeams;

    //creates a new LeagueInfo object and stores all the information for each team into a hashmap
    public LeagueInfo(String teamFile)
    {
        //declare the scanners and the hashmap
        Scanner scan, read, readTeams;
        teamList= new HashMap<>();
            
        try{

            //initialize the scanners and set a delimiter for read 
            scan = new Scanner(new File(teamFile));
            read = new Scanner(scan.nextLine());
            read.useDelimiter(" ");

            //read and assing the number of teams that will be in the league and the number to be promoted
            int numTeams = read.nextInt();
            numPromoted= read.nextInt();
            read.close();

            //create TeamInfo objects for each team 
            for (int i=0; i<numTeams; i++){
                readTeams = new Scanner(scan.nextLine());
                try{ 
                    
                    readTeams.useDelimiter(", ");
                    int teamNum = readTeams.nextInt();
                    TeamInfo newTeam = new TeamInfo(i, readTeams.next());
                    teamList.put(teamNum, newTeam);
                }

                catch(NoSuchElementException e) {
                    readTeams.close(); 
                }
            }
            scan.close();
        }
        
        catch(FileNotFoundException e){
            System.out.println("That file is your imaginary friend, pal");
        }

        //create an array with the key for each team in the hashmap 
        sortedTeams = new ArrayList<Integer>();
        for (Map.Entry<Integer,TeamInfo> x : teamList.entrySet()) 
        { 
            sortedTeams.add(x.getKey());
        }
    }
    

    //default constructor
    public LeagueInfo() {
        this.teamList = null;
        this.numPromoted = 0;
        this.sortedTeams = null;
    }

    //calculates the results of the league using the info in the games file
    public void CalculateResults(String gamesFile)
    {
        Scanner scan, read;
        // try/catch for reading the file

        try {       
            //create scanner for new file & set endFile to false
            scan = new Scanner(new File(gamesFile));
            boolean endFile = false;
        
            while (!endFile) {
                try {
                
                    boolean endLine = false;
                    while (!endLine) 
                    {
                        read = new Scanner(scan.nextLine());
                        read.useDelimiter(" ");
                        try 
                        {
                            GameResult result = new GameResult(read.nextInt(), read.nextInt(), read.nextInt(), read.nextInt());
                            result.calcResultPoints(teamList);
                        }

                        catch (NoSuchElementException e) 
                        {
                            read.close();
                        }
                    }
                }

                catch (NoSuchElementException e)  // set endFile true when execption is reached
                {
                    endFile = true;
                    scan.close();
                }
                
            }
        }
        catch(FileNotFoundException e){
            System.out.println("That file is your imaginary friend, pal");
        }   
    }

    //prints the promoted and demoted teams 
    public String printResults()
    {
        String results = "";
        results += "Promoted \n";
        
        for (int i = 0; i < numPromoted; i++)
            results += teamList.get(sortedTeams.get(i)) + "\n";
            
        
        results += "\nRelegation \n";

        for (int i = sortedTeams.size() - numPromoted; i < sortedTeams.size(); i++)
            results += teamList.get(sortedTeams.get(i))+ "\n";

        return results;

    }
    //toString method, prints all the scores for each team in the league 
    public String toString(){
        String stringbuilder = "";
        for (Map.Entry<Integer,TeamInfo> entry : teamList.entrySet())  
        {
            stringbuilder += entry.getValue();
            stringbuilder += "\n";
        }

        return stringbuilder;

    } 


    //quicksort method 
    public void quickSort(int lo, int hi)
    {
        if (lo < hi)
        {
            int pivotPt = partition(sortedTeams, lo, hi);
            quickSort(lo, pivotPt - 1);
            quickSort(pivotPt + 1, hi);
        }
    }

    //partition method for quicksort 
    public int partition(ArrayList<Integer> a, int lo, int hi)
    {
        
        TeamInfo pivotTeam = teamList.get(a.get(lo)); //the team associated with the key at a.get(o);
        int j = hi;
        Integer dummyVal;
        for (int i = hi; i > lo; i--)
        {
            if (teamList.get(a.get(i)).compareTo(pivotTeam) < 0) //if val associated with key at a.get(i) > pivotVal
            {
                //swap the vals at i and j
                dummyVal = a.get(i);
                a.set(i, a.get(j));
                a.set(j, dummyVal); 
                j--; 
            } 
            
            }

        //swap the vals at lo and j     
        dummyVal = a.get(lo); 
        a.set(lo, a.get(j)); 
        a.set(j, dummyVal); 
        return j; 
    }

    //getters and setters 
    public Map<Integer, TeamInfo> getTeamList()
    {
        return teamList;
    }
        
    public int getNumPromoted()
    {
        return numPromoted;
    }


    public ArrayList<Integer> getSortedTeams()
    {
        return sortedTeams;
    }

    public void setTeamList(Map<Integer, TeamInfo> teamList) {
        this.teamList = teamList;
    }

    public void setNumPromoted(int numPromoted) {
        this.numPromoted = numPromoted;
    }

    public void setSortedTeams(ArrayList<Integer> sortedTeams) {
        this.sortedTeams = sortedTeams;
    }
}

