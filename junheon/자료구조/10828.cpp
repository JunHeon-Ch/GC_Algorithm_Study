#include <iostream>
#include <string>

using namespace std;

struct Stack {
    int data[10000];
    int size;

    Stack() {
        size = 0;
    }

    void push(int num) {
        data[size++] = num;
    }

    bool empty() {
        if (size == 0) {
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
            return data[--size];
        }
    }

    int top() {
        if(empty()) {
            return -1;
        }
        else {
            return data[size - 1];
        }
    }
};

int main() {
    int n;
    Stack s;

    cin >> n;
    while(n--) {
        string cmd;

        cin >> cmd;
        if(cmd == "push") {
            int num;
            cin >> num;
            s.push(num);
        }
        else if(cmd == "pop") {
            cout << s.pop() << '\n';
        }
        else if(cmd == "empty") {
            cout << s.empty() << '\n';
        }
        else if(cmd == "top") {
            cout << s.top() << '\n';
        }
        else if(cmd == "size") {
            cout << s.size << '\n';
        }
    }
}