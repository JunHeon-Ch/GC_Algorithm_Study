import java.util.ArrayList;

public class _뉴스클러스터링 {
    static ArrayList<String> s1 = new ArrayList<>();
    static ArrayList<String> s2 = new ArrayList<>();
    static ArrayList<String> result1 = new ArrayList<>();
    static ArrayList<String> result2 = new ArrayList<>();

    public static void main(String[] args) {
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        String temp1 = "";
        String temp2 = "";

        for (int i = 0; i < str1.length(); i++) {
            temp1 += str1.charAt(i);
        }
        for (int i = 0; i < str2.length(); i++) {
            temp2 += str2.charAt(i);
        }

        System.out.println(temp1);
        System.out.println(temp2);
        make(temp1, temp2);

        System.out.println(s1);
        System.out.println(s2);

        result2.addAll(s1);
        result2.addAll(s2);

        for (int i = 0; i < s1.size(); i++) {
            if (s2.contains(s1.get(i))) {
                result1.add(s1.get(i));
                s2.remove(s1.get(i));
            }
        }


        for (int i = 0; i < result1.size(); i++) {
            result2.remove(result1.get(i));
        }
        System.out.println(result1);
        System.out.println(result2);

        int answer = (int) ((float) result1.size() / result2.size() * 65536);
        if (result1.size()==0&&result2.size()==0){
            answer=65536;
        }
        System.out.println(answer);


    }

    static void make(String a, String b) {
        for (int i = 0; i < a.length() - 1; i++) {
            if (!(a.charAt(i) > 'z' || a.charAt(i) < 'a') && !(a.charAt(i + 1) > 'z' || a.charAt(i + 1) < 'a')) {
                s1.add(a.substring(i, i + 2));
            }
        }
        for (int i = 0; i < b.length() - 1; i++) {
            if (!(b.charAt(i) > 'z' || b.charAt(i) < 'a') && !(b.charAt(i + 1) > 'z' || b.charAt(i + 1) < 'a')) {
                s2.add(b.substring(i, i + 2));
            }
        }
    }
}
