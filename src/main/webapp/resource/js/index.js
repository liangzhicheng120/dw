var index =
{
	url : function()
	{
		return '/demoweb/index/deleteByFilmId'
	},
	deleteByFilmId : function(filmId)
	{
		$.ajax(
		{
			dataType : "json",
			type : "POST",
			url : index.url(),
			data :
			{
				filmId : filmId
			},
			success : function(result)
			{
				console.log(result.data.url)
				console.log(result.data.code)
				console.log(result.data.message)
			},
			error : function(er)
			{
				console.log(er)
			},
		});
	},
	init : function()
	{

	}
}