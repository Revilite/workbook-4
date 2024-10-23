public class HotelApp {
    public static void main(String[] args) {

        int numberOfBeds = 2;
        boolean isClean = true;
        boolean isAvailable = true;

        Room r = new Room(isClean, isAvailable, numberOfBeds);

    }
}
