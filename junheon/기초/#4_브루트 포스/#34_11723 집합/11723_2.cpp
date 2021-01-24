#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int m;
    cin >> m;
    int n = 20;
    int set[20];
    fill_n(set, 20, 0);
    while(m--) {
        string s;
        int x;
        cin.ignore();
        cin >> s;
        if(s == "add") {
            cin >> x;
            x--;
            set[x] = 1;
        }
        else if(s == "remove") {
            cin >> x;
            x--;
            set[x] = 0;
        }
        else if(s == "check") {
            cin >> x;
            x--;
            if(set[x]) cout << 1 << '\n';
            else if(!set[x]) cout << 0 << '\n';
        }
        else if(s == "toggle") {
            cin >> x;
            x--;
            if(set[x]) set[x] = 0;
            else if(!set[x]) set[x] = 1;
        }
        else if(s == "all") {
            fill_n(set, 20, 1);
        }
        else if(s == "empty") {
            fill_n(set, 20, 0);
        }
    }
    return 0;
}