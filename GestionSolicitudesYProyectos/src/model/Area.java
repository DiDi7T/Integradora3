package model;


public class Area {
    private String office;
    private String code;
    private String name;
    private String leader;
    
    public Area(String office, String code, String name, String leader) {
        this.office = office;
        this.code = code;
        this.name = name;
        this.leader=leader;
    }

    @Override
    public String toString() {
        String msg= "";
		
		
		msg+= "Oficina a la que pertenece:" + office;
		msg += "\nCodigo del area" +code;
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
}
