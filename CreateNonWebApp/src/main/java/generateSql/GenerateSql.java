package generateSql;

import com.esandinfo.ifaa.hsm.utils.MyFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

@Component
public class GenerateSql {
    private static Logger logger = LoggerFactory.getLogger(GenerateSql.class);
    private static List<String> sqlList = new LinkedList<>();
    private String sqlName = "generatedSql.sql";
    private String filePath = "d:\\";

    int generate() throws Exception{

        Path currentRelativePath = Paths.get(filePath);
        String path = currentRelativePath.toAbsolutePath().toString();
        File file = new File(path);

        Map<String,String> r=new HashMap<>();
        if (file.isDirectory()) {
            // 获取路径下的所有文件
            File[] files = file.listFiles();

            if (files == null || files.length ==0) {
                logger.debug("路径下不存在密钥文件！！");
            }
            for (File singleFile:files){
           // for (int i = 0; i < files.length; i++) {
                // 如果还是文件夹 不作操作
                if (singleFile.isDirectory()) {
                    logger.debug("目录：" + singleFile.getPath());
                } else {
                    String tmpName = singleFile.getName();
                    if(tmpName.equals(sqlName)){
                        singleFile.delete();
                        continue;
                    }
                    if (tmpName.endsWith("txt")) {
                        byte[] date = MyFile.get(singleFile.getPath());
                        String dateString = new String(date, "UTF-8");
                        IFAADeviceCert ifaaDeviceCert = IFAADeviceCert.fromJson(dateString);
                        logger.debug("导入的公钥文件为   " + dateString);
                        r.put("msg",updateIfaaDeviceBatch(ifaaDeviceCert));
                        if ("密钥导入成功".equals(r.get("msg"))) {
                            boolean delReult = singleFile.delete();
                            if(!delReult){
                                logger.error("临时文件删除出错");
                            }
                            logger.info("文件----->" + singleFile.getPath() + "   导入解析成功！！");
                        } else {
                            logger.info("文件----->" + singleFile.getPath() + "   解析失败！！");
                        }
                        if ("设备公钥转加密异常,密钥导入失败".equals(r.get("msg"))) {
                            logger.error("设备公钥转加密异常,密钥导入失败");
                        }
                        if ("服务器异常,密钥导入失败".equals(r.get("msg"))) {
                            logger.error("设备公钥转加密异常,密钥导入失败");
                        }
                    }
                }
            }
            Files.write(Paths.get(filePath+sqlName),
                    sqlList,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            return 1;
        } else {
            logger.debug("路径不存在");
            return 2;
        }
    }

    String generateChangeStstusSql(String DEVICE_ID){
        String PRE =  "UPDATE IFAA_DEVICE SET STATUS = '3', UPDATE_TIME = " +new Date().getTime()
                +" WHERE STATUS = '1' AND DEVICE_ID = ";
        return PRE+DEVICE_ID+";";
    }
    void initDevice(Device device,String[]strings){
        device.setDeviceId("'"+strings[0]+"'");
        device.setDeviceVendor("''");
        device.setIfaaVersion("'"+strings[1]+"'");
        device.setUpdateTime(new Date().getTime());
        device.setStatus("'1'");
        device.setKeyData("''");
    }
    String generateInsertSql(Device device){
        String insertPre = "INSERT INTO IFAA_DEVICE(DEVICE_ID, KEY_TYPE, SINGULAR, ALGORITHM, " +
                "DEVICE_VENDOR, IFAA_VERSION, STATUS, KEY_DATA, UPDATE_TIME) VALUES ";
        StringJoiner insertJoiner = new StringJoiner(",","(",");");

        String insertSql=insertPre+
                insertJoiner.add(device.getDeviceId())
                        .add(device.getKeyType())
                        .add(device.getSingular())
                        .add(device.getAlgorithm())
                        .add(device.getDeviceVendor())
                        .add(device.getIfaaVersion())
                        .add(device.getStatus())
                        .add(device.getKeyData())
                        .add(device.getUpdateTime()+"").toString();

        return insertSql;
    }
    String updateIfaaDeviceBatch(IFAADeviceCert ifaaDeviceCert){
        try {
            Device device = new Device();
            device.setKeyType("'"+ifaaDeviceCert.getType()+"'");
            device.setSingular("'"+ifaaDeviceCert.getSingular()+"'");
            device.setAlgorithm("'"+ifaaDeviceCert.getAlgorithm()+"'");

            //import处理
            List<String[]> importList = ifaaDeviceCert.getAction().getImportAction();
            if (importList!=null) {
                for (String[] strings : importList) {
                    initDevice(device,strings);
                    sqlList.add(generateChangeStstusSql(device.getDeviceId()));
                    sqlList.add(generateInsertSql(device));
                }
            }

            //update处理
            List<String[]> updateList = ifaaDeviceCert.getAction().getUpdateAction();
            if (updateList!=null) {
                for (String[] strings : updateList) {
                    // 更新状态为"已废弃"
                    initDevice(device,strings);
                    sqlList.add(generateChangeStstusSql(device.getDeviceId()));
                    sqlList.add(generateInsertSql(device));
                }
            }

            //revoke处理
            List<String[]> revokeList = ifaaDeviceCert.getAction().getRevokeAction();
            if (revokeList!=null) {
                for (String[] strings : updateList) {
                    // 更新状态为"已撤销"
                    initDevice(device,strings);
                    device.setStatus("2");
                    sqlList.add(generateChangeStstusSql(device.getDeviceId()));
                }
            }

            return "密钥导入成功";

        } catch (Exception e) {
            logger.error("导入设备公钥出错"+e);
            e.printStackTrace();
            return "服务器异常,密钥导入失败";
        }
    }
}
