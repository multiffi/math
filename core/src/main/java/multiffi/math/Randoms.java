package multiffi.math;

import multiffi.math.spi.RandomProvider;

import java.util.Random;

public final class Randoms {

    private Randoms() {
        throw new AssertionError("No multiffi.math.Randoms instances for you!");
    }

    private static final RandomProvider IMPLEMENTATION = RandomProvider.getImplementation();

    public static boolean nextBoolean(Random random) {
        return IMPLEMENTATION.nextBoolean(random);
    }

    public static void nextBytes(Random random, byte[] bytes, int offset, int length) {
        IMPLEMENTATION.nextBytes(random, bytes, offset, length);
    }

    public static void nextBytes(Random random, byte[] bytes) {
        IMPLEMENTATION.nextBytes(random, bytes);
    }

    public static float nextFloat(Random random) {
        return IMPLEMENTATION.nextFloat(random);
    }

    public static float nextFloat(Random random, float bound) {
        return IMPLEMENTATION.nextFloat(random, bound);
    }

    public static float nextFloat(Random random, float origin, float bound) {
        return IMPLEMENTATION.nextFloat(random, origin, bound);
    }

    public static double nextDouble(Random random) {
        return IMPLEMENTATION.nextDouble(random);
    }

    public static double nextDouble(Random random, double bound) {
        return IMPLEMENTATION.nextDouble(random, bound);
    }

    public static double nextDouble(Random random, double origin, double bound) {
        return IMPLEMENTATION.nextDouble(random, origin, bound);
    }

    public static byte nextByte(Random random) {
        return IMPLEMENTATION.nextByte(random);
    }

    public static byte nextByte(Random random, byte bound) {
        return IMPLEMENTATION.nextByte(random, bound);
    }

    public static byte nextByte(Random random, byte origin, byte bound) {
        return IMPLEMENTATION.nextByte(random, origin, bound);
    }

    public static short nextShort(Random random) {
        return IMPLEMENTATION.nextShort(random);
    }

    public static short nextShort(Random random, short bound) {
        return IMPLEMENTATION.nextShort(random, bound);
    }

    public static short nextShort(Random random, short origin, short bound) {
        return IMPLEMENTATION.nextShort(random, origin, bound);
    }

    public static int nextInt(Random random) {
        return IMPLEMENTATION.nextInt(random);
    }

    public static int nextInt(Random random, int bound) {
        return IMPLEMENTATION.nextInt(random, bound);
    }

    public static int nextInt(Random random, int origin, int bound) {
        return IMPLEMENTATION.nextInt(random, origin, bound);
    }

    public static long nextLong(Random random) {
        return IMPLEMENTATION.nextLong(random);
    }

    public static long nextLong(Random random, long bound) {
        return IMPLEMENTATION.nextLong(random, bound);
    }

    public static long nextLong(Random random, long origin, long bound) {
        return IMPLEMENTATION.nextLong(random, origin, bound);
    }

    public static double nextGaussian(Random random) {
        return IMPLEMENTATION.nextGaussian(random);
    }

    public static double nextGaussian(Random random, double mean, double stddev) {
        return IMPLEMENTATION.nextGaussian(random, mean, stddev);
    }

    public static double nextExponential(Random random) {
        return IMPLEMENTATION.nextExponential(random);
    }

    public static boolean nextBoolean() {
        return IMPLEMENTATION.nextBoolean();
    }

    public static void nextBytes(byte[] bytes, int offset, int length) {
        IMPLEMENTATION.nextBytes(bytes, offset, length);
    }

    public static void nextBytes(byte[] bytes) {
        IMPLEMENTATION.nextBytes(bytes);
    }

    public static float nextFloat() {
        return IMPLEMENTATION.nextFloat();
    }

    public static float nextFloat(float bound) {
        return IMPLEMENTATION.nextFloat(bound);
    }

    public static float nextFloat(float origin, float bound) {
        return IMPLEMENTATION.nextFloat(origin, bound);
    }

    public static double nextDouble() {
        return IMPLEMENTATION.nextDouble();
    }

    public static double nextDouble(double bound) {
        return IMPLEMENTATION.nextDouble(bound);
    }

    public static double nextDouble(double origin, double bound) {
        return IMPLEMENTATION.nextDouble(origin, bound);
    }

    public static byte nextByte() {
        return IMPLEMENTATION.nextByte();
    }

    public static byte nextByte(byte bound) {
        return IMPLEMENTATION.nextByte(bound);
    }

    public static byte nextByte(byte origin, byte bound) {
        return IMPLEMENTATION.nextByte(origin, bound);
    }

    public static short nextShort() {
        return IMPLEMENTATION.nextShort();
    }

    public static short nextShort(short bound) {
        return IMPLEMENTATION.nextShort(bound);
    }

    public static short nextShort(short origin, short bound) {
        return IMPLEMENTATION.nextShort(origin, bound);
    }

    public static int nextInt() {
        return IMPLEMENTATION.nextInt();
    }

    public static int nextInt(int bound) {
        return IMPLEMENTATION.nextInt(bound);
    }

    public static int nextInt(int origin, int bound) {
        return IMPLEMENTATION.nextInt(origin, bound);
    }

    public static long nextLong() {
        return IMPLEMENTATION.nextLong();
    }

    public static long nextLong(long bound) {
        return IMPLEMENTATION.nextLong(bound);
    }

    public static long nextLong(long origin, long bound) {
        return IMPLEMENTATION.nextLong(origin, bound);
    }

    public static double nextGaussian() {
        return IMPLEMENTATION.nextGaussian();
    }

    public static double nextGaussian(double mean, double stddev) {
        return IMPLEMENTATION.nextGaussian(mean, stddev);
    }

    public static double nextExponential() {
        return IMPLEMENTATION.nextExponential();
    }

}
