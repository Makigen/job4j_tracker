package stream;

import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.*;
import static stream.StudentsMap.listToMap;

public class StudentsMapTest {

    @Test
    public void convertStudents() {
        Student student1 = new Student(10, "Malikov");
        Student student2 = new Student(100, "Arsentev");
        Student student3 = new Student(90, "Korobeinikov");
        Student student4 = new Student(33, "Malikov");
        List<Student> list = Arrays.asList(student1, student2, student3, student4);

        Map<String, Student> expect = new HashMap<>();
        expect.put(student1.getSurname(), student1);
        expect.put(student2.getSurname(), student2);
        expect.put(student3.getSurname(), student3);

        Map<String, Student> result = listToMap(list);
        assertEquals(result, expect);
    }
}
