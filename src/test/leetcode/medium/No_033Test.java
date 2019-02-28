package test.leetcode.medium;

import leetcode.medium.No_033;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * No_033 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since 02/27/2019
 */
public class No_033Test {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: search(int[] nums, int target)
     */
    @Test
    public void testSearch() throws Exception {
        No_033 func = new No_033();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        int res = func.search(nums, target);
        System.out.println(res);
    }

    /**
     * Method: biSearch(int[] nums, int start, int end, int target)
     */
    @Test
    public void testBiSearch() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = No_033.getClass().getMethod("biSearch", int[].class, int.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
