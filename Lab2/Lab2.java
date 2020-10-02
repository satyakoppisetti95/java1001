import java.util.*;
public class Lab2 {

    // as im randomly generating array. I fixed the length of array to 10
    public static final int ARRAY_SIZE = 10;
    // setting upper limit for random function to fill the array
    public static final int UPPERLIMIT_FOR_RANDOM = 100;

    // function to reverse a string
    // we loop in a decrementing loop of length equal to string length
    // we append each character at index to a temp variable which will be returned at the end
    public static String ReverseString(String txt){
        String temp = "";
        for(int i = txt.length() - 1; i >= 0; i--)
        {
            temp = temp + txt.charAt(i);
        }
        return temp;
    }

    //function to encrypt a string
    // the concept is that we add an offset to each character's ascii value 
    // and append the new character to a temp variable
    // at the end the temp variable is an encrypted string
    // inorder to add one more layer in encryption we are reversing the string at the end
    public static String EncryptString(String txt, int value){
        String temp = "";
        for(int i = 0 ; i < txt.length() ; i++){
           temp += (char)(((int)txt.charAt(i))+value);   
        }
        return ReverseString(temp);
    }

    // function to decrypt an encrpted string
    // the concept is similar to encryption. here we are reducing the offset instead of adding
    // and reverse it back to normal form
    public static String DecryptString(String txt, int value){
        String temp = "";
        for(int i = 0 ; i < txt.length() ; i++){
           temp += (char)(((int)txt.charAt(i))-value);   
        }
        return ReverseString(temp);
    }

    //function to add all the elements in the array
    public static int SumOfArray(int[] intArray){
        // initialsing a temporary variable to zero
        int sum = 0;
        //for each element in array add it to temp sum variable
        for(int num: intArray)
            sum += num;

        //return sum
        return sum;   
    }

    // function to search a given number in the array
    // returns true if the number exists or false nif number doesn't exits
    public static boolean SearchNumInArray(int[] intArray,int searchNum){
        //for each number in array check if the current number is equal to searchNum
        for(int num: intArray){
            if(num==searchNum){
                // if value is present return true
                return true;
            }
        }
        // if not found return false;
        return false;   
    }

    // main function
    public static void main(String[] arg) {
        //creating scanner instance
        Scanner sc = new Scanner(System.in);
        //creating random instance
        Random rand = new Random();

        String userInputToEncrypt = "";
        
        // Looping till the user enters a non empty string
        while(userInputToEncrypt.isEmpty()){
            System.out.println("Enter a text to Encrypt and press enter: ");
            userInputToEncrypt = sc.nextLine();
        }

        // looping till the user enters a valid int
        // here im limiting the int to range 1 to 10 
        // to be on safer side to not exceed ascii value 127 or 255 depending on system 
        // although most of the modern systems do support. I felt it's safe to limit
        int value = -1;
        while(!(value>=1 && value<=10)){
            System.out.println("Enter a number in range 1 to 10 (encryption offset): ");
            String valueInput = sc.nextLine();
            try{
                value  = Integer.parseInt(valueInput);
            }catch(Exception e){
                value = -1;
            }
        }
        
        // Encrpyting user input string by calling EncryptString method
        String encrypted = EncryptString(userInputToEncrypt,value);

        // printing results
        System.out.println("==========================");
        System.out.println("you have entered '"+userInputToEncrypt+"' . On encryption it becomes : "+encrypted);
        System.out.println("The encrypted string '"+encrypted+"' on decrypting becomes : "+DecryptString(encrypted,value));

        System.out.println("==========================");
        System.out.println("Now generating a random int array of length 10");
        
        // initialising array
        int[] intArray = new int[ARRAY_SIZE];

        // looping to fill the array with random numbers 
        for(int i=0;i<ARRAY_SIZE; i++){
            intArray[i] = rand.nextInt(UPPERLIMIT_FOR_RANDOM); 
        }

        // display array to user
        System.out.print("Array : ");
        for(int i=0;i<ARRAY_SIZE;i++){
            System.out.print(intArray[i]+" ");
        }
        System.out.println("");
        System.out.println("==========================");

        // printing sum of the array
        System.out.println("Sum of the array is : "+SumOfArray(intArray));

        System.out.println("==========================");
        System.out.println("Enter a number to search in the array and press enter : ");
        // asking user input to search the array
        int searchNum = sc.nextInt();
        // searching for the number in array
        boolean isExists = SearchNumInArray(intArray,searchNum);
        //printing results
        if(isExists){
            System.out.println("The number '"+searchNum+"' exists in the array");
        }else{
            System.out.println("The number '"+searchNum+"' doesn't exist in the array");
        }
        
        
    }
}