package multiffi.math;

import multiffi.math.spi.MathProvider;

public final class BooleanMath {

    private BooleanMath() {
        throw new AssertionError("No multiffi.math.BooleanMath instances for you!");
    }
    
    private static final MathProvider IMPLEMENTATION = MathProvider.getImplementation();

    public static final boolean TRUE = Boolean.TRUE;
    public static final boolean FALSE = Boolean.FALSE;

    public static int compare(boolean a, boolean b) {
        return IMPLEMENTATION.compare(a, b);
    }

    public static boolean logicalAnd(boolean a, boolean b) {
        return IMPLEMENTATION.logicalAnd(a, b);
    }

    public static boolean logicalOr(boolean a, boolean b) {
        return IMPLEMENTATION.logicalOr(a, b);
    }

    public static boolean logicalXor(boolean a, boolean b) {
        return IMPLEMENTATION.logicalXor(a, b);
    }

}
