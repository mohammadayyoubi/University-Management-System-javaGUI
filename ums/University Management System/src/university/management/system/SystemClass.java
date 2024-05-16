package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetterOrDigit;
import static java.lang.Double.NaN;
import java.util.*;
import javax.swing.border.*;

public class SystemClass extends JFrame {

    static ArrayList<Student> Allstudents = new ArrayList<Student>();
    static ArrayList<Course> Allcourses = new ArrayList<Course>();
    static String pass;
    static String username;
    /*ArrayList<Professor> Allprof = new ArrayList<Professor>();*/
    JLabel sysLabel = new JLabel("Welcome to our University Management System");
    JLabel studLabel = new JLabel("Students ");
    JLabel courseLabel = new JLabel("Courses");
    JLabel functionsLabel = new JLabel("Courses Functions");
    JButton addStudButton = new JButton("Add Student");
    JButton removeStudButton = new JButton("Remove Student");
    JButton infoStudButton = new JButton("Student Info");
    JButton editStudButton = new JButton("Edit Student Info");
    JButton addCourseButton = new JButton("Add Course");
    JButton removeCourseButton = new JButton("Remove Course");
    JButton infoCourseButton = new JButton("Course Info");
    JButton addRemoveButton = new JButton("Add/remove Student");
    JButton moveStudButton = new JButton("Move Student");
    JButton fillGradeButton = new JButton("Fill Grades");
    JButton ViewGradesButton = new JButton("View Grades");
    JButton ChangePass_Username = new JButton("Change Pass & user");
    JButton Logout = new JButton("Logout");
    /*button color*/
    Color buttonColor = new Color(245, 245, 245);

    //Fill Grades components
    JLabel CourseCodeFl = new JLabel("Course Code");
    JTextField CourseCodeFt = new JTextField(8);

    JButton okFb = new JButton("OK");
    JButton changeCourse = new JButton("Change Course");
//View Grades components
    JLabel CourseCodeVGL = new JLabel("Course Code");
    JTextField CourseCodeVGT = new JTextField(8);

    JButton okVGB = new JButton("OK");
    JButton changeCourseVGB = new JButton("Change Course code");

//Add student components
    JLabel S_ID;
    JTextField SName = new JTextField("");
    JTextField SSSN = new JTextField("");
    JTextField SPhoneNb = new JTextField("");
    JTextField SAddress = new JTextField("");
    JButton ButtonaddStud = new JButton("Add Student");
    JLabel AddSNote = new JLabel("Added / Already Exist");

//remove student components
    JTextField RS_ID = new JTextField("");
    JLabel RSNote = new JLabel("removed / Not Found");
    JButton RSButton = new JButton("Remove");

//Student Info
    JTextField ISID = new JTextField("");
    JTextField ISName = new JTextField("");
    JTextField ISSSN = new JTextField("");
    JTextField ISPhoneNb = new JTextField("");
    JTextField ISAddress = new JTextField("");
    JButton ButtonInfoStud = new JButton("Search Student");
    //JLabel IScourses = new JLabel("Courses / No Courses");

//Edit Student Info
    JTextField ESID = new JTextField("");
    JTextField ESPhone = new JTextField("");
    JTextField ESAddress = new JTextField("");
    JButton ButtonEditStud = new JButton("Edit Student Info");
    JLabel ESNote = new JLabel("Changed / Wrong ID");
//Add course componenet
    JLabel AddCourse = new JLabel("");
    JTextField CNameT = new JTextField("");
    JTextField CCodeT = new JTextField("");
    JTextField CMaxNbOfStudT = new JTextField("");
    JTextField CSectionNbT = new JTextField("");
    JButton AddCourseB = new JButton("Add Course");
    JLabel CWeeksNbT = new JLabel("");
    JRadioButton COnline = new JRadioButton("Online");
    JRadioButton CNormal = new JRadioButton("Normal");
    JMenuBar menu = new JMenuBar();
    JMenu section = new JMenu("section");
    JLabel addCourseNote = new JLabel("Added / Already exists");
    JTextField weeksNbT = new JTextField("");
    JMenuItem online = new JMenuItem("online");
    JMenuItem normal = new JMenuItem("normal");
    JTextField CStatusT = new JTextField("");
//Remove course componenet
    JTextField RC_Code = new JTextField("");
    JLabel RCNote = new JLabel("removed / Not Found");
    JButton RCButton = new JButton("Remove");
//Course info componenet
    JTextField CourseCodeT = new JTextField("");
    JTextField CourseNameT = new JTextField("");
    JButton CourseInfoB = new JButton("Search Course");
    JTextField ICStatusT = new JTextField(10);
    JTextField SectionNBT = new JTextField(10);
    JTextField MaxNbOfStudT = new JTextField(10);
    JTextField AverageGradeT = new JTextField(10);
    JTextField NbRegStud = new JTextField();
    /*All courses components*/
    JButton addStudToCourse = new JButton("Add stud");
    JButton moveStudToCourse = new JButton("Move stud");
    JButton removeStudfromCourse = new JButton("Remove stud");
    /* Add\Remove stud from\to course components*/
    JLabel StudIdL1 = new JLabel("Student ID");
    JLabel StudIdL = new JLabel("Student ID");
    JTextField StudIdT = new JTextField();
    JLabel ARcourseCodeL = new JLabel("course Code");
    JTextField ARcourseCodeT = new JTextField();
    JButton removeB = new JButton("Remove");
    JButton addB = new JButton("add");
    JLabel ARnote = new JLabel("added/removed");

    /*move stud from course components*/
    JLabel fromLabel = new JLabel("From Course");
    JLabel toLabel = new JLabel("To Course");
    JTextField moveStudIdT = new JTextField(10);
    JTextField fromCourseCodeT = new JTextField(10);
    JTextField toCourseCodeT = new JTextField(10);
    JButton moveB = new JButton("move");
    JLabel Mnote = new JLabel("Moved/Not Moved");

    //control system
    JLabel SystemControl = new JLabel("System Control");
    //Change pass and username components
    JTextField oldPass = new JTextField("");
    JPasswordField NewPass = new JPasswordField("");
    JTextField olduser = new JTextField("");
    JTextField newUser = new JTextField("");
    JButton change = new JButton("Change");
    JLabel CNote = new JLabel("Changed / Error");

    /*-------------------------------------------------------------------------Constructor-------------------------------------------------------*/
    public SystemClass() {
        //load from files
        loadStudFromFile();
        loadCourseFromFile();
        loadPassFromFile();
        loadUserFromFile();
        Student.ID = (Allstudents.size());//3melna assign 3ala ID taba3 class student yale huwe static la ysir metel size arraylist te3 students

        /*3malna login hun*/
        Login start = new Login();
        start.setVisible(true);
        setTitle("  University Management System  ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        start.Blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (start.Tpass.getText().equals(pass) && start.Tusername.getText().equalsIgnoreCase(username)) {
                    start.setVisible(false);
                    setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "User/Pass Invalid", "Error Message", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        /*5ulsit login hun*/
        // Create the main content pane with BorderLayout
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

        //design label
        studLabel.setForeground(Color.white);
        courseLabel.setForeground(Color.white);
        functionsLabel.setForeground(Color.white);
        SystemControl.setForeground(Color.white);
        //change button color and size
        addStudButton.setBackground(buttonColor);
        removeStudButton.setBackground(buttonColor);
        infoStudButton.setBackground(buttonColor);
        editStudButton.setBackground(buttonColor);
        addCourseButton.setBackground(buttonColor);
        removeCourseButton.setBackground(buttonColor);
        infoCourseButton.setBackground(buttonColor);
        removeStudfromCourse.setBackground(buttonColor);
        moveStudToCourse.setBackground(buttonColor);
        addStudToCourse.setBackground(buttonColor);
        removeB.setBackground(buttonColor);
        addB.setBackground(buttonColor);
        moveB.setBackground(buttonColor);
        addRemoveButton.setBackground(buttonColor);
        moveStudButton.setBackground(buttonColor);
        fillGradeButton.setBackground(buttonColor);
        okFb.setBackground(buttonColor);
        changeCourse.setBackground(buttonColor);
        ViewGradesButton.setBackground(buttonColor);
        ChangePass_Username.setBackground(buttonColor);
        Logout.setBackground(buttonColor);
        /*all courses design textfields and labels*/
        StudIdT.setFont(new Font("Arial", Font.PLAIN, 14));
        moveStudIdT.setFont(new Font("Arial", Font.PLAIN, 14));
        fromCourseCodeT.setFont(new Font("Arial", Font.PLAIN, 14));
        fromLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        toLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        toCourseCodeT.setFont(new Font("Arial", Font.PLAIN, 14));
        StudIdL.setFont(new Font("Arial", Font.BOLD, 14));
        ARnote.setFont(new Font("Arial", Font.BOLD, 14));
        ARcourseCodeL.setFont(new Font("Arial", Font.BOLD, 14));
        ARcourseCodeT.setFont(new Font("Arial", Font.PLAIN, 14));
        Mnote.setFont(new Font("Arial", Font.BOLD, 14));
        /*Fill grades design textfields and labels*/
        CourseCodeFl.setFont(new Font("Arial", Font.PLAIN, 14));
        CourseCodeFt.setFont(new Font("Arial", Font.PLAIN, 14));

        // Create panel for north and add to it the label welcome and set it to the NORTH position
        sysLabel.setFont(new Font("Arial", Font.BOLD, 19));
        sysLabel.setForeground(Color.white);
        JPanel north = new JPanel(new FlowLayout(1, 1, 1));
        north.add(sysLabel);
        north.setBackground(new Color(58, 135, 173));
        contentPane.add(north, BorderLayout.NORTH);

        // Create a JPanel for the menu buttons on the WEST position
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 1, 0, 1)); // 0 rows, 1 column, vertical spacing of 10 pixels
        menuPanel.setBackground(new Color(58, 135, 173));
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(studLabel);
        menuPanel.add(addStudButton);
        menuPanel.add(removeStudButton);
        menuPanel.add(infoStudButton);
        menuPanel.add(editStudButton);
        menuPanel.add(Box.createVerticalStrut(20));//fara8 ben course w stud
        menuPanel.add(courseLabel);
        menuPanel.add(addCourseButton);
        menuPanel.add(removeCourseButton);
        menuPanel.add(infoCourseButton);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(functionsLabel);
        menuPanel.add(addRemoveButton);
        menuPanel.add(moveStudButton);
        menuPanel.add(fillGradeButton);
        menuPanel.add(ViewGradesButton);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(SystemControl);
        menuPanel.add(ChangePass_Username);
        menuPanel.add(Logout);
        // Add the menuPanel to the WEST position
        contentPane.add(menuPanel, BorderLayout.WEST);

