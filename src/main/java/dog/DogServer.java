package dog;

import io.javalin.Javalin;

import java.util.HashMap;
import java.util.Map;

public class DogServer {

    private static Map<Integer, Dog> dogs = new HashMap<>();
    private static int nextId = 1;

    public static void main(String[] args) {


        Javalin app = Javalin.create().start(7007);

/*        // Route to get all dogs
        app.get("/api/dogs", ctx -> ctx.json(dogs.values()));

        app.get("/api/dogs/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Dog dog = dogs.get(id);
            if (dog != null) {
                ctx.json(dog);
            } else {
                ctx.status(404).result("Dog not found");
            }
        });

        app.post("/api/dogs", ctx -> {
            String name = ctx.formParam("name");
            int age = Integer.parseInt(ctx.pathParam("age"));
            Dog newDog = new Dog(nextId, name, age);
            dogs.put(nextId, newDog);
            nextId++;
            ctx.json(newDog);
        });

        // Route to update an existing dog
        app.put("/api/dogs/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            if (dogs.containsKey(id)) {
                String name = ctx.formParam("name");
                int age = Integer.parseInt(ctx.pathParam("age"));
                Dog updatedDog = new Dog(id, name, age);
                dogs.put(id, updatedDog);
                ctx.json(updatedDog);
            } else {
                ctx.status(404).result("Dog not found");
            }
        });

        // Route to delete an existing dog
        app.delete("/api/dogs/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Dog removedDog = dogs.remove(id);
            if (removedDog != null) {
                ctx.json(removedDog);
            } else {
                ctx.status(404).result("Dog not found");
            }
        });

*/

        // Route to get all dogs
        app.get("/api/dogs", DogController::getAllDogs);

        // Route to get a specific dog by id
        app.get("/api/dogs/{id}", DogController::getDogById);

        // Route to create a new dog
        app.post("/api/dogs", DogController::createDog);

        // Route to update an existing dog
        app.put("/api/dogs/{id}", DogController::updateDog);

        // Route to delete an existing dog
        app.delete("/api/dogs/{id}", DogController::deleteDog);
    }
    }


