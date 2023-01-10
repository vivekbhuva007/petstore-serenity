package io.swagger.cucumber.step;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.swaggerinfo.PetSteps;
import io.swagger.utils.TestUtils;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.hasValue;

public class PetStepdefs {

    static ValidatableResponse response;

    static int petID;

    static String name;

    @Steps
    PetSteps petSteps;

    @When("^User sends a GET request to petID endpoint$")
    public void userSendsAGETRequestToPetIDEndpoint() {
        response = petSteps.getAllPetInfo();


    }

    @When("^I create a new pat by providing the information id \"([^\"]*)\" category \"([^\"]*)\" name \"([^\"]*)\" photoUrls \"([^\"]*)\" tags \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iCreateANewPatByProvidingTheInformationIdCategoryNamePhotoUrlsTagsStatus(int id, HashMap<Object,Object> category, String _name, List<Object> photoUrls, List<HashMap<Object, Object>> tags, String status)  {
        HashMap<Object, Object> newCategory = new HashMap<>();
        newCategory.get(category);
        List<Object> photoUrl = new ArrayList<>();
        photoUrl.add(photoUrls);
        List<HashMap<Object, Object>> tagList = new ArrayList<>();
        tagList.add((HashMap<Object, Object>) tags);


        name = TestUtils.getRandomValue()+ _name;
        response = petSteps.createPet(id,category,name,photoUrls,tags,status);




    }

    @Then("^I verify that the pet with \"([^\"]*)\" is created$")
    public void iVerifyThatThePetWithIsCreated(String field)  {
        response.statusCode(201);
        HashMap<String, Object> petMap = petSteps.findPetById(petID);
        petID = (int) petMap.get("id");
        Assert.assertThat(petMap, hasValue(petID));


    }
}
