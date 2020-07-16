
import org.seryu.plugs.generate.mybatisPlugs.MybatisPlusGenerator;
import org.seryu.plugs.generate.mybatisPlugs.SqlGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * @program: potato-parent
 * @description: 创建表格
 * @author: xujunjie
 * @create: 2020-04-24 15:17
 **/
@RunWith(JUnit4.class)
public class GeneratorCreateTable
{
    /**
     * 根据bean生成table
     */
    @Test
    public void generatorSqlTable()
    {
        //需要生成表格的类
        Class objectClass = Object.class;
        String tableName = "a_test";

        Map<Class,String> map = new HashMap<>();
        map.put(objectClass,tableName);
        List<String> id = map.entrySet().stream().map(k -> SqlGenerator.generateSql(k.getKey(), k.getValue(), "id", null)).collect(Collectors.toList());
        System.out.println(id);
    }

    @Test
    public void generatorDao()
    {
        // 生成DAO层
        //用来获取Mybatis-Plus.properties文件的配置信息
        final ResourceBundle rb = ResourceBundle.getBundle("generator/mybatis-plus-config");
        new MybatisPlusGenerator().generator(rb);
    }
}
