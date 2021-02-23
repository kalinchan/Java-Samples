package io.github.kalinchan.javasamples.javaee.cdiscopes;

import javax.enterprise.context.Dependent;

@Dependent
public class BeanDefiningAnnotationExample {

	/*
	 * 
	 * 
	 * The set of bean defining annotations contains:
	 * 
	 * @ApplicationScoped, @SessionScoped, @ConversationScoped and @RequestScoped
	 * annotations,
	 * 
	 * all other normal scope types,
	 * 
	 * @Interceptor and @Decorator annotations,
	 * 
	 * all stereotype annotations (i.e. annotations annotated with @Stereotype),
	 * 
	 * and the @Dependent scope annotation.
	 * 
	 * If one of these annotations is declared on a bean class, then the bean class
	 * is said to have a bean defining annotation. For example, this dependent
	 * scoped bean has a bean defining annotation:
	 * 
	 */
}
