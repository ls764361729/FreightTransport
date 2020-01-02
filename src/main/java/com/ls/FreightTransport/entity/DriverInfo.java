package com.ls.FreightTransport.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class DriverInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_info.d_id
     *
     * @mbg.generated
     */
    private Integer dId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_info.d_name
     *
     * @mbg.generated
     */
    private String dName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_info.d_sex
     *
     * @mbg.generated
     */
    private String dSex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_info.d_uuid
     *
     * @mbg.generated
     */
    private String dUuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_info.d_phone
     *
     * @mbg.generated
     */
    private String dPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_info.d_password
     *
     * @mbg.generated
     */
    private String dPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_info.d_card
     *
     * @mbg.generated
     */
    private String dCard;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_info.d_balance
     *
     * @mbg.generated
     */
    private BigDecimal dBalance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_info.d_register_date
     *
     * @mbg.generated
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date dRegisterDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_info.d_s_remarks
     *
     * @mbg.generated
     */
    private String dSRemarks;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_info.d_id
     *
     * @return the value of driver_info.d_id
     *
     * @mbg.generated
     */
    public Integer getdId() {
        return dId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_info.d_id
     *
     * @param dId the value for driver_info.d_id
     *
     * @mbg.generated
     */
    public void setdId(Integer dId) {
        this.dId = dId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_info.d_name
     *
     * @return the value of driver_info.d_name
     *
     * @mbg.generated
     */
    public String getdName() {
        return dName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_info.d_name
     *
     * @param dName the value for driver_info.d_name
     *
     * @mbg.generated
     */
    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_info.d_sex
     *
     * @return the value of driver_info.d_sex
     *
     * @mbg.generated
     */
    public String getdSex() {
        return dSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_info.d_sex
     *
     * @param dSex the value for driver_info.d_sex
     *
     * @mbg.generated
     */
    public void setdSex(String dSex) {
        this.dSex = dSex == null ? null : dSex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_info.d_uuid
     *
     * @return the value of driver_info.d_uuid
     *
     * @mbg.generated
     */
    public String getdUuid() {
        return dUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_info.d_uuid
     *
     * @param dUuid the value for driver_info.d_uuid
     *
     * @mbg.generated
     */
    public void setdUuid(String dUuid) {
        this.dUuid = dUuid == null ? null : dUuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_info.d_phone
     *
     * @return the value of driver_info.d_phone
     *
     * @mbg.generated
     */
    public String getdPhone() {
        return dPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_info.d_phone
     *
     * @param dPhone the value for driver_info.d_phone
     *
     * @mbg.generated
     */
    public void setdPhone(String dPhone) {
        this.dPhone = dPhone == null ? null : dPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_info.d_password
     *
     * @return the value of driver_info.d_password
     *
     * @mbg.generated
     */
    public String getdPassword() {
        return dPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_info.d_password
     *
     * @param dPassword the value for driver_info.d_password
     *
     * @mbg.generated
     */
    public void setdPassword(String dPassword) {
        this.dPassword = dPassword == null ? null : dPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_info.d_card
     *
     * @return the value of driver_info.d_card
     *
     * @mbg.generated
     */
    public String getdCard() {
        return dCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_info.d_card
     *
     * @param dCard the value for driver_info.d_card
     *
     * @mbg.generated
     */
    public void setdCard(String dCard) {
        this.dCard = dCard == null ? null : dCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_info.d_balance
     *
     * @return the value of driver_info.d_balance
     *
     * @mbg.generated
     */
    public BigDecimal getdBalance() {
        return dBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_info.d_balance
     *
     * @param dBalance the value for driver_info.d_balance
     *
     * @mbg.generated
     */
    public void setdBalance(BigDecimal dBalance) {
        this.dBalance = dBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_info.d_register_date
     *
     * @return the value of driver_info.d_register_date
     *
     * @mbg.generated
     */
    public Date getdRegisterDate() {
        return dRegisterDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_info.d_register_date
     *
     * @param dRegisterDate the value for driver_info.d_register_date
     *
     * @mbg.generated
     */
    public void setdRegisterDate(Date dRegisterDate) {
        this.dRegisterDate = dRegisterDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_info.d_s_remarks
     *
     * @return the value of driver_info.d_s_remarks
     *
     * @mbg.generated
     */
    public String getdSRemarks() {
        return dSRemarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_info.d_s_remarks
     *
     * @param dSRemarks the value for driver_info.d_s_remarks
     *
     * @mbg.generated
     */
    public void setdSRemarks(String dSRemarks) {
        this.dSRemarks = dSRemarks == null ? null : dSRemarks.trim();
    }
}