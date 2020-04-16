package software.practice.distribution.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import software.practice.distribution.entity.Application;
import software.practice.distribution.entity.ApplicationExample;

import java.util.List;

@Repository
public interface ApplicationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    long countByExample(ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int deleteByExample(ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int deleteByPrimaryKey(Integer applicationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int insert(Application record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int insertSelective(Application record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    List<Application> selectByExampleWithRowbounds(ApplicationExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    List<Application> selectByExample(ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    Application selectByPrimaryKey(Integer applicationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int updateByExampleSelective(@Param("record") Application record, @Param("example") ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int updateByExample(@Param("record") Application record, @Param("example") ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int updateByPrimaryKeySelective(Application record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int updateByPrimaryKey(Application record);
}