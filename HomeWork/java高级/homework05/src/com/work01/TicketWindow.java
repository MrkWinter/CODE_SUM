package com.work01;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class TicketWindow implements Runnable {
    private Map<String, Boolean> ticketMap;
    private String salerName;

    public TicketWindow(Map<String, Boolean> ticketMap, String salerName) {
        this.ticketMap = ticketMap;
        this.salerName = salerName;
    }


//    private void saleTicket() {
//        Iterator<String> it = ticketMap.keySet().iterator();
//        for (; ; ) {
//            synchronized (ticketMap) {
//                if (it.hasNext()) {
//                    String tickNo = it.next();
//                    if (!ticketMap.get(tickNo)) {
//                        System.out.println(salerName + ":" + tickNo + "以被售出");
//                        ticketMap.put(tickNo, true);
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                } else {
//                    break;
//                }
//            }
//        }
//    }
    private void saleTicket() {

        for (String tickNo : ticketMap.keySet()) {
            synchronized (ticketMap) {
                if (!ticketMap.get(tickNo)) {
                    System.out.println(salerName + ":" + tickNo + "以被售出");
                    ticketMap.put(tickNo, true);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }




    @Override
    public void run() {
        saleTicket();
    }
}
