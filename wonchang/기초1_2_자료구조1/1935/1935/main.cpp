//
//  main.cpp
//  1935
//
//  Created by 이원창 on 2020/12/27.
//

#include <iostream>
#include <stack>
#include <deque>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n = 0;
    double a = 0;
    double b = 0;
    int num[26] = {0, };
    stack<double> s;
    deque<int> dq;
    string str = "";
    
    cin >> n;
    cin >> str;
    for(int i = 0; i < n; i++){
        int tmp = 0;
        cin >> tmp;
        num[i] = tmp;
    }
    
    for(int i = 0; i < str.length(); i++){
        if(str[i] == '+'){
            a = s.top();
            s.pop();
            b = s.top();
            s.pop();
            s.push(b + a);
        }
        else if(str[i] == '-'){
            a = s.top();
            s.pop();
            b = s.top();
            s.pop();
            s.push(b - a);
        }
        else if(str[i] == '*'){
            a = s.top();
            s.pop();
            b = s.top();
            s.pop();
            s.push(b * a);
        }
        else if(str[i] == '/'){
            a = s.top();
            s.pop();
            b = s.top();
            s.pop();
            s.push(b / a);
        }
        else{
            s.push(num[str[i] - 'A']);
        }
        
    }
    
    printf("%.2lf\n", s.top());
    return 0;
}
