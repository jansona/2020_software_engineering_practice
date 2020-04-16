package software.practice.distribution.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import software.practice.distribution.entity.Arrangement;
import software.practice.distribution.entity.ArrangementExample;

import java.util.List;

@Repository
public interface ArrangementMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrangement
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    long countByExample(ArrangementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrangement
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int deleteByExample(ArrangementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrangement
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int deleteByPrimaryKey(Integer arrangementId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrangement
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int insert(Arrangement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrangement
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int insertSelective(Arrangement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrangement
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    List<Arrangement> selectByExampleWithRowbounds(ArrangementExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrangement
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    List<Arrangement> selectByExample(ArrangementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrangement
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    Arrangement selectByPrimaryKey(Integer arrangementId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrangement
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int updateByExampleSelective(@Param("record") Arrangement record, @Param("example") ArrangementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrangement
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int updateByExample(@Param("record") Arrangement record, @Param("example") ArrangementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrangement
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int updateByPrimaryKeySelective(Arrangement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrangement
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    int updateByPrimaryKey(Arrangement record);
}