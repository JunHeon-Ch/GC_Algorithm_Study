package 토스;

public class _3 {
    public static void main(String[] args) {
        String amountText = "+300";

//        // 앞이 0인지 확인
        boolean valid = false;
//        for (int i = 0; i < amountText.length(); i++) {
//            if (amountText.charAt(i) < '0' || amountText.charAt(i) > '9') {
//                if (amountText.charAt(i) != ',') {
//                    System.out.println("asd");
//                }
//            }
//        }

        int k = amountText.length()-4;
        if (amountText.contains(",")) {
            valid = true;
        }
        for (int i = amountText.length() - 1; i >= 0; i--) {
            if (amountText.charAt(i) < '0' || amountText.charAt(i) > '9') {
                if (amountText.charAt(i) != ',') {
                    System.out.println("Asdasd");
                }
            }
            if (valid && i == k) {
                if (amountText.charAt(i) == ',') {
                    valid = true;
                    k -= 4;
                } else {
                    System.out.println("Asdasdasd");
                }
            }

        }
    }
}
