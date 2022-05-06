<?php
include("db_info.php");
$response = array();

$email = $_GET["email"];
$password = $_GET["password"];

//$hashedPassword = password_hash($password, PASSWORD_BCRYPT);

$emailQuery = $mysqli->query("SELECT email from users where email='$email'");

if($emailQuery->num_rows>0){

    $passwordQuery = $mysqli->query("SELECT password from users where email = '$email'");

    $fetchedPassword = mysqli_fetch_assoc($passwordQuery);

    $hashedPassword = $fetchedPassword["password"];//database password


    if(password_verify($password, $hashedPassword)){

        $user = $mysqli->query("SELECT email,fname, sname, phoneNb from users where email = '$email'");

        $response["error"]= false;
        $response["message"]= "user successfully logged in";
        $response["user"] = mysqli_fetch_assoc($user);
        echo json_encode($response);
    }else{
        $response["error"]= true;
        $response["message"]= "password doesn't match email";
        echo json_encode($response);
    }



}else{
        $response["error"]= true;
        $response["message"]= "email not registered";
        echo json_encode($response);
}

