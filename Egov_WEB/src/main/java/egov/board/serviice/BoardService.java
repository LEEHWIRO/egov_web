package egov.board.serviice;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {

	void checkUser(HttpServletRequest request)throws Exception;
	
}
