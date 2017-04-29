package com.github.support.entitement.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.usrname
     *
     * @mbggenerated
     */
    private String usrname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.ICONCLS
     *
     * @mbggenerated
     */
    private String iconcls;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.TEXT
     *
     * @mbggenerated
     */
    private String text;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.createdatetime
     *
     * @mbggenerated
     */
    private Date createdatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.note
     *
     * @mbggenerated
     */
    private String note;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.usrname
     *
     * @return the value of t_user.usrname
     *
     * @mbggenerated
     */
    public String getUsrname() {
        return usrname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.usrname
     *
     * @param usrname the value for t_user.usrname
     *
     * @mbggenerated
     */
    public void setUsrname(String usrname) {
        this.usrname = usrname == null ? null : usrname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.password
     *
     * @return the value of t_user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.password
     *
     * @param password the value for t_user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.ICONCLS
     *
     * @return the value of t_user.ICONCLS
     *
     * @mbggenerated
     */
    public String getIconcls() {
        return iconcls;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.ICONCLS
     *
     * @param iconcls the value for t_user.ICONCLS
     *
     * @mbggenerated
     */
    public void setIconcls(String iconcls) {
        this.iconcls = iconcls == null ? null : iconcls.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.TEXT
     *
     * @return the value of t_user.TEXT
     *
     * @mbggenerated
     */
    public String getText() {
        return text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.TEXT
     *
     * @param text the value for t_user.TEXT
     *
     * @mbggenerated
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.createdatetime
     *
     * @return the value of t_user.createdatetime
     *
     * @mbggenerated
     */
    public Date getCreatedatetime() {
        return createdatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.createdatetime
     *
     * @param createdatetime the value for t_user.createdatetime
     *
     * @mbggenerated
     */
    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.note
     *
     * @return the value of t_user.note
     *
     * @mbggenerated
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.note
     *
     * @param note the value for t_user.note
     *
     * @mbggenerated
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsrname() == null ? other.getUsrname() == null : this.getUsrname().equals(other.getUsrname()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getIconcls() == null ? other.getIconcls() == null : this.getIconcls().equals(other.getIconcls()))
            && (this.getText() == null ? other.getText() == null : this.getText().equals(other.getText()))
            && (this.getCreatedatetime() == null ? other.getCreatedatetime() == null : this.getCreatedatetime().equals(other.getCreatedatetime()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsrname() == null) ? 0 : getUsrname().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getIconcls() == null) ? 0 : getIconcls().hashCode());
        result = prime * result + ((getText() == null) ? 0 : getText().hashCode());
        result = prime * result + ((getCreatedatetime() == null) ? 0 : getCreatedatetime().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", usrname=").append(usrname);
        sb.append(", password=").append(password);
        sb.append(", iconcls=").append(iconcls);
        sb.append(", text=").append(text);
        sb.append(", createdatetime=").append(createdatetime);
        sb.append(", note=").append(note);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}