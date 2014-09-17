<?
   require "../LocalSettings.php";
   session_destroy();
   header("Location: ".$URLRoot);
   exit();
   
   ?>
