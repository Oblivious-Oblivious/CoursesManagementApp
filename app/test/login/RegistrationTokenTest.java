package app.test.login;

import app.src.login.RegistrationToken;
import jspec.*;

public class RegistrationTokenTest extends SpecModule {
    public void spec_code() {
        describe("LoginToken", () -> {
            it("creates a login token with initial parameters", () -> {
                RegistrationToken token = new RegistrationToken("id", "oblivious", "123456");
                assert_that(token).isnot(null);
            });

            it("checks for equality for 2 login tokens", () -> {
                RegistrationToken t1 = new RegistrationToken("id", "batman", "1234");
                RegistrationToken t2 = new RegistrationToken("id", "batman", "1234");

                assert_that(t1.equals(t2)).is(true);
            });

            it("checks for inequality for 2 login token", () -> {
                RegistrationToken t1 = new RegistrationToken("id", "batman", "1234");
                RegistrationToken t2 = new RegistrationToken("id2", "batman", "8521");

                assert_that(t1.equals(t2)).is(false);
            });

            it("gets the username", () -> {
                RegistrationToken token = new RegistrationToken("id", "user", "pass");
                assert_that(token.username).is("user");
            });
            
            it("gets the password", () -> {
                RegistrationToken token = new RegistrationToken("id", "user", "pass");
                assert_that(token.password).is("pass");
            });
        });
    }
}
