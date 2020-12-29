//
//  main.cpp
//  10820
//
//  Created by 이원창 on 2020/12/27.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string str = "";
    char temp;
    while(true){
        int upper = 0;
        int lower = 0;
        int num = 0;
        int space = 0;
        
        while(true){
            temp = getchar();
            if(temp == '\n' || temp == EOF)
                break;
            else if(temp >= 97 && temp <= 122)
                upper++;
            else if(temp >= 65 && temp <= 90)
                lower++;
            else if(temp >= 48 && temp <= 57)
                num++;
            else if(temp == ' ')
                space++;
        }
        
        if(upper + lower + num + space != 0)
            cout << upper << ' ' << lower << ' ' << num << ' ' << space << '\n';
        
        if(temp == EOF)
            break;
    }
    
    return 0;
}
