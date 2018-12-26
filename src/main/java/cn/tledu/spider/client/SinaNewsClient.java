package cn.tledu.spider.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import cn.tledu.util.CloseUtil;
import cn.tledu.util.IOUtil;

public class SinaNewsClient {
	public static void test() {
		//输入 详情页网址 urlStr
		// 输出 对应新闻详情网页源码的字符串
		String urlStr = "http://news.sina.com.cn/c/nd/2018-08-31/doc-ihinpmnq4607302.shtml";
		
		String liDate = "08月31日";
		
		String fileBaseDir = "D:" + File.separator + "spider_db" + File.separator + liDate + File.separator;
		String dataPath = fileBaseDir + "spider_data.dat";
		String indexPath = fileBaseDir + "spider_index.txt";
		
		//String dataPath = "D:" + File.separator + "spider_data.dat";
		//String indexPath = "D:" + File.separator + "spider_index.txt";
		String encoding = "utf-8";
		String result = search(urlStr, indexPath, dataPath, encoding);
		System.out.println(result);
	}
	public static String search(String urlStr, String indexPath, String dataPath, String encoding) {
		String result = "";
		char splitChar = '\u0001';
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(indexPath));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] strArr = line.split(splitChar + "");
				if (strArr[0].equals(urlStr)) {
					// 偏移量
					// 字节数
					long pos = Long.valueOf(strArr[3]);
					int size = Integer.valueOf(strArr[4]);
					result = IOUtil.readDataFile(pos, size, dataPath, encoding);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(br);
		}
		return result;
	}
	
	public static void main(String[] args) {
		test();
	}

}
