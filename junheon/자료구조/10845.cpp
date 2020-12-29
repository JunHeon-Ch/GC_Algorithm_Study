#include <iostream>
#include <string>

using namespace std;

struct Queue{
    int data[10000];
    int start, end;

    Queue() {
        start = 0;
        end = 0;
    }

    void push(int num) {
        data[end++] = num;
    }

    int empty() {
        if(start == end) {
            return 1;
        }
        else {
            return 0;
        }
    }

    int pop() {
        if(empty()) {
            return -1;
        }
        else {
            return data[start++];
        }
    }

    int front() {
        if(empty()) {
            return -1;
        }
        else {
            return data[start];
        }
    }

    int back() {
        if(empty()) {
            return -1;
        }
        else {
            return data[end - 1];
        }
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    Queue q;
    int t;
    cin >> t;

    while(t--) {
        string cmd;
        cin >> cmd;

        if(cmd == "push") {
            int n;
            cin >> n;
            q.push(n);
        }
        else if(cmd == "pop") {
            cout << q.pop() << '\n';
        }
        else if(cmd == "front") {
            cout << q.front() << '\n';
        }
        else if(cmd == "back") {
            cout << q.back() << '\n';
        }
        else if(cmd == "empty") {
            cout << q.empty() << '\n';
        }
        else if(cmd == "size") {
            cout << q.end - q.start << '\n';
        }
    }

    return 0;
}