#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int n[9];

int main() {
    for(int i = 0; i < 9; i++) {
        cin >> n[i];
    }
    for(int i = 0; i < 9; i++) {
        for(int j = i + 1; j < 9; j++) {
            vector<int> ans;
            int sum = 0;
            for(int k = 0; k < 9; k++) {
                if(k != i && k != j) {
                    sum += n[k];
                    ans.push_back(n[k]);
                }
            }
            if(sum == 100) {
                sort(ans.begin(), ans.end());
                for(int i = 0; i < 7; i++) {
                    cout << ans[i] << '\n';
                }
                return 0;
            }
            ans.clear();
        }
    }

    return 0;
}