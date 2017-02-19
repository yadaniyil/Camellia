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


    private long kl, kr, d1, d2, ka, kb;

    public Camellia() {
        createKeys();
        generateSupportKeys();
        calculateSupportKeys();
    }

    private void createKeys() {
        kl = key;
        kr = 0;
    }

    private void generateSupportKeys() {
        d1 = (kl ^ kr) >> 64;
        d2 = (kl ^ kr) & MASK64;
        d2 = d2 ^ Functions.F(d1, c1);
        d1 = d1 ^ Functions.F(d2, c2);
        d1 = d1 ^ (kl >> 64);
        d2 = d2 ^ (kl & MASK64);
        d2 = d2 ^ Functions.F(d1, c3);
        d1 = d1 ^ Functions.F(d2, c4);
        ka = (d1 << 64) | d2;
        d1 = (ka ^ kr) >> 64;
        d2 = (ka ^ kr) & MASK64;
        d2 = d2 ^ Functions.F(d1, c5);
        d1 = d1 ^ Functions.F(d2, c6);
        kb = (d1 << 64) | d2;
    }

    private void calculateSupportKeys() {
        long kw1, kw2, kw3, kw4;
        long k1, k2, k3, k4, k5, k6, k7, k8, k9,
                k10, k11, k12, k13, k14, k15, k16, k17, k18;
        long ke1, ke2, ke3, ke4;
        kw1 = (kl) >> 64;
        kw2 = (kl) & MASK64;
        k1  = (ka) >> 64; k2  = (ka & MASK64);
        k3  = (kl <<  15) >> 64; k4  = (kl <<  15) & MASK64;
        k5  = (ka <<  15) >> 64; k6  = (ka <<  15) & MASK64;
        ke1 = (ka <<  30) >> 64; ke2 = (ka <<  30) & MASK64;
        k7  = (kl <<  45) >> 64; k8  = (kl <<  45) & MASK64;
        k9  = (ka <<  45) >> 64; k10 = (kl <<  60) & MASK64;
        k11 = (ka <<  60) >> 64; k12 = (ka <<  60) & MASK64;
        ke3 = (kl <<  77) >> 64; ke4 = (kl <<  77) & MASK64;
        k13 = (kl <<  94) >> 64; k14 = (kl <<  94) & MASK64;
        k15 = (ka <<  94) >> 64; k16 = (ka <<  94) & MASK64;
        k17 = (kl << 111) >> 64; k18 = (kl << 111) & MASK64;
        kw3 = (ka << 111) >> 64;kw4 = (ka << 111) & MASK64;
    }
}
