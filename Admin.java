public interface Admin {
    Instructor addNewInstructor(String name, String address, String phoneNumber, String id, String userName, String password, Course course);

    Course addNewCourse(String name, String id);

    void showInstructorsInformations(Instructor instructor);

    void showStudentsInformations(Student student);

    void showCourses(Course course);
}
