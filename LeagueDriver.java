public class LeagueDriver {
    
    public static void main(String[] args){


        LeagueInfo l1 = new LeagueInfo("team.txt"); //instantiates new LeagueInfo object 
        l1.CalculateResults("games.txt"); //assigns points based on the games file 
        l1.quickSort(0, l1.getTeamList().size() -1); //sorts the teams based on the results  
        System.out.println(l1.printResults()); //prints the resulting promotions and demotions 



    }
}

