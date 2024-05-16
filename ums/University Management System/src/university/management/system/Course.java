package university.management.system;

import java.io.Serializable;

public abstract class Course implements Serializable{

    String Course_name;
    String Course_code;
    int maxNbStud;

    public Course(String Course_name, String Course_code/*,int maxNbStud*/) {
        this.Course_name = Course_name;
        this.Course_code = Course_code;
        /*this.maxNbStud=maxNbStud;*/
    }

}
