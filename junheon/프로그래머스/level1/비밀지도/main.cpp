#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    for(int i = 0; i < n; i++) {
        int n1 = arr1[i];
        int n2 = arr2[i];
        string res = "";
        for(int j = 0; j < n; j++) {
            if(n1 % 2 == 0 && n2 % 2 == 0) {
                res += " ";
            }
            else if(n1 % 2 == 1 || n2 % 2 == 1) {
                res += "#";
            }
            n1 /= 2; n2 /= 2;
        }
        reverse(res.begin(), res.end());
        answer.push_back(res);
    }
    return answer;
}