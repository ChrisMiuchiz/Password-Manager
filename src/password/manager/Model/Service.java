package password.manager.Model;


public class Service implements Serializable {
    private String serviceName;
    private String userName;
    private String password;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toJSON() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
