
public class Hashing {

	public static void main(String[] args) {

		//Get the frequency of given number in an array
		getFrequency();  //array hashing technique
		
		//get the frequency of characters in an array
		getCharFrequency();
		
		
	}
	
	private static void getFrequency() {
		//given array
		int[] arr = {1,2,3,4,2,3,2,5,4,6};
		
		//given number
		int search = 3;
		
		//pre compute
		int[] hash = new int[10];
		for(int i=0; i<arr.length;i++) {
			hash[arr[i]]++;
		}
		
		//fetch
		System.out.println(hash[search]);
	}
	
	private static void getCharFrequency() {
		//given array
		char[] arr = {'a','b','b','b','c','d'};
		
		//given number
		char search = 'b';
		
		//pre compute
		int[] hash = new int[26];
		for(int i=0; i<arr.length;i++) {
			hash[arr[i]-'a']++;
		}
		
		//fetch
		System.out.println(hash[search-'a']);
	}


}
