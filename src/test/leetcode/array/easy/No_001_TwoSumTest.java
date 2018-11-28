package test.leetcode.array.easy;

import leetcode.array.easy.No_001_TwoSum;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * No_001_TwoSum Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since 11/12/2018
 */
public class No_001_TwoSumTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: twoSum(int[] nums, int target)
     */
    @Test
    public void testTwoSum() throws Exception {
//TODO: Test goes here...
        No_001_TwoSum test = new No_001_TwoSum();
        int[] param = {1, 2};
        int[] temp = test.twoSum(param, 3);
        int[] actual = {0, 1};
//        assertEquals(actual[0], temp[0]);
//        assertEquals(actual[1], temp[1]);
        Assert.assertArrayEquals(actual, temp);
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testMain() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: twoSum2(int[] nums, int target)
     */
    @Test
    public void testTwoSum2() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: twoSum3(int[] nums, int target)
     */
    @Test
    public void testTwoSum3() throws Exception {
//TODO: Test goes here... 
    }

} 
