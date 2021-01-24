#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int m;
    cin >> m;
    int n = 20;
    int set = 0;
    while(m--) {
        string s;
        int x;
        cin.ignore();
        cin >> s;
        if(s == "add") {
            cin >> x;
            x--;
            set = set | (1 << x);
        }
        else if(s == "remove") {
            cin >> x;
            x--;
            set = set & ~(1 << x);
        }
        else if(s == "check") {
            cin >> x;
            x--;
            int temp = set & (1 << x);
            if(temp > 0) cout << 1 << '\n';
            else if(temp == 0) cout << 0 << '\n';
        }
        else if(s == "toggle") {
            cin >> x;
            x--;
            set = set ^ (1 << x);
        }
        else if(s == "all") {
            set = (1 << n) - 1;
        }
        else if(s == "empty") {
            set = 0;
        }
    }
    return 0;
}