package algorithm.girlTeacher.sortedLinkList;

public class Node {

	public long dData;
	public Node next;
	public Node(long dd) {
		this.dData = dd;
	}
	
	public void displayNode() {
		System.out.print(dData + " ");
	}
}
