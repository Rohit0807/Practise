import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

import utils.Node;

public class StacksAndQueues {
	public static void main(String[] args) {
		// stacks LIFO --> push, pop, top, size
		StackUsingArray sta = new StackUsingArray();
		sta.push(5);
		sta.pop();
		sta.pop();
		sta.pop();
		System.out.println(sta.size());
		System.out.println(sta.top());
		
		sta.pop();
		System.out.println(sta.size());
		
		
		//Queue FIFO --> push, pop, top, size
		QueueUsingArray que = new QueueUsingArray();
		que.push(4);
		System.out.println(que.top());
		que.push(3);
		System.out.println(que.top());
		que.push(2);
//		que.pop();
		System.out.println(que.top());
		que.push(1);
		System.out.println(que.top());
		que.push(7);
		System.out.println(que.top());
		que.push(8);
		System.out.println(que.top());
		
		StackUsingLinkedList stLL = new StackUsingLinkedList();
		stLL.push(5);
		stLL.push(6);
		stLL.push(2);
		stLL.push(3);
		stLL.pop();
		stLL.printStack();
		
		System.out.println("Queue using Linked List");
		QueueUsingLinkedList qll = new QueueUsingLinkedList();
		qll.push(3);
		qll.push(6);
		qll.push(1);
		qll.push(2);
		qll.printStack();
		qll.pop();
		qll.pop();
		qll.printStack();
		
		System.out.println("StackUsingQueue :-");
		StackUsingQueue s = new StackUsingQueue();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.top());  // 30
        s.pop();
        System.out.println(s.top());  // 20
        s.pop();
        System.out.println(s.top());  // 10
        System.out.println(s.size()); // 1
        
        QueueUsingStack queue = new QueueUsingStack();
        System.out.println("Qeue Using Stack : ");
        queue.push(10);
        queue.push(20);
        queue.push(30);
        System.out.println("Top element: " + queue.top());   // Should print 10
        System.out.println("Size: " + queue.size());         // Should print 3
        queue.pop();
        System.out.println("Top element after one pop: " + queue.top());  // Should print 20
        System.out.println("Size after one pop: " + queue.size());        // Should print 2
        queue.pop();
        queue.pop();
        System.out.println("Size after popping all: " + queue.size());    // Should print 0
        queue.pop();  // Should print a message about empty queue
        
        System.out.println("Qeue Using Stack alternate : ");
        QueueUsingStackAlternateApproach qeue = new QueueUsingStackAlternateApproach();
        qeue.push(10);
        qeue.push(20);
        qeue.push(30);
        System.out.println("Top: " + qeue.top()); // 10
        qeue.pop(); // removes 10
        System.out.println("Top after pop: " + qeue.top()); // 20
        System.out.println("Size: " + qeue.size()); // 2
		
