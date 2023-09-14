
//Terminal Command:
// java Operations 15 0b1011 0xfa

public class Operations {

    public static void main(String[] args) {

        // TASK 1
        int numberOfArguments = args.length;

        for (int i = 0; i < args.length; i++) {

            if (numberOfArguments != 3) {
                System.out.println("Task 1");
                System.out.println("Incorrect number of arguments have been provided. Program Terminating!");
                System.exit(0);

            } else {
                System.out.println("Task 1");
                System.out.println("Correct number of arguments given.");
            }
        }

        // TASK 2
        System.out.println("");
        System.out.println("Task 2");

        for (String arg : args) {
            if (arg.contains("0b")) {
                System.out.println(arg + "=Binary");
            } else if (arg.contains("0x")) {
                System.out.println(arg + "=Hexadecimal");
            } else {
                System.out.println(arg + "=Decimal");
            }
        }

        // TASK 3
        System.out.println("");
        System.out.println("TASK 3");

        for (String arg : args) {
            boolean Binary = arg.matches("0b[01]+");
            boolean Hexadecimal = arg.matches("0x[0-9A-Fa-f]+");
            boolean Decimal = arg.matches("[0-9]+");

            if (Binary || Hexadecimal || Decimal) {
                System.out.println(arg + "=true");
            } else {
                System.out.println(arg + "=false");
            }
        }

        // TASK 4

        // for (int j = 0) for every argument if arg[j] is decimal, print arg[j] =
        // binary format = hexadecimal format
        // if arg[j] is binary, print arg[j] is binary, print arg[j] = decimal format =
        // hexadecimal format
        // if arg [j] is hexadecimal, print arg[j] = binary format = decimal format
        System.out.println("");
        System.out.println("TASK 4");

        for (String arg : args) {
            if (arg.startsWith("0b")) {
                String binaryNums = arg.substring(2);
                int decimalNums = 0;
                int binaryDistance = binaryNums.length();

                for (int i = 0; i < binaryDistance; i++) {
                    char bit = binaryNums.charAt(i);
                    if (bit == '1') {
                        decimalNums += Math.pow(2, binaryDistance - 1 - i);
                    }
                }

                String hexadecimalNums = decToHex(decimalNums);

                System.out.println("Start=" + arg + "," + "Binary=" + "0b" + binaryNums + ","
                        + "Binary=" + decimalNums + "," + "Hexadecimal" + "0x"
                        + hexadecimalNums);

            } else if (arg.startsWith("0x")) {
                String hexadecimalNums = arg.substring(2);
                int decimalNums = 0;
                int hexLength = hexadecimalNums.length();

                for (int i = 0; i < hexLength; i++) {
                    char digit = Character.toUpperCase(hexadecimalNums.charAt(i));
                    int value = Character.isDigit(digit) ? (digit - '0') : (digit - 'A' + 10);
                    decimalNums += value * Math.pow(16, hexLength - 1 - i);
                }

                String binaryNums = decToBin(decimalNums);

                System.out.println("Start=" + arg + "," + "Binary=" + "0b" + binaryNums + ","
                        + "Binary=" + decimalNums + "," + "Hexadecimal" + "0x"
                        + hexadecimalNums);
            } else {

                int decimalNums = Integer.parseInt(arg);
                String binaryNums = "";
                int tempDecimal = decimalNums;

                while (tempDecimal > 0) {
                    int remainder = tempDecimal % 2;
                    binaryNums = remainder + binaryNums;
                    tempDecimal /= 2;
                }

                String hexadecimalNums = decToHex(decimalNums);

                System.out.println("Start=" + arg + "," + "Binary=" + "0b" + binaryNums + ","
                        + "Binary=" + decimalNums + "," + "Hexadecimal" + "0x"
                        + hexadecimalNums);
            }
        }
        // TASK 5
        // for the string arg:args
        // find binary value of arg1 then print following this format arg1=binary of
        // arg1= 1s complement of arg1
        // logic is needed to find 1s compliment-- must iteraterate through each
        // argument and replace all 1s with 0s and all 0s with 1s
        System.out.println("");
        System.out.println("Task 5");
        for (String arg : args) {
            if (arg.startsWith("0b")) {
                String binaryNums = arg.substring(2);
                String onesComplement = computeOnesComplement(binaryNums);

                System.out.println(arg + "=" + binaryNums + "=>"
                        + onesComplement);
            } else if (arg.startsWith("0x")) {
                String hexadecimalNums = arg.substring(2);
                int decimalNums = 0;
                int hexLength = hexadecimalNums.length();

                for (int i = 0; i < hexLength; i++) {
                    char digit = Character.toUpperCase(hexadecimalNums.charAt(i));
                    int value = Character.isDigit(digit) ? (digit - '0') : (digit - 'A' + 10);
                    decimalNums += value * Math.pow(16, hexLength - 1 - i);
                }

                String binaryNums = decToBin(decimalNums);
                String onesComplement = computeOnesComplement(binaryNums);

                System.out.println(arg + "=0b" + binaryNums + "=>"
                        + onesComplement);
            } else {
                String decimalStr = arg;
                int decimalNum = 0;

                boolean isNegative = false;
                if (decimalStr.charAt(0) == '-') {
                    isNegative = true;
                    decimalStr = decimalStr.substring(1);
                }

                for (int i = 0; i < decimalStr.length(); i++) {
                    char digit = decimalStr.charAt(i);
                    if (Character.isDigit(digit)) {
                        decimalNum = decimalNum * 10 + (digit - '0');
                    } else {
                        System.out.println("Invalid decimal input: " + arg);
                        System.exit(1);
                    }
                }

                if (isNegative) {
                    decimalNum = -decimalNum;
                }

                String binaryNum = decToBin(decimalNum);

                String onesComplement = computeOnesComplement(binaryNum);

                System.out.println(arg + "=0b" + binaryNum + "=>"
                        + onesComplement);
            }
        }

        // TASK 6
        System.out.println("");
        System.out.println("Task 6");

        for (String arg : args) {
            if (arg.startsWith("0b")) {
                String binaryNum = arg.substring(2);
                String twosComplement = computeTwosComplement(binaryNum);

                System.out.println(arg + "=" + binaryNum + "=>" + twosComplement);
            } else if (arg.startsWith("0x")) {
                String hexadecimalNum = arg.substring(2);
                int decimalNum = 0;
                int hexLength = hexadecimalNum.length();

                for (int i = 0; i < hexLength; i++) {
                    char digit = Character.toUpperCase(hexadecimalNum.charAt(i));
                    int value = Character.isDigit(digit) ? (digit - '0') : (digit - 'A' + 10);
                    decimalNum += value * Math.pow(16, hexLength - 1 - i);
                }

                String binaryNum = decToBin(decimalNum);
                String twosComplement = computeTwosComplement(binaryNum);

                System.out.println(arg + "=" + binaryNum + "=>" + twosComplement);
            } else {
                String decimalStr = arg;
                int decimalNum = 0;

                boolean isNegative = false;
                if (decimalStr.charAt(0) == '-') {
                    isNegative = true;
                    decimalStr = decimalStr.substring(1);
                }

                for (int i = 0; i < decimalStr.length(); i++) {
                    char digit = decimalStr.charAt(i);
                    if (Character.isDigit(digit)) {
                        decimalNum = decimalNum * 10 + (digit - '0');
                    } else {
                        System.out.println("Invalid decimal input: " + arg);
                        System.exit(1);
                    }
                }

                if (isNegative) {
                    decimalNum = -decimalNum;
                }

                String binaryNum;

                if (arg.startsWith("0b")) {
                    binaryNum = arg.substring(2);
                } else {
                    binaryNum = decToBin(decimalNum);
                }

                String twosComplement = computeTwosComplement(binaryNum);

                System.out.println(arg + "=" + binaryNum + "=>" + twosComplement);
            }
        }

        // Task 7
        System.out.println("");
        System.out.println("Task 7");

        for (String arg : args) {

        }

        // Task 8
        System.out.println("");
        System.out.println("Task 8");

        for (String arg : args) {

        }
    }

