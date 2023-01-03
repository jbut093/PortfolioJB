import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader extends BullsAndCows {
       public static List<String> getUserInput(){
            Scanner scannerIn = new Scanner(System.in);

            boolean fileTrue = false;


            System.out.println("You chose to use code from a file. PLease advise of the file location: ");

            File file = new File(scannerIn.nextLine());
            if (file.exists()) {
                fileTrue = true;
            }
            while (!fileTrue) {
                System.out.println("Please enter a valid file name.");
                file = new File(scannerIn.nextLine());

                if (file.exists()) {
                    System.out.println("file exists");
                    System.out.println(file.getPath());
                    fileTrue = true;

                } else {
                    System.out.println("file not found, please enter a valid file name");
                }
            }
            List<String> readCodes = new ArrayList<>();

            try (Scanner s = new Scanner(file)) {
                while (s.hasNext()) {

                    readCodes.add(s.nextLine());

                }
            } catch(IOException e){
                System.out.println("Error: " + e.getMessage());
            }

            return readCodes;
        }
    }

