import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class CollectionsPractise{
	public static void main(String[] args) {
		System.out.println("Line 11: Hello");
		
		//2 sum problem
		int[] arr = {2,4,5,6,8,15};
		twoSumProblem( arr,14);
		
		try{
			Map<Integer, String> m = new HashMap<Integer, String>();  //  will sort in ascending, LinkedHM preserves insertion order
			m.put(1, null);
			m.put(2, null);
			m.put(null,null);  //  one null is okay
			m.put(null,"2");   // null will be updated
			m.put(2, "4");		// key 2 will be updated with value 4
			
			m.forEach((k,v) -> System.out.println(k+" "+v));
			
			
			for(Map.Entry<Integer, String> entry: m.entrySet()){
				System.out.println("Line 18: key : "+entry.getKey()+" Value:  "+entry.getValue());
			}
			
			
			//Tree Map
			Map<Integer, String> tm = new TreeMap<Integer, String>();
			tm.put(1, null);
			tm.put(2, null);
//			tm.put(null,null);  //  null key not supported in tree map
//			tm.put(null,"2");   // 
			tm.put(2, "4");		// key 2 will be updated with value 4
			tm.remove(1);
			for(Map.Entry<Integer, String> entry: tm.entrySet()){
				System.out.println("Line 36: key : "+entry.getKey()+" Value:  "+entry.getValue());
			}
			
		}finally {  //  catch is not needed if finally is there
			
		}
		
		Set<Integer> s = new HashSet<Integer>();
		s.add(null);
		boolean b= s.add(null);
		System.out.println(b);  //  will print false
		
		for(Integer i : s) {
			System.out.println("Line 50: "+ i);
		}
		
		
		Queue<String> q = new ArrayDeque<String>(5);
		q.add("A");
		q.add("B");
		q.add("C");
		q.add("D");
		q.add("E");
		if(q.size()>4) {
			q.poll();
			q.add("F");
		}
		if(q.size()>4) {
			q.poll();
			q.add("G");
		}
		for(String a : q) {
			System.out.println(a);
		}
		
		
		
	}

	private static void twoSumProblem(int[] arr, int target) {
		HashMap<Integer, Integer> hs  = new HashMap<Integer, Integer>();
		for (int i =0;i<arr.length;i++ ) {
			int diff = target-arr[i];
			if(hs.containsKey(diff)) {
				  System.out.println(arr[i]+":" +diff);
			}
			hs.put(arr[i], i);
			
		}
	}
}