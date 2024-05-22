package model;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Transformation extends Project{
	
	private String codeProcess;
	private Calendar dateClosed;

    public Transformation(String code, String name, String status, Calendar date, Priority priority, String nameLeader,
            String timeClosed, String codeProcess) {
        super(code, name, status, date, priority, nameLeader, timeClosed);
        this.codeProcess = codeProcess;
        Calendar newDate=(Calendar) date.clone();
        
       
        this.dateClosed = calculateDateClosed(priority, newDate);
    }

    public String getCodeProcess() {
        return codeProcess;
    }

    

    @Override
    public String toString() {
        String msg = "";
        msg += "Codigo: " + getCode();
        msg += "\nNombre: " + getName();
        msg += "\nStatus: " + getStatus();
        msg += "\nFecha de aceptacion del proyecto:  " + new SimpleDateFormat("dd/MM/yyyy").format(getDate().getTime());
        msg += "\nPrioridad: " + getPriority();
        msg += "\nNombre del lider: " + getNameLeader();
        msg += "\nDias para cerrar: " + getTimeClosed();
        msg += "\nCodigo del proceso:" + codeProcess;
        msg += "\nFecha estimada de cierre: " + new SimpleDateFormat("dd/MM/yyyy").format(dateClosed.getTime());
        return msg;
    }

   
    public Calendar getDateClosed() {
        return dateClosed;
    }
	

    public Calendar calculateDateClosed(Priority priority, Calendar newdate){

        Calendar dateClosed = newdate;

        if(priority.equals(Priority.URGENTE)){
            dateClosed.add(Calendar.DAY_OF_MONTH, 5);
        }else if(priority.equals(Priority.ALTA)){
            dateClosed.add(Calendar.DAY_OF_MONTH, 10);
        }else if (priority.equals(Priority.MEDIA)) {
            dateClosed.add(Calendar.DAY_OF_MONTH, 30);
        }else{
            dateClosed.add(Calendar.DAY_OF_MONTH, 60);
        }
            
        return dateClosed;
    }



}