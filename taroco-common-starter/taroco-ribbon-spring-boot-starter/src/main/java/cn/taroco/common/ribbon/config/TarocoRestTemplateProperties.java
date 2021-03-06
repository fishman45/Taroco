package cn.taroco.common.ribbon.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * RestTemplate 配置
 *
 * @author liuht
 * @date 2017/11/17 11:36
 */
@ConfigurationProperties(prefix = "taroco.resttemplate")
public class TarocoRestTemplateProperties {
    /**
     * max connection default: 200
     */
    private int maxTotal = 200;
    /**
     * default: 20
     */
    private int maxPerRoute = 20;
    /**
     * default: 35000(ms)
     */
    private int readTimeout = 35000;
    /**
     * default: 10000(ms)
     */
    private int connectTimeout = 10000;

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxPerRoute() {
        return maxPerRoute;
    }

    public void setMaxPerRoute(int maxPerRoute) {
        this.maxPerRoute = maxPerRoute;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }
}
