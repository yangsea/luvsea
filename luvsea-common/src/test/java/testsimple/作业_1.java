package testsimple;

import java.util.Scanner;

public class 作业_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***********************");
		System.out.println("请选择购买的商品编号：");
		System.out.println("1.T恤\t2.网球鞋\t3.网球拍");
		System.out.println("***********************");
		int t=245;
		while (true) {

			Scanner input = new Scanner(System.in);
			System.out.print("请输入购买的商品编号：");
			int s = input.nextInt();
			System.out.print("请输入购买商品数量:");
			int s1 = input.nextInt();
			if (s1 == 1) {
				 t = 245;
				System.out.println("T恤价格￥245.0\t" + "数量：" + s1 + "\t" + "合计："
						+ s1 * t);
			} else if (s1 == 2) {
				 t = 100;
				System.out.println("网球鞋100\t" + "数量：" + s1 + "\t" + "合计：" + s1
						* t);
			} else if (s1 == 3) {
			  t = 200;
				System.out.println("网球拍：￥200\t" + "数量：" + s1 + "\t" + "合计："
						+ s1 * t);
			}
			System.out.println("是否要继续：(y/n):");
			String a = input.next();

			if (a.equals("n")) {
				System.out.println("你已取消");
			} else {
				System.out.println("折扣：8折");
			    
				System.out.println("应付金额：" + s1 * t);

				System.out.println("实付金额："
						+ String.format("%.2f", (s1 * t) * 0.8));
       System.out.println("找钱："+(String.format("%.2f", (s1*t)-(s1 * t) * 0.8)));
			}
			s++;
//			input.close();
		}
	}
}
