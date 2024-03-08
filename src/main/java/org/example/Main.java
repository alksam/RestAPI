package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.apibuilder.EndpointGroup;
import lombok.*;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.*;
import static io.javalin.apibuilder.ApiBuilder.get;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("John", 30),
                new Person("Jane", 25),
                new Person("Tom", 40)
        );

        ObjectMapper om = new ObjectMapper();


        Javalin app = Javalin.create().start(7007);

       /* app.get("person", ctx -> ctx.json(persons)); // return list of persons
        app.get("person/{name}", ctx -> {
            String name = ctx.pathParam("name");
            ctx.json(persons.stream().filter(p -> p.getName().equals(name)).findFirst());
        }); // return person by name*/

        app.routes(
                () -> {
                    path ("person", () -> {
                        get("/", ctx -> ctx.json(persons));
                        get("{name}", ctx -> {
                            String name = ctx.pathParam("name");
                            Person p = persons.stream().filter(person -> person.getName().equals(name)).findFirst().get();
                            ctx.json(p);
                        });

                        post("/", ctx -> {
                            Person pe = ctx.bodyAsClass(Person.class);
                            ctx.json(pe);

                        });
                    });
                }
        );




        app.get("/Today's", ctx -> ctx.json(
                om.createObjectNode()
                        .put("date", LocalDate.now().toString())
        )); // return today's date




    }




    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @EqualsAndHashCode
    private static class Person {
        String name;
        int age;
    }




}