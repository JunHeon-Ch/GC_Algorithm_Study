package 프로그래머스.lv3.길찾기게임;

import java.util.*;

class Solution {
    public int[][] answer;
    public int idx = 0;
    public int[][] solution(int[][] nodeinfo) {
        ArrayList<tree> nodeList = new ArrayList<>();
        for(int i=0; i<nodeinfo.length; i++)
            nodeList.add(new tree(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null));

        Collections.sort(nodeList);

        tree root = nodeList.get(0);
        for(int i=1; i<nodeList.size(); i++)
            makeTree(root, nodeList.get(i));

        answer = new int[2][nodeinfo.length];
        preorder(root);
        idx = 0;
        postorder(root);

        return answer;
    }

    public void makeTree(tree root, tree child){
        if(root.x > child.x){
            if(root.leftChild == null)
                root.leftChild = child;
            else
                makeTree(root.leftChild, child);
        }
        else{
            if(root.rightChild == null)
                root.rightChild = child;
            else
                makeTree(root.rightChild, child);
        }
    }

    public void preorder(tree root) {
        if(root != null) {
            answer[0][idx++] = root.value;
            preorder(root.leftChild);
            preorder(root.rightChild);
        }
    }

    public void postorder(tree root) {
        if(root != null) {
            postorder(root.leftChild);
            postorder(root.rightChild);
            answer[1][idx++] = root.value;
        }
    }

}
class tree implements Comparable<tree>{
    int x, y;
    int value;
    tree leftChild, rightChild;

    public tree (int x, int y, int value, tree leftChild, tree rightChild){
        this.x = x;
        this.y = y;
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(tree t){
        if(this.y == t.y)
            return t.x - this.x;
        else
            return t.y - this.y;
    }
}
