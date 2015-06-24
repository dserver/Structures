package jonathanhenk.sedgewick.structures;


import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item>
{
	private Node first;
	private Node last;
	private int size;

	public void insertAtBeginning(Item a)
	{
		Node old_first = first;
		Node new_node = new Node();
		new_node.item = a;

		if (size==0)
		{
			first = new_node;
			last = new_node;
			new_node.next = first;
		}
		else
		{
			new_node.next = old_first;
			first = new_node;
		}

		size++;
	}

	public Item removeFromBeginning() throws Exception
	{
		Item r;
		if (size==0)
			throw new Exception("Cannot remove from an empty list.");
		else if (size==1)
		{
			r = first.item;
			first.item = null;
			first = null;
			last.item = null;
			last = null;

		}
		else
		{
			r = first.item;
			first = first.next;
		}

		size--;
		return r;
	}

	public void insertAtEnd(Item a)
	{
		Node new_node = new Node();
		new_node.item = a;
		new_node.next = null;

		if (size==0)
		{
			first = new_node;
			last = new_node;
		}
		else if (size==1)
		{
			first.next = new_node;
			last = new_node;
		}
		else
		{
			last.next = new_node;
			last = new_node;
		}

		size++;
	}

	public int size()
	{
		return size;
	}

	private class Node
	{
		Item item;
		Node next;
	}

	// ITERATOR METHODS
	public Iterator<Item> iterator()
	{
		return new LinkedListIterator();
	}


	private class LinkedListIterator implements Iterator<Item>
	{
		Node current = first;
		public boolean hasNext()
		{
			if (current==null)
				return false;
			else
				return true;
		}

		public Item next()
		{
			Node old_current = current;
			current = current.next;
			return old_current.item;
		}
	}
}