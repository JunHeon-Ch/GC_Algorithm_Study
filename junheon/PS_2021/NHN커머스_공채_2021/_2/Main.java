package PS_2021.NHN커머스_공채_2021._2;

import java.util.*;
import java.io.*;

public class Main {

    //표준입력을 수행할 Scanner를 선언한다
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void testCase(int caseNum) throws IOException {   //하나의 테스트케이스를 처리하는 함수
        //각 테스트케이스에 대하여 데이터를 입력받고 정답을 출력하세요
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            String num = st.nextToken();
            set.add(num);
            if(set.size() == m) {
                bw.write((i + 1) + "\n");
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {   //프로그램의 시작부
        int tn = Integer.parseInt(br.readLine()); //테스트케이스의 수를 입력받는다
        for (int caseNum = 1; caseNum <= tn; caseNum++) {   //테스트케이스의 수 만큼 반복 수행한다
            testCase(caseNum);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}