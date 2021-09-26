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

// ���� ������ ������ ��� �Լ� ���� �ʱ�ȭ �ڵ带 �� �ۼ����ּ���.
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