#include <iostream>
#include <queue>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    queue<int> q;
    for(int i = 1; i <= n; i++) {
        q.push(i);
    }

    cout << '<';
    while(q.size() > 1) {
        for(int j = 1; j < m; j++) {
            q.push(q.front());
            q.pop();
        }
        cout << q.front() << ", ";
        q.pop(); 
    }
    cout << q.front() << ">";
    q.pop();
    
    return 0;
}