import java.util.Random;
public class Dice{
    //definig the variable
    private String diceType;
    private int numSides;
    private int sideUp;

    private Random rand = new Random();

    //0 argument (default) constructor
    public Dice(){
        int def = 6;
        this.diceType = "d6";
        this.numSides = def;
        this.sideUp = rand.nextInt(def)+1;
    };

    //1 argument constructor for the number of sides
    public Dice(int numSides){
        this.diceType = "d"+numSides;
        this.numSides = numSides;
        this.sideUp = rand.nextInt(numSides)+1;
    }

    //2 argument constructor for the number of sides and the diceType
    public Dice(String diceType, int numSides){
        this.diceType = diceType;
        this.numSides = numSides;
        this.sideUp = rand.nextInt(numSides)+1;
    }

    // defining accessors 
    public String getDiceType(){
        return this.diceType;
    }
    public int getNumSides(){
        return this.numSides;
    }
    public int getSideUp(){
        return this.sideUp;
    }

    //defining mutators
    public void setDiceType(String diceType){
        this.diceType = diceType;
    }
    public void setNumSides(int numSides){
        this.numSides = numSides;
    }
    public void setSideUp(int sideUp){
        this.sideUp = sideUp;
    }

    public static int roll(){
        this.sideUp = rand.nextInt(this.numSides)+1;
        return this.sideUp;
    }

    // to string function
    public String toString(){
        return "Type : "+this.diceType+", numSides : "+this.numSides+", sideUp : "+this.sideUp;
    }
}