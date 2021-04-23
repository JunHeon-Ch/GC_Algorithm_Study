#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

bool check_condition(string cond, string line) {
    int s = 0, e = 0, d = cond[4] - '0';
    s = find(line.begin(), line.end(), cond[0]) - line.begin();
    e = find(line.begin(), line.end(), cond[2]) - line.begin();

    int dist = abs(e - s) - 1;
    if(cond[3] == '=') {
        if(dist == d) return true;
    }
    else if(cond[3] == '>') {
        if(dist > d) return true;
    }
    else if(cond[3] == '<') {
        if(dist < d) return true;
    }
    return false;
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, vector<string> data) {
    int answer = 0;
    string line = "ACFJMNRT";

    do {
        bool flag = false;
        for(string cond : data) {
            bool res = check_condition(cond, line);
            if(!res) {
                flag = false;
                break;
            }
            flag = true;
        }
        if(flag) answer++;
    } while(next_permutation(line.begin(), line.end()));
    
    return answer;
}