public class Instructor extends Account{
    private Course course;
    public Instructor(String name, String address, String phoneNumber, String id, String userName, String password, Course course) {
        super(name, address, phoneNumber, id, userName, password);
        this.course = course;
    }

    public Course getCourse() {
        return course;
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
                "\ncourse name = " + this.course.getName() +
                "\ncourse id = " + this.course.getId();
    }
}
