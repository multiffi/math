package io.github.multiffi.math;

import multiffi.math.spi.RandomProvider;

import java.util.Random;

public class AndroidRandomProvider extends RandomProvider {

    private static final class RandomHolder {
        private RandomHolder() {
            throw new UnsupportedOperationException();
        }
        public static final Random GENERATOR = new Random();
    }

    private static long boundedNextLong(Random random, long origin, long bound) {
        long r = random.nextLong();
        if (origin < bound) {
            // It's not case (1).
            final long n = bound - origin;
            final long m = n - 1;
            if ((n & m) == 0L) {
                // It is case (2): length of range is a power of 2.
                r = (r & m) + origin;
            } else if (n > 0L) {
                // It is case (3): need to reject over-represented candidates.
                /* This loop takes an unlovable form (but it works):
                   because the first candidate is already available,
                   we need a break-in-the-middle construction,
                   which is concisely but cryptically performed
                   within the while-condition of a body-less for loop. */
                for (long u = r >>> 1;            // ensure nonnegative
                     u + m - (r = u % n) < 0L;    // rejection check
                     u = random.nextLong() >>> 1) // retry
                    ;
                r += origin;
            }
            else {
                // It is case (4): length of range not representable as long.
                while (r < origin || r >= bound) r = random.nextLong();
            }
        }
        return r;
    }

    private static long boundedNextLong(Random random, long bound) {
        // Specialize boundedNextLong for origin == 0, bound > 0
        final long m = bound - 1;
        long r = random.nextLong();
        if ((bound & m) == 0L) {
            // The bound is a power of 2.
            r &= m;
        } else {
            // Must reject over-represented candidates
            /* This loop takes an unlovable form (but it works):
               because the first candidate is already available,
               we need a break-in-the-middle construction,
               which is concisely but cryptically performed
               within the while-condition of a body-less for loop. */
            for (long u = r >>> 1;
                 u + m - (r = u % bound) < 0L;
                 u = random.nextLong() >>> 1)
                ;
        }
        return r;
    }

    private static int boundedNextInt(Random random, int origin, int bound) {
        int r = random.nextInt();
        if (origin < bound) {
            // It's not case (1).
            final int n = bound - origin;
            final int m = n - 1;
            if ((n & m) == 0) {
                // It is case (2): length of range is a power of 2.
                r = (r & m) + origin;
            } else if (n > 0) {
                // It is case (3): need to reject over-represented candidates.
                for (int u = r >>> 1;
                     u + m - (r = u % n) < 0;
                     u = random.nextInt() >>> 1)
                    ;
                r += origin;
            }
            else {
                // It is case (4): length of range not representable as long.
                while (r < origin || r >= bound) r = random.nextInt();
            }
        }
        return r;
    }

    private static double boundedNextDouble(Random random, double origin, double bound) {
        double r = random.nextDouble();
        if (origin < bound) {
            if (bound - origin < Double.POSITIVE_INFINITY) {
                r = r * (bound - origin) + origin;
            } else {
                /* avoids overflow at the cost of 3 more multiplications */
                double halfOrigin = 0.5 * origin;
                r = (r * (0.5 * bound - halfOrigin) + halfOrigin) * 2.0;
            }
            if (r >= bound)  // may need to correct a rounding problem
                r = Math.nextDown(bound);
        }
        return r;
    }

    private static double boundedNextDouble(Random random, double bound) {
        // Specialize boundedNextDouble for origin == 0, bound > 0
        double r = random.nextDouble();
        r = r * bound;
        if (r >= bound)  // may need to correct a rounding problem
            r = Math.nextDown(bound);
        return r;
    }

    private static float boundedNextFloat(Random random, float origin, float bound) {
        float r = random.nextFloat();
        if (origin < bound) {
            if (bound - origin < Float.POSITIVE_INFINITY) {
                r = r * (bound - origin) + origin;
            } else {
                /* avoids overflow at the cost of 3 more multiplications */
                float halfOrigin = 0.5f * origin;
                r = (r * (0.5f * bound - halfOrigin) + halfOrigin) * 2.0f;
            }
            if (r >= bound) // may need to correct a rounding problem
                r = Math.nextDown(bound);
        }
        return r;
    }

    private static float boundedNextFloat(Random random, float bound) {
        // Specialize boundedNextFloat for origin == 0, bound > 0
        float r = random.nextFloat();
        r = r * bound;
        if (r >= bound) // may need to correct a rounding problem
            r = Math.nextDown(bound);
        return r;
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
        if (!(0.0f < bound && bound < Float.POSITIVE_INFINITY)) throw new IllegalArgumentException("bound must be finite and positive");
        return boundedNextFloat(random, bound);
    }

    @Override
    public float nextFloat(Random random, float origin, float bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        if (!(Float.NEGATIVE_INFINITY < origin && origin < bound && bound < Float.POSITIVE_INFINITY))
            throw new IllegalArgumentException("bound must be greater than origin");
        return boundedNextFloat(random, origin, bound);
    }

