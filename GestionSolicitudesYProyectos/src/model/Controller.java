package model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.ArrayList;

public class Controller {
	private ArrayList<Project> storage;
	private ArrayList<Area> areas;
	private ArrayList<Collaborator> collaborators;
	//private Area[] areas;
	//private Collaborator[] collaborators;
	

	public Controller() {
		storage = new ArrayList<Project>();
		areas = new ArrayList<Area>();
		collaborators=new ArrayList<Collaborator>();
		//areas =new Area[500];
		//collaborators=new Collaborator[4];

		

		createTestCases();
	}

	/**
	 * Description: This method allows you to create test cases that later help
	 * validate the operation of important methods
	 */
	public void createTestCases() {
		addArea("Departamento de Computacion y sistemas inteligentes", "COD0", "AREA DE TRANSFORMACION","Ana sofia Cabrera");
		addArea("Direccion de Planeacion y Gestion de Calidad", "COD", "Area de Transformacion y Mejoramiento","Ana sofia Cabrera");
		addCollaborator("COD","1029293", "JUAN FELIPE", "jsjsjak", "jsajksajk");

		storageKnowledge("COD4", "Prueba Proyectos", "Activo", "08-05-2023", 3, "Ana Sanchez", "Proyectos", 3, 3);
		storageTransformation("COD5", "Prueba Proyectoss", "Cerrado", "28-05-2023", 3, "Ana Sanchez", "BU");
	}

	/**
	 * Description: This method allows you to list the offices
	 * 
	 * @return list of offices
	 */
	// public String listArea() {
	// 	String list = "| " + String.format("%2s %7s %2s %7s", "N°", "Oficina Asociada", "Codigo", "Nombre", "\n");
	// 	for (int i = 0; i < areas.length; i++) {
	// 		if (areas[i] != null) {
	// 			list += "\n| " + (i + 1) + ".  " + areas[i].getOffice() + ". "+areas[i].getCode()+". "+areas[i].getName()+" |\n";
	// 		}
	// 	}
	// 	return list;
	// }


	public String listArea() {

	

		String lista = "";

		for (int i = 0; i < areas.size(); i++) {

			lista += "\n" + areas.get(i).getCode() + "-" + areas.get(i).getName() + "-"
					+ areas.get(i).getOffice();

		}

		return lista;

	}


	public String listCollaborator() {


		String lista = "";

		for (int i = 0; i < collaborators.size(); i++) {

			lista += "\n" + collaborators.get(i).getId() + "-" + collaborators.get(i).getFullName() + "-"
					+ collaborators.get(i).getArea();

		}

		return lista;

	}






	/**
	 * Description: This method allows you to list the offices
	 * 
	 * @return list of offices
	 */
	// public String listCollaborator() {
	// 	String list = "| " + String.format("%2s %7s %2s %7s", "N°", "Identificacion", "Nombre Completo", "Correo electronico","Extension", "\n");
	// 	for (int i = 0; i < collaborators.length; i++) {
	// 		if (collaborators[i] != null) {
	// 			list += "\n| " + (i + 1) + ".  " + collaborators[i].getId() + ". "+collaborators[i].getFullName()+". "+collaborators[i].getEmail()+". "+collaborators[i].getArea()+" |\n";
	// 		}
	// 	}
	// 	return list;
	// }

	/**
	 * Description: This method allows to system register offices
	 * 
	 * @param name of office
	 * @return boolean If the project was saved correctly it will be True, if not it
	 *         will be False.
	 */

	// public boolean addArea(String nameOffice, String code, String name, String leader) {

	// 	Area newArea = new Area(nameOffice,code,name,leader);

	// 	for (int i = 0; i < areas.length; i++) {

	// 		if (areas[i] == null) {

	// 			areas[i] = newArea;

	// 			return true;
	// 		} else if (areas[i].getName().equals(name)) {
	// 			return false;
	// 		}

	// 	}

	// 	return false;
	// }


	public boolean addArea(String nameOffice, String code, String name, String leader) {

		Area newArea = new Area(nameOffice,code,name,leader);
		for (int i = 0; i < areas.size(); i++) {

			if (areas.get(i).getCode().equals(code)) {

				return false;
			}
			
			
		}

		return areas.add(newArea); 


	}


	

	private Area searchArea(String codeArea) {

		for (int i = 0; i < areas.size(); i++) {

			Area temporal = areas.get(i);

			if (temporal != null) {

				if (codeArea.equalsIgnoreCase(temporal.getCode())) {

					return temporal;

				}
			}

		}

		return null;
	}

	/**
	 * Description: This method allows to system register offices
	 * 
	 * @param name of office
	 * @return boolean If the project was saved correctly it will be True, if not it
	 *         will be False.
	 */

	//  public boolean addCollaborator(String area,String id, String fullName, String email, String extension) {

	// 	Area temporal=searchArea(area);
			
	// 	if(temporal!=null){

	// 		Collaborator newCollab = new Collaborator(temporal,id,fullName,email,extension);

	// 		for (int i = 0; i < collaborators.length; i++) {

