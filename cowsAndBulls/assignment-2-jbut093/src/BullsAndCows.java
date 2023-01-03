import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BullsAndCows {
    public static void main(String[] args) throws IOException {

        int difficulty = new Intro().greeting();
        System.out.println(difficulty);
        System.out.println();
        int rounds = 7;

        System.out.println("Please select your secret code: ");
        humanPlayer p = new humanPlayer();
        p.name = "Human";
        p.playerCode = p.playerNumberSelect();
        String PC = p.playerCode;

        int reader = new Intro().ReaderYN();
        List<String> readUserGuesses = new ArrayList<>();
        if (reader == 1){
            System.out.println("reader mode");
            List<List<String>> userInputCodes = new ArrayList<>();
            userInputCodes.add(Reader.getUserInput());

            String lengthRead = String.valueOf(userInputCodes);


            String toBePassed = "";
            for (int f = 0; f < lengthRead.length(); f++) {
                if (toBePassed.length() == 4) {
                    readUserGuesses.add(toBePassed);
                    toBePassed = "";
                }
                if (Character.isDigit(lengthRead.charAt(f))) {
                    toBePassed = toBePassed + lengthRead.charAt(f);
                }
            }


        } else {
            System.out.println("normal mode");
        }


        System.out.println("Press enter to start the game...");
        System.in.read();


        String namer;
        if (difficulty == 1) {
            namer = "easy";
        } else if (difficulty == 2) {
            namer = "medium";
        } else {
            namer = "hard";
        }
        ComputerEasy c = new ComputerEasy();


        c.name = namer;
        System.out.println(c.name);
        ArrayList<String> allCodes = new ArrayList<>(c.generateAllCodes());
        c.computersCode = c.getEasyGuess(allCodes);
        String CC = c.computersCode;




        ComputerMedium compMedium = new ComputerMedium();
        compMedium.generateAllCodes();


        ComputerHard computerHard = new ComputerHard();


        System.out.println("Humans first, please try and guess the computers code");

        ArrayList<String> playerGuessRec = new ArrayList<>();
        ArrayList<String> computerGuessRec = new ArrayList<>();
        ArrayList<Integer> cowsCountP = new ArrayList<>();
        ArrayList<Integer> bullsCountP = new ArrayList<>();
        ArrayList<Integer> cowsCountC = new ArrayList<>();
        ArrayList<Integer> bullsCountC = new ArrayList<>();
        boolean gameWon = false;


        int turn = 1;
        int result=0;

        String guessRoundComp;

        outer:
     while (!gameWon) {

        String guessRoundPlayer;
            if (reader == 1) {
                guessRoundPlayer = readUserGuesses.get(0);
                readUserGuesses.remove(0);


                if (guessRoundPlayer == null) {
                    guessRoundPlayer = p.playerNumberSelect();
                }

            }else{
              guessRoundPlayer = p.playerNumberSelect();
            }
            playerGuessRec.add(guessRoundPlayer);

            int bull = 0;
            int cow = 0;
            for (int i = 0; i < c.computersCode.length(); i++) {
                if (guessRoundPlayer.charAt(i) == c.computersCode.charAt(i)) {
                    bull++;
                } else if (guessRoundPlayer.contains(String.valueOf(c.computersCode.charAt(i)))) {
                    cow++;
                }if (bull == 4) {
                    System.out.println("Player Guess round " + turn + " player guessed " + guessRoundPlayer);
                    System.out.println(bull + " bulls and " + cow + " cows.");
                    System.out.println("Player guessed in " + turn + " steps");


                    bullsCountP.add(bull);
                    cowsCountP.add(cow);
                    result=1;
                    break outer;
                }
            }
            bullsCountP.add(bull);
            cowsCountP.add(cow);
            System.out.println("Player Guess round " + turn);
            System.out.println(bull + " bulls and " + cow + " cows.");


            guessRoundComp = "";
            if (difficulty == 1) {
                guessRoundComp = c.getEasyGuess(allCodes);
            } else if (difficulty == 2) {
                guessRoundComp = compMedium.getMediumGuess(allCodes);
            } else if (difficulty == 3) {
                guessRoundComp = computerHard.getHardGuess(turn);
            }
            computerGuessRec.add(guessRoundComp);


            int bullC = 0;
            int cowC = 0;
            for (int i = 0; i < p.playerCode.length(); i++) {
                if (guessRoundComp.charAt(i) == p.playerCode.charAt(i)) {
                    bullC++;
                } else if (guessRoundComp.contains(String.valueOf(p.playerCode.charAt(i)))) {
                    cowC++;
                }
                if (bullC == 4) {
                    bullsCountC.add(bullC);
                    cowsCountC.add(cowC);
                    System.out.println("Computer Guess round " + turn +" commuter guessed "+ guessRoundComp);
                    System.out.println(bullC + " bulls and " + cowC + " cows.");
                    System.out.println("Computer guessed in " + turn + " steps");


                    result =2;
                    break outer;
                }

            }
            if (difficulty == 3) {
                computerHard.getCowAndBullsInfo(guessRoundComp, bullC, cowC);
            }

            bullsCountC.add(bullC);
            cowsCountC.add(cowC);

            System.out.println("Computer Guess round " + turn + " is " +guessRoundComp);
            System.out.println(bullC + " bulls and " + cowC + " cows.");

            System.out.println(" ");

            turn++;
            if (turn == rounds + 1) {
                gameWon = true;
                result=3;
                System.out.println("Game has resulted in a draw.");
            }
        }
        System.out.println(" ");
        Writer.requestRecYN(PC,CC, playerGuessRec, computerGuessRec, result, turn,cowsCountP, bullsCountP, cowsCountC, bullsCountC);

    }
   }




