package com.sha.springbootmicroservice3gateway.config;

import com.google.gson.*;
import org.apache.tomcat.jni.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
public class GsonHttpMessageConfig implements WebMvcConfigurer
{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters)
    {
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(new GsonHttpMessageConverter());
    }

    @Bean
    public GsonBuilder gsonBuilder()
    {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonSerializer<LocalDateTime>) (date, type, context) ->
                        date == null ? null : new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonDeserializer<LocalDateTime>) (json, type, context) ->
                        LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .registerTypeAdapter(String.class,
                        (JsonSerializer<String>) (string, type, context) ->
                        new JsonPrimitive(string));
    }

    @Bean
    public Gson gson(GsonBuilder gsonBuilder)
    {
        return gsonBuilder.create();
    }

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter(Gson gson)
    {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(gson);
        return converter;
    }

}

