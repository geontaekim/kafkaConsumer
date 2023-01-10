<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<link rel="stylesheet" href="../css/chart.css" />
<head>
<!--Load the AJAX API-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<link rel="stylesheet" type="text/css" media="screen"
	href="http://trirand.com/blog/jqgrid/themes/redmond/jquery-ui-1.8.1.custom.css" />

<link rel="stylesheet" type="text/css" media="screen"
	href="http://trirand.com/blog/jqgrid/themes/ui.jqgrid.css" />

<link rel="stylesheet" type="text/css" media="screen"
	href="http://trirand.com/blog/jqgrid/themes/ui.multiselect.css" />


<script src="http://trirand.com/blog/jqgrid/js/jquery.js"
	type="text/javascript"></script>
<script
	src="http://trirand.com/blog/jqgrid/js/jquery-ui-1.8.1.custom.min.js"
	type="text/javascript"></script>
<script src="http://trirand.com/blog/jqgrid/js/jquery.layout.js"
	type="text/javascript"></script>
<script src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js"
	type="text/javascript"></script>
<script src="http://trirand.com/blog/jqgrid/js/ui.multiselect.js"
	type="text/javascript"></script>
<script src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js"
	type="text/javascript"></script>
<script src="http://trirand.com/blog/jqgrid/js/jquery.tablednd.js"
	type="text/javascript"></script>
<script src="http://trirand.com/blog/jqgrid/js/jquery.contextmenu.js"
	type="text/javascript"></script>

<script type="text/javascript">
	

		$(document).ready(function () { 
			let search = '';
    		ajaxData(search);
    		
    		const searchBtn = document.querySelector("#searchBtn");
    		
    		});
     
      let param =[];
      let paramAdd = [];
      let jsonData = [];
      // Load the Visualization API and the corechart package.
      google.charts.load('current', { 'packages': ['corechart'] });

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      function getData(){
    	  search = document.querySelector("#searchName");
    	  ajaxData(search.value);
      }
    	  
      
      function ajaxData(search) {
    	  let paramData;
    	  if(search !=''){
          paramData = {"ENAME":search};
          console.log("paramDatacheck::::",paramData);
    	  }else{
    		  paramData={
    				  "ENAME":""
    				  };
    	  console.log("paramDatacheck222::::",paramData);
    	  }
          $.ajax({
            type: 'POST',
            dataType:'json',
            headers: {'Content-Type': 'application/json'},
            data: JSON.stringify(paramData),
            url: '${pageContext.request.contextPath}/api/kaf/kafka',
            success: function (com) {            	
            	jsonData=com.dataList;          	
            	console.log('jsonData::::',jsonData);
            	jqData(jsonData);

            	
              paramAdd=[];
              for(let i =0; i<com.dataList.length; i++){
                param= [ com.dataList[i]['ENAME'] , com.dataList[i]['SAL'] ];   
                //배열합치기
                paramAdd.push(param.flat([]));
                
              }
            },
            error: function (request, error) {
              console.log('error:' + error);
            }
          });
        }
      
      function jqData(jsonData){

    	  $("#jqGrid").jqGrid({
              datatype: "local",
              data: jsonData,
              height:250,
              colNames : ['ENAME','EMPNO','MGR','JOB','DEPTNO','SAL','HIREDATE'],           
              colModel:[
                  {name:"ENAME",width:100,align:'center',hidden:false},                  
                  {name : 'EMPNO',width : 90, align : 'center',hidden:false},
                  {name : 'MGR',width : 90, resizable : true, align : 'right', hidden:false},
                  {name : 'JOB',width : 90, resizable : true, align : 'right', hidden:false},
                   {name : 'DEPTNO',width : 90, resizable : true, align : 'right', hidden:false},
                   {name : 'SAL',width : 90, resizable : true, align : 'right', hidden:false},
                   {name : 'HIREDATE',width : 200, align : 'left',hidden:false,}
                          ],
              loadtext: "로딩중일때 표시되는 텍스트!",
              caption: "E M P L I S T",
              pager:"#pager",
              rowNum:10,
              autowidth: true,
              loadonce:true,
              onSelectRow : function(rowid, status, e){ //row를 선택했을 때 발생하는 이벤트
              	//console.log('클릭데이터값::::',e.target.innerHTML);
              	//console.log('rowid::::',rowid);
                if(rowid != null)
                {
                          //내가 클릭한 row 의 데이터를 뽑아온다.
                          var data = $('#jqGrid').getRowData(rowid);
                          console.log('data:::::',data);
                  }
            	},
              });    
    	 
    	  //$("#jqGrid").setGridParam({datatype: 'local', postData:jsonData , loadonce:true});
    	  $("#jqGrid").trigger("reloadGrid");
    	      	
      }
      
      function drawChart() {    
        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        
        data.addRows(paramAdd);

        // Set chart options
        var options = {
          'title': '직원별 급여',
          'width': 1000,
          'height': 700
        }
        function selectHandler() {
            var selectedItem = chart.getSelection();
            console.log('selectedItem::::',selectedItem);
            //if (selectedItem) {
              //var value = data.getValue(selectedItem.row, selectedItem.column);
              //alert('The user selected ' + value);
            //}
          }
        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
        google.visualization.events.addListener(chart, 'select', selectHandler);
        
      }

    </script>

</head>

<body>
	<div id="header" role="banner">

		<a href="/chart/view"><img src="../img/renike.png"
			class="img_logo" /></a>
		<form>
			<fieldset>
				<legend class="visually-hidden">검색</legend>
				<div class="search_box">
					<input type="text" name="searchName" id="searchName" maxlength="225" tabindex="1" />
					<button name="searchBtn" type="button" id="searchBtn" tabindex="2" onclick="getData()" >검색</button>
				</div>
			</fieldset>
		</form>



	</div>
	<div id="main" role="main">
	
		<table id="jqGrid"></table>

		<div id="pager"></div>

		<br> Max Date : <input id="maxDateField" value="" width="150px">
			

	</div>

	<div id="footer" role="contentinfo">

		<div id="chart_div"></div>

	</div>

	<!--Div that will hold the pie chart-->

</body>

</html>