/*modified by 潘正龙QQ:315065690 201701051123 Official version3.2*/
var browser = {
	versions : function() {
		var u = navigator.userAgent, app = navigator.appVersion;
		return {
			trident : u.indexOf('Trident') > -1,
			presto : u.indexOf('Presto') > -1,
			webKit : u.indexOf('AppleWebKit') > -1,
			gecko : u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1,
			mobile : !!u.match(/AppleWebKit.*Mobile.*/)
					|| !!u.match(/AppleWebKit/),
			ios : !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),
			android : u.indexOf('Android') > -1 || u.indexOf('Linux') > -1,
			iPhone : u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1,
			iPad : u.indexOf('iPad') > -1,
			webApp : u.indexOf('Safari') == -1,
			QQbrw : u.indexOf('MQQBrowser') > -1,
			weiXin : u.indexOf('MicroMessenger') > -1,
			ucLowEnd : u.indexOf('UCWEB7.') > -1,
			ucSpecial : u.indexOf('rv:1.2.3.4') > -1,
			ucweb : function() {
				try {
					return parseFloat(u.match(/ucweb\d+\.\d+/gi).toString()
							.match(/\d+\.\d+/).toString()) >= 8.2
				} catch (e) {
					if (u.indexOf('UC') > -1) {
						return true
					} else {
						return false
					}
				}
			}(),
			Symbian : u.indexOf('Symbian') > -1,
			ucSB : u.indexOf('Firefox/1.') > -1
		}
	}()
};
if (!browser.versions.weiXin) {
	window.location.href = 'http://ready.ycwemedia.com/userwx/authWithHTML';
};
function jsontoarray(d) {
	var b = [];
	var c = 0;
	for ( var a in d.data) {
		b[c] = new Array();
		b[c][0] = parseInt(String(a), 10);
		b[c][1] = parseInt(String(d.data[a]), 10);
		c = c + 1
	}
	b.sort(function(e, f) {
		return e[0] > f[0]
	});
	for (c = 0; c < b.length; c++) {
		b[c][0] = b[c][0] + d.xunit
	}
	return b
}
function jsontoarrays(d) {
	var b = [];
	var c = 0;
	for ( var a in d.data) {
		b[c] = new Array();
		b[c][0] = String(a);
		b[c][1] = parseInt(String(d.data[a]), 10);
		c = c + 1
	}
	b.sort(function(e, f) {
		return e[0].localeCompare(f[0])
	});
	for (c = 0; c < b.length; c++) {
		b[c][0] = b[c][0] + d.xunit
	}
	return b
}
function isEmpty(b) {
	for ( var a in b) {
		return false
	}
	return true
}
function getURLParam(k, n) {
	var l = "";
	var m = n;
	if (m.indexOf("?") > -1) {
		var o = m.substr(m.indexOf("?") + 1);
		var j = o.split("&");
		for (var p = 0; p < j.length; p++) {
			if (j[p].indexOf(k + "=") == 0) {
				var i = j[p].split("=");
				l = i[1];
				break
			}
		}
	}
	return l
}
function ajaxjson(g, a, d, f) {
	var c = false;
	function b() {
		try {
			c = new ActiveXObject("Msxml2.XMLHTTP")
		} catch (j) {
			try {
				c = new ActiveXObject("Microsoft.XMLHTTP")
			} catch (i) {
				c = false
			}
		}
		if (!c && typeof XMLHttpRequest != "undefined") {
			c = new XMLHttpRequest()
		}
	}
	function h() {
		if (c.readyState == 4) {
			if (c.status == 200) {
				d(JSON.parse(c.responseText))
			}
		}
	}
	b();
	var e = (new Date()).valueOf();
	if (a.indexOf("?") != -1) {
		a = a + "&t=" + e
	} else {
		a = a + "?t=" + e
	}
	c.open(g, a, true);
	c.onreadystatechange = h;
	if (g == "GET") {
		c.send(null)
	}
	if (g == "POST") {
		c.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		c.send(JSON.stringify(f))
	}
}
(function() {
	if (typeof (WeixinJSBridge) == "undefined") {
		document.addEventListener("WeixinJSBridgeReady", function(e) {
			setTimeout(function() {
				WeixinJSBridge.invoke("setFontSizeCallback", {
					"fontSize" : 0
				}, function(res) {
				})
			}, 0)
		})
	} else {
		setTimeout(function() {
			WeixinJSBridge.invoke("setFontSizeCallback", {
				"fontSize" : 0
			}, function(res) {
			})
		}, 0)
	}
})();
function ACS(obj, cls) {
	var obj_class = obj.className;
	var blank = (obj_class != "") ? " " : "";
	var added = obj_class + blank + cls;
	obj.className = added
}
function RCS(obj, cls) {
	var obj_class = " " + obj.className + " ";
	obj_class = obj_class.replace(/(\s+)/gi, " ");
	var removed = obj_class.replace(" " + cls + " ", " ");
	removed = removed.replace(/(^\s+)|(\s+$)/g, "");
	obj.className = removed
}
function HCS(obj, cls) {
	var obj_class = obj.className;
	var obj_class_lst = obj_class.split(/\s+/);
	var x = 0;
	for (x in obj_class_lst) {
		if (obj_class_lst[x] == cls) {
			return true
		}
	}
	return false
}
var TimeMap = '' + new Date().getFullYear() + '' + (new Date().getMonth() + 1)
		+ '' + new Date().getDate() + '' + new Date().getHours() + ''
		+ new Date().getMinutes() + '' + new Date().getSeconds() + '';
var HostUrl = 'http://ready.ycwemedia.com';
var imgUrl = 'http://webimg.ycwemedia.com/guangdong';
var EID = 11;
$$ = function(selector) {
	return document.querySelector(selector)
};
$$$ = function(selector) {
	return document.querySelectorAll(selector)
};
var agent = navigator.userAgent.toLowerCase();
var version;
if (agent.indexOf("like mac os x") > 0) {
	var regStr_saf = /os [\d._]*/gi;
	var verinfo = agent.match(regStr_saf);
	version = (verinfo + "").replace(/[^0-9|_.]/ig, "").replace(/_/ig, ".")
}
var version_str = version + "";
function ios_detect() {
	if (version_str != "undefined" && version_str.length > 0) {
		version = parseInt(version);
		if (version > 8) {
			for (var i = 0; i < $$$('.chioce ul').length; i++) {
				$$$(".chioce ul")[i].classList.add("ul");
			}
		}
	}
};
var _hmt = _hmt || [];
(function() {
	var hm = document.createElement("script");
	hm.src = "https://hm.baidu.com/hm.js?679f3c84261a92be9496a7c89f95bb64";
	var s = document.getElementsByTagName("script")[0];
	s.parentNode.insertBefore(hm, s);
})();
