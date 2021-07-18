package password.manager.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.Expose;

public class Service implements Serializable {
    @Expose
    private String serviceName;
    @Expose
    private String userName;
    @Expose
    private String password;
    @Expose
    private String notes;
    
    public Service() {
        serviceName = "";
        userName = "";
        password = "";
        notes = "";
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    @Override
    public void fromJSON(String json) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
        password = jsonObject.get("password").getAsString();
        notes = jsonObject.get("notes").getAsString();
        userName = jsonObject.get("userName").getAsString();
        serviceName = jsonObject.get("serviceName").getAsString();
    }

    @Override
    public String toJSON() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(this);
    }
}
