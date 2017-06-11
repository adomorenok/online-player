package com.online.player.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ikota on 11.6.17.
 */
public class CustomLocalDateTimeSerializer  extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime dateTime, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        String formattedDateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        gen.writeString(formattedDateTime);
    }
}
