package test.leetcode.easy;

import leetcode.easy.No_437_PathSumIII;
import leetcode.utils.TreeNode;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * No_437_PathSumIII Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since 11/18/2018
 */
public class No_437_PathSumIIITest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: pathSum(TreeNode root, int sum)
     */
    @Test
    public void testPathSum() throws Exception {
        TreeNode temp1 = new TreeNode(3);
        TreeNode temp2 = new TreeNode(-2);
        TreeNode temp3 = new TreeNode(3);
        temp3.left = temp1;
        temp3.right = temp2;
        temp1 = new TreeNode(1);
        temp2 = new TreeNode(2);
        temp2.right = temp1;
        temp1 = new TreeNode(5);
        temp1.right = temp2;
        temp1.left = temp3;
        temp2 = new TreeNode(11);
        temp3 = new TreeNode(-3);
        temp3.right = temp2;
        temp2 = new TreeNode(10);
        temp2.left = temp1;
        temp2.right = temp3;
        TreeNode root = temp2;

        No_437_PathSumIII pathSum = new No_437_PathSumIII();
        int res = pathSum.pathSum(root, 8);

        assertEquals(3, res);
    }

    /**
     * Method: helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum)
     */
    @Test
    public void testHelper() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = No_437_PathSumIII.getClass().getMethod("helper", TreeNode.class, int.class, int.class, HashMap<Integer,.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
