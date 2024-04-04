import java.util.Random;

public class Code {
    //В общем и целом, этот класс работает по приколу и не несет смысловой нагрузки
    //3141 5926 5358 9793 - число Pi
    private static short firstQuartet = 3141;
    private static short secondQuartet = 5926;
    private static short thirdQuartet = 5358;
    private static short fourthQuartet = 9793;
    private static final String ERROR_CODE = "XXXX XXXX XXXX XXXX";
    private boolean status = true;

    public String getCode() {
        Random random = new Random();
        short shift = (short) (random.nextInt(9999) + 1);
        if (shiftCode(shift) && status) {
            return (numberFormatting(firstQuartet) + " " + numberFormatting(secondQuartet) + " " + numberFormatting(thirdQuartet) + " " + numberFormatting(fourthQuartet));
        } else {
            status = false;
            return ERROR_CODE;
        }
    }

    private boolean shiftCode(short shift) {
        if ((fourthQuartet + shift) <= 9999) {
            fourthQuartet = (short) (fourthQuartet + shift);
            return true;
        } else {
            fourthQuartet = (short) (fourthQuartet + shift - 10000);
            thirdQuartet++;
        }

        if (thirdQuartet <= 9999) {
            return true;
        } else {
            thirdQuartet = 0;
            secondQuartet++;
        }

        if (secondQuartet <= 9999) {
            return true;
        } else {
            secondQuartet = 0;
            firstQuartet++;
        }

        return firstQuartet <= 9999;
    }

    private String numberFormatting(short number) {
        String numberString = Short.toString(number);
        return ("0".repeat(4 - numberString.length()) + numberString);
    }


}
