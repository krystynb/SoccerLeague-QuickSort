# SoccerLeague-QuickSort
This program utilizes quicksort to determine promotions and demotions within a soccer league.

Teams are put in multiple level brackets and at the end of each season the teams are promoted if they are one of the best teams and demoted if they are one of the worst teams. 

The program will rank the teamsbased on a specific scoring mechanism: 
- 3 points if they win a game
- 1 point if they tie a game 
- 0 points if they lose

In the case of a tie on points the tie‐breakers are determined by goals scored, goals allowed (goals scored against that team) and finally the the order in which the teams entered the bracket.


Input:  
Two files: Teams.txt and Games.txt

teams.txt: 
- first number =  number of teams
- second number = number of teams to be promoted/demoted
- followed by multiple lines containing the Team Number and Team Name separated by a comma with a single team on each line

games.txt: on each line there is
- Team1 number (home)
- Team2 number (away)
- Team1 score
- Team2 score

The output will be the promoted and demoted teams followed by their scores
