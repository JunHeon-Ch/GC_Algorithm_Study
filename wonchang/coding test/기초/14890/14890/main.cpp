//
//  main.cpp
//  14890
//
//  Created by 이원창 on 2021/02/07.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int l = 0;
    int j = 0;
    int ans = 0;
    int arr[200][100];
    
    cin >> n >> l;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            arr[i + n][j] = arr[j][i];
        }
    }
    
    for(int i = 0; i < 2 * n; i++){
        int c = 1;
        for(j = 0; j < n - 1; j++){
            if(arr[i][j] == arr[i][j + 1])
                c++;
            else if(arr[i][j] + 1 == arr[i][j + 1] && c >= l)
                c = 1;
            else if(arr[i][j] - 1 == arr[i][j + 1] && c >= 0)
                c = 1 - l;
            else
                break;
        }
        if(j == n - 1 && c >= 0)
            ans++;
    }
    
    cout << ans << '\n';
    return 0;
}
