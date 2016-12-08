<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row" style="margin-bottom: 10px;">
	<div class="col-md-2">
		<div class="input-group input-group-sm">
			<span class="input-group-addon">地区</span> <select size="1" onchange="changeDocCity ( this )" class="form-control">
				<option value="">--请选择--</option>
				<option value="内陆">内陆</option>
				<option value="中国大陆">中国大陆</option>
				<option value="美国">美国</option>
				<option value="英国">英国</option>
				<option value="日本">日本</option>
			</select>
		</div>
	</div>
	<div class="col-md-2">
		<div class="input-group input-group-sm">
			<span class="input-group-addon">语言</span> <select size="1" onchange="changeDocDistrict ( this )" class="form-control">
				<option value="">--请选择--</option>
				<option value="国语">国语</option>
				<option value="英语">英语</option>
				<option value="德语">德语</option>
			</select>
		</div>
	</div>
	<div class="col-md-3">
		<div class="input-group input-group-sm">
			<input type="text" class="form-control" placeholder="搜索ID" aria-describedby="basic-addon1" id="hospital"> <span class="input-group-addon" id="search_btn" onclick="search()"><i
				class="glyphicon glyphicon-search"></i></span>
		</div>
	</div>
	<div class="col-md-3">
		<a class="btn btn-success btn-sm" data-toggle="modal" data-target="#insertDia" data-backdrop="static" style="font-weight: bold;">&nbsp;&nbsp;增加&nbsp;&nbsp;</a> <a class="btn btn-danger btn-sm"
			style="font-weight: bold;" data-toggle="modal" data-target="#" data-backdrop="static">&nbsp;&nbsp;启动&nbsp;&nbsp;</a>
	</div>
</div>

<!-- table -->
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
			<th>操作</th>
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
				<td><a class="btn btn-danger btn-sm" data-filmid="${infos.filmId }" data-toggle="modal" data-target="#deleteDia" data-backdrop="static" style="font-weight: bold;"
					onclick="javascript:index.showDeleteDia('deleteDia')">删除</a> <a class="btn btn-success btn-sm" data-filmid="${infos.filmId }" data-toggle="modal" data-target="#updateDia" data-backdrop="static"
					style="font-weight: bold;" onclick="javascript:index.showUpdateDia('updateDia')">修改</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class="tableFooter">
	<div class="col-md-12">
		<c:if test="${page.totalNumber != 0 }">
			<div class="dataTables_info">共查询到${page.totalNumber }条记录,当前为第${page.currentPage }/${page.totalPage }页</div>
		</c:if>
		<c:if test="${page.totalNumber == 0 }">
			<div class="dataTables_info">共查询到0条记录,当前为第0/0页</div>
		</c:if>
	</div>
	<div class="col-md-12 center-block">
		<div class="dataTables_paginate paging_bootstrap pagination">
			<ul class="pagination">
				<c:if test="${page.currentPage != 1 }">
					<li><a href="javascript:index.changeCurrentPage(1)">首页</a></li>
					<li><a href="javascript:index.changeCurrentPage(${page.currentPage-1 })">上一页</a></li>
				</c:if>
				<c:if test="${page.currentPage == 1 }">
					<li class="disabled"><a href="javascript:void(0)">首页</a></li>
					<li class="disabled"><a href="javascript:void(0)">上一页</a></li>
				</c:if>
				<li class="disabled"><a>${page.currentPage }/${page.totalPage }</a></li>
				<c:if test="${page.currentPage != page.totalPage }">
					<li><a href="javascript:index.changeCurrentPage(${page.currentPage+1 })">下一页</a></li>
					<li><a href="javascript:index.changeCurrentPage(${page.totalPage })">末页</a></li>
				</c:if>
				<c:if test="${page.currentPage == page.totalPage }">
					<li class="disabled"><a href="javascript:void(0)">下一页</a></li>
					<li class="disabled"><a href="javascript:void(0)">末页</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</div>
<input type="text" value="${currentPage }" hidden="hidden" id="currentPage">