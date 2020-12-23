package com.softmed.mediator.adapter;

import junit.framework.TestCase;
import org.json.JSONArray;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;

public class CsvAdapterUtilsTest extends TestCase {
    private final String csvPayload = "name,age\n" +
            "Doe,32\n" +
            "John,35";

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testCsvToArrayList() throws IOException {
        List<testObject> objects = (List<testObject>) CsvAdapterUtils.csvToArrayList(csvPayload, testObject.class);
        Assert.assertEquals(2, objects.size());
        Assert.assertEquals("Doe", objects.get(0).getName());
        Assert.assertEquals(32, objects.get(0).getAge());
        Assert.assertEquals("John", objects.get(1).getName());
        Assert.assertEquals(35, objects.get(1).getAge());
    }

    public void testCsvToJson() throws IOException {
        JSONArray expectedArray = new JSONArray("[{\"name\":\"Doe\",\"age\":32},{\"name\":\"John\",\"age\":35}]");
        JSONArray objects = CsvAdapterUtils.csvToJson(csvPayload, testObject.class);
        Assert.assertEquals(expectedArray.toString(), objects.toString());
    }

    public static class testObject {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}