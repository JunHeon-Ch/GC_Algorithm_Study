package 프로그래머스.level2.파일명_졍렬;

import java.util.ArrayList;
import java.util.Collections;

class File {
    public int id;
    public String head;
    public String number;
    public String tail;

    public File(int id, String head, String number, String tail) {
        this.id = id;
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
}

class Solution {
    public String[] solution(String[] files) {
        ArrayList<File> fileList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String file = files[i];

            int j = 0;
            char letter = file.charAt(j);
            while (!(letter >= '0' && letter <= '9')) {
                if(++j == file.length()) break;
                letter = file.charAt(j);
            }
            String head = file.substring(0, j);

            int k = j;
            if(k < file.length()) {
                letter = file.charAt(k);
                while (letter >= '0' && letter <= '9') {
                    if(++k == file.length()) break;
                    letter = file.charAt(k);
                }
            }

            String number = new String();
            String tail = new String();
            if (k != j) number = file.substring(j, k);
            if (k != file.length()) tail = file.substring(k);

            fileList.add(new File(i, head, number, tail));
        }

        Collections.sort(fileList, (o1, o2) -> {
            // head 비교
            int flag = o1.head.compareToIgnoreCase(o2.head);
            if (flag != 0) return flag;

            // number 비교
            if (o1.number.length() != 0 && o2.number.length() != 0) {
                Integer n1 = Integer.parseInt(o1.number);
                Integer n2 = Integer.parseInt(o2.number);
                flag = n1.compareTo(n2);
                if (flag != 0) return flag;
            } else if (o1.number.length() == 0 && o2.number.length() != 0) return 1;
            else if (o2.number.length() == 0 && o1.number.length() != 0) return -1;

            // id 비교
            Integer n1 = new Integer(o1.id);
            Integer n2 = new Integer(o2.id);
            flag = n1.compareTo(n2);
            return flag;
        });

        String[] answer = new String[fileList.size()];
        for (int i = 0; i < fileList.size(); i++) {
            File f = fileList.get(i);
            String file = f.head + f.number + f.tail;
            answer[i] = file;
        }
        return answer;
    }
}