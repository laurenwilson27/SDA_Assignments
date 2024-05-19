package Array;

public class MovieTheatre {
    // The status of all seats is stored in a 2d array
    // The values are boolean - if true, a seat is reserved
    boolean[][] theatreSeats = null;

    public MovieTheatre(int rowCount, int columnCount) {
        // As discussed in class, the values in a boolean array will default to false
        // Therefore, filling the array manually is not necessary
        this.theatreSeats = new boolean[rowCount][columnCount];
    }

    // 1. Prints the status of all seats in the theatre
    //      An _ represents a free seat, an X represents a reserved
    public void printSeats() {
        for (boolean[] theatreRow : theatreSeats) {
            for (boolean seat : theatreRow) {
                System.out.print(seat ? "X" : "_");
            }

            // Print a newline at the end of each row
            System.out.println();
        }
    }

    // 2. Reserves a seat and prints a status message.
    //      Note that for user-friendliness, this method considers the first seat in the first row to be 1,1, not 0,0.
    public void reserveSeat(int row, int col) {
        // Use try/catch in case an invalid seat is specified
        try {
            if (!theatreSeats[row - 1][col - 1]) {
                theatreSeats[row - 1][col - 1] = true;
                System.out.println("Seat " + row + "-" + col + " has been reserved.");
            } else {
                System.out.println("Seat " + row + "-" + col + " is already reserved. Please choose a different seat.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: A nonexistent seat was specified.");
        }
    }

    // Main method to test this class.
    public static void main(String[] args) {
        MovieTheatre testTheatre = new MovieTheatre(5, 3);

        // Print the theatre - this should be all blanks
        testTheatre.printSeats();

        // Reserve some seats
        testTheatre.reserveSeat(3, 1);
        testTheatre.reserveSeat(4, 3);
        testTheatre.reserveSeat(1, 2);
        // A message stating that the seat was already reserved should be displayed after this call.
        testTheatre.reserveSeat(3, 1);

        // Print the theatre again. The reserved seats should be marked.
        testTheatre.printSeats();
    }
}
