//
//  main.cpp
//  1917
//
//  Created by 이원창 on 2021/02/08.
//

#include <iostream>
#include <vector>
using namespace std;
int main(int argc, const char * argv[]) {
    int arr[6][6];
    bool ans[3];
    bool flag = false;
    
    for(int i = 0; i < 3; i++){
        vector<int> r[6];
        vector<int> c[6];
        for(int j = 0; j < 6; j++){
            for(int k = 0; k < 6; k++){
                cin >> arr[i][j];
            }
        }
        
        int rcnt = 0;
        bool rflag = false;
        for(int i = 0; i < 6; i++){
            rflag = false;
            for(int j = 0; j < 6; j++){
                if(arr[i][j] == 1){
                    rflag = true;
                    r[rcnt].push_back(j);
                }
            }
            if(rflag)
                rcnt++;
        }
        
        int ccnt = 0;
        bool cflag = false;
        for(int i = 0; i < 6; i++){
            cflag = false;
            for(int j = 0; j < 6; j++){
                if(arr[i][j] == 1){
                    cflag = true;
                    c[ccnt].push_back(j);
                }
            }
            if(cflag)
                ccnt++;
        }
        
        if(rcnt == 3){
            if(r[1].size() == 4 && r[0].size() == 1 && r[2].size() == 1)
                flag = true;

            if(r[1].size() == 3){
                if(r[0].size() == 2 && (r[0][1] == r[1][0] || r[0][0] == r[1][2]))
                    flag = true;
                else if(r[2].size() == 2 && (r[1][0] == r[2][0] || r[2][0] == r[1][2]))
                    flag = true;
            }
            
            if(r[0].size() == 2 && r[1].size() == 2 && r[2].size() == 2){
                if((r[0][1] == r[1][0] && r[1][1] == r[2][0]) || (r[0][0] == r[1][1] && r[1][0] == r[2][1]))
                    flag = true;
            }
        }
        
        if(rcnt == 2){
            if(r[1].size() == 3){
                if(r[0].size() == 3 && (r[0][2] == r[1][0] || r[0][0] == r[1][2]))
                    flag = true;
            }
        }
        
        if(ccnt == 3){
            if(c[1].size() == 4 && c[0].size() == 1 && c[2].size() == 1)
                flag = true;

            
            if(c[1].size() == 3){
                if(c[0].size() == 2 && (c[0][1] == c[1][0] || c[0][0] == c[1][2]))
                    flag = true;
                else if(c[2].size() == 2 && (c[2][1] == c[1][0] || c[2][0] == c[1][2]))
                    flag = true;

            }
            
            if(c[0].size() == 2 && c[1].size() == 2 && c[2].size() == 2){
                if((c[0][1] == c[1][0] && c[1][1] == c[2][0]) || (c[0][0] == c[1][1] && c[1][0] == c[2][1]))
                    flag = true;
            }
        }

        if(ccnt == 2){
            if(c[1].size() == 3){
                if(c[0].size() == 3 && (c[0][2] == c[1][0] || c[0][0] == c[1][2]))
                    flag = true;
            }
        }
        
        if(flag)
            cout << "yes\n";
        else
            cout << "no\n";
    }
    return 0;
}
