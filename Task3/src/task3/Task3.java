/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task3;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays; 

public class Task3 {


    public static void main(String[] args) {
        String word, readWord, sortedReadWord;
        ArrayList<String> anagramList = new ArrayList<String>(); 
        Scanner sc = new Scanner(System.in); 

        while(true){
        
            System.out.print("Try again (1) or Exit (0) > ");
            char number;
            while((number = sc.nextLine().charAt(0)) != '1' && number != '0'){
                System.out.print("Try again (1) or Exit (0) > ");
            }
            if(number == '0'){
                break;
            }

            System.out.print("Please enter a string (single word or phrase)\n> ");
            word = sc.nextLine(); 
    
            try {
                BufferedReader reader = new BufferedReader(new FileReader("../lexicon.txt"));
                String sortedWord = sortString(word.replaceAll("\\s+",""));
                
                while ((readWord = reader.readLine()) != null){
                    sortedReadWord = sortString(readWord);
                    if(sortedWord.equals(sortedReadWord)){
                        anagramList.add(readWord);
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }

            System.out.printf("Possible anagrams for \"%s\": %s\n", word, Arrays.toString(anagramList.toArray()) );
            anagramList.clear();

        }
    }

    public static String sortString(String inputString) 
    { 
        char tempArray[] = inputString.toCharArray(); 
        Arrays.sort(tempArray); 
        return new String(tempArray); 
    }
    
}
