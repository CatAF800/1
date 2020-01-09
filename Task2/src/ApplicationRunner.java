
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        String word = "";

        try {
            word = chooseWord(new File("../wordlist.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List<Character> wordChars = new ArrayList<>(); 
        List<Character> triedChars = new ArrayList<>(); 
        List<Character> resultChars = new ArrayList<>(); 
  
        // For each character in the String 
        // add it to the List 
        for (char ch : word.toCharArray()) { 
            wordChars.add(ch);
            resultChars.add('_');
        }
        


        while (triedChars.size() < 10) {

            printWord(resultChars);
            printTriedChars(triedChars);
            System.out.print("inserir carater e o crl: ");
            Scanner sc = new Scanner(System.in); 
            
            // Character input 
            char letter = sc.next().charAt(0); 
    
            if(wordChars.indexOf(letter) != -1){
                while(wordChars.indexOf(letter) != -1){
                    int index = wordChars.indexOf(letter);
                    wordChars.set(index, '-');
                    resultChars.set(index, letter);
                }
            }
            else{
                triedChars.add(letter);
            }
            
        }


    }

    public static void printTriedChars(List<Character> word){

        System.out.printf("%d wrong guesses so far [ ", word.size());
        for (Character letter : word) {
            System.out.print(letter + " ");
        }
        System.out.println("]\n");

    }
    
    public static void printWord(List<Character> word){
        String result = "";
        for (Character letter : word) {
            result = result.concat(letter + " ");
        }
        System.out.println(result+"\n");
    }

    public static String chooseWord(File f) throws FileNotFoundException
    {
       String result = null;
       Random rand = new Random();
       int n = 0;
       for(Scanner sc = new Scanner(f); sc.hasNext(); )
       {
          ++n;
          String line = sc.nextLine();
          if(rand.nextInt(n) == 0)
             result = line;         
       }
  
       return result;      
    }
}
