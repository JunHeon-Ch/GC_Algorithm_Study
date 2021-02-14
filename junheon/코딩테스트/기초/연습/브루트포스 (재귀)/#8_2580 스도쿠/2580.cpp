#include <iostream>
#include <vector>

using namespace std;
int a[9][9];
vector<pair<int, int>> v;

bool check(int x, int y, int k) {
    for(int i = 0; i < 9; i++) {
        if(a[x][i] == k) return false;
        if(a[i][y] == k) return false;
    }
    x = x / 3 * 3;
    y = y / 3 * 3;
    for(int i = x; i < x + 3; i++) {
        for(int j = y; j < y + 3; j++) {
            if(a[i][j] == k) return false;
        }
    }
    return true;
}

bool sudoku(int idx) {
    if(idx == v.size())
        return true;

    int x = v[idx].first;
    int y = v[idx].second;
    for(int k = 1; k < 10; k++) {
        if(check(x, y, k)) {
            a[x][y] = k;
            if(sudoku(idx + 1)) 
                return true;
            a[x][y] = 0;           
        }
    }
    return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    for(int i = 0; i < 9; i++) {
        for(int j = 0; j < 9; j++) {
            cin >> a[i][j];
            if(a[i][j] == 0) 
                v.push_back(make_pair(i, j));
        }
    }

    sudoku(0);

    // output
    for(int i = 0; i < 9; i++) {
        for(int j = 0; j < 9; j++) {
            cout << a[i][j] << ' ';
        }
        cout << '\n';
    } 
    return 0;
}