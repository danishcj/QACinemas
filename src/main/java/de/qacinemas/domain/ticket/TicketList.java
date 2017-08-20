package de.qacinemas.domain.ticket;

import java.math.BigDecimal;
import java.util.*;

public class TicketList {

    final List<AbstractTicket> list = new ArrayList<>();

    public Map<TicketType, List<AbstractTicket>> getGroupedTickets() {
        final Map<TicketType, List<AbstractTicket>> result = new HashMap<>();
        list.forEach(abstractTicket -> {
            if (!result.containsKey(abstractTicket.getType())) {
                result.put(abstractTicket.getType(), new ArrayList<>());
            }
            result.get(abstractTicket.getType()).add(abstractTicket);
        });
        return result;
    }

    public void add(final AbstractTicket abstractTicket) {
        list.add(abstractTicket);
    }

    public void addAll(final TicketList tempTickets) {
        this.list.addAll(tempTickets.getList());
    }

    public List<AbstractTicket> getList() {
        return list;
    }

    public void clear() {
        list.clear();
    }

    public BigDecimal getTotalValue() {
        Calendar cal = new GregorianCalendar();
        final BigDecimal[] i = {BigDecimal.ZERO};
        list.forEach(abstractTicket -> i[0] = i[0].add(abstractTicket.getPrice()));

        return i[0];
    }
}
