#include <iostream>
#include <vector>

using namespace std;
int a[9][9];
// Whether a number is included in the horizontal
bool check_w[9][10];
// Whether a number is included in the vertical
bool check_h[9][10];
// Whether a number is included in the 3*3 area
bool check_3x3[9][10];
vector<pair<int, int>> v;

bool sudoku(int idx) {
    if(idx == v.size())
        return true;

    int x = v[idx].first;
    int y = v[idx].second;
    for(int k = 1; k < 10; k++) {
        if(!(check_w[x][k] || check_h[y][k] || check_3x3[x / 3 * 3 + y / 3][k])) {
            a[x][y] = k;
            check_w[x][k] = true;
            check_h[y][k] = true;
            check_3x3[x / 3 * 3 + y / 3][k] = true;
            if(sudoku(idx + 1))
                return true;
            a[x][y] = 0;    
            check_w[x][k] = false;
            check_h[y][k] = false;
            check_3x3[x / 3 * 3 + y / 3][k] = false;
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
            else {
                check_w[i][a[i][j]] = true;
                check_h[j][a[i][j]] = true;
                check_3x3[i / 3 * 3 + j / 3][a[i][j]] = true;
            }
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