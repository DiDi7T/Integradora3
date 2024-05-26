package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;

	private Controller controller;

	public static void main(String[] args) {
		Executable exe = new Executable();
		exe.menu();
	}

	// Contructor
	public Executable() {
		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public void menu() {

		boolean flag = true;

		do {

			System.out.println("\nBIENVENIDO AL SOFTWARE DE GESTION DE SOLICITUDES Y PROYECTOS");
			System.out.println("1) Registrar Solicitud");
			System.out.println("2) Cambiar estado de una solicitud");
			System.out.println("3) Finalizar/Cerrar un proyecto");
			System.out.println("4) Visualizar informacion de un proyecto");
			System.out.println("5) Consultar un proyecto a mas detalle");
			System.out.println("6) Consultar eficiencia");
			System.out.println("7) Consultar indicadores");

			System.out.println("0) Salir");
			int option = reader.nextInt();

			switch (option) {

				case 1:
					registerRequest();
					break;
				case 2:
					System.out.println("Proximamente :)");
					break;
				case 3:

					closedProject();

					break;
				case 4:
					System.out
							.println("=======================" + " PROYECTOS REGISTRADOS " + "=======================");
					System.out.println(controller.listProjects());
					break;

				case 5:
					System.out
							.println("=======================" + " PROYECTOS REGISTRADOS " + "=======================");
					System.out.println(controller.listProjects());
					checkProject();
					break;

				case 6:
					checkEfficiency();
					break;

				case 7:
					consultIndicators();

					break;

				case 0:
					flag = false;
					System.out.println("Gracias por usar nuestros servicios");
					break;

				default:
					System.out.println("Opcion invalida. Intenta nuevamente\n");
					break;
			}

		} while (flag);

	}

	public void registerRequest() {

		reader.nextLine(); // Correccion del bug del Scanner

		System.out.println(controller.listArea());
		System.out.println("Digite el codigo del area solicitante:");
		String code = reader.nextLine();

		System.out.println("Digite la descripcion de la solicitud:");
		String description = reader.nextLine();

		int status = 1;
		

		System.out.println(controller.listAllCollaboratorsWithAreas());
		System.out.println("Digite el id del colaborador que sera responsable de esta solicitud:");
		String collab = reader.nextLine();

		
		boolean resultado = controller.addRequest(code,description,status,collab);

		if (resultado) {
			System.out.println("Solicitud registrada exitosamente");
		} else {
			System.out.println("Error, la solicitud no se ha podido registrar");
		}

	}

	private void closedProject() {
		String list = controller.listProjectsOpens();
		System.out.println("=======================" + " PROYECTOS ABIERTOS " + "=======================");

		if (list.equals("No hay proyectos para cerrar")) {

			System.out.println(list);

		} else {

			System.out.println(controller.listProjectsOpens());

			reader.nextLine(); // Correccion del bug del Scanner

			System.out.println("Digite el codigo del proyecto que desea cerrar ");
			String code = reader.nextLine();

			String status = "Cerrado";

			String msgs = controller.showProject(code);

			if (msgs.equals("El Proyecto no se encuentra")) {

				System.out.println(msgs);

			} else {

				System.out.println("Los datos del proyecto son:\n" + msgs);

				System.out.println("Esta seguro que desa cerrar este proyecto? 1)Si 2)No");
				int option = reader.nextInt();

				switch (option) {
					case 1:

						boolean result = controller.closedProject(code, status);
						if (result) {
							System.out.println("Se ha cerrado el proyecto exitosamente");
						} else {
							System.out.println("Error, el producto no se ha podido cerrar");
						}
						break;

					case 2:
						menu();
						break;
					default:
						System.out.println("Error, seleccione algo valido");
						break;
				}

			}
		}

	}

	private void checkEfficiency() {

		System.out.println("Seleccione la eficiencia que desea consultar");
		System.out.println("1) Un colaborador del área de Transformación y Mejoramiento de procesos institucionales.");
		System.out.println("2) Un proyecto determinado.");
		System.out.println("3) Una solicitud.");
		System.out.println("0) Para volver al menu principal");
		int option = reader.nextInt();

		switch (option) {

			case 1:

				break;

			case 2:

				break;
			case 3:

				break;

			case 0:
				System.out.println("Volviendo al menu principal\n");
				break;

			default:
				System.out.println("Opcion invalida. Volviendo al menu principal\n");
				break;
		}

	}

	private void consultIndicators() {

		System.out.println("Seleccione el indicador que desea consultar");
		System.out.println("1) Cantidad de proyectos por cada tipo y cada prioridad.");
		System.out.println("2) Cantidad de proyectos liderados por cada colaborador del área");
		System.out.println("3) Cantidad de solicitudes recibidas y gestionadas durante un mes determinado.");
		System.out.println("0) Para volver al menu principal");
		int option = reader.nextInt();

		switch (option) {

			case 1:

				break;

			case 2:

				break;
			case 3:

				break;

			case 0:
				System.out.println("Volviendo al menu principal\n");
				break;

			default:
				System.out.println("Opcion invalida. Volviendo al menu principal\n");
				break;
		}

	}

	private void registerProject() {

		System.out.println("Seleccione el proyecto a registrar");
		System.out.println("1) Registrar proyecto de Gestion De Conocimiento");
		System.out.println("2) Registrar proyecto de Transformacion/Mejoramiento de procesos");
		System.out.println("0) Para volver al menu principal");
		int option = reader.nextInt();

		switch (option) {

			case 1:
				registerKnowledge();
				break;

			case 2:
				registerTransformation();
				break;
			case 0:
				System.out.println("Volviendo al menu principal\n");
				break;

			default:
				System.out.println("Opcion invalida. Volviendo al menu principal\n");
				break;
		}

	}

	/**
	 * Description: This method register a project of type Knowledge
	 */

	public void registerKnowledge() {

		reader.nextLine(); // Correccion del bug del Scanner

		System.out.println("Digite el codigo del proyecto");
		String code = reader.nextLine();

		System.out.println("Digite el nombre del proyecto");
		String name = reader.nextLine();

		String status = "Activo";

		System.out.println("Digite la fecha de aceptacion del proyecto (dd-mm-aaaa)");
		String date = reader.nextLine();

		System.out.println("Seleccione la prioridad del proyecto");
		System.out.println(controller.listPriority());
		int priority = reader.nextInt();

		reader.nextLine();

		System.out.println("Digite el nombre del lider del proyecto:");
		System.out.println(
				"AREA DE TRANSFOMRACION \n 1. Ana Suarez \n 2. Guillermo Duarte\n 3.Rodrigo Martinez\n 4.Lina Forz");
		String nameLeader = reader.nextLine();

		System.out.println("Digite el nombre del proceso a gestionar");
		String nameProcess = reader.nextLine();

		System.out.println("Seleccione la comunidad impactada");
		System.out.println(controller.listCommunity());
		int community = reader.nextInt();

		System.out.println("Seleccione el tipo de proyecto ");
		System.out.println(controller.listType());
		int type = reader.nextInt();

		boolean resultado = controller.storageKnowledge(code, name, status, date, priority, nameLeader, nameProcess,
				community, type);

		if (resultado) {
			System.out.println("Proyecto registrado exitosamente");
		} else {
			System.out.println("Error, el proyecto no se ha podido registrar");
		}

	}

	/**
	 * Description: This method register a project of type Transformation
	 */

	public void registerTransformation() {

		reader.nextLine(); // Correccion del bug del Scanner

		System.out.println("Digite el codigo del proyecto");
		String code = reader.nextLine();

		System.out.println("Digite el nombre del proyecto");
		String name = reader.nextLine();

		String status = "Activo";

		System.out.println("Digite la fecha de aceptacion del proyecto (dd-mm-aaaa)");
		String date = reader.nextLine();

		System.out.println("Seleccione la prioridad del proyecto");
		System.out.println(controller.listPriority());
		int priority = reader.nextInt();

		reader.nextLine();

		System.out.println("Digite el nombre del lider del proyecto:");
		System.out.println(
				"AREA DE TRANSFOMRACION \n 1. Ana Suarez \n 2. Guillermo Duarte\n 3.Rodrigo Martinez\n 4.Lina Forz");
		String nameLeader = reader.nextLine();

		System.out.println("Digite el codigo del proceso a mejorar");
		String codeProcess = reader.nextLine();

		boolean resultado = controller.storageTransformation(code, name, status, date, priority, nameLeader,
				codeProcess);

		if (resultado) {
			System.out.println("Proyecto registrado exitosamente");
		} else {
			System.out.println("Error, el proyecto no se ha podido registrar");
		}

	}

	/**
	 * Description: This method allows you to consult a project
	 */
	public void checkProject() {

		reader.nextLine();
		System.out.println("Digite el CODIGO del proyecto que desea consultar a mas detalle");
		String code = reader.nextLine();

		String msg = controller.showProject(code);
		if (msg.equals("El proyecto no se encuentra")) {
			System.out.println(msg);
		} else {
			System.out.println("-------------------------------");
			System.out.println("    INFORMACION DEL PROYECTO \n");
			System.out.println("-------------------------------");
			System.out.println(msg);
		}

	}

}