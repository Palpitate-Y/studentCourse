package cui.xin.studentcourse.util;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.List;

public class ResultMapUtil {

    /**
     * 异常数据统一处理
     */
    public static HashMap<String,Object> getHashMapException(Exception e){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg",e.getMessage());
        return resultMap;
    }

    /**
     * 保存成功的统一返回格式
     */
    public static HashMap<String,Object> getHashMapSave(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if(i == 0){
            resultMap.put("msg","保存失败");
        }else {
            resultMap.put("msg","保存成功");
        }
        return resultMap;
    }

    /**
     * 删除成功的统一返回格式
     */
    public static HashMap<String,Object> getHashMapDel(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if(i == 0){
            resultMap.put("msg","删除失败");
        }else {
            resultMap.put("msg","删除成功");
        }
        return resultMap;
    }

    /**
     * List返回格式
     */
    public static HashMap<String,Object> getHashMapList(List<?> list){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        if (list != null && list.size() > 0){
            resultMap.put("msg","");
        }else {
            resultMap.put("msg","没有查询到数据!");
        }
        resultMap.put("data",list);
        return resultMap;
    }
}
