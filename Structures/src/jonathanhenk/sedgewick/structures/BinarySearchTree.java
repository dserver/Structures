package jonathanhenk.sedgewick.structures;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	private Node root;
	private int size;
	
	public BinarySearchTree()
	{
		root = null;
		size = 0;
	}
	
	public void insert(Key k, Value v)
	{
		Node new_node = new Node(k, v);
		Node current = root;
		Node previous = null;
		
		while (current != null)
		{
			// compare current node to insert node
			int compare_to = current.key.compareTo(k);
			
			switch (compare_to){
				case 1: // current is greater
					previous = current;
					current = current.left;
					break;
				case 0: // current is equal
					if (previous == null) {
						new_node.left = root.left;
						new_node.right = root.right;
						root = new_node;
					} else
					{
						new_node.left = current.left;
						new_node.right = current.right;
						
						if (previous.key.compareTo(current.key) > 0)
							previous.left = new_node;
						else
							previous.right = new_node;
					}
					break;
				case -1: // current is less than
					current = null;
					break;
			}
		}
	}
	
	class Node
	{
		public Key key;
		public Value value;
		public Node left;
		public Node right;
		public int subtree_size;
		
		public Node(Key k, Value v)
		{
			key = k;
			value = v;
			subtree_size = 1;
		}
		
		public Node(Key k, Value v, Node l, Node r)
		{
			key = k;
			value = v;
			left = l;
			right = r;
			subtree_size = this.getSubtreeSize();
		}
		
		public int getSubtreeSize()
		{
			if (right != null && left != null)
				return 1 + right.getSubtreeSize() + left.getSubtreeSize();
			else if (right == null)
				return 1 + left.getSubtreeSize();
			else
				return 1 + right.getSubtreeSize();
		}
		
		
	}

}
