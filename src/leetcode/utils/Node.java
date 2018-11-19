package leetcode.utils;

import java.util.List;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 15:02 2018/11/14
 * @Modified By:
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", children=" + children +
                '}';
    }
}
