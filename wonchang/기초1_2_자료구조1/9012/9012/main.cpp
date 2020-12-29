//
//  main.cpp
//  9012
//
//  Created by 이원창 on 2020/12/22.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    cin >> n;
    for(int i = 0; i < n; i++){
        int cnt = 0;
        string str = "";
        cin >> str;
        for(int j = 0; j < str.length(); j++){
            if(str[j] == '(')
                cnt++;
            else
                cnt--;

            if(cnt == -1){
                cout << "NO" << endl;
                break;
            }
        }
        if(cnt == 0)
            cout << "YES" << endl;
        else if(cnt != -1 and cnt != 0)
            cout << "NO" << endl;
    }
    return 0;
}
