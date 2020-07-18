package models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DepartmentTest {

    @Test
    public void departmentInstantiatesCorrectly() {
        Department department = new Department ("Finance", "Maintains Financial records", 13);
        assertEquals(true, department instanceof Department);
    }

}