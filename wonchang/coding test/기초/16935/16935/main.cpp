//
//  main.cpp
//  16935
//
//  Created by 이원창 on 2021/02/04.
//

#include <iostream>
#include <cstring>
using namespace std;
int n = 0;
int m = 0;
int arr[100][100];
int tmp[100][100];
void one(){
    memset(tmp, 0, sizeof(tmp));
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            tmp[i][j] = arr[n - i - 1][j];
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            arr[i][j] = tmp[i][j];
        }
    }
}
void two(){
    memset(tmp, 0, sizeof(tmp));
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            tmp[i][j] = arr[i][m - j - 1];
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            arr[i][j] = tmp[i][j];
        }
    }
}
void three(){
    memset(tmp, 0, sizeof(tmp));
    
    int idx = n;
    swap(n, m);
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            tmp[i][j] = arr[idx - j - 1][i];
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            arr[i][j] = tmp[i][j];
        }
    }
}
void four(){
    memset(tmp, 0, sizeof(tmp));
    
    int idx = m;
    swap(n, m);
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            tmp[i][j] = arr[j][idx - i - 1];
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            arr[i][j] = tmp[i][j];
        }
    }
}
void five(){
    memset(tmp, 0, sizeof(tmp));
    
    for(int i = 0; i < n / 2; i++){
        for(int j = 0; j < m / 2; j++){
            tmp[i][j] = arr[i + n / 2][j];
        }
    }
    
    for(int i = 0; i < n / 2; i++){
        for(int j = m / 2; j < m; j++){
            tmp[i][j] = arr[i][j - m / 2];
        }
    }
    
    for(int i = n / 2; i < n; i++){
        for(int j = m / 2; j < m; j++){
            tmp[i][j] = arr[i - n / 2][j];
        }
    }
    
    for(int i = n / 2; i < n; i++){
        for(int j = 0; j < m / 2; j++){
            tmp[i][j] = arr[i][j + m / 2];
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            arr[i][j] = tmp[i][j];
        }
    }
}
void six(){
    memset(tmp, 0, sizeof(tmp));
    
    for(int i = 0; i < n / 2; i++){
        for(int j = 0; j < m / 2; j++){
            tmp[i][j] = arr[i][j + m / 2];
        }
    }
    
    for(int i = 0; i < n / 2; i++){
        for(int j = m / 2; j < m; j++){
            tmp[i][j] = arr[i + n / 2][j];
        }
    }
    
    for(int i = n / 2; i < n; i++){
        for(int j = m / 2; j < m; j++){
            tmp[i][j] = arr[i][j - m / 2];
        }
    }
    
    for(int i = n / 2; i < n; i++){
        for(int j = 0; j < m / 2; j++){
            tmp[i][j] = arr[i - n / 2][j];
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            arr[i][j] = tmp[i][j];
        }
    }
}
int main(int argc, const char * argv[]) {
    int cnt = 0;
    
    cin >> n >> m >> cnt;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i < cnt; i++){
        int r = 0;
        cin >> r;
        switch (r) {
            case 1:
                one();
                break;
            case 2:
                two();
                break;
            case 3:
                three();
                break;
            case 4:
                four();
                break;
            case 5:
                five();
                break;
            case 6:
                six();
                break;
            default:
                break;
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cout << arr[i][j] << ' ';
        }
        cout << endl;
    }
    
    return 0;
}
