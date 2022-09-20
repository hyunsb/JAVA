class Solution {
    public String solution(String src) {
        String answer = "";
        String[] strArr = src.split("");
        String[] alphabet = new String[]{"Null","A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        // System.out.print(alphabet[1]);

        int repeatNo = 1; // 반복 횟수
        int chk = 0; // 반복 체크
        int[] repeatArr = new int[20];

        for(int i=0; i<strArr.length-1; i++){
            if (strArr[i].equals(strArr[i+1])){
                repeatNo++;
            }
            else{
                repeatArr[chk] = repeatNo;
                repeatNo = 1;
                chk ++;
            }
        }
        // 같은 문자열로 이루어졌을 경우 반복문 빠져나온 후 반복 횟수 초기화
        repeatArr[chk] = repeatNo;

        answer += strArr[0];
        for(int i=0; i<repeatArr.length; i++){
            // 반복횟수가 없는 경우 반복문 종료
            if(repeatArr[i] == 0){
                break;
            }
            int num = repeatArr[i];
            answer += alphabet[num];
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String src = "111100100011";
        s.solution(src);
    }
}
