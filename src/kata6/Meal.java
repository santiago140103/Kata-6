package kata6;

import com.google.gson.annotations.SerializedName;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Meal {
    
    @SerializedName("idMeal")
    public String code;
    @SerializedName("strMeal")
    public String name;
    @SerializedName("strCategory")
    public String category;
    @SerializedName("strInstructions")
    public String instructions;

    @Override
    public String toString() {
        return "Meal: " + "Name=" + name + ", code=" + code + ", Category=" + category + ", Instructions=" + instructions + '}';
    }
    
    
}
