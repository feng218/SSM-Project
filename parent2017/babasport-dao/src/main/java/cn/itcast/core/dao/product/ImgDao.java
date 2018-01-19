package cn.itcast.core.dao.product;

import cn.itcast.core.bean.product.Img;
import cn.itcast.core.bean.product.ImgQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImgDao {
    int countByExample(ImgQuery example);

    int deleteByExample(ImgQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Img record);

    int insertSelective(Img record);

    List<Img> selectByExample(ImgQuery example);

    Img selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Img record, @Param("example") ImgQuery example);

    int updateByExample(@Param("record") Img record, @Param("example") ImgQuery example);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);
}