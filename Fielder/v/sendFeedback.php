<?php
include("db_info.php");

$message = $_POST["message"];
$fullname = $_POST["fullname"];

if($message!=null){

    $feedbackQuery = $mysqli->query("INSERT INTO feedbacks(message, fullname) VALUES ('$message','$fullname')");

    $response["message"] = "success";
    
    echo json_encode($response);

}
