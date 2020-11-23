package test;
import org.junit.Test;

import main.Project;

public class ProjectTest {

    Project p = new Project();
    @Test
    public void testTitle() {
        p.setTitle("title");
        assertEquals("title", p.getTitle());
    }
}
