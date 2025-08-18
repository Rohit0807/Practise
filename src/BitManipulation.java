import java.util.ArrayList;
import java.util.List;

public class BitManipulation {
	
	public static void main(String[] args) {
		swapTwoNumbers();
		decimal2Binary();
		binary2decimal();
		
		// right shift divides the number by 2 to power k, means right shift 1, will divide by 2, >>2 will divide by 4 and so on
		rightLeftShiftTest(); //divides by 2 raised to power 2, >>3, will divide by 8
		
		//computer stores negation in 2's complement, flips all the bits, if negative converts to 2's complement or else stops
		// 24 will be 0000.....11000
		//flips  1111.....00111
		// last bit is 1 so thats neagtive, will do 2's complement, flip and add 1, leave the last bit
		// 1000.....11000  now add 1
		//1000.....11001  so that -25
		
		iTHbitIsSetOrNot();
		setIthBit();
		clearIthBit();
		toggleIthBit();
		removeLastSetBit();
		numberIsPowerOf2OrNot();
		countNoOfSetBits();
		
		checkforOddEven();
		noOfBitsToFlipForConvertingToDifferentNumber();
		powerSet();
		singleNumberInArray();
	}
	
	private static void swapTwoNumbers() {
		int a=5;
		int b=4;
		
		a=a^b;
		b=a^b;
		a=a^b;
		
		System.out.println("Numbers after swap : "+a +" : "+b);
	}
	
	private static void decimal2Binary() {
		int a=16;
		String bin="";
		
		//10001
		
		while(a>0) {
			if(a%2==1) {
				bin=1+bin;
			}else {
				bin=0+bin;
			}
			
			a/=2;
		}
		System.out.println("Binary of decimal : "+bin);
	}
	
	private static void binary2decimal() {
		String bin = "11001";
		int res=0;
		int mul=1;
		for(int i=bin.length()-1; i>=0 ; i--) {
			res=res+((bin.charAt(i)-'0')*mul);
			mul*=2;
		}
		System.out.println("Decimal conversion : "+ res);
	}
	
	private static void rightLeftShiftTest() {
		// right shift divides the number by 2 to power k, menas right shift 1, will divide by 2, >>2 will divide by 4 and so on
		int num = 24;
		System.out.println("Right shift divides by 2 : "+ (num>>1));
		System.out.println("Left shift multiplies by 2 : "+(num<<1));
		
		//computer stores negation in 2's complement, flips all the bits, if negative converts to 2's complement or else stops
		// 24 will be 0000.....11000
		//flips  1111.....00111
		// last bit is 1 so thats neagtive, will do 2's complement, flip and add 1, leave the last bit
		// 1000.....11000  now add 1
		//1000.....11001  so that -25
		System.out.println("Negation of a number : "+(~num));
	}
	
	private static void iTHbitIsSetOrNot() {
		int num = 13;
		int k=1;
		
		//1101  0100  num ^ 1<<k
		
		//using left shift operator
		if((num & (1<<k))!=0) System.out.println("Ith Bit is set or not using Left Shift Operator : Set");
		else System.out.println("Ith Bit is set or not using Left Shift Operator : Not Set");
		
		//using right shift operator
		if(((num>>k) & 1)!=0) System.out.println("Ith Bit is set or not using Right Shift Operator : Set");
		else System.out.println("Ith Bit is set or not using Right Shift Operator : Not Set");
	}
	
	private static void setIthBit() {
		int num=13;
		int k=1;
		
		//1101  0010  simple OR operation will let the remaining bits same and set the ith bit to 1.
		num = (num | (1<<k));
		System.out.println("Set the Ith Bit : "+num);
	}
	
	private static void clearIthBit() {
		int num=13;
		int k=2;
		
		//1101  1011  AND operation will let the remaining bits same and set the ith bit to 0.
		num = (num & ~(1<<k));
		System.out.println("Clear the Ith Bit : "+num);
	}
	
	private static void toggleIthBit() {
		int num=13;
		int k=1;
		
		//1101  1011  XOR operation will let the remaining bits same and set the ith bit to toggle.
		num = (num ^ (1<<k));
		System.out.println("Toggle the Ith Bit : "+num);
	}
	
	private static void removeLastSetBit() {
		int num=13;
		
		//1101(13)  1100(12)   in n and n-1 before last rightmost set bit everything is same, so do a AND operation
		num = (num & num-1);
		System.out.println("Remove the last Ith Bit : "+num);
	}
	
	private static void numberIsPowerOf2OrNot() {
		int num=32;
		
		//the power numbers 2,4,8,16,... will have only one set bit. and num-1 will have 0 on set bit and remaining 1s
		if((num & num-1) ==0)
		System.out.println(num+ " is a power of 2");
		else System.out.println(num+ " is not a power of 2");
	}
	
	private static void countNoOfSetBits() {
		int num=13;
		int count=0;
		
		//the power numbers 2,4,8,16,... will have only one set bit. and num-1 will have 0 on set bit and remaining 1s
		while(num>0) {
			num=num&(num-1);
			count++;
		}
		System.out.println("Number of set bits : "+count);
	}
	
	private static void checkforOddEven() {
		int num=6;
		if((num&1)==1) System.out.println("Number is odd");
		else System.out.println("Number is even");
	}
	
	private static void noOfBitsToFlipForConvertingToDifferentNumber() {
		int num = 10; // 1010
		int goal = 7; // 0111
		int count=0;
		int newVal = num^goal;
		while(newVal>0) {
			newVal=newVal&(newVal-1);
			count++;
		}
		
		System.out.println("No. of bits to flip for new Number : "+count);
	}
	
	private static void powerSet() {
		int[] arr = {1,2,3};
		List<List<Integer>> powerSet = new ArrayList<>();
		
		//Logic:
		//find no. of elements in power set 2 to the power number of elements, so 2 to power 3 means 8
		// run a loop for 8 times, just like binary representation 000,001,010,100, etc. and take the set bits in power set
		
		int noOfPowerSet = 1<<arr.length;
		
		for(int i=0; i<noOfPowerSet;i++) {  // need to get 8 power sets
			List<Integer> temp =new ArrayList<>();
			for(int k=0;k<arr.length;k++) {   //checking for set bits in 3 bit binary values  001,000,010,100, etc.
				if((i&(1<<k))!=0) {
					//1101
					//0100
					temp.add(arr[k]);
				}
			}
			powerSet.add(temp);
		}
		System.out.print("Power Set: ");
		powerSet.forEach(System.out::print);
	}
	
	private static void singleNumberInArray() {
		int[] arr= {1,4,2,1,2,3,3};
		int XOR= 0;
		for(int x: arr) {
			XOR = XOR ^ x;
		}
		System.out.println();
		System.out.println("Single Number in Array : "+ XOR);
	}
}
