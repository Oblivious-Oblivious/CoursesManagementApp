package test;

import jspec.*;
import hello.Hello;

public class HelloTest extends SpecModule {
    public void spec_code() {
        describe("HelloTest", () -> {
            it("checks for the random function rerturning 42", () -> {
                Hello test = new Hello();
                assert_that(test.random()).is(42);
            });
        });
    }
}