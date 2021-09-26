package 다시풀기;

public class 신규아이디추천 {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm..";


        // 1
        new_id = new_id.toLowerCase();

        // 2
        StringBuilder sb = new StringBuilder();
        for (char c : new_id.toCharArray()) {
            if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }

        // 3
        String str = sb.toString();
        while (str.contains("..")) {
            str = str.replace("..", ".");
        }

        // 4
        if (str.length() > 0 && str.charAt(0) == '.') {
            str = str.substring(1);
        }
        if (str.length() > 0 && str.charAt(str.length() - 1) == '.') {
            str = str.substring(0, str.length() - 1);
        }


        // 5
        if (str.length() == 0) {
            str = "a";
        }

        // 6
        if (str.length() >= 16) {
            str = str.substring(0, 15);
        }
        // 4
        if (str.charAt(str.length() - 1) == '.') {
            str = str.substring(0, str.length() - 2);
        }

        // 7
        if (str.length() <= 2) {
            char k = str.charAt(str.length() - 1);
            while (str.length() < 3) {
                str += k;
            }
        }

        System.out.println(str);


    }
}
