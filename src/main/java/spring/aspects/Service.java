package spring.aspects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Service {

    @Autowired
    private DB db;

    public Service() {
    }

    public boolean addStudent(Student student){
        System.out.println("Add student " + student);
        return db.addStudent(student);
    }

    public Map<Integer, Student>  getAllStudents(){
        System.out.println("Get students");
        return db.getStudents();
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }
}