    @Override
    public float nextFloat(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextFloat();
    }

    @Override
    public double nextDouble(Random random, double bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        if (!(0.0 < bound && bound < Double.POSITIVE_INFINITY)) throw new IllegalArgumentException("bound must be finite and positive");
        return boundedNextDouble(random, bound);
    }

    @Override
    public double nextDouble(Random random, double origin, double bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        if (!(Double.NEGATIVE_INFINITY < origin && origin < bound && bound < Double.POSITIVE_INFINITY))
            throw new IllegalArgumentException("bound must be greater than origin");
        return boundedNextDouble(random, origin, bound);
    }

    @Override
    public double nextDouble(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextDouble();
    }

    @Override
    public byte nextByte(Random random, byte bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        if (bound <= 0) throw new IllegalArgumentException("bound must be positive");
        return (byte) random.nextInt(bound);
    }

    @Override
    public byte nextByte(Random random, byte origin, byte bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        if (origin >= bound) throw new IllegalArgumentException("bound must be greater than origin");
        return (byte) boundedNextInt(random, origin, bound);
    }

    @Override
    public byte nextByte(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return (byte) boundedNextInt(random, -128, 128);
    }

    @Override
    public short nextShort(Random random, short bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        if (bound <= 0) throw new IllegalArgumentException("bound must be positive");
        return (short) random.nextInt(bound);
    }

    @Override
    public short nextShort(Random random, short origin, short bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        if (origin >= bound) throw new IllegalArgumentException("bound must be greater than origin");
        return (short) boundedNextInt(random, origin, bound);
    }

    @Override
    public short nextShort(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return (short) boundedNextInt(random, -32768, 32768);
    }

    @Override
    public int nextInt(Random random, int bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        if (bound <= 0) throw new IllegalArgumentException("bound must be positive");
        return random.nextInt(bound);
    }

    @Override
    public int nextInt(Random random, int origin, int bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        if (origin >= bound) throw new IllegalArgumentException("bound must be greater than origin");
        return boundedNextInt(random, origin, bound);
    }

    @Override
    public int nextInt(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return random.nextInt();
    }

    @Override
    public long nextLong(Random random, long bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        if (bound <= 0) throw new IllegalArgumentException("bound must be positive");
        return boundedNextLong(random, bound);
    }

    @Override
    public long nextLong(Random random, long origin, long bound) {
        if (random == null) random = RandomHolder.GENERATOR;
        if (origin >= bound) throw new IllegalArgumentException("bound must be greater than origin");
        return boundedNextLong(random, origin, bound);
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
        if (stddev < 0.0) throw new IllegalArgumentException("standard deviation must be non-negative");
        return mean + stddev * random.nextGaussian();
    }

