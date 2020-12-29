//
//  main.cpp
//  1406
//
//  Created by 이원창 on 2020/12/22.
//

#include <iostream>
#include <vector>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    string str;
    vector<char> front;
    vector<char> back;
    cin >> str;
    cin >> n;
    
    for(int i = 0; i < str.length(); i++){
        front.push_back(str[i]);
    }
    
    for(int i = 0; i < n; i++){
        char tmp;
        cin >> tmp;
        
        if(tmp == 'L'){
            if(front.size() > 0){
                back.push_back(front.back());
                front.pop_back();
            }
        }
        else if(tmp == 'D'){
            if(back.size() > 0){
                front.push_back(back.back());
                back.pop_back();
            }
        }
        else if(tmp == 'P'){
            char temp;
            cin >> temp;
            front.push_back(temp);
        }
        else if(tmp == 'B'){
            if(front.size() > 0)
                front.pop_back();
        }
    }
    
    int len = back.size();
    if(len > 0){
        for(int i = 0; i < len; i++){
            front.push_back(back.back());
            back.pop_back();
        }
    }

    for(int i = 0; i < front.size(); i++){
        cout << front[i];
    }
    cout << '\n';
    return 0;
}
