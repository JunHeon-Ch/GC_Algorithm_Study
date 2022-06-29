package PS_2021.프로그래머스.level3.길_찾기_게임;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42892
 * 알고리즘: 트리
 * 시간복잡도: O(n*logn + n*m) = O(n*m), n=10,000(nodeinfo 배열 길이), m=1,000(트리 깊이)
                nlogn: 정렬, n*m: 트리 생성
 */

class Solution {

    Node[] node;
    int[][] answer;
    int cnt = 0;

    public int[][] solution(int[][] nodeinfo) {
        int len = nodeinfo.length;
        node = new Node[len];
        int idx = 0;
        for (int[] info : nodeinfo) {
            node[idx++] = new Node(idx, info[0], info[1]);
        }
        // y가 큰 순서, x가 작은 순서
        Arrays.sort(node, (n1, n2) -> {
            if (n1.y == n2.y) return n1.x - n2.x;
            return n2.y - n1.y;
        });
        // 트리 생성
        for (int i = 1; i < len; i++) {
            makeTree(i, 0, -1, 100001);
        }

        answer = new int[2][len];
        preorder(0);
        cnt = 0;
        postorder(0);
        return answer;
    }

    // 루트 노드부터 시작해서 기준에 부합하는 위치를 찾아 추가한다.
    // 기준
    // 왼쪽 서브 트리 -> node[i].x > min && node[i] < node[parent].x
    // 오른쪽 서브 트리 -> node[i].x > node[parent].x && node[i] < max

    // i -> 추가할 노드의 인덱스
    // parent -> 추가할 노드의 부모 노드 인덱스
    // min -> 추가할 노드의 x의 최소값
    // max -> 추가할 노드의 x의 최대값
    public void makeTree(int i, int parent, int min, int max) {
        if (min < node[i].x && node[i].x < node[parent].x) { // 왼쪽 서브 트리
            if (node[parent].left == -1) { // 비어 있을 경우
                node[parent].left = i;
                return;
            }
            makeTree(i, node[parent].left, min, node[parent].x); // 비어 있지 않은 경우

        } else if (node[i].x > node[parent].x && node[i].x < max) { // 오른쪽 서브 트리
            if (node[parent].right == -1) { // 비어 있을 경우
                node[parent].right = i;
                return;
            }
            makeTree(i, node[parent].right, node[parent].x, max); // 비어 있지 않은 경우
        }
    }

    public void preorder(int i) {
        if (i == -1) return;
        answer[0][cnt++] = node[i].idx;
        preorder(node[i].left);
        preorder(node[i].right);
    }

    public void postorder(int i) {
        if (i == -1) return;
        postorder(node[i].left);
        postorder(node[i].right);
        answer[1][cnt++] = node[i].idx;
    }
}

class Node {
    int idx, x, y;
    int left, right;

    public Node(int idx, int x, int y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
        this.left = this.right = -1;
    }
}