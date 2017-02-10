package com.pateo.telematic.utils;

/**
 * 字符串工具类
 * @author Administrator
 *
 */
public class StringUtils {

	/**
	 * 判断字符串是否为空
	 * @param str 字符串
	 * @return 是否为空
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}
	
	/**
	 * 判断字符串是否不为空
	 * @param str 字符串
	 * @return 是否不为空
	 */
	public static boolean isNotEmpty(String str) {
		return str != null && !"".equals(str);
	}
	
	/**
	 * 截断字符串两侧的逗号
	 * @param str 字符串
	 * @return 字符串
	 */
	public static String trimComma(String str) {
		if(str.startsWith(",")) {
			str = str.substring(1);
		}
		if(str.endsWith(",")) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}
	
	/**
	 * 补全两位数字
	 * @param str
	 * @return
	 */
	public static String fulfuill(String str) {
		if(str.length() == 2) {
			return str;
		} else {
			return "0" + str;
		}
	}
	
	/**
	 * 从拼接的字符串中提取字段
	 * @param str 字符串
	 * @param delimiter 分隔符 
	 * @param field 字段
	 * @return 字段值
	 */
	public static String getFieldFromConcatString(String str, 
			String delimiter, String field) {
		try {
			String[] fields = str.split(delimiter);
			for(String concatField : fields) {
				// searchKeywords=|clickCategoryIds=1,2,3
				if(concatField.split("=").length == 2) {
					String fieldName = concatField.split("=")[0];
					String fieldValue = concatField.split("=")[1];
					if(fieldName.equals(field)) {
						return fieldValue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 从拼接的字符串中给字段设置值
	 * @param str 字符串
	 * @param delimiter 分隔符 
	 * @param field 字段名
	 * @param newFieldValue 新的field值
	 * @return 字段值
	 */
	public static String setFieldInConcatString(String str, 
			String delimiter, String field, String newFieldValue) {
		String[] fields = str.split(delimiter);
		
		for(int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].split("=")[0];
			if(fieldName.equals(field)) {
				String concatField = fieldName + "=" + newFieldValue;
				fields[i] = concatField;
				break;
			}
		}
		
		StringBuffer buffer = new StringBuffer("");
		for(int i = 0; i < fields.length; i++) {
			buffer.append(fields[i]);
			if(i < fields.length - 1) {
				buffer.append("|");  
			}
		}
		
		return buffer.toString();
	}
	
	public static void main(String[] args) {

		String aa = "asd   fas++adsa+fa  df asds";

		System.out.println("-------------" +replaceString(aa, "\\+"));
//		String[] substring = "2016-08-09 23:38:10".substring(11,16).split(":");
//		if ( Integer.valueOf(substring[1])<30) {
//			System.out.println(substring[0]+":00-"+substring[0]+":30" );;
//	      }else {
////	    	  23:30-00:00
//	    	  if (Integer.valueOf(substring[0]) == 23) {
//	    		  System.out.println(substring[0]+":30-"+ ("00")+":00");
//			} else {
//				System.out.println(substring[0]+":30-"+(Integer.valueOf(substring[0]) + 1)+":00");
//			}
//	      }
 
	}
	
	public static String replaceString(String src,String replace) {
		String replaceStr = src.replaceAll(replace, "").replaceAll(" ", "");  
		return replaceStr; 
	}
	public static String replaceString(String src,String toReplace,String replace) {
		String replaceStr = src.replaceAll(toReplace, replace).replaceAll(" ", "");  
		return replaceStr; 
	}
}
