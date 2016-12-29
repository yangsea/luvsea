//created by 痴情浪子 201608190919 1.0beta

window.addEventListener("DOMContentLoaded",function() {
        //顶部浮动
		//$$("header").className = 'fixheader';
		//$$$(".float_clear")[0].id = 'fixheader';
		
		var li = $$$(".catalog li");
		var ul = $$$("#ajaxlist ul");
		
		//往ajaxlist里面填充内容
		ajaxlist_ul_html();
		function ajaxlist_ul_html() {
			var html = '';
			for( var i=0;i<10;i++ ){
				    html += '<li>'+
						         '<dl>'+
							          '<dt>'+
								           '<i class="flex">3日</i>'+
									       '<i class="flex">涨4%</i>'+
								      '</dt>'+
								      '<dd class="flex"><img src="images/person.png" /></dd>'+
								      '<dd class="d3">'+
								           '<p>成功率<em class="red">82%</em></p>'+
										   '<p class="bold">步步为营</p>'+
										   '<p>股票代码</p>'+
										   '<p>00****</p>'+
								      '</dd>'+
								      '<dd class="d4 t-r">'+
								           '<p>领先<i class="red">96%</i>的朋友</p>'+
										   '<p class="yellow">关注</p>'+
										   '<p>2016-08-01起算</p>'+
										   '<p>28元阅读<span><img src="images/eyes.png" />6人</span></p>'+
								      '</dd>'+
							     '</dl>'+
						    '</li>';
			}
			//console.log(html);
			for( var i=0; i<ul.length;i++ ){
				ul[i].innerHTML = html;
			}
		}
		
		//ajaxlist列表切换
		ajaxlist_ul_chioce();
		function ajaxlist_ul_chioce(){
			    //初始状态下的列表开关
				chioce();
				function chioce(){
					for( var i=0; i<li.length;i++ ){
						if( li[i].className == 'current' ){
							for( var j=0;j<ul.length;j++ ){
								if( ul[j].className == li[i].id ){
									ul[j].style.display = 'block';
									ul[j].id = 'current';
								}else{
									ul[j].style.display = 'none';
									ul[j].id = '';
								}
							}
						}
					}
				}
				
				//点击列表切换
				$(".catalog li").click(function(){
					for( var i=0;i<li.length;i++ ){
						li[i].className = '';
					}
					this.className = 'current';
					chioce();
					is_scroller = true;
				})
		}
		
		//ajax无限列表
		ajax_scroll();
		var is_scroller = true;
		function ajax_scroll(){
				var waterfull = {
						num:0,
						init: function() { 
							window.onscroll=this.throttle(this.isScroll,150);
							this.isScroll();//初始化
						},
						isScroll:function(){
							var wh = window.screen.availHeight; //屏幕高度
							var sh = document.body.scrollTop; //页面上翻的高度
							var zh = document.body.scrollHeight; //页面总高度
							console.log(wh,sh,zh);
							if( wh + sh >= zh ){ //判断和
							    var html = '';
								for(var j=0;j<10;j++){//列表代码
									html +='<li>'+
												 '<dl>'+
													  '<dt>'+
														   '<i class="flex">3日</i>'+
														   '<i class="flex">涨4%</i>'+
													  '</dt>'+
													  '<dd class="flex"><img src="images/person.png" /></dd>'+
													  '<dd class="d3">'+
														   '<p>成功率<em class="red">82%</em></p>'+
														   '<p class="bold">步步为营</p>'+
														   '<p>股票代码</p>'+
														   '<p>00****</p>'+
													  '</dd>'+
													  '<dd class="d4 t-r">'+
														   '<p>领先<i class="red">96%</i>的朋友</p>'+
														   '<p class="yellow">关注</p>'+
														   '<p>2016-08-01起算</p>'+
														   '<p>28元阅读<span class="flex"><img src="images/eyes.png" />6人</span></p>'+
													  '</dd>'+
												 '</dl>'+
											'</li>';
									waterfull.num++;
								}
								$$("#current").innerHTML += html;
								if($$$('#current li').length >= 100){
									is_scroller = false;
									$$("#loading").style.display = 'none';
									$$("#nomore").style.display = 'flex';
								}
								else{
									$$("#loading").style.display = 'flex';
									$$("#nomore").style.display = 'none';
								}
							}
						},
						throttle: function(fn,delay){
							var timer = null;
							var _this=this;
							return function(){
								var context = _this, args = arguments;
								clearTimeout(timer);
								if(is_scroller && $$$('#current li').length >= 10){
									$$("#loading").style.display = 'flex';
									$$("#nomore").style.display = 'none';
									timer = setTimeout(function(){
										fn.apply(context,args)}, delay);
								}
							};
						}
				}
				waterfull.init( );//瀑布流
		}
		


	
})