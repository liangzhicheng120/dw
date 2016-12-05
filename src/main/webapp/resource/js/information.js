// ȡ���ϴ�
function closeInfo()
{
	var img = $("#keyfilename").val();
	if (img != '')
	{
		$.ajax(
		{
			url : 'closeInfo.html',
			async : false,
			data :
			{
				img : img
			},
			error : function(er)
			{
				console.log(er);
			}
		});
	}
	$("#fabu").modal('hide');
};
// չ��ģ̬��
function shouInfoDialog()
{
	$.ajax(
	{
		url : 'showDialog.html',
		dataType : 'html',
		success : function(page)
		{
			$("#dialog").html(page);
			$("#fabu").modal(
			{
				show : true, // ��ʾ������
				backdrop : 'static', // ��ֹλ�ùر�
				keyboard : false, // �رռ����¼�
			});
		}
	})
}
// �첽���ص���
function getoption(osel)
{
	document.getElementById('info_district').options.length = 0;
	$.ajax(
	{
		url : "option.html",
		dataType : "json",
		type : "POST",
		data :
		{
			city : osel.options[osel.selectedIndex].value
		},
		success : function(responseData, status)
		{
			$(responseData).each(function(n)
			{
				$("<option/>").html(this.district).appendTo("#info_district");
			});
		},
		error : function(er)
		{
			console.log(er); // TODO er
		}
	});
}
// �����ı���Ϣ
function resetText()
{

	$("#info-title").val('');
	$("#info-content").val('');
}

// ѡ�����
function changeInfoCity(osel)
{

	$("#district").val("");
	ajaxGetPageBlack("information.html",
	{
		city : osel.options[osel.selectedIndex].value,
		district : $("#district").val(),
		time : $("#time").val()
	});

};
// ѡ�����
function changeInfoDistrict(osel)
{

	ajaxGetPageBlack("information.html",
	{
		district : osel.options[osel.selectedIndex].value,
		city : $("#city").val(),
		time : $("#time").val()
	});

};

// ������ѯ
function saveInformation()
{
	var a = $("#info_title").val();
	var b = $("#info_content").val();
	var c = $("#info_city").find("option:selected").text();
	var d = $("#info_district").find("option:selected").text();
	var e = $("#keyfilename").val();
	var f = $("#message");
	f.html('');

	if (a == '' || b == '' || c == '\u57CE\u5E02' || d == '\u5730\u533A')
	{
		f.html('\u8BF7\u586B\u5199\u5B8C\u6574\u4FE1\u606F\uFF01');
		return;
	}
	if (e == '')
	{
		f.html('\u8BF7\u4E0A\u4F20\u56FE\u7247\uFF01');
		return;
	}

	ajaxSubmitForm("#informationFrom", "#fabu");
};

// ����ɾ����Ѷ
function deleteInfoBatch()
{

	batchInfoOperate("deleteBatchInfo.html");
}

// ѡ��ʱ��
function changeTime(osel)
{

	var option = osel.options[osel.selectedIndex].value;
	var time;

	if (option == '\u8FD1\u5341\u5929')
	{
		time = 10;
	}
	else if (option == '\u8FD1\u4E00\u4E2A\u6708')
	{
		time = 30
	}
	else if (option == '\u8FD1\u4E09\u4E2A\u6708')
	{
		time = 90;
	}

	ajaxGetPageBlack("information.html",
	{
		title : $("#title").val().trim(),
		time : time,
		city : $("#city").val(),
		district : $("#district").val()
	});
}

// ������Ѷ
function searchInfo()
{

	ajaxGetPageBlack("information.html",
	{
		title : $("#title").val().trim(),
		time : $("#time").val(),
		city : $("#city").val(),
		district : $("#district").val()
	});
}
// ��ҳ
function changeInfoPage(currentPage)
{

	ajaxGetPageBlack("information.html",
	{
		currentPage : currentPage,
		title : $("#title").val().trim(),
		time : $("#time").val(),
		city : $("#city").val(),
		district : $("#district").val()
	});
};

// �鿴��Ѷģ̬��
modalPutData('showInfo', new Array('title', 'time', 'area', 'content'));
// �����������÷���
function batchInfoOperate(url)
{

	obj = document.getElementsByName("checkbox_id");
	ids = [];
	imgs = [];
	for (k in obj)
	{
		if (obj[k].checked)
		{
			ids.push(obj[k].value);
			imgs.push($(obj[k]).next().val());
		}
	}

	ajaxGetPageBlack(url,
	{
		ids : ids.join(","),
		imgs : imgs.join(","),
		title : $("#title").val().trim(),
		currentPage : $("#currentPage").val(),
		time : $("#time").val(),
		city : $("#city").val(),
		district : $("#district").val()
	});
};