        // Create a JPanel for the center content
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setBackground(Color.WHITE);
        // Add an image of the university to the centerPanel
        //"C:\Users\Admin\Documents\NetBeansProjects\University Management System\UMSbackground.jpg"
        ImageIcon universityImage = new ImageIcon("usal1.jpg"); // Replace with the actual path to the image
        JLabel universityLabel = new JLabel(universityImage);
        centerPanel.add(universityLabel);
        // Add the centerPanel to the CENTER position
        contentPane.add(centerPanel, BorderLayout.CENTER);

        //add student panel
        JPanel northAddS = new JPanel(new FlowLayout());
        JLabel addS = new JLabel("Add Student");
        addS.setFont(new Font("Arial", Font.BOLD, 20));
        addS.setForeground(Color.white);
        northAddS.add(addS);
        northAddS.setBackground(new Color(58, 135, 173));

        northAddS.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel addStud = new JPanel(new BorderLayout());
        addStud.setBorder(new EmptyBorder(25, 15, 25, 15));
        addStud.setBackground(Color.WHITE);
        //grid for data
        JPanel addStudData = new JPanel(new GridLayout(5, 2, 15, 15));
        addStudData.setBorder(new EmptyBorder(30, 15, 30, 15));
        S_ID = new JLabel("");
        JLabel SID = new JLabel("ID");
        JLabel LSName = new JLabel("Name");
        JLabel LSSSN = new JLabel("SSN");
        JLabel LSphone = new JLabel("phone number");
        JLabel LSaddr = new JLabel("Address");

        //design comp
        ButtonaddStud.setBackground(new Color(58, 135, 173));
        ButtonaddStud.setForeground(Color.WHITE);
        ButtonaddStud.setFont(new Font("Arial", Font.BOLD, 20));
        // Additional design for labels
        SID.setFont(new Font("Arial", Font.BOLD, 18));
        LSName.setFont(new Font("Arial", Font.BOLD, 18));
        LSSSN.setFont(new Font("Arial", Font.BOLD, 18));
        LSphone.setFont(new Font("Arial", Font.BOLD, 18));
        LSaddr.setFont(new Font("Arial", Font.BOLD, 18));

        // Additional design for text fields
        S_ID.setFont(new Font("Arial", Font.PLAIN, 18));
        SName.setFont(new Font("Arial", Font.PLAIN, 18));
        SSSN.setFont(new Font("Arial", Font.PLAIN, 18));
        SPhoneNb.setFont(new Font("Arial", Font.PLAIN, 18));
        SAddress.setFont(new Font("Arial", Font.PLAIN, 18));
        addStudData.setBackground(Color.WHITE);
        addStudData.add(LSName);
        addStudData.add(SName);
        addStudData.add(LSSSN);
        addStudData.add(SSSN);
        addStudData.add(LSphone);
        addStudData.add(SPhoneNb);
        addStudData.add(LSaddr);
        addStudData.add(SAddress);
        addStudData.add(AddSNote);
        addStudData.add(ButtonaddStud);
        addStud.add(northAddS, BorderLayout.NORTH);
        addStud.add(addStudData, BorderLayout.CENTER);

  //add course panel
        JPanel northAddC = new JPanel(new FlowLayout());
        JLabel addC = new JLabel("Add Course");
        addC.setFont(new Font("Arial", Font.BOLD, 20));
        addC.setForeground(Color.white);
        northAddC.add(addC);
        northAddC.setBackground(new Color(58, 135, 173));

        northAddC.setBorder(BorderFactory.createLineBorder(Color.black,2));
        JPanel addCourse = new JPanel(new BorderLayout());
        addCourse.setBorder(new EmptyBorder(15, 15, 15, 15));
        addCourse.setBackground(Color.white);
        //grid for data
        JPanel addCourseData = new JPanel(new GridLayout(8, 2, 15, 15));
        addCourseData.setBorder(new EmptyBorder(20, 10, 20, 10));
        addCourseData.setBackground(Color.white);
        
        JLabel CourseCodeL = new JLabel("Course Code");
        JLabel CourseNameL = new JLabel("Course Name");
        JLabel SectionNBL = new JLabel("Number of sec");
        JLabel SectionNBL1 = new JLabel("Number of sec");
        JLabel MaxNbOfStudL1 = new JLabel("Maximum Number of Students");
        JLabel MaxNbOfStudL = new JLabel("Maximum Number of Students");
        JLabel StatusL = new JLabel("Status");
        JLabel weeksNbL = new JLabel("Number of weeks");

        section.add(online);
        section.add(normal);
        section.setBackground(Color.GRAY);
        menu.add(section);
        //design comp
        AddCourseB.setBackground(new Color(58, 135, 173));
        AddCourseB.setForeground(Color.WHITE);
        AddCourseB.setFont(new Font("Arial", Font.BOLD, 16));

        // Additional design for labels
        CourseCodeL.setFont(new Font("Arial", Font.BOLD, 14));
        CourseNameL.setFont(new Font("Arial", Font.BOLD, 14));
        SectionNBL1.setFont(new Font("Arial", Font.BOLD, 14));
        MaxNbOfStudL1.setFont(new Font("Arial", Font.BOLD, 14));
        StatusL.setFont(new Font("Arial", Font.BOLD, 14));

        addCourseNote.setFont(new Font("Arial", Font.BOLD, 14));
        weeksNbL.setFont(new Font("Arial", Font.BOLD, 14));
        // Additional design for text fields
        CCodeT.setFont(new Font("Arial", Font.PLAIN, 14));
        CNameT.setFont(new Font("Arial", Font.PLAIN, 14));
        CSectionNbT.setFont(new Font("Arial", Font.PLAIN, 14));
        CMaxNbOfStudT.setFont(new Font("Arial", Font.PLAIN, 14));
        CStatusT.setFont(new Font("Arial", Font.PLAIN, 14));
        weeksNbT.setFont(new Font("Arial", Font.PLAIN, 14));

        addCourseData.add(CourseCodeL);
        addCourseData.add(CCodeT);
        addCourseData.add(CourseNameL);
        addCourseData.add(CNameT);
        addCourseData.add(StatusL);
        addCourseData.add(menu);
        addCourseData.add(SectionNBL1);
        addCourseData.add(CSectionNbT);
        addCourseData.add(MaxNbOfStudL1);
        addCourseData.add(CMaxNbOfStudT);
        addCourseData.add(weeksNbL);
        addCourseData.add(weeksNbT);
        addCourseData.add(AddCourseB);
        addCourseData.add(addCourseNote);
        addCourse.add(northAddC, BorderLayout.NORTH);
        addCourse.add(addCourseData, BorderLayout.CENTER);

        
        

