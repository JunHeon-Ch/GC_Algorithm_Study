package PS_2021.프로그래머스.level2.거리두기_확인하기;

class Solution {

    private int dx[] = {-1, 1, 0, 0};
    private int dy[] = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int idx = 0;
        for(String[] place : places) {
            char[][] room = new char[5][5];
            for(int i = 0; i < place.length; i++) {
                room[i] = place[i].toCharArray();
            }
            boolean unsafe = false;
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(room[i][j] == 'P') {
                        boolean[][] visit = new boolean[5][5];
                        if(!check(i, j, room, visit, 0)) {
                            unsafe = true;
                            break;
                        }
                    }
                }
                if(unsafe) break;
            }
            if(unsafe) answer[idx] = 0;
            else answer[idx] = 1;
            idx++;
        }
        return answer;
    }

    private boolean check(int x, int y, char[][] room, boolean[][] visit, int cnt) {
        if(cnt > 2) return true;
        visit[x][y] = true;
        if(room[x][y] == 'X') return true;
        if(cnt != 0 && room[x][y] == 'P') return false;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visit[nx][ny]) continue;
            if(!check(nx, ny, room, visit, cnt + 1)) return false;
        }
        return true;
    }
}