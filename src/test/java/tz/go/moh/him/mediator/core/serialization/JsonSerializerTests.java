package tz.go.moh.him.mediator.core.serialization;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.mediator.core.exceptions.ArgumentNullException;
import tz.go.moh.him.mediator.core.exceptions.SerializationException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Contains tests for {@link JsonSerializer} class.
 */
public class JsonSerializerTests {

    /**
     * Tests deserialization.
     */
    @Test
    public void testDeserializeFromBytes() throws IOException {
        InputStream stream = JsonSerializerTests.class.getClassLoader().getResourceAsStream("result_detail.json");

        Assert.assertNotNull(stream);

        JsonSerializer serializer = new JsonSerializer();

        ResultDetail actual = serializer.deserialize(IOUtils.toByteArray(stream), ResultDetail.class);

        Assert.assertEquals("the message", actual.getMessage());
        Assert.assertEquals(ResultDetail.ResultsDetailsType.ERROR, actual.getType());
    }

    /**
     * Tests deserialization.
     */
    @Test(expected = SerializationException.class)
    public void testDeserializeFromBytesException() throws IOException {
        InputStream stream = JsonSerializerTests.class.getClassLoader().getResourceAsStream("bad_result_detail.json");

        Assert.assertNotNull(stream);

        JsonSerializer serializer = new JsonSerializer();

        serializer.deserialize(IOUtils.toByteArray(stream), ResultDetail.class);
    }

    /**
     * Tests deserialization.
     */
    @Test(expected = SerializationException.class)
    public void testDeserializeFromStringException() throws IOException {
        InputStream stream = JsonSerializerTests.class.getClassLoader().getResourceAsStream("bad_result_detail.json");

        Assert.assertNotNull(stream);

        JsonSerializer serializer = new JsonSerializer();

        serializer.deserialize(IOUtils.toString(stream), ResultDetail.class);
    }

    /**
     * Tests deserialization.
     */
    @Test
    public void testDeserializeFromString() throws IOException {
        InputStream stream = JsonSerializerTests.class.getClassLoader().getResourceAsStream("result_detail.json");

        Assert.assertNotNull(stream);

        JsonSerializer serializer = new JsonSerializer();

        ResultDetail actual = serializer.deserialize(IOUtils.toString(stream), ResultDetail.class);

        Assert.assertEquals("the message", actual.getMessage());
        Assert.assertEquals(ResultDetail.ResultsDetailsType.ERROR, actual.getType());
    }

    /**
     * Tests serialization to a byte array.
     */
    @Test
    public void testSerializeToBytes() {
        ResultDetail resultDetail = new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, "the message", null);

        JsonSerializer serializer = new JsonSerializer();

        byte[] actual = serializer.serializeToBytes(resultDetail);

        Assert.assertNotNull(actual);
    }

    /**
     * Tests serialization to a byte array.
     */
    @Test(expected = ArgumentNullException.class)
    public void testSerializeToBytesException() {
        JsonSerializer serializer = new JsonSerializer();

        serializer.serializeToBytes(null);
    }

    /**
     * Tests serialization to a string.
     */
    @Test
    public void testSerializeToString() {
        ResultDetail resultDetail = new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, "the message", null);

        JsonSerializer serializer = new JsonSerializer();

        String actual = serializer.serializeToString(resultDetail);

        Assert.assertTrue(actual.contains(resultDetail.getMessage()));
        Assert.assertTrue(actual.contains(resultDetail.getType().toString()));
    }

    /**
     * Tests serialization to a string.
     */
    @Test(expected = ArgumentNullException.class)
    public void testSerializeToStringException() {
        JsonSerializer serializer = new JsonSerializer();

        serializer.serializeToString(null);
    }
}
