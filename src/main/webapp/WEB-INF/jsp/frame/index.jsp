<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>后台登陆</title>
<%@include file="../common/head.jsp"%>
</head>
<body>
	<div class="box-content">
		<div style="margin-top: 5px;">
			<table class="table table-striped table-bordered responsive">
				<thead>
					<tr>
						<th>ID</th>
						<th>影视剧名称</th>
						<th>导演</th>
						<th>主演</th>
						<th>类型</th>
						<th>地区</th>
						<th>语言</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${infos}" var="infos">
						<tr>
							<td>${infos.filmId}</td>
							<td>${infos.filmName }</td>
							<td>${infos.direct }</td>
							<td>${infos.protagonist }</td>
							<td>${infos.type }</td>
							<td>${infos.district }</td>
							<td>${infos.language }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>