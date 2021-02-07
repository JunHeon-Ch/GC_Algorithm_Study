#include <iostream>

using namespace std;
int a[100][100];
int ans[100][100];
int n, m, r;

void reverseTopBottom() {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            ans[i][j] = a[n - 1 - i][j];
        }
    }
}

void reverseLeftRight() {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            ans[i][j] = a[i][m - 1 - j];
        }
    }
}

void rotateRight() {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            ans[j][n - 1 - i] = a[i][j];
        }
    }
}

void rotateLeft() {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            ans[m - 1 - j][i] = a[i][j];
        }
    }
}

void rotateRightHalf() {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(i < n / 2 && j < m / 2) {
                ans[i][m / 2 + j] = a[i][j];
            }
            else if(i < n / 2 && j >= m / 2) {
                ans[n / 2 + i][j] = a[i][j];
            }
            else if(i >= n / 2 && j >= m / 2) {
                ans[i][j - m / 2] = a[i][j];
            }
            else if(i >= n / 2 && j < m / 2) {
                ans[i - n / 2][j] = a[i][j];
            }
        }
    }
}

void rotateLeftHalf() {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(i < n / 2 && j < m / 2) {
                ans[n / 2 + i][j] = a[i][j];
            }
            else if(i < n / 2 && j >= m / 2) {
                ans[i][j - m / 2] = a[i][j];
            }
            else if(i >= n / 2 && j >= m / 2) {
                ans[i - n / 2][j] = a[i][j];
            }
            else if(i >= n / 2 && j < m / 2) {
                ans[i][m / 2 + j] = a[i][j];
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    cin >> n >> m >> r;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }
    for(int i = 0; i < r; i++) {
        int o;
        cin >> o;
        switch(o) {
            case 1:
            reverseTopBottom();
            break;
            
            case 2:
            reverseLeftRight();
            break;
            
            case 3:
            rotateRight();
            swap(n, m);
            break;
            
            case 4:
            rotateLeft();
            swap(n, m);
            break;
            
            case 5:
            rotateRightHalf();
            break;
            
            case 6:
            rotateLeftHalf();
            break;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = ans[i][j];
            }
        }
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cout << a[i][j] << ' ';
        }
        cout << '\n';
    }

    return 0;
}