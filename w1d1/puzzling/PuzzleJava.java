// You will need to import the Random library from java.util
import java.util.Random;
import java.util.ArrayList;

// From there you can use any of the methods listed in the documentation. For example:
// randMachine.setSeed(35679); // <--- you won't need to use this method.


public class PuzzleJava {
    /*
    Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive.
    To use methods from the Random library you will need to create an instance of Random
    Random randMachine = new Random();
    */
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> random10 = new ArrayList<Integer>();
        Random rand = new Random();
        for(int i = 1; i<=10; i++){
            random10.add(rand.nextInt(20) + 1);
            // The nextInt(int n) method is used to get a pseudorandom, uniformly distributed int value between 0 (inclusive) and the specified value n(exclusive), drawn from this random number generator's sequence.
        }
        return random10;
    }

    /*
    Write a method that will:
    Create an array within the method that contains all 26 letters of the alphabet (this array must have 26 values).
    Generate a random index between 0-25, and use it to pull a random letter out of the array.
    Return the random letter.
    */
    public String getRandomLetter() {
        Random rand = new Random();
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = new String[26];
        for(int i = 0; i<26; i++ ){
            alphabet[i] = String.valueOf(alphabetString.charAt(i));
            // The java string valueOf() method converts different types of values into string. By the help of string valueOf() method, you can convert int to string, long to string, boolean to string, character to string, float to string, double to string, object to string and char array to string.
        }
        return alphabet[rand.nextInt(26)];
    }

    // Write a method that uses the previous method to create a random string of eight characters, and return that string.
    public String generatePassword() {
        String password = "";
        for (int i = 0; i<8; i++){
            password = password + getRandomLetter();
        }
        return password;
    }

    /*
    Write a method that takes an int length as an argument
    and creates an array of random eight character words.
    The array should be the length passed in as an int.
    */
    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwordSet = new ArrayList<String>();
        for (int i = 0; i<length; i++){
            passwordSet.add(generatePassword());
        }
        return passwordSet;
    }
}