	// 			if (collaborators[i] == null) {

	// 				collaborators[i] = newCollab;

	// 				return true;
	// 			} else if (collaborators[i].getId().equals(id)) {
	// 				return false;
	// 			}

	// 		}
	// 	}

		

	// 	return false;
	// }
	 public boolean addCollaborator(String area,String id, String fullName, String email, String extension) {

		Area temporal=searchArea(area);
			
		if(temporal!=null){
			Collaborator newCollab = new Collaborator(temporal,id,fullName,email,extension);


			for (int i = 0; i < collaborators.size(); i++) {

				if (collaborators.get(i).getId().equals(id)) {
	
					return false;
	
				}
	
			}
	
			return collaborators.add(new Collaborator(temporal,id,fullName,email,extension)); // Polimorfismo
		}

	}

	

	/**
	 * Description: This method allows you to list the projects
	 * that are stored in the array, returning a list with the name and area of each
	 * place
	 * pre: the storage array is initialized
	 * 
	 * @return list with registered project showing code and name of the project
	 */
	public String listProjects() {

		String list = "| " + String.format("%2s %7s %2s", "N°", "Codigo", "Nombre", "\n") + "\n";

		for (int i = 0; i < storage.size(); i++) {

			if (storage.get(i) != null) {

				list += "| " + (i + 1) + ".  " + storage.get(i).getCode() + "-" + storage.get(i).getName() + " |\n";

			}
		}

		return list;
	}

	/**
	 * Description: This method allows you to list the projects opens
	 * 
	 * pre: the storage array is initialized
	 * 
	 * @return list with registered project showing code and name of the project
	 */
	public String listProjectsOpens() {

		String list = "";
		boolean validate = validateOpens();

		if (validate) {
			list += "| " + String.format("%2s %7s %2s", "N°", "Codigo", "Nombre", "\n") + "\n";
			for (int i = 0; i < storage.size(); i++) {
				if (storage.get(i).getStatus().equalsIgnoreCase("Activo")) {
					list += "| " + (i + 1) + ".  " + storage.get(i).getCode() + "-" + storage.get(i).getName() + " |\n";
				}
			}
		} else {
			list += "No hay proyectos para cerrar";
		}
		return list;
	}

