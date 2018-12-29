package reflection;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReflectionFormatterTest {

    private ReflectionFormatter reflectionFormatter = new ReflectionFormatter();
    private static Robot robot;
    private static String robotStr;

    @BeforeClass
    public void beforeClass() {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void format() {
    }

    @Test
    public void parse() {
    }
}