        balancedParanthesis();
        infixToPostfix();
        infixToPrefix();
        postfixToInfix();
        prefixToInfix();
        postfixToPrefix();
        prefixToPostfix();
        
	}
	
	private static void balancedParanthesis() {
		String s = "(()";
		Stack<Character> st = new Stack<>();
		for(int i=0; i<s.length();i++) {
			if(s.charAt(i) == '('  || s.charAt(i) == '{' || s.charAt(i) == '[')
				st.push(s.charAt(i));
			else {
				
				 if (st.isEmpty()) {
		                System.out.println("Not Balanced");
		                return;
		            }
				
				Character ch = s.charAt(i);
				Character p = st.pop();
				if((p=='('  && ch == ')') || (p=='{'  && ch == '}') ||(p=='['  && ch == ']')) {
					continue;
				}else {
					System.out.println("Not Balanced");
					return;
				}
			}
		}
		if(st.isEmpty()) {
			System.out.println("Balanced");
		}else {
			System.out.println("Not Balanced");
		}
	}
	
	private static void infixToPostfix() {
		String s = "a+b*(d^e^f-5)^g+h";   // abde^5-*+
		Stack<Character> st = new Stack<>();
		String ans= "";
		
		HashMap<Character, Integer> hs = new HashMap<>();
		hs.put('^',3);
		hs.put('/',2);
		hs.put('*',2);
		hs.put('+',1);
		hs.put('-',1);
				
		for(int i=0; i<s.length();i++) {
			if((s.charAt(i) >='A'  && s.charAt(i) <='Z') ||
					(s.charAt(i) >='a'  && s.charAt(i) <='z') ||
					(s.charAt(i) >='0'  && s.charAt(i) <='9')) {
				ans+=s.charAt(i);
				System.out.println(ans);
			}else if(s.charAt(i) == '(') {
				st.push('(');
			}else if (s.charAt(i) == ')') {
				while(!st.isEmpty() && !(st.peek()=='(')) {
					ans+=st.pop();
				}
				st.pop();
			}else {
				while (!st.isEmpty() && st.peek() != '(' &&
		                (hs.get(s.charAt(i)) <= hs.get(st.peek()))) {
		                ans += st.pop();
		            }
				st.push(s.charAt(i));
			}
		}
		
		while (!st.isEmpty()) {
		    ans += st.pop();
		}
		
		System.out.println(ans);
	}
	
	private static void infixToPrefix(){
		String s = "a+b*(d^e^f-5)^g+h";   // abde^5-*+
		
		StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(')
                reversed.append(')');
            else if (c == ')')
                reversed.append('(');
            else
                reversed.append(c);
        }
        s = reversed.toString();
		
		Stack<Character> st = new Stack<>();
		String ans= "";
		
		HashMap<Character, Integer> hs = new HashMap<>();
		hs.put('^',3);
		hs.put('/',2);
		hs.put('*',2);
		hs.put('+',1);
		hs.put('-',1);
		
		for(int i=0; i<s.length();i++) {
			if((s.charAt(i) >='A'  && s.charAt(i) <='Z') ||
					(s.charAt(i) >='a'  && s.charAt(i) <='z') ||
					(s.charAt(i) >='0'  && s.charAt(i) <='9')) {
				ans+=s.charAt(i);
				System.out.println(ans);
			}else if(s.charAt(i) == '(') {
				st.push('(');
			}else if (s.charAt(i) == ')') {
				while(!st.isEmpty() && !(st.peek()=='(')) {
					ans+=st.pop();
				}
				st.pop();
			}else {
				while (!st.isEmpty() && st.peek() != '(' &&
		                (hs.get(s.charAt(i)) <= hs.get(st.peek()))) {
		                ans += st.pop();
		            }
				st.push(s.charAt(i));
			}
		}
		
		while (!st.isEmpty()) {
		    ans += st.pop();
		}
		
		ans = new StringBuilder(ans).reverse().toString();
		
		System.out.println(ans);
				
	}
	
	private static void postfixToInfix() {
		String s = "abde^f^5-g^*+h+";
		Stack<String> st = new Stack<>();
		
		for (int i=0; i<s.length();i++) {
			Character ch = s.charAt(i);
			if(Character.isLetterOrDigit(ch)) {
				st.push(ch.toString());
			}else {
				String t1 = st.pop();
				String t2 = st.pop();
				st.push("("+t2+ch+t1+")");
			}
		}
		
		System.out.println(st.peek());
	}
	
	private static void prefixToInfix() {
	    String prefix = "+*AB-CD";
	    Stack<String> stack = new Stack<>();

	    for (int i = prefix.length() - 1; i >= 0; i--) {
	        char ch = prefix.charAt(i);
	        
	        if (Character.isLetterOrDigit(ch)) {
	            stack.push(Character.toString(ch));
	        } else {
	            String operand1 = stack.pop();
	            String operand2 = stack.pop();
	            String expr = "(" + operand1 + ch + operand2 + ")";
	            stack.push(expr);
	        }
	    }

	    System.out.println("Infix: " + stack.peek());
	}
	
	private static void postfixToPrefix() {
	    String postfix = "ab+c*";
	    Stack<String> stack = new Stack<>();

	    for (int i = 0; i < postfix.length(); i++) {
	        char ch = postfix.charAt(i);

	        if (Character.isLetterOrDigit(ch)) {
	            stack.push(Character.toString(ch));
	        } else {
	            String op2 = stack.pop();
	            String op1 = stack.pop();
	            String expr = ch + op1 + op2;
	            stack.push(expr);
	        }
	    }

	    System.out.println("Prefix: " + stack.peek());
	}
	
	private static void prefixToPostfix() {
	    String prefix = "*+abc";
	    Stack<String> stack = new Stack<>();

	    for (int i = prefix.length() - 1; i >= 0; i--) {
	        char ch = prefix.charAt(i);

	        if (Character.isLetterOrDigit(ch)) {
	            stack.push(Character.toString(ch));
	        } else {
	            String op1 = stack.pop();
	            String op2 = stack.pop();
	            String expr = op1 + op2 + ch;
	            stack.push(expr);
	        }
	    }

	    System.out.println("Postfix: " + stack.peek());
	}


	

}

