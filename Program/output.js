var courseArray = [ "CS","CS","CS","CS","CS","CS","CS","CS","ECE","ECE","MATH","MATH","MATH","MATH","MATH","PH","PH","PH","PH"];
var numberArray = [ "121","200","201","300","301","403","470","495","380","383","302","237","247","355","238","253","255","301","331"];
for (var i = 0; i < courseArray.length; i++) {
	document.getElementsByName('Discipline')[0].value = courseArray[i];
	document.getElementsByName('Number')[0].value = numberArray[i];
	AddClass(document.frmWhatIfBody);
}
