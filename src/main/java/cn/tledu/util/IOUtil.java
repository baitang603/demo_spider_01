package cn.tledu.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class IOUtil {
	//readDataFile()方法是用于从数据文件中抽取起始点和偏移量存入索引文件中，最后返回文件源代码内容
	public static String readDataFile(long pos, int size, String dataPath, String encoding) {
		String result = "";
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(dataPath, "r");
			raf.seek(pos);
			byte[] b = new byte[size];
			raf.read(b);
			result = new String(b, encoding);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(raf);
		}
		return result;
	}
	
	public static void writeDataFile(byte[] byteArr, String dataPath) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(dataPath, true);
			os.write(byteArr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(os);
		}
	}
	
	public static void writeIndexFile(String str, String indexPath) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileOutputStream(indexPath, true));
			out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(out);
		}
	}
}
