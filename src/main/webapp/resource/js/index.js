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
		}
	},
	showDeleteDia : function(dialogId)
	{
		common.pushDiaVal(dialogId, new Array('filmid'))
	},
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
				console.log(result.data)
			},
		});
	},
	init : function()
	{
	}
}