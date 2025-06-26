import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiPractise {

	public static void main(String[] args) {
		
		longestString();
		
		//odd even  Separately
		List<Integer> ls = Arrays.asList(1,4,6,2,7,34,56,37,47,23,46);
		ls.stream().filter(n -> n%2==1).forEach(n->System.out.println(n));
		
		//no. of even numbers
		Long count = ls.stream().filter(n->n%2==0).count();
		System.out.println("Count : "+count);
		
		//sum of squares of of even numbers
		Integer count1 = ls.stream().filter(n->n%2==0).map(n->n*n).reduce(0,Integer::sum);
		System.out.println("Count : "+count1);
		
		//max in list
		Optional<Integer> opMax = ls.stream().max(Integer::compareTo);
		opMax.ifPresent(System.out::println);
		
		//min in list
		Optional<Integer> opMin = ls.stream().min(Integer::compareTo);
		opMin.ifPresent(System.out::println);
		
		//remove duplicates in String
		List<String> lsS= Arrays.asList("asd","lj","asd","yu");
		Stream<String> st = lsS.stream().distinct();
		st.forEach(System.out::println);
		
		//joining Strings
		String sCon = lsS.stream().collect(Collectors.joining());
		System.out.println(sCon);
		
		//group string based on length
		Map<Integer, List<String>> collect = lsS.stream().collect(Collectors.groupingBy(String::length));
		collect.forEach((k,v)->System.out.println(k +" ::: " + v));
		
		//Map List of Strings to Their Length
		lsS.stream().
			map(s-> s +" : " + s.length()).forEach(System.out::println);
		
		
		//odd even in single stream
		 Map<Boolean, List<Integer>> oddEvenMap = ls.stream()
	                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
		 System.out.println("Even Numbers: " + oddEvenMap.get(true));
	        System.out.println("Odd Numbers: " + oddEvenMap.get(false));
	        
	        
	        //find first element 
	        ls.stream()
            .findFirst()
            .ifPresent(System.out::println);

	        
	     // first repeated character in String
	        String rep = "Java is Awesome";
	        IntStream repChar = rep.chars();
	        HashSet<Character> repHS = new HashSet<Character>();
	        Optional<Character> ch = repChar.mapToObj(n->(char)(n))  //  convert int to char
	        		.filter(n-> !repHS.add(n)).findFirst();			// first not added char to set
	        if(ch.isPresent()) {
	        	System.out.println(ch.get());
	        }
	        
	        
	        List<Integer> primeCheckList = Arrays.asList(4,2,4,5,7,1,11,14);
	        primeCheckList.stream().filter(n->isPrime(n))
	        .forEach(System.out::println);
	        
	        
	        List<Student> lsStud=Arrays.asList(
	        		new Student("A",12,34),
	        		new Student("D",14,56),
	        		new Student("C",13,90),
	        		new Student("B",17,45)
	        		);
	        
	        List<Student> lsStudBelow50Grade = lsStud.stream().filter(n->n.getGrade()<50).collect(Collectors.toList());
	        lsStudBelow50Grade.forEach(System.out::println);
	        
	        lsStud.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);;
	    }
	    
	 
	

public static boolean isPrime(int n){
    if(n==1 || n==0) return false;
    else if(n==2) return true;
    else{
        for(int i=2;i<=n/2;i++){
            if(n%i==0) return false;
            
        } return true;
    }

}

//count set bits in binary.
	public static void countNoOfOnes(Long l) {
		Long count = Long.toBinaryString(l).chars().filter(n->n=='1').count();
		System.out.println(count);
	}
	
	private static void longestString() {
		List<String> ls = Arrays.asList("Ram","Shyam","as","dfsdafdaf");
		Optional<String> str  = ls.stream().max(String::compareTo);
		if(str.isPresent()) {
			String s = str.get();
			System.out.println(s);
		}
		
	}
	
	private static void findMax(int[] arr) {
		OptionalInt max = Arrays.stream(arr).max();
		System.out.println(max);	
	}
	
	private static void findMax2(Integer[] arr) {
		Optional<Integer> max = Arrays.asList(arr).stream().max(Integer::compareTo);
		System.out.println(max.get());	
	}
	
	private static void personObjectAvgAge() {
		List<Person> persons = Arrays.asList(
			    new Person("Alice", 25),
			    new Person("Bob", 30),
			    new Person("Charlie", 35)
			);
			double averageAge = persons.stream()
			                          .mapToInt(Person::getAge)
			                          .average()
			                          .orElse(0);
	}
	
	private static void concat2list() {
		List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
		List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
		List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream())
		                                .sorted()
		                                .collect(Collectors.toList());
	}
	
	private static void intersectionOf2list() {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
		List<Integer> intersection = list1.stream()
		                                  .filter(list2::contains)
		                                  .collect(Collectors.toList());
	}
	
	private static void removeDuplicates() {
		List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
		List<Integer> uniqueNumbers = numbersWithDuplicates
		                                       .stream()
		                                       .distinct()
		                                       .collect(Collectors.toList());
	}
	private static void name() {
		List<Transaction> transactions = Arrays.asList(
			    new Transaction("2022-01-01", 100),
			    new Transaction("2022-01-01", 200),
			    new Transaction("2022-01-02", 300),
			    new Transaction("2022-01-02", 400),
			    new Transaction("2022-01-03", 500)
			);

			Map<String, Integer> sumByDay = transactions
			                        .stream()
			                        .collect(Collectors.groupingBy(Transaction::getDate,
			                               Collectors.summingInt(Transaction::getAmount)));
	}
	private static void frequencyOfEachWord() {
		List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", 
                "banana", "apple");
Map<String, Long> wordFrequency = words
.stream()
.collect(Collectors
.groupingBy(Function.identity(), Collectors.counting())
);
	}
}

class Transaction{
	String date;
	int amount;
	public Transaction(String date, int amount) {
		super();
		this.date = date;
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}

class Person{
	String name;
	int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

class Student{
	String name;
	int age;
	int grade;
	
	
	public Student(String name, int age, int grade) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade + "]";
	}
	
	//Collections.sort(lsStud);
//    @Override
//    public int compareTo(Student other) {
//        // Compare by age
//        return Integer.compare(this.age, other.age);
//    }
}

//Collections.sort(lsStud, new NameComparator());
class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
