import java.util.Map;

/**
 * @auther: liuhuan
 * @date: ${.now?string('yyyy-MM-dd')}
 * @Description: ${classInfo.classComment}服务接口
 */
public interface ${classInfo.className}Service {

    /**
    * 新增
    */
    public ReturnT<String> insert(${classInfo.className} ${classInfo.className?uncap_first});

    /**
    * 删除
    */
    public ReturnT<String> delete(int id);

    /**
    * 更新
    */
    public ReturnT<String> update(${classInfo.className} ${classInfo.className?uncap_first});

    /**
    * Load查询
    */
    public ${classInfo.className} load(int id);

    /**
    * 分页查询
    */
    public Map<String,Object> pageList(int offset, int pagesize);

}
