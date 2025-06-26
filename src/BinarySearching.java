
public class BinarySearching {
	
	public static void main(String[] args) {
		binarySearch();
		
		int[] arr = {10,11,12,13,14,15,17,18,19};
		int target = 17;
		
		int low = 0;
		int high = arr.length-1;
		binarySearchRecurssion(arr, target, low, high);
		
		lowerBound();
		upperBound();
		
	}
		
	private static void binarySearch() {
		int[] arr = {10,11,12,13,14,15,17,18,19};
		int target = 17;
		
		int low = 0;
		int high = arr.length-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[mid]==target) {
				System.out.println("Binary Search : Element found at index : "+mid);
				return;
			}else if(target>arr[mid]) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
	}
	
	// case of overflow if low & high are very big numbers
	//low+high/2  --> low + high will not hold in int or long
	// so for mid use low + (high-low)/2
	//subtracting low from high will solve data hold/overflow problem 
	
	
	private static void binarySearchRecurssion(int[] arr,int target, int low, int high) {
		int mid=(low+high)/2;
		if(high<low) {
			return;
		}else if(arr[mid] == target) {
			System.out.println("Recurssive Binary Search : Element found at index : "+mid);
			return;
		}else {
			
			if(arr[mid]>target) {
				high=mid-1;
			}else {
				low=mid+1;
			}
			
			binarySearchRecurssion(arr, target, low, high);
		}
	}
	
	private static void lowerBound() {
		
		int[] arr = {10,11,12,13,14,15,17,18,19};
		int target = 20;
		
		int low = 0;
		int high = arr.length-1;
		int index = arr.length-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(target<=arr[mid]) {
				index=mid;
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		
		System.out.println("Lower Bound found at index : "+index);
	}
	
private static void upperBound() {
		
		int[] arr = {10,11,12,13,14,15,17,18,19};
		int target = 15;
		
		int low = 0;
		int high = arr.length;
		int index = arr.length-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(target<arr[mid]) {
				index=mid;
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		
		System.out.println("Upper Bound found at index : "+index);
	}
	


}
