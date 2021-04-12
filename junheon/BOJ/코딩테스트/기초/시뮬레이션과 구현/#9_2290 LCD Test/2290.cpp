#include <iostream>

using namespace std;
char a[30][150];

int main() {
    int s;
    string n;
    cin >> s >> n;
    int k = 0;
    int j;
    for(char c : n) {
        switch(c) {
            case '1':
            for(int i = 0; i < 2 * s + 3; i++) {
                for(j = k; j < k + s + 2; j++) {
                    if(i == 0 || i == (2 * s + 3) / 2 || i == 2 * s + 2) {
                        a[i][j] = ' ';
                    }
                    else {
                        if(j == k + s + 1) {
                            a[i][j] = '|';
                        }
                        else {
                            a[i][j] = ' ';
                        }
                    }
                }
            }
            break;
            case '2':
            for(int i = 0; i < 2 * s + 3; i++) {
                for(j = k; j < k + s + 2; j++) {
                    if(i == 0 || i == (2 * s + 3) / 2 || i == 2 * s + 2) {
                        if(j == k || j == k + s + 1) {
                            a[i][j] = ' ';
                        }
                        else {
                            a[i][j] = '-';
                        }
                    }
                    else {
                        if(i < (2 * s + 3) / 2) {
                            if(j == k + s + 1) {
                                a[i][j] = '|';
                            }
                            else {
                                a[i][j] = ' ';
                            }
                        }
                        else {
                            if(j == k) {
                                a[i][j] = '|';
                            }
                            else {
                                a[i][j] = ' ';
                            }
                        }
                    }                    
                }
            }
            break;
            case '3':
            for(int i = 0; i < 2 * s + 3; i++) {
                for(j = k; j < k + s + 2; j++) {
                    if(i == 0 || i == (2 * s + 3) / 2 || i == 2 * s + 2) {
                        if(j == k || j == k + s + 1) {
                            a[i][j] = ' ';
                        }
                        else {
                            a[i][j] = '-';
                        }
                    }
                    else {
                        if(j == k + s + 1) {
                            a[i][j] = '|';
                        }
                        else {
                            a[i][j] = ' ';
                        }
                    }                    
                }
            }
            break;
            case '4':
            for(int i = 0; i < 2 * s + 3; i++) {
                for(j = k; j < k + s + 2; j++) {
                    if(i == 0 || i == 2 * s + 2) {
                        a[i][j] = ' ';
                    }
                    else if(i == (2 * s + 3) / 2) {
                        if(j == k || j == k + s + 1) {
                            a[i][j] = ' ';
                        }
                        else {
                            a[i][j] = '-';
                        }
                    }
                    else {
                        if(i < (2 * s + 3) / 2) {
                            if(j == k || j == k + s + 1) {
                                a[i][j] = '|';
                            }
                            else {
                                a[i][j] = ' ';
                            }
                        }
                        else {
                            if(j == k + s + 1) {
                                a[i][j] = '|';
                            }
                            else {
                                a[i][j] = ' ';
                            }
                        }
                    }                    
                }
            }
            break;
            case '5':
            for(int i = 0; i < 2 * s + 3; i++) {
                for(j = k; j < k + s + 2; j++) {
                    if(i == 0 || i == (2 * s + 3) / 2 || i == 2 * s + 2) {
                        if(j == k || j == k + s + 1) {
                            a[i][j] = ' ';
                        }
                        else {
                            a[i][j] = '-';
                        }
                    }
                    else {
                        if(i < (2 * s + 3) / 2) {
                            if(j == k) {
                                a[i][j] = '|';
                            }
                            else {
                                a[i][j] = ' ';
                            }
                        }
                        else {
                            if(j == k + s + 1) {
                                a[i][j] = '|';
                            }
                            else {
                                a[i][j] = ' ';
                            }
                        }
                    }                    
                }
            }
            break;
            case '6':
            for(int i = 0; i < 2 * s + 3; i++) {
                for(j = k; j < k + s + 2; j++) {
                    if(i == 0 || i == (2 * s + 3) / 2 || i == 2 * s + 2) {
                        if(j == k || j == k + s + 1) {
                            a[i][j] = ' ';
                        }
                        else {
                            a[i][j] = '-';
                        }
                    }
                    else {
                        if(i < (2 * s + 3) / 2) {
                            if(j == k) {
                                a[i][j] = '|';
                            }
                            else {
                                a[i][j] = ' ';
                            }
                        }
                        else {
                            if(j == k || j == k + s + 1) {
                                a[i][j] = '|';
                            }
                            else {
                                a[i][j] = ' ';
                            }
                        }
                    }                    
                }
            }
            break;
            case '7':
            for(int i = 0; i < 2 * s + 3; i++) {
                for(j = k; j < k + s + 2; j++) {
                    if(i == (2 * s + 3) / 2 || i == 2 * s + 2) {
                        a[i][j] = ' ';
                    }
                    else if(i == 0) {
                        if(j == k || j == k + s + 1) {
                            a[i][j] = ' ';
                        }
                        else {
                            a[i][j] = '-';
                        }
                    }
                    else {
                        if(j == k + s + 1) {
                            a[i][j] = '|';
                        }
                        else {
                            a[i][j] = ' ';
                        }
                    }
                }
            }
            break;
            case '8':
            for(int i = 0; i < 2 * s + 3; i++) {
                for(j = k; j < k + s + 2; j++) {
                    if(i == 0 || i == (2 * s + 3) / 2 || i == 2 * s + 2) {
                        if(j == k || j == k + s + 1) {
                            a[i][j] = ' ';
                        }
                        else {
                            a[i][j] = '-';
                        }
                    }
                    else {
                        if(j == k || j == k + s + 1) {
                            a[i][j] = '|';
                        }
                        else {
                            a[i][j] = ' ';
                        }
                    }                    
                }
            }
            break;
            case '9':
            for(int i = 0; i < 2 * s + 3; i++) {
                for(j = k; j < k + s + 2; j++) {
                    if(i == 0 || i == (2 * s + 3) / 2 || i == 2 * s + 2) {
                        if(j == k || j == k + s + 1) {
                            a[i][j] = ' ';
                        }
                        else {
                            a[i][j] = '-';
                        }
                    }
                    else {
                        if(i < (2 * s + 3) / 2) {
                            if(j == k || j == k + s + 1) {
                                a[i][j] = '|';
                            }
                            else {
                                a[i][j] = ' ';
                            }
                        }
                        else {
                            if(j == k + s + 1) {
                                a[i][j] = '|';
                            }
                            else {
                                a[i][j] = ' ';
                            }
                        }
                    }                    
                }
            }
            break;
            case '0':
            for(int i = 0; i < 2 * s + 3; i++) {
                for(j = k; j < k + s + 2; j++) {
                    if(i == 0 || i == 2 * s + 2) {
                        if(j == k || j == k + s + 1) {
                            a[i][j] = ' ';
                        }
                        else {
                            a[i][j] = '-';
                        }
                    }
                    else if(i == (2 * s + 3) / 2) {
                        a[i][j] = ' ';
                    }
                    else {
                        if(j == k || j == k + s + 1) {
                            a[i][j] = '|';
                        }
                        else {
                            a[i][j] = ' ';
                        }
                    }                    
                }
            }
            break;
        }
        k = j;
        for(int i = 0; i < 2 * s + 3; i++) {
            a[i][k] = ' ';
        }
        k++;
    }
    for(int i = 0; i < 2 * s + 3; i++) {
        for(int j = 0; j < (s + 3) * n.length(); j++) {
            cout << a[i][j];
        }
        cout << '\n';
    }
    return 0;
}