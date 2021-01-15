//
//  main.cpp
//  11656
//
//  Created by 이원창 on 2020/12/27.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    string str = "";
    vector<string> v;
    cin >> str;
    
    for(int i = 0; i < str.length(); i++){
        v.push_back(str.substr(i));
    }
    
    sort(v.begin(), v.end());
    for(int i = 0; i < v.size(); i++){
        cout << v[i] << '\n';
    }
    return 0;
}
