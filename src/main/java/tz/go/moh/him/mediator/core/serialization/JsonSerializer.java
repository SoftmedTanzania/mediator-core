package tz.go.moh.him.mediator.core.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tz.go.moh.him.mediator.core.exceptions.ArgumentNullException;
import tz.go.moh.him.mediator.core.exceptions.SerializationException;

import java.io.IOException;

/**
 * Represents a JSON serializer.
 */
public class JsonSerializer {

    /**
     * Deserializes a JSON string to an object instance.
     *
     * @param json The JSON to deserialize.
     * @param type The type of the instance.
     * @param <T>  The type of the instance
     * @return Returns the deserialized instance.
     */
    public <T> T deserialize(byte[] json, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    /**
     * Deserializes a JSON string to an object instance.
     *
     * @param json The JSON to deserialize.
     * @param type The type of the instance.
     * @param <T>  The type of the instance
     * @return Returns the deserialized instance.
     */
    public <T> T deserialize(String json, Class<T> type) {

        if (json == null || "".equals(json)) {
            throw new ArgumentNullException("json - Value cannot be null");
        }

        if (type == null) {
            throw new ArgumentNullException("type - Value cannot be null");
        }

        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            return mapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    /**
     * Serializes an object to a byte array.
     *
     * @param instance The instance to serialize.
     * @return Returns the serialized instance as a byte array.
     */
    public byte[] serializeToBytes(Object instance) {

        if (instance == null) {
            throw new ArgumentNullException("instance - Value cannot be null");
        }

        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            return mapper.writeValueAsBytes(instance);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    /**
     * Serializes an object to a JSON string.
     *
     * @param instance The instance to serialize.
     * @return Returns the serialized instance as a string.
     */
    public String serializeToString(Object instance) {

        if (instance == null) {
            throw new ArgumentNullException("instance - Value cannot be null");
        }

        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            return mapper.writeValueAsString(instance);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }
}
