#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;

    stack<int> s;
    for(int m : moves) {
        m--;
        for(int i = 0; i < board.size(); i++) {
            if(board[i][m] == 0) continue;
            if(!s.empty() && s.top() == board[i][m]) {
                s.pop();
                answer += 2;
            }
            else {
                s.push(board[i][m]);
            }
            board[i][m] = 0;
            break;
        }
    }

    return answer;
}