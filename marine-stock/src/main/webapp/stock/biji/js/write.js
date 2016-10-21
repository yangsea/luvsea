//created by 痴情浪子 201609021028 1.0beta

window.addEventListener("DOMContentLoaded",function() {	
        //错误弹窗提示
		var html = '<div id="center" class="notice">'+
							'<center class="scale">'+
									'<i></i>'+
									'<span>确定</span>'+
							'</center>'+
				   '</div>';
		$$('body').innerHTML += html;
		$$("#center span").addEventListener('click',function(){
			$$("#center").style.display = 'none';
		})
		
		//设置组件参数，日历控件js
		var starts = $$("#start").value;
		var ends = $$("#end").value;
		var currYear = (new Date()).getFullYear();
		var myDate = new Date();
		var Y = myDate.getFullYear();
		var M = myDate.getMonth();
		var D = myDate.getDate();
		var opt = {};
		opt.date = {preset : 'date', minDate: new Date(Y,M,D), maxDate: new Date(Y + 10,M,D) };
		opt.default = {
			theme: 'android-ics light', //皮肤样式
			display: 'bottom', //显示方式 
			mode: 'scroller', //日期选择模式
			lang: 'zh',
			dateFormat: 'yyyy-mm-dd',
		};
		$("#start").val(starts).scroller('destroy').scroller($.extend(opt['date'], opt['default']));
		$("#end").val(ends).scroller('destroy').scroller($.extend(opt['date'], opt['default']));
		
        //设置input属性,重置fix标签
		for( var i=0;i<$$$('input').length;i++ ){
			if( $$$('input')[i].id == 'start' || $$$('input')[i].id == 'end' ){
				
			}else{
					$$$('input')[i].addEventListener('focus',function(){
						fix_destory();
					})
					$$$('input')[i].addEventListener('blur',function(){
						fix_add();
					})
			}
		}
		for( var i=0;i<$$$('textarea').length;i++ ){
				$$$('textarea')[i].addEventListener('focus',function(){
					fix_destory();
				})
				$$$('textarea')[i].addEventListener('blur',function(){
					fix_add();
				})
		}
		function fix_destory(){
			    $$('body').classList.add('destroy');
		}
		function fix_add(){
			    $$('body').classList.remove('destroy');
		}
		
		//选择,js方法
		for( var i=0;i<$$$(".Wul li dd b").length;i++ ){
			$$$(".Wul li dd b")[i].addEventListener("click",function(){
				var that = this.parentNode.className;
                for(var j=0;j<$$$("."+that+" b").length;j++){
					if( $$$("."+that+" b")[j] == this ){
						this.classList.add('selected');
						this.parentNode.setAttribute(that,j+1);
					}else{
						$$$("."+that+" b")[j].classList.remove('selected');
					}
				}
			})
		}
		
		//如何提升定价
		$$('.d6 span').addEventListener("click",function(){
                var chtml = '<div class="chioce MFR">'+
	                            '<ul>'+
				                     '<p>轴承及配件、汽摩配件、金属材料、有色金属、橡塑制品、陶瓷制品、装饰装修材料、建材、机电设备及配件、化工产品（除危险化学品、监控化学品、烟花爆竹、民用爆炸物品、易制毒化学品）的销售，电子商务（不得从事增值电信、金融业务）。【依法须经批准的项目，经相关部门批准后方可开展经营活动】</p>'+
					                 '<p>轴承及配件、汽摩配件、金属材料、有色金属、橡塑制品、陶瓷制品、装饰装修材料、建材、机电设备及配件、化工产品（除危险化学品、监控化学品、烟花爆竹、民用爆炸物品、易制毒化学品）的销售，电子商务（不得从事增值电信、金融业务）。【依法须经批准的项目，经相关部门批准后方可开展经营活动】</p>'+
									 '<p>轴承及配件、汽摩配件、金属材料、有色金属、橡塑制品、陶瓷制品、装饰装修材料、建材、机电设备及配件、化工产品（除危险化学品、监控化学品、烟花爆竹、民用爆炸物品、易制毒化学品）的销售，电子商务（不得从事增值电信、金融业务）。【依法须经批准的项目，经相关部门批准后方可开展经营活动】</p>'+
									 '<p>轴承及配件、汽摩配件、金属材料、有色金属、橡塑制品、陶瓷制品、装饰装修材料、建材、机电设备及配件、化工产品（除危险化学品、监控化学品、烟花爆竹、民用爆炸物品、易制毒化学品）的销售，电子商务（不得从事增值电信、金融业务）。【依法须经批准的项目，经相关部门批准后方可开展经营活动】</p>'+
									 '<p>轴承及配件、汽摩配件、金属材料、有色金属、橡塑制品、陶瓷制品、装饰装修材料、建材、机电设备及配件、化工产品（除危险化学品、监控化学品、烟花爆竹、民用爆炸物品、易制毒化学品）的销售，电子商务（不得从事增值电信、金融业务）。【依法须经批准的项目，经相关部门批准后方可开展经营活动】</p>'+
									 '<p>轴承及配件、汽摩配件、金属材料、有色金属、橡塑制品、陶瓷制品、装饰装修材料、建材、机电设备及配件、化工产品（除危险化学品、监控化学品、烟花爆竹、民用爆炸物品、易制毒化学品）的销售，电子商务（不得从事增值电信、金融业务）。【依法须经批准的项目，经相关部门批准后方可开展经营活动】</p>'+
				                '</ul>'+
	                        '</div>'+
	                        '<div class="close"><img src="images/close.png" /></div>';
				$$("#chioce").innerHTML += chtml;
				ios_detect();
				$$("#chioce").style.display = 'block';
				$$(".close img").addEventListener("click",function(){
					$$(".chioce").remove();
					$$(".close").remove();
					$$("#chioce").style.display = 'none';
				})
		})
		
		//页面重置
		$$('.Wul center .float_right').addEventListener("click",function(){
                window.location.href = window.location.href;
		})
		
		//页面提交
		$$('.Wul center .float_left').addEventListener("click",function(){
				var d1 = $$('.d1').getAttribute('d1');
					start = $$("#start").value;
					end = $$("#end").value;
					rate = $$("#rate").value;
					title = $$("#title").value;
					logic = $$("#logic").value;
					price = $$("#price").value;
				if( d1 == null ){
					$$("#center").style.display = 'block';
					$$("#center i").innerHTML = '请选择投资类型！';
					return false;
				}
				if( start == '' ){
					$$("#center").style.display = 'block';
					$$("#center i").innerHTML = '请选择起始时间！';
					return false;
				}
				if( end == '' ){
					$$("#center").style.display = 'block';
					$$("#center i").innerHTML = '请选择结束时间！';
					return false;
				}
				if( rate == '' ){
					$$("#center").style.display = 'block';
					$$("#center i").innerHTML = '请输入平均收益率！';
					return false;
				}
				var regu = /^([0-9])[0-9]*(\\.\\w*)?$/;
				if(regu.test(rate)==false){
					$$("#center").style.display = 'block';
					$$("#center i").innerHTML = '平均收益率请输入数字或小数点！';
					return false;
				}
				if( title == '' ){
					$$("#center").style.display = 'block';
					$$("#center i").innerHTML = '请输入标题！';
					return false;
				}
				if( logic == '' ){
					$$("#center").style.display = 'block';
					$$("#center i").innerHTML = '请输入逻辑！';
					return false;
				}
				if( price.length == '' ){
					$$("#center").style.display = 'block';
					$$("#center i").innerHTML = '请输入定价！';
					return false;
				}
				var reg = /^[1-9]\d*$|^0$/;
				if(reg.test(price)==false){
					$$("#center").style.display = 'block';
					$$("#center i").innerHTML = '请输入数字定价！';
					return false;
				}
				
				//获取投资类型的文字
				d1_text = $$(".d1 b.selected span").innerHTML;
                //提交开始
				$$("#center").style.display = 'block';
				$$("#center span").style.display = 'none';
				$$("#center i").classList.add('flex');
				$$("#center i").innerHTML = '<img src="../public/images/loading.gif" />正在提交...';
				//准备数据
				var order = {
						d1:d1,
						d1_text:d1_text,
						start:start,
						end:end,
						rate:rate,
						title:title,
						logic:logic,
						price:price
				};
				//ajax提交
				/*
				$.ajax({
						type: "post",
						url: "http://sendmail.ersoft.cn/cn/contact_us",
						data: order,
						success: function(){
											$$("#center i").classList.remove('flex');
											$$("#center i").innerHTML = '恭喜您，提交成功！';
											$$("#center span").style.display = 'block';
											$$("#center span").addEventListener('click',function(){
												window.location.href = '';
											})
						},
						error: function(){
											$$("#center i").classList.remove('flex');
											$$("#center i").innerHTML = '正在提交失败，请重新提交！';
											$$("#center span").style.display = 'block';
						}
				});
				*/
		})
		
		
		
	
})