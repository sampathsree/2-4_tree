
/**
 * 
 * @author Sampath
 *
 */


class Node {
	private static final int ORDER = 4;
	private int numItems;
	private Node parent;
	private Node childArray[] = new Node[ORDER];
	private NodeData itemArray[] = new NodeData[ORDER - 1];

	// connect child to this node
	public void connectChild(int childNum, Node child) {
		childArray[childNum] = child;
		if (child != null)
			child.parent = this;
	}

	// disconnect child from this node, return it
	public Node disconnectChild(int childNum) {
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}

	public Node getChild(int childNum) {
		return childArray[childNum];
	}

	public Node getParent() {
		return parent;
	}

	public boolean isLeaf() {
		return (childArray[0] == null) ? true : false;
	}

	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int theValue) {
		numItems = theValue;
		return;
	}

	public NodeData getItem(int index) // get NodeData at index
	{
		return itemArray[index];
	}

	public NodeData setItem(int index, NodeData theValue) // get NodeData at
															// index
	{
		itemArray[index] = theValue;
		return itemArray[index];
	}

	public boolean isFull() {
		return (numItems == ORDER - 1) ? true : false;
	}

	public int insertItem(NodeData newItem) {
		// assumes node is not full
		numItems++; // will add new item
		int newKey = newItem.dData; // key of new item

		// Should start this for loop at numItems-1, rather than ORDER -2

		for (int j = ORDER - 2; j >= 0; j--) // start on right,
		{ // examine items
			if (itemArray[j] == null) // if item null,
				continue; // go left one cell
			else // not null,
			{ // get its key
				int itsKey = itemArray[j].dData;
				if (newKey < itsKey) // if it's bigger
					itemArray[j + 1] = itemArray[j]; // shift it right
				else {
					itemArray[j + 1] = newItem; // insert new item
					return j + 1; // return index to
				} // new item
			} // end else (not null)
		} // end for // shifted all items,
		itemArray[0] = newItem; // insert new item
		return 0;
	} // end insertItem()

	public void insertatfront(NodeData newItem) {

		int newKey = newItem.dData; // key of new item
		numItems++;
		for (int j = numItems - 1; j > 0; j--) {
			itemArray[j] = itemArray[j - 1];
			connectChild(j + 1, disconnectChild(j));
		}
		connectChild(1, disconnectChild(0));
		itemArray[0] = newItem;
		connectChild(0, null);

		return;
	}

	public NodeData removeItem() // remove largest item
	{
		// assumes node not empty
		NodeData temp = itemArray[numItems - 1]; // save item
		itemArray[numItems - 1] = null; // disconnect it
		numItems--; // one less item
		return temp; // return item
	}

	public void displayNode() // format "/24/56/74/"
	{
		for (int j = 0; j < numItems; j++)
			itemArray[j].displayItem(); // "56,"
		// System.out.println();
	}

	public void displayvalue(int j) // format "/24/56/74/"
	{
		itemArray[j].displayItem(); // "/56"
		// System.out.println();
		// System.out.println("/"); // final "/"
	}

	public void deletenodevalue(int theValue) {
		// Only valid for leafs
		int flag = -1;
		// just delete the value and decrease node size
		for (int i = 0; i < numItems; i++) {
			if (theValue == itemArray[i].dData) {
				flag = i;
			}
			if (flag != -1 && i + 1 < numItems) {
				itemArray[i].dData = itemArray[i + 1].dData;
			}
		}
		itemArray[numItems - 1] = null; // disconnect it
		numItems--; // one less item

	}

	public void deletevalue(int theValue, String side) {
		// Only valid for leafs
		int flag = -1;
		// just delete the value and decrease node size
		for (int i = 0; i < numItems; i++) {
			if (theValue == itemArray[i].dData) {
				flag = i;
			}
			if (flag != -1 && i + 1 < numItems) {
				itemArray[i].dData = itemArray[i + 1].dData;
			}
		}
		itemArray[numItems - 1] = null; // disconnect it
		numItems--; // one less item

	}

	public Node getsibiling(int theValue) {
		// get the sibling
		Node x = null;
		Node p = getParent();
		if (numItems != 0) {
			for (int i = 0; i <= p.numItems; i++) {
				if (p.childArray[i].itemArray[0].dData < theValue) {
					// System.out.println(p.childArray[i].numItems);
					// System.out.println(p.childArray[i].itemArray[0].dData);
					x = p.childArray[i];
				}
			}
		} else if (numItems == 0) {
			for (int i = 0; i <= p.numItems; i++) {
				if (p.childArray[i].itemArray[0] == null) {
					// System.out.println(p.childArray[i].numItems);
					// System.out.println(p.childArray[i].itemArray[0].dData);
					if (i != 0) {
						x = p.childArray[i - 1];
					}
				}
			}
		}
		return x;
	}

}