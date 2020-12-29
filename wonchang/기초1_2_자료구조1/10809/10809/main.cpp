//
//  main.cpp
//  10809
//
//  Created by 이원창 on 2020/12/27.
//

#include <iostream>
#include <cstring>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string str = "";
    int visit[26] = {0, };
    int alpha[26] = {-1, };
    

    cin >> str;
    memset(alpha, -1, sizeof(alpha));
    for(int i = 0; i < str.length(); i++){
        if(visit[str[i] - 97] == 0){
            alpha[str[i] - 97] = i;
            visit[str[i] - 97] = 1;
        }
    }
    
    for(int i = 0; i < 26; i++){
        cout << alpha[i] << ' ';
    }
    cout << '\n';
    
    
    return 0;
}
