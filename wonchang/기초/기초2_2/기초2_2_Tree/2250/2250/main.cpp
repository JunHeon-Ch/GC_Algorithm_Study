//
//  main.cpp
//  2250
//
//  Created by 이원창 on 2021/02/01.
//

#include <iostream>
#include <vector>
using namespace std;
int width = 0;
int height = 0;
int root[10001];
vector<int> a[10001];
vector<pair<int, int>> v[10001];
void inorder(int idx, int cnt){
    if(v[idx].front().first != -1)
        inorder(v[idx].front().first, cnt + 1);
    
    height = max(height, cnt);
    a[cnt].push_back(++width);
    
    if(v[idx].front().second != -1)
        inorder(v[idx].front().second, cnt + 1);
}
int main(int argc, const char * argv[]) {
    int n = 0;
    int h = 0;
    int w = 0;
    int r = 1;
    
    cin >> n;
    for(int i = 0; i < n; i++){
        int a, b, c;
        
        cin >> a >> b >> c;
        v[a].push_back(make_pair(b, c));
        root[b] = a;
        root[c] = a;
    }
    
    while(root[r] != 0)
        r = root[r];
    
    inorder(r, 1);
    
    for(int i = 1; i <= height; i++){
        int tmp = a[i].back() - a[i].front() + 1;
        
        if(tmp > w){
            w = tmp;
            h = i;
        }
    }
    
    cout << h << ' ' << w << endl;
    return 0;
}
