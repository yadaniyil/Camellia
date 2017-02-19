/**
 * Created by daniil on 19.02.17.
 */
public class Functions {

    public static long F(long fIn, long ke) {
        byte t1, t2, t3, t4, t5, t6, t7, t8;
        byte y1, y2, y3, y4, y5, y6, y7, y8;
        byte x = (byte) (fIn ^ ke);
        t1 = (byte) (x >> 56);
        t2 = (byte) ((x >> 48) & Camellia.MASK8);
        t3 = (byte) ((x >> 40) & Camellia.MASK8);
        t4 = (byte) ((x >> 32) & Camellia.MASK8);
        t5 = (byte) ((x >> 24) & Camellia.MASK8);
        t6 = (byte) ((x >> 16) & Camellia.MASK8);
        t7 = (byte) ((x >>  8) & Camellia.MASK8);
        t8 = (byte) (x        & Camellia.MASK8);

        t1 = SBox.getSBox1(t1);
        t2 = SBox.getSBox2(t2);
        t3 = SBox.getSBox3(t3);
        t4 = SBox.getSBox4(t4);
        t5 = SBox.getSBox2(t5);
        t6 = SBox.getSBox3(t6);
        t7 = SBox.getSBox4(t7);
        t8 = SBox.getSBox1(t8);

        y1 = (byte) (t1 ^ t3 ^ t4 ^ t6 ^ t7 ^ t8);
        y2 = (byte) (t1 ^ t2 ^ t4 ^ t5 ^ t7 ^ t8);
        y3 = (byte) (t1 ^ t2 ^ t3 ^ t5 ^ t6 ^ t8);
        y4 = (byte) (t2 ^ t3 ^ t4 ^ t5 ^ t6 ^ t7);
        y5 = (byte) (t1 ^ t2 ^ t6 ^ t7 ^ t8);
        y6 = (byte) (t2 ^ t3 ^ t5 ^ t7 ^ t8);
        y7 = (byte) (t3 ^ t4 ^ t5 ^ t6 ^ t8);
        y8 = (byte) (t1 ^ t4 ^ t5 ^ t6 ^ t7);

        return  (y1 << 56) | (y2 << 48) | (y3 << 40) | (y4 << 32)
                | (y5 << 24) | (y6 << 16) | (y7 <<  8) | y8;
    }
}
