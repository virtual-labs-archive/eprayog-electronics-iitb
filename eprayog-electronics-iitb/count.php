<?
$filename= $DocRoot."counter.txt" ;
$fd = fopen ($filename , "r") or die ("Can't open $filename") ;
$fstring = fread ($fd , filesize ($filename)) ;
fclose($fd) ;

$fd = fopen ($filename , "w") or die ("Can't open write $filename") ;
$fcounted = $fstring + 1 ;
$fout= fwrite ($fd , $fcounted ) ;
fclose($fd) ;
?>
