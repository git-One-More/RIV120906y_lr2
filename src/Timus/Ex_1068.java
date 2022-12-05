package Timus;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Ex_1068 {
    public static void main(String[] args) throws NumberFormatException,
            IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in ));

        short n = Short.parseShort(reader.readLine());
        int result = 0;

        if (n < 1) {

            for (short i = n; i <= 1; i++) {
                result=(n+1)*(2-(n))/2;
            }
        } else {
            result = (1 + n) * n / 2;
        }
        System.out.println(result);
    }

}