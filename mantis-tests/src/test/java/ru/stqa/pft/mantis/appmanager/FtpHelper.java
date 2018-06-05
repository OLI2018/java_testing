package ru.stqa.pft.mantis.appmanager;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpHelper {

  private final ApplicationManager app;
  private FTPClient ftp;

  public FtpHelper(ApplicationManager app) {
    this.app = app;
    ftp = new FTPClient();
  }

  public void upload(File file, String target, String backup) throws IOException { //upload a new file and rename the current file
    // file - локальный файл будет загружен на удаленную машину, target - имя удаленного файла, backup - имя резервной копии, если удаленный файл уже есть
    ftp.connect(app.getProperty("ftp.host"));
    ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
    ftp.deleteFile(backup); // удалить резервуню копию, если она была
    ftp.rename(target, backup); // переименовать удаленный файл и сделать копию
    ftp.enterLocalPassiveMode();
    ftp.storeFile(target, new FileInputStream(file)); // загрузить файл на удаленную машину в место target или сохранить в target
    ftp.disconnect();
  }

  public void restore(String backup, String target) throws IOException { // restore the old file
    ftp.connect(app.getProperty("ftp.host"));
    ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
    ftp.deleteFile(target); // delete the file we uploaded before
    ftp.rename(backup, target); // the original file from backup
    ftp.disconnect();
  }
}
