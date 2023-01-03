import java.util.Iterator;
import java.util.List;

public class ComputerHard extends ComputerMedium{

    List<String> allCodes;

    public ComputerHard() {
        allCodes = generateAllCodes();
    }

    public String getHardGuess(int turn){


        String hardGuess = allCodes.get(0);
        allCodes.remove(0);

        return hardGuess;
    }
    public String getCowAndBullsInfo(String guess, int bullC, int cowC){

        int internalBull = 0;
        int internalCow = 0;

        int j;
        String toBeChecked;

        Iterator<String> it = allCodes.iterator();
        while (it.hasNext()) {

            internalBull = 0;
            internalCow = 0;
            toBeChecked = it.next();
            outer:
            for (j = 0; j < guess.length(); j++) {

                try {
                    if (toBeChecked.charAt(j) == guess.charAt(j)) {
                        internalBull++;

                    } else if (toBeChecked.contains(String.valueOf(guess.charAt(j)))) {
                        internalCow++;
                   }

                } catch (IndexOutOfBoundsException e) {
                    //i++;
                    break outer;

                }
            }

            if (internalBull != bullC || internalCow != cowC) {
                it.remove();
            }
        }














        return allCodes.get(0);
    }


}
