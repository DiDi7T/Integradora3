package model;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Knowledge extends Project{
	
	private String nameProcess;
	private Community community;
	private Type type;

	

	public Knowledge(String code, String name, String status, Calendar date, Priority priority, Collaborator nameLeader,
			String timeClosed, String nameProcess, Community community, Type type) {
		super(code, name, status, date, priority, nameLeader, timeClosed);
		this.nameProcess = nameProcess;
		this.community = community;
		this.type = type;
	}

	public String getNameProcess() {
		return nameProcess;
	}

	public Community getCommunity() {
		return community;
	}
	

	@Override
	public String toString() {


		String msg = "";

		msg += "Codigo: " + getCode();
		msg += "\nNombre: " + getName();
		msg += "\nStatus: "+ getStatus();
		msg += "\nFecha de aceptacion del proyecto:  "+  new SimpleDateFormat("dd/MM/yyyy").format(getDate().getTime());
		msg += "\nPrioridad: " + getPriority();
		msg += "\nNombre del lider: "+getNameLeader();
		msg +="\nDias para cerrar: " + getTimeClosed();
		msg +="\nNombre del proceso a gestionar:"+nameProcess;
		msg +="\nComunidad impactada: "+community;
		msg += "\nTipo de proyecto de gestion de conocimiento: "+type;


		return msg;
		
	}

	public Type getType() {
		return type;
	}
	
	
	
}