    private static final double MAX_EXPONENTIAL = 0x1.0p63 * DoubleZigguratTables.exponentialX0;
    public static double computeNextExponential(Random random) {
        /*
         * The tables themselves, as well as a number of associated parameters, are
         * defined in class DoubleZigguratTables, which is automatically
         * generated by the program create_ziggurat_tables.c (which takes only a
         * few seconds to run).
         *
         * For more information about the algorithm, see these articles:
         *
         * Christopher D. McFarland.  2016 (published online 24 Jun 2015).  A modified ziggurat
         * algorithm for generating exponentially and normally distributed pseudorandom numbers.
         * Journal of Statistical Computation and Simulation 86 (7), pages 1281-1294.
         * https://www.tandfonline.com/doi/abs/10.1080/00949655.2015.1060234
         * Also at https://arxiv.org/abs/1403.6870 (26 March 2014).
         *
         * Alastair J. Walker.  1977.  An efficient method for generating discrete random
         * variables with general distributions. ACM Trans. Math. Software 3, 3
         * (September 1977), 253-256. DOI: https://doi.org/10.1145/355744.355749
         *
         */
        long U1 = random.nextLong();
        // Experimentation on a variety of machines indicates that it is overall much faster
        // to do the following & and < operations on longs rather than first cast U1 to int
        // (but then we need to cast to int before doing the array indexing operation).
        long i = U1 & DoubleZigguratTables.exponentialLayerMask;
        if (i < DoubleZigguratTables.exponentialNumberOfLayers) {
            // This is the fast path (occurring more than 98% of the time).  Make an early exit.
            return DoubleZigguratTables.exponentialX[(int)i] * (U1 >>> 1);
        }
        // We didn't use the upper part of U1 after all.  We'll probably be able to use it later.
        final long maxExtraMinus1 = Long.MAX_VALUE;
        for (long extra = 0; ; ) {
            // Use Walker's alias method to sample an (unsigned) integer j from a discrete
            // probability distribution that includes the tail and all the ziggurat overhangs;
            // j will be less than DoubleZigguratTables.exponentialNumberOfLayers + 1.
            long UA = random.nextLong();
            int j = (int)UA & DoubleZigguratTables.exponentialAliasMask;
            if (UA >= DoubleZigguratTables.exponentialAliasThreshold[j]) {
                j = DoubleZigguratTables.exponentialAliasMap[j] &
                        DoubleZigguratTables.exponentialSignCorrectionMask;
            }
            if (j > 0) {   // Sample overhang j
                // For the exponential distribution, every overhang is convex.
                final double[] X = DoubleZigguratTables.exponentialX;
                final double[] Y = DoubleZigguratTables.exponentialY;
                // At this point, the high-order bits of U1 have not been used yet,
                // but we need the value in U1 to be positive.
                for (U1 = (U1 >>> 1);; U1 = (random.nextLong() >>> 1)) {
                    long U2 = (random.nextLong() >>> 1);
                    // Does the point lie below the curve?
                    long Udiff = U2 - U1;
                    if (Udiff < 0) {
                        // We picked a point in the upper-right triangle.  None of those can be
                        // accepted.  So remap the point into the lower-left triangle and try that.
                        // In effect, we swap U1 and U2, and invert the sign of Udiff.
                        Udiff = -Udiff;
                        U2 = U1;
                        U1 -= Udiff;
                    }
                    // Compute the actual x-coordinate of the randomly chosen point.
                    double x = (X[j] * 0x1.0p63) + ((X[j-1] - X[j]) * (double)U1);
                    if (Udiff >= DoubleZigguratTables.exponentialConvexMargin) {
                        return AndroidMathProvider.FusedMultiplyAdd.compute(extra, DoubleZigguratTables.exponentialX0, x);   // The chosen point is way below the curve; accept it.
                    }
                    // Compute the actual y-coordinate of the randomly chosen point.
                    double y = (Y[j] * 0x1.0p63) + ((Y[j-1] - Y[j]) * (double)U2);
                    // Now see how that y-coordinate compares to the curve
                    if (y <= Math.exp(-x)) {
                        return AndroidMathProvider.FusedMultiplyAdd.compute(extra, DoubleZigguratTables.exponentialX0, x);   // The chosen point is below the curve; accept it.
                    }
                    // Otherwise, we reject this sample and have to try again.
                }
            }
            if (extra == maxExtraMinus1) {
                // We've reached the maximum, so don't waste any more time
                return MAX_EXPONENTIAL;
            }
            // We are now committed to sampling from the tail.  We could do a recursive call
            // and then add X[0], but we save some time and stack space by using an iterative loop.
            extra++;
            // This is like the first five lines of this method, but if it returns, it first adds "extra" times X0.
            U1 = random.nextLong();
            i = U1 & DoubleZigguratTables.exponentialLayerMask;
            if (i < DoubleZigguratTables.exponentialNumberOfLayers) {
                return AndroidMathProvider.FusedMultiplyAdd.compute(extra, DoubleZigguratTables.exponentialX0, DoubleZigguratTables.exponentialX[(int)i] * (U1 >>> 1));
            }
        }
    }

    private static final class DoubleZigguratTables {

        public static final int exponentialNumberOfLayers = 252;
        public static final int exponentialLayerMask = 0xff;
        public static final int exponentialAliasMask = 0xff;
        public static final int exponentialSignCorrectionMask = 0xff;
        public static final double exponentialX0 = 7.56927469414806264;
        public static final long exponentialConvexMargin = 853965788476313645L;   // unscaled convex margin = 0.0926

