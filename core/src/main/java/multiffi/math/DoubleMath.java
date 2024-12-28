package multiffi.math;

import multiffi.math.spi.MathProvider;

import java.math.RoundingMode;

public final class DoubleMath {

    private DoubleMath() {
        throw new AssertionError("No multiffi.math.DoubleMath instances for you!");
    }

    private static final MathProvider IMPLEMENTATION = MathProvider.getImplementation();

    public static final double E = Math.E;
    public static final double PI = Math.PI;
    public static final double PI_HALF = Math.PI * 0.5;
    public static final double PI_QUARTER = Math.PI * 0.25;
    public static final double TAU = 2.0 * Math.PI;
    public static final double LN10 = Math.log(10);
    public static final double LN2 = Math.log(2);
    public static final double LOG10E = Math.log10(Math.E);
    public static final double LOG2E = Math.log(Math.E) / LN2;
    public static final double SQRT2 = Math.sqrt(2);
    public static final double SQRT1_2 = Math.sqrt(0.5);

    public static final double POSITIVE_MIN_VALUE = Double.MIN_VALUE;
    public static final double POSITIVE_MAX_VALUE = Double.MAX_VALUE;
    public static final double NEGATIVE_MIN_VALUE = -Double.MAX_VALUE;
    public static final double NEGATIVE_MAX_VALUE = -Double.MIN_VALUE;
    public static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    public static final double NEGATIVE_INFINITY = Double.NEGATIVE_INFINITY;
    public static final double MIN_NORMAL = Double.MIN_NORMAL;
    public static final double MAX_SUBNORMAL = 0x0.fffffffffffffp-1022;
    public static final int MAX_EXPONENT = Double.MAX_EXPONENT;
    public static final int MIN_EXPONENT = Double.MIN_EXPONENT;
    
