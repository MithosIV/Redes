<!DOCTYPE html>
<html>
<head>
	<title> Page Title</title>
	<link rel="stylesheet" href="css/style.css">
	<script src="js/codigo.js"></script>
</head>
<body>

<h1>Titulo</h1>	


<p>Parrafo</p><?php 
$t = date("H");

if ($t < "24"){
	echo "have a nice day";
} else{
	echo "have a good night";
}
?>
</body>
</html>