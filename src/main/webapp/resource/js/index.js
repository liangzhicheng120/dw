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
		},
		deleteInfoByIds : function()
		{
			return '/demoweb/index/deleteInfoByIds'
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
					filmName : $('#filmName').val().trim(),
					direct : $('#direct').val().trim(),
					protagonist : $('#protagonist').val().trim(),
					type : $('#type').val().trim(),
					district : $('#district').val().trim(),
					language : $('#language').val().trim(),
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
	// 搜索
	searchByClusterType : function()
	{
		common.loadingBlankBody(index.url.clusterTab(),
		{
			currentPage : $('#currentPage').val(),
			clustertype : $('#clustertype').val().trim()
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
	// 判断返回值是否正确
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
	},
	// 通过一组id删除所有信息
	deleteInfoByIds : function()
	{
		$.ajax(
		{
			dataType : "json",
			type : "POST",
			url : index.url.deleteInfoByIds(),
			data :
			{
				ids : common.batchOperate(),
				clustertype : $('#clustertype').val(),
				currentPage : $('#currentPage').val()
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
	}
}