package de.qacinemas.domain.ticket;

import java.math.BigDecimal;

public class StudentTicket extends AbstractTicket {
    public StudentTicket() {
        super(TicketType.STUDENT, BigDecimal.valueOf(6L));
    }
}
