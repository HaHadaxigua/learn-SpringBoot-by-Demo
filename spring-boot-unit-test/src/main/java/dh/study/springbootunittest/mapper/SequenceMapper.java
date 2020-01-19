package dh.study.springbootunittest.mapper;

import dh.study.springbootunittest.config.MyMapper;
import dh.study.springbootunittest.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SequenceMapper extends MyMapper<User> {
    @Select("select ${seqName}.nextval from dual")
    Long getSequence(@Param("seqName") String seqName);
}
