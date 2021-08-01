package password.manager.Model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;


public class Storage {
    private String fileName = "vault.dat";
    private String password = "";
    public Storage() {
        
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean fileExists() {
        return new File(fileName).isFile();
    }
    
    public ArrayList<Service> load() {
        
        String json;
        try {
            json = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            return null;
        }
        
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
        JsonArray servicejson = jsonObject.get("services").getAsJsonArray();
        
        ArrayList<Service> serviceList = new ArrayList<>();
        
        for (int i = 0; i < servicejson.size(); i++) {
            Service s = new Service();
            s.fromJSON(servicejson.get(i).toString());
            serviceList.add(s);
        }
        
        return serviceList;
    }
    
    public boolean store(ArrayList<Service> services) {
        String result = "{\"services\":[";
        for (int i = 0; i < services.size(); i++) {
            result += services.get(i).toJSON();
            if (i != services.size()-1) {
                result += ",";
            }
        }
        result += "]}";
 
        try {
            Files.write(Paths.get(fileName), 
                result.getBytes(StandardCharsets.UTF_8)
            );
        }
        catch (IOException e) {
            return false;
        }
        
        return true;
    }
}
