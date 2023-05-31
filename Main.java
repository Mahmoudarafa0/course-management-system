import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList <Course> courses = new ArrayList<>();
        courses.add(new Course("AI", "123"));
        courses.add(new Course("Cs", "456"));
        courses.add(new Course("CCNA", "789"));

        ArrayList <Instructor> instructors = new ArrayList<>();
        instructors.add(new Instructor("mohamed khaled", "cairo", "01012315976", "14789632512345", "mohamed", "mohamed000", courses.get(0)));
        instructors.add(new Instructor("ali nader", "giza", "01012375324", "14789637892316", "ali", "ali111", courses.get(1)));
        instructors.add(new Instructor("omar mohamed", "mansura", "01012336915", "14789637452364", "mohamed", "omar222", courses.get(2)));

        ArrayList <Student> students = new ArrayList<>();
        students.add(new Student("mohamed ali", "cairo", "010185621157", "12345678912345", "mohamed", "mohamed123", courses.get(0)));
        students.add(new Student("ahmed ali", "menofia", "010185784579", "12345677412597", "ahmed", "ahmed456", courses.get(1)));
        students.add(new Student("mustafa ahmed", "cairo", "010185120134", "12345677895123", "mustafa", "mustafa789", courses.get(2)));

        boolean status = true;
        while (status) {
            System.out.println("SignIn as: ");
            System.out.println("1 - Administrator");
            System.out.println("2 - Instructor");
            System.out.println("3 - Student");
            System.out.println("4 - Exit");
            switch (input.nextInt()) {

                //******************************************************************************************************
                // administrator section
                //******************************************************************************************************

                case 1 -> {
                    input.nextLine();
                    Administrator admin = new Administrator("mahmoud arafa", "menofia", "01018328642", "14789632512378", "mahmoud", "mahmoud010");
                    System.out.println("Enter your user name: ");
                    String userName = input.nextLine();
                    System.out.println("Enter your password: ");
                    String password = input.nextLine();
                    while (!Objects.equals(userName, admin.getUserName()) || !Objects.equals(password, admin.getPassword())) {
                        System.out.println("incorrect username or password");
                        System.out.println("Enter your user name: ");
                        userName = input.nextLine();
                        System.out.println("Enter your password: ");
                        password = input.nextLine();
                    }
                    boolean status1 = true;
                    while (status1) {
                        System.out.println("Choose an operation: ");
                        System.out.println("1 - Add new instructor");
                        System.out.println("2 - Add new course");
                        System.out.println("3 - Show instructors informations");
                        System.out.println("4 - Show students informations");
                        System.out.println("5 - Show courses");
                        System.out.println("6 - Remove instructor");
                        System.out.println("7 - Remove course");
                        System.out.println("8 - Exit");
                        switch (input.nextInt()) {
                            //------------------------------------------------
                            // the following case is for adding new instructor
                            //------------------------------------------------
                            case 1 -> {
                                input.nextLine();
                                System.out.println("Enter the instructor informations");
                                System.out.println("Name: ");
                                String name = input.nextLine();
                                System.out.println("Address: ");
                                String address = input.nextLine();
                                System.out.println("Phone number: ");
                                String phoneNumber = input.nextLine();
                                System.out.println("Id: ");
                                String id = input.nextLine();
                                System.out.println("User name: ");
                                String username = input.nextLine();
                                System.out.println("Password: ");
                                String Password = input.nextLine();
                                System.out.println("Enter id of the course to be instructed: ");
                                String courseId = input.nextLine();
                                int x = courses.size();
                                for (Course course: courses){
                                    if (Objects.equals(courseId, course.getId())) {
                                        x = courses.indexOf(course);
                                    }
                                }
                                instructors.add(admin.addNewInstructor(name, address, phoneNumber, id, username, Password, courses.get(x)));
                                System.out.println("Instructor added successfully");
                                System.out.println("--------------------------------------------------------------------");
                            }

                            //--------------------------------------------
                            // the following case is for adding new course
                            //--------------------------------------------
                            case 2 -> {
                                input.nextLine();
                                System.out.println("Enter the course name: ");
                                String courseName = input.nextLine();
                                System.out.println("Enter the course id: ");
                                String id = input.nextLine();
                                for (Course course: courses){
                                    if (Objects.equals(course.getId(), id)) {
                                        System.out.println("The course already exist please enter the correct course name and id");
                                        System.out.println("Enter the course name: ");
                                        courseName = input.nextLine();
                                        System.out.println("Enter the course id: ");
                                        id = input.nextLine();
                                    }
                                }
                                courses.add(admin.addNewCourse(courseName, id));
                                System.out.println("Course added successfully");
                                System.out.println("--------------------------------------------------------------------");
                            }

                            //-----------------------------------------------------------
                            // the following case is for showing instructors informations
                            //-----------------------------------------------------------
                            case 3 -> {
                                for (Instructor instructor: instructors) {
                                    admin.showInstructorsInformations(instructor);
                                }
                            }

                            //--------------------------------------------------------
                            // the following case is for showing students informations
                            //--------------------------------------------------------
                            case 4 -> {
                                for (Student student: students) {
                                    admin.showStudentsInformations(student);
                                }
                            }

                            //-----------------------------------------------------------
                            // the following case is for showing instructors informations
                            //-----------------------------------------------------------
                            case 5 -> {
                                for (Course course: courses) {
                                    admin.showCourses(course);
                                }
                            }

                            //----------------------------------------------
                            // the following case is for removing instructor
                            //----------------------------------------------
                            case 6 -> {
                                input.nextLine();
                                System.out.println("Enter instructor's id");
                                String id = input.nextLine();
                                boolean x = false;
                                for (Instructor instructor : instructors) {
                                    if (instructor.getId().equals(id)) {
                                        instructors.remove(instructor);
                                        System.out.println("Instructor removed successfully");
                                        x = true;
                                    }
                                    if (x) {
                                        break;
                                    }
                                }
                                if (!x) {
                                    System.out.println("instructor not found");
                                }
                            }

                            //------------------------------------------
                            // the following case is for removing course
                            //------------------------------------------
                            case 7 -> {
                                input.nextLine();
                                System.out.println("Enter course's id");
                                String id = input.nextLine();
                                boolean x = false;
                                for (Course course : courses) {
                                    if (course.getId().equals(id)) {
                                        courses.remove(course);
                                        System.out.println("course removed successfully");
                                        x = true;
                                    }
                                    if (x) {
                                        break;
                                    }
                                }
                                if (!x) {
                                    System.out.println("Course not found");
                                }
                            }

                            //-------------------------------
                            // the following case is for exit
                            //-------------------------------
                            case 8 -> {
                                status1 = false;
                                continue;
                            }

                        }
                        System.out.println("Do you want to continue as administrator");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        switch (input.nextInt()) {
                            case 1:
                                continue;
                            case 2:
                                status1 = false;
                        }
                    }
                }

                //******************************************************************************************************
                // instructor section
                //******************************************************************************************************

                case 2 -> {
                    input.nextLine();
                    System.out.println("Enter username: ");
                    String username = input.nextLine();
                    System.out.println("Enter password: ");
                    String password = input.nextLine();
                    boolean status1 = true;
                    while (status1) {
                        int x = instructors.size();
                        boolean y = false;
                        while (true) {
                            for (Instructor instructor: instructors) {
                                if (Objects.equals(username, instructor.getUserName()) && Objects.equals(password, instructor.getPassword())) {
                                    x = instructors.indexOf(instructor);
                                    y = true;
                                    break;
                                }
                            }
                            if (y)
                                break;
                            else {
                                System.out.println("Not found please enter a valid user name and password");
                                System.out.println("Enter username: ");
                                username = input.nextLine();
                                System.out.println("Enter password: ");
                                password = input.nextLine();
                            }
                        }
                        Instructor instructor = instructors.get(x);
                        System.out.println("Choose an operation: ");
                        System.out.println("1 - Show my informations");
                        System.out.println("2 - Show the informations of my students");
                        System.out.println("3 - Exit");
                        switch (input.nextInt()) {

                            //-----------------------------------------------------------
                            // the following case is for showing instructors informations
                            //-----------------------------------------------------------
                            case 1 -> {
                                System.out.println(instructor);
                                System.out.println("--------------------------------------------------------------------");
                            }

                            //---------------------------------------------------------------------------------
                            // the following case is for showing information of students enrolled in the course
                            //---------------------------------------------------------------------------------
                            case 2 -> {
                                for (Student student: students) {
                                    for (Course course: student.courses) {
                                        if (Objects.equals(course.getId(), instructor.getCourse().getId())) {
                                            System.out.println("Student informations");
                                            System.out.println("name = " + student.getName());
                                            System.out.println("address = " + student.getAddress());
                                            System.out.println("phone number = " + student.getPhoneNumber());
                                            System.out.println("id = " + student.getId());
                                            System.out.println("********************************************************");
                                        }
                                    }
                                }
                                System.out.println("--------------------------------------------------------------------");
                            }

                            //---------------------------------------------------------------------------------
                            // the following case is for exit
                            //---------------------------------------------------------------------------------
                            case 3 -> {
                                status1 = false;
                                continue;
                            }
                        }
                        System.out.println("Do you want to continue as instructor " + instructor.getName());
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        switch (input.nextInt()) {
                            case 1:
                                continue;
                            case 2:
                                status1 = false;
                        }
                    }
                }

                //******************************************************************************************************
                // student section
                //******************************************************************************************************

                case 3 -> {
                    System.out.println("1 - Create new account");
                    System.out.println("2 - already have an account");
                    switch (input.nextInt()) {

                        //-----------------------------------------------
                        // the following case is for creating new account
                        //-----------------------------------------------
                        case 1 -> {
                            input.nextLine();
                            System.out.println("Enter your informations");
                            System.out.println("Name: ");
                            String name = input.nextLine();
                            System.out.println("Address: ");
                            String address = input.nextLine();
                            System.out.println("Phone number: ");
                            String phoneNumber = input.nextLine();
                            System.out.println("Id: ");
                            String id = input.nextLine();
                            System.out.println("User name: ");
                            String username = input.nextLine();
                            System.out.println("Password: ");
                            String password = input.nextLine();
                            int counter = 1;
                            System.out.println("Choose one of these courses");
                            for (Course course: courses) {
                                System.out.println(counter + " - " + course.getName());
                            }
                            int x = input.nextInt();
                            students.add(new Student(name, address, phoneNumber, id, username, password, courses.get(x-1)));
                            System.out.println("Account created successfully");
                            System.out.println("---------------------------------------------------------------------");
                        }

                        //-----------------------------------------------------------
                        // the following case is for students already have an account
                        //-----------------------------------------------------------
                        case 2 -> {
                            input.nextLine();
                            System.out.println("Enter username: ");
                            String username = input.nextLine();
                            System.out.println("Enter password: ");
                            String password = input.nextLine();
                            int x = students.size();
                            boolean y = false;
                            while (true) {
                                for (Student student : students) {
                                    if (Objects.equals(username, student.getUserName()) && Objects.equals(password, student.getPassword())) {
                                        x = students.indexOf(student);
                                        y = true;
                                        break;
                                    }
                                }
                                if (y)
                                    break;
                                else {
                                    System.out.println("Not found please enter a valid user name and password");
                                    System.out.println("Enter username: ");
                                    username = input.nextLine();
                                    System.out.println("Enter password: ");
                                    password = input.nextLine();
                                }
                            }
                            Student student = students.get(x);
                            boolean status1 = true;
                            while (status1) {
                                System.out.println("Choose an operation: ");
                                System.out.println("1 - Show my informations");
                                System.out.println("2 - enroll in new course");
                                System.out.println("3 - unenroll in course");
                                System.out.println("4 - Show my instructors informations");
                                System.out.println("5 - exit");
                                switch (input.nextInt()) {

                                    //--------------------------------------------------------
                                    // the following case is for showing students informations
                                    //--------------------------------------------------------
                                    case 1 -> {
                                        System.out.println(student);
                                        System.out.println("---------------------------------------------------------------------");
                                    }

                                    //-----------------------------------------------------
                                    // the following case is for enrollment in a new course
                                    //-----------------------------------------------------
                                    case 2 -> {
                                        System.out.println("Choose one of these courses");
                                        int counter = 1;
                                        if (student.courses.size() == 0) {
                                            for (Course course : courses) {
                                                System.out.println(counter++ + " - " + course);
                                            }
                                        }
                                        else {
                                            for (Course course: courses) {
                                                for (Course course1: student.courses) {
                                                    if (!Objects.equals(course.getId(), course1.getId())) {
                                                        System.out.println(counter++ + " - " + course);
                                                    }
                                                }
                                            }
                                        }
                                        student.courses.add(courses.get(input.nextInt()-1));
                                        System.out.println("Enrollment successfully");
                                        System.out.println("---------------------------------------------------------------------");
                                    }

                                    //---------------------------------------------------
                                    // the following case is for unenrollment in a course
                                    //---------------------------------------------------
                                    case 3 -> {
                                        int counter = 1;
                                        System.out.println("here is your enrolled courses");
                                        if (student.courses.size() == 0) {
                                            System.out.println("you do not have enrolled courses");
                                        }
                                        else {
                                            for (Course course : student.courses) {
                                                System.out.println(counter++ + " - " + course);
                                            }
                                            System.out.println("Choose one of these courses");
                                            student.courses.remove(courses.get(input.nextInt()-1));
                                            System.out.println("course unenrolled successfully");
                                        }
                                    }

                                    //-----------------------------------------------------------
                                    // the following case is for showing instructors informations
                                    //-----------------------------------------------------------
                                    case 4 -> {
                                        if (student.courses.size() == 0) {
                                            System.out.println("you do not have enrolled courses");
                                        }
                                        else {
                                            for (Course course : student.courses) {
                                                for (Instructor instructor : instructors) {
                                                    if (Objects.equals(course.getId(), instructor.getCourse().getId())) {
                                                        System.out.println("Your instructor informations");
                                                        System.out.println("name = " + instructor.getName());
                                                        System.out.println("address = " + instructor.getAddress());
                                                        System.out.println("phone number = " + instructor.getPhoneNumber());
                                                        System.out.println("id = " + instructor.getId());
                                                        System.out.println("course name = " + instructor.getCourse().getName());
                                                        System.out.println("course id = " + instructor.getCourse().getId());
                                                        System.out.println("********************************************************");
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    //-------------------------------
                                    // the following case is for exit
                                    //-------------------------------
                                    case 5 -> {
                                        status1 = false;
                                        continue;
                                    }
                                }
                                System.out.println("Do you want to continue as student " + student.getName());
                                System.out.println("1 - Yes");
                                System.out.println("2 - No");
                                switch (input.nextInt()) {
                                    case 1:
                                        continue;
                                    case 2:
                                        status1 = false;
                                }
                            }

                        }
                    }

                }

                //******************************************************************************************************
                // the following case for exiting the program
                //******************************************************************************************************

                case 4 -> {
                    status = false;
                    continue;
                }
            }

            //**********************************************************************************************************
            // the following case for exiting the program
            //**********************************************************************************************************
            System.out.println("Do you to continue in the program");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            switch (input.nextInt()) {
                case 1:
                    continue;
                case 2:
                    status = false;
            }

        }
    }
}