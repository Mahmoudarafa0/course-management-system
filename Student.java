import java.util.ArrayList;

public class Student extends Account{
    ArrayList <Course> courses = new ArrayList<>();
    public Student(String name, String address, String phoneNumber, String id, String userName, String password, Course course) {
        super(name, address, phoneNumber, id, userName, password);
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "your informations are" +
                "\nname = " + this.getName() +
                "\naddress = " + this.getAddress() +
                "\nphone number = " + this.getPhoneNumber() +
                "\nid = " + this.getId() +
                "\nusername = " + this.getUserName() +
                "\npassword = " + this.getPassword() +
                "\ncourses = " + this.courses;
    }
}
