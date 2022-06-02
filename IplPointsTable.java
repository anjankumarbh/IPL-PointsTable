package javaInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IplPointsTable {
	static Map<String,Object> m;
	Team t;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m=new HashMap<String,Object>();
		Scanner sc=new Scanner(System.in);
		Scanner str=new Scanner(System.in);
		System.out.println("How many teams you want : ");
		int noOfTeams=sc.nextInt();
		String teamName="";
		int points=0;
		String [] status= {};
		for(int i=0;i<noOfTeams;i++) {
			status=new String[5];
			System.out.println("Enter the team name");
			teamName=str.nextLine();
			System.out.println("Enter the points");
			points=sc.nextInt();
			System.out.println("Enter the status of five matches [W as win] or [L as Lose]");
			for(int j=0;j<5;j++) {
				status[j]=str.nextLine().toUpperCase();
			}
			m.put(teamName, new Team(points,status));	
			status=null;
			
		}
		System.out.println("  Teams\tPoints\tLast 5 Matches\n");
		for(String key:m.keySet()) {
			System.out.println(" "+key+" "+m.get(key));
		}
		System.out.println("Enter the consicutive status you want to search please enter W or L");
		String WorL =str.nextLine().toUpperCase();
		System.out.println("Enter how many consicutives");
		int noOfConsecutive=sc.nextInt();
		List consicutiveTeams=new ArrayList();;
		int avgOfConsucitiveTeams=0;
		int count=0;
		for (Map.Entry<String,Object> entry : m.entrySet()) {
	          // System.out.println("Key = " + entry.getKey());
	           //System.out.println("Value = " + entry.getValue());
	           Team t = (Team) entry.getValue();
	         //  System.out.println("Points :" + t.getPoints());
	           if( t.consecutive(t.getStatusOfFivs(),noOfConsecutive,WorL)==true) {
	        	   consicutiveTeams.add(entry.getKey());
	        	   avgOfConsucitiveTeams+=t.getPoints();
	        	   count++;
	           }
	           
        }
		avgOfConsucitiveTeams/=count;
		System.out.println("Teams having consicutive "+noOfConsecutive+" "+WorL+" are "+Arrays.asList(consicutiveTeams));
		System.out.println("Average of these filterd teams is "+avgOfConsucitiveTeams);
		
			
	}

}
class Team{
	int points;
	String[] statusOfFive;
	Team(int point,String[] s){
		this.points=point;
		this.statusOfFive=s;
	}
	public String toString() {
		return ("  "+this.points+"\t"+
			Arrays.asList(this.statusOfFive));
	}
	public int getPoints() {
		return this.points;
	}
	public List getStatusOfFivs() {
		return  (Arrays.asList(statusOfFive));
	}
	public boolean consecutive(List<String> s,int n,String m) {
		int count=0;
		for(int i=0;i<s.size()-n;i++) {
			for(int j=i;j<n+i;j++) {
				if(s.get(j).equals(m)) {
					count++;
				}
				if(count==n) {
					return true;
				}
			}
		}
		return false;
	
	}
}
