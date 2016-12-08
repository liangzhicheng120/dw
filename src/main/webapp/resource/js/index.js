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
		},
		insertTab : function()
		{
			return '/demoweb/index/insertTab'
		},
		startCluster : function()
		{
			return '/demoweb/index/startCluster'
		}
	},
	// 初始化页面
	init : function()
	{
		// 提交信息
		$('#submitBtn').click(function()
		{
			if ($('#filmName').val() == '' || $('#language').val() == '' || $('#district').val() == '')
			{
				$('#message').html('Please fill all the information!')
				return false
			}
			$.ajax(
			{
				dataType : "json",
				type : "POST",
				url : index.url.insertTab(),
				data :
				{
					filmName : $('#filmName').val(),
					direct : $('#direct').val(),
					protagonist : $('#protagonist').val(),
					type : $('#type').val(),
					district : $('#district').val(),
					language : $('#language').val(),
					currentPage : $('#currentPage').val()
				},
				beforeSend : function()
				{
					$('#message').html('')
				},
				success : function(result)
				{
					index.isSuccess(result.data.url, result.data.code, result.data.message,
					{
						currentPage : $('#currentPage').val()
					});
					$('#message').html('Insert a message successfully!')
				},
				error : function(er)
				{
					$('#message').html(er)
				},
			});
		})
	},
	searchByClusterType : function()
	{
		common.loadingBlankBody(index.url.clusterTab(),
		{
			currentPage : $('#currentPage').val(),
			clustertype : $('#clustertype').val()
		})
	},
	startCluster : function()
	{
		// 启动聚类
		$.ajax(
		{
			dataType : "json",
			type : "POST",
			url : index.url.startCluster(),
			beforeSend : function()
			{
				common.showTipLoad()
			},
			success : function(result)
			{
				index.isSuccess(result.data.url, result.data.code, result.data.message,
				{
					currentPage : $('#currentPage').val(),
					clustertype : $('#clustertype').val()
				});
			}
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
				filmId : $('#filmid').text(),
				clustertype : $('#clustertype').val()
			},
			success : function(result)
			{
				index.isSuccess(result.data.url, result.data.code, result.data.message,
				{
					currentPage : $('#currentPage').val(),
					clustertype : $('#clustertype').val()
				})
			},
		});
	},
	isSuccess : function(url, code, message, data)
	{
		if (code == '200')
		{
			common.loadingBody(url, data)
		} else
		{
			common.showTipError(code + ":" + message)
		}
	},
	// 换页
	changeCurrentPage : function(currentPage)
	{
		common.loadingBlankBody(index.url.clusterTab(),
		{
			// 页数
			currentPage : currentPage,
			clustertype : $('#clustertype').val()
		})
	}
}