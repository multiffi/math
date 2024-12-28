package multiffi.math;

import multiffi.math.spi.MathProvider;

import java.math.RoundingMode;

public final class FloatMath {
    
    private FloatMath() {
        throw new AssertionError("No multiffi.math.FloatMath instances for you!");
    }

    private static final MathProvider IMPLEMENTATION = MathProvider.getImplementation();

    public static final float E = (float) Math.E;
    public static final float PI = (float) Math.PI;
    public static final float PI_HALF = (float) (Math.PI * 0.5);
    public static final float PI_QUARTER = (float) (Math.PI * 0.25);
    public static final float TAU = (float) (2.0 * Math.PI);
    public static final float LN10 = (float) Math.log(10);
    public static final float LN2 = (float) Math.log(2);
    public static final float LOG10E = (float) Math.log10(Math.E);
    public static final float LOG2E = (float) (Math.log(Math.E) / LN2);
    public static final float SQRT2 = (float) Math.sqrt(2);
    public static final float SQRT1_2 = (float) Math.sqrt(0.5);

    public static final float POSITIVE_MIN_VALUE = Float.MIN_VALUE;
    public static final float POSITIVE_MAX_VALUE = Float.MAX_VALUE;
    public static final float NEGATIVE_MIN_VALUE = -Float.MAX_VALUE;
    public static final float NEGATIVE_MAX_VALUE = -Float.MIN_VALUE;
    public static final float POSITIVE_INFINITY = Float.POSITIVE_INFINITY;
    public static final float NEGATIVE_INFINITY = Float.NEGATIVE_INFINITY;
    public static final float MIN_NORMAL = Float.MIN_NORMAL;
    public static final float MAX_SUBNORMAL = 0x0.fffffep-126f;
    public static final int MAX_EXPONENT = Float.MAX_EXPONENT;
    public static final int MIN_EXPONENT = Float.MIN_EXPONENT;

