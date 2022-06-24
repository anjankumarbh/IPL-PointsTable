package javaInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IplPointsTable {
	
	static List<Team> teamList;//using List as a data structure to store the team data
	
	public static void main(String[] args) {
		
		teamList=new ArrayList<Team>();
		//adding all 10 teams data to the list 
		teamList.add(new Team("RCB",23, new String[] {"L","W","L","W","W"}));
		teamList.add(new Team("GT",22, new String[] {"W","L","W","L","L"}));
		teamList.add(new Team("LSG",24, new String[] {"W","W","L","W","L"}));
		teamList.add(new Team("RR",18, new String[] {"L","L","W","L","W"}));
		teamList.add(new Team("DC",16, new String[] {"L","W","W","L","W"}));
		teamList.add(new Team("KKR",20, new String[] {"W","L","L","W","L"}));
		teamList.add(new Team("PBKS",23, new String[] {"W","L","W","W","L"}));
		teamList.add(new Team("SRH",12, new String[] {"L","W","L","L","W"}));
		teamList.add(new Team("CSK",14, new String[] {"L","L","L","L","L"}));
		teamList.add(new Team("MI",22, new String[] {"L","L","L","L","L"}));
		//sorting the Team objects based on their points and printing them
		teamList.sort(Comparator.comparing(Team::getPoints));
		System.out.println(" Teams\tPoints\tLast5Status \n");
		for(int i=teamList.size()-1;i>=0;i--) {
			System.out.println(teamList.get(i));
		}
		//taking the input to perform 2 consecutive win or loss
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the team with 2 consecutive wins or loss u want please enter W or L :\n");
		String consecutiveUserInput=input.nextLine().toUpperCase();
		
		int totalPointsOfConsecutiveTeams=0;//variable to add the points of teams comes under requested consecutive category
		
		List<String> teamsWithMatchingConsecutives=new ArrayList<String>();// a list to store requested consecutive teams 
		
		for(int j=0;j<teamList.size();j++) {//Looping over the List of team
			for(int k=0;k<4;k++) {//looping over the statusOfFive in Team class
				if(teamList.get(j).getStatusOfFivs(k).equals(consecutiveUserInput) && teamList.get(j).getStatusOfFivs(k+1).equals(consecutiveUserInput)) {
					totalPointsOfConsecutiveTeams+=teamList.get(j).getPoints();
					teamsWithMatchingConsecutives.add(teamList.get(j).getTeamName());
					break;
				}
				
			}
		}
		
		System.out.println("Teams with 2 consicutive "+consecutiveUserInput+" are : ");
		for(String teams:teamsWithMatchingConsecutives) {//printing the obtained teams under consecutive category
			System.out.println(teams);
		}
		//printing the average of points with those teams with the requested status of win or loss
		System.out.println("Average points of these teams is : "+(totalPointsOfConsecutiveTeams/teamsWithMatchingConsecutives.size()));	
			
	}

}
class Team{//Team class to store all the team data
	
	String teamName;
	int points;
	String[] statusOfFive;
	
	Team(String teamName,int points,String[] statusOfFive){
		this.teamName=teamName;
		this.points=points;
		this.statusOfFive=statusOfFive;
	}
	public String toString() {
		return (" "+this.teamName+"\t"+this.points+"\t"+
			Arrays.toString(this.statusOfFive));
	}
	public String getTeamName() {
		return this.teamName;
	}
	public int getPoints() {
		return this.points;
	}
	public String getStatusOfFivs(int n) {
		return  statusOfFive[n];
	}
}

