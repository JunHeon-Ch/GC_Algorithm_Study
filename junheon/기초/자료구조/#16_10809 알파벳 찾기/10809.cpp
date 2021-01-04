#include <iostream>
#include <string>

using namespace std;

int main() {
    string str;
    cin >> str;

    for(int i = 'a'; i <= 'z'; i++) {
        int n = str.size();
        int pos = str.find(i);
        if(pos > n) {
            cout << -1 << ' ';
        }
        else {
            cout << pos << ' ';
        }
    }

    return 0;
}