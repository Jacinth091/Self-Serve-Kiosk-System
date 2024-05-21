/**
    Name: Ashley R. Saramosing
    Date: March 7,2024
    Description: Using switch-case statement, write a Java program that accepts a grade as input,
       and prints the equivalent rating of that grade.
*/
import java.util.Scanner;
class Act06
{
    public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);
	
		System.out.printf("Enter grade: ");
		int grade = enter.nextInt();
		
		if(grade <= 100){
        	switch(grade/5)
        	{
        	    case 20: 
        	    case 19: System.out.printf("\nThe grade %d is Excellent!", grade);              break;
        	    case 18: System.out.printf("\nThe grade %d is Very Good!", grade);              break;
        	    case 17: System.out.printf("\nThe grade %d is Good!", grade);                   break;
        	    case 16: System.out.printf("\nThe grade %d is Satisfactory!", grade);           break;
        	    case 15: System.out.printf("\nThe grade %d is Needs Improvement!", grade);      break;
        	    case 14: System.out.printf("\nThe grade %d is Poor!", grade);                   break;
        	    default: System.out.printf("\nEnter grades between 70-100");                    
		    }
		}
		else{
		    System.out.printf("\nEnter grades between 70-100");
		}
    }
}