	public boolean validateOpens() {
		for (int i = 0; i < storage.size(); i++) {
			if (storage.get(i).getStatus().equalsIgnoreCase("Activo")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Descripcion: this method allows change status of project
	 * 
	 * @param code      of project
	 * @param newStatus the new status for project
	 * @return boolean
	 */
	public boolean closedProject(String code, String status) {

		return searchProject(code).setStatus(status);

	}

	/**
	 * Description: This method allows you to list the types of comunity impact
	 * 
	 * @return list of comunity types
	 */
	public String listCommunity() {

		Community[] typeComunityArray = Community.values();

		String list = "";

		for (int i = 0; i < typeComunityArray.length; i++) {

			list += "\n" + (i + 1) + "-" + typeComunityArray[i];
		}

		return list;
	}

	/**
	 * Description: This method allows you to list the types of project Knowledge
	 * 
	 * @return list of project Knowledge types
	 */

	public String listType() {

		Type[] typeArray = Type.values();

		String list = "";

		for (int i = 0; i < typeArray.length; i++) {

			list += "\n" + (i + 1) + "-" + typeArray[i];
		}

		return list;
	}

	/**
	 * Description: This method allows you to list the priorities
	 * 
	 * @return list of priority
	 */

	public String listPriority() {

		Priority[] priorityArray = Priority.values();

		String list = "";

		for (int i = 0; i < priorityArray.length; i++) {

			list += "\n" + (i + 1) + "-" + priorityArray[i];
		}

		return list;
	}

	/**
	 * Description: This method allows you to store a project Knowledge in the
	 * system
	 * pre: the storage array is initialized
	 * 
	 * @param code        String The code of Project
	 * @param name        The name of project
	 * @param status      The status of project
	 * @param date        The date accepting project
	 * @param priority    The priority of project
	 * @param nameleader  The name of leader of project
	 * @param nameProcess The name of process of project
	 * @param community   The community impact
	 * @param type        The type of project knowledge
	 * @return boolean If the project was saved correctly it will be True, if not it
	 *         will be False.
	 */

	public boolean storageKnowledge(String code, String name, String status, String date, int prioridad,
			String nameLeader, String nameProcess, int community, int type) {

		String[] arrayDate = date.split("-"); // esplit es para partir cadenas de texto.

		int day = Integer.parseInt(arrayDate[0]);
		int month = Integer.parseInt(arrayDate[1]) - 1;
		int year = Integer.parseInt(arrayDate[2]);

		Calendar newDate = Calendar.getInstance();
		newDate.set(year, month, day);

		Priority newPriority = Priority.URGENTE;
		String timeClosed = "";

		switch (prioridad) {

			case 1: 
				newPriority = Priority.URGENTE;
				timeClosed = "5 dias";
				break;

			case 2:
				newPriority = Priority.ALTA;
				timeClosed = "10 dias";
				break;

			case 3:
				newPriority = Priority.MEDIA;
				timeClosed = "30 dias";
				break;

			case 4:
				newPriority = Priority.BAJA;
				timeClosed = "60 dias";
				break;
		}

		for (int i = 0; i < storage.size(); i++) {

			if (storage.get(i).getCode().equals(code)) {

				return false;

			}

		}
		return storage.add(new Knowledge(code, name, status, newDate, newPriority, nameLeader, timeClosed, nameProcess,
				Community.values()[community - 1], Type.values()[type - 1]));

	}

	/**
	 * Description: This method allows you to store a project Transformation in the
	 * system
	 * pre: the storage array is initialized
	 * 
	 * @param code        String The code of Project
	 * @param name        The name of project
	 * @param status      The status of project
	 * @param date        The date accepting project
	 * @param priority    The priority of project
	 * @param nameleader  The name of leader of project
	 * @param codeProcess The code of process of project
	 * 
	 * @return boolean If the project was saved correctly it will be True, if not it
	 *         will be False.
	 */

	public boolean storageTransformation(String code, String name, String status, String date, int prioridad,
			String nameLeader, String codeProcess) {

		String[] arrayDate = date.split("-"); // esplit es para partir cadenas de texto.

		int day = Integer.parseInt(arrayDate[0]);
		int month = Integer.parseInt(arrayDate[1]) - 1;
		int year = Integer.parseInt(arrayDate[2]);

		Calendar newDate = Calendar.getInstance();
		newDate.set(year, month, day);

		Priority newPriority = Priority.URGENTE;
		String timeClosed = "";

		switch (prioridad) {

			case 1:
				newPriority = Priority.URGENTE;
				timeClosed = "5 dias";
				break;

			case 2:
				newPriority = Priority.ALTA;
				timeClosed = "10 dias";
				break;

			case 3:
				newPriority = Priority.MEDIA;
				timeClosed = "30 dias";
				break;

			case 4:
				newPriority = Priority.BAJA;
				timeClosed = "60 dias";
				break;
		}

		for (int i = 0; i < storage.size(); i++) {

			if (storage.get(i).getCode().equals(code)) {

				return false;

			}

		}
		return storage
				.add(new Transformation(code, name, status, newDate, newPriority, nameLeader, timeClosed, codeProcess));

	}

	/**
	 * Description: This method allows you to search for a project through its code,
	 * comparing the entered string with the code
	 * from the project stored in the array
	 * pre: the storage array is initialized
	 * 
	 * @param code String The code of the place to search
	 * @return project The searched place
	 */

	public Project searchProject(String code) {

		int i = searchIndexProject(code);
		if (i != -1) {

			return storage.get(i);
		}
		return null;

	}

	/**
	 * Description: This method allows obtaining the index of a Project given its
	 * code
	 * pre: The storage array is initialized
	 *
	 * @param String code, the Project code to search
	 * @return int, the Project index. -1 in case the Project is not find registered
	 */
	public int searchIndexProject(String code) {

		for (int i = 0; i < storage.size(); i++) {

			Project temporal = storage.get(i);

			if (temporal != null) {

				if (code.equalsIgnoreCase(temporal.getCode())) {

					return i;

				}
			}

		}

		return -1;

	}

	/**
	 * Description: This method allows displaying the project that the user
	 * requested by code, also validates if the project exists
	 * 
	 * @param code The code of the project to search
	 * @return String The information of the searched project
	 */

	public String showProject(String code) {

		Project temporal = searchProject(code);

		if (temporal == null) {

			return "el proyecto no se encuentra";

		}
		return temporal.toString();

	}

	/**
	 * Description: This method allows you to update a Priority in project in the
	 * system
	 * pre: the storage array is initialized
	 * 
	 * @param code     The code of the project search
	 * @param priority The priority of the project
	 * @return boolean If the specie was saved correctly it will be True, if not it
	 *         will be False.
	 */
	// public boolean updatePriorityInProject(String code, int priority ) {

	// Priority newPriority = Priority.URGENTE;
	// String timeClosed="";

	// switch(priority){

	// case 1:
	// newPriority = Priority.URGENTE;
	// timeClosed="5 dias";
	// break;

	// case 2:
	// newPriority = Priority.ALTA;
	// timeClosed="10 dias";
	// break;

	// case 3:
	// newPriority = Priority.MEDIA;
	// timeClosed="30 dias";
	// break;

	// case 4:
	// newPriority = Priority.BAJA;
	// timeClosed="60 dias";
	// break;
	// }

	// int i =searchIndexProject(code);

	// if(temporal!=null){
	// //Specie newSpecie = new Specie (temporal,name,newType,photo,amount);

	// return temporal.set(temporal, newPriority,timeClosed);

	// }
	// for (int i = 0; i < storage.size(); i++) {

	// if (storage.get(i).getCode().equals(code)) {

	// return false;

	// }

	// }
	// return storage.set(i,newPriority,i,timeClosed));

	// return false;
	// }

}
