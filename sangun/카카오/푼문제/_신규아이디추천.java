package 푼문제;

public class _신규아이디추천 {
    public static void main(String[] args) {
        String new_id = "abcdefghijklmn.p";
        StringBuilder sb = new StringBuilder();

        sb.append(new_id);
//        System.out.println("0 단계");
//        System.out.println(sb.toString());

        // 1단계
        char[] id = new_id.toLowerCase().toCharArray();
        sb = new StringBuilder();
        sb.append(id);
//        System.out.println("1 단계");
//        System.out.println(sb.toString());

        // 2단계 빼기(-), 밑줄(_), 마침표(.)
        sb = new StringBuilder();
        for (char c : id) {
            if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
//        System.out.println("2 단계");
//        System.out.println(sb.toString());

        // 3단계
        String id_3 = sb.toString();
        while (id_3.contains("..")) {
            id_3 = id_3.replace("..", ".");
        }
        sb = new StringBuilder();
        sb.append(id_3);
//        System.out.println("3 단계");
//        System.out.println(sb);

        // 4단계
        sb = new StringBuilder();
        if (id_3.length() > 0) {
            if (id_3.charAt(0) == '.') {
                sb.append(id_3.substring(1));
            } else {
                sb.append(id_3);
            }
            id_3 = sb.toString();
            sb = new StringBuilder();

        }
        if (id_3.length() > 0) {
            if (id_3.charAt(id_3.length() - 1) == '.') {
                sb.append(id_3.substring(0, id_3.length() - 1));
            } else {
                sb.append(id_3);
            }
        } else {
            sb.append(id_3);
        }
//        System.out.println("4 단계");
//        System.out.println(sb);

        // 5단계
        String id_5 = sb.toString();
        if (id_5.isEmpty()) {
            sb.append('a');
        }
//        System.out.println("5 단계");
//        System.out.println(sb);

        // 6단계
        String id_6 = sb.toString();
        sb = new StringBuilder();
        if (id_6.length() >= 16) {
            if (id_6.charAt(14) == '.') {
                sb.append(id_6.substring(0, 14));
            } else {
                sb.append(id_6.substring(0, 15));
            }
        } else {
            sb.append(id_6);
        }
        System.out.println("6 단계");
        System.out.println(sb);

        // 7단계
        if (sb.length() <= 2) {
            String id_7 = sb.toString();
            while (sb.length() < 3) sb.append(id_7.charAt(id_7.length() - 1));
        }

        System.out.println(sb.toString());

    }
}
