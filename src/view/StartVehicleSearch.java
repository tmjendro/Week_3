package view;

import java.util.List;
import java.util.Scanner;

import controller.PartenerInCrime;
import model.ListVehicle;

public class StartVehicleSearch {

		static Scanner in = new Scanner(System.in);
		static PartenerInCrime car = new PartenerInCrime();

		private static void addAVehicle() {
			
			System.out.print("Enter Plate Number: ");
			String license = in.nextLine();
			System.out.print("Enter Year of Production: ");
			int productionYear = Integer.parseInt(in.nextLine());
			System.out.print("Enter Make Name: ");
			String make = in.nextLine();
			System.out.print("Enter Model Name: ");
			String model = in.nextLine();
			ListVehicle toAdd = new ListVehicle (license, productionYear, make, model);
			car.incomingCar(toAdd);

		}

		private static void deleteAVehicle() {
			System.out.print("Enter the License to delete: ");
			String license = in.nextLine();
			System.out.print("Enter the Make to delete: ");
			String make = in.nextLine();
			System.out.print("Enter the Model to delete: ");
			String model = in.nextLine();
			System.out.print("Enter the Year of Production to delete: ");
			int productionYear = in.nextInt();
			ListVehicle toDelete = new ListVehicle ( license, productionYear, make, model);
			
			car.releaseCar(toDelete);
		}

		public static void main(String[] args) {
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the Police Impound Lot! ---");
			while (goAgain) {
				System.out.println("*  Select an action:");
				System.out.println("*  1 -- Impound a Vehicle");
				System.out.println("*  2 -- Release a Vehicle");
				System.out.println("*  3 -- View the list");
				System.out.println("*  4 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAVehicle();
				} else if (selection == 2) {
					deleteAVehicle();
				} 
				else if (selection == 3) {
					viewTheList();
				} else {
					car.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListVehicle> allVehicles = car.showAllCars();
			for(ListVehicle l : allVehicles){
				System.out.println(l.returnVehicleDetails());
			}

		}

	}