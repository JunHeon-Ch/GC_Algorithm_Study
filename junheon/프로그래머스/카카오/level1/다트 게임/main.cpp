#include <string>
#include <iostream>
#include <cmath>

using namespace std;

int solution(string dartResult) {
    int answer = 0;

    int option = 1, bonus = 1;
    bool star = false;
    for(int i = dartResult.length() - 1; i >= 0; i--) {
        if(dartResult[i] == '*') {
            option = 2;
        }
        else if(dartResult[i] == '#') {
            option = -1;
        }
        else if(dartResult[i] == 'S') {
            bonus = 1;
        }
        else if(dartResult[i] == 'D') {
            bonus = 2;
        }
        else if(dartResult[i] == 'T') {
            bonus = 3;
        }
        else {
            int num = dartResult[i] - '0';
            if(num == 0 && dartResult[i - 1] == '1') {
                num = 10;
                i--;
            }
            num = pow(num, bonus) * option;
            if(star) {
                num *= 2;
            }
            answer += num;
            if(option == 2) {
                star = true;
            }
            else {
                star = false;
            }
            option = 1;
        }
    }
    return answer;
}