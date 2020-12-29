//
//  main.cpp
//  1874
//
//  Created by 이원창 on 2020/12/22.
//

#include <iostream>
#include <vector>
using namespace std;
bool isIn(int num, vector<int> v){
    for(int i = 0; i < v.size(); i++){
        if(v[i] == num)
            return true;
    }
    
    return false;
}
int main(int argc, const char * argv[]) {
    int n = 0;
    int item = 1;
    vector<int> v;
    vector<int> stack;
    vector<char> answer;
    cin >> n;
    
    for(int i = 0; i < n; i++){
        int temp = 0;
        cin >> temp;
        v.push_back(temp);
    }
    
    for(int i = 0; i < v.size(); i++){
        if(isIn(v[i], stack)){
            if(v[i] == stack.back()){
                stack.pop_back();
                answer.push_back('-');
            }
            else{
                cout << "NO" << endl;
                return 0;
            }
        }
        else{
            for(int j = item; j <= v[i]; j++){
                stack.push_back(j);
                answer.push_back('+');
                item++;
            }
            stack.pop_back();
            answer.push_back('-');
        }
    }
    
    for(int i = 0; i < answer.size(); i++){
        cout << answer[i] << '\n';
    }
    return 0;
}
