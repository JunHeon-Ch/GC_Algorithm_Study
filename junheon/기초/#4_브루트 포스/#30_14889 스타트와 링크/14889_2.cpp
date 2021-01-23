#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int s[20][20];

int divideTeam(int n, int index, vector<int> &left, vector<int> &right) {
    if(left.size() > n / 2) return -1;
    if(right.size() > n / 2) return -1;
    if(index == n) {
        int l = 0, r = 0;
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < n / 2; j++) {
                if(i == j) continue;
                l += s[left[i]][left[j]];
                r += s[right[i]][right[j]];
            }
        }
        return abs(l - r);
    }

    int ans = -1;
    left.push_back(index);
    int lans = divideTeam(n, index + 1, left, right);
    if(ans == -1 || lans != -1 && ans > lans) {
        ans = lans;        
    }
    left.pop_back();

    right.push_back(index);
    int rans = divideTeam(n, index + 1, left, right);
    if(ans == -1 || rans != -1 && ans > rans) {
        ans = rans;        
    }
    right.pop_back();
    return ans;
}

int main() {
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> s[i][j];
        }
    }

    vector<int> left, right;
    int ans = divideTeam(n, 0, left, right);
    cout << ans << '\n';

    return 0;
}