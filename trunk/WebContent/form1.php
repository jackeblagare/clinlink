//Urfano,Shella C.

<?php

/*$eemail=$_GET["email"];
if(!preg_match('/[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}/', $email)){
  echo "Please Enter a email address."."<br/>";  
}                                                      
*/                                                        

$nname=$_GET["name"];
$error=false;
if(strlen($nname)==0){
   echo "Please Enter a valid name."."<br/>";
} 

$sstudnum=$_GET["studnum"];
if(strlen($sstudnum)==0){
    echo "Please Enter a stdent number."."<br/>";
} 

$aage=$_GET["age"];
if(!is_numeric($age)){
   echo "Please Enter a valid age."."<br/>";
}

$eemail=$_GET["email"];
if(strlen($eemail)==0){
echo "Please Enter a valid email address."."<br/>";
} 


/*hobbies*/
if(!isset($_GET["hobby"]))
   echo "Please choose at least one hobby."."<br/>";
else{
$hobby = $_GET["hobby"];
$countint = count($hobby);
for($i=0;$i<$countint;$i++){
   echo $hobby[$i]."<br/>";
}

?>
