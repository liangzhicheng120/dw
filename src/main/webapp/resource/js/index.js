var index =
{
	url :
	{
		index : function()
		{
			return '/demoweb/index'
		},
		deleteByFilmId : function()
		{
			return '/demoweb/index/deleteByFilmId'
		},
		clusterTab : function()
		{
			return '/demoweb/index/clusterTab'
		}
	},
	// 初始化页面
	init : function()
	{
		$('#submitBtn').click(function()
		{
			loadingBody()
		})
	},
	// 展开删除模态框
	showDeleteDia : function(dialogId)
	{
		common.pushDiaVal(dialogId, new Array('filmid'))
	},
	// 删除
	deleteByFilmId : function()
	{
		$.ajax(
		{
			dataType : "json",
			type : "POST",
			url : index.url.deleteByFilmId(),
			data :
			{
				filmId : $('#filmid').text()
			},
			success : function(result)
			{
				if (result.data.code == '200')
				{
					common.loadingBody(result.data.url)
				} else
				{
					common.showTipError(result.data.code + ":" + result.data.message)
				}
			},
		});
	},
	// 换页
	changeCurrentPage : function(currentPage)
	{
		common.loadingBlankBody(index.url.clusterTab(),
		{
			// 页数
			currentPage : currentPage
		})
	}
}