package io.github.kalinchan.javasamples.javaee.cdiqualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
public @interface SpinRacquet {
	/*
	 * This is an example of a qualifier, you add @SpinRacquet to the bean you want
	 * and the container can distinguish between the two implementations
	 */
}
