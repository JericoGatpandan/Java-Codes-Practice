package studentManagement;
// Create a class Student with attributes such as name, age and major. Create a console menu to add, update, delete items in the list and sort the students by age.
public class Student {

    private String name;
    private int age;
    private String major;

    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    // Getter
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getMajor() {
        return this.major;
    }

    public String showInfo() {
        return "Name: " + name + "\nAge: " + age + "\nMajor: " + major;
    }
}
