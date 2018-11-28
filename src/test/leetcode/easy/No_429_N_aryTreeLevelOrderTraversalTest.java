package test.leetcode.easy;

import leetcode.easy.No_429_N_aryTreeLevelOrderTraversal;
import leetcode.utils.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * No_429_N_aryTreeLevelOrderTraversal Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since 11/15/2018
 */
public class No_429_N_aryTreeLevelOrderTraversalTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: levelOrder(Node root)
     */
    @Test
    public void testLevelOrder() throws Exception {
        No_429_N_aryTreeLevelOrderTraversal no_429 = new No_429_N_aryTreeLevelOrderTraversal();

        Node root = new Node(1, null);
        List<Node> list56 = new ArrayList<>();
        List<Node> list234 = new ArrayList<>();
        list56.add(new Node(5, null));
        list56.add(new Node(6, null));
        list234.add(new Node(2, null));
        list234.add(new Node(3, list56));
        list234.add(new Node(4, null));
        root.children = list234;
        List<List<Integer>> res = no_429.levelOrder(root);

        System.out.println(res.toString());
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> temp = new LinkedList<>();
        temp.add(1);
        expected.add(temp);
        temp.clear();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        expected.add(temp);
        temp.clear();
        temp.add(5);
        temp.add(6);
        expected.add(temp);

        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(expected.get(i).toArray(), res.get(i).toArray());
        }

    }

} 
