import com.google.gson.Gson;
import dagger.Component;

import static spark.Spark.get;

public class Application {

    @Component(modules = { MessageModule.class })
    public interface MessageApplication {
        MyMessage get();
    }

    public static void main(String[] args) {
        MessageApplication message = DaggerApplication_MessageApplication.builder().build();
        Gson gson = new Gson();
        MyMessage myMessage = message.get();
        myMessage.setMessage("Hello World");
        get("/hello", (request, response) -> myMessage, gson::toJson);
    }
}
