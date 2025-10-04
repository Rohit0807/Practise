import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ArrayTest {
	
	public static void main(String[] args) {
		
		//largest element in array
		largestElement();  // sort the arr in timecomplexity NlogN and get the last element
		
		//second largest element in array
		secondLargestElement();
		
		//check if array is sorted
		arraySortedOrNot();
		
		//remove duplicates with ZERO from sorted array
		removeDuplicatesWithZeroFromSortedArray();
		
		//remove duplicates from sorted array
		removeDuplicatesFromSortedArray();
		
		//left roatate array by 1 place , 12345 -> 23451
		leftRotateArrayOnePlace();
		
		//left rotate an array by K places using extra space
		leftRotateArrayK_Place_using_extra_space();
		
		//left rotate an array by K places without using extra space
		leftRotateArrayK_Place_without_using_extra_space();
		
		//move zeroes to end
		zeroToEnd();
		
		//linear Search
		linearSearch();
		
		//Union of two Soretd Arrays
		unionOfTwoSortedArrays();
		
		//Intersection of two Soretd Arrays
		intersectionOfTwoSortedArrays();
		
		//Find the missing number in an array from 0 to n
		findMissingNumber();
		
		// Max Consective ones in an Array
		maxConsecutiveOnes();
		
		//single Occuring Element While Other Occurs Twice  2,2,4,4,3,1,1,6,7,6,7    -> 3 is the single occuring element
		singleOccuringElementWhileOtherOccursTwice();
		
		//longest Subarray
		longestSubarrayWithGivenSumFirstAttemp();
		longestSubarrayWithGivenSumSecondAttemp();
		longestSubarrayWithGivenSumTwoPointerApproach();
		
		
		//add consecutive repetitive element
		addConsecutiveDuplicates();
		addConsecutiveDuplicates2();
		
		//--------------------------------------Medium code starts from here ------------------------------------------------>
	
		//Two Sum Problem  --> i/p : 1,6,2,3,6,4    target: 5,    o/p : 0,5
		twoSumUsingBruteForce();
		twoSumUsingHashing();
		findTwoSum();
		//for optimal approach use two pointers, sort the array and add first and last element and increase/decrease
		//like 2,3,4,5,6 target is 12 2+6=8 increase 3+6=9 again 4+6=10, 5+6=11   Not found
		
		//sorting an array consisting of 0,1 and 2     2,1,0,1,1,1,0,2,0,1,0,2,1
		sortingWithElementsAs012_ThreePointerApproach();
	}
	
	private static void largestElement() {
		int[] arr= {1,3,5,3,4,5,66,65,62,1};
		int max=Integer.MIN_VALUE;
		for(int x:arr) {
			if(x>max) {
				max=x;
			}
		}
		
		System.out.println("Largest element: "+max);
	}
	
	private static void secondLargestElement() {
		int[] arr = {1,3,5,3,4,5,66,65,2,1};
		int max = arr[0];
		int secondMax = Integer.MIN_VALUE;
		for(int x: arr) {
			if(x>max) {
				secondMax=max;
				max=x;
			}else if(x>secondMax && x !=max) {
				secondMax=x;
			}
		}
		System.out.println("Second Largest Element: "+secondMax);
	}
	
	private static void arraySortedOrNot() {
//		int[] arr = {1,3,5,3,4,5,66,65,2,1};
		int[] arr= {1,2,2,3,3,5,7,9,11};
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i+1]>=arr[i]) {
				continue;
			}else {
				System.out.println("Array is not Sorted");
				return;
			}
		}
		System.out.println("Array is Sorted");
	}
	
	private static void removeDuplicatesWithZeroFromSortedArray() {
		int[] arr= {1,2,2,3,3,5,7,9,11};
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i+1]==arr[i]) {
				arr[i]=0;
			}
		}
		System.out.print("After removing duplicates with Zero : ");
		for(int x: arr)
		System.out.print(x);
		System.out.println();
	}
	
	private static void removeDuplicatesFromSortedArray() {
		int[] arr= {1,2,2,3,3,5,7,9,11};
		int j=1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i-1]!=arr[i]) {
				arr[j]=arr[i];
				j++;
			}
		}
		System.out.print("After removing duplicates : ");
		for(int x: arr)
		System.out.print(x+" ");
		System.out.println();
	}
	
	private static void leftRotateArrayOnePlace() {
		int[] arr= {1,2,2,3,3,5,7,9,11};
		int temp= arr[0];
		for(int i=1; i<arr.length;i++) {
			arr[i-1]=arr[i];
		}
		arr[arr.length-1]=temp;
		
		System.out.print("Left Rotate By One place");
		for(int x: arr) System.out.print(x);
		System.out.println();
	}
	
	private static void leftRotateArrayK_Place_using_extra_space() {
		//arr 2,3,1,5,7,2,8,4,9      5,7,2,8,4,9,2,3,1
		//temp of k size
		//move k to n in start of the arrray
		//add all elements from temp to original array k to n
		
		int[] arr = {2,3,1,5,7,2,8,4,9};
		int k=3;
		int n=arr.length;
		
		int[] temp=new int[k];
		for(int i=0; i<k;i++) {
			temp[i]=arr[i];
		}
		
		for(int i=k; i<n;i++) {
			arr[i-k] = arr[i];
		}
		
		for(int i = n-k;i<n;i++) {
			arr[i] = temp[i-(n-k)];
		}
		System.out.print("Left Rotate by "+k+" places : ");
		for(int x: arr) {
			System.out.print(x);
		}
	}
	
	private static void leftRotateArrayK_Place_without_using_extra_space() {
		//arr 2,3,1,5,7,2,8,4,9      5,7,2,8,4,9,2,3,1
		// reverse 231  132
		//reverse 572849  948275
		//array will look like 132 948275
		//reverse the whole array 572849231
		
		int[] arr = {2,3,1,5,7,2,8,4,9};
		int k=3;
		int n=arr.length;
		
		reverseAnArray(arr, 0, k-1);
		reverseAnArray(arr, k, n-1);
		reverseAnArray(arr, 0, n-1);
		System.out.println();
		System.out.print("Left Rotate by "+k+" places Without Extra Space : ");
		for(int x: arr) {
			System.out.print(x);
		}
	}

	private static void reverseAnArray(int[] arr, int i, int k) {
		while(i<k) {
			int temp=arr[i];
			arr[i] = arr[k];
			arr[k]= temp;
			
			i++;
			k--;
		}
		
	}

	private static void zeroToEnd() {
		System.out.println();
		int[] nums= {0,3,00,546,56,0,0,00,0,00,};
		
		int j=0;
		
		for(int i=0; i<nums.length;i++) {
			if(nums[i]!=0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				
				j++;
			}
		}
		System.out.print("Zero To End : ");
		for(int x: nums) {
			System.out.print(x);
		}
		System.out.println();
		
	}
	
	private static void linearSearch() {
		int[] nums= {0,3,00,546,56,0,0,00,0,00,};
		int key = 56;
		
		for(int x: nums) {
			if(x==key) {
				System.out.println("Linear Search Found : " +key);
				return;
			}
		}
		System.out.println("Linear Search Not Found : "+key);
	}
	
	private static void unionOfTwoSortedArrays() {
		int[] arr1= {1,2,4,7,9,11};
		int[] arr2 = {1,2,3,4,8,10,12,13,16};
		
		int i=0;
		int j=0;
		
		int newArraySize = arr1.length + arr2.length;
		
		ArrayList<Integer> arrayList=new ArrayList<>();
		
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]==arr2[j]) {
				arrayList.add(arr1[i]);
				i++;
				j++;
			}
			
			else if(arr1[i]<arr2[j]) {
				arrayList.add(arr1[i]);
				i++;
			}
			
			else if (arr1[i]>arr2[j]) {
				arrayList.add(arr2[j]);
				j++;
			}
		}
		
		while(i<arr1.length) {
			arrayList.add(arr1[i]);
			i++;
		}
		
		while(j<arr2.length) {
			arrayList.add(arr2[j]);
			j++;
		}
		System.out.print("Union of sorted arrays : ");
		arrayList.forEach(e->System.out.print(e+" "));
		System.out.println();
	}
	
	private static void intersectionOfTwoSortedArrays() {
		int[] arr1= {1,2,4,4,7,9,11};
		int[] arr2 = {1,2,3,4,4,8,10,12,13,16};
		
		int i=0;
		int j=0;
		
		int newArraySize = arr1.length + arr2.length;
		
		ArrayList<Integer> arrayList=new ArrayList<>();
		
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i] == arr2[j]) {
				arrayList.add(arr1[i]);
				i++;
				j++;
			}
			
			else if(arr1[i]<arr2[j]) {
				i++;
			}else if(arr1[i]>arr2[j]) {
				j++;
			}
		}
		
		System.out.print("Intersection of two sorted arrays : ");
		arrayList.forEach(e->System.out.print(e+" "));
		System.out.println();
	}
	
	private static void findMissingNumber() {
		int[] arr = {0,2,3,4,5};
		int n=6;
		
		// BRUTE-FORCE APPROACH loop through for each number, time complexity n square
		// Better Approach  -->> Hash each element using Array hashing and check which index is ZERO
		
		//OPTIMAL APPROACH -> Find sum of N natural numbers and sum of elemets in array and then subtract, it will be missing number
		
		int sumOfNNaturalNumber  = (n*(n-1)/2);
		int sum = Arrays.stream(arr).sum();
		
		int diff = sumOfNNaturalNumber- sum;
		
		System.out.println("The Missing Number in an array is : " + diff);
	}
	
	private static void maxConsecutiveOnes() {
		int[] arr = {1,1,0,0,1,1,1,0};
		int maxCount = 0;
		int count = 0;
		
		for(int i=0; i<arr.length;i++) {
			if(arr[i]==1) {
				count++;
				if(count>maxCount) {
					maxCount=count;
				}
			}else {
				count=0;
			}
		}
		System.out.println("Max Consective Ones : " + maxCount);
	}
	
	private static void singleOccuringElementWhileOtherOccursTwice() {
		int[] arr= {1,1,2,3,3,4,4};
		int[] hash=new int[5];
		
		for(int i=0;i<arr.length;i++) {
			hash[arr[i]]++;
		}
		
		for(int i =0; i<hash.length;i++) {
			if (hash[i]==1) {
				System.out.println("Single Occring Eelement : "+ i);
				return;
			}
		}
	}
	
	
	private static void longestSubarrayWithGivenSumFirstAttemp() {
		int[] nums= {0,3,00,546,58,0,00,0,00,2};
		int target =58;
		for(int i=0; i<nums.length;i++) {
			int sum =0;
			for(int j=i;j<nums.length;j++) {
				sum+=nums[j];
				if(sum<=target) {
					
					if(target==sum) {
						
						System.out.println("Longest Subarray with given Sum from "+i+" : "+j);
						return;
					}
					
				}
			}
		}
		System.out.println("Longest Subarray with given Sum Not Found");
	}
	
	private static void longestSubarrayWithGivenSumSecondAttemp() {
		 int[] arr = {1,1,-1,1,0,0,1,1,1,2,2,3,4,1,5,6,7,8};
	        int target =5;
	        int maxCount=0;
	        
	        for(int i=0; i<arr.length;i++){
	            int count = 0;
	            int sum=0;
	            for(int j=i; j<arr.length; j++){
	                sum+=arr[j];
	                count++;
	                if(sum<=target){
	                    
	                    if(sum==target){
	                        if(maxCount<count){
	                            maxCount=count;
	                        }
	                    }
	                }
	            }
	        }
	        System.out.println("Longest Subarray with given Sum : "+maxCount);
	}
	
	private static void longestSubarrayWithGivenSumTwoPointerApproach() {
		 int[] arr = {1,1,-1,1,0,0,4,1,5,6,7,8,3,3,3,2};
	        int target =11;
	        int maxCount=0;
	        
	        //i->n
	        //j->n
	        //sum<target  j++
	        //sum==target len j-i, maxLeng
	        //sum>target sum-arr[i] i++
	        
	        int j=0;
	        int i=0;
	        int sum=0;
	        
	       while(j<arr.length) {
	    	   sum+=arr[j];
	    	   while(sum>target && i<=j) {
	    		   sum-=arr[i];
	    		   i++;
	    	   }
	    	   
	    	   if(sum==target) {
	    		   if(j-i+1>maxCount) {
	    			   maxCount=j-i+1;
	    		   }
	    	   }
	    	   j++;
	    	   
	       }
	       System.out.println("Longest Subarray with given Sum(two pointer approach) : "+maxCount);
	}
	
	private static void addConsecutiveDuplicates() {
		
		int[] arr= {2,2,2,5,7,11,12,12,1};   // output : 6,5,7,11,24,1
		
		ArrayList<Integer> arList = new ArrayList<Integer>();
		int sum=0;
		for(int i = 0; i<arr.length;i++) {
			
			sum+=arr[i];
			if(i+1<arr.length && arr[i] == arr[i+1]) {
				continue;
				
			}else {
				arList.add(sum);
				sum=0;
			}
		}
		System.out.print("Adding consecutive Duplicates : ");
		arList.forEach(n->System.out.print(n));
		System.out.println();
		
	}
	
	private static void addConsecutiveDuplicates2() {
		
		// 1->n
		// j=0
		// sum=arr[0]
		
		int[] arr= {2,2,2,5,7,11,12,12,1};   // output : 6,5,7,11,24,1
		int j=0;
		int sum=arr[0];
		for(int i=1; i<arr.length;i++) {
			if(arr[i-1] == arr[i]) {
				sum+=arr[i];
				arr[j]=sum;
			}else {
				arr[j]=sum;
				sum=arr[i];
				j++;
			}
			//arr[j] = sum;
		}
		
		System.out.print("Adding consecutive Duplicates 2 : ");
		for(int i=0; i<=j;i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		
	}
	
	private static void twoSumUsingBruteForce() {
		int[] arr = {1,1,1,1,1,2,2,3,4,1,5,6,7,8};
        int target =5;
        
        for(int i=0; i<arr.length-1;i++){
            for(int j=i+1; j<arr.length; j++){
                int sum=arr[i]+arr[j];
                if(sum==target){
                    System.out.println("Two Sum indexs from "+i+" and "+j);
                    return;
                }
            }
        }
        System.out.println("Two Sum indexs not found");
	}
	
	private static void twoSumUsingHashing() {
		int[] arr = {1,1,1,1,1,2,2,3,4,1,5,6,7,8};
        int target =5;
        HashMap<Integer, Integer> hs = new HashMap<>();
        
        for(int i=0; i<arr.length;i++){
            int diff = target-arr[i];
            if(hs.containsKey(diff)) {
            	int key1 = hs.get(diff);
            	System.out.println("Two Sum using Hashing indexs from "+key1+" and "+i);
            	return;
            }else {
            	hs.put(arr[i],i);
            }
        }
        System.out.println("Two Sum using Hashing indexs not found");
	}
	
	//for optimal approach use two pointers, sort the array and add first and last element and increase/decrease
	//like 2,3,4,5,6 target is 12 2+6=8 increase 3+6=9 again 4+6=10, 5+6=11   Not found
	
	//print all pairs not only find the pairs
	public static void findTwoSum() {
		int[] nums = {2, 7, 11, 15, -2, 3,6,2,7, 8};
        int target = 9;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("Pair: (" + num + ", " + complement + ")");
            }
            seen.add(num);
        }
    }

	private static void sortingWithElementsAs012_ThreePointerApproach() {
		
		//Easy way : count 0,1 & 2s and run a loop to update values based on count
		
		int[] arr = {2,1,0,1,0,2,0,1,0,2,1};
		int low =0;
		int mid = 0;
		int high =arr.length-1;
		
		while(mid<high) {
			if(arr[mid]==0) {
				swap(arr,low,mid);
				mid++;
				low++;
			}
			else if(arr[mid]==1) {
				mid++;
			}
			else{
				swap(arr,mid,high);
				high--;
			}
		}
		System.out.print("Sorting 0,1 & 2  using 3 pointers approach : ");
		for(int x: arr) {
			System.out.print(x);
		}
	}
	
	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j]= arr[i];
		arr[i]= temp;
	}
}
