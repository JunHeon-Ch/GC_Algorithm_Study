#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int c[10][10];
int calculator(vector<int> p) {
    int result = 0;
    int i;
    for(i = 1; i < p.size(); i++) {
        int cost = c[p[i - 1]][p[i]];
        if(cost == 0) {
            return -1;
        }
        result += cost;
    }
    int cost = c[p[i - 1]][p[0]];
    if(cost == 0) {
        return -1;
    }
    result += cost;

    return result;
}

int main() {
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> c[i][j];
        }
    }
    
    vector<int> p(n);
    for(int i = 0; i < n; i++) {
        p[i] = i;
    }

    int ans = 10000001;
    do {
        if(p[0] != 0) break;
        int result = calculator(p);
        if(result == -1) continue;
        ans = min(ans, result);
    } while(next_permutation(p.begin(), p.end()));
    cout << ans << '\n';
    
    return 0;
}