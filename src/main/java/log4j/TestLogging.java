package log4j;

import org.apache.log4j.*;
import org.apache.log4j.xml.XMLLayout;
import java.io.IOException;

public class TestLogging {
    public static void main(String[] args) throws IOException {
        //create
        Logger parent = Logger.getLogger("study.src.main.java");
        parent.setLevel(Level.DEBUG);
        Logger child1 = Logger.getLogger(TestLogging.class);
        child1.setLevel(Level.INFO);
        Logger child2 = Logger.getLogger("study.src.main.java.log4j");
        child2.setLevel(Level.INFO);

        //config
        child2.addAppender(new FileAppender(new XMLLayout(), "log.xml"));
        child2.addAppender(new ConsoleAppender(new PatternLayout("%r [%t] %-5p %c %x - %m%n ")));
        child1.addAppender(new ConsoleAppender(new PatternLayout("%r [%t] %-5p %c %x - %m%n ")));
        parent.addAppender(new ConsoleAppender(new PatternLayout("%r [%t] %-5p %c %x - %m%n ")));

        //usage
        child2.debug("child2 debug");
        child2.trace("child2 trace");
        child1.trace("child1 trace");
        child1.info("child1 info");
        parent.info("parent info");
    }
}
