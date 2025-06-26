import java.io.Serializable;

public class RecurssionTest {

	public static void main(String[] args) {
		
		//print 1 to 10
		printNTimeAscending(10);
		
		//print 10 to 1
		printNTimeDescending(10);
		
		//sum of n numbers
		System.out.println();
		System.out.println("Sum of n numbers : "+sumOfN_Numbers(1)); 
		
		//factorial
		System.out.println("Factorial : "+factorial(2));
		
		//reverse an array
		 int[] arr = {1,2,3,4,5,6};
	     reverseArray(arr, 0,5);
	        for(int x: arr){
	            System.out.print(x);
	        }
	        System.out.println();
		
		//fibonacci series
		fibonacciSeries(10);
		
		//string is palindrome or not
		System.out.println();
		System.out.println("Palindrome : " + palindromeCheck("abba"));
		
		//string permutation
		permutationOfString("ABC");
		
		
		
	}

	private static void printNTimeAscending(int n){
		
		if(n==0) {
			return;
		}else {
			printNTimeAscending(n-1);
			System.out.print(n+" ");
		}
		
	}
	
	private static void printNTimeDescending(int n){
		System.out.println();
		if(n==0) {
			return;
		}else {
			System.out.print(n+" ");
			printNTimeAscending(n-1);
		}
		
	}
	
	private static int sumOfN_Numbers(int i) {
		if(i==0) {
			return 0;
		}else {
			return i+sumOfN_Numbers(i-1);
		}
	}
	
	private static int factorial(int i) {
		if(i==0) return 1;
		else
		return i * factorial(i-1);
	}
	
	private static void reverseArray(int[] num,int i, int j){
	    if(i>=j) return;
	    else {
	    	reverseArray(num,i+1,j-1);
	        int temp=num[i];
	        num[i]=num[j];
	        num[j]=temp;
	        
	    }
	}
	
	private static void fibonacciSeries(int n) {
		System.out.print("FIbonacci Series : ");
		fibonacciSeriesHelper(n,0,1);
	}

	private static void fibonacciSeriesHelper(int n, int i, int j) {
			if(n==0) {
				return;
			}else {
				System.out.print(i+" ");
				fibonacciSeriesHelper(n-1, j, i+j);
			}
	}
	
	private static boolean palindromeCheck(String string) {
		  boolean b = palindromeCheckHelper(string, 0, string.length()-1);
		  return b;
	}

	private static boolean palindromeCheckHelper(String string, int i, int j) {
		if(i<j) {
			if(string.charAt(i)!=string.charAt(j)) {
				return false;
			}else {
				return palindromeCheckHelper(string, i+1, j-1);
			}
		}else {
			return true;
		}
	}
	
	private static void permutationOfString(String string) {
		permutationOfStringHelper(string,0, string.length()-1);
	}

	private static void permutationOfStringHelper(String string, int left, int right) {
		if(left==right) {
			System.out.println("Final String to print : "+left+": "+right+" : "+string);
		}else {
			for(int k = left;k<=right;k++) {
				string  = swap(string, left,k);
				permutationOfStringHelper(string, left+1, right);
				string  = swap(string, left,k);
			
			}
		}
	}

	private static String swap(String string, int i, int k) {
		char[] ch  = string.toCharArray();
		char temp = ch[i];
		ch[i]=ch[k];
		ch[k]=temp;
		
		return new String(ch);
	}
	
	
	
	
}
