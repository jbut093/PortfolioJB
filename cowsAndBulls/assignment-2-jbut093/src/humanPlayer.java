import java.util.Scanner;


public class humanPlayer{
    String name;
    String playerCode;

    public String playerNumberSelect() {

        int round = 4;
        Scanner scanner = new Scanner(System.in);
        String playerInput1 = " ";
        boolean digits = false;
        boolean unique = true;

        while (!digits || !unique) {
            System.out.println("Enter a four digit code: ");
            playerInput1 = scanner.nextLine();

            if (round != playerInput1.length()) {
                continue;
            }
            if (Character.isDigit(playerInput1.charAt(0)) &&
                    Character.isDigit(playerInput1.charAt(1)) &&
                    Character.isDigit(playerInput1.charAt(2)) &&
                    Character.isDigit(playerInput1.charAt(3))) {
                digits = true;
            }
    unique= checkUnique(playerInput1);


        }


        return playerInput1;


    }
    private boolean checkUnique(String playerInput1){
        for (int outer = 0; outer < playerInput1.length(); outer++) {
            for (int inner = 0; inner < playerInput1.length(); inner++) {
                if (playerInput1.charAt(outer) == playerInput1.charAt(inner) && outer != inner) {
                    System.out.println("please enter a unique for digit number");
                    return false;


                }
            }
        }
     return true;
    }


}
