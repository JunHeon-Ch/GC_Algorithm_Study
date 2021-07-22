import java.util.ArrayList;
import java.util.HashMap;

public class _압축 {
    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        HashMap<String, Integer> hashMap = new HashMap<>();
        int cnt = 27;
        ArrayList<Integer> ans = new ArrayList<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            hashMap.put(i + "", i - 'A' + 1);
        }

        System.out.println(hashMap);
        int i=0;
        while (i<msg.length()){
            int j = 1;
            while (j <= msg.length() - i) {
                if (!hashMap.containsKey(msg.substring(i, i + j))) {
                    hashMap.put(msg.substring(i, i + j), cnt++);
                    break;
                }
                j++;
            }
            if (j >= msg.length()) {
                ans.add(hashMap.get(msg.substring(i)));
                break;
            }
            ans.add(hashMap.get(msg.substring(i, i + j - 1)));
            i = j + i - 1;

        }
        System.out.println(hashMap);
        System.out.println(ans);
    }
}
