public class Intro extends BullsAndCows {


    public int greeting(){

        System.out.println("Welcome to Bulls and Cows");
        System.out.println("The object of the game is to guess your opponents 4 unique digit code before they guess yours");
        System.out.println("Please select difficulty");
        System.out.print("1 for easy, 2 for medium or 3 for hard");
        int difficulty;

        try {
            difficulty= Integer.parseInt(Keyboard.readInput());

        } catch (Exception e){
            System.out.println("Something went wrong. Easy mode selected");
            difficulty=1;
        }

        if(difficulty <1 || difficulty >3) {
            difficulty=1;
       }
        if (difficulty ==3){
            System.out.println("You chose hard difficulty");
         }else if(difficulty ==2){
            System.out.println("You chose medium difficulty");
        }else{
            System.out.println("You chose easy difficulty");
        }

         return difficulty;


    }
    public int ReaderYN(){

        int reader = 0;
        System.out.println("Would you like to use pre written codes from a file?");
        System.out.println("if yes, please press the number 1. If not press any other number. ");
        try {
            reader = Integer.parseInt(Keyboard.readInput());

        } catch (Exception e) {
            System.out.println("Something went wrong. Normal mode selected");
            reader = 2;
        }
        if (reader == 1) {
            System.out.println(reader);

        } else {
            reader=2;
        }
        return reader;
    }
}

