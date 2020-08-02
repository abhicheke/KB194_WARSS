<?php
 $conn = mysqli_connect('localhost','id12732235_asih','Abhicheke123@','id12732235_team');
   if (mysqli_connect_errno($conn)) {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
   }
$f=$_POST['from'];
$t=$_POST['to'];
$changeani=$_POST['changeAnimal'];
$noanimal=$_POST['noanimal'];
$amount=$_POST['amount'];
$Date= date("l jS \of F Y h:i:s A");
$sql1 = "SELECT $changeani FROM Registeration WHERE Id='$f'";
$result1 = $conn->query($sql1);
    while($row1 = $result1->fetch_assoc()) {
         $fromcount=(int)$row1["$changeani"];
    }
     $sql2 = "SELECT $changeani FROM Registeration WHERE Id='$t'";
$result2 = $conn->query($sql2);
    while($row2 = $result2->fetch_assoc()) {
         $tocount=(int)$row2["$changeani"];
    }
    $currentfrom=(int)$fromcount-(int)$noanimal;
    $currentto=(int)$tocount+(int)$noanimal;
    
    $sql3 = "UPDATE Registeration SET $changeani =$currentfrom where Id='$f'";
    $conn->query($sql3);
    $sql4 = "UPDATE Registeration SET $changeani =$currentto where Id='$t'";
    $conn->query($sql4);
     $sql5 ="insert into ownersipchange(Seller,Buyer,Animal,Number,Amount,DateandTime) values('$f','$t','$changeani','$noanimal','$amount','$Date')";
      if($conn->query($sql5)===TRUE){
	echo "Transfer Sucessfull";
   }
   else{
	   echo "Transfer Failed";
   }
$conn->close();
?>