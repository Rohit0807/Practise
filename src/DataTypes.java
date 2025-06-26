import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class DataTypes {

	public static void main(String[] args) {
		int a = 3, b=4;
		swap(a,b);
		
		Long l =00111001100011000101L;
		countNoOfOnes(l);
		
		int[] arr = {3,5,1,45,5,8,6,6};
		findMax(arr);
		
		Integer[] arr2 = {3,5,1,45,5,8,6,6};
		findMax2(arr2);
		
		doubleFloatFormat();
	}
	
	private static void doubleFloatFormat() {
		double d = 123.456789;
		float f = 123.456f;

		String doubleFormatted = String.format("%.2f", d);
		String floatFormatted = String.format("%.2f", f);

		System.out.println("Double (String.format): " + doubleFormatted); // 123.46
		System.out.println("Float (String.format): " + floatFormatted);   // 123.46
		
		DecimalFormat df = new DecimalFormat("#.00");

		System.out.println("Double (DecimalFormat): " + df.format(d)); // 123.46
		System.out.println("Float (DecimalFormat): " + df.format(f));  // 123.46
	}
	
	private static void findMax(int[] arr) {
		OptionalInt max = Arrays.stream(arr).max();
		System.out.println(max);	
	}
	
	private static void findMax2(Integer[] arr) {
		Optional<Integer> max = Arrays.asList(arr).stream().max(Integer::compareTo);
		System.out.println(max.get());	
	}
	
	//swap 2 numbers without using temp variable
	public static void swap(int a, int b) {
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a +" :" +b);
	}
	
	//count set bits in binary.
	public static void countNoOfOnes(Long l) {
		Long count = Long.toBinaryString(l).chars().filter(n->n=='1').count();
		System.out.println(count);

	}

}
