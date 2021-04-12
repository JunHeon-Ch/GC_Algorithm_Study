#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
char s[9];
bool flag[10];
int num[10];
vector<string> ans;

void go(int index, int n) {
    if(index == n + 1) {
        string tmp;
        for(int i = 0; i < index; i++) {
            tmp += (char)(num[i] + '0');
        }
        ans.push_back(tmp);
        return;
    }
    for(int i = 0; i < 10; i++) {
        if(!flag[i]) {
            if(s[index - 1] == '<') {
                if(num[index - 1] > i) continue;
            }
            else if(s[index - 1] == '>') {
                if(num[index - 1] < i) continue;
            }
            num[index] = i;
            flag[i] = true;
            go(index + 1, n);
            flag[i] = false;
        }
    }
}

int main() {
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> s[i];
    }
    for(int i = 0; i < 10; i++) {
        num[0] = i;
        flag[i] = true;
        go(1, n);
        flag[i] = false;
    }
    auto p = minmax_element(ans.begin(), ans.end());
    cout << *p.second << '\n';
    cout << *p.first << '\n';

    return 0;
}