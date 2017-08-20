package de.qacinemas;

import de.qacinemas.domain.Movie;
import de.qacinemas.domain.ticket.EditCommand;
import de.qacinemas.domain.ticket.TicketFactory;
import de.qacinemas.io.MovieDetailViewController;
import de.qacinemas.io.MovieInitController;
import de.qacinemas.io.State;
import de.qacinemas.service.StorageBuilder;

import java.util.List;

import static de.qacinemas.io.State.INIT;

public class App {

    public static List<Movie> storage;
    static Movie curMovie;
    private static final MovieInitController movieInitController = new MovieInitController();
    private static final MovieDetailViewController detailOut = new MovieDetailViewController();
    private static State curState = INIT;
    public static String selectedMovieIndex;

    public static void main(String[] args) {
        init();
        exec();
    }

    private static void exec() {
        if (curState.equals(State.INIT)) {
            selectedMovieIndex = movieInitController.printAndReturnInput(storage);
        }
        printDetail();
    }

    private static void init() {
        storage = StorageBuilder.build(5);
    }

    private static void printDetail() {
        if (isValidInput(selectedMovieIndex)) {
            curState = State.DETAIL;
            curMovie = storage.get(Integer.valueOf(selectedMovieIndex) - 1);
            EditCommand cmd = detailOut.print();
            if (cmd.isAddTicketCommand()) {
                curMovie.addTemporaryTicket(TicketFactory.build(cmd));
            } else {
                execControlCommand(cmd);
            }
        }
        exec();
    }

    private static void execControlCommand(final EditCommand cmd) {
        switch (cmd) {
            case SAVE:
                curMovie.persistTickets();
                curState = State.INIT;
                break;
            case EXIT:
                curMovie.flushTempTickets();
                curState = State.INIT;
                break;
        }
    }

    private static boolean isValidInput(final String input) {
        return input.matches("^-?\\d+$") && Integer.valueOf(input) <= storage.size() && Integer.valueOf(input) > 0;
    }
}
