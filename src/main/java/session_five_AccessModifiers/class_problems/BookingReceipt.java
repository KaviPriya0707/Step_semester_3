class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(
            String bookingId,
            String[] seatNumbers) {

        this.bookingId = bookingId;

        this.seatNumbers = seatNumbers.clone();
    }

    public String[] getSeatNumbers() {

        return seatNumbers.clone();
    }

    public BookingReceipt withUpdatedSeat(
            int index,
            String newSeat) {

        String[] newSeats = seatNumbers.clone();

        newSeats[index] = newSeat;

        return new BookingReceipt(
            bookingId,
            newSeats
        );
    }
}

class GroupBookingReceipt extends BookingReceipt {

    private final int groupSize;

    public GroupBookingReceipt(
            String bookingId,
            String[] seatNumbers,
            int groupSize) {

        super(bookingId, seatNumbers);

        this.groupSize = groupSize;
    }
}

class SettlementProcessor {

    static String processNightlySettlement(
            BookingReceipt[] receipts) {

        int processed = 0;
        int nullCount = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (int i = 0; i < receipts.length; i++) {

            if (receipts[i] == null) {

                nullCount++;
            }
            else {

                processed++;

                if (receipts[i]
                        instanceof GroupBookingReceipt) {

                    groupCount++;
                }
                else {

                    individualCount++;
                }
            }
        }

        return processed + " processed | "
                + nullCount + " null skipped | "
                + groupCount + " group | "
                + individualCount + " individual";
    }
}

class Main {

    public static void main(String[] args) {

        String[] seats = {"A1", "A2"};

        BookingReceipt b =
            new BookingReceipt(
                "CH-1001",
                seats
            );
        String[] copiedSeats = b.getSeatNumbers();

        copiedSeats[0] = "X";

        System.out.println(
            "Original seat: " +
            b.getSeatNumbers()[0]
        );

        BookingReceipt updated =
            b.withUpdatedSeat(1, "A3");

        System.out.println(
            "Original: " +
            b.getSeatNumbers()[1]
        );

        System.out.println(
            "Updated: " +
            updated.getSeatNumbers()[1]
        );
        BookingReceipt[] receipts = {

            new GroupBookingReceipt(
                "CH-2002",
                new String[]{"B1", "B2"},
                2
            ),

            null,

            new BookingReceipt(
                "CH-3003",
                new String[]{"C1"}
            )
        };

        System.out.println(
            SettlementProcessor
                .processNightlySettlement(receipts)
        );
    }
}
