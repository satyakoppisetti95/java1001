import java.util.Scanner;

public class Lab1 {

    //function to return letter grade from percaentage grade
    public static String getGradeForScore(int score){
        if(score > 80){   // less than 100 is handled in input taking
            return "A";
        }else if(score >=70){ // less than 80 and greater than equal to 70
            return "B";
        }else if(score >=60){ // less than 70 and greater than equal to 60
            return "C";
        }else if(score >=50){ // less than 60 and greater than equal to 50
            return "D";
        }else{
            return "F";
        }
    }

    public static void main(String[] args) {
        String name = "";
        int marks = -1;
        Scanner s = new Scanner(System.in);

        //getting non empty name from user
        while(name.isEmpty()){
            System.out.print("Enter your name : ");
            name = s.nextLine();
        }

        // getting a number above 0 and below 100 
        while(marks<0 || marks>100){
            System.out.print("Enter your grade% (0 <= grade% <= 100) : ");
            marks = s.nextInt();
        }

       // printing results
        System.out.println("====================");
        System.out.println("studentName : "+name);
        System.out.println("grade : "+marks+"%");
        System.out.println("The letter grade for "+marks+"% : "+getGradeForScore(marks));
    }
}