package cn.tledu.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebUtil {
	public static String urlGetString(String urlStr, String encoding) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			URL url = new URL(urlStr);
			URLConnection conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), encoding));
			String line = null;
			while ((line = br.readLine()) != null) {
				// System.lineSeparator() 自动添加操作系统对应的换行符
				sb.append(line).append(System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(br);
		}
		return sb.toString();
	}
	
	public static byte[] urlGetByteArray(String urlStr) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BufferedInputStream bis = null;
		byte[] byteArray = new byte[0];
		try {
			URL url = new URL(urlStr);
			URLConnection conn = url.openConnection();
			bis = new BufferedInputStream(conn.getInputStream());
			int b = -1;
			while ((b = bis.read()) != -1) {
				baos.write(b);
			}
			byteArray = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(bis);
			CloseUtil.close(baos);
		}
		return byteArray;
	}
}
