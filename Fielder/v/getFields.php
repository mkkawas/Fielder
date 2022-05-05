<?php

include("db_info.php");
$response = array();

$fieldsQuery = $mysqli->query("SELECT * FROM fields");


while($row = mysqli_fetch_assoc($fieldsQuery)){

    $response[] = $row;
  
}
echo json_encode($response);

