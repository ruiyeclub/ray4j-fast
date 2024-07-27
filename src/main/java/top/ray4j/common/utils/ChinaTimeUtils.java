package top.ray4j.common.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author Cr.
 * @date 2024/5/29
 */
public class ChinaTimeUtils {

    public static Long get() {
        // 获取中国的时区
        ZoneId chinaZoneId = ZoneId.of("Asia/Shanghai");
        // 获取当前时间戳并转换为中国时区
        Instant now = Instant.now();
        ZonedDateTime chinaTime = now.atZone(chinaZoneId);
        // 获取中国当前的时间戳(以秒为单位)
        return chinaTime.toEpochSecond();
    }
}