        // Add\remove stud design
        JPanel addRemove = new JPanel(new BorderLayout(15, 15));
        addRemove.setBackground(Color.WHITE);
        addRemove.setBorder(new EmptyBorder(80, 15, 80, 15));

        
        //addRemove Header panel
        JPanel ARSHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ARSHeader.setBackground(new Color(58, 135, 173));
        ARSHeader.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JLabel ARSheaderLabel = new JLabel("Add / Remove Student to Cousre");
        ARSheaderLabel.setFont(new Font("Arial", Font.BOLD, 20));
        ARSheaderLabel.setForeground(Color.WHITE);
        ARSHeader.add(ARSheaderLabel);
        addRemove.add(ARSHeader, BorderLayout.NORTH);
        // addRemove Data panel 
        JPanel ARSData = new JPanel(new GridLayout(4, 2, 20, 30));
        ARSData.setBackground(Color.WHITE);
        StudIdL1.setFont(new Font("Arial", Font.BOLD, 16));
        ARcourseCodeL.setFont(new Font("Arial", Font.BOLD, 16));
        addB.setBackground(new Color(58, 135, 173));
        addB.setForeground(Color.WHITE);
        removeB.setForeground(Color.WHITE);
        removeB.setFont(new Font("Arial", Font.BOLD, 19));
        removeB.setBackground(new Color(58, 135, 173));
        addB.setFont(new Font("Arial", Font.BOLD, 19));
        ARSData.add(StudIdL1);
        ARSData.add(StudIdT);
        ARSData.add(ARcourseCodeL);
        ARSData.add(ARcourseCodeT);
        ARSData.add(addB);
        ARSData.add(removeB);
        ARSData.add(ARnote);
        addRemove.add(ARSData, BorderLayout.CENTER);

       
//Fill grades

        JPanel fillGrade = new JPanel(new BorderLayout(15, 15));
        fillGrade.setBackground(Color.WHITE);
        fillGrade.setBorder(new EmptyBorder(120, 15, 80, 15));

        //Fill grades HeaderPanel
        JPanel FGSHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        FGSHeader.setBackground(new Color(58, 135, 173));
        FGSHeader.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JLabel FGSheaderLabel = new JLabel("Fill Grades of Student");
        FGSheaderLabel.setFont(new Font("Arial", Font.BOLD, 30));
        FGSheaderLabel.setForeground(Color.WHITE);
        FGSHeader.add(FGSheaderLabel);
        fillGrade.add(FGSHeader, BorderLayout.NORTH);
        //Fill grades Data panel 
        JPanel FGData = new JPanel(new GridLayout(2, 2, 40, 30));
        FGData.setBackground(Color.WHITE);
        CourseCodeFl.setFont(new Font("Arial", Font.BOLD, 22));
        CourseCodeFt.setFont(new Font("Arial", Font.BOLD, 22));
        okFb.setFont(new Font("Arial", Font.BOLD, 20));
        changeCourse.setFont(new Font("Arial", Font.BOLD, 20));

        okFb.setBackground(new Color(58, 135, 173));
        okFb.setForeground(Color.WHITE);
        changeCourse.setBackground(new Color(58, 135, 173));
        changeCourse.setForeground(Color.WHITE);
        FGData.add(CourseCodeFl);
        FGData.add(CourseCodeFt);
        FGData.add(okFb);
        FGData.add(changeCourse);
        FGData.setBorder(new EmptyBorder(50,30,100,30));
        
        fillGrade.add(FGData, BorderLayout.CENTER);

        
 // MoveStudFromCourse data panel
        JPanel MoveStudFromCourse = new JPanel(new BorderLayout(15, 15));
        MoveStudFromCourse.setBackground(Color.WHITE);
        MoveStudFromCourse.setBorder(new EmptyBorder(80, 15, 80, 15));

        // MoveStudFromCourse Header panel
        JPanel MoveStudFromCourseHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        MoveStudFromCourseHeader.setBackground(new Color(58, 135, 173));
        MoveStudFromCourseHeader.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JLabel MoveStudFromCourseHeaderl = new JLabel("Move Student");
        MoveStudFromCourseHeaderl.setFont(new Font("Arial", Font.BOLD, 20));
        MoveStudFromCourseHeaderl.setForeground(Color.WHITE);
        MoveStudFromCourseHeader.add(MoveStudFromCourseHeaderl);
        MoveStudFromCourse.add(MoveStudFromCourseHeader, BorderLayout.NORTH);
        
        JPanel MSData = new JPanel(new GridLayout(4, 2, 50, 30));
        MSData.setBackground(Color.WHITE);
        fromLabel.setFont(new Font("Arial", Font.BOLD, 16));
        toLabel.setFont(new Font("Arial", Font.BOLD, 16));
        StudIdL.setFont(new Font("Arial", Font.BOLD, 16));
        moveB.setForeground(Color.WHITE);
        moveB.setFont(new Font("Arial", Font.BOLD, 20));
        moveB.setBackground(new Color(58, 135, 173));
        MSData.add(StudIdL);
        MSData.add(moveStudIdT);
        moveStudIdT.setText("");
        MSData.add(fromLabel);
        MSData.add(fromCourseCodeT);
        MSData.add(toLabel);
        MSData.add(toCourseCodeT);
        MSData.add(moveB);
        MSData.add(Mnote);
        MoveStudFromCourse.add(MSData, BorderLayout.CENTER);
        
 // RemoveSTUD Data panel
   // remove student design
        JPanel removeStud = new JPanel(new BorderLayout(15, 15));
        removeStud.setBackground(Color.WHITE);
        removeStud.setBorder(new EmptyBorder(120, 15, 120, 15));
   // Remove stud Header panel
        JPanel RSHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        RSHeader.setBackground(new Color(58, 135, 173));
        RSHeader.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        JLabel RSheaderLabel = new JLabel("Remove Student");
        RSheaderLabel.setFont(new Font("Arial", Font.BOLD, 30));
        RSheaderLabel.setForeground(Color.WHITE);
        RSHeader.add(RSheaderLabel);
        removeStud.add(RSHeader, BorderLayout.NORTH);
        
        JPanel RSData = new JPanel(new GridLayout(2, 2, 20, 30));
        RSData.setBorder(new EmptyBorder(30,20,100,20));
        RSData.setBackground(Color.WHITE);
        JLabel RSID = new JLabel("Student  ID");
        RS_ID.setFont(new Font("Arial", Font.BOLD, 16));
        RSID.setFont(new Font("Arial", Font.BOLD, 20));
        RSButton.setBackground(new Color(58, 135, 173));
        RSButton.setForeground(Color.WHITE);
        RSNote.setFont(new Font("Arial", Font.BOLD, 20));
        RSNote.setForeground(Color.RED);
        RSData.add(RSID);
        RSData.add(RS_ID);
        RSData.add(RSButton);
        RSData.add(RSNote);

        removeStud.add(RSData, BorderLayout.CENTER);

   // RemoveCourse Data panel
   
        // RemoveCourse Header panel
        JPanel removeCourse = new JPanel(new BorderLayout(15, 15));
        removeCourse.setBackground(Color.WHITE);

        JPanel RCHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        RCHeader.setBackground(new Color(58, 135, 173));
        RCHeader.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        JLabel RCheaderLabel = new JLabel("Remove Course");
        RCheaderLabel.setFont(new Font("Arial", Font.BOLD, 25));
        RCheaderLabel.setForeground(Color.WHITE);
        RCHeader.add(RCheaderLabel);
        removeCourse.add(RCHeader, BorderLayout.NORTH);
        
        JPanel RCData = new JPanel(new GridLayout(2, 2, 40, 30));
        RCData.setBackground(Color.WHITE);
        RCData.setBorder(new EmptyBorder(50,20,100,20));
        RCData.setBackground(Color.white);
        JLabel RCCode = new JLabel("Course Code");
        RC_Code.setFont(new Font("Arial", Font.BOLD, 20));
        RCCode.setFont(new Font("Arial", Font.BOLD, 16));

        RCButton.setBackground(new Color(58, 135, 173));
        RCButton.setForeground(Color.WHITE);

        RCNote.setFont(new Font("Arial", Font.BOLD, 20));
        RCNote.setForeground(Color.RED);

        RCData.add(RCCode);
        RCData.add(RC_Code);
        RCData.add(RCButton);
        RCData.add(RCNote);

        removeCourse.setBorder(new EmptyBorder(120, 15, 100, 15));
        removeCourse.add(RCData, BorderLayout.CENTER);
    //Student infoDesign
        JLabel ISIDL = new JLabel("   ID");
        JLabel ISNameL = new JLabel("   Name");
        JLabel ISSSNL = new JLabel("   SSN");
        JLabel ISPhoneL = new JLabel("   Phone Number");
        JLabel ISAddressL = new JLabel("   Address");
        //JLabel ISCourseL = new JLabel("   Courses Reg:");

        JPanel InfoStud = new JPanel(new BorderLayout());
        JPanel ISHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ISHeader.setBackground(new Color(58, 135, 173));
        ISHeader.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JLabel ISheaderLabel = new JLabel("Info Student");
        ISheaderLabel.setFont(new Font("Arial", Font.BOLD, 25));
        ISheaderLabel.setForeground(Color.WHITE);
        ISHeader.add(ISheaderLabel);
        InfoStud.add(ISHeader, BorderLayout.NORTH);

        ISIDL.setFont(new Font("Arial", Font.BOLD, 20));
        ISNameL.setFont(new Font("Arial", Font.BOLD, 20));
        ISSSNL.setFont(new Font("Arial", Font.BOLD, 20));
        ISPhoneL.setFont(new Font("Arial", Font.BOLD, 20));
        ISAddressL.setFont(new Font("Arial", Font.BOLD, 20));
        // ISCourseL.setFont(new Font("Arial", Font.BOLD, 12));

