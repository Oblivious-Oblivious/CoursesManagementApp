package app.test.entities;

import app.src.entities.Course;
import jspec.*;

public class CourseTest extends SpecModule {
    private Course c = null;

    public void spec_code() {
        describe("Course object", () -> {
            before_each(() -> {
                String id = "MYY402";
                String name = "Electronics";
                String syllabus = "Introduction to electronics. Amplifiers - Operational amplifiers. Semiconductor theory. The p-n junction - Diodes. Diode circuits (rectifier and limiting circuits). Field effect transistors and bipolar junction transistors: a) physical structure and operation, b) current-voltage characteristics, c) DC operation - bias, d) small-signal equivalent circuit models. Single-stage transistor amplifiers: biasing and operation. Differential amplifiers. Multi-stage amplifiers. Frequency response. Feedback.";
                String instructor = "Tsiatoyhas";
                int year = 2022;
                int semester = 4;
                
                this.c = new Course(id, name, syllabus, instructor, year, semester);
            });

            it("creates a random course object with passed data", () -> {
                assert_that(c.id).equals_to("MYY402");
                assert_that(c.name).equals_to("Electronics");
                assert_that(c.syllabus).equals_to("Introduction to electronics. Amplifiers - Operational amplifiers. Semiconductor theory. The p-n junction - Diodes. Diode circuits (rectifier and limiting circuits). Field effect transistors and bipolar junction transistors: a) physical structure and operation, b) current-voltage characteristics, c) DC operation - bias, d) small-signal equivalent circuit models. Single-stage transistor amplifiers: biasing and operation. Differential amplifiers. Multi-stage amplifiers. Frequency response. Feedback.");
                assert_that(c.instructor).equals_to("Tsiatoyhas");
                assert_that(c.year).equals_to(2022);
                assert_that(c.semester).equals_to(4);
            });
        });
    }
}