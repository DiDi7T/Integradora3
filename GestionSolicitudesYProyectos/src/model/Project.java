package model;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public abstract class Project{
	
	
	private String code;
	private String name;
	private String status;
	private Calendar date;
	private Priority priority;
	private String nameLeader;
	private String timeClosed;

	public Project(String code, String name, String status, Calendar date, Priority priority, String nameLeader,
			String timeClosed) {
		this.code = code;
		this.name = name;
		this.status = status;
		this.date = date;
		this.priority = priority;
		this.nameLeader = nameLeader;
		this.timeClosed = timeClosed;
	}

	


	@Override
	public String toString() {

		String msg = "";

		msg += "Codigo: " + code;
		msg += "\nNombre: " + name;
		msg += "\nStatus: "+ status;
		msg += "\nFecha:  "+  new SimpleDateFormat("dd/MM/yyyy").format(date.getTime());
		msg += "\nPrioridad: " + priority;
		msg += "\nNombre del lider: "+nameLeader;
		msg +="\nDias para cerrar=" + timeClosed;

		return msg;
		
	}




	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public Calendar getDate() {
		return date;
	}

	public Priority getPriority() {
		return priority;
	}

	public String getNameLeader() {
		return nameLeader;
	}

	public String getTimeClosed() {
		return timeClosed;
	}

	public boolean setPriority(Priority priority) {
		this.priority = priority;
		return true;
	}


	

	public boolean setStatus(String status) {
		this.status = status;
		return true;
	}




	public boolean setTimeClosed(String timeClosed) {
		this.timeClosed = timeClosed;
		return true;
	}
	


	
	
}