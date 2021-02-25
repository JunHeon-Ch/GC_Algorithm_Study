//
//  main.cpp
//  1208
//
//  Created by 이원창 on 2021/02/24.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n = 0;
int s = 0;
long long ans = 0;
int arr[40];
vector<int> front;
vector<int> back;
void left(int idx, int sum){
    if(idx >= n / 2)
        return;
    
    front.push_back(sum + arr[idx]);
    if(s == sum + arr[idx])
        ans++;
    
    left(idx + 1, sum);
    left(idx + 1, sum + arr[idx]);
}
void right(int idx, int sum){
    if(idx >= n)
        return;
    
    back.push_back(sum + arr[idx]);
    if(s == sum + arr[idx])
        ans++;
    
    right(idx + 1, sum);
    right(idx + 1, sum + arr[idx]);
}
int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
    
    cin >> n >> s;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    
    left(0, 0);
    right(n / 2, 0);
    
    sort(front.begin(), front.end());
    sort(back.begin(), back.end());
    
    for(int i = 0; i < front.size(); i++){
        int tmp = s - front[i];
        int lower = lower_bound(back.begin(), back.end(), tmp) - back.begin();
        int upper = upper_bound(back.begin(), back.end(), tmp) - back.begin();
        ans += upper - lower;
    }
    
    cout << ans << '\n';
}
