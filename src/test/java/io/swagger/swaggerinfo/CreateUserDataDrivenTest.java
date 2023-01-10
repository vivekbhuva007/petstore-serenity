package io.swagger.swaggerinfo;

import io.swagger.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@Concurrent(threads = "2x")

@UseTestDataFrom("src/test/java/resources/testdata/userinfo.csv")
@RunWith(SerenityParameterizedRunner.class)

public class CreateUserDataDrivenTest extends TestBase {
    private int id;

    private String userName;

    private String firstName;

    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    @Steps
    UserSteps userSteps;

    @Title("Data driven test for adding multiple user to the application")
    @Test
    public void createMultipleUsers(){
        userSteps.createUser(id,userName,firstName,lastName,email,password,phone,userStatus).statusCode(200);

    }
}
