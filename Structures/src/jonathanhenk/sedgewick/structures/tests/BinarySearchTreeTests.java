package jonathanhenk.sedgewick.structures.tests;

import junit.framework.TestCase;
import jonathanhenk.sedgewick.structures.*;

public class BinarySearchTreeTests extends TestCase {

	public void testBasics()
	{
		BinarySearchTree bst = new BinarySearchTree<Integer, String>();
		bst.insert(17, "seventeen");
		bst.insert(20, "cheese");
		bst.insert(5, "apples");
		
		assertEquals("failure -- size not 3.", 3, bst.size());
		
		String v = bst.get(17);
		assertEquals("failure - key 17 not 'seventeen'", "seventeen", v);
		
		v = bst.get(2);
		assertEquals("failure - didn't return null when key doesn't exist.", null, v);
		
		bst.insert(5, "oranges");
		v = bst.get(5);
		assertEquals("failur - didn't return oranges after value updated.", "oranges", v);
		
	}
	
	public void testRemoval()
	{
		BinarySearchTree bst = new BinarySearchTree<Integer, String>();
		bst.insert(17, "seventeen");
		bst.insert(20, "cheese");
		bst.insert(5, "apples");
		
		bst.remove(5);
		assertEquals("failure - 5 not null after removal.", null, bst.get(5));
		assertEquals("failure - size not 2.", 2, bst.size());
		
		bst.remove(20);
		bst.remove(17);
		assertEquals("failure - size not 0.", 0, bst.size());
		
	}
}
