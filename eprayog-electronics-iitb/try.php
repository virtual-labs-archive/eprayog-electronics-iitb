<?  
   error_reporting(E_ALL);
   ini_set('display_errors', '1');
   
   phpinfo();

$user="root";
$pass="root123";
$dbh = new PDO("mysql:host=localhost;dbname=vil", $user, $pass);
foreach($dbh->query('SELECT * from users') as $row) {
  print_r($row);
}
?>