        // exponential_X[i] = length of ziggurat layer i for exponential distribution, scaled by 2**(-63)
        public static final double[] exponentialX = {      // 253 entries, which is exponential_number_of_layers+1
                8.2066240675348816e-19,  7.3973732351607284e-19,  6.9133313377915293e-19,  6.5647358820964533e-19,
                6.2912539959818508e-19,  6.0657224129604964e-19,  5.8735276103737269e-19,  5.7058850528536941e-19,
                5.5570945691622390e-19,  5.4232438903743953e-19,  5.3015297696508776e-19,  5.1898739257708062e-19,
                5.0866922617998330e-19,  4.9907492938796469e-19,  4.9010625894449536e-19,  4.8168379010649187e-19,
                4.7374238653644714e-19,  4.6622795807196824e-19,  4.5909509017784048e-19,  4.5230527790658154e-19,
                4.4582558816353960e-19,  4.3962763126368381e-19,  4.3368675967106470e-19,  4.2798143618469714e-19,
                4.2249273027064889e-19,  4.1720391253464110e-19,  4.1210012522465616e-19,  4.0716811225869233e-19,
                4.0239599631006903e-19,  3.9777309342877357e-19,  3.9328975785334499e-19,  3.8893725129310323e-19,
                3.8470763218720385e-19,  3.8059366138180143e-19,  3.7658872138544730e-19,  3.7268674692030177e-19,
                3.6888216492248162e-19,  3.6516984248800068e-19,  3.6154504153287473e-19,  3.5800337915318032e-19,
                3.5454079284533432e-19,  3.5115350988784242e-19,  3.4783802030030962e-19,  3.4459105288907336e-19,
                3.4140955396563316e-19,  3.3829066838741162e-19,  3.3523172262289001e-19,  3.3223020958685874e-19,
                3.2928377502804472e-19,  3.2639020528202049e-19,  3.2354741622810815e-19,  3.2075344331080789e-19,
                3.1800643250478609e-19,  3.1530463211820845e-19,  3.1264638534265134e-19,  3.1003012346934211e-19,
                3.0745435970137301e-19,  3.0491768350005559e-19,  3.0241875541094565e-19,  2.9995630232144550e-19,
                2.9752911310742592e-19,  2.9513603463113224e-19,  2.9277596805684267e-19,  2.9044786545442563e-19,
                2.8815072666416712e-19,  2.8588359639906928e-19,  2.8364556156331615e-19,  2.8143574876779799e-19,
                2.7925332202553125e-19,  2.7709748061152879e-19,  2.7496745707320232e-19,  2.7286251537873397e-19,
                2.7078194919206054e-19,  2.6872508026419050e-19,  2.6669125693153442e-19,  2.6467985271278891e-19,
                2.6269026499668434e-19,  2.6072191381359757e-19,  2.5877424068465143e-19,  2.5684670754248168e-19,
                2.5493879571835479e-19,  2.5305000499077481e-19,  2.5117985269112710e-19,  2.4932787286227806e-19,
                2.4749361546638660e-19,  2.4567664563848669e-19,  2.4387654298267842e-19,  2.4209290090801527e-19,
                2.4032532600140538e-19,  2.3857343743505147e-19,  2.3683686640614648e-19,  2.3511525560671253e-19,
                2.3340825872163284e-19,  2.3171553995306794e-19,  2.3003677356958333e-19,  2.2837164347843482e-19,
                2.2671984281957174e-19,  2.2508107358001938e-19,  2.2345504622739592e-19,  2.2184147936140775e-19,
                2.2024009938224424e-19,  2.1865064017486842e-19,  2.1707284280826716e-19,  2.1550645524878675e-19,
                2.1395123208673778e-19,  2.1240693427550640e-19,  2.1087332888245875e-19,  2.0935018885097035e-19,
                2.0783729277295508e-19,  2.0633442467130712e-19,  2.0484137379170616e-19,  2.0335793440326865e-19,
                2.0188390560756090e-19,  2.0041909115551697e-19,  1.9896329927183254e-19,  1.9751634248643090e-19,
                1.9607803747261946e-19,  1.9464820489157862e-19,  1.9322666924284314e-19,  1.9181325872045647e-19,
                1.9040780507449479e-19,  1.8901014347767504e-19,  1.8762011239677479e-19,  1.8623755346860768e-19,
                1.8486231138030984e-19,  1.8349423375370566e-19,  1.8213317103353295e-19,  1.8077897637931708e-19,
                1.7943150556069476e-19,  1.7809061685599652e-19,  1.7675617095390567e-19,  1.7542803085801941e-19,
                1.7410606179414531e-19,  1.7279013112017240e-19,  1.7148010823836362e-19,  1.7017586450992059e-19,
                1.6887727317167824e-19,  1.6758420925479093e-19,  1.6629654950527621e-19,  1.6501417230628659e-19,
                1.6373695760198277e-19,  1.6246478682288560e-19,  1.6119754281258616e-19,  1.5993510975569615e-19,
                1.5867737310692309e-19,  1.5742421952115544e-19,  1.5617553678444595e-19,  1.5493121374578016e-19,
                1.5369114024951992e-19,  1.5245520706841019e-19,  1.5122330583703858e-19,  1.4999532898563561e-19,
                1.4877116967410352e-19,  1.4755072172615974e-19,  1.4633387956347966e-19,  1.4512053813972103e-19,
                1.4391059287430991e-19,  1.4270393958586506e-19,  1.4150047442513381e-19,  1.4030009380730888e-19,
                1.3910269434359025e-19,  1.3790817277185197e-19,  1.3671642588626657e-19,  1.3552735046573446e-19,
                1.3434084320095729e-19,  1.3315680061998685e-19,  1.3197511901207148e-19,  1.3079569434961214e-19,
                1.2961842220802957e-19,  1.2844319768333099e-19,  1.2726991530715219e-19,  1.2609846895903523e-19,
                1.2492875177568625e-19,  1.2376065605693940e-19,  1.2259407316813331e-19,  1.2142889343858445e-19,
                1.2026500605581765e-19,  1.1910229895518744e-19,  1.1794065870449425e-19,  1.1677997038316715e-19,
                1.1562011745554883e-19,  1.1446098163777869e-19,  1.1330244275772562e-19,  1.1214437860737343e-19,
                1.1098666478700728e-19,  1.0982917454048923e-19,  1.0867177858084351e-19,  1.0751434490529747e-19,
                1.0635673859884002e-19,  1.0519882162526621e-19,  1.0404045260457141e-19,  1.0288148657544097e-19,
                1.0172177474144965e-19,  1.0056116419943559e-19,  9.9399497648346677e-20,  9.8236613076667446e-20,
                9.7072343426320094e-20,  9.5906516230690634e-20,  9.4738953224154196e-20,  9.3569469920159036e-20,
                9.2397875154569468e-20,  9.1223970590556472e-20,  9.0047550180852874e-20,  8.8868399582647627e-20,
                8.7686295519767450e-20,  8.6501005086071005e-20,  8.5312284983141187e-20,  8.4119880684385214e-20,
                8.2923525516513420e-20,  8.1722939648034506e-20,  8.0517828972839211e-20,  7.9307883875099226e-20,
                7.8092777859524425e-20,  7.6872166028429042e-20,  7.5645683383965122e-20,  7.4412942930179128e-20,
                7.3173533545093332e-20,  7.1927017587631075e-20,  7.0672928197666785e-20,  6.9410766239500362e-20,
                6.8139996829256425e-20,  6.6860045374610234e-20,  6.5570293040210081e-20,  6.4270071533368528e-20,
                6.2958657080923559e-20,  6.1635263438143136e-20,  6.0299033732151700e-20,  5.8949030892850181e-20,
                5.7584226359885930e-20,  5.6203486669597397e-20,  5.4805557413499315e-20,  5.3389043909003295e-20,
                5.1952387717989917e-20,  5.0493837866338355e-20,  4.9011415222629489e-20,  4.7502867933366117e-20,
                4.5965615001265455e-20,  4.4396673897997565e-20,  4.2792566302148588e-20,  4.1149193273430015e-20,
                3.9461666762606287e-20,  3.7724077131401685e-20,  3.5929164086204360e-20,  3.4067836691100565e-20,
                3.2128447641564046e-20,  3.0095646916399994e-20,  2.7948469455598328e-20,  2.5656913048718645e-20,
                2.3175209756803909e-20,  2.0426695228251291e-20,  1.7261770330213485e-20,  1.3281889259442578e-20,
                0.0000000000000000e+00 };

