public class SquareRoot {
    class Solution {
        public long solution(long n) {
            long answer = -1;
            long tmp = (long)Math.sqrt(n);

            if(Math.pow(tmp, 2) == n){
                answer = (long)Math.pow(tmp+1, 2);
            }

            return answer;
        }
    }
}
