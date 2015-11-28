
/**
 * 
 * @author Sampath
 *
 */


public class NodeData {
	public int dData; // one data item

	public NodeData(int dd) // constructor
	{
		dData = dd;
	}

	public void displayItem() // display item, format "27,"
	{
		System.out.print(dData+",");
	}

}