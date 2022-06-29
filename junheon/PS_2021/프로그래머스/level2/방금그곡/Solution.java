package PS_2021.프로그래머스.level2.방금그곡;

import java.util.ArrayList;
import java.util.StringTokenizer;

class Music {
    public int index;
    public String name;
    public String info;

    public Music(int index, String name, String info) {
        this.index = index;
        this.name = name;
        this.info = info;
    }
}

class Solution {

    public String solution(String m, String[] musicinfos) {
        int k = 0;
        String tm = new String();
        while(k < m.length() - 1) {
            if(m.charAt(k + 1) == '#') {
                tm += (char)(m.charAt(k) - 'A' + 'a');
                k += 2;
            } else {
                tm += m.charAt(k);
                k++;
            }
        }
        if(k == m.length() - 1) {
            tm += m.charAt(m.length() - 1);
        }

        ArrayList<Music> musicList = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
            String t1 = st.nextToken();
            String t2 = st.nextToken();
            String name = st.nextToken();
            String mi = st.nextToken();
            String musicInfo = new String();
            int j = 0;
            while(j < mi.length() - 1) {
                if(mi.charAt(j + 1) == '#') {
                    musicInfo += (char)(mi.charAt(j) - 'A' + 'a');
                    j += 2;
                } else {
                    musicInfo += mi.charAt(j);
                    j++;
                }
            }
            if(j == mi.length() - 1) {
                musicInfo += mi.charAt(mi.length() - 1);
            }

            st = new StringTokenizer(t1, ":");
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(t2, ":");
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int t = (h2 - h1) * 60 + m2 - m1;
            String info = new String();
            for(j = 0; j < t; j++) {
                info += musicInfo.charAt(j % musicInfo.length());
            }
            musicList.add(new Music(i, name, info));
        }

        ArrayList<Music> ansList = new ArrayList<>();
        for(Music music : musicList) {
            if(music.info.contains(tm)) {
                ansList.add(music);
            }
        }
        String answer = "(None)";
        if(ansList.size() == 1) {
            answer = ansList.get(0).name;
        }
        else if(ansList.size() > 1) {
            Music ansMusic = ansList.get(0);
            for(Music ans : ansList) {
                if(ans.info.length() > ansMusic.info.length()) {
                    ansMusic = ans;
                }
            }
            answer = ansMusic.name;
        }
        return answer;
    }
}