        // exponential_Y[i] = value of the exponential distribution function at exponential_X[i], scaled by 2**(-63)
        public static final double[] exponentialY = {      // 253 entries, which is exponential_number_of_layers+1
                5.5952054951127360e-23,  1.1802509982703313e-22,  1.8444423386735829e-22,  2.5439030466698309e-22,
                3.2737694311509334e-22,  4.0307732132706715e-22,  4.8125478319495115e-22,  5.6172914896583308e-22,
                6.4435820540443526e-22,  7.2902662343463681e-22,  8.1563888456321941e-22,  9.0411453683482223e-22,
                9.9438488486399206e-22,  1.0863906045969114e-21,  1.1800799775461269e-21,  1.2754075534831208e-21,
                1.3723331176377290e-21,  1.4708208794375214e-21,  1.5708388257440445e-21,  1.6723581984374566e-21,
                1.7753530675030514e-21,  1.8797999785104595e-21,  1.9856776587832504e-21,  2.0929667704053244e-21,
                2.2016497009958240e-21,  2.3117103852306179e-21,  2.4231341516125464e-21,  2.5359075901420891e-21,
                2.6500184374170538e-21,  2.7654554763660391e-21,  2.8822084483468604e-21,  3.0002679757547711e-21,
                3.1196254936130377e-21,  3.2402731888801749e-21,  3.3622039464187092e-21,  3.4854113007409036e-21,
                3.6098893927859475e-21,  3.7356329310971768e-21,  3.8626371568620053e-21,  3.9908978123552837e-21,
                4.1204111123918948e-21,  4.2511737184488913e-21,  4.3831827151633737e-21,  4.5164355889510656e-21,
                4.6509302085234806e-21,  4.7866648071096003e-21,  4.9236379662119969e-21,  5.0618486007478993e-21,
                5.2012959454434732e-21,  5.3419795423648946e-21,  5.4838992294830959e-21,  5.6270551301806347e-21,
                5.7714476436191935e-21,  5.9170774358950678e-21,  6.0639454319177027e-21,  6.2120528079531677e-21,
                6.3614009847804375e-21,  6.5119916214136427e-21,  6.6638266093481696e-21,  6.8169080672926277e-21,
                6.9712383363524377e-21,  7.1268199756340822e-21,  7.2836557582420336e-21,  7.4417486676430174e-21,
                7.6011018943746355e-21,  7.7617188330775411e-21,  7.9236030798322572e-21,  8.0867584297834842e-21,
                8.2511888750363333e-21,  8.4168986028103258e-21,  8.5838919938383098e-21,  8.7521736209986459e-21,
                8.9217482481700712e-21,  9.0926208292996504e-21,  9.2647965076751277e-21,  9.4382806153938292e-21,
                9.6130786730210328e-21,  9.7891963894314161e-21,  9.9666396618278840e-21,  1.0145414575932636e-20,
                1.0325527406345955e-20,  1.0506984617068672e-20,  1.0689792862184811e-20,  1.0873958986701341e-20,
                1.1059490027542400e-20,  1.1246393214695825e-20,  1.1434675972510121e-20,  1.1624345921140471e-20,
                1.1815410878142659e-20,  1.2007878860214202e-20,  1.2201758085082226e-20,  1.2397056973538040e-20,
                1.2593784151618565e-20,  1.2791948452935152e-20,  1.2991558921150600e-20,  1.3192624812605428e-20,
                1.3395155599094805e-20,  1.3599160970797774e-20,  1.3804650839360727e-20,  1.4011635341137284e-20,
                1.4220124840587164e-20,  1.4430129933836705e-20,  1.4641661452404201e-20,  1.4854730467093280e-20,
                1.5069348292058084e-20,  1.5285526489044050e-20,  1.5503276871808626e-20,  1.5722611510726402e-20,
                1.5943542737583543e-20,  1.6166083150566702e-20,  1.6390245619451956e-20,  1.6616043290999594e-20,
                1.6843489594561079e-20,  1.7072598247904713e-20,  1.7303383263267072e-20,  1.7535858953637607e-20,
                1.7770039939284241e-20,  1.8005941154528286e-20,  1.8243577854777398e-20,  1.8482965623825808e-20,
                1.8724120381431627e-20,  1.8967058391181452e-20,  1.9211796268653192e-20,  1.9458350989888484e-20,
                1.9706739900186868e-20,  1.9956980723234356e-20,  2.0209091570579904e-20,  2.0463090951473895e-20,
                2.0718997783083593e-20,  2.0976831401101350e-20,  2.1236611570762130e-20,  2.1498358498287976e-20,
                2.1762092842777868e-20,  2.2027835728562592e-20,  2.2295608758045219e-20,  2.2565434025049041e-20,
                2.2837334128696004e-20,  2.3111332187840010e-20,  2.3387451856080863e-20,  2.3665717337386111e-20,
                2.3946153402349610e-20,  2.4228785405117410e-20,  2.4513639301013211e-20,  2.4800741664897764e-20,
                2.5090119710298442e-20,  2.5381801309347597e-20,  2.5675815013570500e-20,  2.5972190075566336e-20,
                2.6270956471628253e-20,  2.6572144925351523e-20,  2.6875786932281841e-20,  2.7181914785659148e-20,
                2.7490561603315974e-20,  2.7801761355793055e-20,  2.8115548895739172e-20,  2.8431959988666534e-20,
                2.8751031345137833e-20,  2.9072800654466307e-20,  2.9397306620015486e-20,  2.9724588996191657e-20,
                3.0054688627228112e-20,  3.0387647487867642e-20,  3.0723508726057078e-20,  3.1062316707775905e-20,
                3.1404117064129991e-20,  3.1748956740850969e-20,  3.2096884050352357e-20,  3.2447948726504914e-20,
                3.2802201982306013e-20,  3.3159696570631373e-20,  3.3520486848272230e-20,  3.3884628843476888e-20,
                3.4252180327233346e-20,  3.4623200888548644e-20,  3.4997752014001677e-20,  3.5375897171869060e-20,
                3.5757701901149035e-20,  3.6143233905835799e-20,  3.6532563154827400e-20,  3.6925761987883572e-20,
                3.7322905228086981e-20,  3.7724070301302117e-20,  3.8129337363171041e-20,  3.8538789434235234e-20,
                3.8952512543827862e-20,  3.9370595883442399e-20,  3.9793131970351439e-20,  4.0220216822325769e-20,
                4.0651950144388133e-20,  4.1088435528630944e-20,  4.1529780668232712e-20,  4.1976097586926582e-20,
                4.2427502885307452e-20,  4.2884118005513604e-20,  4.3346069515987453e-20,  4.3813489418210257e-20,
                4.4286515477520838e-20,  4.4765291580372353e-20,  4.5249968120658306e-20,  4.5740702418054417e-20,
                4.6237659171683015e-20,  4.6741010952818368e-20,  4.7250938740823415e-20,  4.7767632507051219e-20,
                4.8291291852069895e-20,  4.8822126702292804e-20,  4.9360358072933852e-20,  4.9906218905182021e-20,
                5.0459954986625539e-20,  5.1021825965285324e-20,  5.1592106469178258e-20,  5.2171087345169234e-20,
                5.2759077033045284e-20,  5.3356403093325858e-20,  5.3963413910399511e-20,  5.4580480596259246e-20,
                5.5207999124535584e-20,  5.5846392729873830e-20,  5.6496114614193770e-20,  5.7157651009290713e-20,
                5.7831524654956632e-20,  5.8518298763794323e-20,  5.9218581558791713e-20,  5.9933031488338700e-20,
                6.0662363246796887e-20,  6.1407354758435000e-20,  6.2168855320499763e-20,  6.2947795150103727e-20,
                6.3745196643214394e-20,  6.4562187737537985e-20,  6.5400017881889097e-20,  6.6260077263309343e-20,
                6.7143920145146620e-20,  6.8053293447301698e-20,  6.8990172088133000e-20,  6.9956803158564498e-20,
                7.0955761794878430e-20,  7.1990022788945080e-20,  7.3063053739105458e-20,  7.4178938266266893e-20,
                7.5342542134173124e-20,  7.6559742171142969e-20,  7.7837749863412850e-20,  7.9185582674029512e-20,
                8.0614775537353300e-20,  8.2140502769818073e-20,  8.3783445978280519e-20,  8.5573129249678161e-20,
                8.7554459669590100e-20,  8.9802388057706877e-20,  9.2462471421151086e-20,  9.5919641344951721e-20,
                1.0842021724855044e-19 };

