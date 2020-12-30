//
//  main.cpp
//  1373
//
//  Created by 이원창 on 2020/12/30.
//

#include <iostream>
#include <deque>
using namespace std;
int main(int argc, const char * argv[]) {
    string str = "";
    deque<long> ans;
    
    cin >> str;
    for(long i = str.length() - 1; i >= 0;){
        long tmp = 0;
        for(int j = 1; j <= 4; j *= 2){
            if(str[i--] == '1')
                tmp += j;
        }
        ans.push_back(tmp);
    }
    
    while(ans.size() > 0){
        cout << ans.back();
        ans.pop_back();
    }
    return 0;
}
