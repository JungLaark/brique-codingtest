package com.brique.codingtest.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.brique.codingtest.model.NumberThree;

@Mapper
public interface MainMapper {
	List<NumberThree> selectEmp();
}
