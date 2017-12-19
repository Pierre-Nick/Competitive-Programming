package epi;

public class Parity {
    public static void main(String[] args) {
        System.out.println(betterComputeParity(7));
    }

    public static short linearComputeParity(int value) {
        short bitCount = 0;

        while (value != 0) {
            bitCount += value&1;
            value >>= 1;
        }

        return (short) (bitCount % 2 == 0 ? 0 : 1);
    }

    public static short betterComputeParity(int value) {
        short result = 0;

        while (value != 0) {     
            result ^= 1;
            value &= (value - 1);
        }

        return result;
    }
}