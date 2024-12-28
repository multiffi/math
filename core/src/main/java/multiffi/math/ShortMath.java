package multiffi.math;

import multiffi.math.spi.MathProvider;

public final class ShortMath {

    private ShortMath() {
        throw new AssertionError("No multiffi.math.ShortMath instances for you!");
    }

    private static final MathProvider IMPLEMENTATION = MathProvider.getImplementation();

    public static final short MIN_VALUE = Short.MIN_VALUE;
    public static final short MAX_VALUE = Short.MAX_VALUE;
    public static final short U_MIN_VALUE = 0;
    public static final short U_MAX_VALUE = -1;

    public static short abs(short value) {
        return IMPLEMENTATION.abs(value);
    }
    public static short negate(short value) {
        return IMPLEMENTATION.negate(value);
    }
    public static short reverseBytes(short value) {
        return IMPLEMENTATION.reverseBytes(value);
    }
    public static short reverse(short value) {
        return IMPLEMENTATION.reverse(value);
    }
    public static short highestOneBit(short value) {
        return IMPLEMENTATION.highestOneBit(value);
    }
    public static short lowestOneBit(short value) {
        return IMPLEMENTATION.lowestOneBit(value);
    }
    public static short increment(short value) {
        return IMPLEMENTATION.increment(value);
    }
    public static short decrement(short value) {
        return IMPLEMENTATION.decrement(value);
    }
    public static short nearestPowerOfTwo(short start) {
        return IMPLEMENTATION.nearestPowerOfTwo(start);
    }
    public static short unsignedNearestPowerOfTwo(short start) {
        return IMPLEMENTATION.unsignedNearestPowerOfTwo(start);
    }
    public static short absExact(short value) {
        return IMPLEMENTATION.absExact(value);
    }
    public static short negateExact(short value) {
        return IMPLEMENTATION.negateExact(value);
    }
    public static short incrementExact(short value) {
        return IMPLEMENTATION.incrementExact(value);
    }
    public static short decrementExact(short value) {
        return IMPLEMENTATION.decrementExact(value);
    }
    public static short unsignedIncrementExact(short value) {
        return IMPLEMENTATION.unsignedIncrementExact(value);
    }
    public static short unsignedDecrementExact(short value) {
        return IMPLEMENTATION.unsignedDecrementExact(value);
    }
    public static short add(short augend, short addend) {
        return IMPLEMENTATION.add(augend, addend);
    }
    public static short subtract(short minuend, short subtrahend) {
        return IMPLEMENTATION.subtract(minuend, subtrahend);
    }
    public static short multiply(short multiplicand, short multiplier) {
        return IMPLEMENTATION.multiply(multiplicand, multiplier);
    }
    public static short divide(short dividend, short divisor) {
        return IMPLEMENTATION.divide(dividend, divisor);
    }
    public static short remainder(short dividend, short divisor) {
        return IMPLEMENTATION.remainder(dividend, divisor);
    }
    public static short floorDiv(short dividend, short divisor) {
        return IMPLEMENTATION.floorDiv(dividend, divisor);
    }
    public static short floorMod(short dividend, short divisor) {
        return IMPLEMENTATION.floorMod(dividend, divisor);
    }
    public static short ceilDiv(short dividend, short divisor) {
        return IMPLEMENTATION.ceilDiv(dividend, divisor);
    }
    public static short ceilMod(short dividend, short divisor) {
        return IMPLEMENTATION.ceilMod(dividend, divisor);
    }
    public static int multiplyFull(short multiplicand, short multiplier) {
        return IMPLEMENTATION.multiplyFull(multiplicand, multiplier);
    }
    public static short rotateLeft(short value, int distance) {
        return IMPLEMENTATION.rotateLeft(value, distance);
    }
    public static short rotateRight(short value, int distance) {
        return IMPLEMENTATION.rotateRight(value, distance);
    }
    public static short gcd(short a, short b) {
        return IMPLEMENTATION.gcd(a, b);
    }
    public static short gcd(short a, short b, short c) {
        return IMPLEMENTATION.gcd(a, b, c);
    }
    public static short lcm(short a, short b) {
        return IMPLEMENTATION.lcm(a, b);
    }
    public static short lcm(short a, short b, short c) {
        return IMPLEMENTATION.lcm(a, b, c);
    }
    public static short copySign(short magnitude, short sign) {
        return IMPLEMENTATION.copySign(magnitude, sign);
    }
    public static short unsignedDivide(short dividend, short divisor) {
        return IMPLEMENTATION.unsignedDivide(dividend, divisor);
    }
    public static short unsignedRemainder(short dividend, short divisor) {
        return IMPLEMENTATION.unsignedRemainder(dividend, divisor);
    }
    public static short unsignedCeilDiv(short dividend, short divisor) {
        return IMPLEMENTATION.unsignedCeilDiv(dividend, divisor);
    }
    public static short unsignedCeilMod(short dividend, short divisor) {
        return IMPLEMENTATION.unsignedCeilMod(dividend, divisor);
    }
    public static int unsignedMultiplyFull(short multiplicand, short multiplier) {
        return IMPLEMENTATION.unsignedMultiplyFull(multiplicand, multiplier);
    }
    public static short addExact(short augend, short addend) {
        return IMPLEMENTATION.addExact(augend, addend);
    }
    public static short subtractExact(short minuend, short subtrahend) {
        return IMPLEMENTATION.subtractExact(minuend, subtrahend);
    }
    public static short multiplyExact(short multiplicand, short multiplier) {
        return IMPLEMENTATION.multiplyExact(multiplicand, multiplier);
    }
    public static short divideExact(short dividend, short divisor) {
        return IMPLEMENTATION.divideExact(dividend, divisor);
    }
    public static short floorDivExact(short dividend, short divisor) {
        return IMPLEMENTATION.floorDivExact(dividend, divisor);
    }
    public static short ceilDivExact(short dividend, short divisor) {
        return IMPLEMENTATION.ceilDivExact(dividend, divisor);
    }
    public static short unsignedAddExact(short augend, short addend) {
        return IMPLEMENTATION.unsignedAddExact(augend, addend);
    }
    public static short unsignedSubtractExact(short minuend, short subtrahend) {
        return IMPLEMENTATION.unsignedSubtractExact(minuend, subtrahend);
    }
    public static short unsignedMultiplyExact(short multiplicand, short multiplier) {
        return IMPLEMENTATION.unsignedMultiplyExact(multiplicand, multiplier);
    }
    public static short unsignedCeilDivExact(short dividend, short divisor) {
        return IMPLEMENTATION.unsignedCeilDivExact(dividend, divisor);
    }
    public static int compare(short a, short b) {
        return IMPLEMENTATION.compare(a, b);
    }
    public static int compareSign(short a, short b) {
        return IMPLEMENTATION.compareSign(a, b);
    }
    public static short max(short a, short b) {
        return IMPLEMENTATION.max(a, b);
    }
    public static short max(short a, short b, short c) {
        return IMPLEMENTATION.max(a, b, c);
    }
    public static short min(short a, short b) {
        return IMPLEMENTATION.min(a, b);
    }
    public static short min(short a, short b, short c) {
        return IMPLEMENTATION.min(a, b, c);
    }
    public static short clamp(short value, short min, short max) {
        return IMPLEMENTATION.clamp(value, min, max);
    }
    public static short clamp(int value, short min, short max) {
        return IMPLEMENTATION.clamp(value, min, max);
    }
    public static int unsignedCompare(short a, short b) {
        return IMPLEMENTATION.unsignedCompare(a, b);
    }
    public static short unsignedMax(short a, short b) {
        return IMPLEMENTATION.unsignedMax(a, b);
    }
    public static short unsignedMax(short a, short b, short c) {
        return IMPLEMENTATION.unsignedMax(a, b, c);
    }
    public static short unsignedMin(short a, short b) {
        return IMPLEMENTATION.unsignedMin(a, b);
    }
    public static short unsignedMin(short a, short b, short c) {
        return IMPLEMENTATION.unsignedMin(a, b, c);
    }
    public static short unsignedClamp(short value, short min, short max) {
        return IMPLEMENTATION.unsignedClamp(value, min, max);
    }
    public static short unsignedClamp(int value, short min, short max) {
        return IMPLEMENTATION.unsignedClamp(value, min, max);
    }
    public static int sign(short value) {
        return IMPLEMENTATION.sign(value);
    }
    public static int clz(short value) {
        return IMPLEMENTATION.clz(value);
    }
    public static int clon(short value) {
        return IMPLEMENTATION.clon(value);
    }
    public static int ctz(short value) {
        return IMPLEMENTATION.ctz(value);
    }
    public static int cton(short value) {
        return IMPLEMENTATION.cton(value);
    }
    public static int bitCount(short value) {
        return IMPLEMENTATION.bitCount(value);
    }
    public static boolean isPowerOfTwo(short value) {
        return IMPLEMENTATION.isPowerOfTwo(value);
    }
    public static boolean unsignedIsPowerOfTwo(short value) {
        return IMPLEMENTATION.unsignedIsPowerOfTwo(value);
    }
    public static byte toByte(short value) {
        return IMPLEMENTATION.toByte(value);
    }
    public static byte toByteExact(short value) {
        return IMPLEMENTATION.toByteExact(value);
    }
    public static boolean absEqualsOne(float value) {
        return IMPLEMENTATION.absEqualsOne(value);
    }
    public static byte unsignedToByteExact(short value) {
        return IMPLEMENTATION.unsignedToByteExact(value);
    }
    public static int toUnsignedInt(short value) {
        return IMPLEMENTATION.toUnsignedInt(value);
    }
    public static short compress(short value, short mask) {
        return IMPLEMENTATION.compress(value, mask);
    }
    public static short expand(short value, short mask) {
        return IMPLEMENTATION.expand(value, mask);
    }

}
