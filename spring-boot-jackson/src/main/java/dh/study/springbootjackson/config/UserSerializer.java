package dh.study.springbootjackson.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import dh.study.springbootjackson.pojo.User;

import java.io.IOException;

/**
 * 使用Jackson进行序列化
 */
public class UserSerializer extends JsonSerializer<User> {
    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("user-name", user.getName());
        jsonGenerator.writeEndObject();
    }
}
