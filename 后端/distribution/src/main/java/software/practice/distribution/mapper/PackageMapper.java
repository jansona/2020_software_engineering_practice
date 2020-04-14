package software.practice.distribution.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import software.practice.distribution.entity.Package;
import software.practice.distribution.entity.PackageExample;

public interface PackageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    long countByExample(PackageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int deleteByExample(PackageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int deleteByPrimaryKey(Integer packageId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int insert(Package record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int insertSelective(Package record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    List<Package> selectByExample(PackageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    Package selectByPrimaryKey(Integer packageId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int updateByExampleSelective(@Param("record") Package record, @Param("example") PackageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int updateByExample(@Param("record") Package record, @Param("example") PackageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int updateByPrimaryKeySelective(Package record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package
     *
     * @mbg.generated Tue Apr 14 16:33:29 CST 2020
     */
    int updateByPrimaryKey(Package record);
}