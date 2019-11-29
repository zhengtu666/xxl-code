package com.xxl.codegenerator.admin.util;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.util.Locale;
import java.util.Map;

/**
 * freemarker tool
 *
 * @author xuxueli 2018-05-02 19:56:00
 */
public class FreemarkerUtil {
    private static final Logger logger = LoggerFactory.getLogger(CodeGeneratorTool.class);

    /**
     * freemarker config
     */
    private static Configuration freemarkerConfig = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
    static{
        InputStream stream = FreemarkerUtil.class.getClass().getResourceAsStream("");
        StringBuffer sb = new StringBuffer() ;
        BufferedReader br = null ;
        try {
            br = new BufferedReader(new InputStreamReader(stream,"UTF-8")) ;
            String s=null ;
            while((s=br.readLine()) !=null){
                sb.append(s) ;
            }
            br.close();
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException:"+e);
        } catch (IOException e) {
            logger.error("IOException:"+e);
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error("close br error:" + e);
                }
            }
        }
        String templatePath = sb.toString();
        int wei = templatePath.lastIndexOf("WEB-INF/classes/");
        if (wei > -1) {
            templatePath = templatePath.substring(0, wei);
        }

        try {
            File file = new File(templatePath, "xxl-code-generator");
            logger.info(file.getPath());
            freemarkerConfig.setDirectoryForTemplateLoading(new File(templatePath, "xxl-code-generator"));
            freemarkerConfig.setNumberFormat("#");
            freemarkerConfig.setClassicCompatible(true);
            freemarkerConfig.setDefaultEncoding("UTF-8");
            freemarkerConfig.setLocale(Locale.CHINA);
            freemarkerConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * process Template Into String
     *
     * @param template
     * @param model
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public static String processTemplateIntoString(Template template, Object model)
            throws IOException, TemplateException {

        StringWriter result = new StringWriter();
        template.process(model, result);
        return result.toString();
    }

    /**
     * process String
     *
     * @param templateName
     * @param params
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public static String processString(String templateName, Map<String, Object> params)
            throws IOException, TemplateException {

        Template template = freemarkerConfig.getTemplate(templateName);
        String htmlText = processTemplateIntoString(template, params);
        return htmlText;
    }


}
