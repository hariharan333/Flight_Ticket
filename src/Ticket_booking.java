import java.util.*;

public class Ticket_booking {

    public static void book(Flight current_flight,int ticket,int passengerId)
    {
        String passengerDetails = "";
        int total = current_flight.price * ticket ;
        passengerDetails = "passenger ID " + passengerId + "    Number of tickets booked " + ticket + "     total cost  "+
                            total;
        current_flight.AddPassengerDetails(passengerDetails,ticket,passengerId);
        current_flight.flightSummary();
        current_flight.details();
    }
    public static void cancel(Flight current_flight,int passengerid)
    {
        current_flight.cancelTicket(passengerid);
        current_flight.flightSummary();
        current_flight.details();
    }
    public static void print(Flight f)
    {
        f.details();
    }
    public static void main(String[] args)
    {
        ArrayList<Flight>flight = new ArrayList<>();

        //here i'm taking only two flights
        for(int i=0;i<2;i++)
        {
            flight.add(new Flight());
        }
        //unique id for passenger allotted during every booking
        int passengerId = 1;

        while(true)
        {
            System.out.println("1 - book        2 - cancel      3.print ");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice)
            {
                case 1 :
                {
                    System.out.println("Enter Flight id");
                    int fid = scan.nextInt();
                    if(fid > flight.size())
                    {
                        System.out.println("Enter the valid flight id");
                        break;
                    }
                    Flight curr_flight = null;
                    for(Flight f:flight)
                    {
                        if(f.flightId == fid)
                        {
                            curr_flight = f;
                            curr_flight.flightSummary();
                            break;
                        }
                    }
                    System.out.println("Enter the No.of tickets");
                    int ticket  = scan.nextInt();
                    if(ticket > curr_flight.tickets)
                    {
                        System.out.println("Not Enough tickets");
                        break;
                    }
                    book(curr_flight,ticket,passengerId);
                    passengerId = passengerId + 1;
                    break;
                }
                case 2:
                {
                    System.out.println("Enter flight id and passenger id to cancel booking");
                    int fid = scan.nextInt();

                    if(fid > flight.size())
                    {
                        System.out.println("Enter the valid flight id");
                        break;
                    }
                    Flight currentFlight = null;
                    for(Flight f:flight)
                    {
                        if(f.flightId == fid)
                        {
                            currentFlight.flightId = fid;
                            break;
                        }
                    }

                    int passId = scan.nextInt();
                    cancel(currentFlight , passId);
                    break;
                }
                case 3:
                {
                    for(Flight f:flight)
                    {
                        if(f.passengerDetails.size() == 0)
                            System.out.println("No passenger details for flight id ---> " + f.flightId);
                        else
                            print(f);
                    }
                    break;
                }
                default:
                    break;
            }
        }
    }
}
