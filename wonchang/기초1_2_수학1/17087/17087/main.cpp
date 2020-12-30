//
//  main.cpp
//  17087
//
//  Created by 이원창 on 2020/12/30.
//

#include <iostream>
#include <stack>
using namespace std;
long long gcd(long long a, long long b){
    if(b == 0)
        return a;
    else
        return gcd(b, a % b);
}
int main(int argc, const char * argv[]) {
    long long n = 0;
    long long s = 0;
    stack<long long> st;
    
    cin >> n >> s;
    for(long long i = 0; i < n; i++){
        long long tmp = 0;
        cin >> tmp;
        st.push(abs(tmp - s));
    }

    while(st.size() > 1){
        long long a = st.top();
        st.pop();
        long long b = st.top();
        st.pop();
        st.push(gcd(a, b));
    }
    
    cout << st.top() << '\n';
    return 0;
}
