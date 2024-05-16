package university.management.system;

public class onlineCourse extends CourseSection {

    public onlineCourse(int Section_maxNbStud, int section_Nb, String Course_name, String Course_code, int WeaksNb, String Status) {
        super(Section_maxNbStud, section_Nb, Course_name, Course_code, WeaksNb, Status);
    }

    @Override
    public double getAvarageGrade() {
        double grade, sum = 0;
        for (int i = 0; i < grades.size(); i++) {
            sum += super.grades.get(i);
        }
        return (sum / super.regStud_course.size()) * (1 + (super.WeaksNb / 20));
    }

}
