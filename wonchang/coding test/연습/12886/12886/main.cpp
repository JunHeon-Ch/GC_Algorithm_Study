//
//  main.cpp
//  12886
//
//  Created by 이원창 on 2021/02/27.
//

#include <iostream>
#include <queue>
int a = 0;
int b = 0;
int c = 0;
int sum = 0;
bool check[1000][1000];
using namespace std;
void bfs(){
    queue<pair<int, int>> q;
    q.push(make_pair(a, b));
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        int z = sum - x - y;
        
        q.pop();
        if(x == y && y == z){
            cout << "1\n";
            return;
        }
        
        int dx[2] = {x, x};
        int dy[2] = {y, z};
        for(int i = 0; i < 2; i++){
            int na = dx[i];
            int nb = dy[i];
            
            if(na < nb){
                nb -= na;
                na += na;
            }
            else if(nb < na){
                na -= nb;
                nb += nb;
            }

            int nc = sum - na - nb;
            int nx = min(min(na, nb), nc);
            int ny = max(max(na, nb), nc);
            if(!check[nx][ny]){
                q.push(make_pair(nx, ny));
                check[nx][ny] = true;
            }
        }
    }
    cout << "0\n";
}
int main(int argc, const char * argv[]) {
    
    cin >> a >> b >> c;
    sum = a + b + c;
    if(sum % 3 != 0){
        cout << "0\n";
        return 0;
    }
    else
        bfs();
    
    return 0;
}
