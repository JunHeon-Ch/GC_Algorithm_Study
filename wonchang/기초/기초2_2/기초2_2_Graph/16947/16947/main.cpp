//
//  main.cpp
//  16947
//
//  Created by 이원창 on 2021/01/29.
//

#include <iostream>
#include <vector>
using namespace std;
int n = 0;
vector<int> v[3001];
int main(int argc, const char * argv[]) {
    cin >> n;
    for(int i = 0; i < n; i++){
        int a = 0;
        int b = 0;
        
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    
    
    return 0;
}
