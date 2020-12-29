//
//  main.cpp
//  10845
//
//  Created by 이원창 on 2020/12/23.
//

#include <iostream>
#include <deque>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    deque<int> q;
    cin >> n;
    
    for(int i = 0; i < n; i++){
        string str = "";
        cin >> str;
        if(str.compare("push") == 0){
            int num = 0;
            cin >> num;
            q.push_back(num);
        }
        else if(str.compare("pop") == 0){
            if(q.size() > 0){
                cout << q.front() << '\n';
                q.pop_front();
            }
            else
                cout << "-1" << '\n';
        }
        else if(str.compare("size") == 0){
            cout << q.size() << '\n';
        }
        else if(str.compare("empty") == 0){
            if(q.size() == 0)
                cout << "1" << '\n';
            else
                cout << "0" << '\n';
        }
        else if(str.compare("front") == 0){
            if(q.size() > 0)
                cout << q.front() << '\n';
            else
                cout << "-1" << '\n';
        }
        else if(str.compare("back") == 0){
            if(q.size() > 0)
                cout << q.back() << '\n';
            else
                cout << "-1" << '\n';
        }
    }
    
    return 0;
}
