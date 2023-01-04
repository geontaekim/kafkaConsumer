<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
  <html>

  <head>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
      $(document).ready(function () {
        ajaxData();
        

      });
      let param =[];
      let paramAdd = [];
      // Load the Visualization API and the corechart package.
      google.charts.load('current', { 'packages': ['corechart'] });

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.


      function ajaxData() {
          
          $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/api/kaf/kafka',
            success: function (com) {
              paramAdd=[];
              for(let i =0; i<com.dataList.length; i++){
                param= [ com.dataList[i]['ENAME'] , com.dataList[i]['SAL'] ];
                paramAdd.push(param.flat([]));
                
              }
            },
            error: function (request, error) {
              console.log('error:' + error);
            }
          });

        }



      function drawChart() {    
        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        
        data.addRows(paramAdd);

        // Set chart options
        var options = {
          'title': 'How Much Payment EMP',
          'width': 1000,
          'height': 700
        }
        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }

    </script>

  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>
    <div id="chart_div2"></div>
  </body>

  </html>