package com.example.workflow.ctrl;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.*;

/**
 * @BelongsProject: work-flow
 * @BelongsPackage: com.example.workflow.ctrl
 * @Author: ZhenShan Xu
 * @CreateTime: 2021-02-20 14:07.
 * @Description: 自动生成类
 */

public class CodeGenerator {

    /**
     * <p>
     * 必要配置
     * </p>
     */
    //生成代码的表名
    private static final String TABLE_NAME = "sys_user";

    /**
     * 输出文件的路径
     * //位置根据用户
     */
    private static final String OUT_PATH = "E:\\projectCode\\idea_workspace\\modelCode\\work-flow";
    //数据库相关配置
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/work_flow?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql@password";

    //注释显示作者
    private static final String AUTHOR = "snail";

    //代码生成指定包名
    private static final String PACKAGE_NAME = "com.example.workflow";

    /**
     * 首字母小写
     *
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    public static void main(String[] args) {

        //======= 全局配置 =======
        String projectPath = System.getProperty("user.dir");
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(projectPath + "/src/main/java")
                .setAuthor(AUTHOR)
                .setOpen(false)
                .setFileOverride(false)
                .setBaseResultMap(false)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                .setSwagger2(true)//实体属性 Swagger2 注解
                //自定义文件命名，注意 %s 会自动填充表实体属性！
                .setEntityName("%sBean")
                .setMapperName("%sDao")
                .setXmlName("%sMapper")
                .setServiceImplName("I%sServiceImpl")
                .setControllerName("%sApi");

        //======= 数据源配置 =======
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setUrl(JDBC_URL)
                .setDriverName(DRIVER_NAME)
                .setUsername(USERNAME)
                .setPassword(PASSWORD);

        //======= 包 配置 =======
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(PACKAGE_NAME)
                .setService("service")
                .setController("api")
                .setEntity("bean")
                .setMapper("dao")
                .setXml("mapper");

        //======= 自定义配置 =======
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
         String templatePath = "/templates/mapper.xml.vm";
        //自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        //自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String entityName = toLowerCaseFirstOne(tableInfo.getEntityName().split("Bean")[0]);
                return OUT_PATH + "/src/main/resources/mapper/" + entityName + "Mapper.xml";
            }
        });
        injectionConfig.setFileOutConfigList(focList);

        //======= 模板配置 =======
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);

        //======= 策略配置 =======
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel)// 表名
                .setColumnNaming(NamingStrategy.underline_to_camel)// 字段
                .setInclude(TABLE_NAME)// 需要生成的表
                .setEntityLombokModel(true)//lombok模型
                .setRestControllerStyle(true)// Rest控制器
                .setCapitalMode(true)// 驼峰命名
                .setTablePrefix(TABLE_NAME.split("_")[0]);//表名前缀(生成的实体会省略这个前缀)


        // ======= 执行生成 =======
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSource)
                .setPackageInfo(packageConfig)
                .setStrategy(strategy)
                .setCfg(injectionConfig)
                .setTemplate(templateConfig)
                .execute();
    }
}
