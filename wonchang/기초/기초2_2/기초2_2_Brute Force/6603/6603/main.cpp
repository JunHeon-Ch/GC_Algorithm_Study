//
//  main.cpp
//  6603
//
//  Created by 이원창 on 2021/01/20.
//

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int arr[13];
bool visit[13];
vector<int> v;
void go(int n, int cnt){
    if(cnt == 6){
        for(int i = 0; i < v.size(); i++){
            cout << v[i] << ' ';
        }
        cout << '\n';
    }
    for(int i = 0; i < n; i++){
        if(!visit[i] && v[cnt - 1] < arr[i]){
            v.push_back(arr[i]);
            visit[i] = true;
            go(n, cnt + 1);
            v.pop_back();
            visit[i] = false;
        }
    }
}
int main(int argc, const char * argv[]) {
    int n = -1;
    while(n != 0){
        cin >> n;
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        for(int i = 0; i < n; i++){
            v.push_back(arr[i]);
            visit[i] = true;
            go(n, 1);
            v.pop_back();
            visit[i] = false;
        }
        cout << '\n';
    }
    
    return 0;
}
