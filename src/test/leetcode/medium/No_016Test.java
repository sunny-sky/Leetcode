package test.leetcode.medium;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import leetcode.medium.No_016;

import static junit.framework.TestCase.assertEquals;

/**
 * No_016 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since 02/01/2019
 */
public class No_016Test {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: threeSumClosest(int[] nums, int target)
     */
    @Test
    public void testThreeSumClosest() throws Exception {
        No_016 n16 = new No_016();
        int[] nums = new int[]{-1, 0,1 , 1, 55};
        int target = 3;
        int res = n16.threeSumClosest(nums, target);
        assertEquals(res, 2);
    }

} 
