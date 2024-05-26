package model;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Request {
    private String code;
    private Calendar registerDate;
    private String description;
    private StatusReq status;
    private Collaborator responsible;
    private Area areaReq;
    private Calendar statusDate;

    public Request(String code,String description, StatusReq status, Area areaReq,Collaborator responsible) {
        this.code=code;
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
        this.statusDate=Calendar.getInstance();
        this.status = status;
    }

    public Collaborator getResponsible() {
        return responsible;
    }

    public Area getAreaReq() {
        return areaReq;
    }



    public String getCode() {
        return code;
    }

    @Override
	public String toString() {

		String msg = "";

		msg += "Codigo de la solicitud: " + code;
		msg += "\nFecha de registro: " + new SimpleDateFormat("dd/MM/yyyy").format(registerDate.getTime());
		msg += "\nDescripcion: "+ description;
		msg += "\nEstado:  "+  status;
		msg += "\nArea solicitante: " + areaReq;
		msg += "\nColaborador responsable: "+responsible;
		

		return msg;
		
	}



    public Calendar getStatusDate() {
        return statusDate;
    }
 

    
    
}
