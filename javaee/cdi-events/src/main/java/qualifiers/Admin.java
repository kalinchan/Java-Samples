package qualifiers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Qualifier;

@Qualifier
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Admin {
	
	public final static class Literal extends AnnotationLiteral<Admin> implements Admin{
		
		public static final Literal INSTANCE = new Literal();
		
		private static final long serialVersionUID =1L;
	}
}
