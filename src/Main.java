import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    //Format
    static final int rows = 10;
    static final int seats = 4;
    static final char Aseat = '*';
    static final char Rseat = 'X';
    static char [][] Xseat = new char[rows][seats];

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StartProgram();
        int r, s;
        System.out.println("Bus Seat Reservation:");
        do{
            BlankSeats();
            System.out.print("Enter the row number (1=10) you want to reserve [Enter negative number to exit]: ");
            r = sc.nextInt();
            if(r<0){
                break;
            }
            System.out.print("Enter seat number (1-4) you want to reserve: ");
            s = sc.nextInt();
            if(s<0){
                break;
            }
            if (ReserveSeat(r -1, s -1)){
                System.out.println("Seat " + r + "-" + s + " reserved.");
            }else {
                System.out.println("Seat " + r + "-" + s + " is already reserved. PLease try again!\n\n");
            }
        }while(true);
        System.out.println("Thank you for using our reservation system!");



    }
    //Methods or mentos na candy dos
    public static void BlankSeats()
    {
        System.out.println("\tCol 1\tCol 2\tCOl 3\tCol 4");
        for (int i = 0; i < rows; i++){
            System.out.print(i + 1 + "\t"); //I don't know if its necessary to put '|' here to copy the example on bb
            for (int j = 0; j<seats; j++){
                System.out.print(Xseat[i][j] + " \t\t");
            }
            System.out.println(); // <----- super important right here
        }
    }

    public static void StartProgram()
    {
        for (int i = 0; i<rows; i++){
            Arrays.fill(Xseat[i], Aseat);
        }
    }

    public static boolean ReserveSeat(int r, int s){
        if (Xseat[r][s] == Aseat){
            Xseat[r][s] = Rseat;
            return true;
        } else {
            return false;
        }
    }
}