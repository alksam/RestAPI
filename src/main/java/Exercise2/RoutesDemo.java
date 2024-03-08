package Exercise2;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.get;

public class RoutesDemo {

    public static void main(String[] args) {
    Javalin app = Javalin.create().start(7007);


    List<ProductDTO> products = new ArrayList<>();
    products.add(new ProductDTO(1, "Milk", 2.5, "Dairy"));
    products.add(new ProductDTO(2, "Bread", 1.5, "Bakery"));
    products.add(new ProductDTO(3, "Cheese", 3.5, "Dairy"));
    products.add(new ProductDTO(4, "Yogurt", 2.0, "Dairy"));


    app.routes(
            ()-> {
        path("product", ()-> {
            get("/", ctx -> ctx.json(products));
            get("{id}", ctx -> {
                int id = Integer.parseInt(ctx.pathParam("id"));
                ProductDTO p = products.stream().filter(product -> product.getId() == id).findFirst().get();
                ctx.json(p);
            });
            get("{category}", ctx -> {
                String category = ctx.pathParam("category");
                ProductDTO p = products.stream().filter(product -> product.getCategory().equals(category)).findFirst().get();
                if (p != null) {
                    ctx.json(p);
                } else {
                    ctx.status(404).result("Product not found in the given category");
                }
            });
            post("/", ctx -> {
                ProductDTO p = ctx.bodyAsClass(ProductDTO.class);
                products.add(p);
                ctx.json(p);
            });
        });
    });





    }




    }



