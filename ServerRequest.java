class Solution {
    public String[] solution(int n, String[] queries) {
        String[] answer = new String[queries.length];

        int ReqNum = queries.length;

        // PCname, 요청, 사용중IP, ip할당이력(최근 사용)
        String[][] PCInfo = new String[ReqNum][4];

        // IP, 사용가능 여부(사용중: 1, 사용가능: 0), 할당이력 횟수
        int[][] valIp = new int[n][3];

        //PC name과 요청 분리 및 초기화
        for(int i=0; i<ReqNum-1; i++){
            for (String SeverReq : queries) {
                String[] splitStr = SeverReq.split("\\s+");

                PCInfo[i][0] = splitStr[0];
                PCInfo[i][1] = splitStr[1];
                PCInfo[i][2] = "null";
                PCInfo[i][3] = "null";
            }
        }

        // IP배열 초기화
        for(int i=0; i<n; i++){
            valIp[i][0] = i+1;
            valIp[i][1] = 0;
            valIp[i][2] = 0;
        }

        //요청 확인
        for(int i=0; i<ReqNum-1; i++){
            String PCname, PCreq, PCuseIP, PCrecord;
            PCname = PCInfo[i][0];
            PCreq = PCInfo[i][1];
            PCuseIP = PCInfo[i][2];
            PCrecord = PCInfo[i][3];

            String result;

            // IP요청
            if (PCreq.equals("request")){
                // PC에서 사용중인 IP가 없는 경우
                // IP 할당 이력 확인 후 분기
                if(PCuseIP.equals("null")){
                    // PC에서 IP할당 이력이 없는 경우
                    // 할당 이력이 없는 IP 중 가장 작은 IP 할당
                    // 사용 중이지 않은 IP 중 가장 작은 IP 할당
                    // 모두 사용 중일 시 거부(reject)
                    if(PCuseIP.equals("null")){
                        int IPchk = 0; // 사용 가능한 IP 유무 확인 용도
                        int[] TempIp = new int[20]; // 할당 이력이 있는 IP 저장 (가장 작은 IP 사용)
                        // IP 확인
                        for(int j=0; j<n; j++){
                            // 할당 이력이 없는 IP일 경우
                            if(valIp[j][1] == 0 && valIp[j][2] == 0){
                                PCInfo[i][2] = Integer.toString(valIp[j][0]); // 사용중인 IP를 할당된 IP로 초기화
                                PCInfo[i][3] = Integer.toString(valIp[j][0]); // IP사용 이력을 할당된 IP로 초기화
                                valIp[j][2] += 1; // IP의 사용이력 1추가

                                result = "192.168.0." + Integer.toString(valIp[j][0]);
                                break;
                            }
                            // 할당 이력이 있는 IP일 경우
                            else if(valIp[j][1] == 0 && valIp[j][2] != 0){
                                TempIp[j] = valIp[j][0];
                                IPchk += 1;
                            }
                        }

                        if (IPchk == 0){
                            result = "reject";
                        }
                    }
                    // 해당 PC가 IP할당 이력이 있는 경우
                    // 최근 사용한 IP 할당
                    //
                    else{

                    }
                }
            }
            // IP 반납 (응답X)
            // 해당 PC가 IP를 할당 중인지 확인 및 반납
            else if(PCInfo[i][1].equals("release")){
            }
            else {
                System.out.print("error");
            }

            answer[i] = PCname + " " + result;
        }

        return answer;
    }
}