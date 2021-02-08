//
//  main.cpp
//  15662
//
//  Created by 이원창 on 2021/02/08.
//

#include <iostream>
#include <cstring>
#include <queue>
using namespace std;
int arr[1001][8];
queue<pair<int, int>> q;
void ccw(int idx){
    int tmp = arr[idx][0];
    for(int i = 0; i < 7; i++){
        arr[idx][i] = arr[idx][i + 1];
    }
    arr[idx][7] = tmp;
}
void cw(int idx){
    int tmp = arr[idx][7];
    for(int i = 7; i > 0; i--){
        arr[idx][i] = arr[idx][i - 1];
    }
    arr[idx][0] = tmp;
}
int main(int argc, const char * argv[]) {
    int t = 0;
    int k = 0;
    int ans = 0;
    int info[1001][2];
    bool visit[1001];

    cin >> t;
    getchar();
    for(int i = 1; i <= t; i++){
        string tmp;
        cin >> tmp;
        for(int j = 0; j < 8; j++){
            arr[i][j] = tmp[j] - '0';
        }
    }
    
    cin >> k;
    for(int i = 0; i < k; i++){
        int a = 0;
        int b = 0;
        
        cin >> a >> b;
        q.push(make_pair(a, b));
        memset(visit, false, sizeof(visit));
        for(int i = 1; i <= t; i++){
            // Store left info before rotate
            info[i][0] = arr[i][6];
            
            // Store right info before rotate
            info[i][1] = arr[i][2];
        }
        
        while(!q.empty()){
            int num = q.front().first;
            int dir = q.front().second;
            
            visit[num] = true;
            q.pop();
            if(dir == -1){
                ccw(num);
                if(num - 1 > 0 && info[num - 1][1] != info[num][0] && !visit[num - 1])
                    q.push(make_pair(num - 1, -dir));
                if(num + 1 <= t && info[num + 1][0] != info[num][1] && !visit[num + 1])
                    q.push(make_pair(num + 1, -dir));
            }
            else if(dir == 1){
                cw(num);
                if(num - 1 > 0 && info[num - 1][1] != info[num][0] && !visit[num - 1])
                    q.push(make_pair(num - 1, -dir));
                if(num + 1 <= t && info[num + 1][0] != info[num][1] && !visit[num + 1])
                    q.push(make_pair(num + 1, -dir));
            }
        }
    }

    for(int i = 1; i <= t; i++){
        if(arr[i][0] == 1)
            ans++;
    }
    cout << ans << '\n';
    return 0;
}
