#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int change_num(string str) {
    int n = 0;
    int k = 1;
    for(int i = str.size() - 1; i >= 0; i--) {
        n += k * (str[i] - '0');
        k *= 10;
    }
    return n;
}

bool compare(string s1, string s2) {
    return s1.size() < s2.size();
}

vector<int> solution(string s) {
    vector<int> answer;
    vector<string> v;
    s = s.substr(1, s.size() - 2);
    string digit = "";
    for(char c : s) {
        if(c == '}') {
            v.push_back(digit);
        }
        else if(c == '{') {
            digit = "";
        }
        else {
            digit += c;
        }
    }
    sort(v.begin(), v.end(), compare);
    
    for(string str : v) {
        string tmp = "";
        int n;
        for(char d : str) {
            if(d == ',') {
                n = change_num(tmp);
                if(find(answer.begin(), answer.end(), n) == answer.end()) {
                    answer.push_back(n);
                }
                tmp = "";
            } else {
                tmp += d;
            }
        }
        n = change_num(tmp);
        if(find(answer.begin(), answer.end(), n) == answer.end()) {
            answer.push_back(n);
        }
    }
    
    return answer;
}