//
//  main.cpp
//  1759
//
//  Created by 이원창 on 2021/01/20.
//

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int l = 0;
int c = 0;
char arr[15] = {0, };
char vowel[5] = {'a', 'e', 'i', 'o', 'u'};
bool visit[15];
vector<char> v;
void go(int cnt, int vow, int con){
    if(cnt == l && vow >= 1 && con >= 2){
        for(int i = 0; i < l; i++){
            cout << v[i];
        }
        cout << '\n';
    }
    for(int i = 0; i < c; i++){
        if(!visit[i] && v[cnt - 1] < arr[i]){
            bool flag = false;
            for(int j = 0; j < 5; j++){
                if(arr[i] == vowel[j]){
                    flag = true;
                    break;
                }
            }
            v.push_back(arr[i]);
            visit[i] = true;
            if(flag)
                go(cnt + 1, vow + 1, con);
            else
                go(cnt + 1, vow, con + 1);
            v.pop_back();
            visit[i] = false;
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> l >> c;
    getchar();
    for(int i = 0; i < c; i++){
        cin >> arr[i];
    }
    
    sort(arr, arr + c);
    for(int i = 0; i < c; i++){
        bool flag = false;
        for(int j = 0; j < 5; j++){
            if(arr[i] == vowel[j]){
                flag = true;
                break;
            }
        }
        v.push_back(arr[i]);
        visit[i] = true;
        if(flag)
            go(1, 1, 0);
        else
            go(1, 0, 1);
        v.pop_back();
        visit[i] = false;
    }
    return 0;
}
