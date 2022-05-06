<?php
include("db_info.php");
$response = array();

$email = $_POST["email"];
$oldpass = $_POST["oldpassword"];
$newpass = $_POST["newpassword"];

$passwordQuery = $mysqli->query("SELECT password FROM users where email= '$email'");

$fetchedpass = mysqli_fetch_assoc($passwordQuery);

$hashedpass = $fetchedpass["password"];

if(password_verify($oldpass, $hashedpass)){


    $hashedNewPass = password_hash($newpass,PASSWORD_BCRYPT);
    $updatePasswordQuery = $mysqli->query("UPDATE users SET password='$hashedNewPass' WHERE email = '$email'");

    $response["error"] = false;
    $response["message"] = "Password Updated Successfully";
    echo json_encode($response);

}else{

    $response["error"] = true;
    $response["message"] = "Wrong Password";
    echo json_encode($response);
}



