package jonathanhenk.sedgewick.structures;

import java.lang.reflect.Array;
import java.util.Random;
/*
 * The type E must have an overrided method equals() in order for the set
 * to work properly.
 */
public class FixedSizeSet<E> {

	private int max_size;
	private E[] elements;
	private Class<E> type;
	private int empty_index;
	
	public FixedSizeSet(Class<E> e_type, int n)
	{
		
		max_size = n;
		type = e_type;
		empty_index = 0;
		elements = (E[]) Array.newInstance(type, max_size);
		
	}
	
	public boolean find(E elem)
	{
		for (int i=0; i<empty_index; i++)
			if (elements[i].equals(elem))
				return true;
		
		return false;
	}
	
	public void insert(E elem)
	{
		if (find(elem))
			return; // set already contains this element
		
		if (empty_index==max_size)
			return; // full. throw error here?
		else
		{
			elements[empty_index] = elem;
			empty_index++;
			return;
		}
	}
	
	public void remove(E elem)
	{
		int j;
		for (j=0; j < empty_index; j++)
		{
			if (elements[j].equals(elem))
				break;
		}
		
		if (j == empty_index)
			return; // element wasn't in the set
		else
		{
			for (int i=j+1; i < empty_index; i++)
				elements[i-1] = elements[i];
			empty_index--;
		}
	}
	
	public int size()
	{
		return empty_index;
	}
	
	public E removeRandom()
	{
		assert (empty_index != 0) : "Cannot remove from empty set.";
		
		Random r = new Random();
		E removed_elem = elements[r.nextInt(empty_index)];
		remove(removed_elem);
		return removed_elem;
		
	}
	
	public boolean isEmpty()
	{
		if (empty_index == 0)
			return true;
		else
			return false;
	}
}
