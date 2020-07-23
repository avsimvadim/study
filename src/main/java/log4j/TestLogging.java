package log4j;

import org.apache.log4j.*;
import org.apache.log4j.xml.XMLLayout;
import java.io.IOException;

public class TestLogging {
    public static void main(String[] args) throws IOException {
        //create
        Logger root = Logger.getRootLogger();
        Logger parent = Logger.getLogger("log4j");
        parent.setLevel(Level.INFO);
        Logger child = Logger.getLogger(TestLogging.class);
        child.setLevel(Level.DEBUG);

        //config
        child.addAppender(new FileAppender(new XMLLayout(), "log.xml"));
        child.addAppender(new ConsoleAppender(new PatternLayout("%r [%t] %-5p %c %x - %m%n ")));
        parent.addAppender(new ConsoleAppender(new PatternLayout("%r [%t] %-5p %c %x - %m%n ")));

        //usage
        child.debug("child1 info");
        System.out.println("*------------------------------------*");
        parent.debug("parent info");
        System.out.println("*------------------------------------*");
        root.debug("root info");
    }
}
