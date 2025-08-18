import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class GreedyAlgorithms {
	
	public static void main(String[] args) {
		assignCookie();
		fractionalKnapsackProblem();
		coinChangeByGreedyAlgorithm();
		lemonadeChange();
		
		validParanthesisChecker();
		validParanthesisChecker2();
		
		nMeetingInOneRoom();
		jumpGame();
		jumpGameInMinimumNumberOfJumps();
		shortestJobFirst();
		
		maxNumberOfPlatforms();
		maxNumberOfPlatforms2();
		
		jobSequencing();
	}
	
	private static void assignCookie() {
		//problem states that i have 2 arrays one of student other of cookie size
		// in student array we will have max. size of cookies that can be assigned to the student
		// like {2,1,4}  so in cookie array we will have to find size greater than or equal to the student capacity
		// cookie array {1,3,5,2} so for staudent 2 2,3,5 cookie can be assigned, but at most 1 cookie can be assigned
		// that assigned cookie will not be given to anyone else
		
		//approach:
		// sort both the arrays and take 2 pointers and increase the pointers based on the correct size
		// and print the no. of students satisfied that means given cookies
		
		int[] student= {1,2,3,4};
		int[] cookie = {2,1,1,4};
		
		Arrays.sort(student);
		Arrays.sort(cookie);
		
		int i=0;
		int j=0;
		int count =0;
		while(i<student.length && j<cookie.length) {
			if(cookie[j]>=student[i]) {
				count++;
				i++;
				j++;
			}else {
				j++;
			}
		}
		
		System.out.println("No. of student who got cookies : " + count);
		
	}
	
	private static void fractionalKnapsackProblem() {
		// {(100,20),(60,10),(100,50),(200,50)} first one is value second one is its weight
		// there is a box that can hold 90 weight, you have to put the max value in box, you can take fractional weight
		
		// approach:
		// sort the arrays based on value per weight like 100/20 is 5, 60/10 is 6. SORT IN REVERSE. max value per weight first.
		// then put it in the box, and whatever left take it as fraction.
		
		int n = 3, weight = 50;
        Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is "+ans);
	}
	
	static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator()); 
        
        int curWeight = 0; 
        double finalvalue = 0.0; 
        
        for (int i = 0; i < n; i++) {
       
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            }
     
            else {
                int remain = W - curWeight;
                finalvalue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }
     
        return finalvalue;
        
    }
	
	private static void coinChangeByGreedyAlgorithm() {
		// PS:
		// you have been given a number 49, and you hvae to give change
		// 49 will have two 20 rs. note, 1 5RS, 2 2RS.
		
		// approach:
		// denominations will be {1,2,5,10,20,50,100,200,500,1000}
		
		
		int val=49;
		int[] deno = {1,2,5,10,20,50,100,200,500,1000};
		LinkedHashMap<Integer, Integer> hs = new LinkedHashMap<>();
		
		for(int i=deno.length-1; i>=0;i--) {
			if(val==0) break;
			if(deno[i]>val) {
				continue;
			}else {
				int rem = val/deno[i];
				val%=deno[i];
				hs.put(deno[i],rem);
			}
		}
		
		hs.forEach((k,v)-> System.out.println(k +" note of "+v));
	}
	
	private static void lemonadeChange() {
		// in a shop customers buy lemonade of 5$ and it curreantly has no change.
		// so if multiple customer buy 5$ lemonade and pay in 5, 10,20 dollars, will everyone gets change.
		// {5,5,10,5,20}  for third customer, we can return 5$, and we will be having 5$ and 10$ notes, which will be used to return to next customer
		
		int[] arr = {10,5,20};
		int five=0;
		int ten=0;
		
		for(int i=0; i<arr.length;i++) {
			if(arr[i]==5) {
				five++;
			}else if(arr[i]==10) {
				if(five>0) {
					five--;
					ten++;
				}else {
					System.out.println("Lemonade change : Customers will not get change");
					return;
				}
			}else{
				if(ten>0 && five>0) {
					ten--;
					five--;
				}else if(five>=3) {
					five-=3;
				}else {
					System.out.println("Lemonade change : Customers will not get change");
					return;
				}
			}
		}
		System.out.println("Lemonade change : Customers will get the change");
		
	}
	
	private static void validParanthesisChecker() {
		// a string will be given with only (,*,) three characters, * can be converted into (,) or " " blank String
		// (*()  this will be balanced as * will be converted into ) and the string will be ()()
		
		// arroach 1 ;
		//try out every possibility with recursion, will convert * into (,)," "
		
		String s = ")(*))";
	    boolean isValid = checkValidString(s, 0, 0);
	    System.out.println("Is valid: " + isValid);
	}
	
	// Recursive helper function
	private static boolean checkValidString(String s, int index, int balance) {
	    // If more closing brackets than opening at any point, invalid
	    if (balance < 0) return false;

	    // If we reached the end of the string
	    if (index == s.length()) {
	        return balance == 0; // valid only if all open brackets are closed
	    }

	    char currentChar = s.charAt(index);

	    if (currentChar == '(') {
	        return checkValidString(s, index + 1, balance + 1);
	    } else if (currentChar == ')') {
	        return checkValidString(s, index + 1, balance - 1);
	    } else if (currentChar == '*') {
	        // Try all 3 options: *, becomes (, ), or ""
	        return checkValidString(s, index + 1, balance + 1) ||  // * becomes (
	               checkValidString(s, index + 1, balance - 1) ||  // * becomes )
	               checkValidString(s, index + 1, balance);        // * becomes ""
	    }

	    return false; // unreachable normally
	}
	
	private static void validParanthesisChecker2() {
	    // a string will be given with only (,*,) three characters
	    // * can be converted into (,), or " " (blank)
	    // Example: (*() is valid if * becomes ) -> ()()

	    // approach 1:
//		We keep track of two variables:
//
//		low: the minimum number of open parentheses '(' we might have at that point.
//		high: the maximum number of open parentheses '(' we could have at that point.
//
//		As we scan the string:
//		'('  both low and high increase by 1.
//		')'  both low and high decrease by 1.
//		'*'  could be '(', ')', or empty:
//		So low decreases by 1 (if * is ')')
//		high increases by 1 (if * is '(')
//		We must ensure that high is never negative (too many closing brackets), and at the end, low must be 0 (fully matched).

		String s = "(*))";
	    boolean isValid = isValidGreedy(s);
	    System.out.println("Is valid: " + isValid);
	}
	
	private static boolean isValidGreedy(String s) {
	    int low = 0, high = 0;

	    for (int i = 0; i < s.length(); i++) {
	        char ch = s.charAt(i);

	        if (ch == '(') {
	            low++;
	            high++;
	        } else if (ch == ')') {
	            low--;
	            high--;
	        } else if (ch == '*') {
	            // * could be '(', ')' or empty
	            low--;      // treat * as ')'
	            high++;     // treat * as '('
	        }

	        // If high < 0, too many closing brackets
	        if (high < 0) return false;

	        // low can't be negative — reset to 0
	        low = Math.max(low, 0);
	    }

	    // valid if at the end low == 0 (can be fully balanced)
	    return low == 0;
	}
	
	private static void nMeetingInOneRoom() {
		// there is a room and you have been given start and end timing of meetings, you have to accomodate max. meetings
		// Start = [1, 3, 0, 5, 8, 5] , End = [2, 4, 6, 7, 9, 9]
		// The meetings that can be accommodated in meeting room are (1,2) , (3,4) , (5,7) , (8,9).
		
		// aprroach 1:
		// store the start, end and index in a suitable data structure
		// sort on the basis of end time
		// and now compare if the start time of next element is greater than the end time of last element.
		
		int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 5, 7, 9, 9};
        
        int n = start.length;
        List<Meeting> meetings = new ArrayList<>();

        // Create POJO objects
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        // Sort meetings by end time
        meetings.sort(Comparator.comparingInt(m -> m.end));

        List<Integer> result = new ArrayList<>();
        int lastEndTime = 0;

        // Select meetings greedily
        for (Meeting meeting : meetings) {
            if (meeting.start > lastEndTime) {
                result.add(meeting.index);
                lastEndTime = meeting.end;
            }
        }

        result.forEach(l->System.out.print(meetings.get(l-1).toString()));
    
	}
	
	private static void jumpGame() {
		// for a given array check if from index 0, last index can be reached or not.
		// each element can jump from 1 to the number itself, for number 2, it will jump either 1 or 2 places
		// {2,3,1,1,1,1,5} if 2 jump 1place it will reach to 3, then 3 jumps 3 places, then 1 will jump and reach 5
		
		// approach :
		// if the element encounters 0 then only it will not jump otherwise it reach the end.
		// now based on the logic, we can calculate the max. index the we can reach the array
		// if the counter reaches more then max index it will not reach end
		
		System.out.println();
		int[] arr = {1,2,3,1,1,0,2,5};
		int maxIndex = 0;
		for (int i=0; i<arr.length;i++) {
			
			if(i>maxIndex) {
				System.out.println("It cannot jump to last index");
				return;
			}
			int index = arr[i]+i;
			
			if(index>maxIndex) maxIndex=index;
			
			
		}
		
		System.out.println("It can jump to last index");
		
	}
	
	private static void jumpGameInMinimumNumberOfJumps() {
		// same as jump game but in this it will always jump to last index.
		// we have to calculate minimum number of steps
		
		// approach:
		// just like valid paranthesis check, maintain a range, here the range will be of farthest the element can jump
		//for 2, it can reach 3 and 1, [3,1] will be a range, check in this next check the index next from 1+1 index and 
		// farthest of [3,1]
		
		int[] nums= {2,3,1,4,1,1,1,2};
		int jumps = 0;
        int farthest = 0;
        int end = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }
        
        System.out.println("Minimum number of jumps: "+jumps);
	}
	
	private static void shortestJobFirst() {
		
		//given burst time in an array, calculate average waiting time for the jobs
		// shortest jobs will be picked first
		
		//approach:
		// sort the array :{4, 3, 7, 1, 2} -> {1,2,3,4,7}
		// add the waiting time for each job {0,1,3,6,10} divide by length of array
		
		int[] jobs= {4, 3, 7, 1, 2};
		Arrays.sort(jobs);

        float waitTime = 0;
        int totalTime = 0;
        int n = jobs.length;

        for (int i = 0; i < n; ++i) {

            // Add current total
            // time to waiting time
            waitTime += totalTime;

            // Add current job's
            // time to total time
            totalTime += jobs[i];
        }
        
        System.out.println("Average Waiting time : "+ (waitTime/n));
	}
	
	private static void maxNumberOfPlatforms() {
		int[] arr ={900,945,955,1100,1500,1800};
		int[] dep={920,1200,1130,1150,1900,2000};
		int n=arr.length;
		
		int ans=1; //final value
	    for(int i=0;i<=n-1;i++)
	    {
	        int count=1; // count of overlapping interval of only this   iteration
	        for(int j=i+1;j<=n-1;j++)
	        {
	            if((arr[i]>=arr[j] && arr[i]<=dep[j]) ||
	           (arr[j]>=arr[i] && arr[j]<=dep[i]))
	           {
	               count++;
	           }
	        }
	        ans=Math.max(ans,count); //updating the value
	    }
	    
	    System.out.println("Max Number of platforms : "+ ans);
	}
	
	private static void maxNumberOfPlatforms2() {
		int[] arrival ={900,945,955,1100,1500,1800};
		int[] departure={920,1200,1130,1150,1900,2000};
		int n=arrival.length;
		
		// Sort both arrays
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platformsNeeded = 1;  // At least one platform is needed initially
        int maxPlatforms = 1;

        int i = 1; // Pointer to next arriving train
        int j = 0; // Pointer to next departing train

        while (i < n && j < n) {
            // If next train arrives before the last one departs, need extra platform
            if (arrival[i] <= departure[j]) {
                platformsNeeded++;
                i++;
            } else {
                platformsNeeded--;
                j++;
            }

            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }
	    System.out.println("Max Number of platforms : "+ maxPlatforms);
	}
	
	private static void jobSequencing() {
		Job[] arr = new Job[4];
	      arr[0] = new Job(1, 4, 20);
	      arr[1] = new Job(2, 1, 10);
	      arr[2] = new Job(3, 2, 40);
	      arr[3] = new Job(4, 2, 30);
	      
	      int n=arr.length;
	      
	      Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

	      int maxi = 0;
	      for (int i = 0; i < n; i++) {
	         if (arr[i].deadline > maxi) {
	            maxi = arr[i].deadline;
	         }
	      }
	      
	      int result[] = new int[maxi + 1];

	      for (int i = 1; i <= maxi; i++) {
	         result[i] = -1;
	      }

	      int countJobs = 0, jobProfit = 0;
	      
	      for (int i = 0; i < n; i++) {

	          for (int j = arr[i].deadline; j > 0; j--) {

	             // Free slot found 
	             if (result[j] == -1) {
	                result[j] = i;
	                countJobs++;
	                jobProfit += arr[i].profit;
	                break;
	             }
	          }
	       }

	       int ans[] = new int[2];
	       ans[0] = countJobs;
	       ans[1] = jobProfit;
	}

}

class Item {
	  int value, weight;
	  Item(int x, int y) {
	    this.value = x;
	    this.weight = y;
	  }
}

class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b) 
    {
        double r1 = (double)(a.value) / (double)(a.weight); 
        double r2 = (double)(b.value) / (double)(b.weight); 
        if(r1 < r2) return 1; 
        else if(r1 > r2) return -1; 
        else return 0; 
    }
}

class Meeting {
    int start;
    int end;
    int index;

    public Meeting(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

	@Override
	public String toString() {
		return "(" + start + "," + end + ")";
	}
    
    

    // Optional: getters/setters/toString() if needed
}

class Job {
	   int id, profit, deadline;
	   Job(int x, int y, int z) {
	      this.id = x;
	      this.deadline = y;
	      this.profit = z;
	   }
	}