        // alias_threshold[j] is a threshold for the probability mass function that has been
        // scaled by (2**64 - 1), translated by -(2**63), and represented as a long value;
        // in this way it can be directly compared to a randomly chosen long value.
        public static final long[] exponentialAliasThreshold = {    // 256 entries
                9223372036854775807L,  1623796909450829958L,  2664290944894281002L,  7387971354164055035L,
                6515064486552722205L,  8840508362680707094L,  6099647593382923818L,  7673130333659514446L,
                6220332867583438718L,  5045979640552814279L,  4075305837223956071L,  3258413672162525964L,
                2560664887087763045L,  1957224924672900129L,  1429800935350578000L,   964606309710808688L,
                551043923599587587L,   180827629096889062L,  -152619738120023316L,  -454588624410291246L,
                -729385126147774679L,  -980551509819444511L, -1211029700667463575L, -1423284293868546830L,
                -1619396356369066372L, -1801135830956194794L, -1970018048575634032L, -2127348289059688469L,
                -2274257249303687482L, -2411729520096654942L, -2540626634159182211L, -2661705860113406183L,
                -2775635634532464842L, -2883008316030448462L, -2984350790383654449L, -3080133339198118132L,
                -3170777096303105047L, -3256660348483802362L, -3338123885075135933L, -3415475560473298752L,
                -3488994201966444258L, -3558932970354456420L, -3625522261068040742L, -3688972217741991689L,
                -3749474917563779627L, -3807206277531072172L, -3862327722496826830L, -3914987649156779312L,
                -3965322714631864882L, -4013458973776911635L, -4059512885612766613L, -4103592206186240662L,
                -4145796782586127736L, -4186219260694346585L, -4224945717447274810L, -4262056226866285147L,
                -4297625367836519229L, -4331722680528536958L, -4364413077437472159L, -4395757214229421760L,
                -4425811824915119137L, -4454630025296932322L, -4482261588141294467L, -4508753193105275908L,
                -4534148654077813412L, -4558489126279965349L, -4581813295192216486L, -4604157549138252679L,
                -4625556137145250151L, -4646041313519109096L, -4665643470413305673L, -4684391259530342697L,
                -4702311703971745066L, -4719430301145102986L, -4735771117539946027L, -4751356876102086987L,
                -4766209036859150188L, -4780347871385996716L, -4793792531638885869L, -4806561113635132333L,
                -4818670716409312334L, -4830137496634465358L, -4840976719260854030L, -4851202804490332239L,
                -4860829371376476047L, -4869869278311650511L, -4878334660640770576L, -4886236965617426832L,
                -4893586984900802224L, -4900394884772702384L, -4906670234238884945L, -4912422031164489009L,
                -4917658726580135697L, -4922388247283531793L, -4926618016851042065L, -4930354975163351025L,
                -4933605596540650674L, -4936375906575303186L, -4938671497741357106L, -4940497543854583186L,
                -4941858813449628882L, -4942759682136114354L, -4943204143989086194L, -4943195822025527282L,
                -4942737977813222130L, -4941833520255011698L, -4940485013586759090L, -4938694684624342322L,
                -4936464429291795314L, -4933795818458824946L, -4930690103114057265L, -4927148218896863345L,
                -4923170790008291569L, -4918758132519196401L, -4913910257091661489L, -4908626871126522161L,
                -4902907380349538608L, -4896750889844272240L, -4890156204540530416L, -4883121829162570096L,
                -4875645967641780528L, -4867726521994909999L, -4859361090668119087L, -4850546966345102383L,
                -4841281133215538414L, -4831560263698491374L, -4821380714613452974L, -4810738522790065581L,
                -4799629400105481389L, -4788048727936296621L, -4775991551010524588L, -4763452570642113772L,
                -4750426137329493931L, -4736906242696388587L, -4722886510751367403L, -4708360188440104938L,
                -4693320135461420394L, -4677758813316098089L, -4661668273553495721L, -4645040145179234152L,
                -4627865621182771687L, -4610135444140936871L, -4591839890849352486L, -4572968755929944934L,
                -4553511334358213029L, -4533456402849109028L, -4512792200036270244L, -4491506405372580067L,
                -4469586116675401954L, -4447017826233099938L, -4423787395382284961L, -4399880027458416864L,
                -4375280239014124063L, -4349971829190464606L, -4323937847117722654L, -4297160557210942813L,
                -4269621402214950684L, -4241300963840750107L, -4212178920821854874L, -4182234004204445017L,
                -4151443949668869272L, -4119785446662323159L, -4087234084103169942L, -4053764292396165205L,
                -4019349281473092435L, -3983960974549686930L, -3947569937258414993L, -3910145301787337104L,
                -3871654685619049615L, -3832064104425389837L, -3791337878631529676L, -3749438533114328651L,
                -3706326689447979465L, -3661960950051859912L, -3616297773528542022L, -3569291340409179909L,
                -3520893408440947267L, -3471053156460649921L, -3419717015797783872L, -3366828488034801534L,
                -3312327947826461820L, -3256152429334023226L, -3198235394669709240L, -3138506482563174262L,
                -3076891235255164340L, -3013310801389715890L, -2947681612411392816L, -2879915029671670702L,
                -2809916959107519276L, -2737587429961855017L, -2662820133571332903L, -2585501917733374884L,
                -2505512231579392929L, -2422722515205190175L, -2336995527534106140L, -2248184604988712345L,
                -2156132842510782614L, -2060672187261016979L, -1961622433929380112L, -1858790108950090508L,
                -1751967229002904073L, -1640929916937134981L, -1525436855617591297L, -1405227557075245821L,
                -1280020420662651897L, -1149510549536605301L, -1013367289578706928L,  -871231448632089708L,
                -722712146453677415L,  -567383236774421729L,  -404779231966956764L,  -234390647591531478L,
                -55658667960121553L,   132030985907831093L,   329355128892817467L,   537061298001091010L,
                755977262693561929L,   987022116608030929L,  1231219266829437401L,  1489711711346524770L,
                1763780090187559275L,  2054864117341782772L,  2364588157623782527L,  2694791916990482441L,
                3047567482883491349L,  3425304305830820514L,  3830744187097285423L,  4267048975685836605L,
                4737884547990014029L,  5247525842199011422L,  5800989391535342064L,  6404202162993303300L,
                7064218894258526746L,  7789505049452354354L,  8590309807749425484L,  7643763810684501605L,
                8891950541491453167L,  5457384281016234818L,  9083704440929285914L,  7976211653914461751L,
                8178631350487124609L,  2821287825726757492L,  6322989683301736617L,  4309503753387630347L,
                4685170734960191673L,  8404845967535252693L,  7330522972447610419L,  1960945799077061994L,
                4742910674644933674L,  -751799822533438695L,  7023456603742021660L,  3843116882594755262L,
                3927231442413889375L, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L };

