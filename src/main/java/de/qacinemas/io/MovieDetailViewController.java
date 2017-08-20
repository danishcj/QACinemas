package de.qacinemas.io;

import de.qacinemas.domain.ticket.EditCommand;

public class MovieDetailViewController extends AbstractIO {
    private final TicketEditController ticketEditController = new TicketEditController();
    public EditCommand print() {
        cls();
        final EditCommand input = ticketEditController.printAndReturnInput();
        return input;
    }
}
