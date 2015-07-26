/**
 * 
 */

function calculate()
{


	ceDianId=document.getElementById("a").value;
	s1=document.getElementById("s1").value;
	s2=document.getElementById("s2").value;
	//alert(ceDianId);

	
	request=createRequest();
	if(request==null)
	{
		alert("unable to create object");
		return;
	}
	var url="/MySystem/CeDian?id="+ceDianId+"&s1="+s1+"&s2="+s2;
	//alert(url);
	request.open("GET", url, true);
	request.onreadystatechange = responseFromServer;
	request.send(null);


}

function createRequest() {
	try {
		request = new XMLHttpRequest();
	} catch (tryMS) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (otherMS) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
				request = null;
			}
		}
	}
	return request;
}

function responseFromServer()
{
	if (request.readyState == 4) {
		if (request.status == 200) {
			var result=request.responseText;
			s2=document.getElementById("result").innerHTML=result;
		}
	}
}
