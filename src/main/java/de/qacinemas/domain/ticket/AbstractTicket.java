package de.qacinemas.domain.ticket;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractTicket {
    private final TicketType type;

    final BigDecimal price;

    protected AbstractTicket(final TicketType type, final BigDecimal price) {
        this.type = type;
        this.price = price;
    }

    public TicketType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        Calendar cal = new GregorianCalendar();
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            return price.subtract(new BigDecimal(2L));
        }
        return price;
    }
}
