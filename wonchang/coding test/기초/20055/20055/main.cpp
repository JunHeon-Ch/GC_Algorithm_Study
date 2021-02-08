//
//  main.cpp
//  20055
//
//  Created by 이원창 on 2021/02/08.
//

#include <iostream>
#include <queue>
using namespace std;
int n, k;
int up, down, cnt, ans;
int arr[201];
int robot[201];
void move_belt(){
    if(up == 1)
        up = 2 * n;
    else
        up -= 1;
    
    if(down == 1)
        down = 2 * n;
    else
        down -= 1;
}
void move_robot(){
    int cur = down;
    
    while(cur != up){
        if(robot[cur] == 1){
            int next = cur + 1;
            if(next == 2 * n + 1)
                next = 1;
            
            if(arr[next] > 0 && robot[next] == 0){
                robot[cur] = 0;
                robot[next] = 1;
                arr[next] -= 1;
                if(arr[next] == 0)
                    cnt++;
            }
        }
        
        if(cur == 1)
            cur = 2 * n;
        else
            cur -= 1;
    }
}
int main(int argc, const char * argv[]) {
    queue<int> q;
    
    cin >> n >> k;
    for(int i = 1; i <= 2 * n; i++){
        cin >> arr[i];
    }
    
    up = 1;
    down = n;
    while(cnt < k){
        ans++;
        if(robot[down] == 1)
            robot[down] = 0;
        move_belt();
        
        if(robot[down] == 1)
            robot[down] = 0;
        move_robot();
        
        if(arr[up] > 0){
            robot[up] = 1;
            arr[up] -= 1;
            if(arr[up] == 0)
                cnt++;
        }
    }
    
    cout << ans << '\n';
    return 0;
}
