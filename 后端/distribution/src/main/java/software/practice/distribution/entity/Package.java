package software.practice.distribution.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Package {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column package.package_id
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    private Integer packageId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column package.package_user
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    private Integer packageUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column package.package_content
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    private String packageContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column package.package_id
     *
     * @return the value of package.package_id
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public Integer getPackageId() {
        return packageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column package.package_id
     *
     * @param packageId the value for package.package_id
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column package.package_user
     *
     * @return the value of package.package_user
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public Integer getPackageUser() {
        return packageUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column package.package_user
     *
     * @param packageUser the value for package.package_user
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void setPackageUser(Integer packageUser) {
        this.packageUser = packageUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column package.package_content
     *
     * @return the value of package.package_content
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public String getPackageContent() {
        return packageContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column package.package_content
     *
     * @param packageContent the value for package.package_content
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void setPackageContent(String packageContent) {
        this.packageContent = packageContent == null ? null : packageContent.trim();
    }
}