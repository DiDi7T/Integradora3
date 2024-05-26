package model;
import java.util.Calendar;
public class Request {
    private Calendar registerDate;
    private String description;
    private StatusReq status;
    private Collaborator responsible;
    private Area areaReq;

    public Request(String description, StatusReq status, Area areaReq,Collaborator responsible) {
        this.registerDate = Calendar.getInstance();
        this.description = description;
        this.status = status;
        this.responsible = responsible;
        this.areaReq = areaReq;
    }

    public Calendar getRegisterDate() {
        return registerDate;
    }

    public String getDescription() {
        return description;
    }

    public StatusReq getStatus() {
        return status;
    }

    public void setStatus(StatusReq status) {
        this.status = status;
    }

    public Collaborator getResponsible() {
        return responsible;
    }

    public Area getAreaReq() {
        return areaReq;
    }

 

    
    
}
