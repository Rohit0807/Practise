
public class PatternPrinting {

	public static void main(String[] args) {
		
		
		//	*****
		//	*****
		//	*****
		//	*****
		//	*****
		for(int i =0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------------------------------");
		
		
		//	*
		//	**
		//	***
		//	****
		//	*****
		for(int i=0;i<5;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------------------------------");
		
			//	1
			//	12
			//	123
			//	1234
			//	12345
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		System.out.println("------------------------------");
		
				//	1
				//	22
				//	333
				//	4444
				//	55555
			for(int i=1;i<=5;i++) {
				for(int j=1;j<=i;j++) {
					System.out.print(i);
				}
				System.out.println();
			}
			
			System.out.println("------------------------------");
			
		//	*****
		//	****
		//	***
		//	**
		//	*	
		for(int i=1;i<=5;i++) {
			for(int j=5-i+1;j>=1;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------------------------------");
		
		
		//	*****
		//	****
		//	***
		//	**
		//	*	
		for(int i=0;i<5;i++) {
			for(int j=5-i;j>=1;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------------------------------");
		
			//	    *
			//	   ***
			//	  *****
			//	 *******
			//	*********
			for(int i=0;i<5;i++) {
				for(int j =0; j<5-i-1; j++) {
					System.out.print(" ");
				}
				for(int j=0;j< 2*i+1;j++){
		            
		            System.out.print("*");
		        }
				System.out.println();
			}
			
			System.out.println("------------------------------");
		
		
		//	A
		//	AB
		//	ABC
		//	ABCD
		//	ABCDE
		for(int i=0; i<5;i++) {
			for(int j='A';j<='A'+i;j++) {
				System.out.print((char)j);
			}
			System.out.println();
		}

	}

}
