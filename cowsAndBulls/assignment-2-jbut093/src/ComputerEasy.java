import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ComputerEasy extends BullsAndCows {

    String name;
    String computersCode;


    public boolean allDigitsUnique(String runner) {

        for (int i = 0; i < runner.length(); i++) {
            for (int j = 0; j < runner.length(); j++) {
                if (runner.charAt(i) == runner.charAt(j) && i != j) {

                    return false;
                }
            }
        }
        return true;
    }

    public List<String> generateAllCodes() {
        List<String> integersWithoutRepeatingDigits = new ArrayList<>();
        String runner = " ";
        for (int i = 123; i <= 9876; i++) {
            String intToStringBlankSpace="";
            if(i<1000){
                intToStringBlankSpace ="0" + Integer.toString(i);
            }else{
                intToStringBlankSpace = Integer.toString(i);
            }
            if (allDigitsUnique(intToStringBlankSpace)){
                if (i < 1000) {
                    runner = "0" + i;

                } else {
                    runner = "" + i;
                }
                integersWithoutRepeatingDigits.add(runner);
            }
        }
        return integersWithoutRepeatingDigits;

    }

    public String getEasyGuess(ArrayList<String> allCodes){
       Collections.shuffle(allCodes);
       String easyGuess = allCodes.get(0);

        return easyGuess;
    }
}