    private static String decToHex(int dec) {
        StringBuilder hexadecimalNums = new StringBuilder();
        while (dec > 0) {
            int rem = dec % 16;
            if (rem < 10) {
                hexadecimalNums.insert(0, (char) ('0' + rem));
            } else {
                hexadecimalNums.insert(0, (char) ('A' + rem - 10));
            }
            dec /= 16;
        }
        return hexadecimalNums.toString();
    }

    private static String decToBin(int dec) {
        StringBuilder binaryNums = new StringBuilder();
        while (dec > 0) {
            binaryNums.insert(0, dec % 2);
            dec /= 2;
        }
        return binaryNums.toString();
    }

    private static String computeOnesComplement(String binary) {
        StringBuilder onesComplement = new StringBuilder();
        for (char bit : binary.toCharArray()) {
            onesComplement.append(bit == '0' ? '1' : '0');
        }
        return onesComplement.toString();
    }

    private static String computeTwosComplement(String binary) {
        StringBuilder twosComplement = new StringBuilder();
        boolean carry = true;

        for (int i = binary.length() - 1; i >= 0; i--) {
            char bit = binary.charAt(i);
            if (bit == '0' && carry) {
                twosComplement.insert(0, '1');
            } else if (bit == '1' && carry) {
                twosComplement.insert(0, '0');
            } else {
                twosComplement.insert(0, bit);
            }
        }

        if (carry) {
            twosComplement.insert(0, '1');
        }

        return twosComplement.toString();
    }
}
