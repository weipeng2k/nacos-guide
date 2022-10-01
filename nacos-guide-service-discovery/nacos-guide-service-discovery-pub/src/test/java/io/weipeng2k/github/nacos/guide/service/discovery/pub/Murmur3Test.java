package io.weipeng2k.github.nacos.guide.service.discovery.pub;

import com.google.common.hash.Hashing;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @author weipeng2k 2022年09月28日 上午09:25:13
 */
public class Murmur3Test {

    @Test
    public void hash() {
        System.out.println(Hashing.murmur3_128().hashString("123", StandardCharsets.UTF_8).asLong());
    }

}
