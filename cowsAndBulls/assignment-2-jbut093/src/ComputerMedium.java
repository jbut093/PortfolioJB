import java.util.*;


public class ComputerMedium extends ComputerEasy{

    public String getMediumGuess(ArrayList<String> allCodes){
        List<String> mediumUsed = new ArrayList<>(); //Array list kept to store older codes
        Collections.shuffle(allCodes);
        String mediumGuess = allCodes.get(0);
        mediumUsed.add(allCodes.get(0));
        allCodes.remove(0);

        return mediumGuess;
    }
}













