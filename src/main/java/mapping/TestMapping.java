package mapping;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TestMapping {
    public static void main(String[] args) throws Exception{
        Gson gson = new Gson();
        Car car = new Car();
        String jsonCar = gson.toJson(new Car("Skoda","octavia",33000.8));
        System.out.println(jsonCar);
        File file = new File("C:\\Users\\avsim\\IdeaProjects\\study\\src\\main\\resources\\json.txt");
        try(FileWriter fw = new FileWriter(file)){
            fw.write(jsonCar);
        }
        try(BufferedReader fr = new BufferedReader(new FileReader(file))){
            if (fr.ready()){
                car = gson.fromJson(fr.readLine(), Car.class);
            }
        }
        System.out.printf(car.toString());
    }
}
