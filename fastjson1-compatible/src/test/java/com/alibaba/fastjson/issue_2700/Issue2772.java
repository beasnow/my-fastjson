package com.alibaba.fastjson.issue_2700;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Issue2772 {
    @Test
    public void test_for_issue() throws Exception {
        {
            java.sql.Time time = java.sql.Time.valueOf("12:13:14");
            long millis = time.getTime();
            assertEquals(Long.toString(millis / 1000), JSON.toJSONStringWithDateFormat(time, "unixtime"));
            assertEquals(Long.toString(millis), JSON.toJSONStringWithDateFormat(time, "millis"));
        }

        long millis = System.currentTimeMillis();
        assertEquals(Long.toString(millis), JSON.toJSONStringWithDateFormat(new Date(millis), "millis"));
        assertEquals(Long.toString(millis / 1000), JSON.toJSONStringWithDateFormat(new Date(millis), "unixtime"));
    }
}
