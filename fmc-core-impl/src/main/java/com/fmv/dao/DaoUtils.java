package com.fmv.dao;

import com.fmv.entities.FmvEntity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DaoUtils {

    public static <E extends FmvEntity> void setExternalId(E entity) {
        LocalDateTime dateTime = LocalDateTime.now();
        Integer randomNumber = new Random().nextInt(100000);
        entity.setExternalId(entity.getPrefix()
                + dateTime.format(DateTimeFormatter.ofPattern("yyMMddHHmmssSS"))
                + String.format("%06d", randomNumber)
        );
    }

    public static Date getCurrentDate() {
        return Date.valueOf(LocalDate.now());
    }

}
