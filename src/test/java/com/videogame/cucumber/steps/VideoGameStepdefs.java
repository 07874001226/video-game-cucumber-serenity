package com.videogame.cucumber.steps;

import com.videogame.utils.TestUtils;
import com.videogame.videogameinfo.VideoGameSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class VideoGameStepdefs {
    static int id = 1 + TestUtils.getRandomValueInt();
    static String name = "mario";
    static String releaseDate = "2021-07-15T19:08:27.609Z";
    static int reviewScore = 10;
    static String category = "abc";
    static String rating = "9";
    @Steps
    VideoGameSteps videoGameSteps;

    @Title("This will get a videogame list")
    @Test
    @When("^I create a new Videogame by providing the information name \"([^\"]*)\" releaseDate \"([^\"]*)\" rating\"([^\"]*)\"$")
    public void iCreateANewVideogameByProvidingTheInformationNameReleaseDateRating(String name, String releaseDate, String rating) {
        videoGameSteps.createVideoGame(id, name, releaseDate, reviewScore, category, rating).statusCode(200).extract().response().body().jsonPath();
    }

    @Then("^I verify the VideoGame is created Successfully$")
    public void iVerifyTheVideoGameIsCreatedSuccessfully() {
videoGameSteps.getVideoGameById(id).log().all().statusCode(200);

    }

    @When("^I send GET request to Videogame endpoint with Id \"([^\"]*)\",I should See the Videogame information Successfully$")
    public void iSendGETRequestToVideogameEndpointWithIdIShouldSeeTheVideogameInformationSuccessfully(String videoGameId) {
        videoGameSteps.getVideoGameById(id).statusCode(200).log().all();

    }

    @When("^I update a created Videogame providing the new name$")
    public void iUpdateACreatedVideogameProvidingTheNewName() {
        id = id ;
        name = name + "_Updated";
        releaseDate = releaseDate ;
        reviewScore =  reviewScore+1  ;
        category = category + "_Updated";
        rating = rating + "_Updated";


        videoGameSteps.updateVideoGameById(id,name,releaseDate,reviewScore,category,rating).statusCode(200).log().all();


    }

    @Then("^I verify the Videogame is updated Successfully$")
    public void iVerifyTheVideogameIsUpdatedSuccessfully() {
        videoGameSteps.getVideoGameById(id).body("id",equalTo(id));
    }

    @When("^I delete a created Videogame ,they get back a valid status code is (\\d+)$")
    public void iDeleteACreatedVideogameTheyGetBackAValidStatusCodeIs(int videoGameId) {
        videoGameSteps.deleteVideoGame(id).statusCode(200).log().all();
    }

    @When("^User sends a GET request to the Videogame endpoint,they get back a valid status code 200$")
    public void userSendsAGETRequestToTheVideogameEndpointTheyGetBackAValidStatusCode() {
        videoGameSteps.getAllVideoGames().log().all().statusCode(200);
    }
}