        ISID.setFont(new Font("Arial", Font.BOLD, 17));
        ISName.setFont(new Font("Arial", Font.BOLD, 17));
        ISSSN.setFont(new Font("Arial", Font.BOLD, 17));
        ISPhoneNb.setFont(new Font("Arial", Font.BOLD, 17));
        ISAddress.setFont(new Font("Arial", Font.BOLD, 17));
        // IScourses.setFont(new Font("Arial", Font.BOLD, 12));

        ButtonInfoStud.setBackground(new Color(58, 135, 173));
        ButtonInfoStud.setForeground(Color.WHITE);
        ButtonInfoStud.setFont(new Font("Arial", Font.BOLD, 20));

        ISName.setEditable(false);
        ISSSN.setEditable(false);
        ISPhoneNb.setEditable(false);
        ISAddress.setEditable(false);

        JPanel ISCenter = new JPanel(new GridLayout(6, 2, 2, 10));
        ISCenter.add(ISIDL);
        ISCenter.add(ISID);
        ISCenter.add(ISNameL);
        ISCenter.add(ISName);
        ISCenter.add(ISSSNL);
        ISCenter.add(ISSSN);
        ISCenter.add(ISPhoneL);
        ISCenter.add(ISPhoneNb);
        ISCenter.add(ISAddressL);
        ISCenter.add(ISAddress);
        // ISCenter.add(ISCourseL);
        // ISCenter.add(IScourses);
        ISCenter.setBorder(new EmptyBorder(20, 15, 20, 10));
        ISCenter.setBackground(Color.white);
        InfoStud.add(ISCenter, BorderLayout.CENTER);
        InfoStud.setBackground(Color.WHITE);
        JPanel ISSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ISSouth.setBackground(Color.WHITE);
        ISSouth.add(ButtonInfoStud);
        InfoStud.add(ISSouth, BorderLayout.SOUTH);
        InfoStud.setBorder(new EmptyBorder(35, 7, 20, 7));

//Course info
        JLabel ICCodeL = new JLabel("Course Code");
        JLabel ICNameL = new JLabel(" Name");
        JLabel ICMaxNBOfStudL = new JLabel("Maximum Number of Students");
        JLabel ICStudEnrolledL = new JLabel("Students Enrolled");
        JLabel ICStatusL = new JLabel("Status");
        JLabel NbRegStudL = new JLabel("Number of Regestered Students");
        JLabel AverageGradeL = new JLabel("Average Grade");
        JPanel InfoCourse = new JPanel(new BorderLayout());
        JPanel ICHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ICHeader.setBackground(new Color(58, 135, 173));
        ICHeader.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JLabel ICheaderLabel = new JLabel("Info Course");
        ICheaderLabel.setFont(new Font("Arial", Font.BOLD, 20));

        ICheaderLabel.setForeground(Color.WHITE);
        ICHeader.add(ICheaderLabel);
        InfoCourse.add(ICHeader, BorderLayout.NORTH);
        ICMaxNBOfStudL.setFont(new Font("Arial", Font.BOLD, 15));
        ICStatusT.setFont(new Font("Arial", Font.BOLD, 15));
        MaxNbOfStudT.setFont(new Font("Arial", Font.BOLD, 15));
        SectionNBT.setFont(new Font("Arial", Font.BOLD, 15));
        NbRegStudL.setFont(new Font("Arial", Font.BOLD, 16));
        NbRegStud.setFont(new Font("Arial", Font.BOLD, 15));
        ICCodeL.setFont(new Font("Arial", Font.BOLD, 16));
        ICNameL.setFont(new Font("Arial", Font.BOLD, 16));
        ICStatusL.setFont(new Font("Arial", Font.BOLD, 16));
        ICStudEnrolledL.setFont(new Font("Arial", Font.BOLD, 16));
        AverageGradeL.setFont(new Font("Arial", Font.BOLD, 16));
        AverageGradeT.setFont(new Font("Arial", Font.BOLD, 15));
        CourseCodeT.setFont(new Font("Arial", Font.BOLD, 15));
        CourseNameT.setFont(new Font("Arial", Font.BOLD, 15));
        CourseCodeL.setFont(new Font("Arial", Font.BOLD, 16));
        CourseNameL.setFont(new Font("Arial", Font.BOLD, 16));
        SectionNBL.setFont(new Font("Arial", Font.BOLD, 16));
        MaxNbOfStudL.setFont(new Font("Arial", Font.BOLD, 16));
        CourseNameT.setEditable(false);
        ICStatusT.setEditable(false);
        SectionNBT.setEditable(false);
        MaxNbOfStudT.setEditable(false);
        AverageGradeT.setEditable(false);
        NbRegStud.setEditable(false);
        CourseInfoB.setBackground(new Color(58, 135, 173));
        CourseInfoB.setForeground(Color.WHITE);
        CourseInfoB.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel ICCenter = new JPanel(new GridLayout(7, 2, 4, 4));
        ICCenter.setBackground(Color.white);
        ICCenter.add(ICCodeL);
        ICCenter.add(CourseCodeT);
        ICCenter.add(ICNameL);
        ICCenter.add(CourseNameT);
        ICCenter.add(ICStatusL);
        ICCenter.add(ICStatusT);
        ICCenter.add(SectionNBL);
        ICCenter.add(SectionNBT);
        ICCenter.add(MaxNbOfStudL);
        ICCenter.add(MaxNbOfStudT);
        ICCenter.add(NbRegStudL);
        ICCenter.add(NbRegStud);
        ICCenter.add(AverageGradeL);
        ICCenter.add(AverageGradeT);

        ICCenter.setBorder(new EmptyBorder(10, 10, 10, 10));
        InfoCourse.add(ICCenter, BorderLayout.CENTER);

        JPanel ICSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ICSouth.setBackground(Color.white);
        InfoCourse.setBackground(Color.white);
        ICSouth.add(CourseInfoB);
        InfoCourse.add(ICSouth, BorderLayout.SOUTH);
        InfoCourse.setBorder(new EmptyBorder(15, 10, 15, 10));

        //Edit Student info design
        JLabel ESIDL = new JLabel("ID");
        JLabel ESPhoneL = new JLabel("Phone Number");
        JLabel ESAddressL = new JLabel("Address");

        ESIDL.setFont(new Font("Arial", Font.BOLD, 20));
        ESPhoneL.setFont(new Font("Arial", Font.BOLD, 20));
        ESAddressL.setFont(new Font("Arial", Font.BOLD, 20));
        ButtonEditStud.setBackground(new Color(58, 135, 173));
        ButtonEditStud.setForeground(Color.white);
        ButtonEditStud.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel EditStud = new JPanel(new BorderLayout());
        
        EditStud.setBackground(Color.WHITE);
        JPanel ESNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel ESNL = new JLabel("Edit Student Info");
        ESNL.setFont(new Font("Arial", Font.BOLD, 25));
        ESNL.setForeground(Color.WHITE);
        ESNorth.add(ESNL);
        ESNorth.setBackground(new Color(58, 135, 173));
        ESNorth.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        EditStud.add(ESNorth, BorderLayout.NORTH);

        JPanel ESCenter = new JPanel(new GridLayout(4, 2, 5, 20));
        ESID.setFont(new Font("Arial", Font.BOLD, 20));
        ESPhone.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
        ESAddress.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
        
        ESCenter.add(ESIDL);
        ESCenter.add(ESID);
        ESCenter.add(ESPhoneL);
        ESCenter.add(ESPhone);
        ESCenter.add(ESAddressL);
        ESCenter.add(ESAddress);
        ESCenter.add(ESNote);
        ESCenter.add(ButtonEditStud);
        ESCenter.setBackground(Color.WHITE);
        ESCenter.setBorder(new EmptyBorder(40, 10, 70, 10));
        EditStud.add(ESCenter, BorderLayout.CENTER);

        EditStud.setBorder(new EmptyBorder(30, 15, 50, 15));

        JPanel ViewGrades = new JPanel(new BorderLayout(15, 15));
        ViewGrades.setBackground(Color.WHITE);
        ViewGrades.setBorder(new EmptyBorder(80, 15, 80, 15));

   //View Grades
        //View grades HeaderPanel
        JPanel VGHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        VGHeader.setBackground(new Color(58, 135, 173));
        VGHeader.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JLabel VGheaderLabel = new JLabel("View Grades of Students in Course");
        VGheaderLabel.setFont(new Font("Arial", Font.BOLD, 30));
        VGheaderLabel.setForeground(Color.WHITE);
        VGHeader.add(VGheaderLabel);
        ViewGrades.add(VGHeader, BorderLayout.NORTH);
        //View grades Data panel 
        JPanel VGData = new JPanel(new GridLayout(2, 2, 20, 30));
        VGData.setBackground(Color.WHITE);
        CourseCodeVGT.setFont(new Font("Arial", Font.BOLD, 22));
        CourseCodeVGL.setFont(new Font("Arial", Font.BOLD, 20));
        okVGB.setFont(new Font("Arial", Font.BOLD, 20));
        changeCourseVGB.setFont(new Font("Arial", Font.BOLD, 20));
        VGData.setBorder(new EmptyBorder(50,30,120,30));
        
