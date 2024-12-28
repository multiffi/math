package multiffi.math;

import multiffi.math.spi.MathProvider;

public final class ByteMath {

    private ByteMath() {
        throw new AssertionError("No multiffi.math.ByteMath instances for you!");
    }
    
    private static final MathProvider IMPLEMENTATION = MathProvider.getImplementation();

    public static final byte MIN_VALUE = Byte.MIN_VALUE;
    public static final byte MAX_VALUE = Byte.MAX_VALUE;
    public static final byte U_MIN_VALUE = 0;
    public static final byte U_MAX_VALUE = -1;
    
    public static byte abs(byte value) {
        return IMPLEMENTATION.abs(value);
    }
    public static byte negate(byte value) {
        return IMPLEMENTATION.negate(value);
    }
    public static byte reverse(byte value) {
        return IMPLEMENTATION.reverse(value);
    }
    public static byte highestOneBit(byte value) {
        return IMPLEMENTATION.highestOneBit(value);
    }
    public static byte lowestOneBit(byte value) {
        return IMPLEMENTATION.lowestOneBit(value);
    }
    public static byte increment(byte value) {
        return IMPLEMENTATION.increment(value);
    }
    public static byte decrement(byte value) {
        return IMPLEMENTATION.decrement(value);
    }
    public static byte nearestPowerOfTwo(byte start) {
        return IMPLEMENTATION.nearestPowerOfTwo(start);
    }
    public static byte unsignedNearestPowerOfTwo(byte start) {
        return IMPLEMENTATION.unsignedNearestPowerOfTwo(start);
    }
    public static byte absExact(byte value) {
        return IMPLEMENTATION.absExact(value);
    }
    public static byte negateExact(byte value) {
        return IMPLEMENTATION.negateExact(value);
    }
    public static byte incrementExact(byte value) {
        return IMPLEMENTATION.incrementExact(value);
    }
    public static byte decrementExact(byte value) {
        return IMPLEMENTATION.decrementExact(value);
    }
    public static byte unsignedIncrementExact(byte value) {
        return IMPLEMENTATION.unsignedIncrementExact(value);
    }
    public static byte unsignedDecrementExact(byte value) {
        return IMPLEMENTATION.unsignedDecrementExact(value);
    }
    public static byte add(byte augend, byte addend) {
        return IMPLEMENTATION.add(augend, addend);
    }
    public static byte subtract(byte minuend, byte subtrahend) {
        return IMPLEMENTATION.subtract(minuend, subtrahend);
    }
    public static byte multiply(byte multiplicand, byte multiplier) {
        return IMPLEMENTATION.multiply(multiplicand, multiplier);
    }
    public static byte divide(byte dividend, byte divisor) {
        return IMPLEMENTATION.divide(dividend, divisor);
    }
    public static byte remainder(byte dividend, byte divisor) {
        return IMPLEMENTATION.remainder(dividend, divisor);
    }
    public static byte floorDiv(byte dividend, byte divisor) {
        return IMPLEMENTATION.floorDiv(dividend, divisor);
    }
    public static byte floorMod(byte dividend, byte divisor) {
        return IMPLEMENTATION.floorMod(dividend, divisor);
    }
    public static byte ceilDiv(byte dividend, byte divisor) {
        return IMPLEMENTATION.ceilDiv(dividend, divisor);
    }
    public static byte ceilMod(byte dividend, byte divisor) {
        return IMPLEMENTATION.ceilMod(dividend, divisor);
    }
    public static short multiplyFull(byte multiplicand, byte multiplier) {
        return IMPLEMENTATION.multiplyFull(multiplicand, multiplier);
    }
    public static byte rotateLeft(byte value, int distance) {
        return IMPLEMENTATION.rotateLeft(value, distance);
    }
    public static byte rotateRight(byte value, int distance) {
        return IMPLEMENTATION.rotateRight(value, distance);
    }
    public static byte gcd(byte a, byte b) {
        return IMPLEMENTATION.gcd(a, b);
    }
    public static byte gcd(byte a, byte b, byte c) {
        return IMPLEMENTATION.gcd(a, b, c);
    }
    public static byte lcm(byte a, byte b) {
        return IMPLEMENTATION.lcm(a, b);
    }
    public static byte lcm(byte a, byte b, byte c) {
        return IMPLEMENTATION.lcm(a, b, c);
    }
    public static byte copySign(byte magnitude, byte sign) {
        return IMPLEMENTATION.copySign(magnitude, sign);
    }
    public static byte unsignedDivide(byte dividend, byte divisor) {
        return IMPLEMENTATION.unsignedDivide(dividend, divisor);
    }
    public static byte unsignedRemainder(byte dividend, byte divisor) {
        return IMPLEMENTATION.unsignedRemainder(dividend, divisor);
    }
    public static byte unsignedCeilDiv(byte dividend, byte divisor) {
        return IMPLEMENTATION.unsignedCeilDiv(dividend, divisor);
    }
    public static byte unsignedCeilMod(byte dividend, byte divisor) {
        return IMPLEMENTATION.unsignedCeilMod(dividend, divisor);
    }
    public static short unsignedMultiplyFull(byte multiplicand, byte multiplier) {
        return IMPLEMENTATION.unsignedMultiplyFull(multiplicand, multiplier);
    }
    public static byte addExact(byte augend, byte addend) {
        return IMPLEMENTATION.addExact(augend, addend);
    }
    public static byte subtractExact(byte minuend, byte subtrahend) {
        return IMPLEMENTATION.subtractExact(minuend, subtrahend);
    }
    public static byte multiplyExact(byte multiplicand, byte multiplier) {
        return IMPLEMENTATION.multiplyExact(multiplicand, multiplier);
    }
    public static byte divideExact(byte dividend, byte divisor) {
        return IMPLEMENTATION.divideExact(dividend, divisor);
    }
    public static byte floorDivExact(byte dividend, byte divisor) {
        return IMPLEMENTATION.floorDivExact(dividend, divisor);
    }
    public static byte ceilDivExact(byte dividend, byte divisor) {
        return IMPLEMENTATION.ceilDivExact(dividend, divisor);
    }
    public static byte unsignedAddExact(byte augend, byte addend) {
        return IMPLEMENTATION.unsignedAddExact(augend, addend);
    }
    public static byte unsignedSubtractExact(byte minuend, byte subtrahend) {
        return IMPLEMENTATION.unsignedSubtractExact(minuend, subtrahend);
    }
    public static byte unsignedMultiplyExact(byte multiplicand, byte multiplier) {
        return IMPLEMENTATION.unsignedMultiplyExact(multiplicand, multiplier);
    }
    public static byte unsignedCeilDivExact(byte dividend, byte divisor) {
        return IMPLEMENTATION.unsignedCeilDivExact(dividend, divisor);
    }
    public static int compare(byte a, byte b) {
        return IMPLEMENTATION.compare(a, b);
    }
    public static int compareSign(byte a, byte b) {
        return IMPLEMENTATION.compareSign(a, b);
    }
    public static byte max(byte a, byte b) {
        return IMPLEMENTATION.max(a, b);
    }
    public static byte max(byte a, byte b, byte c) {
        return IMPLEMENTATION.max(a, b, c);
    }
    public static byte min(byte a, byte b) {
        return IMPLEMENTATION.min(a, b);
    }
    public static byte min(byte a, byte b, byte c) {
        return IMPLEMENTATION.min(a, b, c);
    }
    public static byte clamp(byte value, byte min, byte max) {
        return IMPLEMENTATION.clamp(value, min, max);
    }
    public static byte clamp(short value, byte min, byte max) {
        return IMPLEMENTATION.clamp(value, min, max);
    }
    public static int unsignedCompare(byte a, byte b) {
        return IMPLEMENTATION.unsignedCompare(a, b);
    }
    public static byte unsignedMax(byte a, byte b) {
        return IMPLEMENTATION.unsignedMax(a, b);
    }
    public static byte unsignedMax(byte a, byte b, byte c) {
        return IMPLEMENTATION.unsignedMax(a, b, c);
    }
    public static byte unsignedMin(byte a, byte b) {
        return IMPLEMENTATION.unsignedMin(a, b);
    }
    public static byte unsignedMin(byte a, byte b, byte c) {
        return IMPLEMENTATION.unsignedMin(a, b, c);
    }
    public static byte unsignedClamp(byte value, byte min, byte max) {
        return IMPLEMENTATION.unsignedClamp(value, min, max);
    }
    public static byte unsignedClamp(short value, byte min, byte max) {
        return IMPLEMENTATION.unsignedClamp(value, min, max);
    }
    public static int sign(byte value) {
        return IMPLEMENTATION.sign(value);
    }
    public static int clz(byte value) {
        return IMPLEMENTATION.clz(value);
    }
    public static int clon(byte value) {
        return IMPLEMENTATION.clon(value);
    }
    public static int ctz(byte value) {
        return IMPLEMENTATION.ctz(value);
    }
    public static int cton(byte value) {
        return IMPLEMENTATION.cton(value);
    }
    public static int bitCount(byte value) {
        return IMPLEMENTATION.bitCount(value);
    }
    public static boolean isPowerOfTwo(byte value) {
        return IMPLEMENTATION.isPowerOfTwo(value);
    }
    public static boolean unsignedIsPowerOfTwo(byte value) {
        return IMPLEMENTATION.unsignedIsPowerOfTwo(value);
    }
    public static boolean absEqualsOne(byte value) {
        return IMPLEMENTATION.absEqualsOne(value);
    }
    public static short toUnsignedShort(byte value) {
        return IMPLEMENTATION.toUnsignedShort(value);
    }
    public static byte compress(byte value, byte mask) {
        return IMPLEMENTATION.compress(value, mask);
    }
    public static byte expand(byte value, byte mask) {
        return IMPLEMENTATION.expand(value, mask);
    }

}
