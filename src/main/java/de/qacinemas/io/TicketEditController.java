package de.qacinemas.io;

import de.qacinemas.domain.Movie;
import de.qacinemas.domain.ticket.EditCommand;

import java.util.Arrays;

import static de.qacinemas.App.selectedMovieIndex;
import static de.qacinemas.App.storage;

public class TicketEditController extends AbstractIO {

    private final static String POST_RENDER_STATEMENT = "Please type command: ";
    private final TicketListPrinter ticketListPrinter = new TicketListPrinter();

    public EditCommand printAndReturnInput() {
        cls();
        final String movieInfo = getMovieInfo();
        final String commandInfo = getCommandInfo();
        System.out.println(movieInfo.concat(System.getProperty("line.separator")).concat(commandInfo));
        try {
            return EditCommand.parseUserCmd(userInput.nextLine());
        } catch (Exception t) {
            printAndReturnInput();
            return EditCommand.EXIT;
        }
    }

    private String getCommandInfo() {
        final StringBuilder out = new StringBuilder();
        out.append(POST_RENDER_STATEMENT);
        Arrays.asList(EditCommand.values()).forEach(curEditCommand -> {
            out.append(curEditCommand.name().concat(":'").concat(curEditCommand.getUserInput()).concat("' "));
        });
        return out.toString();
    }

    public String getMovieInfo() {
        final Movie curMovie = storage.get(Integer.parseInt(selectedMovieIndex) - 1);
        final StringBuilder st = new StringBuilder();
        st.append("ADD Tickets")
                .append(System.getProperty("line.separator")).append(ticketListPrinter.print(curMovie.getTempTickets())).append(System.getProperty("line.separator")).append(System.getProperty("line.separator")).append("sold tickets").append(System.getProperty("line.separator")).append(ticketListPrinter.print(curMovie.getTickets()));
        return st.toString();
    }

}
