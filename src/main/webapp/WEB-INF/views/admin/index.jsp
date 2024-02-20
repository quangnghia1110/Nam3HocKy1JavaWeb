<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<body class="sb-nav-fixed">
	<%@include file="/common/admin/header/header.jsp"%>

	<div id="layoutSidenav_content">
		<main>
		    <div class="container-fluid px-4">
		        <h1 class="mt-4">BÁO CÁO - THỐNG KÊ</h1>
		        <ol class="breadcrumb mb-4">
		            <li class="breadcrumb-item active">Báo cáo - Thống kê</li>
		        </ol>
		        <div id= "report" class="row">
		            
		            <div class="col-xl-4 col-md-6">
		                <div class="card bg-primary text-white mb-4">
		                    <div class="card-body">Tổng số người dùng</div>
		                    <h2 class="ms-3">${countUser}<i
		                            class="fas fad fa-user float-end me-2"></i>
		                    </h2>
		                </div>
		            </div>
		            <div class="col-xl-4 col-md-6">
		                <div class="card bg-warning text-white mb-4">
		                    <div class="card-body">Tổng số đơn hàng</div>
		                    <h2 class="ms-3">${countOrder}<i
		                            class="fas fad fa-shopping-cart float-end me-2"></i>
		                    </h2>
		                </div>
		            </div>
		            <div class="col-xl-4 col-md-6">
		                <div class="card bg-success text-white mb-4">
		                    <div class="card-body">Tổng số sản phẩm</div>
		                    <h2 class="ms-3">${countProduct}<i
		                            class="fas fad fa-glass-martini float-end me-2"></i>
		                    </h2>
		                </div>
		            </div>
		        </div>
		        <div class="col-xl-12">
				    <div class="card mb-4">
				        <div class="card-header">
				            <h5 class="card-title">Số lượng bán ra của từng loại trà sữa trong tháng</h5>
				        </div>
				        <div class="card-body">
				            <canvas id="quantityChartByMilkTeaType" width="400" height="200"></canvas>
				        </div>
				    </div>
				</div>	
		        <div class="col-xl-12">
				    <div class="card mb-4">
				        <div class="card-header">
				            <h5 class="card-title">Doanh thu theo ngày trong tháng</h5>
				        </div>
				        <div class="card-body">
				            <canvas id="revenueChartByDay" width="400" height="200"></canvas>
				        </div>
				    </div>
				</div>	
				<div class="col-xl-12">
				    <div class="card mb-4">
				        <div class="card-header">
				            <h5 class="card-title">Doanh thu theo tháng trong năm nay</h5>
				        </div>
				        <div class="card-body">
				            <canvas id="revenueChartByMonth" width="400" height="200"></canvas>
				        </div>
				    </div>
				</div>					        
		    </div>
		</main>
	</div>	
	
	<script>
		function createChart(statisticsData, chartId) {
		    var labels = statisticsData.map(function(item) {
		    	if(chartId == 'revenueChartByMonth') 
		    		return 'Tháng ' + item[0];
		    	else if(chartId == 'revenueChartByDay')
		        	return 'Ngày ' + item.order_date;
		    	return item[0].replace(/\+/g, ' ');
		    });
	
		    var data = statisticsData.map(function(item) {
		    	if(chartId == 'revenueChartByDay')
		    		return item.total_price
		        return item[1];
		    });
		    
		    var label = '';
		    if (chartId == 'revenueChartByMonth' || chartId == 'revenueChartByDay') {
		        label = 'Doanh thu';
		    } else {
		        label = 'Số lượng';
		    }
	
		    var ctx = document.getElementById(chartId).getContext('2d');
		    var myChart = new Chart(ctx, {
		        type: 'bar',
		        data: {
		            labels: labels,
		            datasets: [{
		                label: label,
		                data: data,
		                backgroundColor: 'rgba(75, 192, 192, 0.2)',
		                borderColor: 'rgba(75, 192, 192, 1)',
		                borderWidth: 1
		            }]
		        },
		        options: {
		            scales: {
		                y: {
		                    beginAtZero: true
		                }
		            }
		        }
		    });
		}
		
		var revenueDataByDay =  JSON.parse(he.decode('<c:out value="${revenueDataByDayJson}" />'));
		createChart(revenueDataByDay, 'revenueChartByDay');

	
		var revenueDataByMonth = <c:out value="${revenueDataByMonthJson}" />;
		createChart(revenueDataByMonth, 'revenueChartByMonth');
		
		var quantityDataOfMilkTeaType = decodeURIComponent('<c:out value="${quantityDataOfMilkTeaTypeJson}" />');
		createChart(JSON.parse(quantityDataOfMilkTeaType), 'quantityChartByMilkTeaType');

	</script>	
</body>

</html>