package model;

import java.util.ArrayList;

public class Area {
    private String office;
    private String code;
    private String name;
    private String leader;
    private ArrayList<Collaborator> collaborators;

    public Area(String office, String code, String name, String leader) {
        this.office = office;
        this.code = code;
        this.name = name;
        this.leader = leader;
        this.collaborators = new ArrayList<>();
    }

    @Override
    public String toString() {
        String msg = "";

        msg += "Oficina a la que pertenece:" + office;
        msg += "\nCodigo del area" + code;
        msg += "\nNombre del area: " + name;
        msg += "\nNombre del lider de area: " + leader;

        return msg;
    }

    public String getCode() {
        return code;
    }

    public String getOffice() {
        return office;
    }

    public String getName() {
        return name;
    }

    public String getLeader() {
        return leader;
    }

    public ArrayList<Collaborator> getCollaborators() {
        return collaborators;
    }
    public boolean addCollaborator(Collaborator collaborator) {
        if (this.collaborators.size() < 4) {
            this.collaborators.add(collaborator);
            return true;
        } else {
            return false;
        }
    }
}
