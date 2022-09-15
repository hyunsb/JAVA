import java.util.Scanner;
public class tile {
    public static void main(String[] args) throws Exception {
//        타일 채우기
//        타일 : 3*2 -> [1*2, 2*1], [2*1, 1*2], [(1*2) * 3]
//        타일 : 3*4 -> [(1*2) * 2, (2*1) * 4] * 2

//        case1 : 3*8 벽 -> 3*6 + 3*2 으로 채우는 경우
//        case2 : 3*8 벽 -> 3*4 + 3*4 으로 채우는 경우
//        case3 : 3*8 벽 -> 3*2 + 3*6 으로 채우는 경우

//        F[8] = ( F[6] * F[2] ) + ( F[4] * 2 ) + ( F[2] * 2 ) + 2
//        F[N] = ( F[N - 2] * F[2] ) + ( F[N - 4] * 2 ) + ( F[N - 6] * 2) + ( F[N - 8] * 2 ) + ... + ( F[0] * 2 )

        // N값 입력
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();

        // 입력받은 정수 N개의 배열 dp생성
        int[] dp = new int[n + 1];

        int answer = 0;

        // N이 홀수인 경우 불가능
        if (n % 2 == 1) {
            answer = 0;
        } else {
            dp[0] = 1;
            dp[2] = 3;

            for (int i = 4; i <= n; i += 2) {
                dp[i] = dp[i - 2] * dp[2];
                for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] += dp[j] * 2;
                }
            }
            answer = dp[n];
        }

        System.out.println(answer);
        sc.close();
    }
}
