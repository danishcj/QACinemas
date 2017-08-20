package de.qacinemas.domain.ticket;

import java.math.BigDecimal;

public class ChildTicket extends AbstractTicket {
    public ChildTicket() {
        super(TicketType.CHILD, BigDecimal.valueOf(4L));
    }
}