    public static float toRadians(float degrees) {
        return IMPLEMENTATION.toRadians(degrees);
    }
    public static float toDegrees(float radians) {
        return IMPLEMENTATION.toDegrees(radians);
    }
    public static float sin(float angle) {
        return IMPLEMENTATION.sin(angle);
    }
    public static float cos(float angle) {
        return IMPLEMENTATION.cos(angle);
    }
    public static float tan(float angle) {
        return IMPLEMENTATION.tan(angle);
    }
    public static float sinCos(float cosSin, float angle) {
        return IMPLEMENTATION.sinCos(cosSin, angle);
    }
    public static float asin(float angle) {
        return IMPLEMENTATION.asin(angle);
    }
    public static float acos(float angle) {
        return IMPLEMENTATION.acos(angle);
    }
    public static float atan(float angle) {
        return IMPLEMENTATION.atan(angle);
    }
    public static float safeAsin(float angle) {
        return IMPLEMENTATION.safeAsin(angle);
    }
    public static float safeAcos(float angle) {
        return IMPLEMENTATION.safeAcos(angle);
    }
    public static float atan2(float y, float x) {
        return IMPLEMENTATION.atan2(y, x);
    }
    public static float sinh(float angle) {
        return IMPLEMENTATION.sinh(angle);
    }
    public static float cosh(float angle) {
        return IMPLEMENTATION.cosh(angle);
    }
    public static float tanh(float angle) {
        return IMPLEMENTATION.tanh(angle);
    }
    public static float asinh(float angle) {
        return IMPLEMENTATION.asinh(angle);
    }
    public static float acosh(float angle) {
        return IMPLEMENTATION.acosh(angle);
    }
    public static float atanh(float angle) {
        return IMPLEMENTATION.atanh(angle);
    }
    public static float pow(float base, float exponent) {
        return IMPLEMENTATION.pow(base, exponent);
    }
    public static float square(float base) {
        return IMPLEMENTATION.square(base);
    }
    public static float cube(float base) {
        return IMPLEMENTATION.cube(base);
    }
    public static float exp(float exponent) {
        return IMPLEMENTATION.exp(exponent);
    }
    public static float expm1(float exponent) {
        return IMPLEMENTATION.expm1(exponent);
    }
    public static float log(float base, float power) {
        return IMPLEMENTATION.log(base, power);
    }
    public static float log(float power) {
        return IMPLEMENTATION.log(power);
    }
    public static float log10(float power) {
        return IMPLEMENTATION.log10(power);
    }
    public static float log2(float power) {
        return IMPLEMENTATION.log2(power);
    }
    public static float log1p(float power) {
        return IMPLEMENTATION.log1p(power);
    }
    public static float root(float exponent, float power) {
        return IMPLEMENTATION.root(exponent, power);
    }
    public static float invroot(float exponent, float power) {
        return IMPLEMENTATION.invroot(exponent, power);
    }
    public static float sqrt(float power) {
        return IMPLEMENTATION.sqrt(power);
    }
    public static float cbrt(float power) {
        return IMPLEMENTATION.cbrt(power);
    }
    public static float invsqrt(float power) {
        return IMPLEMENTATION.invsqrt(power);
    }
    public static float invcbrt(float power) {
        return IMPLEMENTATION.invcbrt(power);
    }
    public static float up(float value) {
        return IMPLEMENTATION.up(value);
    }
    public static float down(float value) {
        return IMPLEMENTATION.down(value);
    }
    public static float ceiling(float value) {
        return IMPLEMENTATION.ceiling(value);
    }
    public static float floor(float value) {
        return IMPLEMENTATION.floor(value);
    }
    public static float halfUp(float value) {
        return IMPLEMENTATION.halfUp(value);
    }
    public static float halfDown(float value) {
        return IMPLEMENTATION.halfDown(value);
    }
    public static float halfEven(float value) {
        return IMPLEMENTATION.halfEven(value);
    }
    public static float trunc(float value) {
        return IMPLEMENTATION.trunc(value);
    }
    public static float truncExact(float value) {
        return IMPLEMENTATION.truncExact(value);
    }
    public static float round(float value) {
        return IMPLEMENTATION.round(value);
    }
    public static int roundToInt(float value) {
        return IMPLEMENTATION.roundToInt(value);
    }
    public static float round(float value, RoundingMode mode) {
        return IMPLEMENTATION.round(value, mode);
    }
    public static float abs(float value) {
        return IMPLEMENTATION.abs(value);
    }
    public static float negate(float value) {
        return IMPLEMENTATION.negate(value);
    }
    public static float ulp(float start) {
        return IMPLEMENTATION.ulp(start);
    }
    public static float nextUp(float start) {
        return IMPLEMENTATION.nextUp(start);
    }
    public static float nextDown(float start) {
        return IMPLEMENTATION.nextDown(start);
    }
    public static float reciprocalEstimate(float value) {
        return IMPLEMENTATION.reciprocalEstimate(value);
    }
    public static float reciprocalSqrtEstimate(float value) {
        return IMPLEMENTATION.reciprocalSqrtEstimate(value);
    }
    public static float reciprocalCbrtEstimate(float value) {
        return IMPLEMENTATION.reciprocalCbrtEstimate(value);
    }
    public static float increment(float value) {
        return IMPLEMENTATION.increment(value);
    }
    public static float decrement(float value) {
        return IMPLEMENTATION.decrement(value);
    }
    public static float add(float augend, float addend) {
        return IMPLEMENTATION.add(augend, addend);
    }
    public static float subtract(float minuend, float subtrahend) {
        return IMPLEMENTATION.subtract(minuend, subtrahend);
    }
    public static float multiply(float multiplicand, float multiplier) {
        return IMPLEMENTATION.multiply(multiplicand, multiplier);
    }
    public static float divide(float dividend, float divisor) {
        return IMPLEMENTATION.divide(dividend, divisor);
    }
    public static float remainder(float dividend, float divisor) {
        return IMPLEMENTATION.remainder(dividend, divisor);
    }
    public static float floorDiv(float dividend, float divisor) {
        return IMPLEMENTATION.floorDiv(dividend, divisor);
    }
    public static float floorMod(float dividend, float divisor) {
        return IMPLEMENTATION.floorMod(dividend, divisor);
    }
    public static float ceilDiv(float dividend, float divisor) {
        return IMPLEMENTATION.ceilDiv(dividend, divisor);
    }
    public static float ceilMod(float dividend, float divisor) {
        return IMPLEMENTATION.ceilMod(dividend, divisor);
    }
    public static float IEEEremainder(float dividend, float divisor) {
        return IMPLEMENTATION.IEEEremainder(dividend, divisor);
    }
    public static float hypot(float a, float b) {
        return IMPLEMENTATION.hypot(a, b);
    }
    public static float copySign(float magnitude, float sign) {
        return IMPLEMENTATION.copySign(magnitude, sign);
    }
    public static float nextAfter(float start, float direction) {
        return IMPLEMENTATION.nextAfter(start, direction);
    }
    public static float nextAfter(float start, double direction) {
        return IMPLEMENTATION.nextAfter(start, direction);
    }
    public static float fma(float multiplicand, float multiplier, float addend) {
        return IMPLEMENTATION.fma(multiplicand, multiplier, addend);
    }
    public static float ffma(float multiplicand, float multiplier, float addend) {
        return IMPLEMENTATION.ffma(multiplicand, multiplier, addend);
    }
    public static float scaleB(float multiplicand, int exponent) {
        return IMPLEMENTATION.scaleB(multiplicand, exponent);
    }
    public static int compare(float a, float b) {
        return IMPLEMENTATION.compare(a, b);
    }
    public static int compareSign(float a, float b) {
        return IMPLEMENTATION.compareSign(a, b);
    }
    public static int compare(float a, float b, float epsilon) {
        return IMPLEMENTATION.compare(a, b, epsilon);
    }
    public static float max(float a, float b) {
        return IMPLEMENTATION.max(a, b);
    }
    public static float max(float a, float b, float c) {
        return IMPLEMENTATION.max(a, b, c);
    }
    public static float min(float a, float b) {
        return IMPLEMENTATION.min(a, b);
    }
    public static float min(float a, float b, float c) {
        return IMPLEMENTATION.min(a, b, c);
    }
    public static float clamp(float value, float min, float max) {
        return IMPLEMENTATION.clamp(value, min, max);
    }
    public static boolean equals(float a, float b, float epsilon) {
        return IMPLEMENTATION.equals(a, b, epsilon);
    }
    public static float normalize(float value, float min, float max) {
        return IMPLEMENTATION.normalize(value, min, max);
    }
    public static float saturate(float value) {
        return IMPLEMENTATION.saturate(value);
    }
    public static float sign(float value) {
        return IMPLEMENTATION.sign(value);
    }
    public static int getExponent(float value) {
        return IMPLEMENTATION.getExponent(value);
    }
    public static boolean isFinite(float value) {
        return IMPLEMENTATION.isFinite(value);
    }
    public static boolean isInfinite(float value) {
        return IMPLEMENTATION.isInfinite(value);
    }
    public static boolean isNaN(float value) {
        return IMPLEMENTATION.isNaN(value);
    }
    public static boolean isInteger(float value) {
        return IMPLEMENTATION.isInteger(value);
    }
    public static boolean absEqualsOne(float value) {
        return IMPLEMENTATION.absEqualsOne(value);
    }
    public static int toIntBits(float value) {
        return IMPLEMENTATION.toIntBits(value);
    }
    public static int toRawIntBits(float value) {
        return IMPLEMENTATION.toRawIntBits(value);
    }

}
