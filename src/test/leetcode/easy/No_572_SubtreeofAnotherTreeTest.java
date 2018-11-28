package test.leetcode.easy;

import leetcode.easy.No_572_SubtreeofAnotherTree;
import leetcode.utils.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/** 
* No_572_SubtreeofAnotherTree Tester. 
* 
* @author <Authors name> 
* @since 11/22/2018
* @version 1.0 
*/ 
public class No_572_SubtreeofAnotherTreeTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: isSubtree(TreeNode s, TreeNode t) 
* 
*/ 
@Test
public void testIsSubtree() throws Exception {
    TreeNode t = new TreeNode(1);
    TreeNode point = t;
    for (int i = 0; i < 5; i++) {
        TreeNode temp = new TreeNode(1);
        point.right = temp;
        point = temp;
    }
    point.left = new TreeNode(2);
    System.out.println(t);

    TreeNode s = new TreeNode(1);
    TreeNode point1 = s;
    for (int i = 0; i < 10; i++) {
        TreeNode temp = new TreeNode(1);
        point1.right = temp;
        point1 = temp;
    }
    point1.left = new TreeNode(2);
    System.out.println(s);

    No_572_SubtreeofAnotherTree subTree = new No_572_SubtreeofAnotherTree();
    boolean ans = subTree.isSubtree(s, t);
    assertTrue(ans);
}


/** 
* 
* Method: helper(TreeNode s, TreeNode t) 
* 
*/ 
@Test
public void testHelper() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = No_572_SubtreeofAnotherTree.getClass().getMethod("helper", TreeNode.class, TreeNode.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
