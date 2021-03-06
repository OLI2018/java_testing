package ru.stqa.ptf.rest;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;

public class TestBase {

  public boolean isIssueOpen(int issueId) throws IOException {

    JsonElement state_name = getIssueStatus(issueId);
    String asString = state_name.getAsString();

    if (asString.equals("Closed") || asString.equals("Resolved")) {
      return false;
    } else {
      return true;
    }
  }

  public JsonElement getIssueStatus(int issueId) throws IOException {
    String json = getExecutor().execute(Request.Get("http://bugify.stqa.ru/api/issues/" + issueId + ".json"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return issues.getAsJsonArray().get(0).getAsJsonObject().get("state_name");
  }

  private Executor getExecutor() {
    return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
  }

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue: " + issueId);
    }
  }
}
