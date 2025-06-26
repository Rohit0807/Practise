
public class PatternPrinting {

	public static void main(String[] args) {
		
		for(int i =0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------------------------------");
		
		for(int i=1;i<=5;i++) {
			for(int j=5-i+1;j>=1;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------------------------------");
		
		for(int i=0;i<5;i++) {
			for(int j=5-i;j>=1;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------------------------------");
		
		for(int i=0; i<5;i++) {
			for(int j='A';j<='A'+i;j++) {
				System.out.print((char)j);
			}
			System.out.println();
		}

	}

}
