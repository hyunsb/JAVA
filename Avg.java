public class Avg {
    class Solution {
        public double solution(int[] arr) {
            double answer = 0;

            if (arr != null) {
                for (int i : arr) {
                    answer += i;
                }
            }

            return answer/arr.length;
        }
    }
}
