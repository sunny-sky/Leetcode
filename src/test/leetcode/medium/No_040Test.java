package test.leetcode.medium;

import leetcode.medium.No_040;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No_040 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since 03/09/2019
 */
public class No_040Test {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: combinationSum2(int[] candidates, int target)
     */
    @Test
    public void testCombinationSum2() throws Exception {
        No_040 example = new No_040();
        List<List<Integer>> list = new ArrayList<>();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        Integer target = 8;
        list = example.combinationSum2(candidates, target);
        System.out.println(list);
    }

    /**
     * Method: recursive(int[] candidates, int tempTarget, List<Integer> list, int startIndex)
     */
    @Test
    public void testRecursive() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = No_040.getClass().getMethod("recursive", int[].class, int.class, List<Integer>.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
