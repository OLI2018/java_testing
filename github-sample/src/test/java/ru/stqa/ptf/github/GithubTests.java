package ru.stqa.ptf.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

  @Test
  public void testCommits() throws IOException {

    //github Token 73a4929c52bcb2c89968741991a45b7d37c92181
    Github github = new RtGithub("73a4929c52bcb2c89968741991a45b7d37c92181");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("OLI2018", "java_testing")).commits();
    for(RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
