#include <string>
#include <vector>

using namespace std;

bool check_sentence(string s) {
    int cnt = 0;
    for(char c : s) {
        if(c == '(') cnt++;
        else if(c == ')') cnt--;
        if(cnt < 0) return false;
    }
    return true;
}

string go(string p) {
    if(p.size() == 0) return p;
    
    int cnt = 0, i = 0;
    string u = "";
    string v = "";
    for(char c : p) {
        if(c == '(') cnt++;
        else if(c == ')') cnt--;
        i++;
        if(cnt == 0) {
            u = p.substr(0, i);
            v = p.substr(i, p.size());
            break;
        }
    }
    if(check_sentence(u)) {
        return u + go(v);
    }
    
    v = '(' + go(v) + ')';
    u = u.substr(1, u.size() - 2);
    for(char c : u) {
        if(c == '(') v += ')';
        else v += '(';
    }
    return v;
}

string solution(string p) {
    string answer = "";
    if(p.size() == 0) return answer;
    if(check_sentence(p)) return p;
    answer = go(p);
    return answer; 
}