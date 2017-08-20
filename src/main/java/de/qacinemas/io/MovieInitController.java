package de.qacinemas.io;

import de.qacinemas.domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieInitController extends AbstractIO {

    private final static String POST_RENDER_STATEMENT = "Please select a movie (1-5) and press enter:";
    private final TicketListPrinter tableListPrinter = new TicketListPrinter();

    private List<String> headers(final List<Movie> in) {
        final List<String> result = new ArrayList<>();
        in.forEach(curMovie -> result.add(curMovie.getPrintInformation()));
        return result;
    }

    public String printAndReturnInput(final List<Movie> storage) {
        cls();
        final StringBuilder st = new StringBuilder();
        System.out.println("***QA CINEMAS***");
        storage.forEach(movie -> st.append(System.getProperty("line.separator")).append(System.getProperty("line.separator")).append(movie.getPrintInformation()).append(System.getProperty("line.separator")).append(tableListPrinter.print(movie.getTickets())));
        System.out.println(st.toString());
        System.out.println(POST_RENDER_STATEMENT);
        return userInput.nextLine();
    }
}
