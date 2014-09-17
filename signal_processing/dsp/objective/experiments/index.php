<? require "../../../../LocalSettings.php"; ?>
<? $page_title="Experiments"; $show_sidebar=1; ?>

<? include $header; ?>

<h1>List of experiments</h1>
</br>
<ol>
<li>IIR Filter <a href="expt1"> Basics </a>
<ol>
<li>Butterworth Filter: <a href="iir_butterworth/theory.pdf">Theory</a> | <a href="iir_butterworth/code.sce">Scilab code</a>
<li>Chebyshev Filter: <a href="iir_chebyshev/theory.pdf">Theory</a> | <a href="iir_chebyshev/code.sce">Scilab code</a> 
</ol> 
</br>
<li>FIR Filter using Windowing Techniques: <a href="expt2"> Basics </a> 
<ol>
<li>Rectangular Window: <a href="fir_rect/theory.pdf">Theory</a> | <a href="fir_rect/pre_lab.pdf">Pre-lab quiz</a> |<a href="fir_rect/FIRFilterRecDesign.sce">Scilab code</a> 
<li>Kaiser Window:  <a href="fir_kaiser/theory.pdf">Theory</a> | <a href="fir_kaiser/pre_lab.pdf">Pre-lab quiz</a> | <a href="fir_kaiser/FIRFilterKaiserDesign.sce">Scilab code</a>
<li>Hanning Window:  <a href="fir_hanning/theory.pdf">Theory</a> | <a href="fir_hanning/pre_lab.pdf">Pre-lab quiz</a> | <a href="fir_hanning/FIRFilterHannDesign.sce">Scilab code</a> 
</ol>


</ol>


</p>

<? include $footer; ?>
