import utils.Node;

public class LinkedListPractise {

	public static void main(String[] args) {
		createLinkedList();
		countElements();
		searchElement();
		insertEleementAtHead();
		insertEleementAtTail();
		insertEleementAtKthIndex();
		deleteEleementAtHead();
		deleteEleementAtTail();
		deleteEleementAtKthIndex();
		
		findMiddleByBruteForce();
		findMiddleByTortoiseAndHareMethod();
		reverseLinkedList();
		recursiveReverseLinkedList();
		detectLoopInLinkedList();
		startingPointInAloop();
		lengthOfLoop();
		palindromeCheck();
		segregateOddEvenIndex();
	}

	private static void createLinkedList() {
		int[] arr = {2,5,3,6,1,9};
		Node  head = new Node(arr[0]);
		Node mover = head;
		
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		mover =head;
		System.out.print("Linked List from Array : ");
		while(mover !=null) {
			System.out.print(mover.data);
			mover=mover.next;
		}
	}
	
	private static void countElements() {
		int[] arr = {2,5,3,6,1,9};
		Node  head = new Node(arr[0]);
		Node mover = head;
		int count =1;
		
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
			count++;
			
		}
		System.out.println();
		System.out.println("Linked List count : "+count);		
	}
	
	private static void searchElement() {
		int[] arr = {2,5,3,6,1,9};
		Node  head = new Node(arr[0]);
		Node mover = head;
		int target =8;
		
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		mover =head;
		while(mover !=null) {
			if(mover.data==target) {
				System.out.println("Data Found");
				return;
			}
			mover=mover.next;
		}
		System.out.println("Data Not Found");
	}
	
	private static void insertEleementAtHead() {
		int[] arr = {2,5,3,6,1,9};
		Node  head = new Node(arr[0]);
		Node mover = head;
		
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		head=new Node(1,head);
		System.out.print("Eelement inserted at head position : ");
		mover =head;
		while(mover !=null) {
			System.out.print(mover.data);
			mover=mover.next;
		}
	}
	
	private static void insertEleementAtTail() {
		int[] arr = {2,5,3,6,1,9};
		Node  head = new Node(arr[0]);
		Node mover = head;
		
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		Node add =new Node(1,null);
		System.out.println();
		System.out.print("Eelement inserted at Tail position : ");
		mover =head;
		while(mover.next !=null) {
			mover=mover.next;
		}
		mover.next=add;
		mover =head;
		while(mover !=null) {
			System.out.print(mover.data);
			mover=mover.next;
		}
		
	}
	
	private static void insertEleementAtKthIndex() {
		int[] arr = {2,5,3,6,1,9};
		int k =3;
		Node  head = new Node(arr[0]);
		Node mover = head;
		
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		
		if(head==null) {
			if(k==1) {
				head=new Node(8);
			}else {
				return;
			}
		}
		
		if(k==1) {
			Node add =new Node(8,null);
		}
		
		Node add =new Node(8);
		System.out.println();
		System.out.print("Eelement inserted at Kth position : ");
		mover =head;
		for(int i = 2; i<=k;i++) {
			mover=mover.next;
		}
		add.next=mover.next;
		mover.next=add;
		mover =head;
		while(mover !=null) {
			System.out.print(mover.data);
			mover=mover.next;
		}
		
	}
	
	private static void deleteEleementAtHead() {
		int[] arr = {2,5,3,6,1,9};
		Node  head = new Node(arr[0]);
		Node mover = head;
		
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		System.out.println();
		System.out.print("Eelement deleted at head position : ");
		head =head.next;
		mover=head;
		while(mover !=null) {
			System.out.print(mover.data);
			mover=mover.next;
		}
	}
	
	private static void deleteEleementAtTail() {
		
		//for deleting check if head is the tail as well and return null
		
		int[] arr = {2,5,3,6,1,9};
		Node  head = new Node(arr[0]);
		Node mover = head;
		
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		System.out.println();
		System.out.print("Eelement deleted at Tail position : ");
		mover =head;
		while(mover.next.next !=null) {
			mover=mover.next;
		}
		mover.next=null;
		mover =head;
		while(mover !=null) {
			System.out.print(mover.data);
			mover=mover.next;
		}
	}
	
	private static void deleteEleementAtKthIndex() {
				
		int[] arr = {2,5,3,6,1,9};
		int k =3;
		Node  head = new Node(arr[0]);
		Node mover = head;
		
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		
		if(head == null) {
			if(k==1) {
				return;
			}
		}
		
		if(k==1) {
			return;
		}
		
		System.out.println();
		System.out.print("Eelement deleted at Kth position : ");
		mover =head;
		int i=2;
		while(i<3) {
			mover=mover.next;
			i++;
		}
		mover.next=mover.next.next;
		mover =head;
		while(mover !=null) {
			System.out.print(mover.data);
			mover=mover.next;
		}
	}
	
	private static void findMiddleByBruteForce() {
		int[] arr = {2,5,3,6,1,9,4,1,2};
		Node  head = new Node(arr[0]);
		Node mover = head;
		
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		
		mover=head;
		int count=0;
		while(mover!=null) {
			count++;
			mover=mover.next;
		}
		
		int mid = (count/2)+1;
		mover=head;
		for(int i=1; i<mid;i++) {
			mover=mover.next;
		}
		System.out.println();
		System.out.println("Middle Element by Brute Force : "+mover.data);
	}
	
	private static void findMiddleByTortoiseAndHareMethod() {
		
		//logic
		//if a person travels  at s speed and other travels at s/2
		//Distance covered by them will be d and d/2
		//take two pointers, and move one by one place and other by 2 places, slow pointer will be middle element
		
		int[] arr = {2,5,3,6,1,9,4};
		Node  head = new Node(arr[0]);
		Node mover = head;
		
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		
		Node slow=head;
		Node fast=head;
		
		while(fast !=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		System.out.println("Middle Element by Tortoise and Hare Method : "+slow.data);
	}
	
	private static void reverseLinkedList() {
		
		int[] arr = {2,5,3,6,1,9,4};
		Node  head = new Node(arr[0]);
		Node mover=head;
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		
		Node current=head;
		Node prev = null;
		
		while(current !=null) {
			Node front = current.next;
			current.next=prev;
			prev=current;
			current=front;
		}
		
		System.out.print("Reversed Linked List : ");
		while(prev!=null) {
			System.out.print(prev.data);
			prev=prev.next;
		}
		System.out.println();
		
	}
	
	private static void recursiveReverseLinkedList() {
		int[] arr = {2,5,3,6,1,9,4};
		Node  head = new Node(arr[0]);
		Node mover=head;
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		
		Node prev = recursiveReverseLinkedListHelper(null, head);
		System.out.print("Reversed Linked List by recurssion : ");
		while(prev!=null) {
			System.out.print(prev.data);
			prev=prev.next;
		}
	}
	
	private static Node recursiveReverseLinkedListHelper(Node prev, Node current) {
		if(current ==null) {
			return prev;
		}else {
			Node front = current.next;
			current.next=prev;
			
			
			return recursiveReverseLinkedListHelper(current, front);
		}
	}
	
	private static void detectLoopInLinkedList() {
		
		//we can use hashing for this as well
		//store nodes in a hashmap and an int as 1 HashMap<Node,int>
		//check if the node is already in the hashmap
		
		int[] arr = {2,5,3,6,1,9,4};
		Node  head = new Node(arr[0]);
		Node mover=head;
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
//		mover.next=head;
		
		Node slow=head;
		Node fast=head;
		System.out.println();
		
		while(fast !=null && fast.next !=null) {
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast) {
				System.out.println("Loop detected");
				return;
			}
		}
		System.out.println("No loop detected");
	}
	
	private static void startingPointInAloop() {
		
		//we can use hashing for this as well
		//store nodes in a hashmap and an int as 1 HashMap<Node,int>
		//check if the node is already in the hashmap, the first repeated will be head
		
		int[] arr = {2,5,3,6,1,9,4};
		Node  head = new Node(arr[0]);
		Node mover=head;
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		mover.next=head;
		
		Node slow=head;
		Node fast=head;
		
		while(fast !=null && fast.next !=null) {
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast) {
				slow=head;
				while(slow!=fast) {
					slow=slow.next;
					fast=fast.next;
				}
				System.out.println("Loop detected, Starting point : "+ slow.data);
				return;
			}
		}
		System.out.println("No loop detected");
	}

	private static void lengthOfLoop() {
		
		//we can use hashing for this as well
		//store nodes in a hashmap and an int denoting numbering 1,2,3,4.....
		//check if the node is already in the hashmap, if it encouters again, subtract it 10-3=7
		
		int[] arr = {2,5,3,6,1,9,4};
		Node  head = new Node(arr[0]);
		Node mover=head;
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		mover.next=head;
		
		Node slow=head;
		Node fast=head;
		int len=1;
		
		while(fast !=null && fast.next !=null) {
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast) {
				fast =fast.next;
				while(slow!=fast) {
					len++;
					fast=fast.next;
				}
				System.out.println("Loop detected, Length : "+len);
				return;
			}
		}
		System.out.println("No loop detected, Length : " + len);
	}
	
	private static void palindromeCheck() {
		
		//use stack to store the elements and then again set the mover to head
		//pop the stack one by one and match with mover
		//stack will be reverse LL and can be used to check if LL is palindrome
		
		int[] arr = {2,5,3,5,2,1};
		Node  head = new Node(arr[0]);
		Node mover=head;
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		
		mover=head;
		Node slow = head;
		Node fast = head;
		
		while(fast.next !=null &&  fast.next.next !=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		
		Node mid=slow;
		slow=slow.next;
		Node prev=null;
		
		while(slow != null) {
			 Node nextNode = slow.next;
		    slow.next = prev;
		    prev = slow;
		    slow = nextNode;  
		}
		Node newHead=prev;
		
		while(newHead !=null) {
			if(mover.data != newHead.data) {
				System.out.println("Not Palindrome");
				return;
			}
			newHead=newHead.next;
			mover=mover.next;
		}
		System.out.println("Palindrome");
	}
	
	private static void segregateOddEvenIndex() {
		int[] arr = {2,5,3,5,2,1,7};
		Node  head = new Node(arr[0]);
		Node mover=head;
		for(int i=1; i <arr.length;i++) {
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover= temp;
		}
		
		if (head == null || head.next == null) return;
		
		Node odd= head;
		Node even = head.next;
		Node newHead = head.next;
		
		while(even !=null && even.next !=null ) {
			
			odd.next=odd.next.next;
			even.next=even.next.next;
			
			odd=odd.next;
			even=even.next;
			
		}
		
		odd.next=newHead;
		mover=head;
		System.out.print("Segregate odd even indices : ");
		while(mover!=null) {
			System.out.print(mover.data);
			mover=mover.next;
		}
		System.out.println();
	}
}