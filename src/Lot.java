//Class: CSE 1322L
//Section: J03
//Term: Spring 2023
//Name: Asher Graham

class Lot {
    private int lotNumber, currentBid, bidIncrement;
    private static int intNextLotNumber = 1001;
    private String description;
    private boolean sold;

    //default constructor
    public Lot () {
        lotNumber = intNextLotNumber;
        intNextLotNumber++;
        description = "Unknown Item";
        currentBid = 0;
        bidIncrement = 0;
        sold = false;
    }

    //overloaded constructor
    public Lot(String newDescription, int startingBid, int newBidIncrement) {
        lotNumber = intNextLotNumber;
        intNextLotNumber++;
        description = newDescription;
        currentBid = startingBid;
        bidIncrement = newBidIncrement;
        sold = false;
    }

    //getters and setters
    public boolean getSold() {
        return sold;
    }

    public int getBidIncrement() {
        return bidIncrement;
    }

    public String getDescription() {
        return description;
    }

    public void setCurrentBid(int newBid) {
        currentBid = newBid;
    }

    //various methods
    public void markSold() {
        sold = true;
    }

    public int nextBid() {
        return (currentBid + bidIncrement);
    }

    @Override
    public String toString() {
        if (sold) {
            return ("Lot " + lotNumber + ". " + description + " was sold for $" + currentBid);
        }
        else {
            return ("Lot " + lotNumber + ". " + description + " current bid $" + currentBid + " minimum bid $" + (currentBid + bidIncrement));
        }
    }
}