package cn.tledu.util;

import java.util.LinkedList;
/**
 * 自定义泛型类
 * 用于封装实现一个线程安全的 LinkedList
 * 目的是实现一个同步队列 消息中间件
 * @author lhl
 *
 * @param <T>
 */

public class MySynQueue<T> {
	private LinkedList<T> list = new LinkedList<T>();
	
	/**
	 * 用于向队列中添加一个元素
	 * @param t 添加的元素
	 */
	public synchronized void offer(T t) {
		//如果有去重需求就
		if (!list.contains(t)) {
			list.addLast(t);
		}
//		list.addLast(t);
	}
	
	/**
	 * 用于从队列中获取一个元素
	 * @return 获取的元素
	 */
	public synchronized T poll() {
		return list.removeFirst();
	}
	
	/**
	 * 用于判断队列的大小
	 * @return 队列中元素的数量
	 */
	public int size() {
		return list.size();
	}
}
