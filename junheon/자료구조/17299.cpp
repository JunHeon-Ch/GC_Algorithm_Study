#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int freq[1000001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> arr(n);
    vector<int> ans(n);
    stack<int> s;

    for(int i = 0; i < n; i++) {
        cin >> arr[i];
        freq[arr[i]]++;
    }

    for(int i = 0; i < n; i++) {
        while(!s.empty() && freq[arr[s.top()]] <freq[arr[i]]) {
            ans[s.top()] = arr[i];
            s.pop();
        }
        s.push(i);
    }

    while(!s.empty()) {
        ans[s.top()] = -1;
        s.pop();
    }

    for(int i = 0; i < n; i++) {
        cout << ans[i] << ' ';
    }

    return 0;
}