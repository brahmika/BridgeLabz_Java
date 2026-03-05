package designpatterns;

import designpatterns.AppLogger;

public class LoggerTest {

    public static void main(String[] args) {

        AppLogger logger1 = AppLogger.getInstance();
        AppLogger logger2 = AppLogger.getInstance();

        logger1.log("First message");
        logger2.log("Second message");

        System.out.println(logger1 == logger2);
    }
}