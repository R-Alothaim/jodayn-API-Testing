package TestDataBuilder;

public enum APIResources {
  addPlaceAPI("/pet"),
  getPlaceAPI("/");
  private String resource;
  APIResources(String resource){
    this.resource = resource;
  }
  public String getResource() {
    return resource;
  }
}
