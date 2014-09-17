<?
   include_once 'securimage/securimage.php';
   $securimage = new Securimage();
   $captcha_user=$_REQUEST[""];
   return $securimage->check($captcha_user);

?>
