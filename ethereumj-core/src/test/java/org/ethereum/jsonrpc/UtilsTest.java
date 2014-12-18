package org.ethereum.jsonrpc;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UtilsTest {

    @Test
    public void shouldConvertBytesToLongMSB() {

        long result = Utils.bytes2Long(new byte[] { 1, 2 });
        assertThat(result, is(256 + 2L));
    }

    @Test
    public void shouldConvertEightBytesToLongMSB() {

        long result = Utils.bytes2Long(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 });
        assertThat(result, is(72623859790382856L));
    }

    @Test
    public void shouldConvertBytesToLongWith2Bytes() {

        long result = Utils.bytes2Long(new byte[] { 1, 1 });
        assertThat(result, is(256 + 1L));
    }

    @Test
    public void shouldConvertBytesToLongSimple() {

        long result = Utils.bytes2Long(new byte[] { 1 });
        assertThat(result, is(1L));
    }

    @Test
    public void shouldConvertBytesToLong0x() {

        long result = Utils.bytes2Long(new byte[] { 0x0A });
        assertThat(result, is(10L));
    }

    @Test
    public void shouldConvertNullBytes() {
        assertThat(Utils.toHexStringNullSafe(null), is((String) null));
    }
}
