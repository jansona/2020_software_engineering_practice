package software.practice.distribution.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import software.practice.distribution.entity.Deal;
import software.practice.distribution.entity.DealExample;

import java.util.List;

@Repository
public interface DealMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Sun Apr 19 12:25:18 CST 2020
     */
    long countByExample(DealExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Sun Apr 19 12:25:18 CST 2020
     */
    int deleteByExample(DealExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Sun Apr 19 12:25:18 CST 2020
     */
    int deleteByPrimaryKey(Integer dealId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Sun Apr 19 12:25:18 CST 2020
     */
    int insert(Deal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Sun Apr 19 12:25:18 CST 2020
     */
    int insertSelective(Deal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Sun Apr 19 12:25:18 CST 2020
     */
    List<Deal> selectByExampleWithRowbounds(DealExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Sun Apr 19 12:25:18 CST 2020
     */
    List<Deal> selectByExample(DealExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Sun Apr 19 12:25:18 CST 2020
     */
    Deal selectByPrimaryKey(Integer dealId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Sun Apr 19 12:25:18 CST 2020
     */
    int updateByExampleSelective(@Param("record") Deal record, @Param("example") DealExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Sun Apr 19 12:25:18 CST 2020
     */
    int updateByExample(@Param("record") Deal record, @Param("example") DealExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Sun Apr 19 12:25:18 CST 2020
     */
    int updateByPrimaryKeySelective(Deal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Sun Apr 19 12:25:18 CST 2020
     */
    int updateByPrimaryKey(Deal record);
}