        okVGB.setBackground(new Color(58, 135, 173));
        okVGB.setForeground(Color.WHITE);
        changeCourseVGB.setBackground(new Color(58, 135, 173));
        changeCourseVGB.setForeground(Color.WHITE);
        VGData.add(CourseCodeVGL);
        VGData.add(CourseCodeVGT);
        VGData.add(okVGB);
        VGData.add(changeCourseVGB);

        ViewGrades.add(VGData, BorderLayout.CENTER);

   //change Pass and Email design panel
        JPanel ChangepassUser = new JPanel(new BorderLayout());
        //Header
        JPanel CPUHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        CPUHeader.setBackground(new Color(58, 135, 173));
        CPUHeader.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JLabel CPUheaderLabel = new JLabel("Change Password and Username");
        CPUheaderLabel.setFont(new Font("Arial", Font.BOLD, 20));
        CPUheaderLabel.setForeground(Color.WHITE);
        CPUHeader.add(CPUheaderLabel);
        ChangepassUser.add(CPUHeader, BorderLayout.NORTH);

        change.setBackground(new Color(58, 135, 173));
        change.setForeground(Color.WHITE);
        JLabel oldPassL = new JLabel("Old Password");
        JLabel newPassL = new JLabel("New Password");
        JLabel oldUserL = new JLabel("Old Username");
        JLabel newUserL = new JLabel("New UserName");

        oldPassL.setFont(new Font("Arial", Font.BOLD, 18));
        newPassL.setFont(new Font("Arial", Font.BOLD, 18));
        oldUserL.setFont(new Font("Arial", Font.BOLD, 18));
        newUserL.setFont(new Font("Arial", Font.BOLD, 18));
        
        newUser.setFont(new Font("Arial", Font.BOLD, 18));
        oldPass.setFont(new Font("Arial", Font.BOLD, 18));
        NewPass.setFont(new Font("Arial", Font.BOLD, 18));
        olduser.setFont(new Font("Arial", Font.BOLD, 18));
        
        change.setFont(new Font("Arial", Font.BOLD, 18));

        //center
        JPanel CPUCenter = new JPanel(new GridLayout(5, 2, 10, 10));
        CPUCenter.setBackground(Color.WHITE);
        CPUCenter.add(oldPassL);
        CPUCenter.add(oldPass);
        CPUCenter.add(newPassL);
        CPUCenter.add(NewPass);
        CPUCenter.add(oldUserL);
        CPUCenter.add(olduser);
        CPUCenter.add(newUserL);
        CPUCenter.add(newUser);
        CPUCenter.add(CNote);
        CPUCenter.add(change);
        CPUCenter.setBorder(new EmptyBorder(25, 15, 25, 15));
        ChangepassUser.add(CPUCenter, BorderLayout.CENTER);

