package tank;

import java.io.IOException;
import java.util.Properties;

public class Prop {
    private Prop(){

    }
    private static Properties properties = null;
    static {
        properties = new Properties();
        try {
            properties.load(Prop.class.getClassLoader().getResourceAsStream("config.property"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key){
        if(properties == null){
            return null;
        }
        return properties.get(key);
    }
}
