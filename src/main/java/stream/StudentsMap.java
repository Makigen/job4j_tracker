package stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentsMap {
    public static Map<String, Student> listToMap(List<Student> students) {
        return students.stream()
                .collect(Collectors
                        .toMap(student -> student.getSurname(), Function.identity(), ((student, student2) -> student)));
    }
}
