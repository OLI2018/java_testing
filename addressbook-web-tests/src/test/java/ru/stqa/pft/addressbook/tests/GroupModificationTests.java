package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification() {

    app.getNavigationHelper().goToGroupPage();

    if(! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("ModTest1", "ModTest2", "ModTest3"));
    app.getGroupHelper().submittGroupModification();
    app.getGroupHelper().returnToGroupPage();

  }
}
