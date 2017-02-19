/**
 * Created by daniil on 19.02.17.
 */
public class Utils {
    public static byte[] getByteValues(byte value) {
        String byteString = String.valueOf(value);
        if(byteString.length() == 1) {
            return new byte[] {0, Byte.valueOf(value)};
        } else if(byteString.length() == 2) {
            return new byte[] {Byte.valueOf(byteString.substring(0, 1)),
                    Byte.valueOf(byteString.substring(1, 2))};
        } else {
            return null;
        }
    }
}
