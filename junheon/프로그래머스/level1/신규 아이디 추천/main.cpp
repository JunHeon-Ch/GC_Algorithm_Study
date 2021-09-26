#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <cctype>

using namespace std;

string solution(string new_id) {
    string answer = "";
 
    bool dot = false;
    for(int i = 0; i < new_id.size(); i++) {
        char tmp = new_id[i];
        // 1
        if(new_id[i] >= 'A' && new_id[i] <= 'Z')
            tmp = tolower(new_id[i]);  

        // 2
        if(!((tmp >= 'a' && tmp <= 'z') || (tmp >= '0' && tmp <= '9') || tmp == '-' || tmp == '_' || tmp == '.'))
            continue;

        // 3
        if(tmp == '.') {
            if(dot) continue;
            else dot = true;
        }
        else dot = false;
        
        answer += tmp;
    }
    
    // 4
    int k = 0;
    while(k < answer.size()) {
        if(answer[k] == '.') {            
            answer.erase(answer.begin() + k);
        }
        else {
            break;
        }
        cout << answer[k] << '\n';
    }
    k = answer.size() - 1;
    while(k >= 0) {
        if(answer[k] == '.') {            
            answer.erase(answer.begin() + k);
        }
        else {
            break;
        }
        cout << answer[k] << '\n';
    }   
    cout << answer << '\n';
    // 5
    if(answer.size() == 0) {
        answer += "a";
    }
    
    // 6
    if(answer.size() >= 16) {
        answer.erase(answer.begin() + 15, answer.end());
    }
    k = answer.size() - 1;
    while(k >= 0) {
        if(answer[k] == '.')
            answer.erase(answer.begin() + k);
        else break;
    }   
    
    // 7
    if(answer.size() <= 2) {
        char cot = answer[answer.size() - 1];
        while(answer.size() < 3) {
            answer += cot;
        }
    }
    
    return answer;
}