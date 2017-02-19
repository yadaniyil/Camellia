import java.math.BigInteger;

/**
 * Created by daniil on 19.02.17.
 */
public class Camellia {

    /**
     * Implementation of 128 bit key length Camellia cipher
     */

    private static final long key = 37529104;
    private static final String message = " 0123456789abcdeffedcba9876543210";

    public static final long MASK8 = 0xffL;
    public static final long MASK32 = 0xffffL;
    public static final long MASK64 = 0xffffffL;
    public static final long MASK128 = 0xffffffffL;

    private static final long c1 = 0xA09E667F3BCC908BL;
    private static final long c2 = 0xB67AE8584CAA73B2L;
    private static final long c3 = 0xC6EF372FE94F82BEL;
    private static final long c4 = 0x54FF53A5F1D36F1CL;
    private static final long c5 = 0x10E527FADE682D1DL;
    private static final long c6 = 0xB05688C2B3E6C1FDL;


    private long kl, kr, d1, d2;

    public Camellia() {
        createKeys();
        generateSupportKeys();
    }

    private void createKeys() {
        kl = key;
        kr = 0;
    }

    private void generateSupportKeys() {
        d1 = (kl ^ kr) >> 64;
        d2 = (kl ^ kr) & MASK64;
        d2 = d2 ^ Functions.F(d1, c1);
    }
}
