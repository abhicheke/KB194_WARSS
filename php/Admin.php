<?php
$servername = "localhost";
$username = "id12732235_asih";
$password = "Abhicheke123@";
$dbname = "id12732235_team";
$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
$Mobile=$_POST['Mobile'];
$Password=$_POST['Password'];
$sql = "SELECT Admin FROM Admin WHERE UserName='$Mobile' and Password='$Password'";
$result = $conn->query($sql);
    while($row = $result->fetch_assoc()) {
         echo "Login Successfull";
    }
$conn->close();
?>