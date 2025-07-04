import enums.ParkingSpotType;
import enums.PaymentMode;
import model.ParkingTicket;
import model.actors.Admin;
import model.actors.ParkingAttendant;
import model.vehicle.Car;
import model.vehicle.Truck;
import model.vehicle.Vehicle;
import service.ParkingLotServiceFacade;

public class Main {

    public static void main(final String[] args) throws Exception {
        final ParkingLotServiceFacade parkingLotServiceFacade = new ParkingLotServiceFacade();

        final String parkingAttendantUsername = "Raju";
        final String adminUsername = "Aditya";
        initializeActors(parkingLotServiceFacade, parkingAttendantUsername, adminUsername);
        initializeMaxSpotCounts(parkingLotServiceFacade, adminUsername);

        final Vehicle car = new Car("CAR123");
        //Create parking ticket and assign it to the vehicle (CAR)
        final ParkingTicket carParkingTicket = parkingLotServiceFacade.getNewParkingTicket(car);
        System.out.println("Parking ticket details for " + car.getLicenseNumber() + " is " + carParkingTicket);

        //Process the parking ticket for CAR
        parkingLotServiceFacade.processParkingTicket(parkingAttendantUsername, carParkingTicket.getTicketNumber(), PaymentMode.CASH);
        System.out.println("Parking ticket details for " + car.getLicenseNumber() + " is " + carParkingTicket);

        terminalSpaceIndentation();

        final Vehicle truck = new Truck("TRUCK123");
        //Create parking ticket and assign it to the vehicle (TRUCK)
        final ParkingTicket truckParkingTicket = parkingLotServiceFacade.getNewParkingTicket(truck);
        System.out.println("Parking ticket details for" + truck.getLicenseNumber() + " is " + truckParkingTicket);

        //Process the parking ticket for TRUCK
        parkingLotServiceFacade.processParkingTicket(parkingAttendantUsername, truckParkingTicket.getTicketNumber(), PaymentMode.CARD);
        System.out.println("Parking ticket details for" + truck.getLicenseNumber() + " is " + truckParkingTicket);
    }

    private static void initializeActors(final ParkingLotServiceFacade parkingLotServiceFacade,
                                         final String parkingAttendantUsername,
                                         final String adminUsername) throws Exception {
        //Create parking attendant
        parkingLotServiceFacade.createParkingAttendant(parkingAttendantUsername);

        //Get parking attendant details
        final ParkingAttendant parkingAttendant = parkingLotServiceFacade.getParkingAttendant(parkingAttendantUsername);
        System.out.println("Parking attendant username: " + parkingAttendant.getUserName() +
                " and status: " + parkingAttendant.getStatus());

        terminalSpaceIndentation();

        //Create admin
        parkingLotServiceFacade.createAdmin(adminUsername);

        //Get admin details
        final Admin admin = parkingLotServiceFacade.getAdmin(adminUsername);
        System.out.println("Admin username: " + admin.getUserName() +
                " and status: " + admin.getStatus());

        terminalSpaceIndentation();
    }

    private static void initializeMaxSpotCounts(final ParkingLotServiceFacade parkingLotServiceFacade, final String adminUsername) throws Exception {
        parkingLotServiceFacade.addSpotCount(adminUsername, ParkingSpotType.COMPACT, 5);
        parkingLotServiceFacade.addSpotCount(adminUsername, ParkingSpotType.LARGE, 5);
    }

    private static void terminalSpaceIndentation() {
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
    }

}
