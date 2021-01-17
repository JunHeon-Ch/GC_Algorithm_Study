//
//  main.cpp
//  10828
//
//  Created by 이원창 on 2020/12/22.
//

#include <iostream>
#include <vector>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    string temp;
    vector<int> v;

    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> temp;
        if(temp.compare("push") == 0){
            int num = 0;
            cin >> num;
            v.push_back(num);
        }
        else if(temp.compare("pop") == 0){
            if(v.size() == 0)
                cout << "-1" << endl;
            else{
                cout << v.back() << endl;
                v.pop_back();
            }
        }
        else if(temp.compare("size") == 0)
            cout << v.size() << endl;
        else if(temp.compare("empty") == 0){
            if(v.size() == 0)
                cout << "1" << endl;
            else
                cout << "0" << endl;
        }
        else if(temp.compare("top") == 0){
            if(v.size() == 0)
                cout << "-1" << endl;
            else
                cout << v.back() << endl;
        }
    }
    return 0;
}