        ChangepassUser.setBorder(new EmptyBorder(40, 20, 40, 20));
        ChangepassUser.setBackground(Color.WHITE);
        //Events (tana2ol ben panels)
        ChangePass_Username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoStud.setVisible(false);
                addCourse.setVisible(false);
                InfoCourse.setVisible(false);
                removeCourse.setVisible(false);
                centerPanel.setVisible(false);
                EditStud.setVisible(false);
                removeStud.setVisible(false);
                addRemove.setVisible(false);
                MoveStudFromCourse.setVisible(false);
                fillGrade.setVisible(false);
                addStud.setVisible(false);
                ViewGrades.setVisible(false);
                ChangepassUser.setVisible(true);
                contentPane.add(ChangepassUser, BorderLayout.CENTER);
            }
        });

        ViewGradesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoStud.setVisible(false);
                addCourse.setVisible(false);
                InfoCourse.setVisible(false);
                removeCourse.setVisible(false);
                centerPanel.setVisible(false);
                EditStud.setVisible(false);
                removeStud.setVisible(false);
                addRemove.setVisible(false);
                MoveStudFromCourse.setVisible(false);
                fillGrade.setVisible(false);
                addStud.setVisible(false);
                ChangepassUser.setVisible(false);
                ViewGrades.setVisible(true);
                contentPane.add(ViewGrades, BorderLayout.CENTER);
            }
        });

        addStudButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoStud.setVisible(false);
                addCourse.setVisible(false);
                InfoCourse.setVisible(false);
                removeCourse.setVisible(false);
                centerPanel.setVisible(false);
                EditStud.setVisible(false);
                removeStud.setVisible(false);
                addRemove.setVisible(false);
                MoveStudFromCourse.setVisible(false);
                fillGrade.setVisible(false);
                ViewGrades.setVisible(false);
                ChangepassUser.setVisible(false);
                addStud.setVisible(true);
                contentPane.add(addStud, BorderLayout.CENTER);
            }
        });
        removeStudButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoStud.setVisible(false);
                addCourse.setVisible(false);
                InfoCourse.setVisible(false);
                removeCourse.setVisible(false);
                addStud.setVisible(false);
                centerPanel.setVisible(false);
                EditStud.setVisible(false);
                addRemove.setVisible(false);
                MoveStudFromCourse.setVisible(false);
                fillGrade.setVisible(false);
                ViewGrades.setVisible(false);
                ChangepassUser.setVisible(false);
                removeStud.setVisible(true);
                contentPane.add(removeStud, BorderLayout.CENTER);
            }
        });

        removeCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoStud.setVisible(false);
                centerPanel.setVisible(false);
                removeStud.setVisible(false);
                EditStud.setVisible(false);
                addCourse.setVisible(false);
                InfoCourse.setVisible(false);
                addStud.setVisible(false);
                addRemove.setVisible(false);
                MoveStudFromCourse.setVisible(false);
                fillGrade.setVisible(false);
                ViewGrades.setVisible(false);
                ChangepassUser.setVisible(false);
                removeCourse.setVisible(true);

                contentPane.add(removeCourse, BorderLayout.CENTER);
            }
        });
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoStud.setVisible(false);
                centerPanel.setVisible(false);
                removeStud.setVisible(false);
                EditStud.setVisible(false);
                addStud.setVisible(false);
                InfoCourse.setVisible(false);
                removeCourse.setVisible(false);
                addRemove.setVisible(false);
                MoveStudFromCourse.setVisible(false);
                fillGrade.setVisible(false);
                ViewGrades.setVisible(false);
                ChangepassUser.setVisible(false);
                addCourse.setVisible(true);

                contentPane.add(addCourse, BorderLayout.CENTER);
            }
        });
        addRemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerPanel.setVisible(false);
                removeStud.setVisible(false);
                addStud.setVisible(false);
                EditStud.setVisible(false);
                addCourse.setVisible(false);
                InfoCourse.setVisible(false);
                removeCourse.setVisible(false);
                InfoStud.setVisible(false);
                MoveStudFromCourse.setVisible(false);
                fillGrade.setVisible(false);
                ViewGrades.setVisible(false);
                ChangepassUser.setVisible(false);
                addRemove.setVisible(true);
                contentPane.add(addRemove, BorderLayout.CENTER);
            }
        });

        changeCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CourseCodeFt.setEditable(true);
            }
        });

        moveStudButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerPanel.setVisible(false);
                removeStud.setVisible(false);
                addStud.setVisible(false);
                EditStud.setVisible(false);
                addCourse.setVisible(false);
                InfoCourse.setVisible(false);
                removeCourse.setVisible(false);
                addRemove.setVisible(false);
                InfoStud.setVisible(false);
                fillGrade.setVisible(false);
                ViewGrades.setVisible(false);
                ChangepassUser.setVisible(false);
                MoveStudFromCourse.setVisible(true);
                contentPane.add(MoveStudFromCourse, BorderLayout.CENTER);
            }
        });
        infoStudButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerPanel.setVisible(false);
                removeStud.setVisible(false);
                addStud.setVisible(false);
                EditStud.setVisible(false);
                addCourse.setVisible(false);
                InfoCourse.setVisible(false);
                removeCourse.setVisible(false);
                addRemove.setVisible(false);
                MoveStudFromCourse.setVisible(false);
                fillGrade.setVisible(false);
                ViewGrades.setVisible(false);
                ChangepassUser.setVisible(false);
                InfoStud.setVisible(true);
                contentPane.add(InfoStud, BorderLayout.CENTER);
            }
        });
        editStudButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerPanel.setVisible(false);
                removeStud.setVisible(false);
                addStud.setVisible(false);
                addCourse.setVisible(false);
                InfoCourse.setVisible(false);
                removeCourse.setVisible(false);
                InfoStud.setVisible(false);
                addRemove.setVisible(false);
                MoveStudFromCourse.setVisible(false);
                fillGrade.setVisible(false);
                ViewGrades.setVisible(false);
                ChangepassUser.setVisible(false);
                EditStud.setVisible(true);
                contentPane.add(EditStud, BorderLayout.CENTER);
            }
        });

        infoCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoStud.setVisible(false);
                centerPanel.setVisible(false);
                removeStud.setVisible(false);
                addStud.setVisible(false);
                addCourse.setVisible(false);
                removeCourse.setVisible(false);
                EditStud.setVisible(false);
                addRemove.setVisible(false);
                MoveStudFromCourse.setVisible(false);
                fillGrade.setVisible(false);
                ViewGrades.setVisible(false);
                ChangepassUser.setVisible(false);
                InfoCourse.setVisible(true);
                contentPane.add(InfoCourse, BorderLayout.CENTER);
            }
        });
        fillGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoStud.setVisible(false);
                centerPanel.setVisible(false);
                removeStud.setVisible(false);
                addStud.setVisible(false);
                addCourse.setVisible(false);
                removeCourse.setVisible(false);
                EditStud.setVisible(false);
                addRemove.setVisible(false);
                MoveStudFromCourse.setVisible(false);
                InfoCourse.setVisible(false);
                ViewGrades.setVisible(false);
                ChangepassUser.setVisible(false);
                fillGrade.setVisible(true);
                contentPane.add(fillGrade, BorderLayout.CENTER);
            }
        });

        Logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoStud.setVisible(false);
                centerPanel.setVisible(false);
                removeStud.setVisible(false);
                addStud.setVisible(false);
                addCourse.setVisible(false);
                removeCourse.setVisible(false);
                EditStud.setVisible(false);
                addRemove.setVisible(false);
                MoveStudFromCourse.setVisible(false);
                InfoCourse.setVisible(false);
                ViewGrades.setVisible(false);
                fillGrade.setVisible(false);
                ChangepassUser.setVisible(false);
                setVisible(false);
                start.setVisible(true);
                start.Tpass.setText("");
                start.Tusername.setText("");

                //contentPane.add(fillGrade, BorderLayout.CENTER);
            }
        });
        //ACTION LISTENER OF INTERIOR BUTTONS

        /*add student button*/
        ButtonaddStud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SName.getText().equals("") || SPhoneNb.getText().equals("") || SAddress.getText().equals("") || SSSN.getText().equals("")) {
                    AddSNote.setText("Enter All the Information");
                }

                int SSN = 0;
                int regStud = -1;
                if (!Allstudents.isEmpty()) {
                    for (int i = 0; i < Allstudents.size(); i++) {
                        if (Allstudents.get(i).SSN == Integer.parseInt(SSSN.getText())) {
                            SSN = Allstudents.get(i).SSN;
                            regStud = i;
                            break;
                        }
                    }
                }
                if (SSN == 0) {
                    if (SName.getText().equals("") || SPhoneNb.getText().equals("") || SAddress.getText().equals("") || SSSN.getText().equals("")) {
                        AddSNote.setText("Enter All the Information");
                        AddSNote.setForeground(new Color(200, 1, 1));
                        AddSNote.setFont(new Font("Arial", Font.BOLD, 18));
                    } else {
                        Allstudents.add(new Student(SName.getText(), SPhoneNb.getText(), SAddress.getText(), Integer.parseInt(SSSN.getText())));
                        AddSNote.setText("Added" + " with ID: " + (Student.ID - 1));
                        AddSNote.setForeground(new Color(1, 100, 30));
                        AddSNote.setFont(new Font("Arial", Font.BOLD, 18));
                    }
                } else {
                    AddSNote.setText("Student already exist with ID: " + Allstudents.get(regStud).SID);
                    AddSNote.setForeground(new Color(200, 1, 1));
                    AddSNote.setFont(new Font("Arial", Font.BOLD, 18));
                }
            }

        });
        /*remove stud button*/
        RSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RSNote.setText("No Students");
                for (int i = 0; i < Allstudents.size(); i++) {
                    if ((Integer.parseInt(RS_ID.getText())) == Allstudents.get(i).SID) {
                        Allstudents.remove(i);
                        RSNote.setText("Removed");
                        break;
                    } else {
                        RSNote.setText("Not Found");
                    }
                }
            }
        });
        /*info stud button*/
        ButtonInfoStud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ISID.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Student ID", "Missing entering ID", JOptionPane.WARNING_MESSAGE);

                }
                int sIndex = -1;
                if (!Allstudents.isEmpty()) {
                    for (int i = 0; i < Allstudents.size(); i++) {
                        if (Allstudents.get(i).SID == Integer.parseInt(ISID.getText())) {
                            sIndex = i;
                            break;
                        }
                    }
                }
                if (sIndex != -1) {
                    ISName.setText(Allstudents.get(sIndex).Sname);
                    ISSSN.setText(Integer.toString(Allstudents.get(sIndex).SSN));
                    ISPhoneNb.setText(Allstudents.get(sIndex).SphoneNb);
                    ISAddress.setText(Allstudents.get(sIndex).Saddress);
                    //add method courses later

                } else {
                    JOptionPane.showMessageDialog(null, "Student Not Found", "Error", JOptionPane.WARNING_MESSAGE);
                    ISName.setText("");
                    ISSSN.setText("");
                    ISPhoneNb.setText("");
                    ISAddress.setText("");
                }

            }
        });
        /*edit stud button*/
        ButtonEditStud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ESID.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Student ID", "Missing entering ID", JOptionPane.WARNING_MESSAGE);
                } else {
                    for (int i = 0; i < Allstudents.size(); i++) {
                        if (Integer.parseInt(ESID.getText()) == Allstudents.get(i).SID) {
                            if (ESAddress.getText().equals("") || ESPhone.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Enter Student Information", "Missing entering All information", JOptionPane.WARNING_MESSAGE);
                                break;
                            } else {
                                Allstudents.get(i).Saddress = ESAddress.getText();
                                Allstudents.get(i).SphoneNb = ESPhone.getText();
                                ESNote.setText("Succefully changed");
                                ESNote.setForeground(new Color(1, 100, 30));
                                ESNote.setFont(new Font("Arial", Font.BOLD, 14));
                                break;
                            }
                        } else {
                            ESNote.setText("Wrong ID / not found");
                            ESNote.setForeground(new Color(200, 1, 1));
                            ESNote.setFont(new Font("Arial", Font.BOLD, 14));
                            ESAddress.setText("");
                            ESPhone.setText("");
                        }
                    }
                }
            }
        });
        /*online course section menu*/
        online.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                section.setText("online");
            }
        });

        /*normal course section menu*/
        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                section.setText("normal");
            }
        });
        /**/

