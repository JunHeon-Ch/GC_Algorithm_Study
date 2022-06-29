// 채점 결과
// 정확성: 40.0
// 효율성: 60.0
// 합계: 100.0 / 100.0

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<string> querySplit(string s) {
    vector<string> res;
    string tmp = "";
    for(char c : s) {
        if(c == ' ') {
            if(tmp == "and") {
                tmp = "";
                continue;
            }
            res.push_back(tmp);
            tmp = "";
        }
        else {
            tmp += c;
        }
    }
    res.push_back(tmp);
    return res;
}

vector<int> infoSplit(string s) {
    vector<int> res;
    string tmp = "";

    int i = 0;
    for(char c : s) {
        if(c == ' ') {
            if(tmp == "cpp" || tmp == "backend" || tmp == "junior" || tmp == "chicken") {
                i = 0;
            } else if (tmp == "python") {
                i = 2;
            } else {
                i = 1;
            }
            res.push_back(i);
            tmp = "";
        } else {
            tmp += c;
        }
    }
    res.push_back(stoi(tmp));
    return res;
}

vector<int> solution(vector<string> info, vector<string> query) {
    vector<int> answer;
    vector<int> table[3][2][2][2];
    for(string s : info) {
        vector<int> v = infoSplit(s);
        table[v[0]][v[1]][v[2]][v[3]].push_back(v[4]);
    }

    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 2; j++) {
            for(int k = 0; k < 2; k++) {
                for(int l = 0; l < 2; l++) {
                    sort(table[i][j][k][l].begin(), table[i][j][k][l].end());
                }
            }
        }
    }

    for(string s : query) {
        vector<string> v = querySplit(s);

        int li, ri, lj, rj, lk, rk, ll, rl;
        if(v[0] == "cpp") {
            li = ri = 0;
        } else if(v[0] == "java") {
            li = ri = 1;
        } else if(v[0] == "python") {
            li = ri = 2;
        } else {
            li = 0; ri = 2;
        }

        if(v[1] == "backend") {
            lj = rj = 0;
        } else if(v[1] == "frontend") {
            lj = rj = 1;
        } else {
            lj = 0; rj = 1;
        }

        if(v[2] == "junior") {
            lk = rk = 0;
        } else if(v[2] == "senior") {
            lk = rk = 1;
        } else {
            lk = 0; rk = 1;
        }

        if(v[3] == "chicken") {
            ll = rl = 0;
        } else if(v[3] == "pizza") {
            ll = rl = 1;
        } else {
            ll = 0; rl = 1;
        }

        int score = stoi(v[4]);

        int ans = 0;
        for(int i = li; i <= ri; i++) {
            for(int j = lj; j <= rj; j++) {
                for(int k = lk; k <= rk; k++) {
                    for(int l = ll; l <= rl; l++) {
                        if(table[i][j][k][l].size() == 0) continue;
                        ans += table[i][j][k][l].end() - lower_bound(table[i][j][k][l].begin(), table[i][j][k][l].end(), score);
                    }
                }
            }
        }
        answer.push_back(ans);
    }

    return answer;
}