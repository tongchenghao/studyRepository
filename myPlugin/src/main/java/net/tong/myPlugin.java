package net.tong;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:我的第一个maven插件
 * @auth tongchenghao
 * @date 2019/12/14
 */
@Mojo(name = "tongedu", defaultPhase = LifecyclePhase.PACKAGE)
public class myPlugin extends AbstractMojo {

    @Parameter
    private String msg;

    @Parameter
    private List<String> options;

    @Parameter
    private Map<String, String> mapOptions;

    @Parameter
    private Set<String> setOptions;

    @Parameter
    private String targUrl;

    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("---------字符串参数-----------");
        System.out.println(msg);

        System.out.println("---------list参数-----------");
        for (String option :
                options) {
            System.out.println(option);
        }

        System.out.println("---------map参数-----------");
        Set<String> mapOptionsKey = mapOptions.keySet();
        for (String key :
                mapOptionsKey) {
            System.out.println(key + ":" +mapOptions.get(key));
        }

        System.out.println("---------set参数-----------");
        for (String setValue :
                setOptions) {
            System.out.println(setValue);
        }
    }
}
