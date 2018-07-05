package ru.stqa.ptf.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestAssuredTests {

  @BeforeClass
  public void init() {

    RestAssured.authentication = RestAssured.basic("8df242e4ddb24441bafd565ba8c81de9", "");
  }

  @Test
  public void testCreateIssue() throws IOException {

    Set<Issue> oldIssues = getIssues(); // get set of old issues
    Issue newIssue = new Issue().withSubject("QWERTY").withDescription("XXXXXXX"); // create new issue - object
    int issueId = createIssue(newIssue); //create new issue thru method and return id of newly created issue
    Set<Issue> newIssues = getIssues(); //get set of new issues including newly added one
    oldIssues.add(newIssue.withId(issueId)); // add new issue with id to old set to have the equal sets
    assertEquals(newIssues, oldIssues); // compare old and new sets
  }

  private Set<Issue> getIssues() throws IOException {
    String json = RestAssured.get("http://demo.bugify.com/api/issues.json?limit=2000").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
    }.getType());
  }

  private int createIssue(Issue newIssue) throws IOException {
    String json = RestAssured.given()
            .parameter("subject", newIssue.getSubject())
            .parameter("description", newIssue.getDescription())
            .post("http://demo.bugify.com/api/issues.json?limit=2000").asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }
}
