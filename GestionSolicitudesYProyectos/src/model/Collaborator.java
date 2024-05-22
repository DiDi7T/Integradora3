package model;

public class Collaborator {
    
    private String id;
    private String fullName;
    private String email;
    private String extension;
    private Project[] projects;

    public Collaborator(String id, String fullName, String email, String extension) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.extension = extension;
       
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

    public Project[] getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        String msg= "";
		
		
		msg+= "Numero de identificacion:" + id;
		msg += "\nNombre Completo" +fullName;
		msg += "\nNombre del area: " + email;
        msg += "\nNombre del lider de area: " + extension;
		
		return msg;
    }


       

}
