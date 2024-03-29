package aaa.lib.util;

import egovframework.rte.ptl.mvc.tags.ui.pagination.AbstractPaginationRenderer;

public class DefaultPaginationRenderer extends AbstractPaginationRenderer {
	 
	public DefaultPaginationRenderer() {
		firstPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">[처음]</a>&#160;"; 
		previousPageLabel = "<a href=\"#\" class=\"pagingcustom\" onclick=\"{0}({1}); return false;\">[이전]</a>&#160;";
		currentPageLabel = "<strong class=\"pagingcustom2\">{0}</strong>&#160;";
		otherPageLabel = "<a href=\"#\" class=\"pagingcustom3\" onclick=\"{0}({1}); return false;\">{2}</a>&#160;";
		nextPageLabel = "<a href=\"#\" class=\"pagingcustom\" onclick=\"{0}({1}); return false;\">[다음]</a>&#160;";
		lastPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">[마지막]</a>&#160;";
	}
}