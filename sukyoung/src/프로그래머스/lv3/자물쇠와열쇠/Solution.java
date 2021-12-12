package 프로그래머스.lv3.자물쇠와열쇠;

class Solution {
    public int[][] extend_lock;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

        int length = lock.length + (2 * (key.length -1));
        int offset = key.length - 1;

        for (int i = 0; i < offset + lock.length; i++) {
            for (int j = 0; j < offset + lock.length; j++) {

                for (int k = 0; k < 4; k++) {
                    extend_lock = new int[length][length];
                    initPlace(offset, lock);
                    rotateKey(i, j, key, k);

                    boolean check = checkPlace(offset, lock);
                    if (check) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public void initPlace(int index, int[][] lock) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[i].length; j++) {
                extend_lock[index + i][index + j] = lock[i][j];
            }
        }
    }

    public boolean checkPlace(int index, int[][] lock) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[i].length; j++) {
                if (extend_lock[index + i][index + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void rotateKey(int x, int y, int[][] key, int k) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                if (k == 0) {
                    extend_lock[x + i][y + j] += key[i][j];
                } else if (k == 1) {
                    extend_lock[x + i][y + j] += key[key.length - j - 1][i];
                } else if (k == 2) {
                    extend_lock[x + i][y + j] += key[key.length - i - 1][key.length - j - 1];
                } else if (k == 3) {
                    extend_lock[x + i][y + j] += key[j][key.length - i - 1];
                }
            }
        }
    }

}
