public class lesson1 {
    public static void main(String[] args) {
        int N = 32;
        int t = 0;
        int s = 0;
        int e = 0;
        int max = 0;
        while (N >> t != 0) {
            if (((N >> t) & 1) == 1) {
                e = t;
                if (s != 0) {
                    max = Math.max(e - s, max);
                }
                s = t;
            }


            t++;
        }
        if (max==0)
        System.out.println(max-1);
    }
}
