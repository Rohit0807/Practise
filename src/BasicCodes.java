import java.util.ArrayList;
import java.util.HashMap;

public class BasicCodes {

	public static void main(String[] args) {
		
		//count the number of digits in a number
		countDigits(3456);
		
		//reverse a number
		reverseNumber(321);
		
		// reverse a String
		reverseString("Rohit");
		
		//largest no. in array
		largestNoInArray();
		
		//second largest number in array
		secondLargestNumberInArray();
		
		//prime number
		primeNumber();
		
		//print all divisors
		printAllDivisors(36);
		
		//factorial
		factorial();
		factorialRecurssion();
		
		//Anagram Check
		anagramCheck();

	}
	
	private static void countDigits(int num) {
		int count=0;
		for(;num>0;) {
			num/=10;
			count++;
		}
		System.out.println(count);
	}
	
	private static void reverseNumber(int num) {
		int revNum=0;
		while(num>0) {
			int rem=num%10;
			revNum=revNum*10+rem;
			num/=10;
		}
		System.out.println(revNum);
	}

	private static void anagramCheck() {
		String str1="Rohit1";
		String str2 = "tohir";
		
		char[] ch1=str1.toLowerCase().toCharArray();
		char[] ch2=str2.toLowerCase().toCharArray();
		
		HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
		for(char c: ch1) {
			hm1.put(c, hm1.getOrDefault(c, 0)+1);
		}
		
		HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();
		for(char c: ch2) {
			hm2.put(c, hm2.getOrDefault(c, 0)+1);
		}
		
		if(hm1.equals(hm2)) {
			System.out.println("Anagram");
		}else {
			System.out.println("Not Anagram");
		}
		
	}

	private static void factorialRecurssion() {
		int n =5;
		int fact = fact(n);
		System.out.println("Factorial by Recurssion : "+fact);
	}
	
	private static int fact(int n) {
		if(n==1) return 1;
		else
		return n*fact(n-1);
	}

	private static void factorial() {
		int n=5;
		int fact=1;
		for(int i = n; i>0;i--) {
			fact=fact*i;
		}
		System.out.println("Factorial : "+fact);
	}

	private static void primeNumber() {
		int n=4;
		
		if (n <= 1) {
			System.out.println("Not Prime");
            return;
        }
		
		for(int i =2; i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				System.out.println("Not Prime");
				return;
			}
		}
		
		System.out.println("Prime");
	}
	
	private static void printAllDivisors(int n) {
		System.out.println("Print All Divisors");
		if (n==0 || n==1) {
			System.out.println(n);
		}else {
			for(int i=1;i<=Math.sqrt(n);i++) {
				if(n%i==0) {
					System.out.println(i);
					if(!(n/i==i)) {
						System.out.println(n/i);
					}
				}
				
			}
		}
	}
	

	private static void secondLargestNumberInArray() {
		int[] num = {34,2,4,45,2,37,45};
		int largest = num[0];
		int secondLargest=0;
		
		for(int i = 1;i<=num.length-1;i++) {
			if(num[i]>largest) {
				secondLargest=largest;
				largest=num[i];
			}else {
				if(num[i]>secondLargest  && num[i] != largest) {
					secondLargest=num[i];
//					System.out.println(num[i]);
				}
			}
		}
		
		System.out.println("Second Largest number in Array : "+secondLargest);
		
		
		
	}

	private static void largestNoInArray() {
		int[] num = {34,2,4,45,2};
		int largest = 0;
		for(int x: num) {
			if(x>largest) largest=x;
		}
		System.out.println("Largest Number in Array : "+largest);
	}

	private static void reverseString(String string) {
		int left=0;
		int right=string.length()-1;
		
//		System.out.println(left +" : " + right);
		
		char[] ch = string.toCharArray();
		
//		System.out.println("char ; " + ch.length);
		while(left<right) {
			
//			System.out.println("Inner : "+left +" : " + right);
			char temp = ch[left];
			ch[left] = ch[right];
			ch[right] = temp;
			
			left++;
			right--;
			
		}
		
		System.out.println(new String(ch));
	}
	
	

}
