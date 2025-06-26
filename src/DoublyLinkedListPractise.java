
public class DoublyLinkedListPractise {
	
	public static void main(String[] args) {
		createDoublyLinkedList();
		
	}
	
	private static void createDoublyLinkedList() {
		int[] arr= {4,3,7,1,8};
		
		DoubleNode head = new DoubleNode(arr[0]);
		DoubleNode back=head;
		DoubleNode front;
		
		for(int i=1; i<arr.length;i++) {
			front = new DoubleNode(back, arr[i], null);
			back.next=front;
			back=front;
		}
		back=head;
		while(back !=null) {
			System.out.println(back.data);
			back=back.next;
		}
		
		back=head;
		while(back.next !=null) {
			back=back.next;
		}
		
		while(back != null) {
			System.out.println(back.data);
			back=back.prev;
		}
	}
}

class  DoubleNode{
	DoubleNode prev;
	int data;
	DoubleNode next;
	public DoubleNode(DoubleNode prev, int data, DoubleNode next) {
		this.prev = prev;
		this.data = data;
		this.next = next;
	}
	public DoubleNode(int data) {
		this.data = data;
		this.prev=null;
		this.next=null;
	}
}
