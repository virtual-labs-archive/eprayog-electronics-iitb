<? require "../LocalSettings.php"; ?>
<? $page_title="Login - WEL Virtual Labs";  ?> 
<?
if(isset($_SESSION['username'])){
  header("Location: ".$URLRoot);
  exit();
}
?>

<? include $header; ?>

<div width="40%">
  <h3>You'll need to login to view this page...</h3>
  <form action="login.php" method="post">
<table><tbody>
    <tr><td>Username</td><td><input type="text" name="username" /></td></tr>
    <tr><td>Password</td><td><input type="password" name="password" /></td></tr>
</tbody></table>
    <input type="submit" name="submit" value="Login" />
  </form>
  New users may <a href="signup.php">signup</a>.
</div>

<? include $footer; ?>
