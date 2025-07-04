package model;

import enums.ParkingTicketStatus;

import java.util.Date;


public class ParkingTicket {

    private final int ticketNumber;
    private final Date issuedAt;
    private Date payedAt;
    private int payedAmount;
    private ParkingTicketStatus parkingTicketStatus;

    private String licenseNumber;

    public ParkingTicket(final int ticketNumber, final Date issuedAt, final String licenseNumber) {
        this.ticketNumber = ticketNumber;
        this.issuedAt = issuedAt;
        this.licenseNumber = licenseNumber;
        this.parkingTicketStatus = ParkingTicketStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "ticketNumber=" + ticketNumber +
                ", issuedAt=" + issuedAt +
                ", payedAt=" + payedAt +
                ", payedAmount=" + payedAmount +
                ", parkingTicketStatus=" + parkingTicketStatus +
                '}';
    }

    //Getter
    public Date getIssuedAt() {
        return issuedAt;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }


    //Setter
    public void setPayedAt(final Date payedAt) {
        this.payedAt = payedAt;
    }

    public void setPayedAmount(final int payedAmount) {
        this.payedAmount = payedAmount;
    }

    public void setParkingTicketStatus(final ParkingTicketStatus parkingTicketStatus) {
        this.parkingTicketStatus = parkingTicketStatus;
    }

}
