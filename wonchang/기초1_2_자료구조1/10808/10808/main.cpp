//
//  main.cpp
//  10808
//
//  Created by 이원창 on 2020/12/27.
//

#include <iostream>
#include <deque>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string str = "";
    int alpha[26] = {0, };

    cin >> str;
    for(int i = 0; i < str.length(); i++){
        alpha[str[i] - 97]++;
    }
    
    for(int i = 0; i < 26; i++){
        cout << alpha[i] << ' ';
    }
    cout << '\n';
    return 0;
}
