<?php
$DB = "db_students";

$conn = mysqli_connect('localhost', 'root', '', $DB);

if (!$conn) {
  die("Connection failed: " . mysqli_connect_error());
}

$js = '{ "Subjects" : [ ';

$sql = 'CALL SubjectsWithMatchingData()'; 

$result = mysqli_query($conn, $sql);

while($row = mysqli_fetch_assoc($result)){
	$js .= '{	"OfferingNo" : "' . $row['OfferingNo'] .
			'", "SubjCode" : "' . $row['SubjCode'] .
			'", "Schedule" : "' . $row['Schedule'] .
			'", "Room" : "' . $row['Room'] .
			'", "TeacherID" : "' . $row['TeacherID'] .
			'", "EnrolmentID" : "' . $row['EnrolmentID'] .
			'", "StudentID" : "' . $row['StudentID'] .
			'", "Semester" : "' . $row['Semester'] .
			'", "AcademicYear" : "' . $row['AcademicYear'] .'"}, ';
}

$js .= substr($js, -1) . '] }';
echo $js;
mysqli_close($conn)	
?>