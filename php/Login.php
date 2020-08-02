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
$sql = "SELECT Id,Name,Last,Aathar_No,Date_of_Birth,Mobile,House_No,Road,LandMark,Pincode,Village,Taluk,District,Cows,Buffalo,Goat,Sheep,Horse FROM Registeration WHERE Mobile='$Mobile'";
$result = $conn->query($sql);
    while($row = $result->fetch_assoc()) {
         echo $row["Id"]."%".$row["Name"]."_".$row["Last"]."%". $row["Aathar_No"]."%".$row["Date_of_Birth"]."%".$row["Mobile"]."%".$row["House_No"]."%". $row["Road"]."%".$row["LandMark"]."%".$row["Pincode"]."%".$row["Village"]."%".$row["Taluk"]."%".$row["District"]."%".$row["Cows"]."%".$row["Buffalo"]."%".$row["Goat"]."%".$row["Sheep"]."%".$row["Horse"];
    }
$conn->close();
?>