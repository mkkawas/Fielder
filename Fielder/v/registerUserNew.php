<?php
include("db_info.php");
$response = array();
$Fname= $_POST["Fname"];
$Sname= $_POST["Sname"];
$email= $_POST["email"];
$password= $_POST["password"];
$phoneNb = $_POST["phoneNb"];

$emailQuery = $mysqli->query("SELECT email from users where email='$email'");

if($emailQuery->num_rows>0){
    $response["error"] = true;
    $response["message"] = "email already exists";
    echo json_encode($response);
}else{
    $hashedPassword = password_hash($password,PASSWORD_BCRYPT);
    $RegisterUserQuery = $mysqli->query("INSERT INTO users(fname,sname,email,password,phonenb)
                    Values ('$Fname', ' $Sname','$email','$hashedPassword','$phoneNb')");


if($RegisterUserQuery){
    $response["error"]= false;
    $response["message"]= "user successfully registered";
    echo json_encode($response);
}else{
    $response["error"] = true;
    $response["message"] = "please try again later";
    echo json_encode($response);
}

}

