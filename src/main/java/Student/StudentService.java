package Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    private Map<Integer, Student> students = new HashMap<>();
    private int nextId = 1;


    public void addStudent(String name, int age, Degree degree) {
        if (name == null || name.isEmpty() || age <= 0 || degree == null) {
            throw new IllegalArgumentException("Student date is incorrect");
        }
        Student student = new Student(name, age, nextId++, degree);
        students.put(student.getId(), student);
    }

    // А. Возвращать список всех студентов.
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());

    }

    // Б. Возвращать количество студентов.
    public int getStudentCount() {
        return students.size();
    }
    // В. Возвращать количество студентов конкретной учебной степени
//                   (количество бакалавров или количество магистров).

    public long getStudentCountByDegree(Degree degree) {

        return getStudentsByDegree(degree).size();

    }

    // Г. Возвращать средний возраст всех студентов.
    public double getAverageAge() {
        return students.values()
                .stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
    }
    // Д. Возвращать средний возраст студентов конкретной учебной степени.

    public double getAverageAgeByDegree(Degree degree) {


        return getStudentsByDegree(degree)
                .stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);

    }

    //  Е. Возвращать список студентов конкретной учебной степени.
    public List<Student> getStudentsByDegree(Degree degree) {
        return students.values()
                .stream()
                .filter(student -> student.getDegree().equals(degree))
                .collect(Collectors.toList());
        //toList();

    }

    public void printStudent() {
        students.values().forEach(System.out::println);
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public Student getStudentByName(String name) {
        return students.values()
                .stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
