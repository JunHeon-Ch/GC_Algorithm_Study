#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<string> strList;

    string str;
    cin >> str;

    for(int i = 0; i < str.size(); i++) {
        strList.push_back(str.substr(i));
    }
    sort(strList.begin(), strList.end());
    

    for(int i = 0; i < strList.size(); i++) {
        cout << strList[i] << '\n';
    }
    
    return 0;
}
