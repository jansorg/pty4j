package testData;

import bashpro.pty4j.TestUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PromptReader {
  public static void main(String[] args) throws IOException {
    startPromptHandling();
  }

  static void startPromptHandling() throws IOException {
    TestUtil.assertConsoleExists();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter:");
    String line = reader.readLine();
    while (line != null && !line.isEmpty()) {
      System.out.println("Read:" + line);
      System.out.print("Enter:");
      line = reader.readLine();
    }
    System.out.println(line == null ? "exit: stdin closed" : "exit: empty line");
  }
}
