package ru.stqa.pft.mantis.appmanager;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpSession {

  private CloseableHttpClient httpclient;
  private ApplicationManager app;

  public HttpSession(ApplicationManager app) {
    this.app = app;
    httpclient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build(); //new session, send to server
  }

  public boolean login(String username, String password) throws IOException {
    HttpPost post = new HttpPost(app.getProperty("web.BaseUrl") + "/login.php"); //post
    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("password", password));
    params.add(new BasicNameValuePair("secure_session", "on"));
    params.add(new BasicNameValuePair("return", "index.php"));

    post.setEntity(new UrlEncodedFormEntity(params)); //packed parameters

    CloseableHttpResponse response = httpclient.execute(post); // send request to server and get a response
    String body = geTextFrom(response);
//    return body.contains(String.format("<span class=\"label hidden-xs label-default arrowed\">%s</span>", username));
    return body.contains(String.format("<span class=\"user-info\">%s</span>", username));


  }

  private String geTextFrom(CloseableHttpResponse response) throws IOException {
    try {
      return EntityUtils.toString(response.getEntity());
    } finally {
      response.close();
    }
  }

  public boolean isLoggedInAs(String username) throws IOException {
    HttpGet get = new HttpGet(app.getProperty("web.BaseUrl") + "/index.php"); //get
    CloseableHttpResponse response = httpclient.execute(get); // execute GET and receive response
    String body = geTextFrom(response);
    return body.contains(String.format("<span class=\"label hidden-xs label-default arrowed\">%s</span>", username));
  }
}

