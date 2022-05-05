<?php

    class DbOperations{

        private $con;

        function __construct(){
            
            require_once dirname(__FILE__).'/DbConnect.php';

            $db = new DbConnect();

            $this->con = $db->connect();
        }

        function createUser($fname, $sname, $email, $password, $phonenb){
				$stmt = $this->con->prepare("insert into users values(?,?,?,?,?)");
            //$stmt = $this->con->prepare("INSERT INTO `users` ( `fname` , `sname` , `email`, `password`, `phonenb`) VALUES (?, ?, ?, ?, ?);");
				$stmt->bind_param("sssss",$fname, $sname,$email, $password, $phonenb);
                

				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}
        }



    }