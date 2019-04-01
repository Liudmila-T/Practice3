package ua.nure.timoshenko.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public final class Part4 {

    private static final int BYTE_LENGTH = 256;

    private Part4() {
        super();
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        StringBuilder result = new StringBuilder();

        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        result.append(toHexString(hash).toUpperCase(Locale.ENGLISH));

        while (result.indexOf(" ") > 0) {
            result.deleteCharAt(result.indexOf(" "));
        }
        return result.toString();
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            short b = byteToShort(bytes[i]);
            String hex = Integer.toString(b, 0x10);

            if (b < 0x10) {
                buf.append('0');
            }
            buf.append(hex);

            if (i < bytes.length - 1) {
                buf.append(' ');
            }
        }

        return buf.toString();
    }

    private static short byteToShort(byte b) {
        return (b < 0) ? (short) (BYTE_LENGTH + b) : (short) b;
    }

}
