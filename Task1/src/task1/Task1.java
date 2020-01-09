/* ------ Task 1 ------ */

package task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.HashMap; 
import java.util.Map; 
import java.util.Iterator; 



/**
 *
 * @author af800
 */
public class Task1 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        // String fileName="C:\\Users\\af800\\Desktop\\Assignment1\\Assignment1Download\\Task1";
        String fileName="./play.txt";

        Map<Character, Integer> map = new HashMap<Character, Integer>(); 

        try{

            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(inputFile);

            int c;
            char character;

            // Read file line by line and print on the console
            while (( c = bufferReader.read()) != -1){
                character = (char) c;
                if(map.containsKey(character)){
                    map.put(character, map.get(character)+1);
                }
                else if(Character.isLetter(character)){
                    map.put(character, 1);
                }
            }
            printMap(map);
            bufferReader.close();
        }catch(Exception e){
            System.out.println("Error while reading file line by line:" + e.getMessage());                      
        }


    }

    public static void printMap(Map<Character, Integer> mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }


}
