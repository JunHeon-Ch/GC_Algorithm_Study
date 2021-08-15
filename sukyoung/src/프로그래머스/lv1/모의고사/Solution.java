package 프로그래머스.lv1.모의고사;

import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int corr1 = stud1(answers);
        int corr2 = stud2(answers);
        int corr3 = stud3(answers);

        ArrayList<Integer> students = new ArrayList<Integer>();
        if(corr1 > corr2){
            if(corr1 > corr3) {
                students.add(1);
            }
            else if(corr1 == corr3){
                students.add(1);
                students.add(3);
            }
            else {
                students.add(3);
            }
        }
        else if(corr1 == corr2){
            if(corr1 > corr3){
                students.add(1);
                students.add(2);
            }
            else if(corr1 == corr3){
                students.add(1);
                students.add(2);
                students.add(3);
            }
            else{
                students.add(3);
            }
        }
        else{
            if(corr2 > corr3){
                students.add(2);
            }
            else if(corr2 == corr3){
                students.add(2);
                students.add(3);
            }
            else{
                students.add(3);
            }
        }

        answer = new int[students.size()];
        for(int i =0; i<answer.length; i++) {
            answer[i] = students.get(i);
        }

        return answer;
    }
    public int stud1(int[] answers){
        int correct = 0;
        int[] student1 = {1,2,3,4,5};
        for(int i=0; i<answers.length; i++){
            if(student1[i%5] == answers[i]){
                correct++;
            }
        }
        return correct;
    }
    public int stud2(int[] answers){
        int correct = 0;
        int[] student2 = {2,1,2,3,2,4,2,5};
        for(int i=0; i<answers.length; i++){
            if(student2[i%8] == answers[i])
                correct++;
        }
        return correct;
    }
    public int stud3(int[] answers){
        int correct = 0;
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        for(int i=0; i<answers.length; i++){
            if(student3[i%10] == answers[i])
                correct++;
        }
        return correct;
    }
}