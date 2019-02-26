package log4j_tutorial;

import org.apache.log4j.*;
import org.apache.log4j.xml.XMLLayout;

import java.io.IOException;

public class TestLogging {
    public static void main(String[] args) throws IOException {

        //create
        Logger parent = Logger.getLogger("study.src.main.java.log4j_tutorial");
        parent.setLevel(Level.WARN);
        Logger child = Logger.getLogger(TestLogging.class);
        child.setLevel(Level.INFO);

        //config
        child.addAppender(new FileAppender(new XMLLayout(), "log.xml"));
        child.addAppender(new ConsoleAppender(new PatternLayout("%r [%t] %-5p %c %x - %m%n ")));
        parent.addAppender(new ConsoleAppender(new PatternLayout("%r [%t] %-5p %c %x - %m%n ")));

        //usage
//        child.info("start action in system");
//        parent.error("error");
//        parent.trace("trace");
//        parent.warn("warning");

    }
}
