
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


/**
 * 
 * @author Sampath
 *
 */

public class Project {

	public static void main(String[] args) {
		TwoFour theTree = new TwoFour();
		int n;
		Random random = new Random();
		while (true) {
			try {
				System.out.println("1. Insert n random Integers\n"
						+ "2. Perform 2n operations with probability\n3. Print In Order"
						+ "\n4. View Tree level by level\n5. Insert an element\n6. Delete an element"
						+ "\n7. find an element\n8. Quit");
				char choice = getChar();
				switch (choice) {
				case '1':
					System.out.println("Enter the value of n");
					n = getInt();
					for (int a = 1; a < n+1; a++) {
						Node present = theTree.find(a);
						if (present != null){
							//System.out.println("Data Already present!!");
						}else{
							theTree.insert(a);
						}
					}
					break;
				case '2':
					System.out.println("Enter the value of n");
					n = getInt();
					long startTime, endTime;
					int operation = 0;
					int searchCount = 0;
					int insertCount = 0;
					int deleteCount = 0;
					startTime = System.nanoTime();
					while (operation < (2 * n)) {
						double rand = random.nextDouble();
						if (rand < 0.4) {
							// Making sure insert operation runs at 0.4
							// probability
							int x = random.nextInt(n);
							Node present = theTree.find(x);
							if (present != null) {
								//System.out.println("Data Already present!!");
							} else {
								theTree.insert(x);
							}
							operation++;
							insertCount++;
							
						}
						rand = random.nextDouble();
						if (rand < 0.25) { // Making sure delete operation runs at 0.25 //
											// probability
							int x = random.nextInt(n);
							Node del = theTree.find(x);
							if (del != null) {
								if (theTree.delete(del, x) != null)
								{//System.out.println("Deleted" + x);
								}else {
									//System.err.println("Not Deleted!!!");
								}
							} else
								//System.out.println("Could not find " + x);
							operation++;
							deleteCount++;
							
						}
						rand = random.nextDouble();
						if (rand < 0.35) { // Making sure search operation runs at 0.35 //
										// probability
							theTree.find(random.nextInt(n));
							operation++;
							searchCount++;
							
						}
					}
					endTime = System.nanoTime() - startTime;
					
					System.out.println("Total No. of search operations performed :"
							+ searchCount);
					System.out.println("Total No. of delete operations performed :"
							+ deleteCount);
					System.out.println("Total No. of insert operations performed :"
							+ insertCount);
					System.out.println("Total Time Taken:" + endTime + " nanoseconds");
					break;
				case '3':
					System.out.println("In Order: ");
					theTree.displayTree(1);
					break;
				case '4':
					System.out.println("Tree:");
					theTree.displayTree(0);
					break;
				case '5':
					System.out.println("Enter value to insert: ");
					int value = getInt();
					Node present = theTree.find(value);
					if (present != null){
						System.out.println("Data Already present!!");
					}else{
						theTree.insert(value);
					}
					break;
				case '6':
					System.out.println("Enter value to delete: ");
					value = getInt();
					Node del = theTree.find(value);
					if (del != null)
						{
							if(theTree.delete(del,value)!=null)
								System.out.println("Deleted" + value);
							else{
								System.err.println("Not Deleted!!!");
							}
						}
					else
						System.out.println("Could not find " + value);
					break;
				case '7':
					System.out.println("Enter value to find: ");
					value = getInt();
					Node found = theTree.find(value);
					if (found != null)
						System.out.println("Found " + value);
					else
						System.out.println("Could not find " + value);
					break;
				case '8':
					System.out.println("Thank you!!!");
					System.exit(0);
					
				default:
					System.out.println("Invalid entry\n");
				}
			} catch (Exception e) {
				System.err.println("Please enter valid input");
			}
		}

	}
	
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
}