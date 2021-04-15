#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <set>

using namespace std;
map<string, int> combiCnt;
int maxVal;
set<string> combiList;

void go(int index, int selected, int num, string order, string combi) {
    if(selected == num) {
        if(combiCnt.count(combi) == 0) {
            combiCnt[combi] = 1;
        } else {
            combiCnt[combi]++;
            maxVal = max(maxVal, combiCnt[combi]);
            combiList.insert(combi);
        }
        return;
    }
    if(index >= order.size()) return;
    combi += order.at(index);
    go(index + 1, selected + 1, num, order, combi);
    combi.erase(combi.size() - 1);
    go(index + 1, selected, num, order, combi);
}


vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;
    for(int c : course) {
        maxVal = 0;
        combiList.clear();
        combiCnt.clear();
        for(string order : orders) {
            sort(order.begin(), order.end());
            go(0, 0, c, order, "");
        }
        for(string str : combiList) {
            if(combiCnt[str] == maxVal) {
                answer.push_back(str);
            }
        }
        sort(answer.begin(), answer.end());
    }
    return answer;
}