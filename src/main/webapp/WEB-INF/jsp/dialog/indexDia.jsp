<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 删除  -->
<div class="modal fade" id="deleteDia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4>
					<i class="glyphicon glyphicon-warning-sign"></i> 删除
				</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
				<p>确定删除该信息？</p>
				<a hidden="hidden" id="filmid"></a>
			</div>
			<div class="modal-footer">
				<a href="javascript:void(0)" class="btn btn-default btn-sm" data-dismiss="modal">关闭</a> <a href="javascript:void(0)" onclick="javascipt:index.deleteByFilmId()" class="btn btn-success btn-sm"
					data-dismiss="modal">确定 </a>
			</div>
		</div>
	</div>
</div>

<!-- 修改 -->
<div class="modal fade" id="updateDia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4>
					<i class="glyphicon glyphicon-warning-sign"></i> 删除
				</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
				<p>确定更新该信息？</p>
			</div>
			<div class="modal-footer">
				<a href="javascript:void(0)" class="btn btn-default btn-sm" data-dismiss="modal">关闭</a> <a href="javascript:void(0)" onclick="javascipt:void(0)" class="btn btn-success btn-sm" data-dismiss="modal">确定
				</a>
			</div>
		</div>
	</div>
</div>

<!-- 增加  -->
<div class="modal fade" id="insertDia" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>
					<i class="glyphicon glyphicon-edit"></i>添加信息
				</h3>
			</div>
			<div class="modal-body" id="infoFrom">
				<ul>
					<li>地区： <select id="district">
							<option value="">--请选择--</option>
							<option value="内陆">内陆</option>
							<option value="中国大陆">中国大陆</option>
							<option value="美国">美国</option>
							<option value="英国">英国</option>
							<option value="日本">日本</option>
					</select> &nbsp;&nbsp;语言： <select id="language">
							<option value="">--请选择--</option>
							<option value="国语">国语</option>
							<option value="英语">英语</option>
							<option value="德语">德语</option>
							<option value="日语">日语</option>
					</select>
					</li>
					<li>名称： <input type="text" id="filmName" placeholder="影视剧名称" class="blackinput" /></li>
					<li>类型： <input type="text" id="type" placeholder="类型" class="blackinput" /></li>
					<li>导演： <input type="text" id="direct" placeholder="导演" class="blackinput" /></li>
					<li class="center-block" style="margin-left: -35px;">主演</li>
					<li><textarea placeholder="主演" id="protagonist" class="blacktextreply"></textarea></li>
				</ul>
			</div>
			<div class="modal-footer">
				<span id="message" style="color: red;"></span> <a class="btn btn-danger btn-sm" data-dismiss="modal">取消</a> <a class="btn btn-success btn-sm" id="submitBtn">提交</a>
			</div>
		</div>
	</div>
</div>