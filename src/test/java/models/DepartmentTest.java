package models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DepartmentTest {

    @Test
    public void departmentInstantiatesCorrectly() {
        Department department = new Department("Finance", "Maintains Financial records", 13);
        assertEquals(true, department instanceof Department);
    }

    @Test
    public void getsDepartmentName() {
        Department department = new Department("Finance", "Maintains Financial records", 13);
        assertEquals("Finance", department.getName());
    }

    @Test
    public void getsDepartmentDescription() {
        Department department = new Department("Finance", "Maintains Financial records", 13);
        assertEquals("Maintains Financial records", department.getDescription());
    }

    @Test
    public void getsTotalEmployees() {
        Department department = new Department("Finance", "Maintains Financial records", 13);
        assertEquals(13,department.getTotalEmployees());
    }
}