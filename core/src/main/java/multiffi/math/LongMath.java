package multiffi.math;

import multiffi.math.spi.MathProvider;

public final class LongMath {

    private LongMath() {
        throw new AssertionError("No multiffi.math.LongMath instances for you!");
    }

    private static final MathProvider IMPLEMENTATION = MathProvider.getImplementation();

    public static final long MIN_VALUE = Long.MIN_VALUE;
    public static final long MAX_VALUE = Long.MAX_VALUE;
    public static final long U_MIN_VALUE = 0;
    public static final long U_MAX_VALUE = -1L;

    public static long abs(long value) {
        return IMPLEMENTATION.abs(value);
    }
    public static long negate(long value) {
        return IMPLEMENTATION.negate(value);
    }
    public static long reverseBytes(long value) {
        return IMPLEMENTATION.reverseBytes(value);
    }
    public static long reverse(long value) {
        return IMPLEMENTATION.reverse(value);
    }
    public static long highestOneBit(long value) {
        return IMPLEMENTATION.highestOneBit(value);
    }
    public static long lowestOneBit(long value) {
        return IMPLEMENTATION.lowestOneBit(value);
    }
    public static long increment(long value) {
        return IMPLEMENTATION.increment(value);
    }
    public static long decrement(long value) {
        return IMPLEMENTATION.decrement(value);
    }
    public static long nearestPowerOfTwo(long start) {
        return IMPLEMENTATION.nearestPowerOfTwo(start);
    }
    public static long unsignedNearestPowerOfTwo(long start) {
        return IMPLEMENTATION.unsignedNearestPowerOfTwo(start);
    }
    public static long absExact(long value) {
        return IMPLEMENTATION.absExact(value);
    }
    public static long negateExact(long value) {
        return IMPLEMENTATION.negateExact(value);
    }
    public static long incrementExact(long value) {
        return IMPLEMENTATION.incrementExact(value);
    }
    public static long decrementExact(long value) {
        return IMPLEMENTATION.decrementExact(value);
    }
    public static long unsignedIncrementExact(long value) {
        return IMPLEMENTATION.unsignedIncrementExact(value);
    }
    public static long unsignedDecrementExact(long value) {
        return IMPLEMENTATION.unsignedDecrementExact(value);
    }
    public static long add(long augend, long addend) {
        return IMPLEMENTATION.add(augend, addend);
    }
    public static long subtract(long minuend, long subtrahend) {
        return IMPLEMENTATION.subtract(minuend, subtrahend);
    }
    public static long multiply(long multiplicand, long multiplier) {
        return IMPLEMENTATION.multiply(multiplicand, multiplier);
    }
    public static long divide(long dividend, long divisor) {
        return IMPLEMENTATION.divide(dividend, divisor);
    }
    public static long remainder(long dividend, long divisor) {
        return IMPLEMENTATION.remainder(dividend, divisor);
    }
    public static long floorDiv(long dividend, long divisor) {
        return IMPLEMENTATION.floorDiv(dividend, divisor);
    }
    public static long floorMod(long dividend, long divisor) {
        return IMPLEMENTATION.floorMod(dividend, divisor);
    }
    public static long ceilDiv(long dividend, long divisor) {
        return IMPLEMENTATION.ceilDiv(dividend, divisor);
    }
    public static long ceilMod(long dividend, long divisor) {
        return IMPLEMENTATION.ceilMod(dividend, divisor);
    }
    public static long multiplyFull(int multiplicand, int multiplier) {
        return IMPLEMENTATION.multiplyFull(multiplicand, multiplier);
    }
    public static long multiplyHigh(long multiplicand, long multiplier) {
        return IMPLEMENTATION.multiplyHigh(multiplicand, multiplier);
    }
    public static long rotateLeft(long value, int distance) {
        return IMPLEMENTATION.rotateLeft(value, distance);
    }
    public static long rotateRight(long value, int distance) {
        return IMPLEMENTATION.rotateRight(value, distance);
    }
    public static long gcd(long a, long b) {
        return IMPLEMENTATION.gcd(a, b);
    }
    public static long gcd(long a, long b, long c) {
        return IMPLEMENTATION.gcd(a, b, c);
    }
    public static long lcm(long a, long b) {
        return IMPLEMENTATION.lcm(a, b);
    }
    public static long lcm(long a, long b, long c) {
        return IMPLEMENTATION.lcm(a, b, c);
    }
    public static long copySign(long magnitude, long sign) {
        return IMPLEMENTATION.copySign(magnitude, sign);
    }
    public static long unsignedDivide(long dividend, long divisor) {
        return IMPLEMENTATION.unsignedDivide(dividend, divisor);
    }
    public static long unsignedRemainder(long dividend, long divisor) {
        return IMPLEMENTATION.unsignedRemainder(dividend, divisor);
    }
    public static long unsignedCeilDiv(long dividend, long divisor) {
        return IMPLEMENTATION.unsignedCeilDiv(dividend, divisor);
    }
    public static long unsignedCeilMod(long dividend, long divisor) {
        return IMPLEMENTATION.unsignedCeilMod(dividend, divisor);
    }
    public static long unsignedMultiplyHigh(long multiplicand, long multiplier) {
        return IMPLEMENTATION.unsignedMultiplyHigh(multiplicand, multiplier);
    }
    public static long addExact(long augend, long addend) {
        return IMPLEMENTATION.addExact(augend, addend);
    }
    public static long subtractExact(long minuend, long subtrahend) {
        return IMPLEMENTATION.subtractExact(minuend, subtrahend);
    }
    public static long multiplyExact(long multiplicand, long multiplier) {
        return IMPLEMENTATION.multiplyExact(multiplicand, multiplier);
    }
    public static long divideExact(long dividend, long divisor) {
        return IMPLEMENTATION.divideExact(dividend, divisor);
    }
    public static long floorDivExact(long dividend, long divisor) {
        return IMPLEMENTATION.floorDivExact(dividend, divisor);
    }
    public static long ceilDivExact(long dividend, long divisor) {
        return IMPLEMENTATION.ceilDivExact(dividend, divisor);
    }
    public static long unsignedAddExact(long augend, long addend) {
        return IMPLEMENTATION.unsignedAddExact(augend, addend);
    }
    public static long unsignedSubtractExact(long minuend, long subtrahend) {
        return IMPLEMENTATION.unsignedSubtractExact(minuend, subtrahend);
    }
    public static long unsignedMultiplyExact(long multiplicand, long multiplier) {
        return IMPLEMENTATION.unsignedMultiplyExact(multiplicand, multiplier);
    }
    public static long unsignedCeilDivExact(long dividend, long divisor) {
        return IMPLEMENTATION.unsignedCeilDivExact(dividend, divisor);
    }
    public static int compare(long a, long b) {
        return IMPLEMENTATION.compare(a, b);
    }
    public static int compareSign(long a, long b) {
        return IMPLEMENTATION.compareSign(a, b);
    }
    public static long max(long a, long b) {
        return IMPLEMENTATION.max(a, b);
    }
    public static long max(long a, long b, long c) {
        return IMPLEMENTATION.max(a, b, c);
    }
    public static long min(long a, long b) {
        return IMPLEMENTATION.min(a, b);
    }
    public static long min(long a, long b, long c) {
        return IMPLEMENTATION.min(a, b, c);
    }
    public static long clamp(long value, long min, long max) {
        return IMPLEMENTATION.clamp(value, min, max);
    }
    public static int unsignedCompare(long a, long b) {
        return IMPLEMENTATION.unsignedCompare(a, b);
    }
    public static long unsignedMax(long a, long b) {
        return IMPLEMENTATION.unsignedMax(a, b);
    }
    public static long unsignedMax(long a, long b, long c) {
        return IMPLEMENTATION.unsignedMax(a, b, c);
    }
    public static long unsignedMin(long a, long b) {
        return IMPLEMENTATION.unsignedMin(a, b);
    }
    public static long unsignedMin(long a, long b, long c) {
        return IMPLEMENTATION.unsignedMin(a, b, c);
    }
    public static int unsignedClamp(long value, int min, int max) {
        return IMPLEMENTATION.unsignedClamp(value, min, max);
    }
    public static long unsignedClamp(long value, long min, long max) {
        return IMPLEMENTATION.unsignedClamp(value, min, max);
    }
    public static int sign(long value) {
        return IMPLEMENTATION.sign(value);
    }
    public static int clz(long value) {
        return IMPLEMENTATION.clz(value);
    }
    public static int clon(long value) {
        return IMPLEMENTATION.clon(value);
    }
    public static int ctz(long value) {
        return IMPLEMENTATION.ctz(value);
    }
    public static int cton(long value) {
        return IMPLEMENTATION.cton(value);
    }
    public static int bitCount(long value) {
        return IMPLEMENTATION.bitCount(value);
    }
    public static boolean isPowerOfTwo(long value) {
        return IMPLEMENTATION.isPowerOfTwo(value);
    }
    public static boolean unsignedIsPowerOfTwo(long value) {
        return IMPLEMENTATION.unsignedIsPowerOfTwo(value);
    }
    public static boolean absEqualsOne(long value) {
        return IMPLEMENTATION.absEqualsOne(value);
    }
    public static int toInt(long value) {
        return IMPLEMENTATION.toInt(value);
    }
    public static int toIntExact(long value) {
        return IMPLEMENTATION.toIntExact(value);
    }
    public static int unsignedToIntExact(long value) {
        return IMPLEMENTATION.unsignedToIntExact(value);
    }
    public static double bitsToDouble(long bits) {
        return IMPLEMENTATION.bitsToDouble(bits);
    }
    public static long compress(long value, long mask) {
        return IMPLEMENTATION.compress(value, mask);
    }
    public static long expand(long value, long mask) {
        return IMPLEMENTATION.expand(value, mask);
    }

}
