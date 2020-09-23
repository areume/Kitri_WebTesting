/**
 * 
 */

var xhr=null;
var arr=new Array();

function toServer() {
	if(window.XMLHttpRequest) {
		xhr=new XMLHttpRequest();
	}else {
		xhr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	arr.push(xhr);
	//alert(arr.join("\n")); // Object 잘 가져오는지 확인
	
	xhr.open("GET","json02.txt",true);
	xhr.send();
	xhr.onreadystatechange=resultProcess;
}

function resultProcess() {
	
	if(xhr.readyState==4 && xhr.status==200) {
		arr.push(xhr.responseText);
		var obj=JSON.parse(xhr.responseText);
		//arr.push(obj.name+", "+obj.age+", "+obj.cars.length+", "+obj.cars[0].name+", "+obj.cars[0].model.length);
		
		//alert(arr.join("\n"));
		
		// 전체 div
		var disp=document.getElementById("disp");
		
		// 이름		
		var nameH3=document.createElement("h3");
		nameH3.innerHTML="이름 : "+obj.name;
		disp.appendChild(nameH3);
		
		// 나이
		var ageH3=document.createElement("h3");
		ageH3.innerHTML="나이 : "+obj.age;
		disp.appendChild(ageH3);
				
		// 자동차		
		var carsUl=document.createElement("ul");		
		for(var i=0;i<obj.cars.length;i++) {
			
			var carLi=document.createElement("li");
			carLi.innerHTML=obj.cars[i].name;
			
			var modelUl=document.createElement("ul");
			for(var j=0;j<obj.cars[i].model.length;j++) {
				var modelLi=document.createElement("li");
				modelLi.innerHTML=obj.cars[i].model[j];
				
				modelUl.appendChild(modelLi);
			}
			carLi.appendChild(modelUl);
			carsUl.appendChild(carLi);
		}
		
		disp.appendChild(carsUl);	
	}
	
}