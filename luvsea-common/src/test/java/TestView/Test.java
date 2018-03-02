//package TestView;
//
//import java.util.Scanner;
//
//public class Test {
//	// 储存账号
//	static String IDs[] = { "jim", "jackie", "spring" };
//	// 储存密码
//	static String pwds[] = { "123", "456", "789" };
//	// 储存菜品名
//	static String menus[] = { "红烧带鱼", "鱼香肉丝", "时令鲜蔬" };
//	// 储存菜品单价
//	static double price[] = new double[] { 38, 20, 10 };
//	// 储存点赞数
//	static int goods[] = new int[3];
//	// 储存订单序号
//	static int nums[] = new int[4];
//	// 储存订餐人姓名
//	static String names[] = new String[4];
//	// 储存已点单菜品
//	static String selects[] = new String[4];
//	// 储存份数
//	static int counts[] = new int[4];
//	// 储存送餐时间
//	static int times[] = new int[4];
//	// 储存送餐地址
//	static String adds[] = new String[4];
//	// 储存订单总金额
//	static double totPrices[] = new double[4];
//	// 储存订单状态
//	static String a[] = { "已预订", "已完成" };
//	// 判断订单是否完成
//	static int state[] = new int[4];
//	// 确定下标用
//	static int s = 0;
//
//	public static void main(String[] args) {
//
//		String[] user = { "晓明", "小丽", "小刚", "小倩" };
//		String[] pwd = { "1", "2", "3" };
//		int loginErrTimes = 0;
//		boolean isLogSuccess = false;
//		String[] forbidUser = new String[4];
//		String userName = "";
//		String shijian = "";
//		String dz = "";
//		String dingcan = "";
//		String[] d = { "1", "2", "3" };
//		do {
//			if (loginErrTimes == 0) {
//				System.out.print("请输入用户名：");
//			} else {
//				System.out.print("再次请输入用户名：");
//			}
//			Scanner input = new Scanner(System.in);
//			userName = input.next();
//			for (int i = 0; i < forbidUser.length; i++) {
//				if (forbidUser[i] == userName) {
//					System.out.println("您已被冻结，请联系管理员");
//					return;
//				}
//			}
//			for (int i = 0; i < user.length; i++) {
//				if (user[i].equals(userName)) {
//					isLogSuccess = true;
//					// 登录成功
//					System.out.println("恭喜登录成功");
//					break;
//				}
//			}
//			if (!isLogSuccess) {
//				// 登录失败
//				loginErrTimes++;
//				if (loginErrTimes == 3) {
//					forbidUser[0] = userName;
//					System.out.println("登录错误达到3次,已被冻结");
//				}
//			} else {
//				break;
//			}
//
//		} while (loginErrTimes < 3);
//
//		if (isLogSuccess) {
//			System.out.println("***********************************");
//			System.out.println("1，我要点餐：");
//			System.out.println("2.查看餐袋：");
//			System.out.println("3.签收订单：");
//			System.out.println("4.删除订单：");
//			System.out.println("5.我要点赞");
//			System.out.println("6.退出系统：：");
//			System.out.println("***********************************");
//			System.out.println("请选择：");
//			Scanner input = new Scanner(System.in);
//			int menuId = input.nextInt();
//			int xuancai = 0;
//			int fenshu = 0;
//			String menuName = null;
//			switch (menuId) {
//			case 1:
//				System.out.println("***我要订餐***");
//				System.out.println("请订餐人名字：");
//				dingcan = input.next();
//				System.out.println("序号\t菜名\t价格\t点赞");
//				System.out.println("1\t红烧带鱼\t 38.0元");
//				System.out.println("2\t鱼香肉丝\t20.0元\t 0");
//				System.out.println("3\t时令鲜疏\t10.0元\t 0");
//				Scanner input1 = new Scanner(System.in);
//				System.out.println("请选择您要点的菜品 编号：");
//				xuancai = input1.nextInt();
//				if (xuancai == 1) {
//					menuName = "红烧带鱼\t 38.0元";
//				} else if (xuancai == 2) {
//					menuName = "鱼香肉丝\t20.0元\t";
//				} else {
//					menuName = "时令鲜疏\t10.0元";
//				}
//				System.out.println("请选择您需要的份数：");
//				fenshu = input1.nextInt();
//				System.out.println("请选择送餐时间（送餐时间是10点到22点间整点送餐）");
//
//				shijian = input.next();
//				System.out.println("送输入送餐地址：");
//				dz = input.next();
//				System.out.println("订餐成功！");
//
//				break;
//			case 2: // 查看餐袋
//             
//				System.out.println("***查看餐袋***");
//				System.out.println("序号\t\t订餐人\t餐品信息\t\t送餐时间\t送餐地址\t\t总金额\t订单状态");
//				// 遍历所有信息储存数组，如果订餐人为空，则不显示
//				for (int i = 0; i < names.length; i++) {
//					if (nums[i] != 0) {
//						System.out.print(nums[i] + "\t\t" + names[i] + "\t" + selects[i] + counts[i] + "份" + "\t" + times[i]
//								+ "点" + "\t\t" + adds[i] + "\t\t\t" + totPrices[i] + "元\t");
//						// 当数组中的值为0时，默认为已预订状态
//						if (state[i] == 0) {
//							System.out.println(a[0]);
//						} else {
//							System.out.println(a[1]);
//						}
//					}
//				}
//				boolean flag = true;
//				while (flag) {
//					System.out.print("输入0返回：");
//					Scanner input11 = new Scanner(System.in);
//					int num = input11.nextInt();
//					if (num == 0) {
//						System.out.println();
//						flag = false;
//						menu();
//					} else {
//						System.out.println("请输入数字 0 返回主菜单！");
//					}
//				}
//			case 3: // 签收订单
//				System.out.println("***签收订单***");
//				System.out.println("请选择要签收的订单号：");
//				Scanner input2 = new Scanner(System.in);
//				String c = input2.next();
//
//				for (int j = 0; j < c.length(); j++) {
//					if (d[j].equals(c)) {
//						isLogSuccess = true;
//					}
//
//				}
//				System.out.println("订单签收成功！谢谢使用！");
//				break;
//			case 4:// 删除订单0：");
//				Scanner input11 = new Scanner(System.in);
//				int select = input11.nextInt();
//				if (nums[select - 1] != 0) {
//					for (int i = select - 1; i < nums.length; i++) {
//						if (state[select - 1] == 1) {
//							// 将数组中的后一个值赋给前一个值
//							nums[i] = nums[i + 1];
//							names[i] = names[i + 1];
//							selects[i] = selects[i + 1];
//							counts[i] = counts[i + 1];
//							times[i] = times[i + 1];
//							adds[i] = adds[i + 1];
//							totPrices[i] = totPrices[i + 1];
//							// 将数组中的最后一个值清空
//							nums[nums.length - 1] = 0;
//							names[names.length - 1] = null;
//							selects[selects.length - 1] = null;
//							counts[counts.length - 1] = 0;
//							times[times.length - 1] = 0;
//							adds[adds.length - 1] = null;
//							totPrices[totPrices.length - 1] = 0;
//							System.out.println("订单删除成功！");
//							break;
//						} else {
//							System.out.println("订单未完成，不能删除，请确认订单状态！");
//							break;
//						}
//					}
//
//				}
//
//				System.out.println("***********************************");
//				System.out.println("1，我要点餐：");
//				System.out.println("2.查看餐袋：");
//				System.out.println("3.签收订单：");
//				System.out.println("4.删除订单：");
//				System.out.println("5.我要点赞");
//				System.out.println("6.退出系统：：");
//				System.out.println("***********************************");
//				System.out.println("请选择：");
//				Scanner input21 = new Scanner(System.in);
//				menuId = input21.nextInt();
//				if (menuId == 2) {
//					System.out.println("***查看餐袋：***");
//
//					System.out.println("序号\t 订餐人 \t 餐品信息 \t 送餐日期 \t 送餐地址 \t总金额 \t 订单状态");
//					System.out.println(
//							"1\t " + dingcan + " \t " + menuName + "\t " + shijian + "\t " + dz + "\t 76.0元 \t 已完成");
//
//					boolean flag1 = true;
//					while (flag1) {
//						System.out.print("输入0返回：");
//						int num = input11.nextInt();
//						if (num == 0) {
//							// 以便录入下一张订单
//							fenshu++;
//							System.out.println();
//							flag1 = false;
//							menu();
//						} else {
//							System.out.println("请输入数字 0 返回主菜单！");
//						}
//					}
//
//				}
//			case 5:
//
//				System.out.println("***我要点赞***");
//				Scanner input111 = new Scanner(System.in);
//				boolean flag1 = true;
//				while (flag1) {
//					System.out.println("序号\t\t菜名\t\t单价\t\t点赞数");
//					for (int i = 0; i < menus.length; i++) {
//						System.out.println((i + 1) + "\t\t" + menus[i] + "\t" + price[i] + "元\t" + goods[i]);
//					}
//					System.out.print("请选择您要点赞的菜品序号：");
//					int select1 = input111.nextInt();
//					switch (select1) {
//					case 1:
//						goods[select1 - 1] += 1;
//						flag1 = false;
//						break;
//					case 2:
//						goods[select1] += 1;
//						flag1 = false;
//						break;
//					case 3:
//						goods[select1 + 1] += 1;
//						flag1 = false;
//						break;
//					}
//					System.out.println("点赞成功！");
//				}
//				boolean flag11 = true;
//				while (flag11) {
//					System.out.print("输入0返回：");
//					int num = input111.nextInt();
//					if (num == 0) {
//						System.out.println();
//						flag11 = false;
//						menu();
//					} else {
//						System.out.println("请输入数字 0 返回主菜单！");
//					}
//				}
//
//			}
//		}
//	}
//
//	/** 
//	* @Title: menu 
//	* @Description: TODO(这里用一句话描述这个方法的作用)     void    返回类型 
//	* @throws 
//	*/
//
//	private static void menu() {
//		// TODO Auto-generated method stub
//
//	}
//}