package 프로그래머스.lv3.퍼즐조각채우기;

import java.util.*;

class Solution {
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, -1, 0, 1};
    public boolean[][] visitTable, visitBoard;
    public ArrayList<ArrayList<dot>> empty = new ArrayList<>();
    public ArrayList<ArrayList<dot>> block = new ArrayList<>();
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        visitTable = new boolean[table.length][table.length];
        visitBoard = new boolean[game_board.length][game_board.length];

        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table.length; j++){

                //블럭 찾기
                if (table[i][j] == 1 && !visitTable[i][j]){
                    block.add(bfs(i, j, visitTable, table, 1));
                }

                // 빈 공간 찾기
                if (game_board[i][j] == 0 && !visitBoard[i][j]){
                    empty.add(bfs(i, j, visitBoard, game_board, 0));
                }
            }
        }

        answer = findBlock();
        return answer;
    }

    public ArrayList<dot> bfs(int x, int y, boolean[][] visit, int[][] graph, int type){

        Queue<dot> queue = new LinkedList<>();
        ArrayList<dot> subList = new ArrayList<>();

        queue.add(new dot(x, y));
        visit[x][y] = true;

        subList.add(new dot(0, 0));

        while (!queue.isEmpty()){
            dot now = queue.poll();

            for (int i = 0; i < 4; i++){
                int next_x = now.x + dx[i];
                int next_y = now.y + dy[i];

                if (next_x < 0 || next_y < 0 || next_x >= graph.length || next_y >= graph.length)
                    continue;

                if (!visit[next_x][next_y] && graph[next_x][next_y] == type){
                    visit[next_x][next_y] = true;
                    queue.add(new dot(next_x, next_y));
                    subList.add(new dot(next_x - x, next_y - y));
                }
            }
        }

        Collections.sort(subList);

        return subList;
    }

    public int findBlock(){
        int size = 0;
        boolean[] visitedBoard = new boolean[empty.size()];

        // 게임 보드의 빈 공간과 테이블의 블록만큼 반복하면서 빈 공간에 블록을 채움
        for(int i = 0; i < block.size(); i++){
            ArrayList<dot> checkBlock = block.get(i);

            for(int j = 0; j < empty.size(); j++){
                ArrayList<dot> checkEmpty = empty.get(j);

                // 빈 공간과 블록의 개수가 같고 방문한 적이 없는 곳일 경우
                if (checkEmpty.size() == checkBlock.size() && !visitedBoard[j]){
                    if(isRotate(checkEmpty, checkBlock)){
                        size += checkBlock.size();
                        visitedBoard[j] = true;
                        break;
                    }
                }
            }
        }
        return size;
    }

    public boolean isRotate(ArrayList<dot> empty, ArrayList<dot> block){
        for (int i = 0; i < 4; i++){ // 0, 90, 180, 270도 회전
            int zero_x = block.get(0).x;
            int zero_y = block.get(0).y;

            // 회전시키면서 좌표가 달라지기 때문에 다시 (0, 0)을 기준으로 블록 좌표를 변경해줘야 함..
            for (int j = 0; j < block.size(); j++){
                block.get(j).x -= zero_x;
                block.get(j).y -= zero_y;
            }

            boolean isOk = true;
            for (int j = 0; j < empty.size(); j++){
                dot emptyPoint = empty.get(j);
                dot blockPoint = block.get(j);

                //좌표가 다르면 빠꾸
                if (emptyPoint.x != blockPoint.x || emptyPoint.y != blockPoint.y){
                    isOk = false;
                    break;
                }
            }

            if (isOk){
                return true;
            }
            else{ //90도 회전 : x,y -> y, -x
                for(int j = 0; j < block.size(); j++){
                    int temp = block.get(j).x;

                    block.get(j).x = block.get(j).y;
                    block.get(j).y = -temp;
                }

                Collections.sort(block);
            }
        }
        return false;
    }
}
class dot implements Comparable<dot>{
    int x, y;

    public dot (int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(dot d){
        if (this.x == d.x)
            return this.y - d.y;

        return this.x - d.x;
    }
}
