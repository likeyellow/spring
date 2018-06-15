function checkImageType(fileName){
		
	var pattern = /jpg|gif|png|jpeg/i;
		
	return fileName.match(pattern);	
}

function getFileInfo(fullName){
	
	var fileName, imgsrc, getLink;
	
	var fileLink;
	
	if(checkImageType(fullname)){
		imgsrc="/displayFile?fileName="+fullname;
		fileLink = fullname.substr(14);
		
		var front = fullname.substr(0,12); // 	/2018/06/14/
		var end = fullname.substr(14); 
		
		getLink = "/displayFile?fileName="+front + end;
		
	}else{
		imgsrc= "/resources/dist/img/file.png";
		fileLink= fullname.substr(12);
		getLink = "/displayFile?fileName=" + fullname;
	}
	fileName= fileLink.substr(fileLink.indexOf("_")+1);
	
	return {fileName:fileName, imgsrc:imgsrc, getLink:getLink, fullname:fullname};
}