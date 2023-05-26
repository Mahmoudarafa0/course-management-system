public class Administrator extends Account implements Admin{
    public Administrator(String name, String address, String phoneNumber, String id, String userName, String password) {
        super(name, address, phoneNumber, id, userName, password);
    }
    @Override
    public Instructor addNewInstructor(String name, String address, String phoneNumber, String id, String userName, String password, Course course) {
        return new Instructor(name, address, phoneNumber, id, userName, password, course);
    }
    @Override
    public Course addNewCourse(String name, String id) {
        return new Course(name, id);
    }

    @Override
    public void showInstructorsInformations(Instructor instructor) {
        System.out.println("instructor informations");
        System.out.println("name = " + instructor.getName());
        System.out.println("address = " + instructor.getAddress());
        System.out.println("phone number = " + instructor.getPhoneNumber());
        System.out.println("id = " + instructor.getId());
        System.out.println("course name = " + instructor.getCourse().getName());
        System.out.println("course id = " + instructor.getCourse().getId());
        System.out.println("********************************************************");
    }

    @Override
    public void showStudentsInformations(Student student) {
        System.out.println("Student informations");
        System.out.println("name = " + student.getName());
        System.out.println("address = " + student.getAddress());
        System.out.println("phone number = " + student.getPhoneNumber());
        System.out.println("id = " + student.getId());
        System.out.println("courses = " + student.courses);
        System.out.println("********************************************************");
    }

    @Override
    public void showCourses(Course course) {
        System.out.println("course informations");
        System.out.println("course name = " + course.getName());
        System.out.println("course id = " + course.getId());
        System.out.println("********************************************************");
    }
}
