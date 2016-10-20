/**
 * Created by caoqi on 2014/10/20.
 */

var CustomerApp = function() {
    return {
        init: function() {
        	 $('#customerGrid').datagrid({
                 frozenColumns:[[{field:'ck', checkbox:true}]],
                 columns:[[
                     {field:'content', title:'问题内容', width:'30%', align:'center'},               
                     {field:'createdDatetime', title:'创建时间', width:'30%', align:'center',
                    	 formatter: function(value,row,index){
			        		   return new Date(value).toLocaleString();
				         }
                     },
                     {field:'userName', title:'负责人', width:'30%', align:'center',
                    	 formatter: function(value,row,index){
                             if(!!row.realName){
                                 return row.userName + " ( " + row.realName + " )";
                             }else{
                                 return row.userName;
                             }
                         }
                     }
                 ]],
                 fitColumns:true,
                 idField:'id',
                 nowrap:false,
                 pagination:true,
                 rownumbers:true,
                 checkOnSelect:false,
                 selectOnCheck:true,
                 singleSelect:true,
                 method:'post',
                 pageSize:8,
                 pageList: [8,10,20],
                 toolbar: [{
                     iconCls: 'ges-add',
                     handler: function() {
                     	EU.dialog("win",{
                             title: '新增问题',
                             width:"65%",
                             height:"40%",
                             href: $('#APP_ROOT_PATH').val() +'/customerView/question_detail?userId='+$('#ID').val()
                         });
                     }
                 }
//                 , '-', {
//                     iconCls: 'ges-remove',
//                     handler: function() {
//                         CustomerApp.deleterow();
//                     }
//                 }
                 ],
                 onLoadError: function(data) {
                     EU.showTopTip('error',"分页数据加载发生错误");
                 },
//                 onDblClickRow:function(row, data){
//                     EU.dialog("win",{
//                         title: '问题详情',
//                         width:"60%",
//                         height:"40%",
//                         href: $('#APP_ROOT_PATH').val() +'/shop/question_detail?id=' + data.id
//                     });
////                     EU.dialog.close("win");
//                 },
                 url:$('#APP_ROOT_PATH').val() + '/customerJson/list_question?user.id='+$('#ID').val()
             });
        	if($("#hid_expectedDecorationDate").val()!=""){
				$("#expectedDecorationDate").datebox("setValue",$("#hid_expectedDecorationDate").val());
			}
        	CustomerApp.autoLoad();
        	
        	//楼盘
            var building = $("#building_id").val();
            $('#building').combobox({
                url:$('#APP_ROOT_PATH').val() + '/buildingJson/list_building',
                editable:false,
                loadFilter: function(data) {
  					if (data.result) {
  						return data.result;
  					} else {
  						return data;
  					}
  				 },
                valueField:'id',
                textField:'name',
                panelHeight:250
            }).combobox("setValue",building);
            
        	 var operator_id = $("#operator_id").val();
             $('#operator').combobox({
                 url:$('#APP_ROOT_PATH').val() + '/customerJson/listdata',
                 loadFilter: function(data) {
  					if (data.result) {
  						return data.result;
  					} else {
  						return data;
  					}
  				 },
                 editable:false,
                 valueField:'id',
                 textField:'contactName',
                 panelHeight:250,
                 onSelect:function(rec) {
                     $('#shop').combobox({
                         url:$('#APP_ROOT_PATH').val() + '/customerJson/listshops?operator.id='+rec.id,
                         editable:false,
                         loadFilter: function(data) {
           					if (data.result) {
           						return data.result;
           					} else {
           						return data;
           					}
           				 },
                         valueField:'id',
                         textField:'name',
                         panelHeight:250
                     });
                 }
             }).combobox("setValue",operator_id);
             
             if(operator_id!=null&&operator_id!=""){
            	 $('#shop').combobox({
                     url:$('#APP_ROOT_PATH').val() + '/customerJson/listshops?operator.id='+operator_id,
                     loadFilter: function(data) {
     					if (data.result) {
     						return data.result;
     					} else {
     						return data;
     					}
     				 },
                     editable:false,
                     valueField:'id',
                     textField:'name',
                     panelHeight:250
                 });
             	$('#shop').combobox('setValue',$("#shop_id").val());
             }else{
            	 
            	 $('#shop').combobox({
            		 url: '',
            		 editable:false,
            		 valueField:'id',
            		 textField:'name',
            		 panelHeight:250
            	 });
             }
             //职业类型combox
             var jobTypeParentId = $("#jobTypeParentId").val();
             if(jobTypeParentId!=null&&jobTypeParentId!=""){
            	 $('#jobType').combobox({
                     url:$('#APP_ROOT_PATH').val() + '/customerJson/dictionaryByParentId?parentId='+jobTypeParentId,
                     loadFilter: function(data) {
     					if (data.result) {
     						return data.result;
     					} else {
     						return data;
     					}
     				 },
                     editable:false,
                     valueField:'id',
                     textField:'text',
                     panelHeight:'auto'
                 });
             	$('#jobType').combobox('setValue',$("#job_type_id").val());
             }
             //客户关注
             var customerFocusParentId = $("#customerFocusParentId").val();
             if(customerFocusParentId!=null&&customerFocusParentId!=""){
            	 $('#customerFocus').combobox({
                     url:$('#APP_ROOT_PATH').val() + '/customerJson/dictionaryByParentId?parentId='+customerFocusParentId,
                     loadFilter: function(data) {
     					if (data.result) {
     						return data.result;
     					} else {
     						return data;
     					}
     				 },
                     editable:false,
                     valueField:'id',
                     textField:'text',
                     panelHeight:'auto'
                 });
             	$('#customerFocus').combobox('setValue',$("#dictionary_focus_id").val());
             }
             //居住情况
             var livingConditionId = $("#livingConditionId").val();
             if(livingConditionId!=null&&livingConditionId!=""){
            	 $('#livingCondition').combobox({
                     url:$('#APP_ROOT_PATH').val() + '/customerJson/dictionaryByParentId?parentId='+livingConditionId,
                     loadFilter: function(data) {
     					if (data.result) {
     						return data.result;
     					} else {
     						return data;
     					}
     				 },
                     editable:false,
                     valueField:'id',
                     textField:'text',
                     panelHeight:'auto'
                 });
             	$('#livingCondition').combobox('setValue',$("#dictionay_living_id").val());
             }
             //行业了解度
             var industryUnderstandingLevelId = $("#industryUnderstandingLevelId").val();
             if(industryUnderstandingLevelId!=null&&industryUnderstandingLevelId!=""){
            	 $('#industryUnderstandingLevel').combobox({
                     url:$('#APP_ROOT_PATH').val() + '/customerJson/dictionaryByParentId?parentId='+industryUnderstandingLevelId,
                     loadFilter: function(data) {
     					if (data.result) {
     						return data.result;
     					} else {
     						return data;
     					}
     				 },
                     editable:false,
                     valueField:'id',
                     textField:'text',
                     panelHeight:'auto'
                 });
             	$('#industryUnderstandingLevel').combobox('setValue',$("#dictionary_understanding_level_id").val());
             }
             
        	
        },
        //保存按钮
        save: function() {        	
        	var url = $('#APP_ROOT_PATH').val() + '/customerJson/save_customer';
        	if($("#ID").val()!=""&&$("#ID").val()!=null){
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
        	}
        	else{
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
	                	data = JSON.parse(data);
	                    if (data.ret=="0") {
	                    	var url = $('#APP_ROOT_PATH').val() + '/customerJson/save_customerQuestion?customer.id='+data.result;
	                    	$('#customerQuestion').form('submit', {
	        	                url: url,
	        	                onSubmit:function() {
	        	                    var isValid = $(this).form('validate');
	        	                    if (!isValid) {
	        	                        $.messager.progress('close');
	        	                    }
	        	                    return isValid;
	        	                },
	        	                success: function(data) {
	        	                	data = JSON.parse(data);
	        	                	if (data.ret=="0") {
	        	                    	parent.CustomerApp.init();
	        	                        EU.showTopTip('success','保存成功！');
	        	                        CustomerApp.close();
	        	                    }else{
	        							EU.showTopTip('error',result);
	        						}
	        	                }
	        	            });
	                    }else{
							EU.showTopTip('error',result);
						}
	                }
	            });
        		
        	}
        },
        //关闭按钮
        close: function() {
            //parent.parent.closeTab('订单详情');
            parent.EU.dialog.close("win");
        },
        autoLoad:function(){
        	$("#phone").textbox({
        		onChange:function(newValue,oldValue){
        			if(newValue.length!=11){
        				return false;
        			}
        			gui.util.Ajax.asyncGET($('#APP_ROOT_PATH').val() + '/shop/customer_info_by_phone' ,{"phone":newValue},function(data){
            			if(data.errorCode){
    	                  	EU.showTopTip('error',data.errorMsg);
    	                  	return;
    	                }
            			if(data>0){
            				location.href=$('#APP_ROOT_PATH').val() + '/customerJson/customer_info?id='+data;
                      	}
            		},
            		function(){
            			EU.showTopTip('error','获取手机绑定信息失败！');
            		});
            	}
        	});
        }

    };
}();


