package aaa.lib.util;

public class MyHTMLTagConverter {
	public static String convert(String str) {
		String completeval ="";
		StringBuffer strBuff = new StringBuffer();
		for (int j = 0; j < str.length(); j++) {
			char c = str.charAt(j);
			switch (c) {
				case '〈':
					strBuff.append("&lt;");
					break;
				case '〉':
					strBuff.append("&gt;");
					break;
				case '╁':
					strBuff.append("&amp;");
					break;
				case '″':
					strBuff.append("&quot;");
					break;
				case '′':
					strBuff.append("&apos;");
					break;
				default:
					strBuff.append(c);
					break;
			}
		}
		completeval = strBuff.toString();
		return completeval;
	}
	
	public static String convert2(String str) {
		String completeval ="";
		StringBuffer strBuff = new StringBuffer();
		for (int j = 0; j < str.length(); j++) {
			char c = str.charAt(j);
			switch (c) {
				case '〈':
					strBuff.append("<");
					break;
				case '〉':
					strBuff.append(">");
					break;
				case '╁':
					strBuff.append("&");
					break;
				case '″':
					strBuff.append("\"");
					break;
				case '′':
					strBuff.append("\'");
					break;
				default:
					strBuff.append(c);
					break;
			}
		}
		completeval = strBuff.toString();
		return completeval;
	}

	public static String convert3(String str) {
		String completeval ="";
		StringBuffer strBuff = new StringBuffer();
		for (int j = 0; j < str.length(); j++) {
			char c = str.charAt(j);
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
		completeval = strBuff.toString();
		return completeval;
	}
	
	public static String convert4(String str) {
		String completeval ="";

		str = str.replaceAll("╁lt;p╁gt;","◁p▶");
		str = str.replaceAll("╁lt;/p╁gt;","◁/p▶");
		str = str.replaceAll("╁lt;br╁gt;","◁br▶");
		str = str.replaceAll("╁lt;","〈");
		str = str.replaceAll("╁gt;","〉");
		
		StringBuffer strBuff = new StringBuffer();
		for (int j = 0; j < str.length(); j++) {
			char c = str.charAt(j);
			switch (c) {
				case '〈':
					strBuff.append("&lt;");
					break;
				case '〉':
					strBuff.append("&gt;");
					break;
				case '╁':
					strBuff.append("&amp;");
					break;
				case '″':
					strBuff.append("&quot;");
					break;
				case '′':
					strBuff.append("&apos;");
					break;
				default:
					strBuff.append(c);
					break;
			}
		}
		completeval = strBuff.toString();
		completeval = completeval.replaceAll("\\(", "&#40;");
		completeval = completeval.replaceAll("\\)", "&#41;");
		completeval = completeval.replaceAll("\\\\", "&#x2F;");
		
		completeval = completeval.replaceAll("&lt;img src=&quot;https://domain.com","<img src=\"https://domain.com");
		completeval = completeval.replaceAll(".gif&quot; alt=&quot;jpg,gif,png,bmp만 가능. 최대3개,한개에 1MB제한.  저작권침해문제는 게시 당사자에게 있음.&quot; style=&quot;font-size: 11pt;&quot;&gt;",".gif\" alt=\"jpg,gif,png,bmp만 가능. 최대3개,한개에 1MB제한.  저작권침해문제는 게시 당사자에게 있음.\" style=\"font-size: 11pt;\">");
		completeval = completeval.replaceAll(".gif&quot; style=&quot;font-size: 11pt;&quot; alt=&quot;jpg,gif,png,bmp만 가능. 최대3개,한개에 1MB제한.  저작권침해문제는 게시 당사자에게 있음.&quot;&gt;",".gif\" style=\"font-size: 11pt;\" alt=\"jpg,gif,png,bmp만 가능. 최대3개,한개에 1MB제한.  저작권침해문제는 게시 당사자에게 있음.\">");
		completeval = completeval.replaceAll(".gif&quot; alt=&quot;jpg,gif,png,bmp만 가능. 최대3개,한개에 1MB제한.  저작권침해문제는 게시 당사자에게 있음.&quot;&gt;",".gif\" alt=\"jpg,gif,png,bmp만 가능. 최대3개,한개에 1MB제한.  저작권침해문제는 게시 당사자에게 있음.\">");
		completeval = completeval.replaceAll("&lt;p&gt;","<p>");
		completeval = completeval.replaceAll("&lt;/p&gt;","</p>");
		completeval = completeval.replaceAll("&lt;br&gt;","<br>");
		completeval = completeval.replaceAll("&lt;em&gt;","<em>");
		completeval = completeval.replaceAll("&lt;del&gt;","<del>");
		completeval = completeval.replaceAll("&lt;/em&gt;","</em>");
		completeval = completeval.replaceAll("&lt;/del&gt;","</del>");
		completeval = completeval.replaceAll("◁br▶","&lt;br&gt;");
		completeval = completeval.replaceAll("◁p▶","&lt;p&gt;");
		completeval = completeval.replaceAll("◁/p▶","&lt;/p&gt;");
		completeval = completeval.replaceAll("coo","&#99;oo");
		completeval = completeval.replaceAll("cOo","&#99;oo");
		completeval = completeval.replaceAll("cOO","&#99;oo");
		completeval = completeval.replaceAll("COo","&#99;oo");
		completeval = completeval.replaceAll("CoO","&#99;oo");
		completeval = completeval.replaceAll("COO","&#99;oo");


		return completeval;
	}
}