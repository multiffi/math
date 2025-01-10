package multiffi.math.spi;

import java.util.Objects;
import java.util.Random;
import java.util.ServiceLoader;

public abstract class RandomProvider {

    private static volatile RandomProvider IMPLEMENTATION;
    private static final Object IMPLEMENTATION_LOCK = new Object();
    public static RandomProvider getImplementation() {
        if (IMPLEMENTATION == null) synchronized (IMPLEMENTATION_LOCK) {
            if (IMPLEMENTATION == null) {
                try {
                    IMPLEMENTATION = (RandomProvider) Class
                            .forName(Objects.requireNonNull(System.getProperty("multiffi.random.provider")))
                            .getConstructor()
                            .newInstance();
                } catch (Throwable e) {
                    try {
                        for (RandomProvider provider : ServiceLoader.load(RandomProvider.class)) {
                            if (provider != null) {
                                IMPLEMENTATION = provider;
                                break;
                            }
                        }
                    }
                    catch (Throwable ex) {
                        IMPLEMENTATION = null;
                    }
                }
                if (IMPLEMENTATION == null) throw new IllegalStateException("Failed to get any installed multiffi.math.spi.RandomProvider instance");
            }
        }
        return IMPLEMENTATION;
    }

    public abstract boolean nextBoolean(Random random);
    public abstract void nextBytes(Random random, byte[] bytes, int offset, int length);
    public abstract void nextBytes(Random random, byte[] bytes);
    public abstract float nextFloat(Random random, float bound);
    public abstract float nextFloat(Random random, float origin, float bound);
    public abstract float nextFloat(Random random);
    public abstract double nextDouble(Random random, double bound);
    public abstract double nextDouble(Random random, double origin, double bound);
    public abstract double nextDouble(Random random);
    public abstract byte nextByte(Random random, byte bound);
    public abstract byte nextByte(Random random, byte origin, byte bound);
    public abstract byte nextByte(Random random);
    public abstract short nextShort(Random random, short bound);
    public abstract short nextShort(Random random, short origin, short bound);
    public abstract short nextShort(Random random);
    public abstract int nextInt(Random random, int bound);
    public abstract int nextInt(Random random, int origin, int bound);
    public abstract int nextInt(Random random);
    public abstract long nextLong(Random random, long bound);
    public abstract long nextLong(Random random, long origin, long bound);
    public abstract long nextLong(Random random);
    public abstract double nextGaussian(Random random);
    public abstract double nextGaussian(Random random, double mean, double stddev);
    public abstract double nextExponential(Random random);
    public boolean nextBoolean() {
        return nextBoolean(null);
    }
    public void nextBytes(byte[] bytes, int offset, int length) {
        nextBytes(null, bytes, offset, length);
    }
    public void nextBytes(byte[] bytes) {
        nextBytes(null, bytes);
    }
    public float nextFloat(float bound) {
        return nextFloat(null, bound);
    }
    public float nextFloat(float origin, float bound) {
        return nextFloat(null, origin, bound);
    }
    public float nextFloat() {
        return nextFloat(null);
    }
    public double nextDouble(double bound) {
        return nextDouble(null, bound);
    }
    public double nextDouble(double origin, double bound) {
        return nextDouble(null, origin, bound);
    }
    public double nextDouble() {
        return nextDouble(null);
    }
    public byte nextByte(byte bound) {
        return nextByte(null, bound);
    }
    public byte nextByte(byte origin, byte bound) {
        return nextByte(null, origin, bound);
    }
    public byte nextByte() {
        return nextByte(null);
    }
    public short nextShort(short bound) {
        return nextShort(null, bound);
    }
    public short nextShort(short origin, short bound) {
        return nextShort(null, origin, bound);
    }
    public short nextShort() {
        return nextShort(null);
    }
    public int nextInt(int bound) {
        return nextInt(null, bound);
    }
    public int nextInt(int origin, int bound) {
        return nextInt(null, origin, bound);
    }
    public int nextInt() {
        return nextInt(null);
    }
    public long nextLong(long bound) {
        return nextLong(null, bound);
    }
    public long nextLong(long origin, long bound) {
        return nextLong(null, origin, bound);
    }
    public long nextLong() {
        return nextLong(null);
    }
    public double nextGaussian() {
        return nextGaussian(null);
    }
    public double nextGaussian(double mean, double stddev) {
        return nextGaussian(null, mean, stddev);
    }
    public double nextExponential() {
        return nextExponential(null);
    }

}
