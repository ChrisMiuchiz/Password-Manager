package password.manager.Model;

public interface Serializable {
    public void fromJSON(String json);
    public String toJSON();
}