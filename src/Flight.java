import java.util.ArrayList;

public class Flight {

        //id for the flight which is allotted everytime a flight object is created
        static int id = 0;
        int flightId;
        //available no of tickets currently in flight
        int tickets;
        //current price
        int price;
        //All passenger details
        ArrayList<String> passengerDetails;
        //list of all passenger id
        ArrayList<Integer>passengerIds;
        //list of number of ticket booked by every passenger id
        ArrayList<Integer>bookedTicketPerPassenger;
        //list of cost paid by every passenger , used to calculate the refund while cancelling
        ArrayList<Integer> passengerCost;

        public Flight()
        {
            tickets = 50;
            price = 5000;
            id = id+1;
            flightId = id;
            passengerDetails = new ArrayList<>();
            passengerIds = new ArrayList<>();
            bookedTicketPerPassenger = new ArrayList<>();
            passengerCost = new ArrayList<>();
        }
        //Add passenger details
        public void AddPassengerDetails(String passengerDetail , int noOfTicket , int passengerId)
        {
            passengerDetails.add(passengerDetail);
            passengerIds.add(passengerId);
            passengerCost.add(price*noOfTicket);

            //updating price
            price += noOfTicket * 200;

            //updating available seats
            tickets-= noOfTicket;
            bookedTicketPerPassenger.add(noOfTicket);
            System.out.println("Booked successfully");
        }

        //cancel the booked ticket by passenger id
        public void cancelTicket(int passengerid)
        {
            //index remove from all list
            int removeIndex = passengerIds.indexOf(passengerid);
            if(removeIndex < 0)
            {
                System.out.println("please enter the valid passenger id");
                return;
            }
            int bookedTickets = bookedTicketPerPassenger.get(removeIndex);
            //update seats
            tickets+=bookedTickets;
            //update ticket price
            price-=bookedTickets*200;

            System.out.println("Refund amount after ticket cancel :" + passengerCost.get(removeIndex));
            passengerDetails.remove(removeIndex);
            passengerIds.remove(removeIndex);
            passengerCost.remove(removeIndex);
            passengerDetails.remove(removeIndex);

            System.out.println("canceled booked ticket successfully");
        }
        //function to print details about flights and passengers
        public void flightSummary()
        {
            System.out.println("Flight Id "+flightId +"         "+"Remaining tickets = "+tickets +"Ticket current price = "+price);
        }
        public void details()
        {
            System.out.println("Flight id - > " + flightId);
            for(String details : passengerDetails)
                System.out.println(details);
        }

    }
