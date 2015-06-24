
package jonathanhenk.sedgewick.structures.tests;

import jonathanhenk.sedgewick.structures.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;


public class LinkedListTest extends TestCase
{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LinkedListTest( String testName )
    {
        super( testName );
    }

    /**k
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LinkedListTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    public void testInsertAtBeginningAndRemoveFromBeginning()
    {
    	LinkedList<String> ll = new LinkedList<String>();
        ll.insertAtBeginning("Two");
        ll.insertAtBeginning("One");

        try {
        Assert.assertEquals("failure - front item not One", "One", ll.removeFromBeginning());
        Assert.assertEquals("failure - front item not Two", "Two", ll.removeFromBeginning());
        } catch (Exception e)
        {
            Assert.fail("Exception thrown removing from non-empty list.");
        }
    	
    }

    public void testSize()
    {
        LinkedList<String> ll = new LinkedList<String>();
        Assert.assertEquals("failure - empty list has non-zero size.", 0, ll.size());

        ll.insertAtBeginning("Two");
        Assert.assertEquals("failure - list has 1 item but size != 1.", 1, ll.size());

        ll.insertAtBeginning("One");

        Assert.assertEquals("failure - list has 2 item but size != 2.", 2, ll.size());

        try {
        ll.removeFromBeginning();
        Assert.assertEquals("failure - list has 1 item after remove but size != 1.", 1, ll.size());

        ll.removeFromBeginning();
        Assert.assertEquals("failure - empty list has non-zero size.", 0, ll.size());
        } catch (Exception e)
        {
            Assert.fail("Exception thrown removing from non-empty list.");
        }
    }
}