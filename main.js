function checkForm()  {
    username = document.getElementById("username").value;
    pwd = document.getElementById("password").value;
    
    if (username == "")	{
	hideAllErrors();
	document.getElementById("usernameError").style.display = "block";
	document.getElementById("username").select();
	document.getElementById("username").focus();
	return false;
    }  else if (pwd == "")  {
	hideAllErrors();
	document.getElementById("pwdError").style.display = "block";
	document.getElementById("username").select();
	document.getElementById("password").focus();
	return false;
    }
    
    get_info_from_database(username,pwd);
    return false;
}

function get_info_from_database(str,str1){
    if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
    else
        {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
    xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
		    if (xmlhttp.responseText=="Exists")
			{
			    hideAllErrors();
			    window.location="cpld.php";//Edit this line for working for all
			}
		    else
			{
			    hideAllErrors();
			    document.getElementById("unpwdError").style.display = "block";
			    document.getElementById("username").select();
			    document.getElementById("username").focus();
			}
		}
        }
    xmlhttp.open("GET","checkpwd.php?q="+str+"&p="+str1,true);
    xmlhttp.send(null);
}

function hideAllErrors(){
    document.getElementById("usernameError").style.display = "none";
    document.getElementById("pwdError").style.display = "none";
    document.getElementById("unpwdError").style.display = "none";
    document.getElementById("signed_in").style.display = "none";
    document.getElementById("logout_button").style.display = "none";
    //	document.getElementById("usernameError").style.visibility = "hidden";
    //	document.getElementById("pwdError").style.visibility = "hidden";
    //       document.getElementById("unpwdError").style.visibility ="hidden";
}