package lab211.utils;

import java.util.Scanner;

public class Utils {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        return getInt(null, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int getInt(int minRange, int maxRange) {
        return getInt(null, minRange, maxRange);
    }

    public static int getInt(String msg) {
        return getInt(msg, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int getInt(String msg, int minRange, int maxRange) {
        if (minRange > maxRange) {
            int temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }

        int value = Integer.MIN_VALUE;

        while (true) {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }

                value = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
            }

            if (value >= minRange && value <= maxRange) {
                break;
            }
        }

        return value;
    }

    public static double getDouble() {
        return getDouble(null, Double.MIN_VALUE, Double.MAX_VALUE);
    }

    public static double getDouble(double minRange, double maxRange) {
        return getDouble(null, minRange, maxRange);
    }

    public static double getDouble(String msg) {
        return getDouble(msg, Double.MIN_VALUE, Double.MAX_VALUE);
    }

    public static double getDouble(String msg, double minRange, double maxRange) {
        if (minRange > maxRange) {
            double temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }

        double value = Double.MIN_VALUE;

        while (true) {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }

                value = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
            }

            if (value >= minRange && value <= maxRange) {
                break;
            }
        }

        return value;
    }
    
    public static String getString(String msg) {
        return getString(msg, 0, null);
    }
    
    public static String getString(String msg, int minNumChars) {
        return getString(msg, minNumChars, null);
    }

    public static String getString(String msg, int minNumChars, String forbiddenChars, String... comparedValues) {
        String tempValue = "";

        boolean isPassed = false;

        while (!isPassed) {
            if (msg != null) {
                System.out.print(msg);
            }

            tempValue = scanner.nextLine();

            if (tempValue.length() >= minNumChars) {
                if (forbiddenChars != null) {
                    if (tempValue.contains(forbiddenChars)) {
                        continue;
                    }
                }

                if (comparedValues.length == 0) {
                    isPassed = true;
                } else {
                    for (String comparedValue : comparedValues) {
                        if (tempValue.equals(comparedValue)) {
                            isPassed = true;
                        }
                    }
                }
            }
        }

        return tempValue;
    }
}
