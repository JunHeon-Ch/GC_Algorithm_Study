//
//  main.cpp
//  1037
//
//  Created by 이원창 on 2021/02/04.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    vector<int> v;
    
    cin >> n;
    for(int i = 0; i < n; i++){
        int tmp = 0;
        
        cin >> tmp;
        v.push_back(tmp);
    }
    
    sort(v.begin(), v.end());
    cout << v.front() * v.back() << '\n';
    return 0;
}
