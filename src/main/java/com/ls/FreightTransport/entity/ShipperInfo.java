package com.ls.FreightTransport.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShipperInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shipper_info.s_id
     *
     * @mbg.generated
     */
    private Integer sId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shipper_info.s_name
     *
     * @mbg.generated
     */
    private String sName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shipper_info.s_sex
     *
     * @mbg.generated
     */
    private String sSex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shipper_info.s_phone
     *
     * @mbg.generated
     */
    private String sPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shipper_info.s_password
     *
     * @mbg.generated
     */
    private String sPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shipper_info.s_uuid
     *
     * @mbg.generated
     */
    private String sUuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shipper_info.s_balance
     *
     * @mbg.generated
     */
    private BigDecimal sBalance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shipper_info.s_register_date
     *
     * @mbg.generated
     */
    private Date sRegisterDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shipper_info.s_remarks
     *
     * @mbg.generated
     */
    private String sRemarks;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shipper_info.s_id
     *
     * @return the value of shipper_info.s_id
     *
     * @mbg.generated
     */
    public Integer getsId() {
        return sId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shipper_info.s_id
     *
     * @param sId the value for shipper_info.s_id
     *
     * @mbg.generated
     */
    public void setsId(Integer sId) {
        this.sId = sId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shipper_info.s_name
     *
     * @return the value of shipper_info.s_name
     *
     * @mbg.generated
     */
    public String getsName() {
        return sName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shipper_info.s_name
     *
     * @param sName the value for shipper_info.s_name
     *
     * @mbg.generated
     */
    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shipper_info.s_sex
     *
     * @return the value of shipper_info.s_sex
     *
     * @mbg.generated
     */
    public String getsSex() {
        return sSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shipper_info.s_sex
     *
     * @param sSex the value for shipper_info.s_sex
     *
     * @mbg.generated
     */
    public void setsSex(String sSex) {
        this.sSex = sSex == null ? null : sSex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shipper_info.s_phone
     *
     * @return the value of shipper_info.s_phone
     *
     * @mbg.generated
     */
    public String getsPhone() {
        return sPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shipper_info.s_phone
     *
     * @param sPhone the value for shipper_info.s_phone
     *
     * @mbg.generated
     */
    public void setsPhone(String sPhone) {
        this.sPhone = sPhone == null ? null : sPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shipper_info.s_password
     *
     * @return the value of shipper_info.s_password
     *
     * @mbg.generated
     */
    public String getsPassword() {
        return sPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shipper_info.s_password
     *
     * @param sPassword the value for shipper_info.s_password
     *
     * @mbg.generated
     */
    public void setsPassword(String sPassword) {
        this.sPassword = sPassword == null ? null : sPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shipper_info.s_uuid
     *
     * @return the value of shipper_info.s_uuid
     *
     * @mbg.generated
     */
    public String getsUuid() {
        return sUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shipper_info.s_uuid
     *
     * @param sUuid the value for shipper_info.s_uuid
     *
     * @mbg.generated
     */
    public void setsUuid(String sUuid) {
        this.sUuid = sUuid == null ? null : sUuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shipper_info.s_balance
     *
     * @return the value of shipper_info.s_balance
     *
     * @mbg.generated
     */
    public BigDecimal getsBalance() {
        return sBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shipper_info.s_balance
     *
     * @param sBalance the value for shipper_info.s_balance
     *
     * @mbg.generated
     */
    public void setsBalance(BigDecimal sBalance) {
        this.sBalance = sBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shipper_info.s_register_date
     *
     * @return the value of shipper_info.s_register_date
     *
     * @mbg.generated
     */
    public Date getsRegisterDate() {
        return sRegisterDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shipper_info.s_register_date
     *
     * @param sRegisterDate the value for shipper_info.s_register_date
     *
     * @mbg.generated
     */
    public void setsRegisterDate(Date sRegisterDate) {
        this.sRegisterDate = sRegisterDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shipper_info.s_remarks
     *
     * @return the value of shipper_info.s_remarks
     *
     * @mbg.generated
     */
    public String getsRemarks() {
        return sRemarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shipper_info.s_remarks
     *
     * @param sRemarks the value for shipper_info.s_remarks
     *
     * @mbg.generated
     */
    public void setsRemarks(String sRemarks) {
        this.sRemarks = sRemarks == null ? null : sRemarks.trim();
    }
}