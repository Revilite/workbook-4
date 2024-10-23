public class HotelApp {
    public static void main(String[] args) {

        int numberOfBeds = 2;
        boolean isClean = true;
        boolean isOccupied = true;

        Room r = new Room(isClean, isOccupied, numberOfBeds);


        // Room should not be available
        boolean isRoomAvailable = r.isAvailable();

        if(isRoomAvailable){
            System.out.println("The room is available");
        }else{
            System.out.println("The room is not available");
        }

        r.isOccupied = false;
        isRoomAvailable = r.isAvailable();
        if(isRoomAvailable){
            System.out.println("The room is available");
        }else{
            System.out.println("The room is not available");
        }

    }
}
