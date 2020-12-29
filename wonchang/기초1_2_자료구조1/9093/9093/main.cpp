//
//  main.cpp
//  9093
//
//  Created by 이원창 on 2020/12/22.
//

#include <iostream>
using namespace std;
string flip(string str){
    char temp;
    for(int i = 0; i < str.size()/2; i++){
        temp = str[i];
        str[i] = str[str.size() - i - 1];
        str[str.size() - i - 1] = temp;
    }
    return str;
}
int main(int argc, const char * argv[]) {
    int n = 0;
    string ans = "";
    cin >> n;
    cin.ignore(32767, '\n');
    for(int i = 0; i < n; i++){
        string str = "";
        string temp = "";
        getline(cin, str);
        for(int j = 0; j < str.length(); j++){
            if(str[j] == ' '){
                cout << flip(temp) << ' ';
                temp = "";
            }
            else
                temp += str[j];
        }
        cout << flip(temp) << ' ' << endl;
    }
    return 0;
}
