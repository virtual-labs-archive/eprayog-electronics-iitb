<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="<?=$style; ?>" />
    <title>e-Prayog</title>
  </head>
  <body>
    <div id="banner">
      <? include $banner; ?>
    </div>
    <div id="menu">
      <? include $menu; ?>
    </div>
 </div>
    <div id="marquee" style="background-color:#FFFFFF; color:#000077">
        <marquee scrollamount="2"></marquee>
    </div>
    <table id="mainContainer" style="border-collapse:collapse;">
      <tbody>
	<tr style="height:20px;">
	  <td><td id="context"><? if($Path!=$WebRoot."index.php") { ?> <a href="..">Go Back</a> | <? } ?><? include "context_menu.php"; ?></td></td>
   	</tr>
	<tr>
	  <td id="sidebar">
	    <? include $sidebar; ?>
	  </td>
	  <td id="content">

