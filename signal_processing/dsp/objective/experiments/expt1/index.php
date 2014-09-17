<? require "../../../../../LocalSettings.php"; ?>
<? $show_sidebar=1; ?>

<? include $header; ?>
<h1>Aim</h1>
                     <ol>
                         <li>To design an IIR filter using Bilinear Transformation technique</li>
                         </ol>
<h1>Theory</h1>
<p>
A infinite impulse response filter (IIR) is a class of linear time-invariant filters. The impulse response of the IIR filter
extends over infinite number of sample intervals. The IIR filter is a causal filter that requires a present input and all
the past input samples to compute the present output. It might appear that an IIR filter requires infinite amount of
memory for the implementation; however, using recursive techniques an IIR filter can be very efficiently implemented.
The basic idea here is to incorporate certain feedback mechanism for the usage of past output samples to calculate the
present output. This technique facilitates implementation of an IIR filter using a finite number of past input and past
output samples.
For an IIR filter which requires past <i>M</i> input samples and past <i>N</i> output samples, the difference equation can be
written as</p>
<img src="img/img1.jpg"/>
<p>
where <i>x</i>[n] and y[n] are the input and output sequences, respectively. The a<sub>q</sub>'s and b<sub>p</sub>'s are known as filter coefficients,
and they represent the location of poles and zeros of the filter, respectively.
The impulse response of the filter can be calculated by using train of impulses as an input sequence, i.e.
</p>
   <img src="img/img2.jpg"/>
<p>
The transfer function of the IIR filter is obtained by taking Z-transform of the above expression, which yields,
</p>
    <img src="img/img3.jpg" align="middle"  />
<p>
Since the IIR filter consists of poles that may occur outside the unit circle on the z-plane, one has to explicitly evaluate
the ROC of the transfer function to determine the stability of the system. The LTI system is said to be stable if its ROC
includes the unit circle on the z-plane. Thus, IIR filters may be instable in nature, on the contrary to the FIR filters that
are always stable. However, IIR filters provide sharper role-off than an FIR filter of the same order, and thus they are
preferred in certain applications.
The design of an IIR filter usually begins with the design of an analog filter having similar frequency response.
Analog filter design is a well studied and mature field, therefore, designing an analog filter and then converting it into its
digital counterpart is preferred over designing a complete new digital IIR filter. The analog filter of desired magnitude
characteristics is designed from the given specifications. An analog filter may be of the type- Butterworth, Chebyshev,
elliptical, or Bessel, depending on the requirements of the filter system.
Several conversion techniques for designing an IIR filter from the analog filter are used depending on the needs of the
system. One of the basic conversion technique is to approximate the differential equation of analog filter by a difference
equation of a digital filter. An analog filter design usually involves Laplace transform, while the digital filter is often
expressed using Z transform. Therefore, the conversion process is essentially the mapping of the s-plane to the z-plane
under the stability considerations. Another technique of conversion of analog filter into digital filter is to obtain a digital
filter having the same unit sample response as that of sampled response of the analog filter. This technique is known as
impulse invariance technique. The bilinear transformation is sometimes used for the mapping of the s-plane to the z-plane.
This method transforms the jw axis of s-plane into the unit circle of the z-plane only once which prohibits aliasing in
the digital design. In short, the aforementioned techniques convert analog filter from H(s) to digital filter in H(z) by
preserving the desired frequency response characteristics of the analog filter to the maximum possible extent.
</p>
<? include $footer; ?>
