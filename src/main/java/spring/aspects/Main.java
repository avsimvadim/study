package spring.aspects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/aspects-context.xml");
        Student  student1 = new Student("Alan","Badoev",18);
        //Student  student2 = new Student("Kiril","Poturaev",27);
        //Student  student3 = new Student("Ihor","Velichko",32);
        context.getBean(Service.class).addStudent(student1);
        //context.getBean(Service.class).addStudent(student2);
        //context.getBean(Service.class).addStudent(student3);
        Map<Integer, Student> allStudents = context.getBean(Service.class).getAllStudents();

        allStudents.entrySet().stream().forEach(System.out::println);
    }
}
