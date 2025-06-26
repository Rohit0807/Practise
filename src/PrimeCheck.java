
public class PrimeCheck {

	public static void main(String[] args) {
		
		
		// implemented with 3 methods brute force, optimized brute force, square root method
		
		
		int n=12;
		boolean primeOrNot = isPrime0(n);
		
		if(primeOrNot) System.out.println("Prime");
		else System.out.println("Not Prime");
		
		
		
	}
	
public static boolean isPrime0(int n) {
		
		if (n <= 1) {
            return false;
        }
		
		for(int i = 2; i<=Math.sqrt(n); i++) {
			if(n%i==0) return false;
		}
		
		return true;
	}
	
	public static boolean isPrime(int n) {
		
		if (n <= 1) {
            return false;
        }
		
		for(int i = 2; i<n; i++) {
			if(n%i==0) return false;
		}
		
		return true;
	}
	
public static boolean isPrime2(int n) {
		
		if (n <= 1) {
            return false;
        }
		
		for(int i = 2; i<=n/2; i++) {
			if(n%i==0) return false;
		}
		
		return true;
	}

}
