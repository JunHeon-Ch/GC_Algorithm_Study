//
//  main.cpp
//  10866
//
//  Created by 이원창 on 2020/12/23.
//

#include <iostream>
#include <deque>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    deque<int> dq;
    
    cin >> n;
    for(int i = 0; i < n; i++){
        string str = "";
        cin >> str;
        
        if(str.compare("push_front") == 0){
            int tmp = 0;
            cin >> tmp;
            dq.push_front(tmp);
        }
        else if(str.compare("push_back") == 0){
            int tmp = 0;
            cin >> tmp;
            dq.push_back(tmp);
        }
        else if(str.compare("pop_front") == 0){
            if(dq.size() != 0){
                cout << dq.front() << '\n';
                dq.pop_front();
            }
            else
                cout << "-1\n";
        }
        else if(str.compare("pop_back") == 0){
            if(dq.size() != 0){
                cout << dq.back() << '\n';
                dq.pop_back();
            }
            else
                cout << "-1\n";
        }
        else if(str.compare("size") == 0){
            cout << dq.size() << '\n';
        }
        else if(str.compare("empty") == 0){
            if(dq.size() == 0)
                cout << "1\n";
            else
                cout << "0\n";
        }
        else if(str.compare("front") == 0){
            if(dq.size() != 0)
                cout << dq.front() << '\n';
            else
                cout << "-1\n";
        }
        else if(str.compare("back") == 0){
            if(dq.size() != 0)
                cout << dq.back() << '\n';
            else
                cout << "-1\n";
        }
    }
    
    return 0;
}
