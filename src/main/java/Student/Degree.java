package Student;

public enum Degree {
    BACHELOR("Бакалавр"),
    MASTER("Магистр");

    private String russianName;

    Degree(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }
}


