package utilities;

import java.util.Iterator;
import referenceBasedTreeImplementation.BSTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.TreeException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


public class BSTreeTest {

	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testBSTree() {
	    BSTree<Integer> tree = new BSTree<>();
	    assertNotNull(tree, "The tree should not be null");
	    assertTrue(tree.isEmpty(), "The tree should be empty upon initialization");
	}


	
	@Test
    void testGetRoot() {
        BSTree<Integer> tree = new BSTree<>();

    
        assertThrows(TreeException.class, () -> tree.getRoot(), "TreeException should be thrown when the tree is empty.");

       
        tree.add(10);

      
        try {
            BSTreeNode<Integer> root = tree.getRoot();
            assertNotNull(root, "Root should not be null when the tree has elements.");
            assertEquals(10, root.getData(), "The data of the root should be the first element added.");
        } catch (TreeException e) {
            fail("TreeException should not be thrown when the tree has elements.");
        }
    }

	
	@Test
    void testGetHeight() {BSTree<Integer> tree = new BSTree<>();

  
    assertEquals(0, tree.getHeight(), "The height of an empty tree should be 0.");

   
    tree.add(15);
    assertEquals(1, tree.getHeight(), "The height of the tree should be 0 if there is only one node.");

  
    tree.add(10);
    tree.add(20);
    assertEquals(1, tree.getHeight(), "The height should be 1 for a tree with three nodes and two levels.");
    
    tree.add(5);
    assertEquals(2, tree.getHeight(), "The height should be 2 if the tree has a depth of two levels.");
  
    /*tree.add(25);
    assertEquals(2, tree.getHeight(), "The height should increase as more levels are added.");

   
    tree.add(27);
    assertEquals(3, tree.getHeight(), "The height should reflect the deepest path from root to leaf.");*/

       
    }


	@Test
    void testSize() {
        BSTree<Integer> tree = new BSTree<>();
        
       
        assertEquals(0, tree.size(), "The size of the tree should be 0 when it's empty.");

       
        tree.add(10);
        assertEquals(1, tree.size(), "The size of the tree should be 1 after adding one element.");

        tree.add(5);
        assertEquals(2, tree.size(), "The size of the tree should be 2 after adding two elements.");

        tree.add(15);
        assertEquals(3, tree.size(), "The size of the tree should be 3 after adding three elements.");

    }

	
	@Test
	void testIsEmpty() {
	    BSTree<Integer> bst = new BSTree<>();
	    assertTrue("Tree should be empty initially", bst.isEmpty());
	    bst.add(10);  
	    assertFalse("Tree should not be empty after adding an element", bst.isEmpty());
	}


	
	@Test
    void testClear() {
        BSTree<Integer> tree = new BSTree<>();
        // Adding elements to the tree
        tree.add(10);
        tree.add(5);
        tree.add(15);

       
        assertFalse(tree.isEmpty(), "The tree should not be empty after adding elements.");

        tree.clear();

        assertTrue(tree.isEmpty(), "The tree should be empty after calling clear.");
    }

	
	@Test
	void testContains() throws TreeException {
        BSTree<Integer> tree = new BSTree<>();
        
        assertFalse(tree.contains(10), "The tree should not contain an element not yet added.");

        tree.add(10);
        assertTrue(tree.contains(10), "The tree should contain the element after adding.");

        tree.add(20);
        assertTrue(tree.contains(20), "The tree should contain the element after adding.");
        assertFalse(tree.contains(15), "The tree should not contain an element that wasn't added.");
    }

	
	@Test
    void testSearch() {
        /*BSTree<Integer> tree = new BSTree<>();

       
        assertThrows(TreeException.class, () -> tree.search(10), "Searching in an empty tree should throw a TreeException.");

        
        tree.add(15);
        tree.add(10);
        tree.add(20);

       
        try {
            BSTreeNode<Integer> foundNode = tree.search(10);
            assertNotNull(foundNode, "Search should return a non-null node for an element present in the tree.");
            assertEquals(10, foundNode.getData(), "The data of the found node should match the searched element.");
        } catch (TreeException e) {
            fail("TreeException should not be thrown when searching for an element present in the tree.");
        }*/
	assertThrows(TreeException.class, () -> tree.search(10), "Searching in an empty tree should throw a TreeException.");

        tree.add(15);
        tree.add(10);
        tree.add(20);

        BSTreeNode<Integer> foundNode = tree.search(10);
        assertNotNull(foundNode, "Search should return a non-null node for an element present in the tree.");
        assertEquals(10, (int)foundNode.getData(), "The data of the found node should match the searched element.");
        
        assertThrows(TreeException.class, () -> tree.search(5), "Searching for an element not in the tree should throw a TreeException.");
    }

	
	
