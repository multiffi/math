package io.github.multiffi.math;

import multiffi.math.spi.MathProvider;

import java.math.BigDecimal;

public class AndroidMathProvider extends MathProvider {

    @Override
    public float toRadians(float degrees) {
        return (float) Math.toRadians(degrees);
    }

    @Override
    public double toRadians(double degrees) {
        return Math.toRadians(degrees);
    }

    @Override
    public float toDegrees(float radians) {
        return (float) Math.toDegrees(radians);
    }

    @Override
    public double toDegrees(double radians) {
        return Math.toDegrees(radians);
    }

    @Override
    public float sin(float angle) {
        return (float) Math.sin(angle);
    }

    @Override
    public double sin(double angle) {
        return Math.sin(angle);
    }

    @Override
    public float cos(float angle) {
        return (float) Math.cos(angle);
    }

    @Override
    public double cos(double angle) {
        return Math.cos(angle);
    }

    @Override
    public float tan(float angle) {
        return (float) Math.tan(angle);
    }

    @Override
    public double tan(double angle) {
        return Math.tan(angle);
    }

    private static final class SinCos {
        private SinCos() {
            throw new UnsupportedOperationException();
        }
        private static final double PI_HALF = Math.PI * 0.5;
        private static final double TAU = 2.0 * Math.PI;
        public static double compute(double cosSin, double angle) {
            // sin(x)^2 + cos(x)^2 = 1
            double sinCos = Math.sqrt(1.0 - cosSin * cosSin);
            double a = angle + PI_HALF;
            double b = a - (int) (a / TAU) * TAU;
            if (b < 0.0) b = TAU + b;
            if (b >= Math.PI) return -sinCos;
            return sinCos;
        }
    }

    @Override
    public float sinCos(float cosSin, float angle) {
        return (float) SinCos.compute(cosSin, angle);
    }

    @Override
    public double sinCos(double cosSin, double angle) {
        return SinCos.compute(cosSin, angle);
    }

    @Override
    public float asin(float angle) {
        return (float) Math.asin(angle);
    }

    @Override
    public double asin(double angle) {
        return Math.asin(angle);
    }

    @Override
    public float acos(float angle) {
        return (float) Math.acos(angle);
    }

    @Override
    public double acos(double angle) {
        return Math.acos(angle);
    }

    @Override
    public float atan(float angle) {
        return (float) Math.atan(angle);
    }

    @Override
    public double atan(double angle) {
        return Math.atan(angle);
    }

    private static final class SafeAsin {
        private SafeAsin() {
            throw new UnsupportedOperationException();
        }
        private static final double PI_HALF = Math.PI * 0.5;
        public static double compute(double angle) {
            return angle <= -1.0 ? -PI_HALF : angle >= 1.0 ? PI_HALF : Math.asin(angle);
        }
    }

    @Override
    public float safeAsin(float angle) {
        return (float) SafeAsin.compute(angle);
    }

    @Override
    public double safeAsin(double angle) {
        return SafeAsin.compute(angle);
    }

