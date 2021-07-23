import java.util.LinkedList;

public class _캐시 {
    public static void main(String[] args) {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};


        LinkedList<String> cache = new LinkedList<>();

        int answer = 0;
        if (cacheSize == 0) {
            return;
        }
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
            // hit
            if (cache.contains(cities[i])) {
                cache.remove(cities[i]);
                cache.addFirst(cities[i]);
                answer++;
            }
            // miss
            else {
                if (cache.size() == cacheSize) {
                    cache.removeLast();
                    cache.addFirst(cities[i]);
                } else {
                    cache.addFirst(cities[i]);
                }
                answer += 5;
            }
        }
        System.out.println(answer);
    }
}
