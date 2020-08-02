<?php
 $conn = mysqli_connect('localhost','id12732235_asih','Abhicheke123@','id12732235_team');
   if (mysqli_connect_errno($conn)) {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
   }
$type=$_POST['type'];
$count=$_POST['count'];
$mobile=$_POST['mobile'];
$animal=$_POST['animal'];
$mysql_qry = "UPDATE Registeration SET $animal = $count where Mobile=$mobile";
   if($conn->query($mysql_qry)===TRUE ){
	echo "Update Sucessfull";
   }
   else{
	   echo "Failed to Update";
   }
$conn->close();
?>