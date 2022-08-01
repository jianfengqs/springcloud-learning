package com.qs.listtener.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import lombok.Builder;
import lombok.Data;

import java.util.Collections;

/**
 * 3.5.x 新版生成器 可连远程数据库 ，旧版远程报错
 * new MyBatisGenerate.Builder()
 * .setDbName("universal_portal")
 * .setModule("")
 * .setPrefix(new String[]{""})
 * .setParentPackage("generate")
 * .setDbHostAndPort("localhost:3306")
 * .setDbUserName("root")
 * .setDbPsw("123456")
 * .setTables(new String[]{"user"})
 * .build()
 * .generate();
 *
 * @author zhaijianfeng
 * @date 2022/07/19
 */
@Data
@Builder
public class MyBatisGenerate {

    /**
     * 数据库名称
     */
    private String dbName;
    /**
     * 模块名称
     */
    private String module;
    /**
     * 去除表前缀如t_ tb_
     */
    private String[] prefix;
    /**
     * 父级包名称如appenv
     */
    private String parentPackage;
    /**
     * 数据库host和端口
     */
    private String dbHostAndPort;
    /**
     * 数据库用户名
     */
    private String dbUserName;
    /**
     * 数据库密码
     */
    private String dbPsw;
    /**
     * 表名称 ,string数组
     */
    private String[] tables;
//    /**
//     * 排除的表
//     */
//    private String[] excludeTables;

    /**
     * 作者
     */
    private String author;

    /**
     * 代码生成
     */
    public void generate() {
        // 数据源配置
        String url = "jdbc:mysql://" + dbHostAndPort + "/" + dbName;
        DataSourceConfig dsb = new DataSourceConfig.Builder(url, dbUserName, dbPsw)
                .dbQuery(new MySqlQuery())
                // 库名
                .schema(dbName)
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler()).build();
        // 获取当前项目路径
        String projectPath = System.getProperty("user.dir");
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                // 输出目录
                .outputDir(projectPath + "/src/main/java")
                // 覆盖已生成文件
                .fileOverride()
                // 作者
                .author(author)
                // 启用swagger
//                .enableSwagger()
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd")
                .build();
        // 包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent(parentPackage)
                // 设置父包模块名
                .moduleName(module)
                // 设置实体包
                .entity("dataobject")
                // 服务类
                .service("service")
                // 服务类实现
                .serviceImpl("service.impl")
                .mapper("mapper")
                .xml("mapper.xml")
                .controller("controller")
                .other("other")
                // 路径信息
                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + "/src/main/resources/mapper/"))
                .build();
//        // 模板配置 不配无法生成
//        TemplateConfig tc = new TemplateConfig.Builder()
//                .disable(TemplateType.ENTITY)
//                .entity("/templates/entity.java")
//                .service("/templates/service.java")
//                .serviceImpl("/templates/serviceImpl.java")
//                .mapper("/templates/mapper.java")
//                .mapperXml("/templates/mapper.xml")
//                .controller("/templates/controller.java")
//                .build();
        // 注入配置
//        InjectionConfig injectionConfig = new InjectionConfig.Builder()
//                .beforeOutputFile((tableInfo, objectMap) -> {
//                    System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
//                })
//                // 没有自定义配置map对象
//                // 没有模板文件
//                .build();
        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                // 策略 开启大写命名
                .enableCapitalMode()
                .enableSkipView()
                // 禁用SQL过滤
                .disableSqlFilter()
                // 表名
                .addInclude(tables)
                // 排除的表
//                .addExclude(excludeTables)
                // 要移除的表前缀
                .addTablePrefix(prefix)
                // 配置实体策略
                .entityBuilder()
                // 父类
//                .superClass(Model.class)
                // 禁用序列化
//                .disableSerialVersionUID()
                // 启用链式编程
                .enableChainModel()
                //启用Lombok
                .enableLombok()
                // 启用表字段注解
                .enableTableFieldAnnotation()
//                // 乐观锁
//                .versionColumnName("version")
//                .versionPropertyName("version")
//                // 逻辑删除
//                .logicDeleteColumnName("deleted")
//                .logicDeletePropertyName("deleted")
                // 表名驼峰
                .naming(NamingStrategy.underline_to_camel)
                // 列名驼峰命名
                .columnNaming(NamingStrategy.underline_to_camel)
                // 主键策略
                .idType(IdType.AUTO)
                .formatFileName("%sDO")
                // 格式化文件名称
//                .formatFileName("%sModel")
                // 配置controller 策略
                .controllerBuilder()
                // 设置父类，没有，不配
                // .superClass(BaseController.class)
                // RestController
                .enableRestStyle()
                .formatFileName("%sController")
                // 配置service 策略
                .serviceBuilder()
                // BaseRepository impl
//                .superServiceClass(BaseRepository.class)
//                .superServiceImplClass(BaseRepositoryImpl.class)
                .formatServiceFileName("%sService")
                .formatServiceImplFileName("%sServiceImpl")
                // 配置mapper策略
                .mapperBuilder()
                // 父类
//                .superClass(SuperMapper.class)
                // 启用mapper注解
                .enableMapperAnnotation()
                // 启用 BaseResultMap
                .enableBaseResultMap()
                .enableBaseColumnList()
                .formatMapperFileName("%sMapper")
                .formatXmlFileName("%sMapper")
                .build();
        // 执行生成
        new AutoGenerator(dsb)
                // 全局配置
                .global(globalConfig)
                .packageInfo(packageConfig)
//                .injection(injectionConfig)
                .strategy(strategyConfig)
//                .template(tc)
                .execute();
        // 默认VelocityTemplateEngine引擎，改为freemark引擎
//                .execute(new FreemarkerTemplateEngine());

    }


}


class TestGenerate {

    public static void main(String[] args) {
        MyBatisGenerate.builder()
                // 数据库名称
                .dbName("cop_data_transform")
                // 模块
                .module("")
                // 没有需要移除的前缀
                .prefix(new String[]{""})
                // 当前项目的包名
                .parentPackage("com.vevor.cop.dataextract")
                .dbHostAndPort("127.0.0.1:3306")
                .dbUserName("root")
                .dbPsw("12345678")
                .tables(new String[]{"msg_fail_log"})
                .author("zhaijianfeng")
                .build()
                .generate();


    }
}


