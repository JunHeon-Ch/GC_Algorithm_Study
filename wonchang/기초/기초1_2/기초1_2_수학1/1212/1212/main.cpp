//
//  main.cpp
//  1212
//
//  Created by 이원창 on 2020/12/30.
//

#include <iostream>
#include <cmath>
using namespace std;
int main(int argc, const char * argv[]) {
    string str = "";
    int flag = 0;
    
    cin >> str;
    if(str.compare("0") == 0){
        cout << "0\n";
        return 0;
    }
    for(long i = 0; i < str.length(); i++){
        for(int j = 4; j >= 1; j /= 2){
            int tmp = (str[i] - '0') & j ? 1 : 0;
            if(tmp == 1)
                flag = 1;
            
            if(flag != 0){
                cout << tmp;
            }
        }
    }
    cout << '\n';

    return 0;
}
