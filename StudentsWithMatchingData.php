<?php
$DB = "db_students";

$conn = mysqli_connect('localhost', 'root', '', $DB);

if (!$conn) {
  die("Connection failed: " . mysqli_connect_error());
}

$js = '{ "Students" : [ ';

$sql = 'CALL StudentsWithMatchingData()'; 

$result = mysqli_query($conn, $sql);

while($row = mysqli_fetch_assoc($result)){
	$js .= '{	"StudentID" : "' . $row['StudentID'] .
			'", "StudentName" : "' . $row['StudentName'] .
			'", "Course" : "' . $row['Course'] .
			'", "YearLevel" : "' . $row['YearLevel'] .
			'", "EnrolmentID" : "' . $row['EnrolmentID'] .
			'", "OfferingNo" : "' . $row['OfferingNo'] .
			'", "Semester" : "' . $row['Semester'] .
			'", "AcademicYear" : "' . $row['AcademicYear'] .'"}, ';
}

$js .= substr($js, -1) . '] }';
echo $js;
mysqli_close($conn)	
?>