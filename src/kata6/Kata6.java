package kata6;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import static java.util.stream.Collectors.joining;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Kata6 {
    
    

    public static void main(String[] args) throws IOException, JAXBException {
        String json = read("https://www.themealdb.com/api/json/v1/1/random.php");
        Gson gson = new Gson();
        System.out.println(json);
        Meal meal = gson.fromJson(gson.fromJson(json, 
                JsonObject.class).getAsJsonObject().get("meals").getAsJsonArray().get(0).getAsJsonObject(), Meal.class);
        System.out.println(meal);
        
        
        
        JAXBContext context = JAXBContext.newInstance(Meal.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(meal, System.out);        
    }
    
    

    private static String read(String url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            return reader.lines().collect(joining(" "));
        }
    }
    
    
}
