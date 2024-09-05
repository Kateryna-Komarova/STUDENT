package Student;

public class Student {

    private String name;
    private int age;
    private int id;
    private Degree degree;

    public Student(String name, int age, int id, Degree degree) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public Degree getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return String.format("Student: name %s, age %d, id %d, degree %s",
                name, age, id, degree);
    }
}
