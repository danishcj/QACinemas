package de.qacinemas.io;

import de.qacinemas.domain.ticket.TicketList;

public class TicketListPrinter {

    private final static String  CURRENCY_SYMBOL = "£";

    public String print(final TicketList ticketList) {
        final StringBuilder sb = new StringBuilder();
        ticketList.getGroupedTickets().entrySet().forEach(ticketTypeListEntry -> {
            sb.append(ticketTypeListEntry.getKey().name().concat(" ").concat(String.valueOf(ticketTypeListEntry.getValue().size()).concat(System.getProperty("line.separator"))));
        });
        sb.append("Total Tickets sold: ").append(ticketList.getList().size()).append(System.getProperty("line.separator"));
        sb.append("Total Amount: ").append(CURRENCY_SYMBOL).append(ticketList.getTotalValue().setScale(2));
        return sb.toString();
    }
}