    private static final class SafeAcos {
        private SafeAcos() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double angle) {
            if (angle < -1.0) return Math.PI;
            else if (angle > 1.0) return 0.0;
            else return Math.acos(angle);
        }
    }

    @Override
    public float safeAcos(float angle) {
        return (float) SafeAcos.compute(angle);
    }

    @Override
    public double safeAcos(double angle) {
        return SafeAcos.compute(angle);
    }

    @Override
    public float atan2(float y, float x) {
        return (float) Math.atan2(y, x);
    }

    @Override
    public double atan2(double y, double x) {
        return Math.atan2(y, x);
    }

    @Override
    public float sinh(float angle) {
        return (float) Math.sinh(angle);
    }

    @Override
    public double sinh(double angle) {
        return Math.sin(angle);
    }

    @Override
    public float cosh(float angle) {
        return (float) Math.cosh(angle);
    }

    @Override
    public double cosh(double angle) {
        return Math.cosh(angle);
    }

    @Override
    public float tanh(float angle) {
        return (float) Math.tanh(angle);
    }

    @Override
    public double tanh(double angle) {
        return Math.tanh(angle);
    }

    private static final class Asinh {
        private Asinh() {
            throw new UnsupportedOperationException();
        }
        private static final double F_1_3 = 1d / 3d;
        private static final double F_1_5 = 1d / 5d;
        private static final double F_1_7 = 1d / 7d;
        private static final double F_1_9 = 1d / 9d;
        private static final double F_1_11 = 1d / 11d;
        private static final double F_1_13 = 1d / 13d;
        private static final double F_1_15 = 1d / 15d;
        private static final double F_1_17 = 1d / 17d;
        private static final double F_3_4 = 3d / 4d;
        private static final double F_15_16 = 15d / 16d;
        private static final double F_13_14 = 13d / 14d;
        private static final double F_11_12 = 11d / 12d;
        private static final double F_9_10 = 9d / 10d;
        private static final double F_7_8 = 7d / 8d;
        private static final double F_5_6 = 5d / 6d;
        private static final double F_1_2 = 1d / 2d;
        public static double compute(double angle) {
            boolean negative = false;
            if (angle < 0) {
                negative = true;
                angle = -angle;
            }
            double absAsinh;
            if (angle > 0.167) absAsinh = Math.log(Math.sqrt(angle * angle + 1) + angle);
            else {
                final double a2 = angle * angle;
                if (angle > 0.097) absAsinh = angle * (1 - a2 * (F_1_3 - a2 * (F_1_5 - a2 * (F_1_7 - a2 * (F_1_9 - a2 * (F_1_11 - a2 * (F_1_13 - a2 * (F_1_15 - a2 * F_1_17 * F_15_16) * F_13_14) * F_11_12) * F_9_10) * F_7_8) * F_5_6) * F_3_4) * F_1_2);
                else if (angle > 0.036) absAsinh = angle * (1 - a2 * (F_1_3 - a2 * (F_1_5 - a2 * (F_1_7 - a2 * (F_1_9 - a2 * (F_1_11 - a2 * F_1_13 * F_11_12) * F_9_10) * F_7_8) * F_5_6) * F_3_4) * F_1_2);
                else if (angle > 0.0036) absAsinh = angle * (1 - a2 * (F_1_3 - a2 * (F_1_5 - a2 * (F_1_7 - a2 * F_1_9 * F_7_8) * F_5_6) * F_3_4) * F_1_2);
                else absAsinh = angle * (1 - a2 * (F_1_3 - a2 * F_1_5 * F_3_4) * F_1_2);
            }
            return negative ? -absAsinh : absAsinh;
        }
    }

    @Override
    public float asinh(float angle) {
        return (float) Asinh.compute(angle);
    }

    @Override
    public double asinh(double angle) {
        return Asinh.compute(angle);
    }

    private static final class Acosh {
        private Acosh() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double angle) {
            return Math.log(angle + Math.sqrt(angle * angle - 1));
        }
    }

    @Override
    public float acosh(float angle) {
        return (float) Acosh.compute(angle);
    }

    @Override
    public double acosh(double angle) {
        return Acosh.compute(angle);
    }

    private static final class Atanh {
        private Atanh() {
            throw new UnsupportedOperationException();
        }
        private static final double F_1_3 = 1d / 3d;
        private static final double F_1_5 = 1d / 5d;
        private static final double F_1_7 = 1d / 7d;
        private static final double F_1_9 = 1d / 9d;
        private static final double F_1_11 = 1d / 11d;
        private static final double F_1_13 = 1d / 13d;
        private static final double F_1_15 = 1d / 15d;
        private static final double F_1_17 = 1d / 17d;
        public static double compute(double angle) {
            boolean negative = false;
            if (angle < 0) {
                negative = true;
                angle = -angle;
            }
            double absAtanh;
            if (angle > 0.15) absAtanh = 0.5 * Math.log((1 + angle) / (1 - angle));
            else {
                final double a2 = angle * angle;
                if (angle > 0.087) absAtanh = angle * (1 + a2 * (F_1_3 + a2 * (F_1_5 + a2 * (F_1_7 + a2 * (F_1_9 + a2 * (F_1_11 + a2 * (F_1_13 + a2 * (F_1_15 + a2 * F_1_17))))))));
                else if (angle > 0.031) absAtanh = angle * (1 + a2 * (F_1_3 + a2 * (F_1_5 + a2 * (F_1_7 + a2 * (F_1_9 + a2 * (F_1_11 + a2 * F_1_13))))));
                else if (angle > 0.003) absAtanh = angle * (1 + a2 * (F_1_3 + a2 * (F_1_5 + a2 * (F_1_7 + a2 * F_1_9))));
                else absAtanh = angle * (1 + a2 * (F_1_3 + a2 * F_1_5));
            }
            return negative ? -absAtanh : absAtanh;
        }
    }

    @Override
    public float atanh(float angle) {
        return (float) Atanh.compute(angle);
    }

    @Override
    public double atanh(double angle) {
        return Atanh.compute(angle);
    }

    @Override
    public float pow(float base, float exponent) {
        return (float) Math.pow(base, exponent);
    }

    @Override
    public double pow(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    private static final class Square {
        private Square() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double base) {
            return base * base;
        }
    }

    @Override
    public float square(float base) {
        return (float) Square.compute(base);
    }

    @Override
    public double square(double base) {
        return Square.compute(base);
    }

    private static final class Cube {
        private Cube() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double base) {
            return base * base * base;
        }
    }

    @Override
    public float cube(float base) {
        return (float) Cube.compute(base);
    }

    @Override
    public double cube(double base) {
        return Cube.compute(base);
    }

    @Override
    public float exp(float exponent) {
        return (float) Math.exp(exponent);
    }

    @Override
    public double exp(double exponent) {
        return Math.exp(exponent);
    }

    @Override
    public float expm1(float exponent) {
        return (float) Math.expm1(exponent);
    }

    @Override
    public double expm1(double exponent) {
        return Math.expm1(exponent);
    }

    private static final class Log {
        private Log() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double base, double power) {
            return Math.log(power) / Math.log(base);
        }
    }

    @Override
    public float log(float base, float power) {
        return (float) Log.compute(base, power);
    }

    @Override
    public double log(double base, double power) {
        return Log.compute(base, power);
    }

    @Override
    public float log(float power) {
        return (float) Math.log(power);
    }

    @Override
    public double log(double power) {
        return Math.log(power);
    }

    @Override
    public float log10(float power) {
        return (float) Math.log10(power);
    }

    @Override
    public double log10(double power) {
        return Math.log10(power);
    }

    private static final class Log2 {
        private Log2() {
            throw new UnsupportedOperationException();
        }
        private static final double LN2 = Math.log(2);
        public static double compute(double power) {
            return Math.log(power) / LN2;
        }
    }

    @Override
    public float log2(float power) {
        return (float) Log2.compute(power);
    }

    @Override
    public double log2(double power) {
        return Log2.compute(power);
    }

    @Override
    public float log1p(float power) {
        return (float) Math.log1p(power);
    }

    @Override
    public double log1p(double power) {
        return Math.log1p(power);
    }

    private static final class Root {
        private Root() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double exponent, double power) {
            return Math.pow(exponent, 1d / power);
        }
    }

    @Override
    public float root(float exponent, float power) {
        return (float) Root.compute(exponent, power);
    }

    @Override
    public double root(double exponent, double power) {
        return Root.compute(exponent, power);
    }

    private static final class InvRoot {
        private InvRoot() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double exponent, double power) {
            return 1d / Math.pow(exponent, 1d / power);
        }
    }

    @Override
    public float invroot(float exponent, float power) {
        return (float) InvRoot.compute(exponent, power);
    }

    @Override
    public double invroot(double exponent, double power) {
        return InvRoot.compute(exponent, power);
    }

    @Override
    public float sqrt(float power) {
        return (float) Math.sqrt(power);
    }

    @Override
    public double sqrt(double power) {
        return Math.sqrt(power);
    }

    @Override
    public float cbrt(float power) {
        return (float) Math.cbrt(power);
    }

    @Override
    public double cbrt(double power) {
        return Math.cbrt(power);
    }

    private static final class InvSqrt {
        private InvSqrt() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double power) {
            return 1d / Math.sqrt(power);
        }
    }

    @Override
    public float invsqrt(float power) {
        return (float) InvSqrt.compute(power);
    }

    @Override
    public double invsqrt(double power) {
        return InvSqrt.compute(power);
    }

    private static final class InvCbrt {
        private InvCbrt() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double power) {
            return 1d / Math.cbrt(power);
        }
    }

    @Override
    public float invcbrt(float power) {
        return (float) InvCbrt.compute(power);
    }

    @Override
    public double invcbrt(double power) {
        return InvCbrt.compute(power);
    }

    private static final class Up {
        private Up() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double value) {
            return value > 0 ? Math.floor(value) : Math.ceil(value);
        }
    }

    @Override
    public float up(float value) {
        return (float) Up.compute(value);
    }

    @Override
    public double up(double value) {
        return Up.compute(value);
    }

    private static final class Down {
        private Down() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double value) {
            return value > 0 ? Math.ceil(value) : Math.floor(value);
        }
    }

    @Override
    public float down(float value) {
        return (float) Down.compute(value);
    }

    @Override
    public double down(double value) {
        return Down.compute(value);
    }

    @Override
    public float ceiling(float value) {
        return (float) Math.ceil(value);
    }

    @Override
    public double ceiling(double value) {
        return Math.ceil(value);
    }

    @Override
    public float floor(float value) {
        return (float) Math.floor(value);
    }

    @Override
    public double floor(double value) {
        return Math.floor(value);
    }

    private static final class HalfUp {
        private HalfUp() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double value) {
            return value > 0 ? Math.floor(value + 0.5d) : Math.ceil(value - 0.5d);
        }
    }

    @Override
    public float halfUp(float value) {
        return (float) HalfUp.compute(value);
    }

    @Override
    public double halfUp(double value) {
        return HalfUp.compute(value);
    }

    private static final class HalfDown {
        private HalfDown() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double value) {
            return value > 0 ? Math.ceil(value - 0.5d) : Math.floor(value + 0.5d);
        }
    }

    @Override
    public float halfDown(float value) {
        return (float) HalfDown.compute(value);
    }

    @Override
    public double halfDown(double value) {
        return HalfDown.compute(value);
    }

    @Override
    public float halfEven(float value) {
        return (float) Math.rint(value);
    }

    @Override
    public double halfEven(double value) {
        return Math.rint(value);
    }

    @Override
    public float trunc(float value) {
        return value % 1 == 0 ? value : (int) value;
    }

    @Override
    public double trunc(double value) {
        return value % 1 == 0 ? value : (long) value;
    }

    @Override
    public float truncExact(float value) {
        if (value <= Integer.MAX_VALUE && value >= Integer.MIN_VALUE && value % 1 == 0) return value;
        else throw new ArithmeticException("Rounding necessary");
    }

    @Override
    public double truncExact(double value) {
        if (value <= Long.MAX_VALUE && value >= Long.MIN_VALUE && value % 1 == 0) return value;
        else throw new ArithmeticException("Rounding necessary");
    }

    @Override
    public float round(float value) {
        return value % 1 == 0 ? value : Math.round(value);
    }

    @Override
    public double round(double value) {
        return value % 1 == 0 ? value : Math.round(value);
    }

    @Override
    public int roundToInt(float value) {
        return Math.round(value);
    }

    @Override
    public long roundToLong(double value) {
        return Math.round(value);
    }

    @Override
    public byte abs(byte value) {
        return (byte) Math.abs(value);
    }

    @Override
    public short abs(short value) {
        return (short) Math.abs(value);
    }

    @Override
    public int abs(int value) {
        return Math.abs(value);
    }

    @Override
    public long abs(long value) {
        return Math.abs(value);
    }

    @Override
    public float abs(float value) {
        return Math.abs(value);
    }

    @Override
    public double abs(double value) {
        return Math.abs(value);
    }

    @Override
    public byte negate(byte value) {
        return (byte) -value;
    }

    @Override
    public short negate(short value) {
        return (short) -value;
    }

    @Override
    public int negate(int value) {
        return -value;
    }

    @Override
    public long negate(long value) {
        return -value;
    }

    @Override
    public float negate(float value) {
        return -value;
    }

    @Override
    public double negate(double value) {
        return -value;
    }

    @Override
    public float ulp(float start) {
        return Math.ulp(start);
    }

    @Override
    public double ulp(double start) {
        return Math.ulp(start);
    }

    @Override
    public float nextUp(float start) {
        return Math.nextUp(start);
    }

    @Override
    public double nextUp(double start) {
        return Math.nextUp(start);
    }

    @Override
    public float nextDown(float start) {
        return Math.nextDown(start);
    }

    @Override
    public double nextDown(double start) {
        return Math.nextDown(start);
    }

    private static final class ReciprocalEstimate {
        private ReciprocalEstimate() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double value) {
            return 1d / value;
        }
    }

    @Override
    public float reciprocalEstimate(float value) {
        return (float) ReciprocalEstimate.compute(value);
    }

    @Override
    public double reciprocalEstimate(double value) {
        return ReciprocalEstimate.compute(value);
    }

    private static final class ReciprocalSqrtEstimate {
        private ReciprocalSqrtEstimate() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double value) {
            return 1d / Math.sqrt(value);
        }
    }

    @Override
    public float reciprocalSqrtEstimate(float value) {
        return (float) ReciprocalSqrtEstimate.compute(value);
    }

    @Override
    public double reciprocalSqrtEstimate(double value) {
        return ReciprocalSqrtEstimate.compute(value);
    }

    private static final class ReciprocalCbrtEstimate {
        private ReciprocalCbrtEstimate() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double value) {
            return 1d / Math.cbrt(value);
        }
    }

    @Override
    public float reciprocalCbrtEstimate(float value) {
        return (float) ReciprocalCbrtEstimate.compute(value);
    }

    @Override
    public double reciprocalCbrtEstimate(double value) {
        return ReciprocalCbrtEstimate.compute(value);
    }

    @Override
    public byte reverse(byte value) {
        return (byte) (Integer.reverse(value) >>> 24);
    }

    @Override
    public short reverseBytes(short value) {
        return Short.reverseBytes(value);
    }

    @Override
    public short reverse(short value) {
        return (short) (Integer.reverse(value) >>> 16);
    }

    @Override
    public int reverseBytes(int value) {
        return Integer.reverseBytes(value);
    }

    @Override
    public int reverse(int value) {
        return Integer.reverse(value);
    }

    @Override
    public long reverseBytes(long value) {
        return Long.reverseBytes(value);
    }

    @Override
    public long reverse(long value) {
        return Long.reverse(value);
    }

    @Override
    public byte highestOneBit(byte value) {
        return value < 0 ? -1 : (byte) Integer.highestOneBit(value);
    }

    @Override
    public short highestOneBit(short value) {
        return value < 0 ? -1 : (short) Integer.highestOneBit(value);
    }

    @Override
    public int highestOneBit(int value) {
        return Integer.highestOneBit(value);
    }

    @Override
    public long highestOneBit(long value) {
        return Long.highestOneBit(value);
    }

    @Override
    public byte lowestOneBit(byte value) {
        return value == -1 ? 1 : (byte) Integer.lowestOneBit(value | 0xFFFFFF00);
    }

    @Override
    public short lowestOneBit(short value) {
        return value == -1 ? 1 : (short) Integer.lowestOneBit(value | 0xFFFF0000);
    }

    @Override
    public int lowestOneBit(int value) {
        return Integer.lowestOneBit(value);
    }

    @Override
    public long lowestOneBit(long value) {
        return Long.lowestOneBit(value);
    }

    @Override
    public byte increment(byte value) {
        return (byte) (value + 1);
    }

    @Override
    public short increment(short value) {
        return (short) (value + 1);
    }

    @Override
    public int increment(int value) {
        return value + 1;
    }

    @Override
    public long increment(long value) {
        return value + 1L;
    }

    @Override
    public float increment(float value) {
        return value + 1f;
    }

    @Override
    public double increment(double value) {
        return value + 1d;
    }

    @Override
    public byte decrement(byte value) {
        return (byte) (value - 1);
    }

    @Override
    public short decrement(short value) {
        return (short) (value - 1);
    }

    @Override
    public int decrement(int value) {
        return value - 1;
    }

    @Override
    public long decrement(long value) {
        return value - 1L;
    }

    @Override
    public float decrement(float value) {
        return value - 1f;
    }

    @Override
    public double decrement(double value) {
        return value - 1d;
    }

    private static final class NearestPowerOfTwo {
        private NearestPowerOfTwo() {
            throw new UnsupportedOperationException();
        }
        public static int compute(int start) {
            if (start <= 0) return 0;
            start --;
            start |= start >>> 1;
            start |= start >>> 2;
            start |= start >>> 4;
            start |= start >>> 8;
            start |= start >>> 16;
            start ++;
            return start < 0 ? start >>> 1 : start;
        }
        public static long compute(long start) {
            if (start <= 0) return 0;
            long i = Long.highestOneBit(start);
            start = start > i ? i << 1 : i;
            return start < 0 ? start >>> 1 : start;
        }
    }

    @Override
    public byte nearestPowerOfTwo(byte start) {
        return start >= 64 ? 64 : (byte) NearestPowerOfTwo.compute(start);
    }

    @Override
    public short nearestPowerOfTwo(short start) {
        return start >= 16384 ? 16384 : (short) NearestPowerOfTwo.compute(start);
    }

    @Override
    public int nearestPowerOfTwo(int start) {
        return NearestPowerOfTwo.compute(start);
    }

    @Override
    public long nearestPowerOfTwo(long start) {
        return NearestPowerOfTwo.compute(start);
    }

    @Override
    public byte unsignedNearestPowerOfTwo(byte start) {
        return start < 0 ? -1 : (byte) NearestPowerOfTwo.compute(start);
    }

    @Override
    public short unsignedNearestPowerOfTwo(short start) {
        return start < 0 ? -1 : (short) NearestPowerOfTwo.compute(start);
    }

    @Override
    public int unsignedNearestPowerOfTwo(int start) {
        return start < 0 ? -1 : NearestPowerOfTwo.compute(start);
    }

    @Override
    public long unsignedNearestPowerOfTwo(long start) {
        return start < 0 ? -1L : NearestPowerOfTwo.compute(start);
    }

    @Override
    public byte absExact(byte value) {
        if (value == Byte.MIN_VALUE) throw new ArithmeticException("Overflow to represent absolute value of Byte.MIN_VALUE");
        else return (byte) Math.abs(value);
    }

    @Override
    public short absExact(short value) {
        if (value == Short.MIN_VALUE) throw new ArithmeticException("Overflow to represent absolute value of Short.MIN_VALUE");
        else return (short) Math.abs(value);
    }

    @Override
    public int absExact(int value) {
        if (value == Integer.MIN_VALUE) throw new ArithmeticException("Overflow to represent absolute value of Integer.MIN_VALUE");
        else return Math.abs(value);
    }

    @Override
    public long absExact(long value) {
        if (value == Long.MIN_VALUE) throw new ArithmeticException("Overflow to represent absolute value of Long.MIN_VALUE");
        else return Math.abs(value);
    }

    @Override
    public byte negateExact(byte value) {
        if (value == Byte.MIN_VALUE) throw new ArithmeticException("byte overflow");
        else return (byte) -value;
    }

    @Override
    public short negateExact(short value) {
        if (value == Short.MIN_VALUE) throw new ArithmeticException("short overflow");
        else return (short) -value;
    }

    @Override
    public int negateExact(int value) {
        return Math.negateExact(value);
    }

    @Override
    public long negateExact(long value) {
        return Math.negateExact(value);
    }

    @Override
    public byte incrementExact(byte value) {
        if (value == Byte.MAX_VALUE) throw new ArithmeticException("byte overflow");
        else return (byte) (value + 1);
    }

    @Override
    public short incrementExact(short value) {
        if (value == Short.MAX_VALUE) throw new ArithmeticException("short overflow");
        else return (short) (value + 1);
    }

    @Override
    public int incrementExact(int value) {
        return Math.incrementExact(value);
    }

    @Override
    public long incrementExact(long value) {
        return Math.incrementExact(value);
    }

    @Override
    public byte decrementExact(byte value) {
        if (value == Byte.MIN_VALUE) throw new ArithmeticException("byte overflow");
        else return (byte) (value - 1);
    }

    @Override
    public short decrementExact(short value) {
        if (value == Short.MIN_VALUE) throw new ArithmeticException("short overflow");
        else return (short) (value - 1);
    }

    @Override
    public int decrementExact(int value) {
        return Math.decrementExact(value);
    }

    @Override
    public long decrementExact(long value) {
        return Math.decrementExact(value);
    }

    @Override
    public byte unsignedIncrementExact(byte value) {
        if (value == -1) throw new ArithmeticException("byte overflow");
        else return (byte) (value + 1);
    }

    @Override
    public short unsignedIncrementExact(short value) {
        if (value == -1) throw new ArithmeticException("short overflow");
        else return (short) (value + 1);
    }

    @Override
    public int unsignedIncrementExact(int value) {
        if (value == -1) throw new ArithmeticException("integer overflow");
        else return value + 1;
    }

    @Override
    public long unsignedIncrementExact(long value) {
        if (value == -1L) throw new ArithmeticException("long overflow");
        else return value + 1L;
    }

    @Override
    public byte unsignedDecrementExact(byte value) {
        if (value == 0) throw new ArithmeticException("byte overflow");
        else return (byte) (value - 1);
    }

    @Override
    public short unsignedDecrementExact(short value) {
        if (value == 0) throw new ArithmeticException("short overflow");
        else return (short) (value - 1);
    }

    @Override
    public int unsignedDecrementExact(int value) {
        if (value == 0) throw new ArithmeticException("integer overflow");
        else return value - 1;
    }

    @Override
    public long unsignedDecrementExact(long value) {
        if (value == 0L) throw new ArithmeticException("long overflow");
        else return value - 1L;
    }

    @Override
    public byte add(byte augend, byte addend) {
        return (byte) (augend + addend);
    }

    @Override
    public short add(short augend, short addend) {
        return (short) (augend + addend);
    }

    @Override
    public int add(int augend, int addend) {
        return augend + addend;
    }

    @Override
    public long add(long augend, long addend) {
        return augend + addend;
    }

    @Override
    public float add(float augend, float addend) {
        return augend + addend;
    }

    @Override
    public double add(double augend, double addend) {
        return augend + addend;
    }

    @Override
    public byte subtract(byte minuend, byte subtrahend) {
        return (byte) (minuend - subtrahend);
    }

    @Override
    public short subtract(short minuend, short subtrahend) {
        return (short) (minuend - subtrahend);
    }

    @Override
    public int subtract(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    @Override
    public long subtract(long minuend, long subtrahend) {
        return minuend - subtrahend;
    }

    @Override
    public float subtract(float minuend, float subtrahend) {
        return minuend - subtrahend;
    }

    @Override
    public double subtract(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }

    @Override
    public byte multiply(byte multiplicand, byte multiplier) {
        return (byte) (multiplicand * multiplier);
    }

    @Override
    public short multiply(short multiplicand, short multiplier) {
        return (short) (multiplicand * multiplier);
    }

    @Override
    public int multiply(int multiplicand, int multiplier) {
        return multiplicand * multiplier;
    }

    @Override
    public long multiply(long multiplicand, long multiplier) {
        return multiplicand * multiplier;
    }

    @Override
    public float multiply(float multiplicand, float multiplier) {
        return multiplicand * multiplier;
    }

    @Override
    public double multiply(double multiplicand, double multiplier) {
        return multiplicand * multiplier;
    }

    @Override
    public byte divide(byte dividend, byte divisor) {
        return (byte) (dividend / divisor);
    }

    @Override
    public short divide(short dividend, short divisor) {
        return (short) (dividend / divisor);
    }

    @Override
    public int divide(int dividend, int divisor) {
        return dividend / divisor;
    }

    @Override
    public long divide(long dividend, long divisor) {
        return dividend / divisor;
    }

    @Override
    public float divide(float dividend, float divisor) {
        return dividend / divisor;
    }

    @Override
    public double divide(double dividend, double divisor) {
        return dividend / divisor;
    }

    @Override
    public byte remainder(byte dividend, byte divisor) {
        return (byte) (dividend % divisor);
    }

    @Override
    public short remainder(short dividend, short divisor) {
        return (short) (dividend % divisor);
    }

    @Override
    public int remainder(int dividend, int divisor) {
        return dividend % divisor;
    }

    @Override
    public long remainder(long dividend, long divisor) {
        return dividend % divisor;
    }

    @Override
    public float remainder(float dividend, float divisor) {
        return dividend % divisor;
    }

    @Override
    public double remainder(double dividend, double divisor) {
        return dividend % divisor;
    }

    private static final class IEEEremainder {
        private IEEEremainder() {
            throw new UnsupportedOperationException();
        }
        public static float compute(float dividend, float divisor) {
            return dividend - (divisor * Math.round(dividend / divisor));
        }
    }

    @Override
    public float IEEEremainder(float dividend, float divisor) {
        return IEEEremainder.compute(dividend, divisor);
    }

    @Override
    public double IEEEremainder(double dividend, double divisor) {
        return Math.IEEEremainder(dividend, divisor);
    }

    @Override
    public byte floorDiv(byte dividend, byte divisor) {
        return (byte) Math.floorDiv(dividend, dividend);
    }

    @Override
    public short floorDiv(short dividend, short divisor) {
        return (short) Math.floorDiv(dividend, divisor);
    }

    @Override
    public int floorDiv(int dividend, int divisor) {
        return Math.floorDiv(dividend, divisor);
    }

    @Override
    public long floorDiv(long dividend, long divisor) {
        return Math.floorDiv(dividend, divisor);
    }

    private static final class FloorDiv {
        private FloorDiv() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double dividend, double divisor) {
            final double q = dividend / divisor;
            // if the signs are different and modulo not zero, round down
            if ((Math.signum(dividend) != Math.signum(divisor)) && (dividend % divisor != 0)) return q - 1;
            return q;
        }
    }

    @Override
    public float floorDiv(float dividend, float divisor) {
        return (float) FloorDiv.compute(dividend, divisor);
    }

    @Override
    public double floorDiv(double dividend, double divisor) {
        return FloorDiv.compute(dividend, divisor);
    }

    @Override
    public byte floorMod(byte dividend, byte divisor) {
        return (byte) Math.floorMod(dividend, divisor);
    }

    @Override
    public short floorMod(short dividend, short divisor) {
        return (short) Math.floorMod(dividend, divisor);
    }

    @Override
    public int floorMod(int dividend, int divisor) {
        return Math.floorMod(dividend, divisor);
    }

    @Override
    public long floorMod(long dividend, long divisor) {
        return Math.floorMod(dividend, divisor);
    }

    private static final class FloorMod {
        private FloorMod() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double dividend, double divisor) {
            final double r = dividend % divisor;
            // if the signs are different and modulo not zero, adjust result
            if ((Math.signum(dividend) != Math.signum(divisor)) && r != 0) return r + divisor;
            return r;
        }
    }

    @Override
    public float floorMod(float dividend, float divisor) {
        return (float) FloorMod.compute(dividend, divisor);
    }

    @Override
    public double floorMod(double dividend, double divisor) {
        return FloorMod.compute(dividend, divisor);
    }

    private static final class CeilDiv {
        private CeilDiv() {
            throw new UnsupportedOperationException();
        }
        public static int compute(int dividend, int divisor) {
            final int q = dividend / divisor;
            // if the signs are the same and modulo not zero, round up
            if ((dividend ^ divisor) >= 0 && (q * divisor != dividend)) return q + 1;
            return q;
        }
        public static long compute(long dividend, long divisor) {
            final long q = dividend / divisor;
            // if the signs are the same and modulo not zero, round up
            if ((dividend ^ divisor) >= 0 && (q * divisor != dividend)) return q + 1;
            return q;
        }
        public static double compute(double dividend, double divisor) {
            final double q = dividend / divisor;
            // if the signs are the same and modulo not zero, round up
            if ((Math.signum(dividend) == Math.signum(divisor)) && (dividend % divisor != 0)) return q + 1;
            return q;
        }
    }

    @Override
    public byte ceilDiv(byte dividend, byte divisor) {
        return (byte) CeilDiv.compute(dividend, divisor);
    }

    @Override
    public short ceilDiv(short dividend, short divisor) {
        return (short) CeilDiv.compute(dividend, divisor);
    }

    @Override
    public int ceilDiv(int dividend, int divisor) {
        return CeilDiv.compute(dividend, divisor);
    }

    @Override
    public long ceilDiv(long dividend, long divisor) {
        return CeilDiv.compute(dividend, divisor);
    }

    @Override
    public float ceilDiv(float dividend, float divisor) {
        return (float) CeilDiv.compute(dividend, divisor);
    }

    @Override
    public double ceilDiv(double dividend, double divisor) {
        return CeilDiv.compute(dividend, divisor);
    }

    private static final class CeilMod {
        private CeilMod() {
            throw new UnsupportedOperationException();
        }
        public static int compute(int dividend, int divisor) {
            final int r = dividend % divisor;
            // if the signs are the same and modulo not zero, adjust result
            if ((dividend ^ divisor) >= 0 && r != 0) return r - divisor;
            return r;
        }
        public static long compute(long dividend, long divisor) {
            final long r = dividend % divisor;
            // if the signs are the same and modulo not zero, adjust result
            if ((dividend ^ divisor) >= 0 && r != 0) return r - divisor;
            return r;
        }
        public static double compute(double dividend, double divisor) {
            final double r = dividend % divisor;
            // if the signs are the same and modulo not zero, adjust result
            if ((Math.signum(dividend) == Math.signum(divisor)) && r != 0) return r - divisor;
            return r;
        }
    }

    @Override
    public byte ceilMod(byte dividend, byte divisor) {
        return (byte) CeilMod.compute(dividend, divisor);
    }

    @Override
    public short ceilMod(short dividend, short divisor) {
        return (short) CeilMod.compute(dividend, divisor);
    }

    @Override
    public int ceilMod(int dividend, int divisor) {
        return CeilMod.compute(dividend, divisor);
    }

    @Override
    public long ceilMod(long dividend, long divisor) {
        return CeilMod.compute(dividend, divisor);
    }

    @Override
    public float ceilMod(float dividend, float divisor) {
        return (float) CeilMod.compute(dividend, divisor);
    }

    @Override
    public double ceilMod(double dividend, double divisor) {
        return CeilMod.compute(dividend, divisor);
    }

    @Override
    public short multiplyFull(byte multiplicand, byte multiplier) {
        return (short) (multiplicand * multiplier);
    }

    @Override
    public int multiplyFull(short multiplicand, short multiplier) {
        return multiplicand * multiplier;
    }

    @Override
    public long multiplyFull(int multiplicand, int multiplier) {
        return (long) multiplicand * (long) multiplier;
    }

    private static final class MultiplyHigh {
        private MultiplyHigh() {
            throw new UnsupportedOperationException();
        }
        public static long compute(long multiplicand, long multiplier) {
            // Use technique from section 8-2 of Henry S. Warren, Jr.,
            // Hacker's Delight (2nd ed.) (Addison Wesley, 2013), 173-174.
            long x1 = multiplicand >> 32;
            long x2 = multiplicand & 0xFFFFFFFFL;
            long y1 = multiplier >> 32;
            long y2 = multiplier & 0xFFFFFFFFL;

            long z2 = x2 * y2;
            long t = x1 * y2 + (z2 >>> 32);
            long z1 = t & 0xFFFFFFFFL;
            long z0 = t >> 32;
            z1 += x2 * y1;

            return x1 * y1 + z0 + (z1 >> 32);
        }
    }

    @Override
    public long multiplyHigh(long multiplicand, long multiplier) {
        return MultiplyHigh.compute(multiplicand, multiplier);
    }

    @Override
    public byte rotateLeft(byte value, int distance) {
        return (byte) Integer.rotateLeft(value, distance % 8);
    }

    @Override
    public short rotateLeft(short value, int distance) {
        return (short) Integer.rotateLeft(value, distance % 16);
    }

    @Override
    public int rotateLeft(int value, int distance) {
        return Integer.rotateLeft(value, distance);
    }

    @Override
    public long rotateLeft(long value, int distance) {
        return Long.rotateLeft(value, distance);
    }

    @Override
    public byte rotateRight(byte value, int distance) {
        return (byte) Integer.rotateRight(value, distance % 8);
    }

    @Override
    public short rotateRight(short value, int distance) {
        return (short) Integer.rotateRight(value, distance % 16);
    }

    @Override
    public int rotateRight(int value, int distance) {
        return Integer.rotateRight(value, distance);
    }

    @Override
    public long rotateRight(long value, int distance) {
        return Long.rotateRight(value, distance);
    }

    private static final class GreatestCommonDivisor {
        private GreatestCommonDivisor() {
            throw new UnsupportedOperationException();
        }
        public static int compute(int a, int b) {
            int u = a;
            int v = b;
            if (u == 0 || v == 0) {
                if (u == Integer.MIN_VALUE || v == Integer.MIN_VALUE) throw new ArithmeticException("integer overflow");
                return Math.abs(u + v);
            }

            long ul = u;
            long vl = v;
            boolean useLong = false;
            if (u < 0) {
                if (Integer.MIN_VALUE == u) useLong = true;
                else u = -u;
                ul = -ul;
            }
            if (v < 0) {
                if (Integer.MIN_VALUE == v) useLong = true;
                else v = -v;
                vl = -vl;
            }
            if (useLong) {
                if (ul == vl) throw new ArithmeticException("integer overflow");
                long blbu = vl;
                vl = ul;
                ul = blbu % ul;
                if (ul == 0) {
                    if (vl > Integer.MAX_VALUE) throw new ArithmeticException("integer overflow");
                    return (int) vl;
                }
                blbu = vl;

                // Now "ul" and "vl" fit in an "int".
                v = (int) ul;
                u = (int) (blbu % ul);
            }

            return computePositive(u, v);
        }
        private static int computePositive(int a, int b) {
            if (a == 0) return b;
            else if (b == 0) return a;

            // Make "a" and "b" odd, keeping track of common power of 2.
            final int aTwos = Integer.numberOfTrailingZeros(a);
            a >>= aTwos;
            final int bTwos = Integer.numberOfTrailingZeros(b);
            b >>= bTwos;
            final int shift = Math.min(aTwos, bTwos);

            // "a" and "b" are positive.
            // If a > b then "gdc(a, b)" is equal to "gcd(a - b, b)".
            // If a < b then "gcd(a, b)" is equal to "gcd(b - a, a)".
            // Hence, in the successive iterations:
            //  "a" becomes the absolute difference of the current values,
            //  "b" becomes the minimum of the current values.
            while (a != b) {
                final int delta = a - b;
                b = Math.min(a, b);
                a = Math.abs(delta);

                // Remove any power of 2 in "a" ("b" is guaranteed to be odd).
                a >>= Integer.numberOfTrailingZeros(a);
            }

            // Recover the common power of 2.
            return a << shift;
        }
        public static long compute(long a, long b) {
            long u = a;
            long v = b;
            if ((u == 0) || (v == 0)) {
                if ((u == Long.MIN_VALUE) || (v == Long.MIN_VALUE)) throw new ArithmeticException("long overflow");
                return Math.abs(u) + Math.abs(v);
            }
            // keep u and v negative, as negative integers range down to
            // -2^63, while positive numbers can only be as large as 2^63-1
            // (i.e. we can't necessarily negate a negative number without
            // overflow)
            /* assert u!=0 && v!=0; */
            if (u > 0) u = -u; // make u negative
            if (v > 0) v = -v; // make v negative
            // B1. [Find power of 2]
            int k = 0;
            while ((u & 1) == 0 && (v & 1) == 0 && k < 63) { // while u and v are
                // both even...
                u /= 2;
                v /= 2;
                k ++; // cast out twos.
            }
            if (k == 63) throw new ArithmeticException("long overflow");
            // B2. Initialize: u and v have been divided by 2^k and at least
            // one is odd.
            long t = ((u & 1) == 1) ? v : -(u / 2)/* B3 */;
            // t negative: u was odd, v may be even (t replaces v)
            // t positive: u was even, v is odd (t replaces u)
            do {
                if (u >= 0 || v >= 0) throw new AssertionError();
                /* assert u<0 && v<0; */
                // B4/B3: cast out twos from t.
                while ((t & 1) == 0) { // while t is even..
                    t /= 2; // cast out twos
                }
                // B5 [reset max(u,v)]
                if (t > 0) u = -t;
                else v = t;
                // B6/B3. at this point both u and v should be odd.
                t = (v - u) / 2;
                // |u| larger: t positive (replace u)
                // |v| larger: t negative (replace v)
            } while (t != 0);
            return -u * (1L << k); // gcd is u*2^k
        }
    }

    @Override
    public byte gcd(byte a, byte b) {
        return (byte) GreatestCommonDivisor.compute(a, b);
    }

    @Override
    public short gcd(short a, short b) {
        return (short) GreatestCommonDivisor.compute(a, b);
    }

    @Override
    public int gcd(int a, int b) {
        return GreatestCommonDivisor.compute(a, b);
    }

    @Override
    public long gcd(long a, long b) {
        return GreatestCommonDivisor.compute(a, b);
    }

    @Override
    public byte gcd(byte a, byte b, byte c) {
        return (byte) GreatestCommonDivisor.compute(a, GreatestCommonDivisor.compute(b, c));
    }

    @Override
    public short gcd(short a, short b, short c) {
        return (short) GreatestCommonDivisor.compute(a, GreatestCommonDivisor.compute(b, c));
    }

    @Override
    public int gcd(int a, int b, int c) {
        return GreatestCommonDivisor.compute(a, GreatestCommonDivisor.compute(b, c));
    }

    @Override
    public long gcd(long a, long b, long c) {
        return GreatestCommonDivisor.compute(a, GreatestCommonDivisor.compute(b, c));
    }

    private static final class LeastCommonMultiple {
        private LeastCommonMultiple() {
            throw new UnsupportedOperationException();
        }
        public static byte compute(byte a, byte b) {
            if (a == 0 || b == 0) return 0;
            byte lcm = (byte) Math.abs(Math.multiplyExact(a / GreatestCommonDivisor.compute(a, b), b));
            if (lcm == Byte.MIN_VALUE) throw new ArithmeticException("byte overflow");
            return lcm;
        }
        public static short compute(short a, short b) {
            if (a == 0 || b == 0) return 0;
            short lcm = (short) Math.abs(Math.multiplyExact(a / GreatestCommonDivisor.compute(a, b), b));
            if (lcm == Short.MIN_VALUE) throw new ArithmeticException("short overflow");
            return lcm;
        }
        public static int compute(int a, int b) {
            if (a == 0 || b == 0) return 0;
            int lcm = Math.abs(Math.multiplyExact(a / GreatestCommonDivisor.compute(a, b), b));
            if (lcm == Integer.MIN_VALUE) throw new ArithmeticException("integer overflow");
            return lcm;
        }
        public static long compute(long a, long b) {
            if (a == 0 || b == 0) return 0;
            long lcm = Math.abs(Math.multiplyExact(a / GreatestCommonDivisor.compute(a, b), b));
            if (lcm == Long.MIN_VALUE) throw new ArithmeticException("long overflow");
            return lcm;
        }
    }

    @Override
    public byte lcm(byte a, byte b) {
        return LeastCommonMultiple.compute(a, b);
    }

    @Override
    public short lcm(short a, short b) {
        return LeastCommonMultiple.compute(a, b);
    }

    @Override
    public int lcm(int a, int b) {
        return LeastCommonMultiple.compute(a, b);
    }

    @Override
    public long lcm(long a, long b) {
        return LeastCommonMultiple.compute(a, b);
    }

    @Override
    public byte lcm(byte a, byte b, byte c) {
        return LeastCommonMultiple.compute(a, LeastCommonMultiple.compute(b, c));
    }

    @Override
    public short lcm(short a, short b, short c) {
        return LeastCommonMultiple.compute(a, LeastCommonMultiple.compute(b, c));
    }

    @Override
    public int lcm(int a, int b, int c) {
        return LeastCommonMultiple.compute(a, LeastCommonMultiple.compute(b, c));
    }

    @Override
    public long lcm(long a, long b, long c) {
        return LeastCommonMultiple.compute(a, LeastCommonMultiple.compute(b, c));
    }

    @Override
    public float hypot(float a, float b) {
        return (float) Math.hypot(a, b);
    }

    @Override
    public double hypot(double a, double b) {
        return Math.hypot(a, b);
    }

    @Override
    public byte copySign(byte magnitude, byte sign) {
        if ((magnitude ^ sign) < 0) return (byte) -magnitude;
        else return magnitude;
    }

    @Override
    public short copySign(short magnitude, short sign) {
        if ((magnitude ^ sign) < 0) return (short) -magnitude;
        else return magnitude;
    }

    @Override
    public int copySign(int magnitude, int sign) {
        if ((magnitude ^ sign) < 0) return -magnitude;
        else return magnitude;
    }

    @Override
    public long copySign(long magnitude, long sign) {
        if ((magnitude ^ sign) < 0) return -magnitude;
        else return magnitude;
    }

    @Override
    public float copySign(float magnitude, float sign) {
        return Math.copySign(magnitude, sign);
    }

    @Override
    public double copySign(double magnitude, double sign) {
        return Math.copySign(magnitude, sign);
    }

    @Override
    public float nextAfter(float start, float direction) {
        return Math.nextAfter(start, direction);
    }

    @Override
    public float nextAfter(float start, double direction) {
        return Math.nextAfter(start, direction);
    }

    @Override
    public double nextAfter(double start, double direction) {
        return Math.nextAfter(start, direction);
    }

    @Override
    public byte unsignedDivide(byte dividend, byte divisor) {
        return (byte) (Byte.toUnsignedInt(dividend) / Byte.toUnsignedInt(divisor));
    }

    @Override
    public short unsignedDivide(short dividend, short divisor) {
        return (short) (Short.toUnsignedInt(dividend) / Short.toUnsignedInt(divisor));
    }

    @Override
    public int unsignedDivide(int dividend, int divisor) {
        return Integer.divideUnsigned(dividend, divisor);
    }

    @Override
    public long unsignedDivide(long dividend, long divisor) {
        return Long.divideUnsigned(dividend, divisor);
    }

    @Override
    public byte unsignedRemainder(byte dividend, byte divisor) {
        return (byte) (Byte.toUnsignedInt(dividend) % Byte.toUnsignedInt(divisor));
    }

    @Override
    public short unsignedRemainder(short dividend, short divisor) {
        return (short) (Short.toUnsignedInt(dividend) % Short.toUnsignedInt(divisor));
    }

    @Override
    public int unsignedRemainder(int dividend, int divisor) {
        return Integer.remainderUnsigned(dividend, divisor);
    }

    @Override
    public long unsignedRemainder(long dividend, long divisor) {
        return Long.remainderUnsigned(dividend, divisor);
    }

    private static final class UnsignedCeilDiv {
        private UnsignedCeilDiv() {
            throw new UnsupportedOperationException();
        }
        public static long compute(long dividend, long divisor) {
            final long q = Long.divideUnsigned(dividend, divisor);
            // if modulo not zero, round up
            if (q * divisor != dividend) return q + 1;
            return q;
        }
    }

    @Override
    public byte unsignedCeilDiv(byte dividend, byte divisor) {
        return (byte) CeilDiv.compute(Byte.toUnsignedInt(dividend), Byte.toUnsignedInt(divisor));
    }

    @Override
    public short unsignedCeilDiv(short dividend, short divisor) {
        return (short) CeilDiv.compute(Short.toUnsignedInt(dividend), Short.toUnsignedInt(divisor));
    }

    @Override
    public int unsignedCeilDiv(int dividend, int divisor) {
        return (int) CeilDiv.compute(Integer.toUnsignedLong(dividend), Integer.toUnsignedLong(divisor));
    }

    @Override
    public long unsignedCeilDiv(long dividend, long divisor) {
        return UnsignedCeilDiv.compute(dividend, divisor);
    }

    private static final class UnsignedCeilMod {
        private UnsignedCeilMod() {
            throw new UnsupportedOperationException();
        }
        public static long compute(long dividend, long divisor) {
            final long r = Long.remainderUnsigned(dividend, divisor);
            // if modulo not zero, adjust result
            if (r != 0) return r - divisor;
            return r;
        }
    }

    @Override
    public byte unsignedCeilMod(byte dividend, byte divisor) {
        return (byte) CeilMod.compute(Byte.toUnsignedInt(dividend), Byte.toUnsignedInt(divisor));
    }

    @Override
    public short unsignedCeilMod(short dividend, short divisor) {
        return (short) CeilMod.compute(Short.toUnsignedInt(dividend), Short.toUnsignedInt(divisor));
    }

    @Override
    public int unsignedCeilMod(int dividend, int divisor) {
        return (int) CeilMod.compute(Integer.toUnsignedLong(dividend), Integer.toUnsignedLong(divisor));
    }

    @Override
    public long unsignedCeilMod(long dividend, long divisor) {
        return UnsignedCeilMod.compute(dividend, divisor);
    }

    @Override
    public short unsignedMultiplyFull(byte multiplicand, byte multiplier) {
        return (short) (Byte.toUnsignedInt(multiplicand) * Byte.toUnsignedInt(multiplier));
    }

    @Override
    public int unsignedMultiplyFull(short multiplicand, short multiplier) {
        return Short.toUnsignedInt(multiplicand) * Short.toUnsignedInt(multiplier);
    }

    @Override
    public long unsignedMultiplyFull(int multiplicand, int multiplier) {
        return Integer.toUnsignedLong(multiplicand) * Integer.toUnsignedLong(multiplier);
    }

    private static final class UnsignedMultiplyHigh {
        private UnsignedMultiplyHigh() {
            throw new UnsupportedOperationException();
        }
        public static long compute(long multiplicand, long multiplier) {
            // Compute via multiplyHigh() to leverage the intrinsic
            long result = MultiplyHigh.compute(multiplicand, multiplier);
            result += (multiplier & (multiplicand >> 63)); // equivalent to `if (multiplicand < 0) result += multiplier;`
            result += (multiplicand & (multiplier >> 63)); // equivalent to `if (multiplier < 0) result += multiplicand;`
            return result;
        }
    }

    @Override
    public long unsignedMultiplyHigh(long multiplicand, long multiplier) {
        return UnsignedMultiplyHigh.compute(multiplicand, multiplier);
    }

    @Override
    public byte addExact(byte augend, byte addend) {
        int r = augend + addend;
        if (r < Byte.MIN_VALUE || r > Byte.MAX_VALUE) throw new ArithmeticException("byte overflow");
        return (byte) r;
    }

    @Override
    public short addExact(short augend, short addend) {
        int r = augend + addend;
        if (r < Short.MIN_VALUE || r > Short.MAX_VALUE) throw new ArithmeticException("short overflow");
        return (short) r;
    }

    @Override
    public int addExact(int augend, int addend) {
        return Math.addExact(augend, addend);
    }

    @Override
    public long addExact(long augend, long addend) {
        return Math.addExact(augend, addend);
    }

    @Override
    public byte subtractExact(byte minuend, byte subtrahend) {
        int r = minuend - subtrahend;
        if (r < Byte.MIN_VALUE || r > Byte.MAX_VALUE) throw new ArithmeticException("byte overflow");
        return (byte) r;
    }

    @Override
    public short subtractExact(short minuend, short subtrahend) {
        int r = minuend - subtrahend;
        if (r < Short.MIN_VALUE || r > Short.MAX_VALUE) throw new ArithmeticException("short overflow");
        return (short) r;
    }

    @Override
    public int subtractExact(int minuend, int subtrahend) {
        return Math.subtractExact(minuend, subtrahend);
    }

    @Override
    public long subtractExact(long minuend, long subtrahend) {
        return Math.subtractExact(minuend, subtrahend);
    }

    @Override
    public byte multiplyExact(byte multiplicand, byte multiplier) {
        int r = multiplicand * multiplier;
        if (r < Byte.MIN_VALUE || r > Byte.MAX_VALUE) throw new ArithmeticException("byte overflow");
        return (byte) r;
    }

    @Override
    public short multiplyExact(short multiplicand, short multiplier) {
        int r = multiplicand * multiplier;
        if (r < Short.MIN_VALUE || r > Short.MAX_VALUE) throw new ArithmeticException("short overflow");
        return (short) r;
    }

    @Override
    public int multiplyExact(int multiplicand, int multiplier) {
        return Math.multiplyExact(multiplicand, multiplier);
    }

    @Override
    public long multiplyExact(long multiplicand, long multiplier) {
        return Math.multiplyExact(multiplicand, multiplier);
    }

    @Override
    public byte divideExact(byte dividend, byte divisor) {
        int q = dividend / divisor;
        if (q > Byte.MAX_VALUE) throw new ArithmeticException("byte overflow");
        return (byte) q;
    }

    @Override
    public short divideExact(short dividend, short divisor) {
        int q = dividend / divisor;
        if (q > Short.MAX_VALUE) throw new ArithmeticException("short overflow");
        return (short) q;
    }

    private static final class DivideExact {
        private DivideExact() {
            throw new UnsupportedOperationException();
        }
        public static int compute(int dividend, int divisor) {
            int q = dividend / divisor;
            if ((dividend & divisor & q) >= 0) return q;
            throw new ArithmeticException("integer overflow");
        }
        public static long compute(long dividend, long divisor) {
            long q = dividend / divisor;
            if ((dividend & divisor & q) >= 0) return q;
            throw new ArithmeticException("long overflow");
        }
    }

    @Override
    public int divideExact(int dividend, int divisor) {
        return DivideExact.compute(dividend, divisor);
    }

    @Override
    public long divideExact(long dividend, long divisor) {
        return DivideExact.compute(dividend, divisor);
    }

    private static final class FloorDivExact {
        private FloorDivExact() {
            throw new UnsupportedOperationException();
        }
        public static byte compute(byte dividend, byte divisor) {
            final int q = dividend / divisor;
            if (q > Byte.MAX_VALUE || q == Byte.MIN_VALUE) throw new ArithmeticException("byte overflow");
            // if the signs are different and modulo not zero, round down
            if ((dividend ^ divisor) < 0 && (q * divisor != dividend)) return (byte) (q - 1);
            return (byte) q;
        }
        public static short compute(short dividend, short divisor) {
            final int q = dividend / divisor;
            if (q > Short.MAX_VALUE || q == Short.MIN_VALUE) throw new ArithmeticException("short overflow");
            // if the signs are different and modulo not zero, round down
            if ((dividend ^ divisor) < 0 && (q * divisor != dividend)) return (short) (q - 1);
            return (short) q;
        }
        public static int compute(int dividend, int divisor) {
            final int q = dividend / divisor;
            if ((dividend & divisor & q) >= 0) {
                // if the signs are different and modulo not zero, round down
                if ((dividend ^ divisor) < 0 && (q * divisor != dividend)) return q - 1;
                return q;
            }
            throw new ArithmeticException("integer overflow");
        }
        public static long compute(long dividend, long divisor) {
            final long q = dividend / divisor;
            if ((dividend & divisor & q) >= 0) {
                // if the signs are different and modulo not zero, round down
                if ((dividend ^ divisor) < 0 && (q * divisor != dividend)) return q - 1;
                return q;
            }
            throw new ArithmeticException("long overflow");
        }
    }

    @Override
    public byte floorDivExact(byte dividend, byte divisor) {
        return FloorDivExact.compute(dividend, divisor);
    }

    @Override
    public short floorDivExact(short dividend, short divisor) {
        return FloorDivExact.compute(dividend, divisor);
    }

    @Override
    public int floorDivExact(int dividend, int divisor) {
        return FloorDivExact.compute(dividend, divisor);
    }

    @Override
    public long floorDivExact(long dividend, long divisor) {
        return FloorDivExact.compute(dividend, divisor);
    }

    private static final class CeilDivExact {
        private CeilDivExact() {
            throw new UnsupportedOperationException();
        }
        public static byte compute(byte dividend, byte divisor) {
            final int q = dividend / divisor;
            if (q >= Byte.MAX_VALUE) throw new ArithmeticException("byte overflow");
            // if the signs are the same and modulo not zero, round up
            if ((dividend ^ divisor) >= 0 && (q * divisor != dividend)) return (byte) (q + 1);
            return (byte) q;
        }
        public static short compute(short dividend, short divisor) {
            final int q = dividend / divisor;
            if (q >= Short.MAX_VALUE) throw new ArithmeticException("short overflow");
            // if the signs are the same and modulo not zero, round up
            if ((dividend ^ divisor) >= 0 && (q * divisor != dividend)) return (short) (q + 1);
            return (short) q;
        }
        public static int compute(int dividend, int divisor) {
            final int q = dividend / divisor;
            if ((dividend & divisor & q) >= 0) {
                // if the signs are the same and modulo not zero, round up
                if ((dividend ^ divisor) >= 0 && (q * divisor != dividend)) return q + 1;
                return q;
            }
            throw new ArithmeticException("integer overflow");
        }
        public static long compute(long dividend, long divisor) {
            final long q = dividend / divisor;
            if ((dividend & divisor & q) >= 0) {
                // if the signs are the same and modulo not zero, round up
                if ((dividend ^ divisor) >= 0 && (q * divisor != dividend)) return q + 1;
                return q;
            }
            throw new ArithmeticException("long overflow");
        }
    }

    @Override
    public byte ceilDivExact(byte dividend, byte divisor) {
        return CeilDivExact.compute(dividend, divisor);
    }

    @Override
    public short ceilDivExact(short dividend, short divisor) {
        return CeilDivExact.compute(dividend, divisor);
    }

    @Override
    public int ceilDivExact(int dividend, int divisor) {
        return CeilDivExact.compute(dividend, divisor);
    }

    @Override
    public long ceilDivExact(long dividend, long divisor) {
        return CeilDivExact.compute(dividend, divisor);
    }

    @Override
    public byte unsignedAddExact(byte augend, byte addend) {
        int r = Byte.toUnsignedInt(augend) + Byte.toUnsignedInt(addend);
        if (r > 255) throw new ArithmeticException("byte overflow");
        return (byte) r;
    }

    @Override
    public short unsignedAddExact(short augend, short addend) {
        int r = Short.toUnsignedInt(augend) + Short.toUnsignedInt(addend);
        if (r > 65535) throw new ArithmeticException("short overflow");
        return (short) r;
    }

    @Override
    public int unsignedAddExact(int augend, int addend) {
        long r = Integer.toUnsignedLong(augend) + Integer.toUnsignedLong(addend);
        if (r > 4294967295L) throw new ArithmeticException("integer overflow");
        return (int) r;
    }

    private static final class UnsignedAddExact {
        private UnsignedAddExact() {
            throw new UnsupportedOperationException();
        }
        public static long compute(long augend, long addend) {
            long sum = augend + addend;
            if (Long.compareUnsigned(augend, sum) > 0) throw new ArithmeticException("long overflow");
            return sum;
        }
    }

    @Override
    public long unsignedAddExact(long augend, long addend) {
        return UnsignedAddExact.compute(augend, addend);
    }

    @Override
    public byte unsignedSubtractExact(byte minuend, byte subtrahend) {
        int r = Byte.toUnsignedInt(minuend) - Byte.toUnsignedInt(subtrahend);
        if (r < 0) throw new ArithmeticException("byte overflow");
        return (byte) r;
    }

    @Override
    public short unsignedSubtractExact(short minuend, short subtrahend) {
        int r = Short.toUnsignedInt(minuend) - Short.toUnsignedInt(subtrahend);
        if (r < 0) throw new ArithmeticException("short overflow");
        return (byte) r;
    }

    @Override
    public int unsignedSubtractExact(int minuend, int subtrahend) {
        long r = Integer.toUnsignedLong(minuend) - Integer.toUnsignedLong(subtrahend);
        if (r < 0) throw new ArithmeticException("integer overflow");
        return (int) r;
    }

    @Override
    public long unsignedSubtractExact(long minuend, long subtrahend) {
        return UnsignedAddExact.compute(minuend, -subtrahend);
    }

    @Override
    public byte unsignedMultiplyExact(byte multiplicand, byte multiplier) {
        int r = Byte.toUnsignedInt(multiplicand) * Byte.toUnsignedInt(multiplier);
        if (r > 255) throw new ArithmeticException("byte overflow");
        return (byte) r;
    }

    @Override
    public short unsignedMultiplyExact(short multiplicand, short multiplier) {
        int r = Short.toUnsignedInt(multiplicand) * Short.toUnsignedInt(multiplier);
        if (r > 65535) throw new ArithmeticException("short overflow");
        return (short) r;
    }

    @Override
    public int unsignedMultiplyExact(int multiplicand, int multiplier) {
        long r = Integer.toUnsignedLong(multiplicand) * Integer.toUnsignedLong(multiplier);
        if (r > 4294967295L) throw new ArithmeticException("integer overflow");
        return (int) r;
    }

    @Override
    public long unsignedMultiplyExact(long multiplicand, long multiplier) {
        long hi = UnsignedMultiplyHigh.compute(multiplicand, multiplier);
        if (hi != 0) throw new ArithmeticException("long overflow");
        return multiplicand * multiplier;
    }

    private static final class UnsignedCeilDivExact {
        private UnsignedCeilDivExact() {
            throw new UnsupportedOperationException();
        }
        public static byte compute(byte dividend, byte divisor) {
            int iDividend = Byte.toUnsignedInt(dividend);
            int iDivisor = Byte.toUnsignedInt(divisor);
            final int q = iDividend / iDivisor;
            if (q * iDivisor != iDividend) return (byte) q;
            else if (q == 255) throw new ArithmeticException("byte overflow");
            else return (byte) (q + 1); // if modulo not zero, round up
        }
        public static short compute(short dividend, short divisor) {
            int iDividend = Short.toUnsignedInt(dividend);
            int iDivisor = Short.toUnsignedInt(divisor);
            final int q = iDividend / iDivisor;
            if (q * iDivisor != iDividend) return (short) q;
            else if (q == 65535) throw new ArithmeticException("short overflow");
            else return (short) (q + 1); // if modulo not zero, round up
        }
        public static int compute(int dividend, int divisor) {
            final int q = Integer.divideUnsigned(dividend, divisor);
            if (Integer.remainderUnsigned(dividend, divisor) == 0) return q;
            else if (q == -1) throw new ArithmeticException("integer overflow");
            else return q + 1; // if modulo not zero, round up
        }
        public static long compute(long dividend, long divisor) {
            final long q = Long.divideUnsigned(dividend, divisor);
            if (Long.remainderUnsigned(dividend, divisor) == 0) return q;
            else if (q == -1L) throw new ArithmeticException("long overflow");
            else return q + 1L; // if modulo not zero, round up
        }
    }

    @Override
    public byte unsignedCeilDivExact(byte dividend, byte divisor) {
        return UnsignedCeilDivExact.compute(dividend, divisor);
    }

    @Override
    public short unsignedCeilDivExact(short dividend, short divisor) {
        return UnsignedCeilDivExact.compute(dividend, divisor);
    }

    @Override
    public int unsignedCeilDivExact(int dividend, int divisor) {
        return UnsignedCeilDivExact.compute(dividend, divisor);
    }

    @Override
    public long unsignedCeilDivExact(long dividend, long divisor) {
        return UnsignedCeilDivExact.compute(dividend, divisor);
    }
    
    static final class FusedMultiplyAdd {
        private FusedMultiplyAdd() {
            throw new UnsupportedOperationException();
        }
        public static double compute(double multiplicand, double multiplier, double addend) {
            /*
             * Infinity and NaN arithmetic is not quite the same with two
             * roundings as opposed to just one so the simple expression
             * "multiplicand * multiplier + addend" cannot always be used to compute the correct
             * result.  With two roundings, the product can overflow and
             * if the addend is infinite, multiplicand spurious NaN can be produced
             * if the infinity from the overflow and the infinite addend
             * have opposite signs.
             */

            // First, screen for and handle non-finite input values whose
            // arithmetic is not supported by BigDecimal.
            if (Double.isNaN(multiplicand) || Double.isNaN(multiplier) || Double.isNaN(addend)) return Double.NaN;
            else { // All inputs non-NaN
                boolean infiniteA = Double.isInfinite(multiplicand);
                boolean infiniteB = Double.isInfinite(multiplier);
                boolean infiniteC = Double.isInfinite(addend);
                double result;

                if (infiniteA || infiniteB || infiniteC) {
                    if (infiniteA && multiplier == 0.0 || infiniteB && multiplicand == 0.0) return Double.NaN;
                    double product = multiplicand * multiplier;
                    if (Double.isInfinite(product) && !infiniteA && !infiniteB) {
                        // Intermediate overflow; might cause multiplicand
                        // spurious NaN if added to infinite addend.
                        if (!Double.isInfinite(addend)) throw new AssertionError();
                        /* assert Double.isInfinite(addend); */
                        return addend;
                    }
                    else {
                        result = product + addend;
                        if (Double.isFinite(result)) throw new AssertionError();
                        /* assert !Double.isFinite(result); */
                        return result;
                    }
                }
                else { // All inputs finite
                    BigDecimal product = (new BigDecimal(multiplicand)).multiply(new BigDecimal(multiplier));
                    if (addend == 0.0) { // Positive or negative zero
                        // If the product is an exact zero, use multiplicand
                        // floating-point expression to compute the sign
                        // of the zero final result. The product is an
                        // exact zero if and only if at least one of multiplicand and
                        // multiplier is zero.
                        if (multiplicand == 0.0 || multiplier == 0.0) return multiplicand * multiplier + addend;
                        else {
                            // The sign of multiplicand zero addend doesn't matter if
                            // the product is nonzero. The sign of multiplicand zero
                            // addend is not factored in the result if the
                            // exact product is nonzero but underflows to
                            // zero; see IEEE-754 2008 section 6.3 "The
                            // sign bit".
                            return product.doubleValue();
                        }
                    }
                    else return product.add(new BigDecimal(addend)).doubleValue();
                }
            }
        }
        public static float compute(float multiplicand, float multiplier, float addend) {
            if (Float.isFinite(multiplicand) && Float.isFinite(multiplier) && Float.isFinite(addend)) {
                if (multiplicand == 0.0 || multiplier == 0.0) return multiplicand * multiplier + addend; // Handled signed zero cases
                else {
                    return (new BigDecimal((double) multiplicand * (double) multiplier) // Exact multiply
                            .add(new BigDecimal((double) addend))) // Exact sum
                            .floatValue(); // One rounding to multiplicand float value
                }
            }
            else {
                // At least one of multiplicand,multiplier, and addend is non-finite. The result
                // will be non-finite as well and will be the same
                // non-finite value under double as float arithmetic.
                return (float) compute((double) multiplicand, (double) multiplier, (double) addend);
            }
        }
    }

    @Override
    public float fma(float multiplicand, float multiplier, float addend) {
        return FusedMultiplyAdd.compute(multiplicand, multiplier, addend);
    }

    @Override
    public double fma(double multiplicand, double multiplier, double addend) {
        return FusedMultiplyAdd.compute(multiplicand, multiplier, addend);
    }

    @Override
    public float ffma(float multiplicand, float multiplier, float addend) {
        return multiplicand * multiplier + addend;
    }

    @Override
    public double ffma(double multiplicand, double multiplier, double addend) {
        return multiplicand * multiplier + addend;
    }

    @Override
    public float scaleB(float multiplicand, int exponent) {
        return Math.scalb(multiplicand, exponent);
    }

    @Override
    public double scaleB(double multiplicand, int exponent) {
        return Math.scalb(multiplicand, exponent);
    }

    @Override
    public int compare(byte a, byte b) {
        return Byte.compare(a, b);
    }

    @Override
    public int compare(short a, short b) {
        return Short.compare(a, b);
    }

    @Override
    public int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    @Override
    public int compare(long a, long b) {
        return Long.compare(a, b);
    }

    @Override
    public int compare(float a, float b) {
        return Float.compare(a, b);
    }

    @Override
    public int compare(double a, double b) {
        return Double.compare(a, b);
    }

    @Override
    public int compare(float a, float b, float epsilon) {
        if (Math.abs(a - b) <= epsilon) return 0;
        else return Float.compare(a, b);
    }

    @Override
    public int compare(double a, double b, double epsilon) {
        if (Math.abs(a - b) <= epsilon) return 0;
        else return Double.compare(a, b);
    }

    @Override
    public int compareSign(byte a, byte b) {
        return Integer.compare(Integer.signum(a), Integer.signum(b));
    }

    @Override
    public int compareSign(short a, short b) {
        return Integer.compare(Integer.signum(a), Integer.signum(b));
    }

    @Override
    public int compareSign(int a, int b) {
        return Integer.compare(Integer.signum(a), Integer.signum(b));
    }

    @Override
    public int compareSign(long a, long b) {
        return Integer.compare(Long.signum(a), Long.signum(b));
    }

    @Override
    public int compareSign(float a, float b) {
        return Float.compare(Math.signum(a), Math.signum(b));
    }

    @Override
    public int compareSign(double a, double b) {
        return Double.compare(Math.signum(a), Math.signum(b));
    }

    @Override
    public byte max(byte a, byte b) {
        return (byte) Math.max(a, b);
    }

    @Override
    public short max(short a, short b) {
        return (short) Math.max(a, b);
    }

    @Override
    public int max(int a, int b) {
        return Math.max(a, b);
    }

    @Override
    public long max(long a, long b) {
        return Math.max(a, b);
    }

    @Override
    public float max(float a, float b) {
        return Math.max(a, b);
    }

    @Override
    public double max(double a, double b) {
        return Math.max(a, b);
    }

    @Override
    public byte max(byte a, byte b, byte c) {
        return (byte) Math.max(a, Math.max(b, c));
    }

    @Override
    public short max(short a, short b, short c) {
        return (short) Math.max(a, Math.max(b, c));
    }

    @Override
    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    @Override
    public long max(long a, long b, long c) {
        return Math.max(a, Math.max(b, c));
    }

    @Override
    public float max(float a, float b, float c) {
        return Math.max(a, Math.max(b, c));
    }

    @Override
    public double max(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }

    @Override
    public byte min(byte a, byte b) {
        return (byte) Math.min(a, b);
    }

    @Override
    public short min(short a, short b) {
        return (short) Math.min(a, b);
    }

    @Override
    public int min(int a, int b) {
        return Math.min(a, b);
    }

    @Override
    public long min(long a, long b) {
        return Math.min(a, b);
    }

    @Override
    public float min(float a, float b) {
        return Math.min(a, b);
    }

    @Override
    public double min(double a, double b) {
        return Math.min(a, b);
    }

    @Override
    public byte min(byte a, byte b, byte c) {
        return (byte) Math.min(a, Math.min(b, c));
    }

    @Override
    public short min(short a, short b, short c) {
        return (short) Math.min(a, Math.min(b, c));
    }

    @Override
    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    @Override
    public long min(long a, long b, long c) {
        return Math.min(a, Math.min(b, c));
    }

    @Override
    public float min(float a, float b, float c) {
        return Math.min(a, Math.min(b, c));
    }

    @Override
    public double min(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }

    @Override
    public byte clamp(byte value, byte min, byte max) {
        return (byte) Clamp.compute(value, min, max);
    }

    @Override
    public byte clamp(short value, byte min, byte max) {
        return (byte) Clamp.compute(value, min, max);
    }

    @Override
    public short clamp(short value, short min, short max) {
        return (short) Clamp.compute(value, min, max);
    }

    @Override
    public short clamp(int value, short min, short max) {
        return (short) Clamp.compute(value, min, max);
    }

    private static final class Clamp {
        private Clamp() {
            throw new UnsupportedOperationException();
        }
        public static int compute(int value, int min, int max) {
            if (min > max) throw new IllegalArgumentException(min + " > " + max);
            return Math.max(min, Math.min(value, max));
        }
        public static long compute(long value, long min, long max) {
            if (min > max) throw new IllegalArgumentException(min + " > " + max);
            return Math.max(min, Math.min(value, max));
        }
        public static float compute(float value, float min, float max) {
            if (min > max) throw new IllegalArgumentException(min + " > " + max);
            return Math.max(min, Math.min(value, max));
        }
        public static double compute(double value, double min, double max) {
            if (min > max) throw new IllegalArgumentException(min + " > " + max);
            return Math.max(min, Math.min(value, max));
        }
    }

    @Override
    public int clamp(int value, int min, int max) {
        return Clamp.compute(value, min, max);
    }

    @Override
    public int clamp(long value, int min, int max) {
        return (int) Clamp.compute(value, min, max);
    }

    @Override
    public long clamp(long value, long min, long max) {
        return Clamp.compute(value, min, max);
    }

    @Override
    public float clamp(float value, float min, float max) {
        return Clamp.compute(value, min, max);
    }

    @Override
    public double clamp(double value, double min, double max) {
        return Clamp.compute(value, min, max);
    }

    @Override
    public boolean equals(float a, float b, float epsilon) {
        return Float.compare(a, b) == 0 || Math.abs(a - b) <= epsilon;
    }

    @Override
    public boolean equals(double a, double b, double epsilon) {
        return Double.compare(a, b) == 0 || Math.abs(a - b) <= epsilon;
    }

    @Override
    public int unsignedCompare(byte a, byte b) {
        return Integer.compare(Byte.toUnsignedInt(a), Byte.toUnsignedInt(b));
    }

    @Override
    public int unsignedCompare(short a, short b) {
        return Integer.compare(Short.toUnsignedInt(a), Short.toUnsignedInt(b));
    }

    @Override
    public int unsignedCompare(int a, int b) {
        return Integer.compareUnsigned(a, b);
    }

    @Override
    public int unsignedCompare(long a, long b) {
        return Long.compareUnsigned(a, b);
    }

    @Override
    public byte unsignedMax(byte a, byte b) {
        return (byte) Math.max(Byte.toUnsignedInt(a), Byte.toUnsignedInt(b));
    }

    @Override
    public short unsignedMax(short a, short b) {
        return (short) Math.max(Short.toUnsignedInt(a), Short.toUnsignedInt(b));
    }

    @Override
    public int unsignedMax(int a, int b) {
        return (int) Math.max(Integer.toUnsignedLong(a), Integer.toUnsignedLong(b));
    }

    private static final class UnsignedMax {
        private UnsignedMax() {
            throw new UnsupportedOperationException();
        }
        public static long compute(long a, long b) {
            if (a == 0) return b;
            else if (b == 0) return a;
            else {
                int s1 = Long.signum(a);
                int s2 = Long.signum(b);
                if (s1 == s2) return Math.max(a, b);
                else if (s1 < s2) return a;
                else return b;
            }
        }
    }

    @Override
    public long unsignedMax(long a, long b) {
        return UnsignedMax.compute(a, b);
    }

    @Override
    public byte unsignedMax(byte a, byte b, byte c) {
        return (byte) Math.max(Byte.toUnsignedInt(a), Math.max(Byte.toUnsignedInt(b), Byte.toUnsignedInt(c)));
    }

    @Override
    public short unsignedMax(short a, short b, short c) {
        return (short) Math.max(Short.toUnsignedInt(a), Math.max(Short.toUnsignedInt(b), Short.toUnsignedInt(c)));
    }

    @Override
    public int unsignedMax(int a, int b, int c) {
        return (int) Math.max(Integer.toUnsignedLong(a), Math.max(Integer.toUnsignedLong(b), Integer.toUnsignedLong(c)));
    }

    @Override
    public long unsignedMax(long a, long b, long c) {
        return UnsignedMax.compute(a, UnsignedMax.compute(b, c));
    }

    @Override
    public byte unsignedMin(byte a, byte b) {
        return (byte) Math.min(Byte.toUnsignedInt(a), Byte.toUnsignedInt(b));
    }

    @Override
    public short unsignedMin(short a, short b) {
        return (short) Math.min(Short.toUnsignedInt(a), Short.toUnsignedInt(b));
    }

    @Override
    public int unsignedMin(int a, int b) {
        return (int) Math.min(Integer.toUnsignedLong(a), Integer.toUnsignedLong(b));
    }

    private static final class UnsignedMin {
        private UnsignedMin() {
            throw new UnsupportedOperationException();
        }
        public static long compute(long a, long b) {
            if (a == 0) return a;
            else if (b == 0) return b;
            else {
                int s1 = Long.signum(a);
                int s2 = Long.signum(b);
                if (s1 == s2) return Math.min(a, b);
                else if (s1 < s2) return b;
                else return a;
            }
        }
    }

    @Override
    public long unsignedMin(long a, long b) {
        return UnsignedMin.compute(a, b);
    }

    @Override
    public byte unsignedMin(byte a, byte b, byte c) {
        return (byte) Math.min(Byte.toUnsignedInt(a), Math.min(Byte.toUnsignedInt(b), Byte.toUnsignedInt(c)));
    }

    @Override
    public short unsignedMin(short a, short b, short c) {
        return (short) Math.min(Short.toUnsignedInt(a), Math.min(Short.toUnsignedInt(b), Short.toUnsignedInt(c)));
    }

    @Override
    public int unsignedMin(int a, int b, int c) {
        return (int) Math.min(Integer.toUnsignedLong(a), Math.min(Integer.toUnsignedLong(b), Integer.toUnsignedLong(c)));
    }

    @Override
    public long unsignedMin(long a, long b, long c) {
        return UnsignedMin.compute(a, UnsignedMin.compute(b, c));
    }

    @Override
    public byte unsignedClamp(byte value, byte min, byte max) {
        return (byte) Clamp.compute(Byte.toUnsignedInt(value), Byte.toUnsignedInt(min), Byte.toUnsignedInt(max));
    }

    @Override
    public byte unsignedClamp(short value, byte min, byte max) {
        return (byte) Clamp.compute(Short.toUnsignedInt(value), Byte.toUnsignedInt(min), Byte.toUnsignedInt(max));
    }

    @Override
    public short unsignedClamp(short value, short min, short max) {
        return (short) Clamp.compute(Short.toUnsignedInt(value), Short.toUnsignedInt(min), Short.toUnsignedInt(max));
    }

    @Override
    public short unsignedClamp(int value, short min, short max) {
        return (short) Clamp.compute(Integer.toUnsignedLong(value), Short.toUnsignedLong(min), Short.toUnsignedLong(max));
    }

    @Override
    public int unsignedClamp(int value, int min, int max) {
        return (int) Clamp.compute(Integer.toUnsignedLong(value), Integer.toUnsignedLong(min), Integer.toUnsignedLong(max));
    }

    private static final class UnsignedClamp {
        private UnsignedClamp() {
            throw new UnsupportedOperationException();
        }
        public static long compute(long value, long min, long max) {
            if (Long.compareUnsigned(min, max) > 0)
                throw new IllegalArgumentException(Long.toUnsignedString(min) + " > " + Long.toUnsignedString(max));
            return UnsignedMax.compute(min, UnsignedMin.compute(value, max));
        }
    }

    @Override
    public int unsignedClamp(long value, int min, int max) {
        return (int) UnsignedClamp.compute(value, Integer.toUnsignedLong(min), Integer.toUnsignedLong(max));
    }

    @Override
    public long unsignedClamp(long value, long min, long max) {
        return UnsignedClamp.compute(value, min, max);
    }

    private static final class Normalize {
        private Normalize() {
            throw new UnsupportedOperationException();
        }
        public static float compute(float value, float min, float max) {
            if (Float.isInfinite(value) || Float.isNaN(value)) return Float.NaN;
            float range = max - min;
            while (value > max) value -= range;
            while (value < min) value += range;
            return value;
        }
        public static double compute(double value, double min, double max) {
            if (Double.isInfinite(value) || Double.isNaN(value)) return Double.NaN;
            double range = max - min;
            while (value > max) value -= range;
            while (value < min) value += range;
            return value;
        }
    }

    @Override
    public float normalize(float value, float min, float max) {
        return Normalize.compute(value, min, max);
    }

    @Override
    public double normalize(double value, double min, double max) {
        return Normalize.compute(value, min, max);
    }

    @Override
    public float saturate(float value) {
        return Math.max(0f, Math.min(value, 1f));
    }

    @Override
    public double saturate(double value) {
        return Math.max(0d, Math.min(value, 1d));
    }

    @Override
    public int sign(byte value) {
        return Integer.signum(value);
    }

    @Override
    public int sign(short value) {
        return Integer.signum(value);
    }

    @Override
    public int sign(int value) {
        return Integer.signum(value);
    }

    @Override
    public int sign(long value) {
        return Long.signum(value);
    }

    @Override
    public float sign(float value) {
        return Math.signum(value);
    }

    @Override
    public double sign(double value) {
        return Math.signum(value);
    }

    @Override
    public int getExponent(float value) {
        return Math.getExponent(value);
    }

    @Override
    public int getExponent(double value) {
        return Math.getExponent(value);
    }

    @Override
    public int clz(byte value) {
        return Integer.numberOfLeadingZeros(value) - 24;
    }

    @Override
    public int clz(short value) {
        return Integer.numberOfLeadingZeros(value) - 16;
    }

    @Override
    public int clz(int value) {
        return Integer.numberOfLeadingZeros(value);
    }

    @Override
    public int clz(long value) {
        return Long.numberOfLeadingZeros(value);
    }

    @Override
    public int clon(byte value) {
        return Integer.numberOfLeadingZeros(~value) - 24;
    }

    @Override
    public int clon(short value) {
        return Integer.numberOfLeadingZeros(~value) - 16;
    }

    @Override
    public int clon(int value) {
        return Integer.numberOfLeadingZeros(~value);
    }

    @Override
    public int clon(long value) {
        return Long.numberOfLeadingZeros(~value);
    }

    @Override
    public int ctz(byte value) {
        return Integer.numberOfTrailingZeros(value);
    }

    @Override
    public int ctz(short value) {
        return Integer.numberOfTrailingZeros(value);
    }

    @Override
    public int ctz(int value) {
        return Integer.numberOfTrailingZeros(value);
    }

    @Override
    public int ctz(long value) {
        return Long.numberOfTrailingZeros(value);
    }

    @Override
    public int cton(byte value) {
        return Integer.numberOfTrailingZeros(~value);
    }

    @Override
    public int cton(short value) {
        return Integer.numberOfTrailingZeros(~value);
    }

    @Override
    public int cton(int value) {
        return Integer.numberOfTrailingZeros(~value);
    }

    @Override
    public int cton(long value) {
        return Long.numberOfTrailingZeros(~value);
    }

    @Override
    public int bitCount(byte value) {
        return Integer.bitCount(value);
    }

    @Override
    public int bitCount(short value) {
        return Integer.bitCount(value);
    }

    @Override
    public int bitCount(int value) {
        return Integer.bitCount(value);
    }

    @Override
    public int bitCount(long value) {
        return Long.bitCount(value);
    }

    @Override
    public boolean isFinite(float value) {
        return Float.isFinite(value);
    }

    @Override
    public boolean isInfinite(float value) {
        return Float.isInfinite(value);
    }

    @Override
    public boolean isNaN(float value) {
        return Float.isNaN(value);
    }

    @Override
    public boolean isFinite(double value) {
        return Double.isFinite(value);
    }

    @Override
    public boolean isInfinite(double value) {
        return Double.isInfinite(value);
    }

    @Override
    public boolean isNaN(double value) {
        return Double.isNaN(value);
    }

    @Override
    public boolean isPowerOfTwo(byte value) {
        return value > 0 && (value & (value - 1)) == 0;
    }

    @Override
    public boolean isPowerOfTwo(short value) {
        return value > 0 && (value & (value - 1)) == 0;
    }

    @Override
    public boolean isPowerOfTwo(int value) {
        return value > 0 && (value & (value - 1)) == 0;
    }

    @Override
    public boolean isPowerOfTwo(long value) {
        return value > 0 && (value & (value - 1)) == 0;
    }

    @Override
    public boolean unsignedIsPowerOfTwo(byte value) {
        int iVal = value & 0xFF;
        return iVal != 0 && (iVal & (iVal - 1)) == 0;
    }

    @Override
    public boolean unsignedIsPowerOfTwo(short value) {
        int iVal = value & 0xFFFF;
        return iVal != 0 && (iVal & (iVal - 1)) == 0;
    }

    @Override
    public boolean unsignedIsPowerOfTwo(int value) {
        return value != 0 && (value & (value - 1)) == 0;
    }

    @Override
    public boolean unsignedIsPowerOfTwo(long value) {
        return value != 0 && (value & (value - 1)) == 0;
    }

    @Override
    public boolean isInteger(float value) {
        return value % 1 == 0;
    }

    @Override
    public boolean isInteger(double value) {
        return value % 1 == 0;
    }

    @Override
    public boolean absEqualsOne(byte value) {
        return value == 1 || value == -1;
    }

    @Override
    public boolean absEqualsOne(short value) {
        return value == 1 || value == -1;
    }

    @Override
    public boolean absEqualsOne(int value) {
        return value == 1 || value == -1;
    }

    @Override
    public boolean absEqualsOne(long value) {
        return value == 1 || value == -1;
    }

    @Override
    public boolean absEqualsOne(float value) {
        return (Float.floatToRawIntBits(value) & 0x7FFFFFFF) == 0x3F800000;
    }

    @Override
    public boolean absEqualsOne(double value) {
        return (Double.doubleToRawLongBits(value) & 0x7FFFFFFFFFFFFFFFL) == 0x3FF0000000000000L;
    }

    @Override
    public byte toByte(short value) {
        return (byte) value;
    }

    @Override
    public short toShort(int value) {
        return (short) value;
    }

    @Override
    public int toInt(long value) {
        return (int) value;
    }

    @Override
    public float toFloat(double value) {
        return (float) value;
    }

    @Override
    public byte toByteExact(short value) {
        if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) throw new ArithmeticException("byte overflow");
        return (byte) value;
    }

    @Override
    public short toShortExact(int value) {
        if (value < Short.MIN_VALUE || value > Short.MAX_VALUE) throw new ArithmeticException("short overflow");
        return (short) value;
    }

    @Override
    public int toIntExact(long value) {
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) throw new ArithmeticException("integer overflow");
        return (int) value;
    }

    @Override
    public float toFloatExact(double value) {
        float fVal = (float) value;
        if (Double.compare(fVal, value) != 0) throw new ArithmeticException("float overflow");
        return fVal;
    }

    @Override
    public byte unsignedToByteExact(short value) {
        if (value > 255) throw new ArithmeticException("byte overflow");
        return (byte) value;
    }

    @Override
    public short unsignedToShortExact(int value) {
        if (value > 65535) throw new ArithmeticException("short overflow");
        return (short) value;
    }

    @Override
    public int unsignedToIntExact(long value) {
        if (value > 4294967295L) throw new ArithmeticException("integer overflow");
        return (int) value;
    }

    @Override
    public short toUnsignedShort(byte value) {
        return (short) Byte.toUnsignedInt(value);
    }

    @Override
    public int toUnsignedInt(short value) {
        return Short.toUnsignedInt(value);
    }

    @Override
    public long toUnsignedLong(int value) {
        return Integer.toUnsignedLong(value);
    }

    @Override
    public int toIntBits(float value) {
        return Float.floatToIntBits(value);
    }

    @Override
    public int toRawIntBits(float value) {
        return Float.floatToRawIntBits(value);
    }

    @Override
    public long toLongBits(double value) {
        return Double.doubleToLongBits(value);
    }

    @Override
    public long toRawLongBits(double value) {
        return Double.doubleToRawLongBits(value);
    }

    @Override
    public float bitsToFloat(int bits) {
        return Float.intBitsToFloat(bits);
    }

    @Override
    public double bitsToDouble(long bits) {
        return Double.longBitsToDouble(bits);
    }

    @Override
    public byte compress(byte value, byte mask) {
        return (byte) Compress.compute(value & 0xFF, mask & 0xFF);
    }

    @Override
    public byte expand(byte value, byte mask) {
        return (byte) Expand.compute(value & 0xFF, mask & 0xFF);
    }

    @Override
    public short compress(short value, short mask) {
        return (short) Compress.compute(value & 0xFFFF, mask & 0xFFFF);
    }

    @Override
    public short expand(short value, short mask) {
        return (short) Expand.compute(value & 0xFFFF, mask & 0xFFFF);
    }

    private static final class Compress {
        private Compress() {
            throw new UnsupportedOperationException();
        }
        public static int compute(int value, int mask) {
            // See Hacker's Delight (2nd ed) section 7.4 Compress, or Generalized Extract

            value = value & mask; // Clear irrelevant bits
            int maskCount = ~mask << 1; // Count 0's to right

            for (int j = 0; j < 5; j++) {
                // Parallel prefix
                // Mask prefix identifies bits of the mask that have an odd number of 0's to the right
                int maskPrefix = maskCount ^ (maskCount << 1);
                maskPrefix = maskPrefix ^ (maskPrefix << 2);
                maskPrefix = maskPrefix ^ (maskPrefix << 4);
                maskPrefix = maskPrefix ^ (maskPrefix << 8);
                maskPrefix = maskPrefix ^ (maskPrefix << 16);
                // Bits to move
                int maskMove = maskPrefix & mask;
                // Compress mask
                mask = (mask ^ maskMove) | (maskMove >>> (1 << j));
                // Bits of value to be moved
                int t = value & maskMove;
                // Compress value
                value = (value ^ t) | (t >>> (1 << j));
                // Adjust the mask count by identifying bits that have 0 to the right
                maskCount = maskCount & ~maskPrefix;
            }
            return value;
        }
        public static long compute(long value, long mask) {
            // See Hacker's Delight (2nd ed) section 7.4 Compress, or Generalized Extract

            value = value & mask; // Clear irrelevant bits
            long maskCount = ~mask << 1; // Count 0's to right

            for (int j = 0; j < 6; j++) {
                // Parallel prefix
                // Mask prefix identifies bits of the mask that have an odd number of 0's to the right
                long maskPrefix = maskCount ^ (maskCount << 1);
                maskPrefix = maskPrefix ^ (maskPrefix << 2);
                maskPrefix = maskPrefix ^ (maskPrefix << 4);
                maskPrefix = maskPrefix ^ (maskPrefix << 8);
                maskPrefix = maskPrefix ^ (maskPrefix << 16);
                maskPrefix = maskPrefix ^ (maskPrefix << 32);
                // Bits to move
                long maskMove = maskPrefix & mask;
                // Compress mask
                mask = (mask ^ maskMove) | (maskMove >>> (1 << j));
                // Bits of value to be moved
                long t = value & maskMove;
                // Compress value
                value = (value ^ t) | (t >>> (1 << j));
                // Adjust the mask count by identifying bits that have 0 to the right
                maskCount = maskCount & ~maskPrefix;
            }
            return value;
        }
    }

    private static final class Expand {
        private Expand() {
            throw new UnsupportedOperationException();
        }
        public static int compute(int value, int mask) {
            // Save original mask
            int originalMask = mask;
            // Count 0's to right
            int maskCount = ~mask << 1;
            int maskPrefix = maskCount ^ (maskCount << 1);
            maskPrefix = maskPrefix ^ (maskPrefix << 2);
            maskPrefix = maskPrefix ^ (maskPrefix << 4);
            maskPrefix = maskPrefix ^ (maskPrefix << 8);
            maskPrefix = maskPrefix ^ (maskPrefix << 16);
            // Bits to move
            int maskMove1 = maskPrefix & mask;
            // Compress mask
            mask = (mask ^ maskMove1) | (maskMove1 >>> 1);
            maskCount = maskCount & ~maskPrefix;

            maskPrefix = maskCount ^ (maskCount << 1);
            maskPrefix = maskPrefix ^ (maskPrefix << 2);
            maskPrefix = maskPrefix ^ (maskPrefix << 4);
            maskPrefix = maskPrefix ^ (maskPrefix << 8);
            maskPrefix = maskPrefix ^ (maskPrefix << 16);
            // Bits to move
            int maskMove2 = maskPrefix & mask;
            // Compress mask
            mask = (mask ^ maskMove2) | (maskMove2 >>> (1 << 1));
            maskCount = maskCount & ~maskPrefix;

            maskPrefix = maskCount ^ (maskCount << 1);
            maskPrefix = maskPrefix ^ (maskPrefix << 2);
            maskPrefix = maskPrefix ^ (maskPrefix << 4);
            maskPrefix = maskPrefix ^ (maskPrefix << 8);
            maskPrefix = maskPrefix ^ (maskPrefix << 16);
            // Bits to move
            int maskMove3 = maskPrefix & mask;
            // Compress mask
            mask = (mask ^ maskMove3) | (maskMove3 >>> (1 << 2));
            maskCount = maskCount & ~maskPrefix;

            maskPrefix = maskCount ^ (maskCount << 1);
            maskPrefix = maskPrefix ^ (maskPrefix << 2);
            maskPrefix = maskPrefix ^ (maskPrefix << 4);
            maskPrefix = maskPrefix ^ (maskPrefix << 8);
            maskPrefix = maskPrefix ^ (maskPrefix << 16);
            // Bits to move
            int maskMove4 = maskPrefix & mask;
            // Compress mask
            mask = (mask ^ maskMove4) | (maskMove4 >>> (1 << 3));
            maskCount = maskCount & ~maskPrefix;

            maskPrefix = maskCount ^ (maskCount << 1);
            maskPrefix = maskPrefix ^ (maskPrefix << 2);
            maskPrefix = maskPrefix ^ (maskPrefix << 4);
            maskPrefix = maskPrefix ^ (maskPrefix << 8);
            maskPrefix = maskPrefix ^ (maskPrefix << 16);
            // Bits to move
            int maskMove5 = maskPrefix & mask;

            int t = value << (1 << 4);
            value = (value & ~maskMove5) | (t & maskMove5);
            t = value << (1 << 3);
            value = (value & ~maskMove4) | (t & maskMove4);
            t = value << (1 << 2);
            value = (value & ~maskMove3) | (t & maskMove3);
            t = value << (1 << 1);
            value = (value & ~maskMove2) | (t & maskMove2);
            t = value << 1;
            value = (value & ~maskMove1) | (t & maskMove1);

            // Clear irrelevant bits
            return value & originalMask;
        }
        public static long compute(long value, long mask) {
            // Save original mask
            long originalMask = mask;
            // Count 0's to right
            long maskCount = ~mask << 1;
            long maskPrefix = maskCount ^ (maskCount << 1);
            maskPrefix = maskPrefix ^ (maskPrefix << 2);
            maskPrefix = maskPrefix ^ (maskPrefix << 4);
            maskPrefix = maskPrefix ^ (maskPrefix << 8);
            maskPrefix = maskPrefix ^ (maskPrefix << 16);
            maskPrefix = maskPrefix ^ (maskPrefix << 32);
            // Bits to move
            long maskMove1 = maskPrefix & mask;
            // Compress mask
            mask = (mask ^ maskMove1) | (maskMove1 >>> 1);
            maskCount = maskCount & ~maskPrefix;

            maskPrefix = maskCount ^ (maskCount << 1);
            maskPrefix = maskPrefix ^ (maskPrefix << 2);
            maskPrefix = maskPrefix ^ (maskPrefix << 4);
            maskPrefix = maskPrefix ^ (maskPrefix << 8);
            maskPrefix = maskPrefix ^ (maskPrefix << 16);
            maskPrefix = maskPrefix ^ (maskPrefix << 32);
            // Bits to move
            long maskMove2 = maskPrefix & mask;
            // Compress mask
            mask = (mask ^ maskMove2) | (maskMove2 >>> (1 << 1));
            maskCount = maskCount & ~maskPrefix;

            maskPrefix = maskCount ^ (maskCount << 1);
            maskPrefix = maskPrefix ^ (maskPrefix << 2);
            maskPrefix = maskPrefix ^ (maskPrefix << 4);
            maskPrefix = maskPrefix ^ (maskPrefix << 8);
            maskPrefix = maskPrefix ^ (maskPrefix << 16);
            maskPrefix = maskPrefix ^ (maskPrefix << 32);
            // Bits to move
            long maskMove3 = maskPrefix & mask;
            // Compress mask
            mask = (mask ^ maskMove3) | (maskMove3 >>> (1 << 2));
            maskCount = maskCount & ~maskPrefix;

            maskPrefix = maskCount ^ (maskCount << 1);
            maskPrefix = maskPrefix ^ (maskPrefix << 2);
            maskPrefix = maskPrefix ^ (maskPrefix << 4);
            maskPrefix = maskPrefix ^ (maskPrefix << 8);
            maskPrefix = maskPrefix ^ (maskPrefix << 16);
            maskPrefix = maskPrefix ^ (maskPrefix << 32);
            // Bits to move
            long maskMove4 = maskPrefix & mask;
            // Compress mask
            mask = (mask ^ maskMove4) | (maskMove4 >>> (1 << 3));
            maskCount = maskCount & ~maskPrefix;

            maskPrefix = maskCount ^ (maskCount << 1);
            maskPrefix = maskPrefix ^ (maskPrefix << 2);
            maskPrefix = maskPrefix ^ (maskPrefix << 4);
            maskPrefix = maskPrefix ^ (maskPrefix << 8);
            maskPrefix = maskPrefix ^ (maskPrefix << 16);
            maskPrefix = maskPrefix ^ (maskPrefix << 32);
            // Bits to move
            long maskMove5 = maskPrefix & mask;
            // Compress mask
            mask = (mask ^ maskMove5) | (maskMove5 >>> (1 << 4));
            maskCount = maskCount & ~maskPrefix;

            maskPrefix = maskCount ^ (maskCount << 1);
            maskPrefix = maskPrefix ^ (maskPrefix << 2);
            maskPrefix = maskPrefix ^ (maskPrefix << 4);
            maskPrefix = maskPrefix ^ (maskPrefix << 8);
            maskPrefix = maskPrefix ^ (maskPrefix << 16);
            maskPrefix = maskPrefix ^ (maskPrefix << 32);
            // Bits to move
            long maskMove6 = maskPrefix & mask;

            long t = value << (1 << 5);
            value = (value & ~maskMove6) | (t & maskMove6);
            t = value << (1 << 4);
            value = (value & ~maskMove5) | (t & maskMove5);
            t = value << (1 << 3);
            value = (value & ~maskMove4) | (t & maskMove4);
            t = value << (1 << 2);
            value = (value & ~maskMove3) | (t & maskMove3);
            t = value << (1 << 1);
            value = (value & ~maskMove2) | (t & maskMove2);
            t = value << 1;
            value = (value & ~maskMove1) | (t & maskMove1);

            // Clear irrelevant bits
            return value & originalMask;
        }
    }

    @Override
    public int compress(int value, int mask) {
        return Compress.compute(value, mask);
    }

    @Override
    public int expand(int value, int mask) {
        return Expand.compute(value, mask);
    }

    @Override
    public long compress(long value, long mask) {
        return Compress.compute(value, mask);
    }

    @Override
    public long expand(long value, long mask) {
        return Expand.compute(value, mask);
    }

    @Override
    public int compare(boolean a, boolean b) {
        return Boolean.compare(a, b);
    }

    @Override
    public boolean logicalAnd(boolean a, boolean b) {
        return Boolean.logicalAnd(a, b);
    }

    @Override
    public boolean logicalOr(boolean a, boolean b) {
        return Boolean.logicalOr(a, b);
    }

    @Override
    public boolean logicalXor(boolean a, boolean b) {
        return Boolean.logicalXor(a, b);
    }

}
