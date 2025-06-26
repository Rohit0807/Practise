import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("Enter");
		
		String s = "RohitKumar";
		Optional<Character> ch = s.chars()
		.mapToObj(c->(char)c)
		.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
		.entrySet()
		.stream()
		.filter(entry->entry.getValue()==1)
		.map(Map.Entry::getKey)
		.skip(2)
		.findFirst();
		
		
		if(ch.isPresent()) {
			System.out.println(ch.get());
		}else {
			System.out.println("not");
		}
		
		Optional<Character> thirdNonRepeatingChar = s.chars()  // Stream of chars
		        .mapToObj(c -> (char) c)  // Convert to Character stream
		        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Count occurrences
		        .entrySet().stream()  // Stream of Map entries
		        .filter(entry -> entry.getValue() == 1) // Filter non-repeating characters
		        .map(Map.Entry::getKey)  // Get the characters
		        .peek(c -> System.out.println("Non-repeating char: " + c))  // Debug: log non-repeating characters
		        .skip(2)  // Skip the first 2 non-repeating characters
		        .findFirst();  // Get the 3rd one, if it exists

		thirdNonRepeatingChar.ifPresent(
			    System.out::println
			);

			// Fallback for the else case
			if (!thirdNonRepeatingChar.isPresent()) {
			    System.out.println("No third non-repeating character");
			}
			
			List<String> ls = new ArrayList<String>();
			ls.add("Ram");
			ls.add("Shyam");
			ls.add("Charlie");
			
			Optional<String> str = ls.stream().max(String::compareTo);
			if(str.isPresent()) {
				System.out.println(str.get());
			}
			
			Optional<String> str11 = ls.stream().max(Comparator.comparingInt(String::length));

	        // If a string is found, print it
	        str11.ifPresent(System.out::println);
	        
	        List<Integer> lsI= Arrays.asList(2,5,1,7,4,9);
	        Optional<Integer> minI=lsI.stream().min(Integer::compareTo);
	        minI.ifPresent(System.out::println);
	        
//	        List<Integer> lsM= Arrays.asList(2,5,1,7,4,9);
	        Optional<Integer> maxI=lsI.stream().max(Integer::compareTo);
	        maxI.ifPresent(System.out::println);
	        
	        long lo=lsI.stream().count();
	        System.out.println(lo);
	        
	        Map<Character, Long> mp =  s.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
	        mp.forEach((key,value)-> System.out.println(key +":"+ value));
	        
	        Map<Character, Long> ch1 = s.toLowerCase().chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
	        Optional<Character> ch2 = ch1.entrySet().stream().filter(entry->entry.getValue()==2).map(Map.Entry::getKey).findFirst();
	        ch2.ifPresent(System.out::println);
	        
	        List<Person1> pr = Arrays.asList(
	        		new Person1("A",23,24000),
	        		new Person1("B",24,24000),
	        		new Person1("C",25,24000)
	        		);
	        
	        
	        OptionalDouble od = pr.stream().map(Person1::getAge).mapToInt(Integer::intValue).average();
	        od.ifPresent(System.out::println);
	        
	        
	        String digStr = "af325b245bb5i252902b=[482395i4";
	        long digitCount = digStr.chars().filter(Character::isDigit).count();
	        
//	        List<Character> chList = digStr.chars().mapToObj(c->(char) c)
//	        .filter(c->Character.isDigit(c))
//	        .collect(Collectors.toList());
//	        
//	        chList.forEach(System.out::println);
//	        List chl2= chList.subList(chList.size()-10, chList.size());
//	        System.out.println(chl2.toString());
	        StringBuilder strb = new StringBuilder();
////	        chl2.stream().map(c->strb.append(c));
	        
	        
	        digStr.chars().mapToObj(c->(char) c)
	        .filter(Character::isDigit)
//	        .skip(Math.max(0, digitCount - 10))
	        .forEach(strb::append);
	        System.out.println(strb.toString());
	        
	        digStr.chars().mapToObj(c->(char) c)
	        .filter(Character::isDigit)
//	        .skip(Math.max(0, digitCount - 10))
	        .forEach(strb::append);
	        System.out.println(strb.toString());
	        
	        List<Character> charList = Arrays.asList('a', 'b', 'c', 'd', 'e');
	        String result = charList.stream()
	                                .map(String::valueOf) // Convert each Character to String
	                                .collect(Collectors.joining()); // Join the strings together
	        System.out.println(result); 
	        
	}
	
	private static void employeeTest() {
		
		// Filter Employees Based on Age
		List<Employee> employees = new LinkedList<Employee>();//getEmployees();
		List<Employee> olderThan30 = employees.stream()
		    .filter(employee -> employee.getAge() > 30)
		    .collect(Collectors.toList());

		System.out.println(olderThan30);
		
		//Find First Employee with Salary Above 5000
		Optional<Employee> firstHighSalaryEmployee = employees.stream()
			    .filter(employee -> employee.getSalary() > 5000)
			    .findFirst();

			firstHighSalaryEmployee.ifPresent(System.out::println);

		//Group Employees by Department
			Map<String, List<Employee>> employeesByDepartment = employees.stream()
				    .collect(Collectors.groupingBy(Employee::getDepartment));

				employeesByDepartment.forEach((department, empList) -> {
				    System.out.println(department + ": " + empList);
				});

				
			//Calculate Average Salary
				OptionalDouble averageSalary = employees.stream()
					    .mapToDouble(Employee::getSalary)
					    .average();

					averageSalary.ifPresent(System.out::println);

			//Get All Employee Names as a List
					List<String> employeeNames = employees.stream()
						    .map(Employee::getName)
						    .collect(Collectors.toList());

						System.out.println(employeeNames);

			//Get Total Salary of All Employees
						double totalSalary = employees.stream()
							    .mapToDouble(Employee::getSalary)
							    .sum();

							System.out.println(totalSalary);

			//Sort Employees by Name
							List<Employee> sortedByName = employees.stream()
								    .sorted(Comparator.comparing(Employee::getName))
								    .collect(Collectors.toList());

								sortedByName.forEach(System.out::println);

			//Count Employees in a Specific Department
								long salesCount = employees.stream()
									    .filter(employee -> "Sales".equals(employee.getDepartment()))
									    .count();

									System.out.println(salesCount);

			//Check if All Employees Have Salary Above 3000
									boolean allAbove3000 = employees.stream()
										    .allMatch(employee -> employee.getSalary() > 3000);

										System.out.println(allAbove3000);

			//Get the Highest Salary
										Optional<Employee> highestSalaryEmployee = employees.stream()
											    .max(Comparator.comparing(Employee::getSalary));

											highestSalaryEmployee.ifPresent(System.out::println);

			//Get Employees Who Are Not in the "HR" Department
											List<Employee> notInHR = employees.stream()
												    .filter(employee -> !"HR".equals(employee.getDepartment()))
												    .collect(Collectors.toList());

												notInHR.forEach(System.out::println);

			//

	}
}
 

class Person1{
	String Name;
	int Age;
	double Salary;
	public Person1(String name, int age, double salary) {
		super();
		Name = name;
		Age = age;
		Salary = salary;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "Person [Name=" + Name + ", Age=" + Age + ", Salary=" + Salary + "]";
	}
}


class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (" + department + ", " + age + " years old, Salary: " + salary + ")";
    }
}
