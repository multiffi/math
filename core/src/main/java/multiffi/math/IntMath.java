package multiffi.math;

import multiffi.math.spi.MathProvider;

public final class IntMath {

    private IntMath() {
        throw new AssertionError("No multiffi.math.IntMath instances for you!");
    }

    private static final MathProvider IMPLEMENTATION = MathProvider.getImplementation();

    public static final int MIN_VALUE = Integer.MIN_VALUE;
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static final int U_MIN_VALUE = 0;
    public static final int U_MAX_VALUE = -1;

    public static int abs(int value) {
        return IMPLEMENTATION.abs(value);
    }
    public static int negate(int value) {
        return IMPLEMENTATION.negate(value);
    }
    public static int reverseBytes(int value) {
        return IMPLEMENTATION.reverseBytes(value);
    }
    public static int reverse(int value) {
        return IMPLEMENTATION.reverse(value);
    }
    public static int highestOneBit(int value) {
        return IMPLEMENTATION.highestOneBit(value);
    }
    public static int lowestOneBit(int value) {
        return IMPLEMENTATION.lowestOneBit(value);
    }
    public static int increment(int value) {
        return IMPLEMENTATION.increment(value);
    }
    public static int decrement(int value) {
        return IMPLEMENTATION.decrement(value);
    }
    public static int nearestPowerOfTwo(int start) {
        return IMPLEMENTATION.nearestPowerOfTwo(start);
    }
    public static int unsignedNearestPowerOfTwo(int start) {
        return IMPLEMENTATION.unsignedNearestPowerOfTwo(start);
    }
    public static int absExact(int value) {
        return IMPLEMENTATION.absExact(value);
    }
    public static int negateExact(int value) {
        return IMPLEMENTATION.negateExact(value);
    }
    public static int incrementExact(int value) {
        return IMPLEMENTATION.incrementExact(value);
    }
    public static int decrementExact(int value) {
        return IMPLEMENTATION.decrementExact(value);
    }
    public static int unsignedIncrementExact(int value) {
        return IMPLEMENTATION.unsignedIncrementExact(value);
    }
    public static int unsignedDecrementExact(int value) {
        return IMPLEMENTATION.unsignedDecrementExact(value);
    }
    public static int add(int augend, int addend) {
        return IMPLEMENTATION.add(augend, addend);
    }
    public static int subtract(int minuend, int subtrahend) {
        return IMPLEMENTATION.subtract(minuend, subtrahend);
    }
    public static int multiply(int multiplicand, int multiplier) {
        return IMPLEMENTATION.multiply(multiplicand, multiplier);
    }
    public static int divide(int dividend, int divisor) {
        return IMPLEMENTATION.divide(dividend, divisor);
    }
    public static int remainder(int dividend, int divisor) {
        return IMPLEMENTATION.remainder(dividend, divisor);
    }
    public static int floorDiv(int dividend, int divisor) {
        return IMPLEMENTATION.floorDiv(dividend, divisor);
    }
    public static int floorMod(int dividend, int divisor) {
        return IMPLEMENTATION.floorMod(dividend, divisor);
    }
    public static int ceilDiv(int dividend, int divisor) {
        return IMPLEMENTATION.ceilDiv(dividend, divisor);
    }
    public static int ceilMod(int dividend, int divisor) {
        return IMPLEMENTATION.ceilMod(dividend, divisor);
    }
    public static int rotateLeft(int value, int distance) {
        return IMPLEMENTATION.rotateLeft(value, distance);
    }
    public static int rotateRight(int value, int distance) {
        return IMPLEMENTATION.rotateRight(value, distance);
    }
    public static int gcd(int a, int b) {
        return IMPLEMENTATION.gcd(a, b);
    }
    public static int gcd(int a, int b, int c) {
        return IMPLEMENTATION.gcd(a, b, c);
    }
    public static int lcm(int a, int b) {
        return IMPLEMENTATION.lcm(a, b);
    }
    public static int lcm(int a, int b, int c) {
        return IMPLEMENTATION.lcm(a, b, c);
    }
    public static int copySign(int magnitude, int sign) {
        return IMPLEMENTATION.copySign(magnitude, sign);
    }
    public static int unsignedDivide(int dividend, int divisor) {
        return IMPLEMENTATION.unsignedDivide(dividend, divisor);
    }
    public static int unsignedRemainder(int dividend, int divisor) {
        return IMPLEMENTATION.unsignedRemainder(dividend, divisor);
    }
    public static int unsignedCeilDiv(int dividend, int divisor) {
        return IMPLEMENTATION.unsignedCeilDiv(dividend, divisor);
    }
    public static int unsignedCeilMod(int dividend, int divisor) {
        return IMPLEMENTATION.unsignedCeilMod(dividend, divisor);
    }
    public static long unsignedMultiplyFull(int multiplicand, int multiplier) {
        return IMPLEMENTATION.unsignedMultiplyFull(multiplicand, multiplier);
    }
    public static int addExact(int augend, int addend) {
        return IMPLEMENTATION.addExact(augend, addend);
    }
    public static int subtractExact(int minuend, int subtrahend) {
        return IMPLEMENTATION.subtractExact(minuend, subtrahend);
    }
    public static int multiplyExact(int multiplicand, int multiplier) {
        return IMPLEMENTATION.multiplyExact(multiplicand, multiplier);
    }
    public static int divideExact(int dividend, int divisor) {
        return IMPLEMENTATION.divideExact(dividend, divisor);
    }
    public static int floorDivExact(int dividend, int divisor) {
        return IMPLEMENTATION.floorDivExact(dividend, divisor);
    }
    public static int ceilDivExact(int dividend, int divisor) {
        return IMPLEMENTATION.ceilDivExact(dividend, divisor);
    }
    public static int unsignedAddExact(int augend, int addend) {
        return IMPLEMENTATION.unsignedAddExact(augend, addend);
    }
    public static int unsignedSubtractExact(int minuend, int subtrahend) {
        return IMPLEMENTATION.unsignedSubtractExact(minuend, subtrahend);
    }
    public static int unsignedMultiplyExact(int multiplicand, int multiplier) {
        return IMPLEMENTATION.unsignedMultiplyExact(multiplicand, multiplier);
    }
    public static int unsignedCeilDivExact(int dividend, int divisor) {
        return IMPLEMENTATION.unsignedCeilDivExact(dividend, divisor);
    }
    public static int compare(int a, int b) {
        return IMPLEMENTATION.compare(a, b);
    }
    public static int compareSign(int a, int b) {
        return IMPLEMENTATION.compareSign(a, b);
    }
    public static int max(int a, int b) {
        return IMPLEMENTATION.max(a, b);
    }
    public static int max(int a, int b, int c) {
        return IMPLEMENTATION.max(a, b, c);
    }
    public static int min(int a, int b) {
        return IMPLEMENTATION.min(a, b);
    }
    public static int min(int a, int b, int c) {
        return IMPLEMENTATION.min(a, b, c);
    }
    public static int clamp(int value, int min, int max) {
        return IMPLEMENTATION.clamp(value, min, max);
    }
    public static int clamp(long value, int min, int max) {
        return IMPLEMENTATION.clamp(value, min, max);
    }
    public static int unsignedCompare(int a, int b) {
        return IMPLEMENTATION.unsignedCompare(a, b);
    }
    public static int unsignedMax(int a, int b) {
        return IMPLEMENTATION.unsignedMax(a, b);
    }
    public static int unsignedMax(int a, int b, int c) {
        return IMPLEMENTATION.unsignedMax(a, b, c);
    }
    public static int unsignedMin(int a, int b) {
        return IMPLEMENTATION.unsignedMin(a, b);
    }
    public static int unsignedMin(int a, int b, int c) {
        return IMPLEMENTATION.unsignedMin(a, b, c);
    }
    public static int unsignedClamp(int value, int min, int max) {
        return IMPLEMENTATION.unsignedClamp(value, min, max);
    }
    public static int unsignedClamp(long value, int min, int max) {
        return IMPLEMENTATION.unsignedClamp(value, min, max);
    }
    public static int sign(int value) {
        return IMPLEMENTATION.sign(value);
    }
    public static int clz(int value) {
        return IMPLEMENTATION.clz(value);
    }
    public static int clon(int value) {
        return IMPLEMENTATION.clon(value);
    }
    public static int ctz(int value) {
        return IMPLEMENTATION.ctz(value);
    }
    public static int cton(int value) {
        return IMPLEMENTATION.cton(value);
    }
    public static int bitCount(int value) {
        return IMPLEMENTATION.bitCount(value);
    }
    public static boolean isPowerOfTwo(int value) {
        return IMPLEMENTATION.isPowerOfTwo(value);
    }
    public static boolean unsignedIsPowerOfTwo(int value) {
        return IMPLEMENTATION.unsignedIsPowerOfTwo(value);
    }
    public static boolean absEqualsOne(int value) {
        return IMPLEMENTATION.absEqualsOne(value);
    }
    public static short toShort(int value) {
        return IMPLEMENTATION.toShort(value);
    }
    public static short toShortExact(int value) {
        return IMPLEMENTATION.toShortExact(value);
    }
    public static short unsignedToShortExact(int value) {
        return IMPLEMENTATION.unsignedToShortExact(value);
    }
    public static long toUnsignedLong(int value) {
        return IMPLEMENTATION.toUnsignedLong(value);
    }
    public static float bitsToFloat(int bits) {
        return IMPLEMENTATION.bitsToFloat(bits);
    }
    public static int compress(int value, int mask) {
        return IMPLEMENTATION.compress(value, mask);
    }
    public static int expand(int value, int mask) {
        return IMPLEMENTATION.expand(value, mask);
    }

}
