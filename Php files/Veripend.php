<?php
 $conn = mysqli_connect('localhost','id12732235_asih','Abhicheke123@','id12732235_team');
   if (mysqli_connect_errno($conn)) {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
   }
$status=$_POST['status'];
$mobile=$_POST['mobile'];
$mysql_qry = "UPDATE Registeration SET Status = '$status' where Mobile='$mobile'";
   if($conn->query($mysql_qry)===TRUE ){
	echo "Update Sucessfull";
   }
   else{
	   echo "Failed to Update";
   }
$conn->close();
?>