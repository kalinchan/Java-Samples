package io.github.kalinchan.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws IOException {

		// Integer Stream
		IntStream
			.range(1, 10) //Stream of 1 to 10
			.forEach(System.out::print); //Print each number from 1 to 10
		System.out.println();
		
		//Integer Stream with Skip
		IntStream
			.range(1, 10) //Stream of 1 to 10
			.skip(5) // Skip first 5 numbers in the stream
			.forEach(x -> System.out.println(x)); // Print each number left in the stream
		System.out.println();
		
		//Integer Stream with sum
		System.out.println(
		IntStream
			.range(1, 5) // Stream of 1 to 5
			.sum()); // Calculate sum of the entire stream
		System.out.println();
		
		//Stream.of, sorted and findFirst
		Stream.of("Ava", "Aneri", "Alberto")
			.sorted() // Sort stream alphabetically 
			.findFirst() // Get first in stream
			.ifPresent(System.out::println); // Print out fist element in stream
		System.out.println();
		
		//Stream from Array, sort, filter and print
		String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
		Arrays.stream(names)
			.filter(x -> x.startsWith("S")) // Filter stream to names only beginning with S
			.sorted() // Sort stream alphabetically 
			.forEach(System.out::println); // Print out each name
		System.out.println();
		
		//Average of squares of an int array
		Arrays.stream(new int[] {2,4,6,8,10})
			.map(x -> x * x) //Map each element to it's square, e.g. 2 is now 4
			.average() //Get the average of all elements 
			.ifPresent(System.out::println); //Print average
		System.out.println();
		
		//Stream from list, filter and print
		List<String> people = Arrays.asList("Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
		people
			.stream() // Stream people list
			.map(String::toLowerCase) //Convert stream to lowercase
			.filter(x -> x.startsWith("a")) //Filter stream to names only beginning with a 
			.forEach(System.out::println); //Print each name left in stream
		System.out.println();
		
		//Stream rows from text file, sort, filter and print
		Stream<String> bands = Files.lines(Paths.get("src/main/resources/bands.txt"));
		bands
			.sorted() //Sort stream
			.filter(x -> x.length() > 13) //Filter by character size keeping only strings with more than 13 chars
			.forEach(System.out::println); //Print each string
		bands.close(); //Close to prevent memory leaks
		System.out.println();
		
		//Stream rows from text file and save to List
		List<String> bands2 = Files.lines(Paths.get("src/main/resources/bands.txt"))
				.filter(x -> x.contains("jit")) //filter stream to only elements that contain 'jit'
				.collect(Collectors.toList()); // collect all elements to add to list
		bands2.forEach(x ->	System.out.println(x));//Print out each item in stream
		System.out.println();
		
		//Stream rows from CSV file and count
		Stream<String> rows1 = Files.lines(Paths.get("src/main/resources/data.txt"));
		int rowCount = (int)rows1
				.map(x -> x.split(",")) // Split each item with ,
				.filter(x -> x.length == 3) //filter each item which has a length of 3
				.count(); //count amount of items
		System.out.println(rowCount + " rows. ");
		rows1.close(); //Close to prevent memory leaks
		System.out.println();
		
		//Stream rows from CSV file, parse data from rows
		Stream<String> rows2 = Files.lines(Paths.get("src/main/resources/data.txt"));
		rows2
			.map(x -> x.split(",")) //Split each item in stream
			.filter(x -> x.length == 3) //Filter by item length
			.filter(x -> Integer.parseInt(x[1]) > 15) //Parse int and filter items greater than 15
			.forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2])); // print each item
		rows2.close(); //Close stream
		System.out.println();
		
		//Stream rows from CSV file, store fields in hashmap
		Stream<String> rows3 = Files.lines(Paths.get("src/main/resources/data.txt"));
		Map<String, Integer> map = new HashMap<>();
		map = rows3
				.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.filter(x -> Integer.parseInt(x[1]) > 15)
				.collect(Collectors.toMap(
						x -> x[0], //Gets first item in row array
						x -> Integer.parseInt(x[1]))); //Gets second item in row array
		//Each item is added to the map 
		rows3.close();
		for(String key : map.keySet()) {
			System.out.println(key + "  " + map.get(key));
		}
		System.out.println();
		
		//Reduction - sum
		double total = Stream.of(7.3, 1.5, 4.8)
				.reduce(0.0, (Double a, Double b) -> a+b); ///0.0 is starting value, pass in two doubles and add together.
		// double a is the current total and double b is new value which is being passed in 
		System.out.println("Total = " + total);
		System.out.println();
		
		//Reduction - summary statistics 
		IntSummaryStatistics summary = IntStream.of(7,2,19,88,73,4,10)
				.summaryStatistics(); //gets count, sum, min, average and max of the stream
		//only works for int stream
		System.out.println(summary);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
 