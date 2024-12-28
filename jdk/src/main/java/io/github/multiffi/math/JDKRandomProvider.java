package io.github.multiffi.math;

import multiffi.math.spi.RandomProvider;

import java.util.Random;

public class JDKRandomProvider extends RandomProvider {

    private static final class RandomHolder {
        private RandomHolder() {
            throw new UnsupportedOperationException();
        }
        public static final Random GENERATOR = new Random();
    }

    @Override
    public boolean nextBoolean(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextBoolean();
    }

    @Override
    public void nextBytes(Random random, byte[] bytes, int offset, int length) {
        if (random == null) random = RandomHolder.GENERATOR;
        byte[] tmp = new byte[length];
        random.nextBytes(tmp);
        System.arraycopy(tmp, 0, bytes, offset, length);
    }

    @Override
    public void nextBytes(Random random, byte[] bytes) {
        if (random == null) random = RandomHolder.GENERATOR;
        random.nextBytes(bytes);
    }

    @Override
    public float nextFloat(Random random, float bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextFloat(bound);
    }

    @Override
    public float nextFloat(Random random, float origin, float bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextFloat(origin, bound);
    }

    @Override
    public float nextFloat(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextFloat();
    }

    @Override
    public double nextDouble(Random random, double bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextDouble(bound);
    }

    @Override
    public double nextDouble(Random random, double origin, double bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextDouble(origin, bound);
    }

    @Override
    public double nextDouble(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextDouble();
    }

    @Override
    public byte nextByte(Random random, byte bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        return (byte) random.nextInt(bound);
    }

    @Override
    public byte nextByte(Random random, byte origin, byte bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        return (byte) random.nextInt(origin, bound);
    }

    @Override
    public byte nextByte(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return (byte) random.nextInt(-128, 128);
    }

    @Override
    public short nextShort(Random random, short bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        return (short) random.nextInt(bound);
    }

    @Override
    public short nextShort(Random random, short origin, short bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        return (short) random.nextInt(origin, bound);
    }

    @Override
    public short nextShort(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return (short) random.nextInt(-32768, 32768);
    }

    @Override
    public int nextInt(Random random, int bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextInt(bound);
    }

    @Override
    public int nextInt(Random random, int origin, int bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextInt(origin, bound);
    }

    @Override
    public int nextInt(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextInt();
    }

    @Override
    public long nextLong(Random random, long bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextLong(bound);
    }

    @Override
    public long nextLong(Random random, long origin, long bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextLong(origin, bound);
    }

    @Override
    public long nextLong(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextLong();
    }

    @Override
    public double nextGaussian(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextGaussian();
    }

    @Override
    public double nextGaussian(Random random, double mean, double stddev) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextGaussian(mean, stddev);
    }

    @Override
    public double nextExponential(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextExponential();
    }

}
