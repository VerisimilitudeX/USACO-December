import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) {
        // get input from user using BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = br.readLine();
            System.out.println("You entered: " + input);

            // get next line
            input = br.readLine();
            System.out.println("You entered: " + input);
        } catch (Exception e) {
            // do nothing
        }
    }
}
