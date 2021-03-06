package ru.stqa.pft.mantis.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SoapHelper {

  private ApplicationManager app;

  public SoapHelper(ApplicationManager app) {
    this.app = app;

  }

  public Set<Project> getProjects() throws MalformedURLException, ServiceException, RemoteException { // get list of projects
    MantisConnectPortType mc = getMantisConnect();
    ProjectData[] projects = mc.mc_projects_get_user_accessible("administrator", "root"); //get list of projects
    // преобразовать данные в модельные объекты тут
    return Arrays.asList(projects).stream() //convert to objects
            .map((p) -> new Project().withtId(p.getId().intValue()).withName(p.getName()))
            .collect(Collectors.toSet());
  }

  private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
    return new MantisConnectLocator()
            .getMantisConnectPort(new URL("http://localhost/mantisbt-2.14.0/api/soap/mantisconnect.php"));
  }

  public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    String[] categories = mc.mc_project_get_categories("administrator", "root", BigInteger.valueOf(issue.getProject().getId()));
    IssueData issueData = new IssueData();
    issueData.setSummary(issue.getSummary());
    issueData.setDescription(issue.getDescription());
    issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId()), issue.getProject().getName()));
    issueData.setCategory(categories[0]);

    BigInteger issuedId = mc.mc_issue_add("administrator", "root", issueData);
    IssueData createdIssuedData = mc.mc_issue_get("administrator", "root", issuedId);
    return new Issue().withId(createdIssuedData.getId().intValue())
            .withSummary(createdIssuedData.getSummary()).withDescription(createdIssuedData.getDescription())
            .withProject(new Project().withtId(createdIssuedData.getProject().getId().intValue())
                    .withName(createdIssuedData.getProject().getName()));
  }

  public String getStatus(int issueId) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    IssueData issueData = mc.mc_issue_get("administrator", "root", BigInteger.valueOf(issueId));
    String statusName = issueData.getStatus().getName(); //get status of report
    return statusName;
  }
}
