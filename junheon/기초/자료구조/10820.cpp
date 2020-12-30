#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    string str;
    while(getline(cin, str)) {
        int low_cnt = 0, upp_cnt = 0, dig_cnt = 0, bnk_cnt = 0;

        for(int i = 0; i < str.size(); i++) {
            if(str[i] >= 'a' && str[i] <= 'z') {
                low_cnt++;
            }
            else if(str[i] >= 'A' && str[i] <= 'Z') {
                upp_cnt++;
            }
            else if(str[i] >= '0' && str[i] <= '9') {
                dig_cnt++;
            }
            else if(str[i] == ' ') {
                bnk_cnt++;
            }
        }

        cout << low_cnt << ' ' << upp_cnt << ' ' << dig_cnt << ' ' << bnk_cnt << '\n';
    }

    return 0;
}