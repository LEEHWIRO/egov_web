package egov.board.dao;



import java.util.HashMap;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper("BoardMapper")
public interface BoardMapper {
	
	void saveBoard(HashMap<String, Object> paramMap)throws Exception;


}
