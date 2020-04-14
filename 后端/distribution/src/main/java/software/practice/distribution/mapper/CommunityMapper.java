package software.practice.distribution.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import software.practice.distribution.entity.Community;
import software.practice.distribution.entity.CommunityExample;

public interface CommunityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    long countByExample(CommunityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int deleteByExample(CommunityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int deleteByPrimaryKey(Integer communityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int insert(Community record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int insertSelective(Community record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    List<Community> selectByExample(CommunityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    Community selectByPrimaryKey(Integer communityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int updateByExampleSelective(@Param("record") Community record, @Param("example") CommunityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int updateByExample(@Param("record") Community record, @Param("example") CommunityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int updateByPrimaryKeySelective(Community record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int updateByPrimaryKey(Community record);
}