class StackUsingArray{
	int[] arr = new int[4];
	int top=-1;
	public void push(int element) {
		if(top<arr.length-1) {
			top+=1;
			arr[top]=element;
		}
	}
	
	public void pop() {
		if(top>-1) {
			top-=1;
		}
	}
	
	public int size() {
		return top+1;
	}
	
	public int top() {
		if(top>-1) {
			return arr[top];
		}
		return -1;
	}
}

class QueueUsingArray{
	int[] arr = new int[4];   // 2 3 1 3
	int start=-1;
	int end =-1;
	int currSize=0;
	int size=4;
	
	//1. currSize==0; 2. curr>0,<size; 3. else no space
	public void push(int element) {
		if(currSize==0) {
			start= (start+1)%size;
			end=(end+1)%size;
			arr[start]=element;
			currSize++;
		}else if(currSize>0 && currSize<size) {
			end=(end+1)%size;
			arr[end]=element;
			currSize++;
		}else {
			System.out.println("No Space in Queue to push element");
		}
	}
	
	
	// 1. if curr==0; curr==1; 
	public void pop() {
		if(currSize==0) {
			System.out.println("Nothing to delete in queue");
		}else if(currSize==1){
			start=-1;
			end=-1;
			currSize--;
		}else {
			start= (start+1)%size;
			currSize--;
		}
	}
	
	public int size() {
		return currSize;
	}
	
	public int top() {
		if(start>-1) {
			return arr[start];
		}
		return -1;
	}
}


class StackUsingLinkedList{
	// create a node   1 2 3
	Node top =null;
	int size=0;
	
	public void push(int element) {
		Node temp = new Node(element);
		temp.next=top;
		top = temp;
		size++;
	}
	
	public void pop() {
		if(top==null) return;
		top = top.next;
		size--;
	}
	public int top() {
		if(top!=null)
		return top.data;
		
		return -1;
	}
	
	
	public int size() {
		return size;
	}
	
	public void printStack() {
		if(top==null) {
			System.out.println("No Element in LL");
			return;
		}else {
			while(top!=null) {
				System.out.println(top.data);
				top=top.next;
			}
		}
	}
}

class QueueUsingLinkedList{
	// create a node   1 2 3
	Node start =null;
	Node end =null;
	int size=0;
	
	public void push(int element) {
		Node temp = new Node(element);
		if(size==0) {
			start=temp;
			end=temp;
			
		}else if(size==1) {
			start.next=temp;
			end.next=temp;
			end=temp;
		}else {
			end.next=temp;
			end=temp;
		}
		size++;
	}
	
	public void pop() {
		if(start==null) return;
		start = start.next;
		size--;
	}
	public int top() {
		if(start!=null)
		return start.data;
		
		return -1;
	}
	
	
	public int size() {
		return size;
	}
	
	public void printStack() {
		Node mover =start;
		if(mover==null) {
			System.out.println("No Element in LL");
			return;
		}else {
			while(mover!=null) {
				System.out.println(mover.data);
				mover=mover.next;
			}
		}
	}
}

class StackUsingQueue{
	Queue<Integer> q= new ArrayDeque<>();
	public void push(int element) {
		q.offer(element);
		int n = q.size();
	    for (int i = 0; i < n - 1; i++) {
	        q.offer(q.poll());
	    }
	}
	
	public void pop() {
		q.poll();
	}
	
	public int top() {
		return q.peek();
	}
	
	public int size() {
		return q.size();
	}
}

class QueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int element) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(element);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public void pop() {
        if (!s1.isEmpty()) {
            s1.pop();
        }
    }

    public int top() {
        if (!s1.isEmpty()) {
            return s1.peek();
        }
        throw new RuntimeException("Queue is empty");
    }

    public int size() {
        return s1.size();
    }
}

class QueueUsingStackAlternateApproach {
	Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    public void push(int element) {
    	s1.push(element);
    }
    
    public void pop() {
    	if(s2.isEmpty()) {
    		while(!s1.isEmpty()) {
    			s2.push(s1.peek());
    			s1.pop();
    		}
    	}
    	 if (!s2.isEmpty()) {
             s2.pop();
         } else {
             System.out.println("Queue is empty. Cannot pop.");
         }
    }
    
    public int top() {
    	if(s2.isEmpty()) {
    		while(!s1.isEmpty()) {
    			s2.push(s1.peek());
    			s1.pop();
    		}
    	}
    	 if (!s2.isEmpty()) {
             return s2.peek();
         } else {
             System.out.println("Queue is empty.");
             return -1;  // or throw an exception
         }
    }

    public int size() {
    	return s1.size()+s2.size();
    }
}
