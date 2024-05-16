package university.management.system;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{

    String Sname;
    static int ID = 1;
    String SphoneNb;
    String Saddress;
    int SSN;
    int SID;
    ArrayList<CourseSection> courses;

    public Student(String Sname, String SphoneNb, String Saddress, int SSN) {
        this.Sname = Sname;
        this.SphoneNb = SphoneNb;
        this.Saddress = Saddress;
        this.SID = ID;
        this.SSN = SSN;
        ID++;
    }

    public void changeCourse(CourseSection c1, CourseSection c2) {
        courses.remove(c1);
        courses.add(c2);
    }
}
