import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class CountDigit {

	public static void main(String[] args) {
		int n = 235404;
		int count=0;
		for(;n>0;n=n/10) count++;
		System.out.println("Count : " + count);
		
		int n1 = 235404;
		int revNum=reverse(n1);
		System.out.println("Reverse : " +revNum);
		
		printDivisors(36);
		
		System.out.println();
		int hcf = gcd(24,36);
		System.out.println("GCD: "+ hcf);
	}
	
	// reverse
	public static int reverse(int n) {
		int num=0;
		for(;n>0;n=n/10) {
			num=num*10+(n%10);
		}
		return num;
	}
	
	public static void printDivisors(int n) {
		//34
		TreeSet<Integer> al = new TreeSet<Integer>();
		for(int i=1; i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				al.add(i);
				al.add(n/i);
			}
			
			}
		System.out.println("Divisors : ");
		for(int k : al) {
			System.out.print(k+ " ");
		}
	}
	
	
	public static int gcd(int n,int m) {
		int num=1;
		
		for(int i = n; i>1;i--) {
			if(n%i==0) {
				if(m%i==0) {
					return i;
				}
			}
		}
		
		return num;
	}
	

}
