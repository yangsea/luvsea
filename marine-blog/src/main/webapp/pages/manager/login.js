

//ajax

$.ajax({
	
	url:'login.html',
	data:11
	,
	success:function(){
		
	},error:function(){
		
	},err:function(){
		
	},xxx:111
}
	
		
//		alert("you and me");

)

function loginSub(){
	$("#loginForm").form('submit', {
        url: 'www.baidu.com',
        onSubmit:function() {
            var isValid = $(this).form('validate');
            alert(isValid)
            if (!isValid) {
//                 $.messager.progress('close');
            }
            return isValid;
        }	
	});
}

   $('#customerForm').form('submit', {
	                url: url,
	                onSubmit:function() {
	                    var isValid = $(this).form('validate');
	                    if (!isValid) {
	                        $.messager.progress('close');
	                    }
	                    return isValid;
	                },
	                success: function(data) {
	                    $.messager.progress('close');
	                    data = JSON.parse(data);
	                    if (data.ret=="400001") {
	                    	CustomerApp.close();
	                    	EU.showTopTip('error',"您没有权限");	                    	
	                    }else if(data.ret=="0"){
	                    	EU.showTopTip('success','保存成功！');
	                        parent.CustomerApp.search();
	                        CustomerApp.close();
	                        }
	                    else{
							EU.showTopTip('error',result);
						}
	                }
	            });