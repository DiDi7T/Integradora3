package model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Controller {
	private ArrayList<Project> storage;
	private ArrayList<Area> areas;
	private ArrayList<Collaborator> collaborators;
	private ArrayList<Request> request;
	private int counterReq;

	public Controller() {
		storage = new ArrayList<Project>();
		areas = new ArrayList<Area>();
		collaborators = new ArrayList<Collaborator>();
		request = new ArrayList<Request>();
		counterReq = 0;

		createTestCases();
	}

	/**
	 * Description: This method allows you to create test cases that later help
	 * validate the operation of important methods
	 */
	public void createTestCases() {
		addArea("Departamento de Computacion y sistemas inteligentes", "ARE0", "Area de informacion",
				"Ana sofia Cabrera");

		addArea("Direccion de Planeacion y Gestion de Calidad", "ARE1", "Area de Transformacion y Mejoramiento",
				"Ana sofia Henao");
		addCollaborator("ARE1", "123", "Juan Felipe Cabrera", "juan.f@gmail.com", "230");
		addCollaborator("ARE1", "345", "Ana Sofia Henao", "ana.h@gmail.com", "235");
		addCollaborator("ARE1", "678", "Jesica Pulido", "jess.p@gmail.com", "236");
		addCollaborator("ARE1", "900", "Axel Rose", "axel.r@gmail.com", "237");
		addRequest("ARE0", "se requiere optimizar el proceso de gestion administrativa", 1, "123");

		// storageKnowledge("COD1", "Prueba Proyectos", "Activo", 3, "123", "Proyectos",
		// 3, 3);
		// storageTransformation("CODx", "Prueba Proyectoss", "Cerrado", 3, "123",
		// "BU");
	}

	public String listArea() {

		String lista = "";

		for (int i = 0; i < areas.size(); i++) {

			lista += "\n" + areas.get(i).getCode() + "-" + areas.get(i).getName() + "-"
					+ areas.get(i).getOffice();

		}

		return lista;

	}

	public String listAllCollaboratorsWithAreas() {
		int count = 1;
		String list = "";

		for (Area area : areas) {
			if (area.getCode().equalsIgnoreCase("ARE1")) {
				list += "Área: " + area.getName() + "\n";
				for (Collaborator collaborator : area.getCollaborators()) {
					list += "\n" + count + ". " + collaborator.getFullName() + ", ID: " + collaborator.getId();
					count++;
				}
			}
		}
		return list;
	}

	public boolean addArea(String nameOffice, String code, String name, String leader) {

		Area newArea = new Area(nameOffice, code, name, leader);
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

	// return false;
	// }
	public boolean addCollaborator(String area, String id, String fullName, String email, String extension) {

		Area temporal = searchArea(area);
		Collaborator newCollab = new Collaborator(temporal, id, fullName, email, extension);

		if (temporal != null) {

			return temporal.addCollaborator(newCollab);
		}
		return false;

	}

	public Collaborator searchCollab(String id) {

		for (Area area : areas) {
			for (Collaborator collaborators : area.getCollaborators()) {

				if (collaborators != null && id.equalsIgnoreCase(collaborators.getId())) {

					return collaborators;
				}
			}
		}
		System.out.println("Colaborador no encontrado.");
		return null;

	}

	public String generatorCodeRequest() {
		counterReq++;
		return "COD" + counterReq;
	}

	public boolean addRequest(String areaReq, String description, int status, String id) {
		String code = generatorCodeRequest();
		Area areaReqs = searchArea(areaReq);
		Collaborator collab = searchCollab(id);

		Request newRequest = new Request(code, description, StatusReq.values()[status - 1], areaReqs, collab);
		return request.add(newRequest);

	}

	public Request searchReq(String code) {
		for (Request request : request) {
			if (request.getCode().equalsIgnoreCase(code)) {
				return request;
			}
		}
		return null;
	}

	public String showReq(String code) {

		Request temporal = searchReq(code);

		if (temporal == null) {

			return "La solicitud no se encuentra";

		}
		return temporal.toString();

	}

	public void changeStatusReq(String code, int status) {
		StatusReq newStatus = StatusReq.PENDIENTE;
		Request temporal = searchReq(code);
		switch (status) {
			case 1:
				newStatus = StatusReq.APROBADA;
				break;
			case 3:
				newStatus = StatusReq.RECHAZADA;
				break;
		}
		temporal.setStatus(newStatus);
	}

	public String listReq() {

		String list = "";

		for (int i = 0; i < request.size(); i++) {

			list += "\n" + request.get(i).getCode() + "-" + request.get(i).getDescription() + "-"
					+ request.get(i).getAreaReq().getName() + "-" + request.get(i).getResponsible().getFullName() + "-"
					+ new SimpleDateFormat("dd/MM/yyyy").format(request.get(i).getRegisterDate().getTime()) + "-"
					+ new SimpleDateFormat("dd/MM/yyyy").format(request.get(i).getStatusDate().getTime());

		}

		return list;

	}

	public String listReqOpen() {

		String list = "";

		for (int i = 0; i < request.size(); i++) {
			if (request.get(i).getStatus() == StatusReq.PENDIENTE) {
				list += "\n" + request.get(i).getCode() + "-" +
						request.get(i).getDescription() + "-" +
						request.get(i).getAreaReq().getName() + "-" +
						request.get(i).getResponsible().getFullName() + "-" +
						new SimpleDateFormat("dd/MM/yyyy").format(request.get(i).getRegisterDate().getTime());
			}

		}

		return list;

	}

	/**
	 * Description: This method allows you to list the priorities
	 * 
	 * @return list of priority
	 */

	public String listStatusReq() {

		StatusReq[] statusReqsArray = StatusReq.values();

		String list = "";

		for (int i = 0; i < statusReqsArray.length; i++) {

			list += "\n" + (i + 1) + "-" + statusReqsArray[i];
		}

		return list;
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

	public boolean storageKnowledge(String code, String name, String status, int prioridad,
			String idLeader, String nameProcess, int community, int type) {

		// String[] arrayDate = date.split("-"); // esplit es para partir cadenas de
		// texto.
		Request temporal = searchReq(code);
		// int day = Integer.parseInt(arrayDate[0]);
		// int month = Integer.parseInt(arrayDate[1]) - 1;
		// int year = Integer.parseInt(arrayDate[2]);

		Calendar newDate = temporal.getStatusDate();
		// newDate.set(year, month, day);

		Priority newPriority = Priority.URGENTE;
		String timeClosed = "";
		Collaborator collab = searchCollab(idLeader);

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
		return storage.add(new Knowledge(code, name, status, newDate, newPriority, collab, timeClosed, nameProcess,
				Community.values()[community - 1], Type.values()[type - 1]));

	}

	public String listarProyectosPorColaborador() {
		String list = "";
		for (Area area : areas) {
			if (area.getCode().equalsIgnoreCase("ARE1")) {

				for (Collaborator collaborator : area.getCollaborators()) {
					Collaborator coll = searchCollab(collaborator.getId());
					int projectCount = 0;
					for (Project projects : storage) {
						if (projects.getNameLeader().equals(coll)) {
							projectCount++;

						}
					}

					list += "\nColaborador: " + collaborator.getFullName() + " tiene " + projectCount + " proyectos.";
				}

			}
			
		}return list;
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

	public boolean storageTransformation(String code, String name, String status, int prioridad,
			String idLeader, String codeProcess) {

		// String[] arrayDate = date.split("-"); // esplit es para partir cadenas de
		// texto.
		Request temporal = searchReq(code);
		// int day = Integer.parseInt(arrayDate[0]);
		// int month = Integer.parseInt(arrayDate[1]) - 1;
		// int year = Integer.parseInt(arrayDate[2]);

		Calendar newDate = temporal.getStatusDate();
		// newDate.set(year, month, day);

		Priority newPriority = Priority.URGENTE;
		String timeClosed = "";
		Collaborator collab = searchCollab(idLeader);

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
				.add(new Transformation(code, name, status, newDate, newPriority, collab, timeClosed, codeProcess));

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

	// public void visualizarInformacionMatricial() {

	// for (Collaborator collaborator : collaborators) {
	// ArrayList<Project> projects = collaborator.getProjects();

	// // Ordenar proyectos por prioridad y fecha de cierre
	// Collections.sort(projects, new Comparator<Project>() {
	// @Override
	// public int compare(Project p1, Project p2) {
	// // Comparar por prioridad
	// int priorityComparison = p1.getPriority().compareTo(p2.getPriority());
	// if (priorityComparison != 0) {
	// return priorityComparison;
	// }
	// // Si las prioridades son iguales, comparar por fecha de cierre
	// return p1.getDateClosed().compareTo(p2.getDateClosed());
	// }
	// });

	// // Obtener los últimos 5 proyectos
	// int start = Math.max(0, projects.size() - 5);
	// ArrayList<Project> lastFiveProjects = new ArrayList<>(projects.subList(start,
	// projects.size()));

	// // Imprimir la información en forma matricial
	// System.out.println("Colaborador: " + collaborator.getFullName());
	// for (Project project : lastFiveProjects) {
	// System.out.println("Código: " + project.getCode() + ", Prioridad: " +
	// project.getPriority().name().charAt(0) + ", Fecha de cierre: " +
	// project.getClosureDate());
	// }
	// System.out.println();
	// }
	// }

	public String contarProyectosPorTipoYPrioridad() {
		String list = "";
		int knowledgeManagementUrgent = 0;
		int knowledgeManagementHigh = 0;
		int knowledgeManagementMedium = 0;
		int knowledgeManagementLow = 0;

		int processImprovementUrgent = 0;
		int processImprovementHigh = 0;
		int processImprovementMedium = 0;
		int processImprovementLow = 0;
		int counterK = 0;
		int counterT = 0;

		// for (Collaborator collaborator : collaborators) {
		// ArrayList<Project> projects = collaborator.getProjects();
		for (Project project : storage) {
			if (project instanceof Knowledge) {
				counterK++;
				switch (project.getPriority()) {
					case URGENTE:
						knowledgeManagementUrgent++;
						break;
					case MEDIA:
						knowledgeManagementHigh++;
						break;
					case ALTA:
						knowledgeManagementMedium++;
						break;
					case BAJA:
						knowledgeManagementLow++;
						break;
				}
			} else if (project instanceof Transformation) {
				counterT++;
				switch (project.getPriority()) {
					case URGENTE:
						processImprovementUrgent++;
						break;
					case MEDIA:
						processImprovementHigh++;
						break;
					case ALTA:
						processImprovementMedium++;
						break;
					case BAJA:
						processImprovementLow++;
						break;
				}
			}
		}
		// }
		list += "Proyectos de Gestion de conocimiento:" + counterK + "\n";
		list += "Urgente: " + knowledgeManagementUrgent;
		list += "  Alta: " + knowledgeManagementHigh;
		list += "  Media: " + knowledgeManagementMedium;
		list += "  Baja: " + knowledgeManagementLow;
		list += "\nProyectos de Transformacion/Mejoramiento:" + counterT + "\n";
		list += "Urgente:" + processImprovementUrgent;
		list += "  Alta:" + processImprovementHigh;
		list += "  Media:" + processImprovementMedium;
		list += "  Baja:" + processImprovementLow;

		return list;
	}

}
