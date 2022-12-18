import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class CowCollege {
    public static void main(String[] args) {
        // get input from user using BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCows = 0;
        String stringMaxTuitionPerCow = null;
        try {
            numCows = Integer.parseInt(br.readLine());

            // get next line
            stringMaxTuitionPerCow = br.readLine();
        } catch (Exception e) {
            // do nothing
        }

        long[] tuitionPerCow = new long[numCows];
        String[] stringTuitionPerCow = stringMaxTuitionPerCow.split(" ");
        for (int i = 0; i < numCows; i++) {
            tuitionPerCow[i] = Integer.parseInt(stringTuitionPerCow[i]);
        }

        // sort array
        Arrays.sort(tuitionPerCow);

        long leastOnePerCow = 0;
        long maxTotalAmount = 0;

        // for each cow, find out how many cows can pay this tuition
        for (int i = 0; i < numCows; i++) {
            long oneCowPay = tuitionPerCow[i];
            long totalAmount = 0;
            // how many cows can pay this particular tuition
            for (int j = 0; j < numCows; j++) {
                if (oneCowPay <= tuitionPerCow[j]) {
                    totalAmount += oneCowPay;
                }
            }

            if (totalAmount > maxTotalAmount) {
                maxTotalAmount = totalAmount;
                leastOnePerCow = oneCowPay;
            } else if (totalAmount == maxTotalAmount && oneCowPay < leastOnePerCow) {
                leastOnePerCow = oneCowPay;
            }
        }

        System.out.println(maxTotalAmount + " " + leastOnePerCow);
    }
}
