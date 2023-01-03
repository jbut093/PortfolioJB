import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Writer{


    private static void writer(String PC, String CC, ArrayList<String> playerGuessRec, ArrayList<String> computerGuessRec, int result, int turn, ArrayList<Integer> cowsCountP, ArrayList<Integer> bullsCountP, ArrayList<Integer> cowsCountC, ArrayList<Integer> bullsCountC) {

        Scanner scannerFileWrite = new Scanner(System.in);


        String fileName;
        System.out.println("Please enter a file path ");
        fileName = scannerFileWrite.nextLine();
        int j=1;

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("Cows & Bulls game result.\n");
            bw.write("Your code: " + PC + " \n");
            bw.write("Computer code: " + CC + " \n");

            for(int i=0; i< turn; i++) {

                bw.write("---\n");
                bw.write("Turn " + j +" \n");
                bw.write("You guessed " + playerGuessRec.get(i) + ", scoring " + bullsCountP.get(i) + " Bulls and " + cowsCountP.get(i) + " Cows  \n");
                bw.write("The Computer guessed " +  computerGuessRec.get(i) + ", scoring  " + bullsCountC.get(i) + "" +
                        " Bulls and " + cowsCountC.get(i) + " Cows  \n");
                j++;
            }
            if(result==1){
                bw.write("---\n");
                bw.write("Player won! \n");
            }else if(result==2){
                bw.write("---\n");
                bw.write("Computer won! \n");
            }else{
                bw.write("---\n");
                bw.write("Game resulted in draw \n");
            }

                bw.close();

            } catch (Exception ex) {
            System.out.println("an error occurred");

            }
        }

    public static int requestRecYN(String PC, String CC, ArrayList<String> playerGuessRec, ArrayList<String> computerGuessRec, int result, int turn, ArrayList<Integer> cowsCountP, ArrayList<Integer> bullsCountP, ArrayList<Integer> cowsCountC, ArrayList<Integer> bullsCountC){

        int rec= 0;
        System.out.println("Game over. Would you a text record of the game?");
        System.out.println("if yes, please press the number 1. If not, press any other number. ");
        try {
            rec = Integer.parseInt(Keyboard.readInput());


        } catch (Exception e) {
            System.out.println("Something went wrong. Game end");
            rec = 2;
        }
        if (rec == 1) {
            System.out.println("Writer mode");
            writer(PC,CC,playerGuessRec, computerGuessRec, result, turn, cowsCountP, bullsCountP, cowsCountC, bullsCountC);
        } else {
            System.out.println("Game end");
            rec=2;
        }


        return rec;
    }

    }

