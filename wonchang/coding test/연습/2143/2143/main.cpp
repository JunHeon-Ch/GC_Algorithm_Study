//
//  main.cpp
//  2143
//
//  Created by 이원창 on 2021/02/26.
//

#include <iostream>
#include <vector>
#include <map>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t = 0;
    int n = 0;
    int m = 0;
    int A[1000];
    int B[1000];
    long long ans = 0;
    vector<int> a;
    map<long long, int> b;
    
    cin >> t >> n;
    for(int i = 0; i < n; i++){
        cin >> A[i];
    }
    
    cin >> m;
    for(int i = 0; i < m; i++){
        cin >> B[i];
    }
    
    for(int i = 0; i < n; i++){
        int tmp = 0;
        for(int j = i; j < n; j++){
            tmp += A[j];
            a.push_back(tmp);
        }
    }
    
    for(int i = 0; i < m; i++){
        int tmp = 0;
        for(int j = i; j < m; j++){
            tmp += B[j];
            b[tmp]++;
        }
    }
    
    for(int i = 0; i < a.size(); i++){
        ans += b[t - a[i]];
    }

    cout << ans << '\n';
    return 0;
}
