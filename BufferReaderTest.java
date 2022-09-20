import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferReaderTest {
    public static void main(String args[]) throws Exception {
        String name;
        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("당신의 이름을 입력하세요");
        name = inbr.readLine();
        System.out.println(name);

    }
}
