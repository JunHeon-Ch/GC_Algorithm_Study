//
//  main.cpp
//  11723
//
//  Created by 이원창 on 2021/01/23.
//

#include <iostream>
#include <algorithm>
using namespace std;
int arr[21] = {0, };
void add(int num){
    arr[num] = 1;
}
void remove(int num){
    arr[num] = 0;
}
void check(int num){
    if(arr[num] == 1)
        cout << "1\n";
    else
        cout << "0\n";
}
void toggle(int num){
    if(arr[num] == 1)
        arr[num] = 0;
    else if(arr[num] == 0)
        arr[num] = 1;
}
void all(){
    for(int i = 0; i <= 20; i++){
        arr[i] = 1;
    }
}
void empty(){
    for(int i = 0; i <= 20; i++){
        arr[i] = 0;
    }
}
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    long long m = 0;
    
    cin >> m;
    for(int i = 0; i < m; i++){
        int tmp = 0;
        string temp = "";
        
        cin >> temp;
        if(temp.compare("add") == 0){
            cin >> tmp;
            add(tmp);
        }
        else if(temp.compare("remove") == 0){
            cin >> tmp;
            remove(tmp);
        }
        else if(temp.compare("check") == 0){
            cin >> tmp;
            check(tmp);
        }
        else if(temp.compare("toggle") == 0){
            cin >> tmp;
            toggle(tmp);
        }
        else if(temp.compare("all") == 0)
            all();
        else if(temp.compare("empty") == 0)
            empty();
    }
    
    return 0;
}
