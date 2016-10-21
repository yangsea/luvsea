/*powered by 痴情浪子 201606170937 version1.0 beta*/

/*getURLParam方法封装*/function getURLParam(k,n){var l="";var m=n.toLowerCase();if(m.indexOf("?")>-1){var o=m.substr(m.indexOf("?")+1).toLowerCase();var j=o.split("&");for(var p=0;p<j.length;p++){if(j[p].indexOf(k.toLowerCase()+"=")==0){var i=j[p].split("=");l=i[1];break}}}return l};/*字体重置*/(function(){if(typeof(WeixinJSBridge)=="undefined"){document.addEventListener("WeixinJSBridgeReady",function(e){setTimeout(function(){WeixinJSBridge.invoke("setFontSizeCallback",{"fontSize":0},function(res){})},0)})}else{setTimeout(function(){WeixinJSBridge.invoke("setFontSizeCallback",{"fontSize":0},function(res){})},0)}})();/*通用选择器*/$$=function(selector){return document.querySelector(selector)};$$$=function(selector){return document.querySelectorAll(selector)};

//全局变量UID
var uid = getURLParam('uid',window.location.href);
console.log(uid);

//通用错误页面的新加内容
var co_err = '';
function co_err_html(){
         co_err += '<div id="co_err" style="display:none;">'+
		                        '<i><img src="images/co_err.png" /></i>'+
								'<span></span>'+
								'<em></em>'+
				   '</div>';
};

//IOS探针兼容代码
var agent = navigator.userAgent.toLowerCase() ;
var version;
if(agent.indexOf("like mac os x") > 0){
		var regStr_saf = /os [\d._]*/gi ;
		var verinfo = agent.match(regStr_saf) ;
		version = (verinfo+"").replace(/[^0-9|_.]/ig,"").replace(/_/ig,".");
}
var version_str = version+"";
function ios_detect(){
		if(version_str != "undefined" && version_str.length >0){
				version=version.substring(0,1);
				if(version>8){
							   $$(".chioce ul").className = 'ul';
				}
		}
}
