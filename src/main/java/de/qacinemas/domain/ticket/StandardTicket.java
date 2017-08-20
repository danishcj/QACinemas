package de.qacinemas.domain.ticket;

import java.math.BigDecimal;

public class StandardTicket extends AbstractTicket{
    public StandardTicket() {
        super(TicketType.STANDARD, BigDecimal.valueOf(8L));
    }
}
