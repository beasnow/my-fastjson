package com.alibaba.fastjson2.v1issues;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigDecimalFieldTest {

    @Test
    public void test_codec_null() throws Exception {
        V0 v = new V0();

        String text = JSON.toJSONString(v, JSONWriter.Feature.WriteMapNullValue);
        assertEquals("{\"value\":null}", text);

        V0 v1 = JSON.parseObject(text, V0.class);

        assertEquals(v1.getValue(), v.getValue());
    }

    public void test_codec_null_1() throws Exception {
        V0 v = new V0();

        String text = JSON.toJSONString(v, JSONWriter.Feature.WriteMapNullValue, JSONWriter.Feature.NullAsDefaultValue);
        assertEquals("{\"value\":0}", text);
    }

    public static class V0 {

        private BigDecimal value;

        public BigDecimal getValue() {
            return value;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }

    }
}
