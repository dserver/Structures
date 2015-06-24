package jonathanhenk.sedgewick.structures;

public class VariableArrayPriorityQueue {

	private int front;
	private int size;
	private PriorityQueueElement[] queue;
	
	public VariableArrayPriorityQueue()
	{
		front = 0;
		size = 0;
		queue = new PriorityQueueElement[16];
	}
	
	public void enqueue(PriorityQueueElement e)
	{
		if (size==0)
		{
			queue[front] = e;
			size++;
		}
		else
		{
			if (size+1 == queue.length)
				resize(queue.length*2);
			
			int current = front;
			while (queue[current].priority() >= e.priority())
			{
				current = (current+1) % queue.length;
			}
			
			int b = (front+size) % queue.length;
			while (b != current)
			{
				int b_m1 = (b-1) % queue.length;
				queue[b] = queue[b_m1];
				b = b_m1;
			}
			
			queue[current] = e;
			size++;
			
		}
	}
	
	public PriorityQueueElement dequeue()
	{
		if (size==0)
			return null;
		PriorityQueueElement e = queue[front];
		front = (front+1) % queue.length;
		size--;
		return e;
		
	}
	
	private void resize(int new_size)
	{
		
	}
	
	
}
