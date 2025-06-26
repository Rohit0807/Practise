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
		System.out.println("Test1");
		
//		Input: "swiss"
//		Output: 'w'
		
		//non repeating char
		//chars  char(map) hashSet()   .findFirst w _
		//
		
		String str = "swiss";
//		HashSet<Character> hs = new HashSet<Character>();
//		
//		HashMap<Character, Long> hm = new HashMap<Character, Long>();
//		
//		Optional<Character> op = str.chars().mapToObj(c->(char) c).filter(n->hs.add(n)).peek(System.out::println).findFirst();//
//		if(op.isPresent()) {
//			System.out.println(op.get());
//		}else {
//			System.out.println("_");
//		}
//		
		
		str.chars().mapToObj(c->(char) c)
		.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
		.entrySet()
		.stream()
		.filter(n->n.getValue()==1)
		.findFirst().ifPresent(System.out::println);
 	}

}