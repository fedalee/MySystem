function testcallback(pageid,reportid,selectedTrObjArr,deselectedTrObjArr)
{
	var str=getTrObjsValue(deselectedTrObjArr);
	alert('被选中的所有行：'+str);
	if(str!=null&&str!='')
	{
		alert('本次被取消选中的行：'+str);
	}
	str=getTrObjsValue(selectedTrObjArr);
	if(str!=null&&str!='')
	{
		alert('本次选中的行：'+str);
	}
	var allSelectedTrObjsArr=getListReportSelectedTrObjs(pageid,reportid);//取到所有选中的行对象
	str=getTrObjsValue(allSelectedTrObjsArr);
	if(str!=null&&str!='')
	{
		alert('被选中的所有行：'+str);
	}
}
