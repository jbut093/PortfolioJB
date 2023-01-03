import java.util.*;
import java.util.ArrayList;

public class computerRandom<compCode> extends BullsAndCows {

    public static String computerRandomNumber(){
// Old hashSet random code generator. Used in the second version of the code.
        Random random = new Random();

        int round = 4;
        HashSet<Integer> randomHash = new HashSet<>();
        for (int i=0; round>randomHash.size(); i++){
            randomHash.add(random.nextInt(10));
        }
        List<Integer> compCode = new ArrayList<Integer>(randomHash);
        Collections.shuffle(compCode);
        String computersCode= String.valueOf(compCode);

        return computersCode;

    }
}