        public static final byte[] exponentialAliasMap = {    // 256 entries
                (byte)  0, (byte)  0, (byte)  1, (byte)235, (byte)  3, (byte)  4, (byte)  5, (byte)  0,
                (byte)  0, (byte)  0, (byte)  0, (byte)  0, (byte)  0, (byte)  0, (byte)  0, (byte)  0,
                (byte)  0, (byte)  0, (byte)  1, (byte)  1, (byte)  1, (byte)  1, (byte)  2, (byte)  2,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252, (byte)252,
                (byte)252, (byte)251, (byte)251, (byte)251, (byte)251, (byte)251, (byte)251, (byte)251,
                (byte)251, (byte)251, (byte)251, (byte)251, (byte)251, (byte)251, (byte)250, (byte)250,
                (byte)250, (byte)250, (byte)250, (byte)250, (byte)250, (byte)249, (byte)249, (byte)249,
                (byte)249, (byte)249, (byte)249, (byte)248, (byte)248, (byte)248, (byte)248, (byte)247,
                (byte)247, (byte)247, (byte)247, (byte)246, (byte)246, (byte)246, (byte)245, (byte)245,
                (byte)244, (byte)244, (byte)243, (byte)243, (byte)242, (byte)241, (byte)241, (byte)240,
                (byte)239, (byte)237, (byte)  3, (byte)  3, (byte)  4, (byte)  4, (byte)  6, (byte)  0,
                (byte)  0, (byte)  0, (byte)  0, (byte)236, (byte)237, (byte)238, (byte)239, (byte)240,
                (byte)241, (byte)242, (byte)243, (byte)244, (byte)245, (byte)246, (byte)247, (byte)248,
                (byte)249, (byte)250, (byte)251, (byte)252, (byte)  2, (byte)  0, (byte)  0, (byte)  0 };

    }

    @Override
    public double nextExponential(Random random) {
        if (random == null) random = RandomHolder.GENERATOR;
        return computeNextExponential(random);
    }

}
