/**
 * 公用插件
 */
var common =
{
	// 模态框传值
	pushDiaVal : function(dialogId, data)
	{
		$('#' + dialogId).on('show.bs.modal', function(event)
		{
			var a = $(event.relatedTarget);
			var modal = $('#' + dialogId);
			for (x in data)
			{
				modal.find('.modal-body #' + data[x]).html(a.data(data[x]));
			}
		});
	},
	// 加载网页
	loadingBody : function(url, data)
	{
		$.ajax(
		{
			dataType : "html",
			type : "POST",
			url : url,
			data : data,
			beforeSend : function()
			{
				common.showTipLoad();
			},
			success : function(page)
			{
				$("#loadingBody").html(page)
			},
			error : function(er)
			{
				common.showTipError();
			},
		});
	},
	// 加载网页不带效果
	loadingBlankBody : function(url, data)
	{
		$.ajax(
		{
			dataType : "html",
			type : "POST",
			url : url,
			data : data,
			success : function(page)
			{
				$("#loadingBody").html(page)
			},
			error : function(er)
			{
				common.showTipError();
			},
		});
	},
	// 展示加载效果
	showTipLoad : function()
	{
		$("#loadingBody").html("<div id='load' class='center'>Loading...<div class='center'></div></div>");
	},
	// 展示错误效果
	showTipError : function(er)
	{
		$("#loadingbody").html("<div id='load' class='center'>error...<div class='center'></div></div>");
		console.log(er);
	},
}