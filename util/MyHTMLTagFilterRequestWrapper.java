package aaa.lib.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHTMLTagFilterRequestWrapper extends HttpServletRequestWrapper {

	public MyHTMLTagFilterRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	public String[] getParameterValues(String parameter) {

		String[] values = super.getParameterValues(parameter);

		if (values == null) {
			return null;
		}

		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				values[i] = values[i].replaceAll("〈", "&lt;");
				values[i] = values[i].replaceAll("〉", "&gt;");
				values[i] = values[i].replaceAll("╁", "&amp;");
				values[i] = values[i].replaceAll("″", "&quot;");
				values[i] = values[i].replaceAll("′", "&apos;");
				StringBuffer strBuff = new StringBuffer();
				for (int j = 0; j < values[i].length(); j++) {
					char c = values[i].charAt(j);
					switch (c) {
						case '<':
							strBuff.append("〈");
							break;
						case '>':
							strBuff.append("〉");
							break;
						case '&':
							strBuff.append("╁");
							break;
						case '"':
							strBuff.append("″");
							break;
						case '\'':
							strBuff.append("′");
							break;
						default:
							strBuff.append(c);
							break;
					}
				}
				values[i] = strBuff.toString();
			} else {
				values[i] = null;
			}
		}

		return values;
	}

	public String getParameter(String parameter) {

		String value = super.getParameter(parameter);

		if (value == null) {
			return null;
		}

		StringBuffer strBuff = new StringBuffer();
		value = value.replaceAll("〈", "&lt;");
		value = value.replaceAll("〉", "&gt;");
		value = value.replaceAll("╁", "&amp;");
		value = value.replaceAll("″", "&quot;");
		value = value.replaceAll("′", "&apos;");

		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			switch (c) {
				case '<':
					strBuff.append("〈");
					break;
				case '>':
					strBuff.append("〉");
					break;
				case '&':
					strBuff.append("╁");
					break;
				case '"':
					strBuff.append("″");
					break;
				case '\'':
					strBuff.append("′");
					break;
				default:
					strBuff.append(c);
					break;
			}
		}

		value = strBuff.toString();

		return value;
	}

}