	@Test
	void testAdd() throws TreeException {
	    BSTree<Integer> tree = new BSTree<>();
	    tree.add(15);
	    assertNotNull(tree.search(15), "The tree should contain the element added.");
	 
	}


	
	@Test
    void testInorderIterator() {
        BSTree<Integer> tree = new BSTree<>();
        tree.add(15);
        tree.add(10);
        tree.add(20);
        tree.add(5);
        tree.add(17);

        utilities.Iterator<Integer> it = tree.inorderIterator();
        assertTrue(it.hasNext(), "Iterator should have next element.");
        
        // Check if the iterator returns elements in ascending order
        assertEquals(5, it.next(), "First element in in-order should be 5.");
        assertEquals(10, it.next(), "Second element in in-order should be 10.");
        assertEquals(15, it.next(), "Third element in in-order should be 15.");
        assertEquals(17, it.next(), "Fourth element in in-order should be 17.");
        assertEquals(20, it.next(), "Fifth element in in-order should be 20.");
        
        assertFalse(it.hasNext(), "Iterator should not have more elements after the last one.");
    }

	
	@Test
	void testPreorderIterator() {
	    /*BSTree<Integer> bst = new BSTree<>();
	  
	    bst.add(10);
	    bst.add(5);
	    bst.add(15);

	  
	    Integer[] expectedPreOrder = {10, 5, 15};
	    int index = 0;

	  
	    @SuppressWarnings("unchecked")
		Iterator<Integer> it = (Iterator<Integer>) bst.preorderIterator();

	 
	    while (it.hasNext()) {
	        Integer element = it.next();
	        assertEquals("Element should match expected pre-order value", expectedPreOrder[index], element);
	        index++;
	    }

	   
	    assertEquals("Should have iterated through all elements", expectedPreOrder.length, index);*/
	    
	    tree.add(10);
            tree.add(5);
            tree.add(15);

            Iterator<Integer> it = tree.preorderIterator();
            assertTrue(it.hasNext(), "Iterator should have next element.");
    
            assertEquals(10, (int)it.next(), "First element should be the root.");
            assertEquals(5, (int)it.next(), "Second element should be the left child.");
            assertEquals(15, (int)it.next(), "Fifth element should be the right child.");
            assertFalse(it.hasNext(), "Iterator should not have more elements after the last one.");
	
	}


	
	@Test
    void testPostorderIterator() {
        BSTree<Integer> tree = new BSTree<>();
        tree.add(15);
        tree.add(10);
        tree.add(20);
        tree.add(5);
        tree.add(17);

        utilities.Iterator<Integer> it = tree.postorderIterator();
        assertTrue(it.hasNext(), "Iterator should have next element.");


        assertEquals(5, it.next(), "First element in post-order should be the leftmost leaf.");
        assertEquals(10, it.next(), "Second element should be the parent of the first element if it's a leaf.");
        assertEquals(17, it.next(), "Third element should follow post-order logic.");
        assertEquals(20, it.next(), "Fourth element should be the right child.");
        assertEquals(15, it.next(), "Fifth element should be the root.");

        assertFalse(it.hasNext(), "Iterator should not have more elements after the last one.");
    }

}
