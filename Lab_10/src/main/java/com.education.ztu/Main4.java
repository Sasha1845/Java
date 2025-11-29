package com.education.ztu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.education.ztu.game.Schoolar;

public class Main4 {

    public static void main(String[] args) throws Exception {

        Schoolar person = new Schoolar("John Doe", 30);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println("Java to JSON: " + json);

        String jsonInput = "{\"name\":\"Jane Doe\",\"age\":30}";
        Schoolar deserializedPerson = objectMapper.readValue(jsonInput, Schoolar.class);
        System.out.println("JSON to Java: Name - " + deserializedPerson.getName() + ", Age - " + deserializedPerson.getAge());
    }
}

