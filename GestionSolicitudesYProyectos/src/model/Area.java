package model;

public class Area {
    private String office;
    private String code;
    private String name;
    private String leader;
    private Collaborator[] collaborators;

    public Area(String office, String code, String name, String leader) {
        this.office = office;
        this.code = code;
        this.name = name;
        this.leader = leader;
        collaborators = new Collaborator[4];
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

    public boolean addCollaborator(Collaborator newCollab) {

        for (int i = 0; i < collaborators.length; i++) {

            if (collaborators[i] == null) {

                collaborators[i] = newCollab;

                return true;
            }

        }

        return false;
    }
}
