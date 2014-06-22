package my.spring.first.udemy.cave;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	System.out.println( "Hello World!" );
//    	Person person = new Person();
//    	person.speak();
    	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("my/spring/first/udemy/cave/beans/beans.xml");
//    	ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/my/spring/first/udemy/cave/beans/beans.xml");
    	Person person = (Person)context.getBean("person");
    	person.speak();
    	context.close();
    }
}
