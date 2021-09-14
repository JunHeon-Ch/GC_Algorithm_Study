package 다시풀기;

public class 신규아이디추천 {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";


        // 1
        new_id = new_id.toLowerCase();

        // 2
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            if (new_id.charAt(i) < 'a' && new_id.charAt(i) > 'z') {
                if (new_id.charAt(i) != '.' && new_id.charAt(i) != '-' && new_id.charAt(i) != '_') {
                    continue;
                }
            }
            sb.append(new_id.charAt(i));
        }
        System.out.println(sb.toString());

    }
}
