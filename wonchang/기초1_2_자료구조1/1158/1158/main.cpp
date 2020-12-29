//
//  main.cpp
//  1158
//
//  Created by 이원창 on 2020/12/23.
//

#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int k = 0;
    int cnt = 1;
    int cur = 1;
    bool *visit;
    vector<int> answer;
    
    cin >> n >> k;
    visit = new bool[n + 1];
    memset(visit, false, sizeof(*visit));

    while(answer.size() < n){
        if(!visit[cur]){
            if(cnt == k){
                visit[cur] = true;
                answer.push_back(cur);
                cnt = 1;
            }
            else
                cnt++;
        }
        
        if(cur == n)
            cur = 1;
        else
            cur++;
    }
    
    cout << '<' << answer[0];
    for(int i = 1; i < answer.size(); i++){
        cout << ", " << answer[i];
    }
    cout << ">\n";
    
    return 0;
}
