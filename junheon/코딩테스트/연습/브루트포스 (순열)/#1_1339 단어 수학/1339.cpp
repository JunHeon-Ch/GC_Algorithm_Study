#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

int main() {
    // input
    int n;
    cin >> n;
    vector<string> input;
    vector<char> alpha;
    vector<int> digit;
    int d = 9;
    for(int i = 0; i < n; i++) {
        string tmp;
        cin >> tmp;
        input.push_back(tmp);
        for(int i = 0; i < tmp.length(); i++) {
            if(find(alpha.begin(), alpha.end(), tmp[i]) == alpha.end()) {
                alpha.push_back(tmp[i]);
                digit.push_back(d--);
            }
        }
    }

    // using permutation
    int ans = 0;
    do{
        int sum = 0;
        for(int k = 0; k < input.size(); k++) {
            int tmp = 0;
            for(int i = 0; i < input[k].length(); i++) {
                int idx = find(alpha.begin(), alpha.end(), input[k][i]) - alpha.begin();
                tmp *= 10;
                tmp += digit[idx];
            }
            sum += tmp;
        }
        ans = max(ans, sum);
    }while(prev_permutation(digit.begin(), digit.end()));

    cout << ans << '\n';

    return 0;
}