package Assignment1;

import java.util.Scanner;

public class Main {
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of sets");
		while(!scan.hasNextInt()) {
		    scan.next();
		}
		int n = scan.nextInt();
		
		
		UI play = new UI();
		play.setUniverse(n);
		
	}
	
	
}
	


