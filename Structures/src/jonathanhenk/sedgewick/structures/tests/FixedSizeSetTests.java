package jonathanhenk.sedgewick.structures.tests;

import junit.framework.TestCase;
import junit.framework.Test;
import jonathanhenk.sedgewick.structures.FixedSizeSet;
public class FixedSizeSetTests extends TestCase {

	public void testAddElements()
	{
		FixedSizeSet<String> stringSet = new FixedSizeSet<String>(String.class, 4);
		stringSet.insert("Test1");
		stringSet.insert("Test2");
		stringSet.insert("Test3");
		stringSet.insert("Test4");
		assertTrue("failure - couldn't find 'Test1'.", stringSet.find("Test1"));
		assertTrue("failure - couldn't find 'Test2'.", stringSet.find("Test2"));
		assertTrue("failure - couldn't find 'Test4'.", stringSet.find("Test4"));
		
		stringSet.remove("Test1");
		assertFalse("failure - found an item not in the set.", stringSet.find("Test1"));
		
	}
	
	public void testSize()
	{
		FixedSizeSet<String> stringSet = new FixedSizeSet<String>(String.class, 4);
		assertEquals("failure - size is wrong.", 0, stringSet.size());
		stringSet.insert("Test1");
		assertEquals("failure - size is wrong.", 1, stringSet.size());
		stringSet.insert("Test2");
		assertEquals("failure - size is wrong.", 2, stringSet.size());
		stringSet.insert("Test3");
		stringSet.insert("Test4");
		assertEquals("failure - size is wrong.", 4, stringSet.size());

		stringSet.remove("Test1");
		assertEquals("failure - size is wrong.", 3, stringSet.size());
	}
}
