package app.src.entities;

import java.util.ArrayList;

public class Course {
    public String id;
    public String name;
    public String syllabus;
    public String instructor;
    public String year;
    public String semester;

    public ArrayList<StudentRegistration> students;

    public Course(
        String id,
        String name,
        String syllabus,
        String instructor,
        String year,
        String semester
    ) {
        this.id = id;
        this.name = name;
        this.syllabus = syllabus;
        this.instructor = instructor;
        this.year = year;
        this.semester = semester;

        this.students = new ArrayList<StudentRegistration>();
    }
}
