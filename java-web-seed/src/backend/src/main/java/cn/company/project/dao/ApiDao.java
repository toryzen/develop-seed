package cn.company.project.dao;

import cn.company.project.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApiDao {

    //查询Demo数据
    @Select("SELECT * FROM  datalist")
    List<Data> queryData();

}
