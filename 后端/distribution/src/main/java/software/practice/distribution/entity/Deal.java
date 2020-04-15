package software.practice.distribution.entity;

public class Deal {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal.deal_id
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    private Integer dealId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal.deal_user
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    private Integer dealUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal.deal_package
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    private Integer dealPackage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal.deal_content
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    private String dealContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal.deal_isdone
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    private Byte dealIsdone;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal.deal_id
     *
     * @return the value of deal.deal_id
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
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
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal.deal_user
     *
     * @return the value of deal.deal_user
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public Integer getDealUser() {
        return dealUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column deal.deal_user
     *
     * @param dealUser the value for deal.deal_user
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public void setDealUser(Integer dealUser) {
        this.dealUser = dealUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal.deal_package
     *
     * @return the value of deal.deal_package
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
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
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
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
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
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
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public void setDealContent(String dealContent) {
        this.dealContent = dealContent == null ? null : dealContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal.deal_isdone
     *
     * @return the value of deal.deal_isdone
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public Byte getDealIsdone() {
        return dealIsdone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column deal.deal_isdone
     *
     * @param dealIsdone the value for deal.deal_isdone
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public void setDealIsdone(Byte dealIsdone) {
        this.dealIsdone = dealIsdone;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "dealId=" + dealId +
                ", dealUser=" + dealUser +
                ", dealPackage=" + dealPackage +
                ", dealContent='" + dealContent + '\'' +
                ", dealIsdone=" + dealIsdone +
                '}';
    }
}