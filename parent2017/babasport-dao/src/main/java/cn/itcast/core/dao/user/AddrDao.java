package cn.itcast.core.dao.user;

import cn.itcast.core.bean.user.Addr;
import cn.itcast.core.bean.user.AddrQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddrDao {
    int countByExample(AddrQuery example);

    int deleteByExample(AddrQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Addr record);

    int insertSelective(Addr record);

    List<Addr> selectByExample(AddrQuery example);

    Addr selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Addr record, @Param("example") AddrQuery example);

    int updateByExample(@Param("record") Addr record, @Param("example") AddrQuery example);

    int updateByPrimaryKeySelective(Addr record);

    int updateByPrimaryKey(Addr record);
}