import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CowCollege {
    public static void main(String[] args) {
        // get input from user using BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCows = 0;
        String stringMaxTuitionPerCow = null;
        try {
            numCows = Integer.parseInt(br.readLine());
            // System.out.println("You entered: " + numCows);

            // get next line
            stringMaxTuitionPerCow = br.readLine();
            // System.out.println("You entered: " + stringMaxTuitionPerCow);
        } catch (Exception e) {
            // do nothing
        }

        int[] tuitionPerCow = new int[numCows];
        String[] stringTuitionPerCow = stringMaxTuitionPerCow.split(" ");
        for (int i = 0; i < numCows; i++) {
            tuitionPerCow[i] = Integer.parseInt(stringTuitionPerCow[i]);
        }

        // sort array
        Arrays.sort(tuitionPerCow);

        // key: store how much each cow can pay | value: the number of cows that can pay
        // that in hashmap
        HashMap<Integer, Integer> tuitionMap = new HashMap<Integer, Integer>();

        // print array
        for (int i = 0; i < numCows; i++) {
            int oneCowPay = tuitionPerCow[i];
            int totalAmount = 0;
            // how many cows can pay this particular tuition
            for (int j = 0; j < numCows; j++) {
                if (oneCowPay <= tuitionPerCow[j]) {
                    totalAmount += oneCowPay;
                }
            }

            // add to hashmap
            tuitionMap.put(oneCowPay, totalAmount);
        }

        /*
         * print hashmap
         * for (int key : tuitionMap.keySet()) {
         * System.out.println("$" + key + " | Num: " + tuitionMap.get(key));
         * }
         */

        Map<Integer, Integer> sortedTuitionMap = tuitionMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, HashMap::new));
        
        // find the key of the first occurence of the max value
        int maxTuition = 0;
        int maxTuitionKey = 0;
        for (int key : sortedTuitionMap.keySet()) {
            if (sortedTuitionMap.get(key) > maxTuition) {
                maxTuition = sortedTuitionMap.get(key);
                maxTuitionKey = key;
            }
        }

        System.out.println(maxTuition + " " + maxTuitionKey);
    }
}
