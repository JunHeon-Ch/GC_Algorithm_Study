#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool compare(pair<int, float>a, pair<int, float>b) {
	if (a.second == b.second) {
		return a.first < b.first;
	}
	else {
		return a.second > b.second;
	}
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<pair<int, float>> fail;
    for(int i = 1; i <= N; i++) {
        int total = 0, fNum = 0;
        for(int j = 0; j < stages.size(); j++) {
            if(stages[j] >= i) {
                if(stages[j] == i) {
                    fNum++;
                }
                total++;
            }
        }
        if(total == 0) {
            fail.push_back({i, 0});
        }
        else {
            fail.push_back({i, (float)fNum/total});
        }
    }
    sort(fail.begin(), fail.end(), compare);
    for(int i = 0; i < fail.size(); i++) {
        answer.push_back(fail[i].first);
    }

    return answer;
}