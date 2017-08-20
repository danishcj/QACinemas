package de.qacinemas.domain;

import de.qacinemas.domain.ticket.AbstractTicket;
import de.qacinemas.domain.ticket.TicketList;

public class Movie {
    private final int index;

    private final static String PRE_INDEX = "Movie ";

    private TicketList tickets = new TicketList();

    private TicketList tempTickets = new TicketList();

    public Movie(final int index) {
        this.index = index;
    }

    public String getPrintInformation() {
        return PRE_INDEX.concat(String.valueOf(index));
    }

    public void addTemporaryTicket(final AbstractTicket abstractTicket) {
        tempTickets.add(abstractTicket);
    }

    public void persistTickets() {
        tickets.addAll(tempTickets);
        tempTickets.clear();
    }

    public void flushTempTickets() {
        tempTickets.clear();
    }

    public TicketList getTickets() {
        return tickets;
    }

    public TicketList getTempTickets() {
        return tempTickets;
    }
}
