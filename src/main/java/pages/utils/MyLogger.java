package pages.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class MyLogger {
  private static   Logger myLogger = Logger.getLogger("MyLogger");

    public static void main(String[] args) {

        myLogger.setLevel(Level.INFO);
        myLogger.info("hello");

        try {
            brokenMethod();
        } catch (Exception e) {
            myLogger.error(e.getMessage(), e);
        }
    }

      public static void brokenMethod() throws Exception {
          throw new Exception("ERROR");
    }
}

