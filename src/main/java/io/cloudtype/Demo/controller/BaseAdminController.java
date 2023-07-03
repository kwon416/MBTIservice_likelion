package io.cloudtype.Demo.controller;


import io.cloudtype.Demo.dto.BaseApiDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class BaseAdminController<T extends BaseApiDto<?>> {

    protected ResponseEntity<T> ok(T t) {
        return this.ok(t, "0000", "SUCCESS");
    }

    protected ResponseEntity<T> ok(T t, String code, String message) {
        t.setCode(code);
        t.setMessage(message);
        return ResponseEntity.ok().body(t);
    }

//    protected ResponseEntity<T> fail(T t) {
//        if (StringUtils.isBlank(t.getCode())) {
//            t.setCode("9999");
//        }
//        if (StringUtils.isBlank(t.getMessage())) {
//            t.setMessage("FAIL");
//        }
//        //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(t);
//        return ResponseEntity.ok().body(t);
//    }

    protected ResponseEntity<T> fail(T t, String code, String message) {
        t.setCode(code);
        t.setMessage(message);
        return ResponseEntity.ok().body(t);
    }
}
