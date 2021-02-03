package spring.aspects;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DB {
    private Map<Integer, Student> students;

    public DB() {
        students = new HashMap<>();
    }

    public boolean addStudent(Student student) {
        students.put((int)(Math.random() * 100000), student);
        return true;
    }

    public Map<Integer, Student> getStudents(){
        return students;
    }
}
