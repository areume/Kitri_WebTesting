/**
 * 
 */
var xhr=null;
var arr=new Array();

function toServer() {
	var message=document.getElementById("createForm").message.value;
	//arr.push(message);
	
	if(window.XMLHttpRequest) {
		xhr=new XMLHttpRequest;
	}else {
		xhr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	// GET
	//xhr.open("GET","command.jsp?message="+message,true);	// 요청방식, 서버파일, 비동기식
	//xhr.send();
	
	//POST
	xhr.open("POST","command.jsp","true");	// 웹 브라우저의 헤더부분으로 데이터가 넘어간다.
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("message="+message);
	
	xhr.onreadystatechange=process;
	
	//alert(arr.join("\n"));
}

function process() {
	
	if(xhr.readyState==4 && xhr.status==200) {
		arr.push(xhr.responseText);
		var disp=document.getElementById("disp");
		disp.innerText=xhr.responseText;
		
	}
	//alert(arr.join("\n"));
}