<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "daBase";

$id = $_POST["id"];
$name = $_POST["name"];
$age = $_POST["age"];
$server = $_POST["server"];


// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO Player2 (ID, Name, Age, Server)
VALUES (2, 'Mithos3', 25, 'Uva')";

if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$sql = "INSERT INTO Player2 (ID, Name, Age, Server)
VALUES (3, $name, $age, $server)";

if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>