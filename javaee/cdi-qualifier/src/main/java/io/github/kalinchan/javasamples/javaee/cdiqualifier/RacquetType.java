package io.github.kalinchan.javasamples.javaee.cdiqualifier;

public interface RacquetType {
	String getRacquetType();

	/*
	 * If you have multiple implementations of RacquetType an ambiguous injection
	 * error will occur because the container will not know which implementation
	 * must be injected
	 * 
	 * 
	 * This is where qualifiers come in, they will uniquely identify the
	 * implementations, therefore the container will know exactly what to inject
	 */
}
