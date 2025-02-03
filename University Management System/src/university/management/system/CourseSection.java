package university.management.system;

import java.util.ArrayList;

public abstract class CourseSection extends Course {

    int Section_maxNbStud;
    int section_Nb;
    ArrayList<Student> regStud_course;
    ArrayList<Double> grades;
    int WeaksNb;
    String Status;

    public CourseSection(int Section_maxNbStud, int section_Nb, String Course_name, String Course_code, int WeaksNb, String Status) {
        super(Course_name, Course_code);
        this.grades = new ArrayList<Double>();
        this.regStud_course = new ArrayList<Student>();
        this.Section_maxNbStud = Section_maxNbStud;
        this.section_Nb = section_Nb;
        this.Status = Status;
        this.WeaksNb = WeaksNb;
        /*if (this.Status.equalsIgnoreCase("normal")) {
            this.WeaksNb = WeaksNb;

        } else {
            while (WeaksNb <= 5 && WeaksNb >= 10) {
                System.out.println("Its online course...the nb of weaks should be between 5 & 10");
                WeaksNb=input.nextInt();
            }
            this.WeaksNb = WeaksNb;
        }**/

    }

    public void add_student(Student s) {

        if (regStud_course.contains(s)) {
            System.out.println("Already in section");
        } else {
            regStud_course.add(s);
            System.out.println("Successfully Add to this section");
        }
    }

    public boolean checkStudent(Student s) {
        if (regStud_course.contains(s)) {
            return true;
        } else {
            return false;
        }
    }

    public void remove_student(Student s) {

        if (regStud_course.contains(s)) {
            regStud_course.remove(s);
            System.out.println("Successfully removed from this section");
        } else {
            System.out.println("Already not in this section!");
        }
    }

    public abstract double getAvarageGrade();


    /*
    //fill grade method to be checked and finished later on
    public void fillGrade(){
        double grade=0;
        for(int i=0;i<this.regStud_course.size();i++){
            grades.add(grade);
        }
    }*/
    @Override
    public String toString() {
        return "CourseSection{" + "Section_maxNbStud=" + Section_maxNbStud + ", section_Nb=" + section_Nb + ", regStud_course=" + regStud_course + ", grades=" + grades + ", WeaksNb=" + WeaksNb + ", Status=" + Status + '}';
    }

    public void print_Student() {
        for (int i = 0; i < regStud_course.size(); i++) {
            String ViewGrades = "Name: " + regStud_course.get(i).Sname + "\t" + "Grade: " + grades.get(i);
            System.out.println(ViewGrades);
        }
    }

    public void move_student(Student s, CourseSection c) {
        if (this.regStud_course.contains(s)) {
            this.remove_student(s);//remove student from this arraylist section
            c.regStud_course.add(s);//add it to the new section
            System.out.println("Successfully moved to new section");
        } else {
            System.out.println("This student is already not regestered in this section");
        }
    }
}