// add action listeners to the buttons
        // Add & remove Stud to course
        addB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cIndex = 0, sIndex = -1;
                for (int i = 0; i < Allcourses.size(); i++) {
                    if (Allcourses.get(i).Course_code.equalsIgnoreCase(ARcourseCodeT.getText())) {
                        cIndex = i;
                        break;
                    }
                }
                for (int i = 0; i < Allstudents.size(); i++) {
                    if (Integer.parseInt(StudIdT.getText()) == Allstudents.get(i).SID) {
                        sIndex = i;
                        break;
                    }
                }
                if (cIndex != 0 && sIndex != -1) {
                    if (((CourseSection) Allcourses.get(cIndex)).checkStudent(Allstudents.get(sIndex))) {
                        ARnote.setText(Allstudents.get(sIndex).Sname + " Already in " + Allcourses.get(cIndex).Course_name);
                        ARnote.setForeground(new Color(200, 1, 1));
                        ARnote.setFont(new Font("Arial", Font.BOLD, 14));
                    } else {
                        int maxNb = ((CourseSection) Allcourses.get(cIndex)).Section_maxNbStud;
                        int regNb = ((CourseSection) Allcourses.get(cIndex)).regStud_course.size();
                        if (regNb < maxNb) {
                            ((CourseSection) Allcourses.get(cIndex)).regStud_course.add(Allstudents.get(sIndex));
                            // Allstudents.get(sIndex).courses.add((CourseSection) Allcourses.get(cIndex));
                            ARnote.setText(Allstudents.get(sIndex).Sname + " Added to " + Allcourses.get(cIndex).Course_code);
                            ARnote.setForeground(new Color(1, 100, 30));
                            ARnote.setFont(new Font("Arial", Font.BOLD, 14));
                        } else {
                            ARnote.setText("Course is full!");
                            ARnote.setForeground(new Color(200, 1, 1));
                            ARnote.setFont(new Font("Arial", Font.BOLD, 14));
                        }

                    }
                } else if (cIndex == 0) {
                    ARnote.setText(ARcourseCodeT.getText() + " Not Found");
                    ARnote.setForeground(new Color(200, 1, 1));
                    ARnote.setFont(new Font("Arial", Font.BOLD, 14));
                } else if (sIndex == -1) {
                    ARnote.setText(StudIdT.getText() + " Not Found");
                    ARnote.setForeground(new Color(200, 1, 1));
                    ARnote.setFont(new Font("Arial", Font.BOLD, 14));
                } else {
                    ARnote.setText("Something went wrong!!!");
                    ARnote.setForeground(new Color(200, 1, 1));
                    ARnote.setFont(new Font("Arial", Font.BOLD, 14));
                }
            }
        });
        removeB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int cIndex = 0, sIndex = -1;

                for (int i = 0; i < Allcourses.size(); i++) {
                    if (Allcourses.get(i).Course_code.equalsIgnoreCase(ARcourseCodeT.getText())) {
                        cIndex = i;
                        break;
                    }
                }
                for (int i = 0; i < Allstudents.size(); i++) {
                    if (Integer.parseInt(StudIdT.getText()) == Allstudents.get(i).SID) {
                        sIndex = i;
                        break;
                    }
                }
                if (cIndex != 0 && sIndex != -1) {
                    if (((CourseSection) Allcourses.get(cIndex)).checkStudent(Allstudents.get(sIndex))) {
                        ((CourseSection) Allcourses.get(cIndex)).remove_student(Allstudents.get(sIndex));
//                        Allstudents.get(sIndex).courses.remove((CourseSection) Allcourses.get(cIndex));
                        ARnote.setText(Allstudents.get(sIndex).Sname + " removed from " + Allcourses.get(cIndex).Course_name);
                        ARnote.setForeground(new Color(1, 100, 30));
                        ARnote.setFont(new Font("Arial", Font.BOLD, 14));
                    } else {
                        ARnote.setText(Allstudents.get(sIndex).Sname + " not in " + Allcourses.get(cIndex).Course_name);
                        ARnote.setForeground(new Color(200, 1, 1));
                        ARnote.setFont(new Font("Arial", Font.BOLD, 14));
                    }
                } else if (cIndex == 0) {
                    ARnote.setText(ARcourseCodeT.getText() + " Not Found");
                    ARnote.setForeground(new Color(200, 1, 1));
                    ARnote.setFont(new Font("Arial", Font.BOLD, 14));
                    System.out.println("course not found");
                } else if (sIndex == -1) {
                    ARnote.setText(StudIdT.getText() + " Not Found");
                    ARnote.setForeground(new Color(200, 1, 1));
                    ARnote.setFont(new Font("Arial", Font.BOLD, 14));
                    System.out.println("stud not found");
                }
            }
        });
        moveB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean EmptyID = false;

                if (moveStudIdT.getText().equals("")) {
                    EmptyID = true;
                    Mnote.setText("Enter Student ID");
                    Mnote.setForeground(new Color(200, 1, 1));
                    Mnote.setFont(new Font("Arial", Font.BOLD, 14));
                }
                int fromCourseIndex = 0, sIndex = -1, toCourseIndex = 0;
                for (int i = 0; i < Allcourses.size(); i++) {
                    if (fromCourseCodeT.getText().equalsIgnoreCase(Allcourses.get(i).Course_code)) {
                        fromCourseIndex = i;
                        break;
                    }
                }
                for (int i = 0; i < Allcourses.size(); i++) {
                    if (toCourseCodeT.getText().equalsIgnoreCase(Allcourses.get(i).Course_code)) {
                        toCourseIndex = i;
                        break;
                    }
                }
                for (int i = 0; i < Allstudents.size(); i++) {

                    if (!Allstudents.isEmpty()) {
                        if (Integer.parseInt(moveStudIdT.getText()) == Allstudents.get(i).SID) {
                            sIndex = i;
                            break;
                        }
                    }
                }

                if (sIndex == -1) {
                    Mnote.setText("No Student Found");
                    Mnote.setForeground(new Color(200, 1, 1));
                    Mnote.setFont(new Font("Arial", Font.BOLD, 14));
                } else {
                    if (sIndex != -1 && toCourseIndex != 0 && fromCourseIndex != 0) {
                        if (((CourseSection) Allcourses.get(fromCourseIndex)).regStud_course.contains(Allstudents.get(sIndex))) {
                            ((CourseSection) Allcourses.get(fromCourseIndex)).move_student(Allstudents.get(sIndex), (CourseSection) Allcourses.get(toCourseIndex));
                            //Allstudents.get(sIndex).changeCourse((CourseSection)Allcourses.get(fromCourseIndex),(CourseSection) Allcourses.get(toCourseIndex));
                            Mnote.setText(Allstudents.get(sIndex).Sname + " have been moved from " + Allcourses.get(fromCourseIndex).Course_name + " to " + Allcourses.get(toCourseIndex).Course_name + ".");
                            Mnote.setForeground(new Color(1, 100, 30));
                            Mnote.setFont(new Font("Arial", Font.BOLD, 14));
                        } else if (((CourseSection) Allcourses.get(toCourseIndex)).regStud_course.contains(Allstudents.get(sIndex))) {
                            Mnote.setText(Allstudents.get(sIndex).Sname + " already in " + Allcourses.get(toCourseIndex).Course_name + ".");
                            Mnote.setForeground(new Color(200, 1, 1));
                            Mnote.setFont(new Font("Arial", Font.BOLD, 14));
                        } else {
                            Mnote.setText(Allstudents.get(sIndex).Sname + " is not enrolled in " + Allcourses.get(fromCourseIndex).Course_name + ".");
                            Mnote.setForeground(new Color(200, 1, 1));
                            Mnote.setFont(new Font("Arial", Font.BOLD, 14));
                        }
                    } else if (fromCourseIndex == 0) {
                        Mnote.setText(fromCourseCodeT.getText() + " Not Found");
                        Mnote.setForeground(new Color(200, 1, 1));
                        Mnote.setFont(new Font("Arial", Font.BOLD, 14));
                    } else if (toCourseIndex == 0) {
                        Mnote.setText(toCourseCodeT.getText() + " Not Found");
                        Mnote.setForeground(new Color(200, 1, 1));
                        Mnote.setFont(new Font("Arial", Font.BOLD, 14));
                    }
                }
                if (EmptyID == true) {
                    Mnote.setText("Enter Student ID");
                    Mnote.setForeground(new Color(200, 1, 1));
                    Mnote.setFont(new Font("Arial", Font.BOLD, 14));
                }

            }
        });

        /*add course button*/
        AddCourseB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String status = section.getText(), courseName = CNameT.getText(), courseCode = CCodeT.getText();
                int weeks = Integer.parseInt(weeksNbT.getText()), Nbsec = Integer.parseInt(CSectionNbT.getText()), maxNbStud = Integer.parseInt(CMaxNbOfStudT.getText());
                int cIndex = 0;
                for (int i = 0; i < Allcourses.size(); i++) {
                    if (Allcourses.get(i).Course_code.equalsIgnoreCase(courseCode)) {
                        cIndex = i;
                        break;
                    }
                }
                if (Allcourses.get(cIndex).Course_code.equalsIgnoreCase(courseCode)) {
                    addCourseNote.setText("Already exists");
                    addCourseNote.setForeground(new Color(200, 1, 1));
                    addCourseNote.setFont(new Font("Arial", Font.BOLD, 14));
                    System.out.println("course already exist");
                } else {
                    if ((weeks < 5 || weeks > 12) && status.equalsIgnoreCase("online")) {
                        JOptionPane.showMessageDialog(null, "Weeks must be between 5&12", "Error Message", JOptionPane.ERROR_MESSAGE);
                    } else {

                        if (status.equalsIgnoreCase("normal")) {

                            Allcourses.add(new normalCourse(maxNbStud, Nbsec, courseName, courseCode, weeks, status));
                            addCourseNote.setText("Normal Course (" + courseCode + ") Added");
                            addCourseNote.setForeground(new Color(1, 100, 30));
                            addCourseNote.setFont(new Font("Arial", Font.BOLD, 14));
                            System.out.println("Normal Course (" + courseCode + ") Added");
                        } else {

                            Allcourses.add(new onlineCourse(maxNbStud, Nbsec, courseName, courseCode, weeks, status));
                            addCourseNote.setText("Online Course (" + courseCode + ") Added");
                            addCourseNote.setForeground(new Color(1, 100, 30));
                            addCourseNote.setFont(new Font("Arial", Font.BOLD, 14));
                            System.out.println("Online Course (" + courseCode + ") Added");
                        }

                    }
                }
            }
        });
        /*remove course button*/

        //RC_Code
        RCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cIndex = 0;
                for (int i = 0; i < Allcourses.size(); i++) {
                    if (RC_Code.getText().equalsIgnoreCase(Allcourses.get(i).Course_code)) {
                        cIndex = i;
                        break;
                    }
                }
                if (cIndex != 0) {
                    removeCourseMethod(Allcourses.get(cIndex));
                    RCNote.setText("Removed");
                } else {
                    RCNote.setText("Course not found!");
                }
            }
        });

        /*course info button actionlistener*/
        CourseInfoB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                int cIndex = 0;
                for (int i = 0; i < Allcourses.size(); i++) {
                    if (CourseCodeT.getText().equalsIgnoreCase(Allcourses.get(i).Course_code)) {
                        cIndex = i;
                        break;
                    }
                }
                if (cIndex != 0) {
                    CourseNameT.setText(Allcourses.get(cIndex).Course_name);
                    MaxNbOfStudT.setText(String.valueOf(((CourseSection) Allcourses.get(cIndex)).Section_maxNbStud));
                    NbRegStud.setText(String.valueOf(((CourseSection) Allcourses.get(cIndex)).regStud_course.size()));

                    if (Allcourses.get(cIndex) instanceof CourseSection ) {
                        if (Allcourses.get(cIndex) instanceof onlineCourse ) {
                            String status = ((onlineCourse)Allcourses.get(cIndex)).Status;
                            String sectionNB = String.valueOf(((onlineCourse)Allcourses.get(cIndex)).section_Nb);
                            ICStatusT.setText(status);
                            SectionNBT.setText(sectionNB);

                        }
                        if (Allcourses.get(cIndex) instanceof normalCourse ) {
                            String status =((normalCourse)Allcourses.get(cIndex)).Status;
                            String sectionNB = String.valueOf(((normalCourse)Allcourses.get(cIndex)).section_Nb);
                            ICStatusT.setText(status);
                            SectionNBT.setText(sectionNB);
                        }
                        if (((normalCourse)Allcourses.get(cIndex)).grades.isEmpty()) {
                            AverageGradeT.setText("Fill grades first");
                        } else {
                            AverageGradeT.setText(String.valueOf(((normalCourse)Allcourses.get(cIndex)).getAvarageGrade()));
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Course not found", "Error Message", JOptionPane.WARNING_MESSAGE);
                    CourseNameT.setText("");
                    MaxNbOfStudT.setText("");
                    ICStatusT.setText("");
                    SectionNBT.setText("");
                    AverageGradeT.setText("");
                    NbRegStud.setText("");
                }
            }
        });

        /*fill grades ok button actionlistener*/
        okFb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cIndex = 0;
                for (int i = 0; i < Allcourses.size(); i++) {
                    if (Allcourses.get(i).Course_code.equalsIgnoreCase(CourseCodeFt.getText())) {
                        cIndex = i;
                        break;
                    }
                }
                if (cIndex != 0) {
                    CourseCodeFt.setEditable(false);
                    if (Allcourses.get(cIndex) instanceof CourseSection ) {
                        if (((CourseSection)Allcourses.get(cIndex)).regStud_course.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "There are no students in this course", "Error Message", JOptionPane.WARNING_MESSAGE);
                        } else {
                            if (((CourseSection)Allcourses.get(cIndex)).grades.size() == 0) {
                                for (int i = 0; i < ((CourseSection)Allcourses.get(cIndex)).regStud_course.size(); i++) {
                                    Double grade = NaN;
                                    do {
                                        grade = Double.parseDouble(JOptionPane.showInputDialog(null, ((CourseSection)Allcourses.get(cIndex)).regStud_course.get(i).Sname + "'s grade"));
                                    } while (grade.isNaN());
                                    /*{
                                grade = Double.parseDouble(JOptionPane.showInputDialog(null, "grade must be a number"));
                                }*/
                                    ((CourseSection)Allcourses.get(cIndex)).grades.add(grade);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Alredy filled all grades", "Error Message", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Course not found", "Error Message", JOptionPane.WARNING_MESSAGE);
                    }
                }

            }
        });

        //View Grades Listener  
        okVGB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cIndex = 0;
                for (int i = 0; i < Allcourses.size(); i++) {
                    if (Allcourses.get(i).Course_code.equalsIgnoreCase(CourseCodeVGT.getText())) {
                        cIndex = i;
                        break;
                    }
                }

                if (cIndex != 0) {
                    if (Allcourses.get(cIndex) instanceof CourseSection ) {
                        if (!((CourseSection)Allcourses.get(cIndex)).grades.isEmpty()) {
                            CourseCodeVGT.setEditable(false);
                            for (int i = 0; i < ((CourseSection)Allcourses.get(cIndex)).grades.size(); i++) {
                                JOptionPane.showMessageDialog(null, ((CourseSection)Allcourses.get(cIndex)).regStud_course.get(i).Sname + ": " + ((CourseSection)Allcourses.get(cIndex)).grades.get(i), "Grades", JOptionPane.WARNING_MESSAGE);
                            }
                            ((CourseSection)Allcourses.get(cIndex)).print_Student();
                        } else {
                            JOptionPane.showMessageDialog(null, "Fill Grades first", "No Grades Found", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Course not found", "Error Message", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (oldPass.getText().equals(pass)) {
                    if (isPassValid(NewPass.getText())) {
                        changePass(NewPass.getText());
                        JOptionPane.showMessageDialog(null, "Password Changed Successfuly", "Success", JOptionPane.INFORMATION_MESSAGE);
                        savePassToFile();
                    } else {
                        JOptionPane.showMessageDialog(null, "New password must have at least 4 caharcters,"
                                + "contains at lease one special character,and has at least two"
                                + " digits", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Old Password is Invalid", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                }
                if (olduser.getText().equalsIgnoreCase(username)) {
                    if (!newUser.getText().equals("")) {
                        changeUser(newUser.getText());
                        JOptionPane.showMessageDialog(null, "Username Changed Successfuly", "Success", JOptionPane.INFORMATION_MESSAGE);
                        saveUserToFile();
                    } else {
                        JOptionPane.showMessageDialog(null, "New Username is Invalid", "Invalid Username", JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Old Username is Invalid", "Invalid Username", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        );

        changeCourseVGB.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                CourseCodeVGT.setEditable(true);
            }
        }
        );
        Runtime.getRuntime()
                .addShutdownHook(new Thread(() -> saveStudToFile()));
        Runtime.getRuntime()
                .addShutdownHook(new Thread(() -> saveCourseToFile()));

        setContentPane(contentPane);

        pack();

        setLocationRelativeTo(
                null);
    }

    public void removeCourseMethod(Course c) {
        Allcourses.remove(c);
    }
//Methods of streaming 

    public static void saveCourseToFile() {
        try ( FileOutputStream fileOut = new FileOutputStream("courses.dat");  ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(Allcourses);
            System.out.println("Courses saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving the courses: " + e.getMessage());
        }
    }

    public static void saveStudToFile() {
        try ( FileOutputStream fileOut = new FileOutputStream("students.dat");  ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(Allstudents);
            System.out.println("Students saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving the students: " + e.getMessage());
        }
    }

    public static void loadStudFromFile() {
        try ( FileInputStream fileIn = new FileInputStream("students.dat");  ObjectInputStream in = new ObjectInputStream(fileIn)) {

            Allstudents = (ArrayList<Student>) in.readObject();
            System.out.println("Students loaded successfully.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading the list: " + e.getMessage());
        }
    }

    public static void loadCourseFromFile() {
        try ( FileInputStream fileIn = new FileInputStream("courses.dat");  ObjectInputStream in = new ObjectInputStream(fileIn)) {

            Allcourses = (ArrayList<Course>) in.readObject();
            System.out.println("Courses loaded successfully.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading the list: " + e.getMessage());
        }
    }

    public static void saveUserToFile() {
        try ( FileOutputStream fileOut = new FileOutputStream("User.dat");  ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(username);

            System.out.println("Username Saved Succesfully.");

        } catch (IOException e) {
            System.out.println("Error saving username: " + e.getMessage());
        }
        String txtUserPath = "username.txt";
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(txtUserPath))) {
            writer.write(username);
            System.out.println("username Saved Succesfully in (username.txt).");
        } catch (IOException e) {
            System.out.println("Error saving Username to (username.txt): " + e.getMessage());
        }
    }

    public static void loadUserFromFile() {
        try ( FileInputStream fileIn = new FileInputStream("User.dat");  ObjectInputStream in = new ObjectInputStream(fileIn)) {

            username = (String) in.readObject();
            System.out.println("username loaded successfully.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading the username: " + e.getMessage());
        }
    }

    public static void savePassToFile() {
        try ( FileOutputStream fileOut = new FileOutputStream("Pass.dat");  ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(pass);

            System.out.println("Password Saved Succesfully.");

        } catch (IOException e) {
            System.out.println("Error saving Password: " + e.getMessage());
        }
        String txtPassPath = "Password.txt";
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(txtPassPath))) {
            writer.write(pass);
            System.out.println("Password Saved Succesfully in (Password.txt).");
        } catch (IOException e) {
            System.out.println("Error saving password to (Password.txt): " + e.getMessage());
        }
    }

    public static void loadPassFromFile() {
        try ( FileInputStream fileIn = new FileInputStream("Pass.dat");  ObjectInputStream in = new ObjectInputStream(fileIn)) {

            pass = (String) in.readObject();
            System.out.println("Password loaded successfully.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading the Password: " + e.getMessage());
        }
    }

//method to change password
    public static void changePass(String s) {
        pass = s;
    }

    public static void changeUser(String s) {
        username = s;
    }

    //methods to check if password is valid
    public static int check_digit(String s) {
        int cc = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (isDigit(a)) {
                cc++;
            }

        }
        return cc;
    }
//new pass must be at least 4 caharcters,contains at lease one special character,and has at least two digits

    public static boolean isPassValid(String pass) {

        int cc_dig = check_digit(pass);

        boolean valid = false;
        for (int i = 0; i < pass.length(); i++) {
            if (!isLetterOrDigit(pass.charAt(i))) {
                valid = true;
                break;
            }
        }
        if (valid && cc_dig >= 2 && pass.length() >= 4) {
            return true;
        } else {
            return false;
        }

    }
}
