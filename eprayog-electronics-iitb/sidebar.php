<script type="text/javascript" src="main.js"></script>

<div id="sidebar">
  <ul>
    <li>
      <h2>Login for e-Prayog</h2>
      <?  if(isset($_SESSION['username'])){ ?>
      <p> 
	Welcome <?=$_SESSION['username']; ?><br />
	<a href="<?=$WebRoot; ?>user/logout.php">Sign Out </a>
      </p>
      <? } else	 { ?>
      <form action="<?=$WebRoot; ?>user/login.php" method=post>
	Username <input type=text name="username" id=username  /><br />
	Password <input type=password name="password" id =password /><br />
	<input type=submit name="submit" value="Login" />
        <a href="<?=$WebRoot; ?>user/signup.php"><input type="button" 
value="Free Sign Up" /></a>
      </form>
      <br />
      <? } ?>
    </li>
    <li>
	<h2>Downloads</h2>
	<ul>
		<li><a href="http://www.java.com/getjava">Java Runtime</a></li>
		<li><a href="http://www.ee.iitb.ac.in/~sequel">SEQUEL</a></li>
		<li><a href="http://sourceforge.net/projects/ngspice/">NGSPICE</a></li>
		<li><a href="http://scilab.org">Scilab</a></li>  
	</ul>
    </li>
    <li>
      <h2>Links</h2>
      <ul>
	<li><a href="http://www.vlab.co.in/">Virtual Labs</a><span>Virtual Labs supported by MHRD</span> </li>
	<li><a href="http://www.cdeep.iitb.ac.in">CDEEP</a><span>Video Lectures by CDEEP</span> </li>
	<li><a href="http://www.iitb.ac.in">IIT Bombay</a><span>Website of IIT Bombay</span> </li>
	<li><a href="http://nptel.iitm.ac.in/">NPTEL</a><span>NPTEL website</span> </li>
      </ul>
    </li>
   <li>
   <h2>Contact Us</h2>
   <ul>
   <li><a href="<?=$WebRoot; ?>contact">Virtual Labs - IIT Bombay</a></li>
   </li>
  </ul>
</div>
