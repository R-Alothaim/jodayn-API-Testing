package step_definitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
  @Before("@DeletePlace")
  public void beforeScenario() throws IOException{
    stepDefination step = new stepDefination();
    if(stepDefination.place_id == null){
    step.add_place("Ryan", "French", "Asia");
    step.httprequest("addPlaceAPI", "post");
    step.verify_place_id_created_maps_to_using_get_place_api("Ryan", "getPlaceAPI");
    }
  }
}
