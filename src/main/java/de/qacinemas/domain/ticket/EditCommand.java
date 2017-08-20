package de.qacinemas.domain.ticket;

import java.util.Arrays;

public enum EditCommand {
    CHILD_TICKET("CH", true), OAP_TICKET("OAP", true), STUDENT_TICKET("STU", true), STANDARD_TICKET("STD", true),
    SAVE("S", false), EXIT("C", false);
    private final String userInput;
    private final boolean addTicketCommand;

    EditCommand(final String userInput, final boolean isAddTicketCommand) {
        this.userInput = userInput;
        this.addTicketCommand = isAddTicketCommand;
    }

    public String getUserInput() {
        return userInput;
    }

    public boolean isAddTicketCommand() {
        return addTicketCommand;
    }

    public static EditCommand parseUserCmd(final String cmd) {
       return Arrays.asList(values()).stream().filter(editCommand -> editCommand.getUserInput().equals(cmd)).findFirst().orElseThrow(() -> new IllegalStateException("could not parse cmd:'" + cmd + "'"));
    }
}
