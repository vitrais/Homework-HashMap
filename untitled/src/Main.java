    public class Main {
    private static final String HEX = "0123456789abcdef";
    public static void main(String[] args) {
        int decimalNumber = 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    public static String toHex(int decimalNumber) {
        String hexNumber = "";
        if (decimalNumber == 0) {
            return "";
        }
        while (decimalNumber!=0){
            hexNumber = HEX.charAt(decimalNumber%16) + hexNumber;
            decimalNumber = decimalNumber/16;
        }
        return String.valueOf(hexNumber);
    }

    public static int toDecimal(String hexNumber) {
        double decimalNumber = 0;
        if (hexNumber == null || hexNumber == "") {
            return 0;
        }
        for (int i = 0; i < hexNumber.length(); i++) {
            decimalNumber = Character.getNumericValue(hexNumber.charAt(i))*Math.pow(16, hexNumber.length()-1-i)+decimalNumber;
        }
        return (int)decimalNumber;
    }
}





