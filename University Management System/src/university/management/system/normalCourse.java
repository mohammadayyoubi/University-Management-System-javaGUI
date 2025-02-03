package university.management.system;

public class normalCourse extends CourseSection {

    public normalCourse(int Section_maxNbStud, int section_Nb, String Course_name, String Course_code, int WeaksNb, String Status) {
        super(Section_maxNbStud, section_Nb, Course_name, Course_code, WeaksNb, Status);
    }

    @Override
    public double getAvarageGrade() {
        double grade=0, sum = 0;
        for (int i = 0; i < grades.size(); i++) {
            sum += super.grades.get(i);
        }
       grade= (sum / super.regStud_course.size());
       return grade;
    }

}
