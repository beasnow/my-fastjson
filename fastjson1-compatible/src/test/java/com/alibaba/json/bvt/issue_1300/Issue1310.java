package com.alibaba.json.bvt.issue_1300;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by wenshao on 29/07/2017.
 */
public class Issue1310 {
    @Test
    public void test_trim() throws Exception {
        Model model = new Model();
        model.value = " a ";

        assertEquals("{\"value\":\"a\"}", JSON.toJSONString(model));

        Model model2 = JSON.parseObject("{\"value\":\" a \"}", Model.class);
        assertEquals("a", model2.value);
    }

    public static class Model {
        @JSONField(format = "trim")
        public String value;
    }
}
