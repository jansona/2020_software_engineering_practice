package software.practice.distribution.entity;

public class DealResponse {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal_response.deal_response_id
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    private Integer dealResponseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal_response.deal_response_ispass
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    private Byte dealResponseIspass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal_response.deal_response_message
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    private String dealResponseMessage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column deal_response.deal_response_deal
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    private Integer dealResponseDeal;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal_response.deal_response_id
     *
     * @return the value of deal_response.deal_response_id
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public Integer getDealResponseId() {
        return dealResponseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column deal_response.deal_response_id
     *
     * @param dealResponseId the value for deal_response.deal_response_id
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public void setDealResponseId(Integer dealResponseId) {
        this.dealResponseId = dealResponseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal_response.deal_response_ispass
     *
     * @return the value of deal_response.deal_response_ispass
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public Byte getDealResponseIspass() {
        return dealResponseIspass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column deal_response.deal_response_ispass
     *
     * @param dealResponseIspass the value for deal_response.deal_response_ispass
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public void setDealResponseIspass(Byte dealResponseIspass) {
        this.dealResponseIspass = dealResponseIspass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal_response.deal_response_message
     *
     * @return the value of deal_response.deal_response_message
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public String getDealResponseMessage() {
        return dealResponseMessage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column deal_response.deal_response_message
     *
     * @param dealResponseMessage the value for deal_response.deal_response_message
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public void setDealResponseMessage(String dealResponseMessage) {
        this.dealResponseMessage = dealResponseMessage == null ? null : dealResponseMessage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column deal_response.deal_response_deal
     *
     * @return the value of deal_response.deal_response_deal
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public Integer getDealResponseDeal() {
        return dealResponseDeal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column deal_response.deal_response_deal
     *
     * @param dealResponseDeal the value for deal_response.deal_response_deal
     *
     * @mbg.generated Wed Apr 15 11:06:09 CST 2020
     */
    public void setDealResponseDeal(Integer dealResponseDeal) {
        this.dealResponseDeal = dealResponseDeal;
    }
}