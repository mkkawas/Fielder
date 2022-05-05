<?php
$db_host = "localhost";
$db_user = "root";
$db_pass = "";
$db_name = "fielderdb";

$mysqli= new mysqli($db_host,$db_user,$db_pass,$db_name);
if(mysqli_connect_errno()){
    die("Connection failed");   
}
?>