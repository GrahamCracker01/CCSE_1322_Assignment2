//Class: CSE 1322L
//Section: J03
//Term: Spring 2023
//Name: Asher Graham

import java.util.ArrayList;
import java.util.Scanner;
class Main {
    //declare scanner and variables

    public static Lot getNextLot(ArrayList<Lot> lotList) {
        Lot lot = new Lot();
        if (!lotList.isEmpty()) {
            lot = lotList.get(0);
            lotList.remove(0);
            return (lot);
        } else {
            return lot;
        }
    }

    public static void addItem(ArrayList<Lot> lotList) {
        Scanner scan = new Scanner(System.in);
        String description;
        System.out.println("What is the description of this item");
        description = (scan.nextLine());
        System.out.println("What is the starting bid");
        int startingBid = Integer.parseInt(scan.nextLine());
        System.out.println("What is the bid increment");
        int bidIncrement = Integer.parseInt(scan.nextLine());
        Lot newLot = new Lot(description, startingBid, bidIncrement);
        lotList.add(newLot);
    }

    public static void bid(Lot lot) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How much would you like to bid?\nMinimum bid is " + lot.nextBid());
        int intBid = Integer.parseInt(scan.nextLine());
        if (intBid < lot.nextBid()) {
            System.out.println("You must bid at least " + lot.nextBid());
        } else {
            lot.setCurrentBid(intBid);
        }
    }

    public static void markSold(Lot lot) {
        lot.markSold();
        System.out.println(lot);
    }

    public static void mainMenu(ArrayList<Lot> lotList) {
        Scanner scan = new Scanner(System.in);
        Lot currentLot = null;
        boolean boolStop = false;
        do {
            if ((currentLot == null) || (currentLot.getDescription().equals("Unknown Item"))) {
                System.out.println("We are not currently bidding");
            } else {
                System.out.println("Current lot: \n" + currentLot);
            }
            System.out.println("\n" +
                    "1. Add Lot to Auction\n" +
                    "2. Start bidding on next Lot\n" +
                    "3. Bid on current Lot\n" +
                    "4. Mark current Lot Sold\n" +
                    "5. Exit");
            switch (Integer.parseInt(scan.nextLine())) {
                case 1:
                    addItem(lotList);
                    break;
                case 2:
                    if (lotList.isEmpty()) {
                        System.out.println("There is nothing to bid on, add an item first");
                    }
                    else if ((currentLot != null ) && (!currentLot.getSold())) {
                        System.out.println("You must mark the current lot as sold before bringing up the next Lot");
                    }
                    else {
                        currentLot = getNextLot(lotList);
                    }
                    break;
                case 3:
                    if ((currentLot == null) || (currentLot.getDescription().equals("Unknown Item")) || currentLot.getSold()) {
                        System.out.println("You must first bring a Lot up for bidding");
                    }
                    else {
                        bid(currentLot);
                    }
                    break;
                case 4:
                    if ((currentLot == null) || (currentLot.getDescription().equals("Unknown Item")) || currentLot.getSold()) {
                        System.out.println("You must first bring a Lot up for bidding");
                    }
                    else {
                        markSold(currentLot);
                    }
                    break;
                case 5:
                    boolStop = true;
                    break;
                default:
                    System.out.println("Please input a valid menu option.");
            }
        } while (!boolStop);
    }

    public static void main(String[] args) {
        ArrayList<Lot> auction = new ArrayList<Lot>();
        mainMenu(auction);
    }
}