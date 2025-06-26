import java.util.ArrayList;

public class SortingPractice {

	public static void main(String[] args) {
		
		int[] arr = {1,5,2,9,4,8,2};
		System.out.print("Before Sort: ");
		for(int k: arr)
		System.out.print(k);
		System.out.println();
		
		selectionSort(arr);
		
		int[] arr2 = {1,5,2,9,4,8,2};
		bubbleSort(arr2);
		
		int[] arr3 = {1,5,2,9,4,8,2};
		insertionSort(arr3);
		
		int[] arr4 = {1,5,2,9,4,8,2};
		mergeSort(arr4);
		
		int[] arr5 = {1,5,2,9,4,8,2};
		System.out.println();
		System.out.print("Quick Sort : ");
		quickSort(arr5,0,arr5.length-1);
		for(int x: arr5) {
			System.out.print(x);
		}
	}

	private static void quickSort(int[] arr,int low,int high) {
		if(low>=high)return;
		int partition = quickSortLogic(arr, low,high);
		quickSort(arr, low, partition-1);
		quickSort(arr, partition+1, high);
	}

	private static int quickSortLogic(int[] arr, int low, int high) {
		int pivot=arr[low];
		int i=low+1;
		int j=high;
		while(i<j) {
			while(arr[i]<=pivot && i<high) i++;
			while(arr[j]>pivot && j>low) j--;
			if(i<j) swap(arr, i, j);
			
		}
		swap(arr, j, low);
		return j;
		
	}

	private static void mergeSort(int[] arr) {
		int start=0;
		int end = arr.length-1;
		int mid=(start+end)/2;
		merge(arr,start,mid);
		merge(arr,mid+1,end);
		mergeAgain(arr,start,mid,end);
		
		System.out.println();
		System.out.print("Merge Sort: ");
		for(int k: arr)
		System.out.print(k);
		
	}

	private static void mergeAgain(int[] arr, int l, int mid, int r) {
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
        int left=l;
        int right=mid+1;
        while(left<=mid && right<=r){
            if(arr[left]<=arr[right]){
                arrayList.add(arr[left]);
                left++;
            }else{
                arrayList.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            arrayList.add(arr[left]);
                left++;
        }
        while(right<=r){
            arrayList.add(arr[right]);
                right++;
        }
        for(int i=l; i<=r;i++){
            arr[i]=arrayList.get(i-l);
        }

	}

	private static void merge(int[] arr, int start1, int end1) {
		if(start1>=end1) {
			return;
		}else {
			int mid=(start1+end1)/2;
			merge(arr,start1,mid);
			merge(arr,mid+1,end1);
			mergeAgain(arr,start1,mid,end1);
		}
	}

	private static void insertionSort(int[] arr) {
		for(int i=1; i<arr.length;i++) {
			for(int j=i; j>0 && arr[j]<arr[j-1]; j--) {  //2->1   3->2->1   4->3->2->1
				swap(arr,j,j-1);
			}
		}
		System.out.println();
		System.out.print("Insertion Sort: ");
		for(int k: arr)
		System.out.print(k);
	}

	private static void bubbleSort(int[] arr) {
		for(int i = arr.length-1; i>0;i--) {
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) swap(arr,j,j+1);
			}
		}
		System.out.println();
		System.out.print("Bubble Sort: ");
		for(int k: arr)
		System.out.print(k);
	}

	private static void selectionSort(int[] arr) {
		for(int i=0; i<=arr.length-2;i++) {
			for(int j=i+1;j<=arr.length-1;j++) {
				if(arr[j]<arr[i]) swap(arr,j,i);
			}
		}
		System.out.print("Selecction Sort: ");
		for(int k: arr)
		System.out.print(k);
	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j]= arr[i];
		arr[i]= temp;
		
	}
}
