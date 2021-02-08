#include <iostream>
#include <vector>

using namespace std;
int a[6][6];

int main() {
    // input
    int t = 3;
    while(t--) {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                cin >> a[i][j];
            }
        }
        bool flag = false;
        vector<int> row[6];
        vector<int> col[6];
        int rIdx = 0;
        // row major
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(a[i][j]) {
                    if(row[i].size() == 0) {
                        row[i].push_back(j);
                    }
                    else {
                        if(row[i][row[i].size() - 1] + 1 == j) {
                            row[i].push_back(j);
                        }
                        else flag = true;
                    }
                }
            }
            if(row[i].size() != 0) rIdx++;
        }
        // column major
        int cIdx = 0;
        for(int j = 0; j < 6; j++) {
            for(int i = 0; i < 6; i++) {
                if(a[i][j]) {
                    if(col[j].size() == 0) {
                        col[j].push_back(i);
                    }
                    else {
                        if(col[j][col[j].size() - 1] + 1 == i) {
                            col[j].push_back(i);
                        }
                        else flag = true;
                    }
                }
            }
            if(col[j].size() != 0) cIdx++;
        }
        if(flag) { 
            cout << "no" << '\n';
            continue;
        }

        // check
        // row
        if(rIdx == 3) {
            // 1 4 1
            for(int i = 1; i < 5; i++) {
                if(row[i].size() == 4 && row[i - 1].size() == 1 && row[i + 1].size() == 1) {
                    if((row[i - 1][0] >= row[i][0] && row[i - 1][0] <= row[i][3]) 
                    && (row[i + 1][0] >= row[i][0] && row[i + 1][0] <= row[i][3])) {
                        flag = true;
                        break;
                    }
                }
            }
            // 2 3 1
            for(int i = 1; i < 5; i++) {
                if(row[i].size() == 3 && row[i - 1].size() == 1 && row[i + 1].size() == 2) {
                    if(row[i - 1][0] >= row[i][0] && row[i - 1][0] <= row[i][2]) {
                        if(row[i + 1][1] == row[i][0] || row[i + 1][0] == row[i][2]) {
                            flag = true;
                            break;
                        }
                    }
                }
                if(row[i].size() == 3 && row[i - 1].size() == 2 && row[i + 1].size() == 1) {
                    if(!(row[i + 1][0] >= row[i][0] && row[i + 1][0] <= row[i][2])) {
                        if(row[i - 1][1] == row[i][0] || row[i - 1][0] == row[i][2]) {
                            flag = true;
                            break;
                        }
                    }
                }
            }
            // 2 2 2
            for(int i = 1; i < 5; i++) {
                if(row[i].size() == 2 && row[i - 1].size() == 2 && row[i + 1].size() == 2) {
                    if(row[i][0] == row[i - 1][1] && row[i][1] == row[i + 1][0]) {
                        flag = true;
                        break;
                    }
                    if(row[i][1] == row[i - 1][0] && row[i][0] == row[i + 1][1]) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        // 3 3
        else if(rIdx == 2) {
            for(int i = 0; i < 5; i++) {
                if(row[i].size() == 3 && row[i + 1].size() == 3) {
                    if(row[i][2] == row[i + 1][0] || row[i][0] == row[i + 1][2]) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        if(flag) {
            cout << "yes" << '\n';
            continue;
        }
        // col
        if(cIdx == 3) {
            // 1 4 1
            for(int i = 1; i < 5; i++) {
                if(col[i].size() == 4 && col[i - 1].size() == 1 && col[i + 1].size() == 1) {
                    if((col[i - 1][0] >= col[i][0] && col[i - 1][0] <= col[i][3]) 
                    && (col[i + 1][0] >= col[i][0] && col[i + 1][0] <= col[i][3])) {
                        flag = true;
                        break;
                    }
                }
            }
            // 2 3 1
            for(int i = 1; i < 5; i++) {
                if(col[i].size() == 3 && col[i - 1].size() == 1 && col[i + 1].size() == 2) {
                    if(col[i - 1][0] >= col[i][0] && col[i - 1][0] <= col[i][2]) {
                        if(col[i + 1][1] == col[i][0] || col[i + 1][0] == col[i][2]) {
                            flag = true;
                            break;
                        }
                    }
                }
                else if(col[i].size() == 3 && col[i - 1].size() == 2 && col[i + 1].size() == 1) {
                    if(!(col[i + 1][0] >= col[i][0] && col[i + 1][0] <= col[i][2])) {
                        if(col[i - 1][1] == col[i][0] || col[i - 1][0] == col[i][2]) {
                            flag = true;
                            break;
                        }
                    }
                }
            }
            // 2 2 2
            for(int i = 1; i < 5; i++) {
                if(col[i].size() == 2 && col[i - 1].size() == 2 && col[i + 1].size() == 2) {
                    if(col[i][0] == col[i - 1][1] && col[i][1] == col[i + 1][0]) {
                        flag = true;
                        break;
                    }
                    if(col[i][1] == col[i - 1][0] && col[i][0] == col[i + 1][1]) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        // 3 3
        else if(cIdx == 2) {
            for(int i = 0; i < 5; i++) {
                if(col[i].size() == 3 && col[i + 1].size() == 3) {
                    if(col[i][2] == col[i + 1][0] || col[i][0] == col[i + 1][2]) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        if(flag) {
            cout << "yes" << '\n';
        }
        else {
            cout << "no" << '\n';
        }
    }

    return 0;
}