#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(string s) {
    vector<int> len(s.size() / 2 + 1, s.size());
    
    for(int k = 1; k <= s.size() / 2; k++) {
        int complen = s.size();
        int i = 0;
        while(i + 2 * k <= s.size()) {
            string s1 = s.substr(i, k);
            int cnt = 0;
            i += k;
            while(i + k <= s.size()) {                    
                string s2 = s.substr(i, k);
                if(s1 != s2) break;
                cnt++;
                i += k;
            }
            if(cnt > 0) {
                complen -= cnt * k;
                int digitLen = 0;
                cnt++;
                while(cnt > 0) {
                    digitLen++;
                    cnt /= 10;
                }
                complen += digitLen;
            }
        }
        len[k] = min(len[k], complen);
    }
    sort(len.begin(), len.end());
    
    return len[0];
}