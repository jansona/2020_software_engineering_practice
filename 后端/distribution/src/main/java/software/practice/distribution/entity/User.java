package software.practice.distribution.entity;

import java.util.Date;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_id
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_name
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_address
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    private String userAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_favorite_starttime
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    private Date userFavoriteStarttime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_time_stay
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    private Integer userTimeStay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_community
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    private Integer userCommunity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_password
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    private String userPassword;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_id
     *
     * @return the value of user.user_id
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_id
     *
     * @param userId the value for user.user_id
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_name
     *
     * @return the value of user.user_name
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_name
     *
     * @param userName the value for user.user_name
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_address
     *
     * @return the value of user.user_address
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_address
     *
     * @param userAddress the value for user.user_address
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_favorite_starttime
     *
     * @return the value of user.user_favorite_starttime
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public Date getUserFavoriteStarttime() {
        return userFavoriteStarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_favorite_starttime
     *
     * @param userFavoriteStarttime the value for user.user_favorite_starttime
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void setUserFavoriteStarttime(Date userFavoriteStarttime) {
        this.userFavoriteStarttime = userFavoriteStarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_time_stay
     *
     * @return the value of user.user_time_stay
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public Integer getUserTimeStay() {
        return userTimeStay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_time_stay
     *
     * @param userTimeStay the value for user.user_time_stay
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void setUserTimeStay(Integer userTimeStay) {
        this.userTimeStay = userTimeStay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_community
     *
     * @return the value of user.user_community
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public Integer getUserCommunity() {
        return userCommunity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_community
     *
     * @param userCommunity the value for user.user_community
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void setUserCommunity(Integer userCommunity) {
        this.userCommunity = userCommunity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_password
     *
     * @return the value of user.user_password
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_password
     *
     * @param userPassword the value for user.user_password
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }
}