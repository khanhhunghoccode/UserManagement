/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.dtos;

/**
 *
 * @author PC
 */
public class UserErrorDTO {
    String errorUserID, errorFullName, errorPassword, errorRoleID, errorConfirm;
    
    public UserErrorDTO() {
    
    }

    public UserErrorDTO(String errorUserID, String errorFullName, String errorPassword, String errorRoleID, String errorConfirm) {
        this.errorUserID = errorUserID;
        this.errorFullName = errorFullName;
        this.errorPassword = errorPassword;
        this.errorRoleID = errorRoleID;
        this.errorConfirm = errorConfirm;
    }

    public String getErrorConfirm() {
        return errorConfirm;
    }

    public void setErrorConfirm(String errorConfirm) {
        this.errorConfirm = errorConfirm;
    }

    public String getErrorUserID() {
        return errorUserID;
    }

    public void setErrorUserID(String errorUserID) {
        this.errorUserID = errorUserID;
    }

    public String getErrorFullName() {
        return errorFullName;
    }

    public void setErrorFullName(String errorFullName) {
        this.errorFullName = errorFullName;
    }

    public String getErrorPassword() {
        return errorPassword;
    }

    public void setErrorPassword(String errorPassword) {
        this.errorPassword = errorPassword;
    }

    public String getErrorRoleID() {
        return errorRoleID;
    }

    public void setErrorRoleID(String errorRoleID) {
        this.errorRoleID = errorRoleID;
    }
    
}
