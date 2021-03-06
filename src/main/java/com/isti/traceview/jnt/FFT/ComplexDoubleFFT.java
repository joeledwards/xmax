package com.isti.traceview.jnt.FFT;

/**
 * Abstract Class representing FFT's of complex, double precision data. Concrete
 * classes are typically named ComplexDoubleFFT_<i>method</i>, implement the FFT
 * using some particular method.
 * <P>
 * Complex data is represented by 2 double values in sequence: the real and
 * imaginary parts. Thus, in the default case (i0=0, stride=2), N data points is
 * represented by a double array dimensioned to 2*N. To support 2D (and higher)
 * transforms, an offset, i0 (where the first element starts) and stride (the
 * distance from the real part of one value, to the next: at least 2 for complex
 * values) can be supplied. The physical layout in the array data, of the
 * mathematical data d[i] is as follows:
 * 
 * <PRE>
 *    Re(d[i]) = data[i0 + stride*i]
 *    Im(d[i]) = data[i0 + stride*i+1]
 * </PRE>
 * 
 * The transformed data is returned in the original data array in <a
 * href="package-summary.html#wraparound">wrap-around</A> order.
 * 
 * @author Bruce R. Miller bruce.miller@nist.gov
 * @author Contribution of the National Institute of Standards and Technology,
 * @author not subject to copyright.
 */
abstract class ComplexDoubleFFT {

	int n;

	/**
	 * Create an FFT for transforming n points of complex, double precision
	 * data.
	 */
	ComplexDoubleFFT(int n) {
		if (n <= 0)
			throw new IllegalArgumentException(
					"The transform length must be >=0 : " + n);
		this.n = n;
	}

	void checkData(double[] data, int i0, int stride) {
		if (i0 < 0)
			throw new IllegalArgumentException("The offset must be >=0 : " + i0);
		if (stride < 2)
			throw new IllegalArgumentException("The stride must be >=2 : "
					+ stride);
		if (i0 + stride * (n - 1) + 2 > data.length)
			throw new IllegalArgumentException(
					"The data array is too small for " + n + ":" + "i0=" + i0
							+ " stride=" + stride + " data.length="
							+ data.length);
	}

	/**
	 * Compute the Fast Fourier Transform of data leaving the result in data.
	 * The array data must be dimensioned (at least) 2*n, consisting of
	 * alternating real and imaginary parts.
	 */
	public void transform(double[] data) {
		transform(data, 0, 2);
	}

	/**
	 * Compute the Fast Fourier Transform of data leaving the result in data.
	 * The array data must contain the data points in the following locations:
	 * 
	 * <PRE>
	 *    Re(d[i]) = data[i0 + stride*i]
	 *    Im(d[i]) = data[i0 + stride*i+1]
	 * </PRE>
	 */
	protected abstract void transform(double[] data, int i0, int stride);

	/** Compute the (unnomalized) inverse FFT of data, leaving it in place. */
	public void backtransform(double[] data) {
		backtransform(data, 0, 2);
	}

	/**
	 * Compute the (unnomalized) inverse FFT of data, leaving it in place. The
	 * frequency domain data must be in wrap-around order, and be stored in the
	 * following locations:
	 * 
	 * <PRE>
	 *    Re(D[i]) = data[i0 + stride*i]
	 *    Im(D[i]) = data[i0 + stride*i+1]
	 * </PRE>
	 */
	protected abstract void backtransform(double[] data, int i0, int stride);

}
