<?php
include("db_info.php");
$response = array();

$sport = $_GET["sport"];
$city = $_GET["city"];

if($sport!=null && $city != null){
    $searchQuery = $mysqli->query("SELECT * FROM fields WHERE sport = '$sport' AND city = '$city'");
    while($row = mysqli_fetch_assoc($searchQuery)){

        $response[] = $row;
      
    }
    echo json_encode($response);
}elseif($sport!=null && $city == null){
    $searchQuery = $mysqli->query("SELECT * FROM fields WHERE sport = '$sport'");
    while($row = mysqli_fetch_assoc($searchQuery)){

        $response[] = $row;
      
    }
    echo json_encode($response);
}elseif( $sport == null && $city!=null){
    $searchQuery = $mysqli->query("SELECT * FROM fields WHERE city = '$city'");
    while($row = mysqli_fetch_assoc($searchQuery)){

        $response[] = $row;
      
    }
    echo json_encode($response);
}else{
    $fieldsQuery = $mysqli->query("SELECT * FROM fields");


while($row = mysqli_fetch_assoc($fieldsQuery)){

    $response[] = $row;
  
}
echo json_encode($response);

}

