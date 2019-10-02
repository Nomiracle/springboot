/**
 * Copyright(c) 2017, Beijing eSand Information Technology Co., Ltd. All rights reserved.
 * 
 * File Comment Here! 
 * 
 * @author  拼命三郎 
 * @since    v1.0
 */
package generateSql;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * @author ReidLee
 * 需要导入的设备数据公钥JSON数据解析
 * 
 *   {
 *	    idHsmKey: "1234567890",                     ---- 用于协商密钥的HSM设备公钥ID
 *	    otPk: "12345678901234567890123456789012",   ---- 用于协商密钥的一次性公钥
 *	    type: 1,                                    ---- 数据类型，可以参考 com.esandinfo.ifaa.hsm.implement.Common.CERTFORMAT
 *		singular: 1,                                ---- 密钥特性，可以参考 com.esandinfo.ifaa.hsm.implement.Common.SINGULAR             
 *		algorithm: 1,                               ---- 加密算法，可以参考 com.esandinfo.ifaa.hsm.implement.Common.ALGORITHM
 *	    action: {
 *	      import: [                                 ---- 要导入的公钥／证书列表，该数据使用协商的密钥加密，数据格式为4个元素的数组
 *	        [
 *	          "MEIZU",                              ---- 设备制造商名字
 *	          "MX5",                                ---- 设备型号／设备ID
 *	          "2,1",                                ---- IFAA实现版本
 *	          "12345678901234567890123456789012"    ---- 加密的公钥／证书数据
 *	        ]
 *	      ],
 *	      update: [...],                            ---- 格式通上 import
 *	      revoke: [...]                             ---- 格式通上 import
 *	    }
 *	}
 */

public class IFAADeviceCert {
	
	private String idHsmKey;
	private String otPk;
	private int type;
	private int singular;
	private int algorithm;
	private IFAADeviceCertAction action;

    public IFAADeviceCertAction getAction() {
		return action;
	}

	public void setAction(IFAADeviceCertAction action) {
		this.action = action;
	}

    public String getIdHsmKey() {
        return idHsmKey;
    }

    public void setIdHsmKey(String idHsmKey) {
        this.idHsmKey = idHsmKey;
    }

    public String getOtPk() {
		return otPk;
	}

	public void setOtPk(String otPk) {
		this.otPk = otPk;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSingular() {
		return singular;
	}

	public void setSingular(int singular) {
		this.singular = singular;
	}

	public int getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(int algorithm) {
		this.algorithm = algorithm;
	}

	public static IFAADeviceCert fromJson(String json) {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping().create();
		return (IFAADeviceCert)gson.fromJson(json, IFAADeviceCert.class);

	}

	public String toJson() {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping().create();
		return gson.toJson(this);
	}

	
}




