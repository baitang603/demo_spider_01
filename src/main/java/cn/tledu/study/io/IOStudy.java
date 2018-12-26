package cn.tledu.study.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

import cn.tledu.util.CloseUtil;
import cn.tledu.util.WebUtil;

public class IOStudy {
	public static void test() {
		String dataFile = "D:" + File.separator + "spider_data.dat";
		String encoding = "utf-8";
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(dataFile, "r");
			long pos = 75994;// 0;
			raf.seek(pos);
			int size = 76172;//75994;
			byte[] b = new byte[size];
			raf.read(b);
			System.out.println(new String(b, encoding));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(raf);
		}
	}
	public static void test2() {
		String urlStr = "http://news.sina.com.cn/c/nd/2018-08-31/doc-ihinpmnq6172268.shtml";
		urlStr = "http://news.sina.com.cn/c/nd/2018-08-31/doc-ihinpmnq4607302.shtml";
		String dataFile = "D:" + File.separator + "spider_data.dat";
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(dataFile, true));
			byte[] ba = WebUtil.urlGetByteArray(urlStr);
			System.out.println(ba.length);
			bos.write(ba);
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(bos);
		}
	}
	public static void test1() {
		String urlStr = "http://news.sina.com.cn/c/nd/2018-08-31/doc-ihinpmnq6172268.shtml";
		String encoding = "utf-8";//utf-8
		URL url = null;
		URLConnection conn = null;
		BufferedReader br = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BufferedInputStream bis = null;
		byte[] byteArray = null;
		try {
			url = new URL(urlStr);
			conn = url.openConnection();
			bis = new BufferedInputStream(conn.getInputStream());
			int b = -1;
			while ((b = bis.read()) != -1) {
				baos.write(b);
			}
			byteArray = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(br);
			CloseUtil.close(bis);
			CloseUtil.close(baos);
		}
		System.out.println("byteArray length = " + byteArray.length);
		try {
			System.out.println(new String(byteArray, encoding));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		test();
	}

}
