import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther: liuhuan
 * @date: ${.now?string('yyyy/MM/dd')}
 * @Description: ${classInfo.classComment}服务层
 */
@Service
public class ${classInfo.className}Service extends BaseService<${classInfo.className}, Long> implements I${classInfo.className}Service {

	@Autowired
	private ${classInfo.className}Mapper ${classInfo.className?uncap_first}Mapper;

}
