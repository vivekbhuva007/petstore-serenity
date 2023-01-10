package io.swagger.cucumber.step;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.swaggerinfo.UserSteps;
import io.swagger.utils.TestUtils;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class UserStepdefs {

    static ValidatableResponse response;

    static String userName = null;


    static int userID;



    @Steps
    UserSteps userSteps;

    @When("^I create a new user by providing the information id \"([^\"]*)\" username \"([^\"]*)\" firstName \"([^\"]*)\" lastName \"([^\"]*)\" email \"([^\"]*)\"password\"([^\"]*)\"phone\"([^\"]*)\"userStatus\"([^\"]*)\"$")
    public void iCreateANewUserByProvidingTheInformationIdUsernameFirstNameLastNameEmailPasswordPhoneUserStatus(int _userID, String _userName, String firstName, String lastName, String email, String password, String phone, int userStatus) {
       //userID = TestUtils.getRandomValue()+ _userID;
       userName = TestUtils.getRandomValue()+ _userName;
       response = userSteps.createUser(_userID,userName,firstName,lastName,email,password,phone,userStatus);

    }
    @Then("^I verify that the student with \"([^\"]*)\" is created$")
    public void iVerifyThatTheStudentWithIsCreated(String field) {
        response.statusCode(200);
        HashMap<String, Object> userMap = userSteps.getUserInfoByUserId(userName);
        Assert.assertThat(userMap, hasValue(userName));
        userID = (int) userMap.get("id");

    }


}