    public static double toRadians(double degrees) {
        return IMPLEMENTATION.toRadians(degrees);
    }
    public static double toDegrees(double radians) {
        return IMPLEMENTATION.toDegrees(radians);
    }
    public static double sin(double angle) {
        return IMPLEMENTATION.sin(angle);
    }
    public static double cos(double angle) {
        return IMPLEMENTATION.cos(angle);
    }
    public static double tan(double angle) {
        return IMPLEMENTATION.tan(angle);
    }
    public static double sinCos(double cosSin, double angle) {
        return IMPLEMENTATION.sinCos(cosSin, angle);
    }
    public static double asin(double angle) {
        return IMPLEMENTATION.asin(angle);
    }
    public static double acos(double angle) {
        return IMPLEMENTATION.acos(angle);
    }
    public static double atan(double angle) {
        return IMPLEMENTATION.atan(angle);
    }
    public static double safeAsin(double angle) {
        return IMPLEMENTATION.safeAsin(angle);
    }
    public static double safeAcos(double angle) {
        return IMPLEMENTATION.safeAcos(angle);
    }
    public static double atan2(double y, double x) {
        return IMPLEMENTATION.atan2(y, x);
    }
    public static double sinh(double angle) {
        return IMPLEMENTATION.sinh(angle);
    }
    public static double cosh(double angle) {
        return IMPLEMENTATION.cosh(angle);
    }
    public static double tanh(double angle) {
        return IMPLEMENTATION.tanh(angle);
    }
    public static double asinh(double angle) {
        return IMPLEMENTATION.asinh(angle);
    }
    public static double acosh(double angle) {
        return IMPLEMENTATION.acosh(angle);
    }
    public static double atanh(double angle) {
        return IMPLEMENTATION.atanh(angle);
    }
    public static double pow(double base, double exponent) {
        return IMPLEMENTATION.pow(base, exponent);
    }
    public static double square(double base) {
        return IMPLEMENTATION.square(base);
    }
    public static double cube(double base) {
        return IMPLEMENTATION.cube(base);
    }
    public static double exp(double exponent) {
        return IMPLEMENTATION.exp(exponent);
    }
    public static double expm1(double exponent) {
        return IMPLEMENTATION.expm1(exponent);
    }
    public static double log(double base, double power) {
        return IMPLEMENTATION.log(base, power);
    }
    public static double log(double power) {
        return IMPLEMENTATION.log(power);
    }
    public static double log10(double power) {
        return IMPLEMENTATION.log10(power);
    }
    public static double log2(double power) {
        return IMPLEMENTATION.log2(power);
    }
    public static double log1p(double power) {
        return IMPLEMENTATION.log1p(power);
    }
    public static double root(double exponent, double power) {
        return IMPLEMENTATION.root(exponent, power);
    }
    public static double invroot(double exponent, double power) {
        return IMPLEMENTATION.invroot(exponent, power);
    }
    public static double sqrt(double power) {
        return IMPLEMENTATION.sqrt(power);
    }
    public static double cbrt(double power) {
        return IMPLEMENTATION.cbrt(power);
    }
    public static double invsqrt(double power) {
        return IMPLEMENTATION.invsqrt(power);
    }
    public static double invcbrt(double power) {
        return IMPLEMENTATION.invcbrt(power);
    }
    public static double up(double value) {
        return IMPLEMENTATION.up(value);
    }
    public static double down(double value) {
        return IMPLEMENTATION.down(value);
    }
    public static double ceiling(double value) {
        return IMPLEMENTATION.ceiling(value);
    }
    public static double floor(double value) {
        return IMPLEMENTATION.floor(value);
    }
    public static double halfUp(double value) {
        return IMPLEMENTATION.halfUp(value);
    }
    public static double halfDown(double value) {
        return IMPLEMENTATION.halfDown(value);
    }
    public static double halfEven(double value) {
        return IMPLEMENTATION.halfEven(value);
    }
    public static double trunc(double value) {
        return IMPLEMENTATION.trunc(value);
    }
    public static double truncExact(double value) {
        return IMPLEMENTATION.truncExact(value);
    }
    public static double round(double value) {
        return IMPLEMENTATION.round(value);
    }
    public static long roundToLong(double value) {
        return IMPLEMENTATION.roundToLong(value);
    }
    public static double round(double value, RoundingMode mode) {
        return IMPLEMENTATION.round(value, mode);
    }
    public static double abs(double value) {
        return IMPLEMENTATION.abs(value);
    }
    public static double negate(double value) {
        return IMPLEMENTATION.negate(value);
    }
    public static double ulp(double start) {
        return IMPLEMENTATION.ulp(start);
    }
    public static double nextUp(double start) {
        return IMPLEMENTATION.nextUp(start);
    }
    public static double nextDown(double start) {
        return IMPLEMENTATION.nextDown(start);
    }
    public static double reciprocalEstimate(double value) {
        return IMPLEMENTATION.reciprocalEstimate(value);
    }
    public static double reciprocalSqrtEstimate(double value) {
        return IMPLEMENTATION.reciprocalSqrtEstimate(value);
    }
    public static double reciprocalCbrtEstimate(double value) {
        return IMPLEMENTATION.reciprocalCbrtEstimate(value);
    }
    public static double increment(double value) {
        return IMPLEMENTATION.increment(value);
    }
    public static double decrement(double value) {
        return IMPLEMENTATION.decrement(value);
    }
    public static double add(double augend, double addend) {
        return IMPLEMENTATION.add(augend, addend);
    }
    public static double subtract(double minuend, double subtrahend) {
        return IMPLEMENTATION.subtract(minuend, subtrahend);
    }
    public static double multiply(double multiplicand, double multiplier) {
        return IMPLEMENTATION.multiply(multiplicand, multiplier);
    }
    public static double divide(double dividend, double divisor) {
        return IMPLEMENTATION.divide(dividend, divisor);
    }
    public static double remainder(double dividend, double divisor) {
        return IMPLEMENTATION.remainder(dividend, divisor);
    }
    public static double floorDiv(double dividend, double divisor) {
        return IMPLEMENTATION.floorDiv(dividend, divisor);
    }
    public static double floorMod(double dividend, double divisor) {
        return IMPLEMENTATION.floorMod(dividend, divisor);
    }
    public static double ceilDiv(double dividend, double divisor) {
        return IMPLEMENTATION.ceilDiv(dividend, divisor);
    }
    public static double ceilMod(double dividend, double divisor) {
        return IMPLEMENTATION.ceilMod(dividend, divisor);
    }
    public static double IEEEremainder(double dividend, double divisor) {
        return IMPLEMENTATION.IEEEremainder(dividend, divisor);
    }
    public static double hypot(double a, double b) {
        return IMPLEMENTATION.hypot(a, b);
    }
    public static double copySign(double magnitude, double sign) {
        return IMPLEMENTATION.copySign(magnitude, sign);
    }
    public static double nextAfter(double start, double direction) {
        return IMPLEMENTATION.nextAfter(start, direction);
    }
    public static double fma(double multiplicand, double multiplier, double addend) {
        return IMPLEMENTATION.fma(multiplicand, multiplier, addend);
    }
    public static double ffma(double multiplicand, double multiplier, double addend) {
        return IMPLEMENTATION.ffma(multiplicand, multiplier, addend);
    }
    public static double scaleB(double multiplicand, int exponent) {
        return IMPLEMENTATION.scaleB(multiplicand, exponent);
    }
    public static int compare(double a, double b) {
        return IMPLEMENTATION.compare(a, b);
    }
    public static int compareSign(double a, double b) {
        return IMPLEMENTATION.compareSign(a, b);
    }
    public static int compare(double a, double b, double epsilon) {
        return IMPLEMENTATION.compare(a, b, epsilon);
    }
    public static double max(double a, double b) {
        return IMPLEMENTATION.max(a, b);
    }
    public static double max(double a, double b, double c) {
        return IMPLEMENTATION.max(a, b, c);
    }
    public static double min(double a, double b) {
        return IMPLEMENTATION.min(a, b);
    }
    public static double min(double a, double b, double c) {
        return IMPLEMENTATION.min(a, b, c);
    }
    public static double clamp(double value, double min, double max) {
        return IMPLEMENTATION.clamp(value, min, max);
    }
    public static boolean equals(double a, double b, double epsilon) {
        return IMPLEMENTATION.equals(a, b, epsilon);
    }
    public static double normalize(double value, double min, double max) {
        return IMPLEMENTATION.normalize(value, min, max);
    }
    public static double saturate(double value) {
        return IMPLEMENTATION.saturate(value);
    }
    public static double sign(double value) {
        return IMPLEMENTATION.sign(value);
    }
    public static int getExponent(double value) {
        return IMPLEMENTATION.getExponent(value);
    }
    public static boolean isFinite(double value) {
        return IMPLEMENTATION.isFinite(value);
    }
    public static boolean isInfinite(double value) {
        return IMPLEMENTATION.isInfinite(value);
    }
    public static boolean isNaN(double value) {
        return IMPLEMENTATION.isNaN(value);
    }
    public static boolean isInteger(double value) {
        return IMPLEMENTATION.isInteger(value);
    }
    public static boolean absEqualsOne(double value) {
        return IMPLEMENTATION.absEqualsOne(value);
    }
    public static float toFloat(double value) {
        return IMPLEMENTATION.toFloat(value);
    }
    public static float toFloatExact(double value) {
        return IMPLEMENTATION.toFloatExact(value);
    }
    public static long toLongBits(double value) {
        return IMPLEMENTATION.toLongBits(value);
    }
    public static long toRawLongBits(double value) {
        return IMPLEMENTATION.toRawLongBits(value);
    }

}
