package app.test.list_of_courses;

import java.util.ArrayList;

import app.src.list_of_courses.CourseSorter;
import app.src.list_of_courses.SemesterCourseSorter;

import app.src.entities.Course;
import app.src.entities.DBMSGateway;
import app.src.entities.Schema;

import dbms.CustomGatewayImplementation;

import jspec.*;

public class SemesterCourseSorterTest extends SpecModule {
    private DBMSGateway courses;

    public void spec_code() {
        before_each(() -> {
            this.courses = new CustomGatewayImplementation("Courses");
            this.courses.save(new Schema("c1", new Course(
                "c1",
                "Digital Design I",
                "Some info about ditital design 1",
                "Kavousianos",
                "2020",
                "3"
            )));
            this.courses.save(new Schema("c2", new Course(
                "c2",
                "Software Engineering",
                "More info about S. E.",
                "Zarras",
                "2022",
                "8"
            )));
            this.courses.save(new Schema("c3", new Course(
                "c3",
                "Operating Systems",
                "OS class information and syllabus",
                "Anastasiadis",
                "2021",
                "7"
            )));
        });

        describe("SemesterCourseSorter", () -> {
            it("creates a sorter object", () -> {
                CourseSorter semester_sorter = new SemesterCourseSorter();
                assert_that(semester_sorter).isnot(null);
            });

            it("sorts the db by semester", () -> {
                CourseSorter semester_sorter = new SemesterCourseSorter();
                ArrayList<Schema> sorted = semester_sorter.sort(this.courses);

                Course anastasiadis = new Course("c3", "Operating Systems", "OS class information and syllabus", "Anastasiadis", "2021", "7");
                Course kavousianos = new Course("c1", "Digital Design I", "Some info about ditital design 1", "Kavousianos", "2020", "3");
                Course zarras = new Course("c2", "Software Engineering", "More info about S. E.", "Zarras", "2022", "8");

                assert_that(((Course)(sorted.get(0).value())).equals(kavousianos)).is(true);
                assert_that(((Course)(sorted.get(1).value())).equals(anastasiadis)).is(true);
                assert_that(((Course)(sorted.get(2).value())).equals(zarras)).is(true);
            });
        });
    }
}