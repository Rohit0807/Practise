package com.rohit.notebook;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
	
	public static void main(String[] args) {
		 int[] arr = {2, 7, 11, 15,3,6,2,7};
	        int target = 9;
	        Map<Integer,List<Integer>> hm = new HashMap<>();
	        List<Integer> ls = new LinkedList<>();
	        for(int i=0; i<arr.length;i++){
	            
	            Integer diff = target-arr[i];
	            if(hm.containsKey(diff)){
	                List<Integer> index = hm.get(diff);
	                for(Integer x: index){
	                    System.out.println(x +","+i);
	                }
	                
	            }else{
	                ls.add(i);
	                hm.put(arr[i], ls);
	            }
	        }
		
			
 	}

}