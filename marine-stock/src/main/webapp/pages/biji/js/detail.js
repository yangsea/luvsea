//created by 痴情浪子 2016090152053 1.0beta

window.addEventListener("DOMContentLoaded",function() {
        //错误弹窗提示
		var html = '<div id="notice" class="notice">'+
						   '<dl class="MFB">'+
								'<dt>'+
									'<i>您确定要支付阅读吗？</i>'+
									'<span>付费</span>'+
								'</dt>'+
								'<dd>取消</dd>'+
						   '</dl>'+
				   '</div>'+
				   '<div id="center" class="notice">'+
							'<center class="scale">'+
									'<i></i>'+
									'<span>确定</span>'+
							'</center>'+
				   '</div>';
		$$('body').innerHTML += html;
		$$("#notice dd").addEventListener('click',function(){
			$$("#notice").style.display = 'none';
		})
		$$("#center span").addEventListener('click',function(){
			$$("#center").style.display = 'none';
		})
		
		//菜单点击事项
		for( var i=0;i<$$$(".dcatalog li").length;i++ ){
			$$$(".dcatalog li")[i].addEventListener("click",function(){
				if( this.className == 'flex pay' ){
					$$('#notice').style.display = 'block';
					$$('#notice span').addEventListener("click",function(){
						    $$('#notice').style.display = 'none';
							var chtml = '<div class="chioce MFL">'+
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
				}else if( this.className == 'flex modify' ){
					$$("#center").style.display = 'block';
					$$("#center i").innerHTML = '这里的页面跟写笔记的是一样，就是页面有没有数据的问题！';
					$$("#center span").addEventListener('click',function(){
						window.location.href = 'modify.html';
					})
				}else if( this.className == 'flex share' ){
					$$("#center").style.display = 'block';
					$$("#center i").innerHTML = '这里要调用微信接口';
				}else if( this.className == 'flex more' ){
					$$("#center").style.display = 'block';
					$$("#center i").innerHTML = '这里的页面少一张，借用黄智的页面！';
					$$("#center span").addEventListener('click',function(){
						window.location.href = 'list.html';
					})
				}
			})
		}
        


	
})