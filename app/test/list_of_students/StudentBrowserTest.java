package app.test.list_of_students;

import java.util.ArrayList;

import app.src.entities.Course;
import app.src.entities.Identifiable;
import app.src.entities.StudentRegistration;

import app.src.list_of_students.NameStudentSorter;
import app.src.list_of_students.StudentBrowser;

import jspec.*;

public class StudentBrowserTest extends SpecModule {
    private Course test = null;

    public void spec_code() {
        describe("StudentBrowser object", () -> {
            before(() -> {
                this.test = new Course(
                    "id",
                    "name",
                    "syllabus",
                    "instructor",
                    "year", "semester"
                );

                this.test.get_students_db().save(new StudentRegistration(
                    "4147",
                    "Papapostolou",
                    "2017",
                    "10"
                ));
                this.test.get_students_db().save(new StudentRegistration(
                    "4392",
                    "Koureas",
                    "2018",
                    "8"
                ));
                this.test.get_students_db().save(new StudentRegistration(
                    "4333",
                    "Georgiou",
                    "2018",
                    "8"
                ));
            });

            it("creates a student browser object", () -> {
                StudentBrowser browser = new StudentBrowser(
                    this.test,
                    new NameStudentSorter()
                );

                assert_that(browser).isnot(null);
            });

            it("returns a list of all students in a particular course", () -> {
                StudentBrowser browser = new StudentBrowser(
                    this.test,
                    new NameStudentSorter()
                );

                ArrayList<Identifiable> list = browser.list_students();
                assert_that(((StudentRegistration)(list.get(0))).id).equals_to("4333");
                assert_that(((StudentRegistration)(list.get(1))).id).equals_to("4392");
                assert_that(((StudentRegistration)(list.get(2))).id).equals_to("4147");
            });

            after(() -> {
                new java.io.File("persistence/sqlite/src/Database.db").delete();
            });
        });
    }
}
