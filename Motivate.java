import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Motivate {
    public static void main(String[] args) throws IOException {
        String str1, str2;
        str1 = "JAVA\t";
        str2 = "RESTART!";
        System.out.println(str1+str2);

        String name2;
        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
        name2 = inbr.readLine();
        System.out.printf("입력값 : " + name2);
    }
}
