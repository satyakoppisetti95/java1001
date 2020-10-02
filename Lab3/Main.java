import java.util.*;

public class Main{

    // main function
    public static void main(String[] arg) {
        //initialising scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("*** Dice Game ***");

        // the print statements are self explanatory on what is code doing
        System.out.println("Creating default dice...");
        Dice df = new Dice();
        System.out.println("Created -> "+df.toString());
        System.out.println("Rolling...");
        df.roll();
        System.out.println("Result -> "+df.getSideUp());

        System.out.println("Press Enter to continue...");
        sc.nextLine();

        System.out.println("------------------------");
        System.out.println("Now, Lets create a dice with single parameter (numOfSides)");
        
        int number_of_sides = -1;
        while(number_of_sides <= 0){
            System.out.println("Enter number of sides : ");
            try{
                number_of_sides = Integer.parseInt(sc.nextLine());
            }catch(Exception E){
                number_of_sides = -1;
            }
        }

        Dice d1 = new Dice(number_of_sides);
        System.out.println("Created -> "+d1.toString());
        System.out.println("Rolling...");
        d1.roll();
        System.out.println("Result -> "+d1.getSideUp());
        System.out.println("Press Enter to continue...");
        sc.nextLine();

        System.out.println("------------------------");
        System.out.println("Now, Lets create a dice with two parameters (diceType and numOfSides)");
        
        String diceType = "";
        while(diceType.isEmpty()){
            System.out.println("Enter Dice Type : ");
            diceType = sc.nextLine();
        }

        number_of_sides = -1;
        while(number_of_sides <= 0){
            System.out.println("Enter number of sides : ");
            try{
                number_of_sides = Integer.parseInt(sc.nextLine());
            }catch(Exception E){
                number_of_sides = -1;
            }
        }

        Dice d2 = new Dice(diceType,number_of_sides);
        System.out.println("Created -> "+d2.toString());
        System.out.println("Rolling...");
        d2.roll();
        System.out.println("Result -> "+d2.getSideUp());
        System.out.println("Press Enter to continue...");
        sc.nextLine();
        System.out.println("Now, Lets set Top face of the this dice!!");
        

        int topFace = 0;
        while(topFace < 1 || topFace > d2.getNumSides()){
            System.out.println("Enter number to be set as top face ( 1 < number < "+d2.getNumSides()+") : ");
            try{
                topFace = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                topFace = 0;
            }
        }

        d2.setSideUp(topFace);
        System.out.println("Dice Updated");
        System.out.println("-> "+d2.toString());
        System.out.println("Press Enter to continue...");
        sc.nextLine();

        System.out.println("------------------------");
        System.out.println("Now we will create 5 dices and roll till cold-Yahtzee happens!");
        d1 = new Dice();
        d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        System.out.println("Created -> "+d1.toString());
        System.out.println("Created -> "+d2.toString());
        System.out.println("Created -> "+d3.toString());
        System.out.println("Created -> "+d4.toString());
        System.out.println("Created -> "+d5.toString());

        System.out.println("Press Enter to start rolling ...");
        sc.nextLine();

        int number_of_rolls = 0,d1_roll=0,d2_roll=0,d3_roll=0,d4_roll=5,d5_roll=6;


        while(true){
            number_of_rolls += 1;

            d1_roll = d1.roll();
            d2_roll = d2.roll();
            d3_roll = d3.roll();
            d4_roll = d4.roll();
            d5_roll = d5.roll();

            System.out.println("Roll - > "+d1_roll+" "+d2_roll+" "+d3_roll+" "+d4_roll+" "+d5_roll);
            if(d1_roll == d2_roll && d2_roll == d3_roll && d3_roll == d4_roll && d4_roll == d5_roll){
                System.out.println("Hurray! cold-Yahtzee!!");
                System.out.println("Took "+number_of_rolls+" rolls to achieve cold-Yahtzee!");
                break;
            }
        }




    }
}