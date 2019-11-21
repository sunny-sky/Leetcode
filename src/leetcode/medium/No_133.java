package leetcode.medium;

import java.util.*;

public class No_133 {
    public Node cloneGraph(Node node) {
        // 判空
        if (node == null) {
            return null;
        }
        // 用map保存新旧两个节点的映射关系，其中key为老，value为旧
        // map中无，则新节点未建立，有则已建立且已访问
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);


    }

    private Node dfs(Node old, Map<Node, Node> map) {
        // 退出 node为空
        if (old == null) {
            return null;
        }
        if (map.containsKey(old)) {
            return map.get(old);
        }
        // 未建立old和new的映射
        Node newNode = new Node(old.val, new ArrayList<>());
        map.put(old, newNode);
        for (Node n : old.neighbors) {
            Node temp = dfs(n, map);
            if (temp != null) {
                newNode.neighbors.add(temp);
            }
        }
        return newNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
}

