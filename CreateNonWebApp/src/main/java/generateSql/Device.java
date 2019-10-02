package generateSql;



public class Device {
    private Integer id;

    private String deviceId;

    private String keyType;

    private String singular;

    private String algorithm;

    private String deviceVendor;

    private String ifaaVersion;

    private String status;

    private String keyData;

    private long updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

     String getDeviceId() {
        return deviceId;
    }

     void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

     String getKeyType() {
        return keyType;
    }

     void setKeyType(String keyType) {
        this.keyType = keyType == null ? null : keyType.trim();
    }

     String getSingular() {
        return singular;
    }

     void setSingular(String singular) {
        this.singular = singular == null ? null : singular.trim();
    }

     String getAlgorithm() {
        return algorithm;
    }

     void setAlgorithm(String algorithm) {
        this.algorithm = algorithm == null ? null : algorithm.trim();
    }

     String getDeviceVendor() {
        return deviceVendor;
    }

     void setDeviceVendor(String deviceVendor) {
        this.deviceVendor = deviceVendor == null ? null : deviceVendor.trim();
    }

     String getIfaaVersion() {
        return ifaaVersion;
    }

     void setIfaaVersion(String ifaaVersion) {
        this.ifaaVersion = ifaaVersion == null ? null : ifaaVersion.trim();
    }

     String getStatus() {
        return status;
    }

     void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

     String getKeyData() {
        return keyData;
    }

     void setKeyData(String keyData) {
        this.keyData = keyData == null ? null : keyData.trim();
    }

     long getUpdateTime() {
        return updateTime;
    }

     void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}