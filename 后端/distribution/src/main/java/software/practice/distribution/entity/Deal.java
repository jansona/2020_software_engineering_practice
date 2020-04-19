package software.practice.distribution.entity;

import java.util.Date;

public class Deal {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal.deal_id
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    private Integer dealId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal.deal_package
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    private Integer dealPackage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal.deal_content
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    private String dealContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal.deal_isPass
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    private Byte dealIspass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal.deal_response
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    private String dealResponse;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal.deal_time
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    private Date dealTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal.deal_id
     *
     * @return the value of deal.deal_id
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    public Integer getDealId() {
        return dealId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column deal.deal_id
     *
     * @param dealId the value for deal.deal_id
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal.deal_package
     *
     * @return the value of deal.deal_package
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    public Integer getDealPackage() {
        return dealPackage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column deal.deal_package
     *
     * @param dealPackage the value for deal.deal_package
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    public void setDealPackage(Integer dealPackage) {
        this.dealPackage = dealPackage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal.deal_content
     *
     * @return the value of deal.deal_content
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    public String getDealContent() {
        return dealContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column deal.deal_content
     *
     * @param dealContent the value for deal.deal_content
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    public void setDealContent(String dealContent) {
        this.dealContent = dealContent == null ? null : dealContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal.deal_isPass
     *
     * @return the value of deal.deal_isPass
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    public Byte getDealIspass() {
        return dealIspass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column deal.deal_isPass
     *
     * @param dealIspass the value for deal.deal_isPass
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    public void setDealIspass(Byte dealIspass) {
        this.dealIspass = dealIspass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal.deal_response
     *
     * @return the value of deal.deal_response
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    public String getDealResponse() {
        return dealResponse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column deal.deal_response
     *
     * @param dealResponse the value for deal.deal_response
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    public void setDealResponse(String dealResponse) {
        this.dealResponse = dealResponse == null ? null : dealResponse.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal.deal_time
     *
     * @return the value of deal.deal_time
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    public Date getDealTime() {
        return dealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column deal.deal_time
     *
     * @param dealTime the value for deal.deal_time
     *
     * @mbg.generated Sun Apr 19 11:03:37 CST 2020
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }
}