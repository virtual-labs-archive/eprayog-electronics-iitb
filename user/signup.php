<? require "../LocalSettings.php"; ?>
<? $page_title="Login - WEL Virtual Labs";  ?>

<? 
   if(isset($_SESSION['username'])){
   header("Location: ".$URLRoot);
   exit();
   }
   
   if(isset($_POST['username'])){
     include_once 'securimage/securimage.php';
     $securimage = new Securimage();
     $captcha_input=$_POST["captcha_code"];
     
     $q = $conn->prepare("SELECT COUNT(*) FROM users WHERE username = ?");
     $q->execute(array($_POST['username']));
     $uExists=$q->fetchColumn();
     $q=null;
     $q = $conn->prepare("SELECT COUNT(*) FROM users WHERE email = ?");
     $q->execute(array($_POST['email']));
     $eExists=$q->fetchColumn();
     $q=null;
     if($uExists>0){
       $username_exists=1;
     } else if($_POST['password']!=$_POST['re_password']){
       $pass_nomatch=1;
     } else if($eExists>0){
       $email_exists=1;
     } else if($_POST['email']!=$_POST['re_email']){
       $email_nomatch=1;
     } else if(!$securimage->check($captcha_input)){
       $captcha_failed=1;
     } else {
       $q = $conn->prepare("INSERT INTO users (username, password, email, college) VALUES (:uname, :pass, :email, :college)");

       $q->bindParam(':uname', $_POST['username']);
       $q->bindParam(':pass', md5($salt.$_POST['password']));
       $q->bindParam(':email', $_POST['email']);
       $q->bindParam(':college', $_POST['college']);
       try{
       $q->execute();
       } catch (Exception $e) {
	 die("error:". $e->getMessage());
       }
       $success=1;
     }
   }
     ?>

<? include $header; ?>
<div width="40%">
<? if(isset($success)){ ?>
<h2>Signup Successful</h2>
<p> You may now <a href="login.php">login</a>.</p>
<? } else { ?>
  <h2>Signup for WEL Virtual Labs</h2>
  <form action="signup.php" method="post">
<table><tbody>
    <tr><td>Name:</td><td><input type="text" name="name" /></td></tr>
    <tr><td>College:</td><td><input type="text" name="college" /></td></tr>
    <tr><td>Username:</td><td><input type="text" name="username" />
    <?=(isset($username_exists)?"<span class='error'>Username exists</span>":""); ?></td></tr>
    <tr><td>Password:</td><td><input type="password" name="password" /></td></tr>
    <tr><td>Confirm password:</td><td><input type="password" name="re_password" />
    <?=(isset($pass_nomatch)?"<span class='error'>Passwords do not match</span>":""); ?></td></tr>
    <tr><td>Email ID:</td><td><input type="text" name="email" />
    <?=(isset($email_exists)?"<span class='error'>Email ID already registered</span>":""); ?></td></tr>
    <tr><td>Confirm Email ID:</td><td><input type="text" name="re_email" />
    <?=(isset($email_nomatch)?"<span class='error'>Email IDs do not match</span>":""); ?></td></tr>
    <tr><td></td><td><img src="securimage/securimage_show.php" alt="CAPTCHA Image" /></td></tr>
    <tr><td></td><td>Enter the above text in the box:<br />
    <input type="text" name="captcha_code" size="10" maxlength="6" />
    <?=(isset($captcha_failed)?"<span class='error'>Captcha Failed</span>":""); ?></td></tr>
    </tbody></table>
    <input type="submit" name="submit" value="Proceed" />
  </form><? } ?>
</div>

<? include $footer; ?>
