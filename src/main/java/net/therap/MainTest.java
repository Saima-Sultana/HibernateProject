package net.therap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: saima
 * Date: 5/14/12
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config.xml");

        Main obj = (Main) context.getBean("mainBean");
        obj.saveStock();
    }

}
