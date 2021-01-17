//
//  main.cpp
//  1107
//
//  Created by 이원창 on 2021/01/15.
//

#include <iostream>
#include <algorithm>
#include <cstring>
#include <climits>
using namespace std;
bool btn[10] = {false, };
string s = "";
string n = "";
int m = 0;
int ans = INT_MAX;
bool remote(string s){
    for(int i = 0; i < s.length(); i++){
        if(btn[s[i] - '0']){
            return false;
        }
    }
    
    return true;
}
int main(int argc, const char * argv[]) {
    
    cin >> n;
    getchar();
    cin >> m;
    for(int i = 0; i < m; i++){
        int tmp = 0;
        cin >> tmp;
        btn[tmp] = true;
    }
    

    for(int i = 0; i <= 1000000; i++){
        string tmp = to_string(i);
        if(remote(tmp)){
            int temp = abs(stoi(tmp) - stoi(n)) + (int)tmp.length();
            ans = min(ans, temp);
            
        }
    }
        
    ans = min(ans, abs(stoi(n) - 100));
    cout << ans << '\n';
    return 0;
}
