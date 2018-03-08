package cn.com.rising.dbsync.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.com.rising.dbsync.entity.DatabaseSource;
import cn.com.rising.dbsync.entity.Job;

public class JobsParse {

	private static final Logger logger = Logger.getLogger(JobsParse.class);

	public static Map<String, Object> getJobs() {
		DatabaseSource innerSource = new DatabaseSource();
		DatabaseSource outerSource = new DatabaseSource();
		List<Job> jobList = new ArrayList<Job>();
		SAXReader reader = new SAXReader();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			// 读取xml的配置文件名，并获取其里面的节点
			Element root = reader.read("jobs.xml").getRootElement();
			Element inner = root.element("inner");
			Element outer = root.element("outer");
			Element jobs = root.element("jobs");
			// 遍历job即同步的表
			for (Iterator<?> it = jobs.elementIterator("job"); it.hasNext();) {
				jobList.add((Job) elementInObject((Element) it.next(), new Job()));
			}
			//
			elementInObject(inner, innerSource);
			elementInObject(outer, outerSource);
			String code = root.element("code").getTextTrim();
			map.put("inner", innerSource);
			map.put("outer", outerSource);
			map.put("jobs", jobList);
			map.put("code", code);
			return map;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public static Object elementInObject(Element e, Object o) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = o.getClass().getDeclaredFields();
		for (int index = 0; index < fields.length; index++) {
			fields[index].setAccessible(true);
			fields[index].set(o, e.element(fields[index].getName()).getTextTrim());
		}
		return o;
	}
}
