package soni.sandeep.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JdbcStore {

    @Value("${spring.datasource.url}")
    private String masterUrl;

    @Value("${spring.datasource.username}")
    private String masterUserName;

    @Value("${spring.datasource.password}")
    private String masterPassword;

    @Value("${spring.jpa.database-platform}")
    private String masterDatabasePlatform;

    @Value("${spring.jpa.generate-ddl}")
    private String masterDdl;

    @Value("${spring.datasource.driver-class-name}")
    private String masterDriver;

    @Value("${spring.datasource.driver-class-name}")
    private String masterDdlAuto;

    @Value("${spring.datasource.slave.url}")
    private String slaveUrl;




    public String getSlaveUrl() {
        return slaveUrl;
    }

    public void setSlaveUrl(String slaveUrl) {
        this.slaveUrl = slaveUrl;
    }

    public String getMasterUserName() {
        return masterUserName;
    }

    public void setMasterUserName(String masterUserName) {
        this.masterUserName = masterUserName;
    }

    public String getMasterPassword() {
        return masterPassword;
    }

    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
    }

    public String getMasterDatabasePlatform() {
        return masterDatabasePlatform;
    }

    public void setMasterDatabasePlatform(String masterDatabasePlatform) {
        this.masterDatabasePlatform = masterDatabasePlatform;
    }

    public String getMasterDdl() {
        return masterDdl;
    }

    public void setMasterDdl(String masterDdl) {
        this.masterDdl = masterDdl;
    }

    public String getMasterDriver() {
        return masterDriver;
    }

    public void setMasterDriver(String masterDriver) {
        this.masterDriver = masterDriver;
    }

    public String getMasterDdlAuto() {
        return masterDdlAuto;
    }

    public void setMasterDdlAuto(String masterDdlAuto) {
        this.masterDdlAuto = masterDdlAuto;
    }

    public String getMasterUrl() {
        return masterUrl;
    }

    public void setMasterUrl(String masterUrl) {
        this.masterUrl = masterUrl;
    }

}
