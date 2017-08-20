package de.qacinemas.domain.ticket;

import java.math.BigDecimal;

public class OAPTicket extends AbstractTicket {
    public OAPTicket() {
        super(TicketType.OAP, BigDecimal.valueOf(6L));
    }
}
