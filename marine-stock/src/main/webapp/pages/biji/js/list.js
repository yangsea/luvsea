//created by 痴情浪子 201609012257 1.0beta

window.addEventListener("DOMContentLoaded",function() {
	
	    //headerfix
		var elm = $('.ltitle');
		var startPos = elm.offset().top;
		$.event.add(window, "scroll", function() {
				var p = document.body.scrollTop;
				if (parseInt(p) > parseInt(startPos)) {
						$$(".ltitle").classList.add("fix");
				}else if (parseInt(p) < parseInt(startPos)){				
						$$(".ltitle").classList.remove("fix");				
				}
		});
	   
		
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
									html +='<ul><a href="detail.html">'+
												 '<li><p>002805</p><p>(热点型)</p></li>'+
												 '<li><p>丰元股份</p><p>(基础化工业)</p></li>'+
												 '<li><p>买点58.75</p><p>买点60.36</p><p>买点60.42</p></li>'+
												 '<li><p>61.95</p></li>'+
												 '<li><p>短线风险5.37</p><p>綜合风险29.29</p></li>'+
										   '</a></ul>'+
										   '<ul><a href="detail.html">'+
												 '<li><p>002664</p><p>(量化型)</p></li>'+
											     '<li><p>信质电机</p><p>(机械行业)</p></li>'+
												 '<li><p>买点27.01</p><p>买点27.38</p><p>买点27.41</p></li>'+
												 '<li><p>27.6</p></li>'+
												 '<li><p>短线风险21.76</p><p>綜合风险37.25</p></li>'+
										   '</a></ul>'+
										   '<ul><a href="detail.html">'+
											     '<li><p>000555</p><p>(量化型)</p></li>'+
												 '<li><p>神州信息</p><p>(通信及通信设备)</p></li>'+
												 '<li><p>买点30.74</p><p>买点31.15</p><p>买点31.18</p></li>'+
												 '<li><p>31.38</p></li>'+
												 '<li><p>短线风险-7.44</p><p>綜合风险13.27</p></li>'+
											'</a></ul>';
									waterfull.num++;
								}
								$$("#ajaxlist").innerHTML += html;
								if($$$('#ajaxlist ul').length >= 100){
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
								if(is_scroller && $$$('#ajaxlist ul').length >= 10){
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