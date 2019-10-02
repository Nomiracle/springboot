package generateSql;

import com.google.gson.annotations.SerializedName;

import java.util.List;

 class IFAADeviceCertAction {
    
    @SerializedName("import")
    private List<String[]> importAction;

    @SerializedName("update")
    private List<String[]> updateAction;

    @SerializedName("revoke")
     private List<String[]> revokeAction;

     List<String[]> getImportAction() {
        return importAction;
    }

     void setImportAction(List<String[]> importAction) {
        this.importAction = importAction;
    }

     List<String[]> getUpdateAction() {
        return updateAction;
    }

     void setUpdateAction(List<String[]> updateAction) {
        this.updateAction = updateAction;
    }

     List<String[]> getRevokeAction() {
        return revokeAction;
    }

     void setRevokeAction(List<String[]> revokeAction) {
        this.revokeAction = revokeAction;
    }
}