package de.qacinemas.domain.ticket;

public class TicketFactory {
    public static AbstractTicket build(final EditCommand cmd) {
        switch (cmd) {
            case CHILD_TICKET:
                return new ChildTicket();
            case OAP_TICKET:
                return new OAPTicket();
            case STUDENT_TICKET:
                return new StudentTicket();
            case STANDARD_TICKET:
                return new StandardTicket();
            default:
                throw new IllegalStateException("unknown command:'".concat(cmd.name()).concat("'"));
        }
    }
}
