package io.weipeng2k.github.nacos.guide.service.discovery.pub;

import java.util.Objects;

/**
 * <pre>
 * 工作节点，代表了一个可以工作的实例
 * </pre>
 *
 * @author weipeng2k 2022年09月25日 下午20:58:04
 */
public class WorkNode implements Comparable<WorkNode> {

    private String ip;

    private int port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WorkNode workNode = (WorkNode) o;
        return port == workNode.port && Objects.equals(ip, workNode.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }

    @Override
    public int compareTo(WorkNode o) {
        return 0;
    }
}
