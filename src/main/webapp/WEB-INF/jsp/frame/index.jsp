<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>聚类展示平台</title>
<%@include file="../common/head.jsp"%>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="ch-container">
		<div id="content" class="col-lg-12 col-sm-12">
			<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">
						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-user"></i> 聚类展示平台
							</h2>
						</div>
						<div class="box-content">
							<div style="margin-top: 5px;">
								<div class="loadingBody">
									<%@include file="../table/clusterTab.jsp"%>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../dialog/indexDia.jsp"%>
</body>
<script src="./resource/bower_components/jquery/jquery.min.js"></script>
<script src="./resource/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="./resource/js/jquery.cookie.js"></script>
<script src='./resource/bower_components/moment/min/moment.min.js'></script>
<script src='./resource/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<script src='./resource/js/jquery.dataTables.min.js'></script>
<script src="./resource/bower_components/chosen/chosen.jquery.min.js"></script>
<script src="./resource/js/jquery.iphone.toggle.js"></script>
<script src="./resource/bower_components/colorbox/jquery.colorbox-min.js"></script>
<script src="./resource/js/jquery.noty.js"></script>
<script src="./resource/bower_components/responsive-tables/responsive-tables.js"></script>
<script src="./resource/js/jquery.dataTables.min.js"></script>
<script src="./resource/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<script src="./resource/js/jquery.raty.min.js"></script>
<script src="./resource/js/jquery.autogrow-textarea.js"></script>
<script src="./resource/js/jquery.history.js"></script>
<script src="./resource/js/charisma.js"></script>
<script src="./resource/js/jquery-form.js"></script>
<script src="./resource/js/common.js"></script>
<script src="./resource/js/index.js"></script>
<script>
	$(function()
	{
		index.init()
	})
</script>
</html>