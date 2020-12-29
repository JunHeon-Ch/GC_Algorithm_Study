#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main() {
    string p;
    cin >> p;
    p += '\n';

    stack<int> is;
    int result = 0;

    int i = 0;
    while (p[i] != '\n') {
        if(p[i] == '(') {
            is.push(i);
        }
        else if(p[i] == ')') {
            if(i - 1 == is.top()) {
                is.pop();
                result += is.size();
            }
            else {
                is.pop();
                result += 1;
            }
        }
        i++;
    }

    cout << result;
    
    return 0;
}