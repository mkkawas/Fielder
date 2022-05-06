<?php
include("db_info.php");

$response = array();

$email = $_POST["email"];
$oldphone = $_POST["oldphone"];
$newphone = $_POST["newphone"];


$phoneQuery = $mysqli->query("SELECT phonenb FROM users where email= '$email'");

$fetchedphone = mysqli_fetch_assoc($phoneQuery);

$queriedPhone = $fetchedphone["phonenb"];

if($queriedPhone == $oldphone){

    $updatePasswordQuery = $mysqli->query("UPDATE users SET phonenb='$newphone' WHERE email = '$email'");

    $response["error"] = false;
    $response["message"] = "Phone Number Updated Successfully";
    echo json_encode($response);

}else{
    $response["error"] = true;
    $response["message"] = "Wrong Phone Number";
    echo json_encode($response);
}
