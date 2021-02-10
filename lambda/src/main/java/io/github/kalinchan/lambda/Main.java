package io.github.kalinchan.lambda;

public class Main {

	// Lambda expressions use a functional interface
	// A functional interface is an interface with only one method

	public static void main(String[] args) {

		// Example of Anonymous class implementation
		ExampleInterface exampleInterface = new ExampleInterface() {

			public void exampleFunction() {
				System.out.println("This is an example of an anonymous class implementation");
			}
		};

		exampleInterface.exampleFunction();

		// Example of Lambda Expression with no parameters
		ExampleInterface eI = () -> {
			System.out.println("This is an example of a lambda expression");
		};

		eI.exampleFunction();

		// Example of Lambda Expression with 2 paramters
		ExampleInterfaceWith2 eI2 = (param1, param2) -> {
			System.out.println("Example of a lambda expression with two parameters: " + param1 + ", " + param2);
		};
		eI2.ExampleFunction("First Param", "Second Param");

		// You can return values if the method in the functional interface is not void method
		// by adding the return statement inside the expression	
	}

}
