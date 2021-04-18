package e2e.stepDef;

import e2e.page.Challenge;
import io.cucumber.java.en.*;

public class ChallengeStepDef {
    Challenge challenge = new Challenge();


    @Given("navigate landing page verify it the click Render the Challenge button")
    public void navigate_landing_page_verify_it_the_click_Render_the_Challenge_button() {
        challenge.verifyLandingPage();
    }

    @When("Array challenge is diplayed and find the center index which equals left and right and enter")
    public void array_challenge_is_diplayed_and_find_the_center_index_which_equals_left_and_right_and_enter() {
        challenge.submitChallenges();
    }

    @Then("input name then click submit")
    public void input_name_then_click_submit() {
        challenge.inputNameAndClickSubmit();
    }

}
