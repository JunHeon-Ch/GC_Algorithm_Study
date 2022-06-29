package PS_2021.카카오브레인_패스파인더_2021.Problem2;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

import java.net.*;

class Result {

    public static List<String> getTopRatedFoodOutlets(String city) throws MalformedURLException, IOException {
        int page = 1, total = 0;
        List<String> nameList = new ArrayList<>();
        List<Double> rateList = new ArrayList<>();
        Double maxVal = Double.MIN_VALUE;
        do {
            URL url = new URL("https://jsonmock.hackerrank.com/api/food_outlets?city=" + city + "&page=" + page);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

            String str = br.readLine();
            System.out.println(str);
            str = str.replaceAll("[\\[\\]\\{\\}\"]", "");
            String[] strArr = str.split(":|,");
            boolean pageFlag = false;
            boolean nameFlag = false;
            boolean rateFlag = false;
            String name = "";
            for(String s : strArr) {
                if(s.equals("total_pages")) {
                    pageFlag = true;
                    continue;
                }
                if(s.equals("name")) {
                    nameFlag = true;
                    continue;
                }
                if(s.equals("average_rating")) {
                    rateFlag = true;
                    continue;
                }
                if(pageFlag) {
                    total = Integer.parseInt(s);
                    pageFlag = false;
                }
                if(nameFlag) {
                    name = s;
                    nameList.add(s);
                    nameFlag = false;
                }
                if(rateFlag) {
                    double val = Double.parseDouble(s);
                    rateList.add(val);
                    maxVal = Math.max(maxVal, val);
                    rateFlag = false;
                }
            }
            page++;
        } while(page <= total);

        List<String> ans = new ArrayList<>();
        for(int i = 0; i < rateList.size(); i++) {
            if(rateList.get(i).equals(maxVal) && !ans.contains(nameList.get(i))) {
                ans.add(nameList.get(i));
            }
        }
        for(String str : ans) {
            System.out.println(str);
        }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String city = bufferedReader.readLine();

        List<String> result = Result.getTopRatedFoodOutlets(city);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
