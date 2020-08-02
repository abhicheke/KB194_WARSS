
<?php
   $conn = mysqli_connect('localhost','id12732235_asih','Abhicheke123@','id12732235_team');
   if (mysqli_connect_errno($conn)) {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
   }
   $na=$_POST['na'];
    $la=$_POST['lna'];
   $aathar=$_POST['aathar'];
   $dob=$_POST['dob'];
    $mob=$_POST['mob'];
    $honum=$_POST['honum'];
    $ro=$_POST['ro'];
    $lm=$_POST['lm'];
    $pc=$_POST['pc'];
    $villa=$_POST['villa'];
    $talu=$_POST['talu'];
    $dist=$_POST['dist'];
    $co=$_POST['co'];
    $buf=$_POST['buf'];
    $go=$_POST['go'];
    $she=$_POST['she'];
    $hor=$_POST['hor'];
    $password=$_POST['password'];
    $status="Pending";
    $id="AP".$dist{0}.$talu{0}.$villa{0}.$mob."L20";
   $mysql_qry ="insert into Registeration (Id,Name,Last,Aathar_No,Date_of_Birth,Mobile,House_No,Road,LandMark,Pincode,Village,Taluk,District,Cows,Buffalo,Goat,Sheep,Horse,Password,Status) values( '$id','$na','$la','$aathar','$dob','$mob','$honum','$ro','$lm','$pc','$dist','$talu','$villa','$co','$buf','$go','$she','$hor','$password','$status')";
   if($conn->query($mysql_qry)===TRUE){
	echo "Registration Sucessfull";
   }
   else{
	   echo "Failed to Register";
   }
?>