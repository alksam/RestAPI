package Exercise3;

import io.javalin.Javalin;

    public class ContextDemo {

        public static void main(String[] args) {
            Javalin app = Javalin.create().start(7000);

            // GET /hello/{name}
            app.get("/hello/{name}", ctx -> {
                String name = ctx.pathParam("name");
                ctx.result("Hello, " + name + "!");
            });

            // GET /headers
            app.get("{headers}", ctx -> {
                ctx.json(ctx.headerMap());
            });

            // GET /queryParam
            app.get("{queryParam}", ctx -> {
                String name = ctx.queryParam("name");
                ctx.result("Query parameter 'name' value: " + name);
            });

            // GET /responseHeaders
            app.get("{responseHeaders}", ctx -> {
                ctx.header("X-My-Header", "Hello World");
                ctx.result("Response with custom header: X-My-Header");
            });

            // GET /responseStatus
            app.get("{responseStatus}", ctx -> {
                ctx.status(418);
                ctx.result("I'm a teapot");
            });

            // Error handling
            app.exception(Exception.class, (e, ctx) -> {
                ctx.status(500);
                ctx.result("Internal Server Error");
            });
        }
    }


