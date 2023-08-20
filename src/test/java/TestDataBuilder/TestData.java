package TestDataBuilder;

import java.util.LinkedList;
import java.util.List;

import io.restassured.path.json.JsonPath;
import pojo.category;
import pojo.pet;
import pojo.tags;
public class TestData {
public pet addplace(String name, String language, String address) {
 pet p = new pet();
 category c = new category();
 c.setId(7);
 c.setName(language);
 p.setCategory(c);
 p.setId(123);
 p.setName(name);
 String []array = {"Yes","No"};
 p.setPhotoUrls(array);
 p.setStatus(address);
 List<tags> LinkedListForTags= new LinkedList<tags>();
 tags tagsValues = new tags();
tagsValues.setId(7);
tagsValues.setName("R");
LinkedListForTags.add(tagsValues);
p.setTags(LinkedListForTags);
return p;

  }
  public String deleteplace(String place_id) {
    return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}";
  }
}
