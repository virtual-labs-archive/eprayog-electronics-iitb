<?
include('include.php');
require "../../../LocalSettings.php";

 if(!isset($_SESSION['username']))
  {
    header("Location: ".$URLRoot."user/require_login.php");
  }

 ?>


<? $page_title="Experiment"; $show_sidebar=1;?>

<? include $header; ?>
<script language="javascript">
var dlgOpenDialog = null;

function DisplayStatusTable()
{
$err = "";
$Data="";
$NumBytes = "";
$NumResources = "";
$Ip="";
$ConnSock = "";
$GetNoResMsg = "GetNumRes";
$GetResMsg = "GetAllResInfo";
$Index ="";

 $ConnSock = ConnectToServer(SERVER_ADDRESS,SERVER_PORT,$err);
     
  if($ConnSock)
    {
     $NumBytes = SendMsg($ConnSock,$GetNoResMsg,strlen($GetNoResMsg),$err);
     $Data = GetMsg($ConnSock,4,$err);
     $NumResources = ord($Data);
    
     CloseConnection($ConnSock);
     }
     
$ConnSock = ConnectToServer(SERVER_ADDRESS,SERVER_PORT,$err);
    if($ConnSock)
    {
     $NumBytes = SendMsg($ConnSock,$GetResMsg,strlen($GetResMsg),$err);
     $Data = GetMsg($ConnSock,4*$NumResources,$err);
 //    echo ord($Data[3]);
     CloseConnection($ConnSock);
     } 
 
 echo ' <table border = "1" >  ';
  
 for($Index = 0; $Index < $NumResources ;$Index++)
 {
   $DataBufIndex = 4*$Index;
   echo ' <tr> <td> <b>'.'AppServer '.$Index.'</td>'.'<td> <b>Status </td> </tr>';
   
   // Get Function Generator Status
   $Num = ord($Data[$DataBufIndex]);
   $Status = (!$Num)? "CONNECTED" : "DISCONNECTED";
   echo '<tr>';
   echo '<td> FNG STATUS: </td>';
   echo '<td>'.$Status.'</td>';
   echo '</tr>';
   
   // Get DSO Status
   $Num = ord($Data[$DataBufIndex + 1]);
   $Status = (!$Num)? "CONNECTED" : "DISCONNECTED";
   echo '<tr>';
   echo '<td> DSO STATUS: </td>';
   echo '<td>'.$Status.'</td>';
   echo '</tr>';
   
   // Get Board Status
   $Num = ord($Data[$DataBufIndex + 3]);
   $Status = (!$Num)? "CONNECTED" : "DISCONNECTED";
   echo '<tr>';
   echo '<td> BOARD STATUS: </td>';
   echo '<td>'.$Status.'</td>';
   echo '</tr>';
  
} //for loop
echo '</table>'; 
}



function ShowUploadDialog()
{
	ShowStop();
	document.getElementById('applet').style.display='none';
	document.getElementById('upload').style.display='inline';
}

function EndUpload(message)
{
	document.getElementById('applet').style.display='inline';
	document.getElementById('upload').style.display='none';
	ShowStop();
	if(message != "")
	{
		alert(message);
	}
}

function UploadFile()
{
	if(document.getElementById('filename').value == "")
	{
		alert('Select a file to upload');
		return false;
	}
	else
	{
		ShowUploadDialog();
		return true;
	}
}
//Progress Bar
totalWidth=500;
progressWidth = 30;
bShowing = false;
var timer = null;
function Initialize()
{
	document.getElementById('table').style.width = totalWidth + "px";
	document.getElementById('field2').style.width=progressWidth + "px";
}
function ShowStop()
{
	if(bShowing)
	{
		bShowing = false;
		clearTimeout(timer);		
	}
	else
	{
		bShowing = true;
		ShowStatus(0, 1);
	}
}
function ShowStatus(width, increase)
{
	document.getElementById('field1').style.width=width + "px";
	document.getElementById('field3').style.width=totalWidth-(progressWidth+width) + "px";
	width = width + 3*increase;
	if(width >= totalWidth-progressWidth)
	{
		increase = -1;
	}
	if(width <= 0)
	{
		increase = +1;
	}
	timer = window.setTimeout('ShowStatus(' + width + ',' + increase + ')', 20);
}
Initialize();
</script>

<?php
$ip = GetServerIp($_SESSION['username']);
if($ip=="")
{
	echo "We are sorry. Currently all remote lab setup are in use.<br/>";
	echo "You can try after sometime to see if any setup becomes free.<br/>";
	echo "Thank you for your patience.";
	DisplayStatusTable();

}
else
{
?>

<table>
<tr id="applet" style="display:inline"><td>
<form action="upload.php" method="post" enctype="multipart/form-data" target="uploader" onsubmit="UploadFile()">
Select program to upload : <input type="file" id="filename" name="Program" size="50"/><input type="submit" value="Upload"/>
</form>
<a href="logout.php">Logout</a>
<P>
<APPLET code="org.JDspExp.class" width="1050" height="1050" archive="JRLabDemo.jar">
    <param name="StatusUri" value="status.php">
    <param name="UploadUri" value="upload.php">
	<param name="Username" value="<?php echo "student"; ?>"> <!-- HARDCODED //-->
<!--
    <param name="StatusUri" value="http://10.12.33.20/temp/bhankas/data.bin">
    <param name="UploadUri" value="http://10.12.33.20/lab/demo2/upload.php">
-->
</APPLET>
</td></tr>
<tr id="upload" style="display:none"><td>
Uploading:
<table border="1" style="width:1000px;height:20px" id="table">
	<tr border="0"><td id="field1"></td><td id="field2" bgcolor="#3377FF" style="width:30px"></td><td id="field3"></td></tr>
</table>
</td></tr>
</table>
</P>
<iframe id="uploader" name="uploader" src="#" style="width:0;height:0;border:0px solid #fff;"></iframe>
<? } ?>
<? include $footer; ?>
