package model;

import java.util.ArrayList;

public class Collaborator {
    
    private Area area;
    private String id;
    private String fullName;
    private String email;
    private String extension;
    private ArrayList<Project> projects;


    public Collaborator(Area area, String id, String fullName, String email, String extension) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.extension = extension;
        this.area=area;
        this.projects = new ArrayList<>();
      
    }


    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getExtension() {
        return extension;
    }

    public Area getArea() {
        return area;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        String msg= "";
		
		
		msg+= "Numero de identificacion:" + id;
		msg += "\nNombre Completo" +fullName;
		msg += "\nNombre del area: " + area.getName();
        msg += "\nNumero de la extension " + extension;
		
		return msg;
    }
    


       

}
