package com.sha.springbootmicroservice3gateway.config;

import com.google.gson.*;
import org.apache.tomcat.jni.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
public class GsonHttpMessageConfig
{
    @Bean
    public GsonBuilder gsonBuilder()
    {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonSerializer<LocalDateTime>) (date, type, context) ->
                        date == null ? null : new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonDeserializer<LocalDateTime>) (json, type, context) ->
                        LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    @Bean
    public Gson gson(GsonBuilder gsonBuilder)
    {
        return gsonBuilder.create();
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter()
    {
        StringHttpMessageConverter messageConverter = new StringHttpMessageConverter();
        messageConverter.setSupportedMediaTypes(List.of(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.ALL));
        return messageConverter;
    }

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter(Gson gson)
    {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(gson);
        return converter;
    }


}
