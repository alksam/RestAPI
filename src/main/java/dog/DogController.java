package dog;



import io.javalin.http.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class DogController {

   public static Map<Integer, DogDTO> dogs = new HashMap<>(Map.of(
            1, new DogDTO(1, "Buddy", "Golden Retriever","han", 3),
            2, new DogDTO(2, "Molly", "Goldendoodle", "hun", 4),
            3, new DogDTO(3, "Max", "Labrador", "han", 2),
            4, new DogDTO(4, "Lucy", "Beagle", "hun", 5)
    ));

    public static int nextId = 1;

    public static void getAllDogs( Context ctx) {
        ctx.json(dogs.values());
    }

    public static void getDogById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        DogDTO dog = dogs.get(id);
        if (dog != null) {
            ctx.json(dog);
        } else {
            ctx.status(404).result("Dog not found");
        }
    }

    public static void createDog(Context ctx) {
        String name = ctx.formParam("name");
        String breed = ctx.formParam("breed");
        String gender = ctx.formParam("gender");
        int age = Integer.parseInt(ctx.formParam("age"));
        DogDTO newDog = new DogDTO(nextId, name, breed, gender, age);
        dogs.put(nextId, newDog);
        nextId++; // Increment nextId after adding a new dog
        ctx.json(newDog);
    }

    public static void updateDog(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        if (dogs.containsKey(id)) {
            String name = ctx.formParam("name");
            String breed = ctx.formParam("breed");
            String gender = ctx.formParam("gender");
            int age = Integer.parseInt(ctx.formParam("age"));
            DogDTO updatedDog = new DogDTO(id, name, breed, gender, age);
            dogs.put(id, updatedDog);
            ctx.json(updatedDog);
        } else {
            ctx.status(404).result("Dog not found");
        }
    }

    public static void deleteDog(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        DogDTO removedDog = dogs.remove(id);
        if (removedDog != null) {
            ctx.json(removedDog);
        } else {
            ctx.status(404).result("Dog not found");
        }
    }
}