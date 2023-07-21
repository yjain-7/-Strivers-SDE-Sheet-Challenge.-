import java.io.*;
import java.util.* ;

public class ModuloExponent {
    public static int modularExponentiation(int base, int exponent, int modulus) {
        // Write your code here. 
        if (modulus == 1) {
            return 0; // In this case, the result will always be 0.
        }

        int result = 1;
        base = base % modulus;

        while (exponent > 0) {
            // If the current exponent bit is 1, multiply the result with the current base.
            if (exponent % 2 == 1) {
                result = (int) ((long) result * base % modulus);
            }

            // Move to the next bit of the exponent and update the base.
            exponent >>= 1;
            base = (int) ((long) base * base % modulus);
        }

        return result;       
    }
}