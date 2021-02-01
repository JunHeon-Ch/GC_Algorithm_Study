//
//  main.cpp
//  1991
//
//  Created by 이원창 on 2021/02/01.
//

#include <iostream>
#include <vector>
using namespace std;
vector<pair<char, char>> v[26];
void preorder(int idx){
    int l = v[idx].front().first - 'A';
    int r = v[idx].front().second - 'A';

    cout << (char)(idx + 'A');
    
    if(v[idx].front().first != '.')
        preorder(l);
    
    if(v[idx].front().second != '.')
        preorder(r);
}
void inorder(int idx){
    int l = v[idx].front().first - 'A';
    int r = v[idx].front().second - 'A';

    
    if(v[idx].front().first != '.')
        inorder(l);
    
    cout << (char)(idx + 'A');
    
    if(v[idx].front().second != '.')
        inorder(r);
}
void postorder(int idx){
    int l = v[idx].front().first - 'A';
    int r = v[idx].front().second - 'A';

    if(v[idx].front().first != '.')
        postorder(l);

    if(v[idx].front().second != '.')
        postorder(r);

    cout << (char)(idx + 'A');
}
int main(int argc, const char * argv[]) {
    int n = 0;
    
    cin >> n;
    for(int i = 0; i < n; i++){
        char tmp, l, r;

        cin >> tmp >> l >> r;
        v[tmp - 'A'].push_back(make_pair(l, r));
    }
    
    preorder(0);
    cout << '\n';
    
    inorder(0);
    cout << '\n';
    
    postorder(0);
    cout << '\n';
    return 0;
}
