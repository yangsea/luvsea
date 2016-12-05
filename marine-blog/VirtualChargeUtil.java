package com.ct.bms.virtual.util;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.ct.bms.util.ConfigInfo;
import com.ct.bms.util.Http2Xml;

/**
 * 虚拟号码充值工具类
 * 
 * @author Administrator
 * 
 */
public class VirtualChargeUtil {

	/**
	 * 尚泽话费充值
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String shangzeCharge(String order_no, String account_no,
			String face_price) throws Exception {

		String URL = ConfigInfo.getString("shangze_url");// URL
		String org_code = ConfigInfo.getString("shangze_code");// 组织编号
		String key = ConfigInfo.getString("shangze_key");// key

		String parm = "org_code=" + org_code + "&order_no=" + order_no
				+ "&account_no=" + account_no + "&face_price=" + face_price;

		// 增加参数 key 进行MD5加密,加密后的密文用sign参数传送
		String sign = getMd5(parm + "&key=" + key);
		String result = Http2Xml.sendHTTP(URL, parm + "&sign=" + sign, "utf-8");

		return result;
	}

	public static String getMd5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密
			return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 太和话费充值
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String taiheCharge(String order_no, String account_no,
			String face_price) throws Exception {

		String URL = ConfigInfo.getString("taihe_url");// URL
		String sysCode = ConfigInfo.getString("taihe_sysCode");// 系统编号
		String salt = ConfigInfo.getString("taihe_salt");// 盐值
		long currentTime = System.currentTimeMillis();

		String keyParm = sysCode + currentTime + salt;

		// 增加参数 key 进行MD5加密,加密后的密文用sign参数传送
		String key = getMd5(keyParm);
		String taihe_callback_url = ConfigInfo.getString("taihe_callback_url");// 回调接口地址

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("amount", face_price);
		paramMap.put("mobile", account_no);
		paramMap.put("orderId", order_no);
		paramMap.put("retUri", taihe_callback_url);

		String paramJson = JSONObject.fromObject(paramMap).toString();

		String param = "sysCode=" + sysCode + "&timer=" + currentTime + "&key="
				+ key + "&serviceFlg=teleChargeNoBarcode&params=" + paramJson;

		String result = Http2Xml.sendHTTP(URL, param, "utf-8");

		return result;
	}

	/**
	 * 易裳话费充值
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String shang1HfCharge(String order_no, String account_no,
			String face_price) throws Exception {

		String URL = ConfigInfo.getString("1shang_url");// URL
		String userId = ConfigInfo.getString("1shang_userId");
		String orderId = ConfigInfo.getString("1shang_orderId");

		Map<String, String> map = new HashMap<String, String>();

		map.put("service", "getAward");// 服务接口
		map.put("phone", account_no);// 电话
		map.put("operation", "recharge");// 直充标记
		map.put("customOrderCode", order_no);// 客户订单号

		String prizeId = "";
		String prizePriceTypeId = "";

		if ("2".equals(face_price)) {
			prizeId = "960";
			prizePriceTypeId = "954";
		} else if ("5".equals(face_price)) {
			prizeId = "963";
			prizePriceTypeId = "957";
		} else if ("10".equals(face_price)) {
			prizeId = "968";
			prizePriceTypeId = "962";
		} else if ("30".equals(face_price)) {
			prizeId = "970";
			prizePriceTypeId = "964";
		} else if ("50".equals(face_price)) {
			prizeId = "971";
			prizePriceTypeId = "965";
		} else if ("100".equals(face_price)) {
			prizeId = "972";
			prizePriceTypeId = "966";
		}

		map.put("userId", userId);// 用户id，由易赏平台提供
		map.put("prizeId", prizeId);// 奖品id，由易赏平台提供
		map.put("prizePriceTypeId", prizePriceTypeId);// 面值id，由易赏平台提供
		map.put("orderId", orderId);// 订单id，由易赏平台提供

		String key = ConfigInfo.getString("1shang_key");// 用户秘钥
		map.put("sign", getSign(map, key));

		StringBuffer params = new StringBuffer();

		for (String keyName : map.keySet()) {
			params.append(keyName);
			params.append("=");
			params.append(map.get(keyName));
			params.append("&");
		}

		if (params.length() > 0) {
			params = params.deleteCharAt(params.length() - 1);
		}
		String result = Http2Xml.sendHTTP(URL, params.toString(), "utf-8");

		return result;
	}

	/**
	 * 生成sign
	 * 
	 * @param map
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String getSign(Map<String, String> map, String key)
			throws Exception {
		String[] nameArr = map.keySet().toArray(new String[] {});

		Arrays.sort(nameArr);

		StringBuilder builder = new StringBuilder();

		for (String name : nameArr) {
			if ("sign".equals(name))
				continue;
			if (map.get(name) == null)
				continue;
			builder.append(map.get(name));
		}

		return getMd5(builder.toString() + key);
	}

	/**
	 * 易裳QQ币兑换
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String shang1QqCharge(String order_no, String account_no,
			String face_price, String userPhone) throws Exception {

		String URL = ConfigInfo.getString("1shang_url");// URL
		String userId = ConfigInfo.getString("1shang_userId");
		String orderId = ConfigInfo.getString("1shang_orderId");

		Map<String, String> map = new HashMap<String, String>();

		map.put("service", "getBankCash");// 服务接口
		map.put("phone", userPhone);// 电话
		map.put("customOrderCode", order_no);// 客户订单号
		map.put("name", "");// 姓名，转账金必填
		map.put("bank", "");
		map.put("branch", "");// 支行 ，转账金必填
		map.put("cardNumber", account_no);// 银行卡号、微信openId、qq号码、加油卡号
		map.put("province", "");// 省份，转账金必填
		map.put("city", "");// 城市，转账金必填

		String prizeId = "1531";
		String prizePriceTypeId = "1525";
		if ("1".equals(face_price)) {
			prizeId = "1531";
			prizePriceTypeId = "1525";
		}
		if ("5".equals(face_price)) {
			prizeId = "1533";
			prizePriceTypeId = "1527";
		}
		if ("10".equals(face_price)) {
			prizeId = "1534";
			prizePriceTypeId = "1528";
		}

		map.put("userId", userId);// 用户id，由易赏平台提供
		map.put("prizeId", prizeId);// 奖品id，由易赏平台提供
		map.put("prizePriceTypeId", prizePriceTypeId);// 面值id，由易赏平台提供
		map.put("orderId", orderId);// 订单id，由易赏平台提供

		String key = ConfigInfo.getString("1shang_key");// 用户秘钥
		map.put("sign", getSign(map, key));

		StringBuffer params = new StringBuffer();

		for (String keyName : map.keySet()) {
			params.append(keyName);
			params.append("=");
			params.append(map.get(keyName));
			params.append("&");
		}

		if (params.length() > 0) {
			params = params.deleteCharAt(params.length() - 1);
		}
		String result = Http2Xml.sendHTTP(URL, params.toString(), "utf-8");

		return result;
	}

	/**
	 * 易裳流量充值
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String shang1LlCharge(String order_no, String account_no,
			String face_price, String commodityName) throws Exception {

		String URL = ConfigInfo.getString("1shang_url");// URL
		String userId = ConfigInfo.getString("1shang_userId");
		String orderId = ConfigInfo.getString("1shang_orderId");

		Map<String, String> map = new HashMap<String, String>();

		map.put("service", "getAward");// 服务接口
		map.put("phone", account_no);// 电话
		map.put("operation", "recharge");// 直充标记
		map.put("customOrderCode", order_no);// 客户订单号

		String prizeId = "";
		String prizePriceTypeId = "";

		// 兑换商品为移动的流量包
		if (commodityName.indexOf("移动") != -1) {
			if ("10".equals(face_price) || commodityName.indexOf("10M") != -1) {
				prizeId = "206";
				prizePriceTypeId = "201";
			} else if ("30".equals(face_price)
					|| commodityName.indexOf("30M") != -1) {
				prizeId = "207";
				prizePriceTypeId = "202";
			} else if ("70".equals(face_price)
					|| commodityName.indexOf("70M") != -1) {
				prizeId = "208";
				prizePriceTypeId = "203";
			} else if ("150".equals(face_price)
					|| commodityName.indexOf("150M") != -1) {
				prizeId = "209";
				prizePriceTypeId = "204";
			} else if ("500".equals(face_price)
					|| commodityName.indexOf("500M") != -1) {
				prizeId = "210";
				prizePriceTypeId = "205";
			} else if ("1000".equals(face_price)
					|| commodityName.indexOf("1G") != -1) {
				prizeId = "211";
				prizePriceTypeId = "206";
			} else if ("2000".equals(face_price)
					|| commodityName.indexOf("2G") != -1) {
				prizeId = "1597";
				prizePriceTypeId = "1591";
			} else if ("3000".equals(face_price)
					|| commodityName.indexOf("3G") != -1) {
				prizeId = "1598";
				prizePriceTypeId = "1592";
			} else if ("4000".equals(face_price)
					|| commodityName.indexOf("4G") != -1) {
				prizeId = "1599";
				prizePriceTypeId = "1593";
			} else if ("6000".equals(face_price)
					|| commodityName.indexOf("6G") != -1) {
				prizeId = "1600";
				prizePriceTypeId = "1594";
			} else if ("11000".equals(face_price)
					|| commodityName.indexOf("11G") != -1) {
				prizeId = "1601";
				prizePriceTypeId = "1595";
			}
		}
		// 兑换商品为联通的流量包
		else if (commodityName.indexOf("联通") != -1) {
			if ("50".equals(face_price) || commodityName.indexOf("50M") != -1) {
				prizeId = "194";
				prizePriceTypeId = "188";
			} else if ("200".equals(face_price)
					|| commodityName.indexOf("200M") != -1) {
				prizeId = "195";
				prizePriceTypeId = "189";
			} else if ("20".equals(face_price)
					|| commodityName.indexOf("20M") != -1) {
				prizeId = "419";
				prizePriceTypeId = "413";
			} else if ("100".equals(face_price)
					|| commodityName.indexOf("100M") != -1) {
				prizeId = "420";
				prizePriceTypeId = "414";
			} else if ("500".equals(face_price)
					|| commodityName.indexOf("500M") != -1) {
				prizeId = "421";
				prizePriceTypeId = "415";
			}
		}
		// 兑换商品为电信的流量包
		else if (commodityName.indexOf("电信") != -1) {
			if ("10".equals(face_price) || commodityName.indexOf("10M") != -1) {
				prizeId = "196";
				prizePriceTypeId = "190";
			} else if ("30".equals(face_price)
					|| commodityName.indexOf("30M") != -1) {
				prizeId = "197";
				prizePriceTypeId = "191";
			} else if ("100".equals(face_price)
					|| commodityName.indexOf("100M") != -1) {
				prizeId = "199";
				prizePriceTypeId = "193";
			} else if ("200".equals(face_price)
					|| commodityName.indexOf("200M") != -1) {
				prizeId = "200";
				prizePriceTypeId = "194";
			} else if ("500".equals(face_price)
					|| commodityName.indexOf("500M") != -1) {
				prizeId = "201";
				prizePriceTypeId = "195";
			} else if ("5".equals(face_price)
					|| commodityName.indexOf("5M") != -1) {
				prizeId = "1595";
				prizePriceTypeId = "1589";
			} else if ("50".equals(face_price)
					|| commodityName.indexOf("50M") != -1) {
				prizeId = "1694";
				prizePriceTypeId = "1688";
			} else if ("1000".equals(face_price)
					|| commodityName.indexOf("1G") != -1) {
				prizeId = "1695";
				prizePriceTypeId = "1689";
			}
		}

		map.put("userId", userId);// 用户id，由易赏平台提供
		map.put("prizeId", prizeId);// 奖品id，由易赏平台提供
		map.put("prizePriceTypeId", prizePriceTypeId);// 面值id，由易赏平台提供
		map.put("orderId", orderId);// 订单id，由易赏平台提供

		String key = ConfigInfo.getString("1shang_key");// 用户秘钥
		map.put("sign", getSign(map, key));

		StringBuffer params = new StringBuffer();

		for (String keyName : map.keySet()) {
			params.append(keyName);
			params.append("=");
			params.append(map.get(keyName));
			params.append("&");
		}

		if (params.length() > 0) {
			params = params.deleteCharAt(params.length() - 1);
		}
		String result = Http2Xml.sendHTTP(URL, params.toString(), "utf-8");

		return result;
	}

	/**
	 * 易裳电影票兑换
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String shang1DypCharge(String order_no, String account_no,
			String face_price, String commodityName) throws Exception {

		String URL = ConfigInfo.getString("1shang_url");// URL
		String userId = ConfigInfo.getString("1shang_userId");
		String orderId = ConfigInfo.getString("1shang_orderId_yq");

		Map<String, String> map = new HashMap<String, String>();

		map.put("service", "getAward");// 服务接口
		map.put("phone", account_no);// 电话
		map.put("operation", "getCode");// 获取易赏平台串码
		map.put("customOrderCode", order_no);// 客户订单号

		String prizeId = "";
		String prizePriceTypeId = "";

		// 兑换商品为单人2D电影票标准版
		if (commodityName.indexOf("标准") != -1) {
			prizeId = "276";
			prizePriceTypeId = "271";
		}
		// 兑换商品为单人2D电影票升级版
		else if (commodityName.indexOf("升级") != -1) {
			prizeId = "178";
			prizePriceTypeId = "171";
		}

		map.put("userId", userId);// 用户id，由易赏平台提供
		map.put("prizeId", prizeId);// 奖品id，由易赏平台提供
		map.put("prizePriceTypeId", prizePriceTypeId);// 面值id，由易赏平台提供
		map.put("orderId", orderId);// 订单id，由易赏平台提供

		String key = ConfigInfo.getString("1shang_key");// 用户秘钥
		map.put("sign", getSign(map, key));

		StringBuffer params = new StringBuffer();

		for (String keyName : map.keySet()) {
			params.append(keyName);
			params.append("=");
			params.append(map.get(keyName));
			params.append("&");
		}

		if (params.length() > 0) {
			params = params.deleteCharAt(params.length() - 1);
		}
		String result = Http2Xml.sendHTTP(URL, params.toString(), "utf-8");

		return result;
	}

	/**
	 * 易裳电子礼品券兑换
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String shang1DzlpqCharge(String order_no, String account_no,
			String face_price, String commodityName) throws Exception {

		String URL = ConfigInfo.getString("1shang_url");// URL
		String userId = ConfigInfo.getString("1shang_userId");
		String orderId = ConfigInfo.getString("1shang_orderId_yq");

		Map<String, String> map = new HashMap<String, String>();

		map.put("service", "getAward");// 服务接口
		map.put("phone", account_no);// 电话
		map.put("operation", "getCode");// 获取易赏平台串码
		map.put("customOrderCode", order_no);// 客户订单号

		String prizeId = "";
		String prizePriceTypeId = "";

		// 兑换京东5元电子礼品卡
		if (commodityName.indexOf("京东") != -1) {
			if ("5".equals(face_price)) {
				prizeId = "10124";
				prizePriceTypeId = "10118";
			}
		}
		// 兑换当当电子礼品卡5元
		else if (commodityName.indexOf("当当") != -1) {
			if ("5".equals(face_price)) {
				prizeId = "10125";
				prizePriceTypeId = "10119";
			}
		}
		// 中石化加油卡100元（卡密）
		else if (commodityName.indexOf("中石化") != -1) {
			if ("100".equals(face_price)) {
				prizeId = "8950";
				prizePriceTypeId = "8944";
			}
		}

		map.put("userId", userId);// 用户id，由易赏平台提供
		map.put("prizeId", prizeId);// 奖品id，由易赏平台提供
		map.put("prizePriceTypeId", prizePriceTypeId);// 面值id，由易赏平台提供
		map.put("orderId", orderId);// 订单id，由易赏平台提供

		String key = ConfigInfo.getString("1shang_key");// 用户秘钥
		map.put("sign", getSign(map, key));

		StringBuffer params = new StringBuffer();

		for (String keyName : map.keySet()) {
			params.append(keyName);
			params.append("=");
			params.append(map.get(keyName));
			params.append("&");
		}

		if (params.length() > 0) {
			params = params.deleteCharAt(params.length() - 1);
		}
		String result = Http2Xml.sendHTTP(URL, params.toString(), "utf-8");

		return result;
	}

	/**
	 * 易裳话费\流量\QQ币充值后的状态查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String shang1QueryStatus(String order_no) throws Exception {

		String URL = ConfigInfo.getString("1shang_url");// URL
		String userId = ConfigInfo.getString("1shang_userId");
		String orderId = ConfigInfo.getString("1shang_orderId");

		Map<String, String> map = new HashMap<String, String>();

		map.put("service", "queryStatus");// 服务接口
		map.put("customOrderCode", order_no);// 客户订单号
		map.put("userId", userId);// 用户id，由易赏平台提供
		map.put("orderId", orderId);// 订单id，由易赏平台提供

		String key = ConfigInfo.getString("1shang_key");// 用户秘钥
		map.put("sign", getSign(map, key));

		StringBuffer params = new StringBuffer();

		for (String keyName : map.keySet()) {
			params.append(keyName);
			params.append("=");
			params.append(map.get(keyName));
			params.append("&");
		}

		if (params.length() > 0) {
			params = params.deleteCharAt(params.length() - 1);
		}
		String result = Http2Xml.sendHTTP(URL, params.toString(), "utf-8");

		return result;
	}

	/**
	 * 太和中石化卡密提取
	 * 
	 * add kongfanhui 2016-11-16
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String taiheSykCharge(String order_no, String account_no,
			String face_price) throws Exception {

		String url = ConfigInfo.getString("taihe_url");// URL
		String sysCode = ConfigInfo.getString("taihe_sysCode");// 系统编号
		String salt = ConfigInfo.getString("taihe_saltJyk");// 盐值
		long currentTime = System.currentTimeMillis();

		String keyParm = sysCode + currentTime + salt;

		// 增加参数 key 进行MD5加密,加密后的密文用sign参数传送
		String key = getMd5(keyParm);

		String cardid = "";
		if ("100".equals(face_price)) {
			cardid = ConfigInfo.getString("taihe_cardidJyk100");// 加油卡100
		}

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cardid", cardid);// 商品编号
		paramMap.put("orderId", order_no);// 订单编号
		paramMap.put("cardnum", "1");// 提卡数量
		paramMap.put("mobile", account_no);// 手机

		String paramJson = JSONObject.fromObject(paramMap).toString();

		String param = "sysCode=" + sysCode + "&timer=" + currentTime + "&key="
				+ key + "&serviceFlg=snpRecharge&params=" + paramJson;

		String result = Http2Xml.sendHTTP(url, param, "utf-8");

		return result;
	}

	/**
	 * 易裳话费充值后的状态查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String shang1YqQueryStatus(String order_no) throws Exception {

		String URL = ConfigInfo.getString("1shang_url");// URL
		String userId = ConfigInfo.getString("1shang_userId");
		String orderId = ConfigInfo.getString("1shang_orderId_yq");

		Map<String, String> map = new HashMap<String, String>();

		map.put("service", "queryStatus");// 服务接口
		map.put("customOrderCode", order_no);// 客户订单号
		map.put("userId", userId);// 用户id，由易赏平台提供
		map.put("orderId", orderId);// 订单id，由易赏平台提供

		String key = ConfigInfo.getString("1shang_key");// 用户秘钥
		map.put("sign", getSign(map, key));

		StringBuffer params = new StringBuffer();

		for (String keyName : map.keySet()) {
			params.append(keyName);
			params.append("=");
			params.append(map.get(keyName));
			params.append("&");
		}

		if (params.length() > 0) {
			params = params.deleteCharAt(params.length() - 1);
		}
		String result = Http2Xml.sendHTTP(URL, params.toString(), "utf-8");

		return result;
	}

}
