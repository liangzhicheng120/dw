var index =
{
	url : function()
	{
		return '/demoweb/index/deleteByFilmId'
	},
	deleteByFilmId : function(filmId)
	{
		console.log(filmId)
		$.ajax(
		{
			dataType : "json",
			type : "POST",
			url : index.url(),
			data :
			{
				filmId : filmId
			},
			success : function(data)
			{
				console.log(data.url)
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