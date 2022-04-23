package app.src.entities;

import java.io.Serializable;

public class StudentRegistration implements Serializable {
    public String id;
    public String name;
    public String year_of_registration;
    public String semester;

    public StudentRegistration(
        String id,
        String name,
        String year_of_registration,
        String semester
    ) {
        this.id = id;
        this.name = name;
        this.year_of_registration = year_of_registration;
        this.semester = semester;
    }
}
