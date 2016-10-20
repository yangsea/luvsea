<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="../../uiframe/jquery-easyui-1.4.5/plugins/jquery.form.js"></script>
<script type="text/javascript">
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
</script>
</head>
<body>

</body>
</html>