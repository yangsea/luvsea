<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title></title>
    <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
        <script type="text/javascript" src="common.js"></script>
    <script type="text/javascript">
    (function WX_API(){
    	
            var url = 'http://ocean.iask.in/user/getConfigJs?url='+encodeURIComponent(location.href.split('#')[0]);
            
            alert(url);
//             alert(location.href.split('#')[0]);
//             alert(encodeURIComponent(location.href.split('#')[0]));
            ajaxjson('POST',url,do_result);
            function do_result(result){
                    if(result.success){
//                     	alert(result);
                    	
                            var results = JSON.parse(result.result);
                            console.log(results);
                            
                            alert( results.appId);
                            alert( results.nonceStr);
                            alert( results.timestamp);
                            alert( results.signature);
                            
                            wx.config({    
                                debug: true,    
                                appId: results.appId,    
                                timestamp: parseInt(results.timestamp),    
                                nonceStr: results.nonceStr,    
                                signature: results.signature,    
// 							    appId: '', // 必填，公众号的唯一标识
// 							    timestamp: , // 必填，生成签名的时间戳
// 							    nonceStr: '', // 必填，生成签名的随机串
// 							    signature: '',// 必填，签名，见附录1
                                jsApiList: ['checkJsApi','scanQRCode']    
                            });
                            wx.ready(function () {
                            });
                            wx.error(function(res){
//                                 alert('wx.error: '+JSON.stringify(res));
                            });
                    }else{
                    }
            }
    })();

    </script>
</head>
<body>
<h2>Hello Wechat!</h2>
<input type="button" onclick="WX_API()" value="点击测试微信js验证" />
</body>
</html>
