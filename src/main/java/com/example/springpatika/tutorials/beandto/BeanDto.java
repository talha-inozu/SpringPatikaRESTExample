package com.example.springpatika.tutorials.beandto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class BeanDto {

    private String beanName;
    private String beadData;
    private Long beandId;

    public void initialBeanMethod(){
        log.info("Bean is starting");
    }
    public void destroyBeanMethod(){
        log.info("Bean is closing");
    }


}
