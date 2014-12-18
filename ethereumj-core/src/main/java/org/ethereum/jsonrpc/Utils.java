package org.ethereum.jsonrpc;

import org.spongycastle.util.encoders.Hex;

public class Utils {

    private Utils() {
        // do not instantiate
    }

    public static String toHexStringNullSafe(byte[] input) {
        if (input == null) {
            return null;
        } else {
            return Hex.toHexString(input);
        }
    }

    public static long bytes2Long(byte[] bytes) {
        if (bytes == null) {
            return 0;
        }
        long value = 0;
        for (int i = 0; i < bytes.length; i++) {
            value = (value << 8) + (bytes[i] & 0xff);
        }
        return value;
    }

}
